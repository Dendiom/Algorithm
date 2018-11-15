package LeetCode.book;

/**
 * 将一个字符串中的空格替换成 "%20"。
 */
public class ReplaceSpace {

    /**
     * 先扫描一遍字符串，遇到一个空格就在字符串后面补两个位，
     * 然后使用两个指针倒着遍历一遍，前一个指针遇到空格，就在后一个指针处插入%20（倒序），不是空格就插入相同的值
     */
    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }

        int end = str.length() - 1;
        for (int i = 0; i < end + 1; i++) {
            if (' ' == str.charAt(i)) {
                str.append("**");
            }
        }

        int newEnd = str.length() - 1;
        while (end >= 0 && newEnd > end) {
            if (' ' == str.charAt(end)) {
                str.setCharAt(newEnd--, '0');
                str.setCharAt(newEnd--, '2');
                str.setCharAt(newEnd--, '%');
            } else {
                str.setCharAt(newEnd--, str.charAt(end));
            }

            end--;
        }

        return str.toString();
    }

}

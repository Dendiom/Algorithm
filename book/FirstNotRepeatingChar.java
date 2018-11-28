package LeetCode.book;

/**
 * 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。
 */
public class FirstNotRepeatingChar {

    /**
     * char 可以用一个int[256]来存储即可。
     */
    public int firstNotRepeatingChar(String str) {
        if (str == null || str.length() ==0) {
            return -1;
        }

        int[] count = new int[256];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                return i;
            }
        }

        return -1;
    }

}

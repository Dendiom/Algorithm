package LeetCode.book;

/**
 * 左旋转字符串.
 * Input:
 * S="abcXYZdef"
 * K=3
 *
 * Output:
 * "XYZdefabc"
 */
public class LeftRotateString {

    public String leftRotateString(String str, int n) {
        if (str == null || n >= str.length()) {
            return str;
        }

        char[] strs = str.toCharArray();
        reverse(strs, 0, n - 1);
        reverse(strs, n, str.length() - 1);
        reverse(strs, 0, str.length() - 1);
        return new String(strs);
    }

    // 翻转字符串
    private void reverse(char[] str, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
}

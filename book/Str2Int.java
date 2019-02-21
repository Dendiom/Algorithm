package LeetCode.book;

/**
 * 把字符串转换成整数
 */
public class Str2Int {

    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int result = 0;
        char first = str.charAt(0);
        boolean negative = first == '-';

        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (i == 0 ) {   // 首位字符可以为符号，0也是合理的
                if (cur == '+' || cur == '-') {
                    continue;
                }
            }

            if (cur < '0' || cur > '9') {
                return 0;
            }

            result = result * 10 + (cur - '0');
        }

        return negative ? -result : result;
    }

}

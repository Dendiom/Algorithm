package LeetCode.book;

/**
 * 计算两个大正数的加法
 */
public class BigNumberAdd {

    public String bigNumberAdd(String number1, String number2) {
        char[] charA = new StringBuilder(number1).reverse().toString().toCharArray();
        char[] charB = new StringBuilder(number2).reverse().toString().toCharArray();

        int length = Math.max(charA.length, charB.length) + 1;
        if (length < 2) {
            return "0";
        }

        char[] ans = new char[length];
        int carry = 0;
        for (int i = 0; i < length; i++) {
            int a = i > charA.length - 1 ? 0 : charA[i] - '0';
            int b = i > charB.length - 1 ? 0 : charB[i] - '0';

            int sum = a + b + carry;
            if (sum >= 10) {
                ans[i] = (char)(sum - 10 + '0');
                carry = 1;
            } else {
                ans[i] = (char)(sum + '0');
                carry = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            sb.append(ans[i]);
        }

        return sb.charAt(0) == '0' ? sb.substring(1) : sb.toString();
    }
}

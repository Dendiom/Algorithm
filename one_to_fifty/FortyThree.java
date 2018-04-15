package LeetCode.one_to_fifty;

public class FortyThree {

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "";
        }

        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int[] temp = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int factor = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = factor + temp[i + j + 1];
                temp[i + j + 1] = sum % 10;
                temp[i + j] += sum / 10;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < len1 + len2; i ++) {
            if (ans.length() == 0 && temp[i] == 0) {
                continue;
            }

            ans.append(temp[i]);
        }

        return ans.toString();
    }

}

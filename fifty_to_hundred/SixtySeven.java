package LeetCode.fifty_to_hundred;

public class SixtySeven {
    private static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();

        int remainA = a.length() - 1;
        int remainB = b.length() - 1;
        int add = 0;

        while (remainA >= 0 && remainB >= 0) {
            int binA = a.charAt(remainA) - '0';
            int binB = b.charAt(remainB) - '0';

            ans.append((binA + binB + add) % 2);
            add = (binA + binB + add) / 2;
            remainA--;
            remainB--;
        }

        int remain = remainA >= 0 ? remainA : remainB;
        String str = remainA >= 0 ? a : b;

        while (remain >= 0) {
            int bin = str.charAt(remain) - '0';
            ans.append((bin + add) % 2);
            add = (bin + add) / 2;
            remain--;
        }

        if (add == 1) {
            ans.append(1);
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("101111", "10"));
    }
}

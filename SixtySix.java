package TestOne;


import java.util.Arrays;

public class SixtySix {

    public static int[] plusOne(int[] digits) {
        int lastIndex = digits.length - 1;

        if (digits[lastIndex] < 9) {
            digits[lastIndex] = ++digits[lastIndex];
            return digits;
        }
        digits[lastIndex] = 0;

        for (int i = lastIndex - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }
        int[] ans = new int[lastIndex+2];
        ans[0] = 1;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 4, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 4})));
        System.out.println(Arrays.toString(plusOne(new int[]{4})));
        System.out.println(Arrays.toString(plusOne(new int[]{1,3,9,9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9,9})));
    }
}

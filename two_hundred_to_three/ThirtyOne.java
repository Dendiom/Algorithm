package LeetCode.two_hundred_to_three;

public class ThirtyOne {

    public static boolean isPowerOfTwo(int n) {
        // 1000000000000000
        if (n < 1) {
            return false;
        }

        String binary = Integer.toBinaryString(n);
        System.out.println(binary);
        int number = 0;
        for (int i = 0; i < binary.length(); i++) {
            if ('1' == binary.charAt(i)) {
                number++;
            }
        }

        return number == 1;
    }

    // recursive
    public static boolean isPowerOfTwoFaster(int n) {
        if (n == 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        if (n % 2 != 0) {
            return false;
        }

        return isPowerOfTwoFaster(n / 2);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwoFaster(1));
        System.out.println(isPowerOfTwoFaster(3));
        System.out.println(isPowerOfTwoFaster(4));
        System.out.println(isPowerOfTwoFaster(256));
        System.out.println(isPowerOfTwoFaster(254));
    }
}

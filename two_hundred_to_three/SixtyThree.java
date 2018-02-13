package LeetCode.two_hundred_to_three;

public class SixtyThree {

    private static boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else if (num % 3 == 0) {
                num = num / 3;
            } else if (num % 5 == 0) {
                num = num / 5;
            } else {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(isUgly(6));
        System.out.println(isUgly(18));
        System.out.println(isUgly(345));
    }
}

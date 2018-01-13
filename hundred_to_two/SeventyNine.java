package TestOne.hundred_to_two;


public class SeventyNine {

    /**
     * My solution.
     *
     * @param nums non negative integers.
     * @return String.
     */
    private static String largestNumber(int[] nums) {
        StringBuilder ans = new StringBuilder("");
        for (int i = 0; i < nums.length - 1; i++) {  // Bubble sort, a slow method, just for practising
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (compare(nums[j], nums[j + 1])) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            ans.append(nums[nums.length - i - 1]);
        }
        ans.append(nums[0]);
        if (ans.charAt(0) == '0') { // all the numbers are 0
            return "0";
        }
        return ans.toString();
    }

    /**
     * If a should be ahead of b, return true.
     *
     * @param a integer one.
     * @param b integer two.
     * @return boolean.
     */
    private static boolean compare(int a, int b) {
        int lengthA = getLength(a);
        int lengthB = getLength(b);
        int copy = a < b ? a : b;
        while (lengthA != 0 && lengthB != 0) { // compare the first number of integer
            int tempA = (int) Math.pow(10, lengthA - 1);
            int tempB = (int) Math.pow(10, lengthB - 1);
            if (a / tempA > b / tempB) {
                return true;
            }

            if (a / tempA < b / tempB) {
                return false;
            }

            a = a % tempA;
            b = b % tempB;
            lengthA--;
            lengthB--;
        }


        if (lengthA == lengthB) {
            return true;
        }

        if (lengthA == 0) {  // a is shorter than b and a is prefix of b
            return compare(copy, b);
        }

        return compare(a, copy);
    }

    /**
     * Get length of an integer.
     *
     * @param a integer.
     * @return length.
     */
    private static int getLength(int a) {
        int length = 0;
        while (a != 0) {
            a = a / 10;
            length++;
        }
        return length > 0 ? length : 1;
    }

    /*************************** use comparator ************************/


    public static void main(String[] args) {
//        System.out.println(largestNumber(new int[]{1, 2}));
//        System.out.println(compare(3,5));
//        System.out.println(compare(13,5));
//        System.out.println(compare(13,135));
//        System.out.println(compare(4,4));
//        System.out.println(compare(432,4321))
        System.out.println(largestNumber(new int[]{0, 0}));
        System.out.println(largestNumber(new int[]{123, 12}));
        System.out.println(largestNumber(new int[]{12, 123}));
        System.out.println(largestNumber(new int[]{57, 2, 42}));
        System.out.println(largestNumber(new int[]{321, 32, 42}));
        System.out.println(largestNumber(new int[]{12, 121}));   // error!
        System.out.println(largestNumber(new int[]{121, 12}));   // error!
        System.out.println(largestNumber(new int[]{2281, 2}));   // error!
        System.out.println(largestNumber(new int[]{2, 2281}));   // error!
        System.out.println(largestNumber(new int[]{2215, 2}));   // error!
        System.out.println(largestNumber(new int[]{2, 2215}));   // error!
    }
}

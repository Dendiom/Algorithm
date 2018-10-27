package LeetCode.three_hundred_to_four;

public class FortyFour {

    public static String reverseString(String s) {
        if (s == null) {
            return null;
        }

        int length = s.length();
        char[] ans = new char[length];
        for (int i = length - 1; i>=0; i--) {
            ans[length - 1 - i] = s.charAt(i);
        }

        return String.valueOf(ans);
    }

    // StringBuilder has reverse api
    public static String reverseStringBrief(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("fdf fdf "));
        System.out.println(reverseStringBrief(null));
    }
}

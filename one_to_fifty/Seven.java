package TestOne.one_to_fifty;


public class Seven {

    public static int reverse(int x) {
        if (x >= 0) {
            StringBuilder trans = new StringBuilder(String.valueOf(x));
            for (int i = 0, j = trans.length() - 1; i < j; i++, j--) {
                char temp = trans.charAt(i);
                trans.setCharAt(i, trans.charAt(j));
                trans.setCharAt(j, temp);
            }
            double ans = Double.valueOf(trans.toString());
            if (ans > Integer.MAX_VALUE) {
                return 0;
            }
            return (int) ans;

        } else {
            StringBuilder trans = new StringBuilder(String.valueOf(x).substring(1));
            for (int i = 0, j = trans.length() - 1; i < j; i++, j--) {
                char temp = trans.charAt(i);
                trans.setCharAt(i, trans.charAt(j));
                trans.setCharAt(j, temp);
            }
            double ans = Double.valueOf("-" + trans.toString());
            if (ans < Integer.MIN_VALUE) {
                return 0;
            }
            return (int) ans;
        }
    }

    public static int reverseTwo(int x) {
        long sum = 0;
        while (x != 0) {
            int temp = x % 10;
            sum = sum * 10 + temp;
            x = x / 10;

        }
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        System.out.println(reverseTwo(422));
        System.out.println(reverseTwo(1423425225));
        System.out.println(reverseTwo(-467822));
    }
}

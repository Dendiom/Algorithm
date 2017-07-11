package TestOne;

/**
 * 先获取倒置的数字，比原来少一位避免溢出，再进行比较
 */
public class Nine {


    //from leetcode  ,so good
    public static boolean isPalindrome(int x) {

        if (x < 0) return false;

        int p = x;
        int q = 0;

        while (p >= 10) {
            q *= 10;
            q += p % 10;
            p /= 10;
        }

        return q == x / 10 && p == x % 10;
    }


    public static void main(String[] args) {
        System.out.println("ans" + isPalindrome(1000021));
        System.out.println("ans" + isPalindrome(1232321));
        System.out.println("ans" + isPalindrome(123321));
        System.out.println("ans" + isPalindrome(-1345));

    }


}

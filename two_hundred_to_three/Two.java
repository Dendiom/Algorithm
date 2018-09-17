package LeetCode.two_hundred_to_three;

import java.util.HashSet;
import java.util.Set;

public class Two {

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            int count = 0;
            while (n > 0) {
                count += (n % 10) * (n % 10);
                n = n / 10;
            }

            if (set.contains(count)) {
                return false;
            }

            set.add(count);
            n = count;
        }

        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i ++) {
            System.out.println(i + " " + isHappy(i));
        }
    }
}

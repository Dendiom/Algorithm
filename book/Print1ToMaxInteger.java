package LeetCode.book;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 */
public class Print1ToMaxInteger {

    /**
     * 递归
     */
    public static void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }

        char[] number = new char[n];
        recursive(number, 0);
    }

    private static void recursive(char[] number, int index) {
        if (index == number.length) {
            print(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index] = (char)('0' + i);
            recursive(number, index + 1);
        }
    }

    private static void print(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0') {
            index++;
        }
        while (index < number.length) {
            System.out.print(number[index++]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print1ToMaxOfNDigits(3);
    }
}

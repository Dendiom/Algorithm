package LeetCode.book;

/**
 * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方。
 */
public class Power {

    /**
     * 递归求解，需要注意可能为负数次方
     */
    public double power(double base, int exponent) {
        if (base == 0 || base == 1) {
            return base;
        }

        if (exponent == 0) {
            return 1;
        }

        if (exponent == 1) {
            return base;
        }

        boolean negative = false;
        if (exponent < 0) {
            exponent = -exponent;
            negative = true;
        }

        double pow = power(base * base, exponent / 2);
        if (exponent % 2 != 0) {
            pow = base * pow;
        }

        return negative ? 1 / pow : pow;
    }
}

package LeetCode.three_hundred_to_four;

public class ThirtyEight {

    /**
     * Dp
     *
     * specific index = [1, 2, 4, 8, 16, 32, ...]
     * ans[index[i]] = 1, let offset = index[i + 1] - index[i]
     * ans[index[i] + offset] = 1 + ans[offset]
     * do not forget that total length maybe < index[i + 1]
     */
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;

        for (int i = 0; Math.pow(2, i) < num + 1; i++) {
            int index = (int)Math.pow(2, i);
            ans[index] = 1;
            int bound = Math.min(num + 1, (int)Math.pow(2, i + 1));
            for (int j = index + 1; j < bound; j++) {
                ans[j] = 1 + ans[j - index];
            }
        }

        return ans;
    }
}

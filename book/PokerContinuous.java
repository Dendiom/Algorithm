package LeetCode.book;

import java.util.Arrays;

/**
 * 五张牌，其中大小鬼为癞子，牌面大小为 0。A看作1,J为11,Q为12,K为13
 * 判断这五张牌是否能组成顺子。(与实际不同，实际2无法组成顺子而且A不是1)
 */
public class PokerContinuous {

    public boolean isContinuous(int[] nums) {
        if (nums == null || nums.length != 5) {
            return false;
        }

        Arrays.sort(nums);
        int count = 0;
        for (int num: nums) {    // 先统计王的个数
            if (num == 0) {
                count++;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff == 0) {
                return false;
            } else if (diff == 1) {
                continue;
            } else {
                count = count - (diff - 1);
            }
        }

        return count >= 0;
    }
}

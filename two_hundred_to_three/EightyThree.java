package LeetCode.two_hundred_to_three;

public class EightyThree {

    // like bubble sort, o(n^2)
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int index = i;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        int temp = nums[index];
                        nums[index] = nums[j];
                        nums[j] = temp;
                        index = j;
                    }
                }
            }
        }
    }

    // use two pointer
    public void moveZeroesTwo(int[] nums) {
        int zero = 0, nozero = 0;
        while(zero < nums.length && nozero < nums.length) {
            while(zero < nums.length && nums[zero] != 0) {
                zero++;
            }

            if (zero == nums.length) {
                return;
            }

            nozero = zero + 1;
            while(nozero < nums.length && nums[nozero] == 0) {
                nozero++;
            }

            if (nozero == nums.length) {
                return;
            }

            int temp = nums[zero];
            nums[zero] = nums[nozero];
            nums[nozero] = temp;
            zero++;
            nozero++;
        }
    }
}

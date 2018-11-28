package LeetCode.book;

/**
 * 求数字在排序数组中出现的次数
 */
public class GetNumberOfK {

    /**
     * 二分法，先找到k，然后朝两边拓展
     */
    public int getNumberOfK(int[] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 0;
        int start = 0, end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (array[mid] == k) {
                count++;
                int index1 = mid - 1, index2 = mid + 1;
                while (index1 >= start && array[index1] == k) {
                    count++;
                    index1--;
                }

                while (index2 <= end && array[index2] == k) {
                    count++;
                    index2++;
                }
                return count;
            }

            if (array[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return 0;
    }
}

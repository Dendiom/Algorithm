package LeetCode.book;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class SearchIn2DMatrix {

    /**
     * 从右上角或者左下角开始扫描，可以有效的缩小查找范围
     * 以下代码是从右上角开始扫描的
     */
    public static boolean exist(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int currentRow = 0;
        int currentCol = col - 1;

        while(currentCol >=0 && currentRow <= row - 1) {
            int val = matrix[currentRow][currentCol];
            if (val == target) {
                return true;
            }

            if (val > target) {
                currentCol--;
            } else {
                currentRow++;
            }
        }

        return false;
    }
}

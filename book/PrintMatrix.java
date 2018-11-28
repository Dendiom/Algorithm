package LeetCode.book;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {

    /**
     * 一圈一圈的考虑
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int rowStart = 0, rowEnd = matrix.length - 1;
        int colStart = 0, colEnd = matrix[0].length - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {  // 横
                result.add(matrix[rowStart][i]);
            }

            for (int i = rowStart + 1; i <= rowEnd; i++){   // 竖
                result.add(matrix[i][colEnd]);
            }

            if (rowEnd > rowStart) { // 反横
                for (int i = colEnd - 1; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }

            if (colStart < colEnd) {  // 反竖
                for (int i  = rowEnd - 1; i > rowStart; i--) {
                    result.add(matrix[i][rowStart]);
                }
            }

            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }

        return result;
    }
}

package LeetCode.two_hundred_to_three;

public class Forty {


    // recursive, so slow
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        return search(matrix, target, 0, m - 1, 0, n - 1);
    }

    public boolean search(int[][] matrix, int target, int rowStart, int rowEnd, int colStart, int colEnd) {
        if (rowStart == rowEnd && colStart == colEnd) {  // the last one element
            return target == matrix[rowStart][colStart];
        }

        if (rowStart > rowEnd || colStart > colEnd) {
            return false;
        }

        int newColEnd = colEnd;
        for (int i = colStart; i <= colEnd; i++) {
            if (matrix[rowStart][i] == target) {
                return true;
            }

            if (matrix[rowStart][i] > target) {
                newColEnd = i - 1;
                break;
            }
        }

        int newRowEnd = rowEnd;
        for (int i = rowStart; i <= rowEnd; i++) {
            if (matrix[i][colStart] == target) {
                return true;
            }

            if (matrix[i][colStart] > target) {
                newRowEnd = i - 1;
                break;
            }
        }

        return search(matrix, target, rowStart + 1, newRowEnd, colStart + 1, newColEnd);
    }


    // a faster way
    public boolean searchMatrixFast(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int i = row - 1;
        int j = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] == target) {
                return true;
            }

            if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        
        return false;
    }
}

package TestOne.fifty_to_hundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeventyThree {

	public static void setZeroesExtra(int[][] matrix) { // extra space o(1)
		int firstCol = 1, row = matrix.length, col = matrix[0].length;
		for (int i = 0; i < row; i++) {
			if (matrix[i][0] == 0) {
				firstCol = 0;
			}
			for (int j = 1; j < col; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = row - 1; i >= 0; i--) {
			for (int j = col - 1; j >= 1; j--) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
			if (firstCol == 0) {
				matrix[i][0] = 0;
			}
		}

	}

	public static void setZeroes(int[][] matrix) { // extra space o(m+n)
		int m = matrix.length;
		if (m == 0)
			return;
		int n = matrix[0].length;
		if (n == 0)
			return;

		boolean[] row = new boolean[m];
		boolean[] col = new boolean[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			if (row[i]) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
			for (int j = 0; j < n; j++) {
				if (col[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] test = new int[1][1];
		test[0] = new int[] { 0 };
		setZeroes(test);
	}

}

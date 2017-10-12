package TestOne.fifty_to_hundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SeventyThree {

	public static void setZeroes(int[][] matrix) {   // extra space o(m+n)
		int m = matrix.length;
		if (m == 0)
			return;
		int n = matrix[0].length;
		if (n == 0)
			return;

		boolean[] raw = new boolean[m];
		boolean[] col = new boolean[n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					raw[i] = true;
					col[j] = true;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			if (raw[i]) {
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
		test[0] = new int[]{0};
		setZeroes(test);
	}

}

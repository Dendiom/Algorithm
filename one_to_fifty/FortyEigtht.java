package TestOne.one_to_fifty;

import java.util.Arrays;

public class FortyEigtht {

	// o(n^2) extra space, not good
	public static void rotate(int[][] matrix) {
		if (matrix == null || matrix.length < 2)
			return;
		int size = matrix.length;
		int[][] temp = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				temp[i][j] = matrix[i][j];
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[j][size - 1 - i] = temp[i][j];
			}
		}
	}

	// only o(1) extra space
	public static void rotateTwo(int[][] matrix) {
		if (matrix == null || matrix.length < 2)
			return;
		int size = matrix.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][size - 1 - j];
				matrix[i][size - 1 - j] = temp;
			}
		}

	}

	public static void main(String[] args) {

	}

}

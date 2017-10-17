package TestOne.fifty_to_hundred;

public class SeventyFour {

	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		if (m == 0)
			return false;
		for (int i = 0; i < m; i++) {
			for (int j = matrix[0].length - 1; j >=0; j--) {
				if (target > matrix[i][j])
					break;
				else if (target == matrix[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {

	}

}

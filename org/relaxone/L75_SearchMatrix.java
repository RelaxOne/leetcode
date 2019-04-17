package org.relaxone;

public class L75_SearchMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null)
			return false;
		int row = matrix.length;
		int col = matrix[0].length;
		int m = row - 1, n = 0;
		while (m >= 0 && n < col) {
			if(matrix[m][n]  == target)
				return true;
			if(matrix[m][n] > target)
				m--;
			else
				n++;
		}
		return false;
	}

}

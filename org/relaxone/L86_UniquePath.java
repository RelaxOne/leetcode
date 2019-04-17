package org.relaxone;

public class L86_UniquePath {

	public static int uniquePath(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		if (m == 0)
			return 0;
		int n = obstacleGrid[0].length;

		int[][] result = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j] == 1)
					continue;
				else {
					if (i == 0 && j == 0)
						result[i][j] = 1;
					else if (i == 0 && j != 0)
						result[i][j] = result[i][j - 1] == 0 ? 0 : 1;
					else if (i != 0 && j == 0)
						result[i][j] = result[i - 1][j] == 0 ? 0 : 1;
					else {
						result[i][j] = result[i - 1][j] + result[i][j - 1];
					}
				}
			}
		}
		return result[m - 1][n - 1];
	}

	public static void main(String[] args) {
		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		System.out.println(L86_UniquePath.uniquePath(obstacleGrid));
	}

}

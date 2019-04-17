package org.relaxone;

public class L21_SurroundRegions {

	public void solve(char[][] board) {
		if (board.length <= 0 || board == null)
			return;
		if (board[0].length <= 0)
			return;
		int row = board.length;
		int col = board[0].length;
		for (int i = 0; i != row; i++) {
			dfs(board, i, col - 1);
			dfs(board, i, 0);
		}
		for (int i = 0; i != col; i++) {
			dfs(board, 0, i);
			dfs(board, row - 1, i);
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				if (board[i][j] == '*')
					board[i][j] = 'O';
			}
		}
	}

	/**
	 * a. 深度遍历，将与边缘相连接的 O 全部设置为 *
	 * 
	 * @param board
	 * @param row
	 * @param col
	 */
	public void dfs(char[][] board, int row, int col) {
		if (row < 0 || row > (board.length - 1) || col < 0 || col > (board[0].length - 1))
			return;
		if (board[row][col] == 'O') {
			board[row][col] = '*';
			dfs(board, row - 1, col);
			dfs(board, row, col - 1);
			dfs(board, row + 1, col);
			dfs(board, row, col + 1);
		}
	}

	public void print(char[][] board) {

		int row = board.length;
		int col = board[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		L21_SurroundRegions l21_SurroundRegions = new L21_SurroundRegions();
		char[][] board = new char[4][6];
		char[] row1 = "XOXOXO".toCharArray();
		board[0] = row1;
		board[2] = row1;
		char[] row2 = "OXOXOX".toCharArray();
		board[1] = row2;
		board[3] = row2;

		l21_SurroundRegions.print(board);

		System.out.println();
		l21_SurroundRegions.solve(board);
		
		l21_SurroundRegions.print(board);

	}

}

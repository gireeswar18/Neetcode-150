package neetcode150;

public class ValidSudoku {
	public static void main(String[] args) {

		char[][] t1 = { { '1', '2', '.', '.', '3', '.', '.', '.', '.' },
						{ '4', '.', '.', '5', '.', '.', '.', '.', '.' }, 
						{ '.', '9', '8', '.', '.', '.', '.', '.', '3' },
						{ '5', '.', '.', '.', '6', '.', '.', '.', '4' }, 
						{ '.', '.', '.', '8', '.', '3', '.', '.', '5' },
						{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
						{ '.', '.', '.', '.', '.', '.', '2', '.', '.' },
						{ '.', '.', '.', '4', '1', '9', '.', '.', '8' }, 
						{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		System.out.println(isValidSudoku(t1));
	}

	public static boolean isValidSudoku(char[][] board) {
		boolean[][] rows = new boolean[9][9];
		boolean[][] cols = new boolean[9][9];
		boolean[][] boxes = new boolean[9][9];
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				
				if (board[i][j] == '.') continue;
				
				int val = board[i][j] - '0';
				int boxInd = (i / 3) * 3 + (j / 3);
				
				if (rows[i][val - 1] || cols[j][val - 1] || boxes[boxInd][val - 1]) {
					return false;
				}
				
				rows[i][val - 1] = true;
				cols[j][val - 1] = true;
				boxes[boxInd][val - 1] = true;
			}
		}
		
		return true;
	}
}

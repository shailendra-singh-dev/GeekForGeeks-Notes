package problems.arrays;


/**
 * https://www.geeksforgeeks.org/final-cell-position-in-the-matrix/
 * @author ShSingh
 *
 */
public class FinalCellInMatrixAfterMovements {

	public void test() {
		String directions1 = "DLRR";
		char[][] matrix1 = new char[][] { 
			{ '.', '#', '.' }, 
			{ '.', '.', '#' } 
		};
		
		String directions2 = "";
		char[][] matrix2 = new char[][] { 
			{ '.', '.', }, 
			{ '.', '.', },
			{ '.', '#', }
		};
		
		String directions3 = "DDURRR";
		char[][] matrix3 = new char[][] { 
			{ '.', '.', '.' }, 
			{ '.', '.' , '.'},
			{ '.', '.', '.' }
		};
		
		String directions4 = "RRDDL";
		char[][] matrix4 = new char[][] { 
			{ '.', '.', '.' }, 
			{ '.', '.' , '.'},
			{ '.', '.' , '#'},
		};
		
		int i = 0, j = 0;

		int[] finalCell = getFinalCell(directions4, matrix4, i, j);
		System.out.println("Cell:" + "[" + finalCell[0] + "]" + "[" +  finalCell[1] +"]");
	}

	public int[] getFinalCell(String directions, char[][] matrix, int i, int j) {
		if (matrix == null || matrix.length == 0) {
			return null;
		}
		int m = matrix.length, n = matrix[0].length;
		for (char ch : directions.toCharArray()) {
			switch (ch) {
			case 'D':
				if (i + i >= 0 && i + 1 <= m - 1 && matrix[i + 1][j] != '#') {
					i++;
				}
				break;
			case 'U':
				if (i - 1 >= 0 && i - 1 <= m - 1 && matrix[i - 1][j] != '#') {
					i--;
				}
				break;
			case 'L':
				if (j - 1 >= 0 && j - 1 <= n - 1 && matrix[i][j - 1] != '#') {
					j--;
				}
				break;
			case 'R':
				if (j + 1 >= 0 && j + 1 <= n - 1 && matrix[i][j + 1] != '#') {
					j++;
				}
				break;
			}
		}
		return new int[] {i,j};
	}

}

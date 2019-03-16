package problems.arrays;

public class ZeroMatrix {

	public static void test() {
		int[][] matrix = new int[][] { { 0, 1, 2, 10 }, { 2, 3, 4, 5 },
				{ 9, 3, 4, 4 }, { 5, 5, 9, 9 } };
		print(matrix);
		zeroMatrix(matrix);
		print(matrix);
	}

	private static void zeroMatrix(int[][] matrix) {
		boolean[] rows = new boolean[matrix.length];
		boolean[] columns = new boolean[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = true;
					columns[j] = true;
				}
			}
		}
		for (int i = 0; i < rows.length; i++) {
			if (rows[i]) {
				nullifyRows(matrix, i);
			}
		}
		for (int i = 0; i < columns.length; i++) {
			if (columns[i]) {
				nullifyColumns(matrix, i);
			}
		}
	}

	private static void nullifyRows(int[][] matrix, int row) {
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[row][i] = 0;
		}
	}

	private static void nullifyColumns(int[][] matrix, int column) {
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[i][column] = 0;
		}
	}

	private static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.println();
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(" " + matrix[i][j]);
			}
		}
	}

}

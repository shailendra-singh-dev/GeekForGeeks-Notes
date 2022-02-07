package problems.stack;

import java.util.Stack;

/**
 * @author ShSingh
 *
 */
public class FindAllPaths {

	/**
	 * https://www.techiedelight.com/find-all-paths-from-source-to-destination-in-matrix/
	 */
	public static void findPaths(int[][] mat, Stack<Integer> path, int i, int j) {
		// base case
		if (mat == null || mat.length == 0) {
			return;
		}

		int M = mat.length;
		int N = mat[0].length;

		// if the last cell is reached, print the route
		if (i == M - 1 && j == N - 1) {
			path.add(mat[i][j]);
			System.out.println("i == M - 1 && j == N - 1"+path);
			path.pop();
			return;
		}

		// include the current cell in the path
		System.out.println("Adding " + mat[i][j] +" to path, path:"+ path);
		path.add(mat[i][j]);

		// move right
		if ((i >= 0 && i < M && j + 1 >= 0 && j + 1 < N)) {
			System.out.println("Moving Right");
			findPaths(mat, path, i, j + 1);
		}

		// move down
		if ((i + 1 >= 0 && i + 1 < M && j >= 0 && j < N)) {
			System.out.println("Moving Down");
			findPaths(mat, path, i + 1, j);
		}

		// backtrack: remove the current cell from the path
		System.out.println("path:"+path);
		path.pop();
	}

	public static void main(String[] args) {
		int[][] mat = { 
				 { 1, 2, 3 },
				 { 4, 5, 6 },
				 { 7, 8, 9 } };

		Stack<Integer> path = new Stack<>();

		// start from `(0, 0)` cell
		int x = 0, y = 0;

		findPaths(mat, path, x, y);
	}

	

	public void test() {
		int[][] matrix = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

//		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
//		int uniquePathsWithObstacles = uniquePathsWithObstacles(matrix);
//		System.out.println(uniquePathsWithObstacles);

//		Stack<Integer> stack = new Stack<>();
//		printPathsV2(matrix, stack , 0, 0);
//		printPaths(matrix, 0, 0);
	}

	//TODO
	public void printPaths(int[][] matrix, int x, int y) {
		if (matrix.length == 0 || matrix == null) {
			return;
		}
		Stack<Integer> stack = new Stack<>();
		int M = matrix.length;
		int N = matrix[0].length;

		stack.push(matrix[0][0]);

		for (int i = x; i < M; i++) {
			for (int j = y; j < N; j++) {
				if (i == M - 1 || j == N - 1) {
					stack.push(matrix[M - 1][N - 1]);
					System.out.println(stack.toString());
					stack.pop();
				}
				if ((i + 1 >= 0 && i + 1 < M) && (j >= 0 && j < M)) {
					stack.push(matrix[i + 1][j]);
				} else if ((i >= 0 && i < M) && (j + 1 >= 0 && j + 1 < M)) {
					stack.push(matrix[i][j + 1]);
				}
			}
		}
	}

}

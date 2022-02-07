package problems.arrays;

public class RotateMatrix {

	private static final int SIZE = 4;

	private void rotate(int[][] a) {
		int level = 0, totalLevels = SIZE / 2, last = a[0].length - 1;
		while (level < totalLevels) {
			for (int i = level; i < last; i++) {
				// swap(a[level][i], a[i][last]);
				// swap(a[level][i], a[last][last - i + level]);
				// swap(a[level][i], a[last - i + level][level]);
				swap(a, level, i, i, last);
				swap(a, level, i, last, last - i + level);
				swap(a, level, i, last - i + level, level);
			}
			level++;
			last--;
		}
	}

	// https://www.geeksforgeeks.org/rotate-a-matrix-by-90-degree-in-clockwise-direction-without-using-any-extra-space/
	private void rotateV2(int[][] a) {
		int layer = SIZE / 2;
		int N = SIZE;
		for (int i = 0; i < layer; i++) {
			for (int j = i; j < N-1-i ; j++) {
				// Swap elements of each cycle 
	            // in clockwise direction 
	            int temp = a[i][j]; 
	            a[i][j] = a[N - 1 - j][i]; 
	            a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j]; 
	            a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i]; 
	            a[j][N - 1 - i] = temp; 
			}
		}
	}

	private void swap(int[][] a, int i, int j, int l, int k) {
		int temp = a[i][j];
		a[i][j] = a[l][k];
		a[l][k] = temp;
	}

	private void create(int[][] a) {
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j] = k++;
			}
		}
	}

	private void print(int[][] a) {
		System.out.println();
		System.out.print("---------------------------");
		for (int i = 0; i < a.length; i++) {
			System.out.println("");
			for (int j = 0; j < a[0].length; j++) {
				System.out.print("      " + a[i][j]);
			}
		}
	}

	public void test() {
		int[][] a = new int[SIZE][SIZE];
		RotateMatrix rotateMatrix = new RotateMatrix();
		rotateMatrix.create(a);
		rotateMatrix.print(a);
		rotateMatrix.rotateV2(a);
		rotateMatrix.print(a);

	}

}

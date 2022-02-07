package problems.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class PointInsideTringle {

	// Area of A(x1,y1),B(x2,y2),C(x3,y3) points
	private static double calculateArea(int x1, int y1, int x2, int y2, int x3,
			int y3) {
		return Math	.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y3 - y2)) / 2.0);
	}

	// Whether point P(x4,y4) is inside (x1,y1),(x2,y2),(x3,y3).
	private static boolean isInside(int x1, int y1, int x2, int y2, int x3,
			int y3, int x4, int y4) {
		final double ABC = calculateArea(x1, y1, x2, y2, x3, y4);
		final double PAB = calculateArea(x1, y1, x2, y2, x4, y4);
		final double PBC = calculateArea(x2, y2, x3, y3, x4, y4);
		final double PCA = calculateArea(x1, y1, x3, y3, x4, y4);

		return ABC == (PAB + PBC + PCA);
	}

	public static void test() {
		try {
			// BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String T = br.readLine(); // Reading input from STDIN
			int t = Integer.parseInt(T);

			for (int i = 0; i < t; i++) {
				String input = br.readLine(); // Reading input from STDIN
				String[] numbers = input.split(" ");
				int x1 = Integer.parseInt(numbers[0]);
				int y1 = Integer.parseInt(numbers[0]);
				int x2 = Integer.parseInt(numbers[0]);
				int y2 = Integer.parseInt(numbers[0]);
				int x3 = Integer.parseInt(numbers[0]);
				int y3 = Integer.parseInt(numbers[0]);

				int x4 = Integer.parseInt(numbers[0]);
				int y4 = Integer.parseInt(numbers[0]);

				if (isInside(x1, y1, x2, y2, x3, y3, x4, y4)) {
					System.out.println("INSIDE");
				} else {
					System.out.println("OUTSIDE");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

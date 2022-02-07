package math;

import java.awt.Point;
import java.util.HashMap;

public class MaxPointsInLine {

	public static int getMaxLinesInLine(final Point[] points) {
		if (null == points || points.length == 0) {
			return 0;
		}

		final HashMap<Double, Integer> result = new HashMap<Double, Integer>();
		int max = 0;

		for (int i = 0; i < points.length; i++) {
			int duplicates = 1;
			int verticals = 0;
			for (int j = i + 1; j < points.length; j++) {
				if (points[i].x == points[j].x) {
					if (points[i].y == points[j].y) {
						duplicates++;
					} else {
						verticals++;
					}
				} else {
					double slope = points[j].y == points[i].y ? 0.0
							: (1.0 * (points[j].y - points[i].y))
									/ (points[j].x - points[i].x);
					if (null != result.get(slope)) {
						result.put(slope, result.get(slope) + 1);
					} else {
						result.put(slope, 1);
					}
				}

				for (Integer count : result.values()) {
					if (count + duplicates > max) {
						max = count + duplicates;
					}
				}
				max = Math.max(verticals + duplicates, max);

				result.clear();
			}
		}

		return max;
	}

	public static void test() {
		Point[] points = new Point[18];

		// Horizontal lines..
		Point point1 = new Point(110, 10);
		Point point2 = new Point(1110, 10);
		Point point3 = new Point(140, 10);
		Point point4 = new Point(1420, 10);
		Point point5 = new Point(1550, 10);

		// Vertical Lines..
		Point point6 = new Point(10, 0);
		Point point7 = new Point(10, 1);
		Point point8 = new Point(10, 2);
		Point point9 = new Point(10, 34);
		Point point10 = new Point(10, 5);
		Point point11 = new Point(10, 10);

		// Line with 15 degree
		Point point12 = new Point(10, 10);
		Point point13 = new Point(20, 20);
		Point point14 = new Point(30, 30);
		Point point15 = new Point(40, 40);
		Point point16 = new Point(50, 50);
		Point point17 = new Point(60, 60);
		Point point18 = new Point(70, 70);

		points[0] = point1;
		points[1] = point2;
		points[2] = point3;
		points[3] = point4;
		points[4] = point5;
		points[5] = point6;
		points[6] = point7;
		points[7] = point8;
		points[8] = point9;
		points[9] = point10;
		points[10] = point11;
		points[11] = point12;
		points[12] = point13;
		points[13] = point14;
		points[14] = point15;
		points[15] = point16;
		points[16] = point17;
		points[17] = point18;

		int max = getMaxLinesInLine(points);
		System.out.print("max:" + max);

	}

}

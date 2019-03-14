package org.relaxone;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.relaxone.common.Point;

public class L3_MaxPoints {

	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0)
			return 0;
		HashMap<Integer, Integer> row_map = new HashMap<>();
		HashMap<Integer, Integer> col_map = new HashMap<>();
		for (int i = 0; i < points.length; i++) {
			Point point = points[i];
			if (row_map.containsKey(point.x)) {
				row_map.replace(point.x, row_map.get(point.x) + 1);
			} else {
				row_map.put(point.x, 1);
			}

			if (col_map.containsKey(point.y)) {
				col_map.replace(point.y, col_map.get(point.y) + 1);
			} else {
				col_map.put(point.y, 1);
			}
		}
		int result = Integer.MIN_VALUE;
		Iterator<Entry<Integer, Integer>> iterator = row_map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Integer, Integer> next = iterator.next();
			if (result < next.getValue())
				result = next.getValue();
		}
		iterator = col_map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Integer, Integer> next = iterator.next();
			if (result < next.getValue())
				result = next.getValue();
		}
		return result;
	}

	public static void main(String[] args) {

		L3_MaxPoints l3_MaxPoints = new L3_MaxPoints();
		Point p = new Point(0, 0);
		Point p1 = new Point(0, 0);
		Point[] points = {p,p1};
		System.out.println(l3_MaxPoints.maxPoints(points));

	}
}

package org.relaxone;

public class L65_LargestRectangleArea {

	public int largestRectangleArea(int[] height) {
		int result = 0;
		for (int i = 0; i < height.length; i++) {

			int count = 1;
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (height[j] < height[i])
					break;
				count++;
			}
			for (j = i + 1; j < height.length; j++) {
				if (height[j] < height[i])
					break;
				count++;
			}
			int temp = count * height[i];
			result = temp > result ? temp : result;
		}
		return result;
	}

	public static void main(String[] args) {
		L65_LargestRectangleArea area = new L65_LargestRectangleArea();
		int[] height = { 2, 1, 5, 6, 2, 3 };
		System.out.println(area.largestRectangleArea(height));
	}

}

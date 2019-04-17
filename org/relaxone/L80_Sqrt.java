package org.relaxone;

public class L80_Sqrt {

	public int sqrt(int x) {
		if (x < 2)
			return x;
		int right = x / 2;
		int left = 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (x / mid > mid)
				left = mid + 1;
			else if (x / mid < mid)
				right = mid - 1;
			else
				return mid;
		}
		return right;
	}
	
	public static void main(String[] args) {
		L80_Sqrt l80_Sqrt = new L80_Sqrt();
		System.out.println(l80_Sqrt.sqrt(81));
	}
	
}

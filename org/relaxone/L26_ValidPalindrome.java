package org.relaxone;

public class L26_ValidPalindrome {

	public boolean isPalindrome(String s) {
		if (s.trim().equals(""))
			return true;
		s = s.toLowerCase();
		char[] array = s.toCharArray();
		char[] newArr = new char[s.length()];
		int length = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] >= 'a' && array[i] <= 'z' || (array[i] >= '0' && array[i] <= '9')) {
				newArr[length] = array[i];
				length++;
			}
		}
		for (int i = 0; i < length; i++) {
			System.out.print(newArr[i]);
		}
		System.out.println();
		int m = 0, n = length - 1;
		while (m < n) {
			if (newArr[m] != newArr[n])
				return false;
			m++;
			n--;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "1a2";
		L26_ValidPalindrome l26_ValidPalindrome = new L26_ValidPalindrome();
		boolean b = l26_ValidPalindrome.isPalindrome(s);
		System.out.println(b);
	}
}

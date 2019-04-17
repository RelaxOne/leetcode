package org.relaxone;

import java.util.ArrayList;

public class L81_FullJustify {

	public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> result = new ArrayList<>();
		if(L ==0 ) {
			result.add("");
			return result;
		}
		int length = 0;
		int start = 0;
		for (int i = 0; i < words.length; i++) {
			length += words[i].length();
			if (length + i - start > L) {
				length -= words[i].length();
				String string = mergWord(words, start, i - 1, L, length);
				result.add(string);
				start = i;
				i--;
				length = 0;
			}
			if (i == words.length - 1) {
				String string = mergWord(words, start, words.length - 1, L, length);
				result.add(string);
			}
		}
		return result;
	}

	public String mergWord(String[] words, int start, int end, int L, int length) {

		StringBuilder builder = new StringBuilder();
		//处理最后一行,不加入额外的空格
		if (end == words.length - 1) {
			int len  = 0;
			for(int i = start;i <= end && len < L;i++) {
				builder.append(words[i]);
				builder.append(" ");
				len += words[i].length() + 1;
			}
			for(int i = len;i<16;i++)
				builder.append(" ");
			return builder.toString();
		}

		int blindLen = L - length; // 总的空格数
		int gap = end - start; // 间隔数
		int gap_blindLen = 0;
		int more_index = 0;
		if (gap != 0) {
			gap_blindLen = blindLen / gap; // 每个间隔的空格数
			more_index = blindLen % gap; // 多一个空格的间隔数
		} else {
			more_index = L - length;
			builder.append(words[start]);
			for (int i = 0; i < more_index; i++)
				builder.append(" ");
			return builder.toString();
		}
		for (int i = start; i < end; i++) {
			builder.append(words[i]);
			for (int j = 0; j < gap_blindLen; j++)
				builder.append(" ");
			if (i < start + more_index)
				builder.append(" ");
		}
		builder.append(words[end]);
		return builder.toString();
	}

	public static void main(String[] args) {
//		String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
		String[] words = { "a" };
		L81_FullJustify fullJustify = new L81_FullJustify();
//		String s = fullJustify.mergWord(words, 0, 2, 16, 8);
		System.out.println(fullJustify.fullJustify(words, 1));
	}

}

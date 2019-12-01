package com.jackli.solution;

/**
* @Description: LCS: 获取一个字符中的最长公共连续子串.
* @Warning:
* @Author: Jack Li
* @Package: question005 - LongestSubString
* @Date: Nov 30, 2019 11:39:17 PM
* @Version: 1.0.0
* @TimeComplexity: Required[*] ---- Current[O(n^2)]
* @ExecuteResult: Success!
* @Status: Accepted
 */
public class LongestSubString {
	public static void main(String[] args) {
		System.out.println(longestSubstring("", null));
		System.out.println(longestSubstring("", ""));
		System.out.println(longestSubstring("abc", "defg"));
		System.out.println(longestSubstring("abcfg", "kmlozazui"));
		System.out.println(longestSubstring("aaaaa", "aaaaaaaaa"));
		System.out.println(longestSubstring("abcdefedcba", "abcdefedcba"));
	}
	
	/**
	 * @Description: 定义一个以 str1 为行, 以 str2 为 列的
	 * @Warning: 
	 * @Author: Jack Li
	 * @Date: Nov 30, 2019 11:56:16 PM
	 * @Version: 1.0.0
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static String longestSubstring(String str1, String str2) {
		if(str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty()) {
			return null;
		}
		
		String result = null;
		
		// 初始化一个表用于记录 str1 和 str2 的相同字符的坐标与长度
		int[][] rc = new int[str1.length()][str2.length()];
		int leftTop;
		
		int subLength = 0, endIndexByStr1 = 0;
		
		for(int i = 0; i < str1.length(); i++) {
			for(int j = 0; j < str2.length(); j++) {
				if(str1.charAt(i) == str2.charAt(j)) {
					// 获取左上角的值
					leftTop = 0;
					
					if(i > 0 && j > 0) {
						leftTop = rc[i - 1][j - 1];
					}

					rc[i][j] = leftTop + 1;
					
					if(rc[i][j] > subLength) {
						subLength = rc[i][j];
						endIndexByStr1 = i;
					}
				}
			}
		}
		
		// 获取最长子序列
		if(subLength > 0) {
			result = str1.substring(endIndexByStr1 - subLength + 1, endIndexByStr1 + 1);
		}
		
		return result;
	}
}

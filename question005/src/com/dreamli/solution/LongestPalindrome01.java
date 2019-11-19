package com.dreamli.solution;

/**
 * @Description: 获取一个字符串的最大回文子序列.
 * @Warning: 假设字符串非空, 且最大长度为 1000.
 * @Author: Jack Li
 * @Package: question005 - LongestPalindrome01
 * @Date: Nov 19, 2019 9:39:20 AM
 * @Version: 1.0.0
 * @TimeComplexity: Required[*] ---- Current[O(n^2)]
 * @ExecuteResult: Success!
 * @Status: Accepted
 */
public class LongestPalindrome01 {
	public static void main(String[] args) {
		
	}
	
	/**
	 * Example: "abefcbbckz" --> "cbbc"
	 * 
	 * maxLenth: 记录最大回文子串的长度 --> 4
	 * middleIndex: 记录回文子串中间值的 index. 如果子串为偶数位该值为中间较小的 index. --> 4
	 * middleCount: 回文序列中间的值, 如果回文序列为偶数位, 则为中间重复的字符数. --> 2 ("bb")
	 * result: 字符串中的最大回文序列 --> "cbbc"
	 */
	private static String longestPalindrome(String str) {
		if(str == null || str.length() < 2) {
			return str;
		}
		
		int maxLength = 1; // 至少长度为1
		String result = str.charAt(0) + ""; // 至少是第一个字符
		int middleIndex = 0;
		int middleCount = 1;
		
		// temp variable
		String left, middle, right;
		
		for(int i = 1; i < str.length(); i++) {
			// calculate middleCount
			middleCount = 1;
			
			for(int j = 1; j < str.length(); j++) {
				if(i + j < str.length() && str.charAt(i + j) == str.charAt(i)) {
					middleCount++;
				}
				else {
					break;
				}
			}
			
			// calculate middle str.  ----> bb
			middle = str.substring(i, i + middleCount);

			for(int j = 1; j <= i; j++) {
				left = str.substring(beginIndex, endIndex)
			}
		}
		
		return result;
	}
	
}

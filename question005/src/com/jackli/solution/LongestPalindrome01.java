package com.jackli.solution;

/**
 * @Description: 获取一个字符串的最大回文子序列.
 * @Warning: 假设字符串非空, 且最大长度为 1000.
 * @Author: Jack Li
 * @Package: question005 - LongestPalindrome01
 * @Date: Nov 19, 2019 9:39:20 AM
 * @Version: 1.0.0
 * @TimeComplexity: Required[*] ---- Current[O(n^2)]
 * @ExecuteResult: Success!
 * @Status: Time Limit Exceeded
 */
public class LongestPalindrome01 {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("bb"));
		System.out.println(longestPalindrome("ccc"));
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("cbbd"));
		System.out.println(longestPalindrome("abefkcbbckz"));
		String str = "vaomxdtiuwqlwhgutkhxxhccsgvyoaccuicgybnqnslogtqhblegfudagpxfvjdacsxgevvepuwthdtybgflsxjdmmfumyqgpxatvdypjmlapccaxwkuxkilqqgpihyepkilhlfkdrbsefinitdcaghqmhylnixidrygdnzmgubeybczjceiybowglkywrpkfcwpsjbkcpnvfbxnpuqzhotzspgebptnhwevbkcueyzecdrjpbpxemagnwmtwikmkpqluwmvyswvxghajknjxfazshsvjkstkezdlbnkwxawlwkqnxghjzyigkvqpapvsntojnxlmtywdrommoltpbvxwqyijpkirvndwpgufgjelqvwffpuycqfwenhzrbzbdtupyutgccdjyvhptnuhxdwbmdcbpfvxvtfryszhaakwshrjseonfvjrrdefyxefqfvadlwmedpvnozobftnnsutegrtxhwitrwdpfienhdbvvykoynrsbpmzjtotjxbvemgoxreiveakmmbbvbmfbbnyfxwrueswdlxvuelbkrdxlutyukppkzjnmfmclqpkwzyylwlzsvriwomchzzqwqglpflaepoxcnnewzstvegyaowwhgvcwjhbbstvzhhvghigoazbjiikglbqlxlccrwqvyqxpbtpoqjliziwmdkzfsrqtqdkeniulsavsfqsjwnvpprvczcujihoqeanobhlsvbzmgflhykndfydbxatskf";
		System.out.println(longestPalindrome(str));
		System.out.println(str.length());
	}
	
	/**
	 * Example: "abefkcbbckz" --> "kcbbck"
	 * 
	 * maxLenth: 记录最大回文子串的长度 --> 6
	 * middleIndex: 记录回文子串中间值的 index. 如果子串为偶数位该值为中间较小的 index. --> 6
	 * middleCount: 回文序列中间的值, 如果回文序列为偶数位, 则为中间重复的字符数. --> 2 ("bb")
	 * result: 字符串中的最大回文序列 --> "kcbbck"
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
		int len = 0;
		
		for(int i = 0; i < str.length(); i++) {
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

			if(middleCount != 1 && middleCount > maxLength) {
				// 当中间长度发生变化, 回文序列至少是中间重复的子串.
				result = str.substring(i, i + middleCount);
				maxLength = result.length();
			}
			
			// calculate middle str.  ----> bb
			middle = str.substring(i, i + middleCount);

			for(int j = 1; j <= i; j++) {
				if(i -j < 0 || i + middleCount +j > str.length()) {
					break;
				}
				
				left = str.substring(i - j, i) + middle; // kcbb
				right = new StringBuffer(str.substring(i + middleCount, i + middleCount + j)).reverse() //kc
						+ middle; // kcbb
				
				if(left.equals(right)) {
					// find a palindrome.
					len = j * 2 + middleCount;
					
					if(len > maxLength) {
						maxLength = len;
						result = str.substring(i - j, i + middleCount + j);
					}
				}
			}
		}
		
		return result;
	}
	
}

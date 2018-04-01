package com.dreamli.arrangement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 获取直定数组的全排列 
 * @Warning: 
 * @Author: dreamli
 * @Package: question003 - com.dreamli.arrangement.FullArrangement.java
 * @Date: 2018年4月1日 下午11:50:39
 * @Version: 1.0.0
 * @ExecuteResult: Success!
 */
public class FullArrangement {
	
	private static int counter = 0;
	
	public static void main(String[] args) {
		String[] nums = new String[] { "1", "2", "3", "4" };

		
		printFullArrangement(new ArrayList<String>(Arrays.asList(nums)), "");
		
		System.out.println("Total:" + counter);
	}
	
	private static void printFullArrangement(List<String> nums, String result) {
		if(nums == null || nums.size() == 0) { // 找到一个排列
			System.out.println(result);
			counter++;
		}
		
		for (int i = 0; i < nums.size(); i++) {
			String num = nums.remove(i);
			printFullArrangement(nums, result + num);
			nums.add(i, num);
		}
	}
}

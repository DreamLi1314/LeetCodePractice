package com.dreamli.solution;

/**
 * @Description: 计算两个已排序数组的中位数, 且时间复杂度不超过  O(log (m+n)).
 * @Warning: 输入数组不为 null
 * @Author: dreamli
 * @Package: question004 - .Solution01.java
 * @Date: 2018年5月15日 下午9:12:46
 * @Version: 1.0.0
 * @TimeComplexity: O(n) ---- O((n + m) / 2 + 1)
 * @ExecuteResult: Success!
 * @Status: Accepted
 */
public class Solution01 {

	public static void main(String[] args) {
		System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
		System.out.println(findMedianSortedArrays(new int[] { 1 }, new int[] { 4, 6 }));
		System.out.println(findMedianSortedArrays(new int[] { 100000 }, new int[] { 100001 }));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int i = 0, j = 0, k = 0, sumLen = nums1.length + nums2.length, len = sumLen / 2;
		int[] num = new int[len + 1];

		while (k <= len) {//只需要将一半的数据排序出来就可以计算到结果
			Integer n1 = null, n2 = null, min = Integer.MAX_VALUE;
			// 从 nums1 中取一个元素
			if(i < nums1.length) {
				n1 = nums1[i];
			}
			
			//从 nums2 中取一个元素
			if(j < nums2.length) {
				n2 = nums2[j];
			}
			
			// 计算较小值, 也就是当前需要加入排序的元素
			min = Math.min(n1 != null ? n1 : Integer.MAX_VALUE, n2 != null ? n2 : Integer.MAX_VALUE);
			// 将元素加入到结果数组
			num[k++] = min;
			
			// 如果当前元素是从 nums1 中取出来的, 则将 i + 1, 反之将 j + 1 ---> 由于使用的是 Integer, 所以要使用 equals 代替 ==, 因为 元素可能大于 127
			if(min.equals(n1)) {
				i++;
			}
			else {
				j++;
			}
		}
		
		return (sumLen % 2 == 1) ? num[k - 1] : (num[k -1] + num[k -2 ]) * 1.0 / 2;
	}
}

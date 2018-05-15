package com.dreamli.solution;

public class Solution01 {

	public static void main(String[] args) {
//		System.out.println(findMedianSortedArrays(null, null));
//		System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
//		System.out.println(findMedianSortedArrays(new int[] { 1 }, new int[] { 4, 6 }));
		System.out.println(findMedianSortedArrays(new int[] { 100000 }, new int[] { 100001 }));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int i = 0, j = 0, k = 0, sumLen = nums1.length + nums2.length, len = sumLen / 2;
		int[] num = new int[len + 1];

		while (k <= len) {
			Integer n1 = null, n2 = null, min = Integer.MAX_VALUE;
			if(i < nums1.length) {
				n1 = nums1[i];
			}
			
			if(j < nums2.length) {
				n2 = nums2[j];
			}
			
			min = Math.min(n1 != null ? n1 : Integer.MAX_VALUE, n2 != null ? n2 : Integer.MAX_VALUE);
			num[k++] = min;
			
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

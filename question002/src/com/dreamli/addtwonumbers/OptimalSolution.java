package com.dreamli.addtwonumbers;

import com.dreamli.addtwonumbers.Solution03.ListNode;

/**
 * @Description: 最优解 时间复杂度 O(max{m, n}) 和 Solution03 类似
 * @Warning: 该方法将结果集创建为带表头的单向链表, 返回结果集的时候返回 head.next
 * @Author: dreamli
 * @Package: question002 - com.dreamli.addtwonumbers.OptimalSolution.java
 * @Date: 2018年3月28日 上午2:10:44
 * @Version: 1.0.0
 */
public class OptimalSolution {
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;
	}
	
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		node1.next = node2;
		System.out.println(node1);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(6);
		ListNode node6 = new ListNode(7);
		ListNode node7 = new ListNode(9);

		node6.next = node7;
		node5.next = node6;
		node4.next = node5;
		System.out.println(node4);

		System.out.println(addTwoNumbers(node1, node4));
	}
}

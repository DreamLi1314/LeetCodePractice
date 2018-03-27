package com.dreamli.addtwonumbers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: You are given two non-isEmpty linked lists representing two
 *               non-negative integers. The digits are stored in reverse order
 *               and each of their nodes contain a single digit. Add the two
 *               numbers and return it as a linked list.
 * 
 *               You may assume the two numbers do not contain any leading zero,
 *               except the number 0 itself.
 * 
 *               Example
 * 
 *               Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 *               Explanation: 342 + 465 = 807.
 * @Warning:
 * @Author: dreamli
 * @Package: question002 - com.dreamli.addwwonumbers.Solution01.java
 * @Date: 2018年3月26日 下午11:57:09
 * @Version: 1.0.0
 */
public class Solution01 {
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

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null; // 结果链表
		Queue<Integer> num1 = new LinkedList<>();
		Queue<Integer> num2 = new LinkedList<>();
		
		do {
			num1.add(l1.val);
		} while(null != (l1 = l1.next));

		do {
			num2.add(l2.val);
		} while(null != (l2 = l2.next));
		
		int left, right, carry = 0; //  加数， 被加数， 进位数
		
		do {
			left = num1.poll();
			right = num2.poll();
			int sum = left + right + carry;
			ListNode sumNode = new ListNode(sum % 10); // 两个个位数相加可能大于10
			carry = sum / 10; // 对高位的进位， 如果大于10就是1， 如果没大于10就是0
			sumNode.next = result; //采用头插发构建结果链表
			result = sumNode; //头指针前移
		} while(!num1.isEmpty() && !num2.isEmpty());//对两个数共有的位进行求和
		
		// 处理剩余位
		Queue<Integer> remainig = null; //剩余的高位节点
		if(!num1.isEmpty()) { // num1 位数较多
			remainig = num1;
		}
		
		if(!num2.isEmpty()) { // num2 位数较多
			remainig = num2;
		}
		
		if(remainig != null) { // 两个数字位数不同， 存在剩余高位
			do {
				if(carry != 0)  { // 存在进位，需要逐位累加
					left = remainig.poll();
					right = carry;
					int sum = left + right;
					ListNode sumNode = new ListNode(sum % 10);
					carry = sum /10;
					sumNode.next  = result;
					result = sumNode;
				} else { // 不存在进位，直接将剩余部分头插到结果集
					ListNode  first = new ListNode(remainig.poll());
					first.next = result;
					result = first;
				}
			} while(!remainig.isEmpty());
		}

		if(carry != 0) { // 两个数字位数相同， 但是存在进位
			ListNode  first = new ListNode(carry);
			first.next = result;
			result = first;
		}
		
		return result;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			ListNode root = this;
			do {
				sb = sb.append(root.val).append("->");
			} while(null != (root = root.next));
			
			return sb.toString();
		}
	}
}

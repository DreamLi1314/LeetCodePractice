package com.dreamli.addtwonumbers;

/**
 * @Description: 时间复杂度 O(n): 遍历最长的数字链, 对于位数不够的用 0 代替以在一次循环中处理求和
 * @Warning:
 * @Author: dreamli
 * @Package: question002 - com.dreamli.addtwonumbers.Solution02.java
 * @Date: 2018年3月28日 上午1:39:13
 * @Version: 1.0.0
 */
public class Solution03 {
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
		ListNode last = null; // 尾指针
		int left, right, carry = 0;

		do {
			left = l1 != null ? l1.val : 0; // 如果 l1 不为空, 就取 val, 为空用 0 代替
			right = l2 != null ? l2.val : 0;
			int sum = left + right + carry; // 求一个数字位上的和
			carry = sum / 10; // 计算进位
			ListNode sumNode = new ListNode(sum % 10); // 创建当前位的结果集节点 --- 新结果集链表的尾节点

			if (result == null) { // 如果是第一次, 将头指针指向最低位
				result = sumNode;
			} else {
				last.next = sumNode; // 如果结果集链表的表头指针不为空, 将新的最低位节点以尾插的方式添加到结果集链表
			}

			last = sumNode; // 移动尾指针
			// 当还有节点(无论是位数多的还是位数少的) 使用 | 以保持 l1 和 l2 同步移动
		} while ((null != (l1 != null ? (l1 = l1.next) : null)) | (null != (l2 != null ? (l2 = l2.next) : null)));

		if (carry != 0) { // 最高位还有一个进位 carry == 1
			ListNode first = new ListNode(carry);
			last.next = first;
			last = first;
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
			} while (null != (root = root.next));

			return sb.toString();
		}
	}
}

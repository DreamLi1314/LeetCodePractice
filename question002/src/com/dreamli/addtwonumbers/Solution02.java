package com.dreamli.addtwonumbers;

/**
 * @Description: This queues doesn't seem necessary. 
 * @Warning: 
 * @Author: dreamli
 * @Package: question002 - com.dreamli.addtwonumbers.Solution02.java
 * @Date: 2018年3月28日 上午1:39:13
 * @Version: 1.0.0
 */
public class Solution02 {
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

	public static ListNode addTwoNumbers(ListNode num1, ListNode num2) {
		ListNode result = null; // 结果链表
		
		int left, right, carry = 0; //  加数， 被加数， 进位数
		
		do {
			left = num1.val;
			right = num2.val;
			
			int sum = left + right + carry;
			ListNode sumNode = new ListNode(sum % 10); // 两个个位数相加可能大于10
			carry = sum / 10; // 对高位的进位， 如果大于10就是1， 如果没大于10就是0
			sumNode.next = result; //采用头插发构建结果链表
			result = sumNode; //头指针前移
		} while((null != (num1 = num1.next)) &  (null != (num2 = num2.next)));//对两个数共有的位进行求和
		
		// 处理剩余位
		ListNode remainig = null; //剩余的高位节点
		if(num1 != null) { // num1 位数较多
			remainig = num1;
		}
		
		if(num2 != null) { // num2 位数较多
			remainig = num2;
		}
		
		if(remainig != null) { // 两个数字位数不同， 存在剩余高位
			do {
				if(carry != 0)  { // 存在进位，需要逐位累加
					left = remainig.val;
					right = carry;
					int sum = left + right;
					ListNode sumNode = new ListNode(sum % 10);
					carry = sum /10;
					sumNode.next  = result;
					result = sumNode;
				} else { // 不存在进位，直接将剩余部分头插到结果集
					ListNode  first = new ListNode(remainig.val);
					first.next = result;
					result = first;
				}
			} while(null != (remainig = remainig.next));
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

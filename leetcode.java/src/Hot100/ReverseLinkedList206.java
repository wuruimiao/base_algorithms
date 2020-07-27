package Hot100;

import Struct.ListNode;

/*
* 206. 反转链表
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？*/
public class ReverseLinkedList206 {
    private ListNode reverseIter(ListNode head) {
        ListNode newHead = null, bak;
        while (head != null) {
            bak = head.next;
            head.next = newHead;
            newHead = head;
            head = bak;
        }
        return newHead;
    }

    private ListNode reverseRecur(ListNode node, ListNode newHead) {
        if (node == null) {
            return newHead;
        }
        ListNode tail = reverseRecur(node.next, newHead);
        node.next = null;
        tail.next = node;
        return node;
    }

    public ListNode reverseList(ListNode head) {
//        return reverseIter(head);
        ListNode newHead = new ListNode();
        reverseRecur(head, newHead);
        return newHead.next;
    }

    public static void main(String[] args) {
        ReverseLinkedList206 t = new ReverseLinkedList206();
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(t.reverseList(head1).String());
    }
}

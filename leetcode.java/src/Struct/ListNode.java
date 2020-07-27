package Struct;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {
    }
    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }

    public String String() {
        ListNode head = this;
        StringBuilder result = new StringBuilder();
        while (head != null) {
            result.append(head.val + "->");
            head = head.next;
        }
        return result.toString();
    }
}
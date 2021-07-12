package linkedlist;

// https://leetcode.com/problems/merge-two-sorted-lists/

public class MergeTwoSortedLists {

    static class ListNode {

        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);

        return answer;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode second = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode answer = mergeTwoLists(first, second);

        while (answer != null) {
            System.out.print(answer.val + " -> ");
            answer = answer.next;
        }
    }
}

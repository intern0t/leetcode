// https://leetcode.com/problems/add-two-numbers/

public class AddTwoNumbers {

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

    public static void main(String[] args) {
        //   If 342+465 = 807, [2 4 3] + [5 6 4] = [7 0 8]
        ListNode first = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode second = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode answer = addTwoNumbers(first, second);

        while (answer != null) {
            System.out.print(answer.val + " -> ");
            answer = answer.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer, temp = new ListNode(0);
        answer = temp;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry += sum;
            int remainder = carry % 10;
            carry /= 10;
            answer.next = new ListNode(remainder);
            answer = answer.next;
        }

        return temp.next;
    }
}

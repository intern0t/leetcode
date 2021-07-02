// https://leetcode.com/problems/add-two-numbers/

public class AddTwoNumbers {

  class ListNode {

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

  }

//   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//     ListNode answer = new ListNode(0);
//     int carry = 0;

//     while (l1 != null || l2 != null || carry != 0) {
//       int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
//       int remainder = sum % 10;

//       carry = sum / 10;
//       ListNode node = new ListNode(remainder);
//       answer.next = node;
//       l1 = (l1.next == null) ? l1 : l1.next;
//       l2 = (l2.next == null) ? l2 : l2.next;
//     }

//     return answer;
//   }


//      int carry = 0;
//     ListNode p, dummy = new ListNode(0);
//     p = dummy;
//     while (l1 != null || l2 != null || carry != 0) {
//         if (l1 != null) {
//             carry += l1.val;
//             l1 = l1.next;
//         }
//         if (l2 != null) {
//             carry += l2.val;
//             l2 = l2.next;
//         }
//         p.next = new ListNode(carry%10);
//         carry /= 10;
//         p = p.next;
//     }
//     return dummy.next;
}

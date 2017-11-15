/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored 
 * in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode node;
        
        int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
        node = new ListNode(sum % 10);
        if (sum >= 10) {
            if (l1 != null && l1.next == null && l2 == null
                    || l2 != null && l2.next == null && l1 == null
                    || l1 != null && l2 != null && l2.next == null && l1.next == null) {
                node.next = new ListNode(1);
                return node;
            } else if (l1 != null && l1.next != null) {
                l1.next.val += 1;
            } else if (l2 != null && l2.next != null) {
                l2.next.val += 1;
            }
        }

        l1 = l1 == null ? null : l1.next;
        l2 = l2 == null ? null : l2.next;
        node.next = addTwoNumbers(l1, l2);

        return node;
    }
}

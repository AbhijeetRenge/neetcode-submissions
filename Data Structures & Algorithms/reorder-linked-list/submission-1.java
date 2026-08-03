/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        System.out.println("Inside function");
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // System.out.println("Now reversing "+slow.next.val);
        ListNode rev = reverseList(slow.next);
        slow.next = null;
        // System.out.println(rev.val);
        slow = head;
        while(slow != null && rev != null){
            fast = slow.next;
            slow.next = rev;
            slow = fast;
            fast = rev.next;
            rev.next = slow;
            rev = fast;
        }
        // return head;
    }

    public static ListNode reverseList(ListNode head){
        ListNode newHead = null, curr = newHead, p = head;
        while(p != null){
            if(newHead == null){
                newHead = p;
                curr = p;
                p = p.next;
                curr.next = null;
            }else{
                ListNode temp = p;
                p=p.next;
                temp.next = curr;
                curr = temp;
            }
            
        }
        return curr;
    }
}

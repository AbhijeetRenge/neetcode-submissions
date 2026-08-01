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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 0;
        ListNode p = head;
        while(i<n){
            i++;
            p = p.next;
        }
        ListNode curr= head;
        if(p == null)return head.next;
        while(p.next != null){
            curr = curr.next;
            p=p.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}

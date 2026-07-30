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
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head != null){
            if(newHead == null){
                newHead = head;
                head = head.next;
                newHead.next = null;
            }else{
                ListNode temp = head;
                head = head.next;
                temp.next = newHead;
                newHead = temp;
            }
        }
        return newHead;
    }
}

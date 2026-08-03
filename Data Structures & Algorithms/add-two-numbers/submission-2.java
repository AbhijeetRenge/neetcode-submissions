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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // ListNode n1 = reverseList(l1), n2 = reverseList(l2);
        ListNode n1 = l1, n2 = l2;
        int carry = 0;
        ListNode head = n1;
        while(n1.next != null && n2.next != null){
            n1.val += n2.val + carry;
            if(n1.val > 9){
                carry = 1;
                n1.val -= 10;
            }else{
                carry = 0;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1.val += n2.val + carry;
        if(n1.val > 9){
            n1.val -= 10;
            carry =1;
        }else{
            carry = 0;
        }
        ListNode prev = n1;
        if(n2.next != null){
            n1.next = n2.next;
        }
        n1 = n1.next;
        
        while(n1 != null){
            n1.val += carry;
            if(n1.val > 9){
                n1.val -= 10;
                carry = 1;
            }else{
                carry = 0;
            }
            prev = n1;
            n1 = n1.next;
        }
       
        // head = reverseList(head);
        if (carry == 0)return head;
        prev.next = new ListNode(1);
        return head;
    }

    public static ListNode reverseList(ListNode head){
        ListNode p = head, curr = null;
        while(p!=null){
            if(curr == null){
                curr = p;
                p=p.next;
                curr.next = null;
            }else{
                ListNode temp = p;
                p = p.next;
                temp.next = curr;
                curr = temp;
            }
        }
        return curr;
    }
}

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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(), curr = dummy;
        
        boolean flag = true;
        while(flag){
            flag = false;
            int index = 0, value = Integer.MAX_VALUE;
            for(int i=0;i<lists.length;i++){
                if(lists[i] == null)continue;
                flag = true;
                if(lists[i].val < value){
                    value = lists[i].val;
                    index = i;
                }
            }
            if(flag){
                curr.next = lists[index];
                lists[index] = lists[index].next;
                curr = curr.next;
                curr.next = null;
            }
            
        }
        return dummy.next;
        
    }
}

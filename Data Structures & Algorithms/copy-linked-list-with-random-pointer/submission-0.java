/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node>hash = new HashMap<>();
        if (head == null)return head;
        Node curr = head, newHead = null;
        newHead = new Node(head.val);

        Node newCurr = newHead;
        hash.put(head, newHead);
        while(curr.next!= null){
            if(!hash.containsKey(curr.next)){
                newCurr.next = new Node(curr.next.val);
            }else{
                newCurr.next = hash.get(curr.next);
            }
            hash.put(curr.next, newCurr.next);
            if (curr.random != null){
                if(!hash.containsKey(curr.random)){
                    newCurr.random = new Node(curr.random.val);
                }
                else {
                    newCurr.random = hash.get(curr.random);
                }
                hash.put(curr.random, newCurr.random);
            }
            curr = curr.next;
            newCurr = newCurr.next;
        }
        if(curr.random != null){
            newCurr.random = hash.get(curr.random);
        }
        return newHead;
    }
}

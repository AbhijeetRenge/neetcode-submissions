class LRUCache {
    int capacity;
    // int size;
    Node head, tail;
    Map<Integer, Node>hash;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        // this.size = 0;
        this.head = null;
        this.tail = null;
        this.hash = new HashMap<>();
    }
    
    public int get(int key) {
        if(this.hash.containsKey(key)){
            // Go to the node
            Node currNode = this.hash.get(key);
            if(currNode.prev != null){
                currNode.prev.next = currNode.next;
                if(currNode.next != null){
                    currNode.next.prev = currNode.prev;
                }else{
                    this.tail = currNode.prev;
                }
                
                currNode.next = this.head;
                currNode.prev = null;
                this.head.prev = currNode;
                this.head = currNode;
            }
            // if(this.tail.key == key){
            //     this.tail = this.tail.prev;
            // }
            return currNode.value;
            // Rearrange the doubly linked list
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(this.hash.containsKey(key)){
            Node currNode = this.hash.get(key);
            currNode.value = value;
            if(currNode.prev != null){
                currNode.prev.next = currNode.next;
                if(currNode.next != null){
                    currNode.next.prev = currNode.prev;
                }else{
                    this.tail = this.tail.prev;
                }
                currNode.prev = null;
                currNode.next = this.head;
                this.head.prev = currNode;
                this.head = currNode;
            }
            this.hash.put(key, currNode);
        }else{
            if (hash.size() == this.capacity){
                // System.out.println("removeing element for key "+key);
                Node removeNode = this.tail;
                this.hash.remove(removeNode.key);
                this.tail = this.tail.prev;
                if(this.tail != null){
                    this.tail.next = null;
                }else{
                    this.head = null;
                }

            }
            Node currNode = new Node(key, value);
            this.hash.put(key, currNode);
            if(head == null){
                this.head = currNode;
                this.tail = currNode;
            }else{
                currNode.next = this.head;
                this.head.prev = currNode;
                this.head = currNode;
            }

        }
        // System.out.println(this.hash);
        
    }
}

class Node {
    int key;
    int value;
    Node next;
    Node prev;

    private Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    // private Node (int key, int value, Node next, Node prev){
    //     this.key = key;
    //     this.value = value;
    //     this.next = next;
    //     this.value = value;
    // }
}

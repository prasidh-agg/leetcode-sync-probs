class Node {
    int key;
    int val;
    Node next;

    public Node(int key, int val, Node next){
        this.key = key;
        this.val = val;
        this.next = next;
    }
}

class MyHashMap {

    final int size = 10000;
    Node[] hashTable;

    public MyHashMap() {
        this.hashTable = new Node[size];       
    }

    private int hash(int key){
        return key % size;
    }

    public void put(int key, int value) {
        remove(key);
        int h = hash(key);
        //set the current node sitting in hashtable, as the next of the new node
        Node node = new Node(key, value, hashTable[h]);

        //finally, make this new node, the current starting node.
        //basically, we are adding the new node, to the start of the list
        hashTable[h] = node;
    }
    
    public int get(int key) {
        int h = hash(key);
        Node node = hashTable[h];

        while(node != null){
            if(node.key == key) return node.val;
            node = node.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int h = hash(key);
        Node node = hashTable[h];
        if(node == null) return;
        //if current node is the one we want to remove,
        //then just tell hashtable's node to move one ahead.
        if(node.key == key) hashTable[h] = node.next;
        else{
            while(node.next != null){
                if(node.next.key == key){
                    node.next = node.next.next;
                    return;
                }
                node = node.next;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

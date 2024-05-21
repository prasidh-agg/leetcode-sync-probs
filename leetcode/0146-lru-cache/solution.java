class LRUCache {

    Map<Integer, Node> cache;
    Node front;
    Node back;
    int cap;

    class Node{
        private int key;
        private int val;
        private Node next;
        private Node prev;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        cap = capacity;
        cache = new HashMap<>();
        front = new Node(-1, 0);
        back = new Node(-1, 0);
        front.next = back;
        back.prev = front;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        int val = cache.get(key).val;
        remove(cache.get(key));
        insertAtBack(cache.get(key));
        return val;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        cache.put(key, new Node(key, value));
        insertAtBack(cache.get(key));

        if(cache.size() > cap){
            Node lru = front.next;
            remove(lru);
            cache.remove(lru.key);
        }   
    }

    public void remove(Node node){
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    public void insertAtBack(Node node){
        Node prev = this.back.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.back;
        this.back.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

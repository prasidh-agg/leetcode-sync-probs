class LRUCache {

    private int maxKeys;
    LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.maxKeys = capacity;
        this.map = new LinkedHashMap<>(capacity, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
                return size() > maxKeys;
            }
        };
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

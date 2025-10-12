class LRUCache:

    class Node:
        def __init__(self, key, val):
            self.key = key
            self.val = val
            self.prev = self.next = None

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {}
        self.head = self.Node(0,0) #dummy nodes
        self.tail = self.Node(0,0)
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key: int) -> int:
        # if key is not in our cache (dict), just return -1
        if key not in self.cache:
            return -1
        
        removal_node = self.cache[key]
        self.move_to_head(removal_node)

        return removal_node.val

    def put(self, key: int, value: int) -> None:
        # if this key already exists in the cache, move the node to the head, and update the cache
        if key in self.cache:
            existing_node = self.cache[key]
            existing_node.val = value
            self.move_to_head(existing_node)

        else:
            if len(self.cache) == self.capacity:
                self.remove_from_tail()
            
            # if the key doesn't exist, make a new node and add it to head
            new_node = self.Node(key, value)
            new_node.prev = self.head
            new_node.next = self.head.next
            self.head.next.prev = new_node
            self.head.next = new_node
            self.cache[key] = new_node

    
    def move_to_head(self, removal_node: Node) -> None:
        if removal_node == self.head.next:
            return
        # store removal_node's next and prev nodes
        prev_node = removal_node.prev
        next_node = removal_node.next

        # make the connections that were severed due to the removal of this node
        prev_node.next = next_node
        next_node.prev = prev_node

        # connections for moving node to the front
        removal_node.prev = self.head
        removal_node.next = self.head.next
        
        self.head.next.prev = removal_node # self.head.next basically gives us the first node, then we assign it's previous to the node that just became the MRU
        self.head.next = removal_node

    def remove_from_tail(self) -> None:
        # no actual nodes other than the head and tail dummies
        if self.tail.prev == self.head:
             return

        removal_node = self.tail.prev
        self.tail.prev = removal_node.prev

        # point that node's next to the tail now
        removal_node.prev.next = self.tail
        
        del self.cache[removal_node.key]

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)

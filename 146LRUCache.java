/*
146LRU Cache

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/

/*
	理解题意：	1. if key already present, reset the value
				2. invalidate the "least recently used" key, here "least recently used" including get.

	思考此处需要做哪些操作：	1. insert new values in order (sorted by timestamp)
							2. get/set values, update the position of the existing value in the list. (move to end)
							3. insert new values when over capacity, remove the head value and do step 1.
							Does this sound like something inked list do?
							Node {prev, next, int key, int val, int time}
*/
// this is a better soutlion using linked list							
public class LRUCache {
	long time = 0;
	HashMap<Integer, Node> map; // this is used to quickly locate where the node is 
	Node head;
	Node tail;
	int cap;

	public class Node {
		Node prev;
		Node next;
		int key;
		int value;
		long time;
		public Node (int key, int value, long time) {
			this.key = key;
			this.value = value;
			this.time = time;
		}
	}

    public LRUCache(int capacity) {
    	map = new HashMap<Integer, Node>();
    	cap = capacity;
    }
    
    public int get(int key) {
    	if (map.containsKey(key)) {
    		long curTime = time ++;
    		Node cur = map.get(key);
    		cur.time = curTime;
    		Node prev = cur.prev;
    		Node next = cur.next;
    		if (prev != null)
        		prev.next = next;
        	else //this means cur == head
        	    head = next;
        	if (next != null)
        		next.prev = prev;
        	else {//this mead cur == tail
        	    tail.next = cur;
        	    cur.prev = tail;
        	    tail = cur;  
        	}
    		return cur.value;
    	}
    	return -1;
    }
    
    public void set(int key, int value) {
    	long curTime = time ++;
    	Node cur = null;
    	if (map.containsKey(key)) {
    		cur = map.get(key);
    		cur.value = value;
    		cur.time = curTime; 
    		Node prev = cur.prev;
    		Node next = cur.next;
    		if (prev != null)
        		prev.next = next;
        	if (next != null)
        		next.prev = prev;
    	}
    	else {
    		//check cap
    		if (map.size() == cap) {
    			map.remove(head.key);
    			if (head == tail) {
    			    head = null;
    			    tail = null;
    			}
    		}
    		cur = new Node(key, value, curTime);
    		map.put(key, cur);
    	
    	   if (tail == null) {
        		head = cur;
        		tail = cur;
    	    }else {
            	cur.prev = tail;
            	tail.next = cur;
                tail = cur;	
    	    }
    	}
    	Node tmp = head;
    	System.out.println("New valu set....");
    	while (tmp != null) {
    	    System.out.println(tmp.key + ":" + tmp.value + ":" + tmp.time);
    	    tmp = tmp.next;
    	}
    }

}

// this is my solution which is not very efficient because: map is 
public class LRUCache {
    public class ValueWithTime {
        int value;
        long time;
        public ValueWithTime(int value, long time){
            this.value = value;
            this.time = time;
        }
    }
    
    HashMap<Integer, ValueWithTime> cache;//key: value: time
    TreeMap<Long, Integer> map;//time : key
    int cap = 0;
    long count = 0;
    public LRUCache(int capacity) {
        cache = new HashMap<Integer, ValueWithTime>();
        map =new TreeMap<Long, Integer>();
        cap = capacity;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            long currentTime = count++;
            ValueWithTime preval = cache.get(key);
            ValueWithTime curval = new ValueWithTime(preval.value, currentTime);
            map.remove(preval.time);
            map.put(currentTime, key);
            cache.put(key, curval);
            return preval.value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        long currentTime = count++;
        ValueWithTime val = new ValueWithTime(value, currentTime);
        if (!cache.containsKey(key)) {
            checkCapAndInvalidateIfNeeded();
        }
        else {
            ValueWithTime preVal = cache.get(key);
            map.remove(preVal.time);
        }
        map.put(currentTime, key);
        cache.put(key, val);
        //printCache();
    }
    private void checkCapAndInvalidateIfNeeded() {
        if (cache.size() == cap){
            Map.Entry<Long, Integer> firstEntry = map.firstEntry();
            cache.remove(firstEntry.getValue());
            map.remove(firstEntry.getKey());
        }
    }
    //this method is for testing purpose
    private void printCache() {
        System.out.println("Printing cache....");
        for (Map.Entry<Integer, ValueWithTime> entry: cache.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().value + ": " + entry.getValue().time);
        }
        System.out.println("Printing map....");
        for (Map.Entry<Long, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
/*
295. Find Median from Data Stream 

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. 
So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

add(1)
add(2)
findMedian() -> 1.5
add(3) 
findMedian() -> 2
*/

class MedianFinder {
    public class MaxHeapComparator implements Comparator<Integer>{
    	public int compare(Integer i, Integer j){
    		return j-i;
    	}
    }
    // Adds a number into the data structure.
    PriorityQueue<Integer> right;
    PriorityQueue<Integer> left;
    public MedianFinder(){
    	right = new PriorityQueue<Integer>();
    	left = new PriorityQueue<Integer>(10, new MaxHeapComparator());
    }
    public void addNum(int num) {
        double m = findMedian();
        if(num > m)
        	right.offer(num);
        else
        	left.offer(num);
        if(right.size() > left.size())
        	left.offer(right.poll());
        else if(left.size() > right.size() + 1)
        	right.offer(left.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(!left.isEmpty()){
        	if(left.size() > right.size())
 		       	return (double) left.peek();
 		    else
 		    	return (double)(left.peek() + right.peek()) / 2;
        }
        return Double.MIN_VALUE;
    }
}

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
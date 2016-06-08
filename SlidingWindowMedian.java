/*
	Sliding Window Median
	Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array, 
	find the median of the element inside the window at each moving. (If there are even numbers in the array, 
	return the N/2- 1 th number after sorting the element in the window. )


Example
For array [1,2,7,8,5], moving window size k = 3. return [2,7,7]

At first the window is at the start of the array like this

[ | 1,2,7 | ,8,5] , return the median 2;

then the window move one step forward.

[1, | 2,7,8 | ,5], return the median 7;

then the window move one step forward again.

[1,2, | 7,8,5 | ], return the median 7;
*/


public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0)
        	return result;
        int[] tmp = Arrays.copyOfRange(nums, 0 ,  (k > nums.length? nums.length : k) );
        Arrays.sort(tmp);
        int m = tmp[(k-1)/2];
        result.add(m);
        if(k > nums.length)
        	return result;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k/2+1);
        for(int i = (k+1)/2; i < tmp.length; i++)
        	minHeap.offer(tmp[i]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k/2+1, new maxHeapComparator());
        for(int i = 0; i <= (k-1)/2; i++)
        	maxHeap.offer(tmp[i]);
        int offset = maxHeap.size() - minHeap.size(); //could be 0 or 1
    	System.out.println("offset = " + offset);
    	for(int i = 0; i < nums.length - k;i++ ){
    	    System.out.println("nums[i] = " + nums[i]);
    	    System.out.println("nums[i+k] = " + nums[i+k]);
    	    System.out.println("minHeap = " + Arrays.toString(minHeap.toArray()));
    	    System.out.println("maxHeap = " + Arrays.toString(maxHeap.toArray()));
    	    
    		if(nums[i] > m)
    			minHeap.remove(nums[i]);
    		else if(nums[i] <= m)
    			maxHeap.remove(nums[i]);
    		if(nums[i+k] > m)
    			minHeap.offer(nums[i+k]);
    		else if(nums[i+k] <= m)
    			maxHeap.offer(nums[i+k]);
    		if(maxHeap.size() - minHeap.size() > offset)
    			m = maxHeap.poll();
    		else if(maxHeap.size() - minHeap.size() < offset){
    			maxHeap.offer(minHeap.poll());
    			m = maxHeap.peek();
    		}   	
    		result.add(m);
    	}
    	return result;
    }


    public class maxHeapComparator implements Comparator<Integer>{
    	public int compare(Integer x, Integer y ){
    		return y-x;
    	}
    }

}
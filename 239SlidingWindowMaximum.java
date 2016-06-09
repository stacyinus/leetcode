/*
239. Sliding Window Maximum 

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
*/

public class Solution {

	//use deque O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {

    }
    //use priorityqueue: nlogk
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0)
            return new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new MaxHeapComparator());
        for(int i = 0; i < k ; i++)
        	queue.offer(nums[i]); //log k
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < nums.length - k; i++){
        	list.add(queue.peek());
        	queue.remove(nums[i]);//log k
        	queue.offer(nums[i+k]);//log k
        }
        list.add(queue.peek());
        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++)
        	result[i] = list.get(i);
        return result;
    }
    public class MaxHeapComparator implements Comparator<Integer>{
    	public int compare(Integer i, Integer j){
    		return j-i;
    	}
    }
}	
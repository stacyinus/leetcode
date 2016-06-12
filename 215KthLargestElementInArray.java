/*
215. Kth Largest Element in an Array
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

/*
4 different Solutions:
1. sort and get kth. 
2. use priority queue
3. Partition
4. radix sort: sort byte by byte, and for the last byte, consider the sign
https://leetcode.com/discuss/36913/solutions-java-having-worst-time-complexity-with-explanation
*/

public class Solution {

    //Partiion : O(n)
     public int kthLargestElement(int k, int[] nums) {
        return partition(nums, 0 ,nums.length - 1, k);
    }
    
    public int partition(int[] nums, int i, int j, int k){
        //System.out.println("start = " + i);
        //System.out.println("end = " + j);
        //System.out.println("k = " + k);
        int pivot = nums[i];
        int s = i, e = j;
        while(s < e){
            while( s < e && nums[e] >= pivot ){
                e--;
            }
            if( s < e )
                nums[s++] = nums[e];
            while( s < e && nums[s] < pivot ){
                s++;
            }
            if(s < e)
                nums[e--] = nums[s];
           
        }
         nums[s] = pivot;
        //System.out.println(Arrays.toString(nums));
        //System.out.println("pivot move to " + s);
        // j + 1 - k, is the index of the kth largest element in the array
        //s - (j + 1 - k)
        if(s == j + 1 - k)
            return nums[s];
        if(s > j + 1 - k)
            return partition(nums, i, s - 1, s - (j + 1 - k));
        return partition(nums, s + 1, j , k);
    }   

	//Sort: O(nlogn)
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //Priority Queue: O(nlogn)
    public int findKthLargest(int[] nums, int k) {
    	PriorityQueue<Integer> q = new PriorityQueue<Integer>();
    	for(int i = 0; i < nums.length; i++){
    		q.add(nums[i]);
    		if(queue.size() > k)
    			q.poll();
    	}
    	return q.poll();
    }
}
/*
169. Majority Element
Given an array of size n, find the majority element. The majority element is the element that 
appears more than  n/2  times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/

public class 169MajorityElement {
	//T: O(n)   S:O(n)
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> count = new HashMap<Integer,Integer>();
        for(int i = 0;i<nums.length;i++){
        	if(count.containsKey(nums[i]))
        		count.put(nums[i],count.get(nums[i])+1);
        	else
        		count.put(nums[i],1);
        	if(count.get(nums[i])>nums.length/2)
        	    return nums[i];        	
        }
        return -1;     
    }
	//Voting system: Precondition is there must be a majority element in the set
	//http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
	//   T: O(n)   S:O(1)  
    public int majorityElement(int[] nums) {
		if(nums==null||nums.length==0)
			return -1;
		int cur = 0;
		int count = 0;   
		for(int i = 0;i<nums.length;i++){
			if(count == 0){
				cur = nums[i];
				count += 1;
			}
			else if(cur == nums[i])
				count +=1;
			else 
				count -=1;
		}
		return cur;
    }    
}
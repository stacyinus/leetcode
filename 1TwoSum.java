/*Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9

Output: index1=1, index2=2*/
/*
	HashMap: O(n)
	Cant use 2 pointers here because it is asking to return the pointer. If you sort, then you lose the original position.
*/

public class 1TwoSum {        
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if(nums == null || nums.length < 2)
            return null;
        for(int i = 0 ; i< nums.length ; i++){
            if(map.containsKey(nums[i]))
                return new int[]{map.get(nums[i]),i+1};
            else 
                map.put(target - nums[i], i+1);
        }
        return null;
    }
}
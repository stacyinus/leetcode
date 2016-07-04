/*
229. Majority Element II
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

Hint:

How many majority elements could it possibly have?


*/
/*
	How many majority elements could it possibly have? 
	<=2. because we are looking for elements that appear more than n/3 times.
	Bayer-Moore Voting System:
		keep 2 counters count1 and count2 for majority elements num1 and num2.
		if equals to either one of the element, increase its count. 
		if not equal to any one, then decrease both of them.(THIS IS IMPORTANT!!!!DECREASE BOTH!!!)
		if any count became 0, change the num to the newly appeared number.
	
		Sinece we do not garuentee such element exists, in the end, we need to count again see 
		if the number of majority element we found appear more than n/3 times. eg. [1,2,3] 

        Here is a more generalized method :
        https://discuss.leetcode.com/topic/42463/java-solution-for-generalized-n-k-case 
*/

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        int[] result = new int[2];
        int[] count = new int[2];
        result[0] = 0;
        result[1] = 1;
        for (int i = 0; i < nums.length; i ++) {
            if (result[0] == nums[i]) {
                count[0]++;
            }
            else if (result[1] == nums[i]) {
                count[1]++;
            }
            else if (count[0] == 0) {
                result[0] = nums[i];
                count[0]++;
            }
            else if(count[1] == 0) {
                result[1] = nums[i];
                count[1]++;
            }
            else {
                count[0]--;
                count[1]--;
            }
        }
        Arrays.fill(count,0);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < result.length; j++) {
                if (nums[i] == result[j]) count[j]++;
            }
        }
        List<Integer> finalResult = new ArrayList<Integer>();
        for (int j = 0; j < result.length; j++) {
            if( count[j] <= nums.length / 3 )
                continue;
            finalResult.add(result[j]);
        }
        return finalResult;
    }
}
/*
16. 3Sum Closest 
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

/*
		Turn this problem to two sum.
		sort the array first, start from the begining, for each nums[i], find the two sum closest to target - nums[i]
		from i + 1 to nums.length -1

		Time Comlexity O(n2)
		Space O(1)
*/

public class Solution {
    //Second Round solution.
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int s = i + 1, e = nums.length - 1, tmp = 0;
            while ( s < e ) {
                if (nums[s] + nums[e] + nums[i] == target) return target;
                tmp = nums[i] + nums[s] + nums[e];
                if (tmp < target) {
                    s++;
                }else {
                    e--;
                }
                result = result == Integer.MAX_VALUE || Math.abs(result - target) > Math.abs(tmp - target) ? tmp : result;
            }
        }
        return result;
    }

    // first round solution. long...
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int r = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2 ; i++) {
        	int t = target - nums[i];
        	int closest = twoSumClosest(nums, i + 1, t);
        	if (t == closest)
        		return target;
        	if (min > Math.abs(t - closest)) {
        		min = Math.abs(t - closest);
        		r = closest + nums[i];
        	}
        }
        return r;
    }

    public int twoSumClosest(int[] nums, int i, int target) {
    	int s = i, e = nums.length - 1;
    	int closest = 0, min= Integer.MAX_VALUE;
    	while ( s < e ){
    		int sum = nums[s] + nums[e];
    		if( sum == target ) {
    			return target;
    		}
    		if (min > Math.abs(target - sum)) {
        		min = Math.abs(target - sum);
        		closest = sum;
        	}
    		if ( sum > target ) {
    			e--;
    		}
    		else {
    			s++;
    		}
    	}
    	return closest;
    }
}
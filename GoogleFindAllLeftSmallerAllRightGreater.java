/*
	google onsite:
	given an array of integer nums[], find all elements that leftside are smaller than nums[i] and right side are bigger than nums[i] 
*/
/*

8,4,3,2,8,8,8,8


*/
public class Solution {
    public ArrayList<Integer> canFind(int[] nums) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	int[] largest = new int[nums.length]; // the largest number up to i
    	boolean[] canFindLeft = new boolean[nums.length]; // whether nums[i] is greater than all nums on i's left
    	largest[0] = nums[0];
    	canFindLeft[0] = true;
    	for (int i = 1; i < nums.length; i++) {
    		canFindLeft[i] = nums[i] > largest[i - 1];
    		largest[i] = Math.max(largest[i - 1], nums[i]);
    	}
    	int[] smallest = new int[nums.length]; // the largest number up to i
    	boolean[] canFindRight = new boolean[nums.length]; // whether nums[i] is greater than all nums on i's left
    	smallest[nums.length - 1] = nums[nums.length - 1];
    	canFindRight[nums.length - 1] = true;
    	for (int i = nums.length - 2; i >= 0; i--) {
    		canFindRight[i] = nums[i] < smallest[i + 1];
    		smallest[i] = Math.min(smallest[i + 1], nums[i]);
    		if(canFindRight[i] && canFindLeft[i]) {
    			result.add(nums[i]);
    		}
    	}
    	return result;
    }
} 
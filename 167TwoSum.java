/*
167.Two Sum II - Input array is sorted 

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, 
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

*/

public class 167TwoSum { 
	//greedy algorithm: T: O(n)  S: O(1)
	//if using a map, then T: O(n)  S: O(n)
    public int[] twoSum(int[] numbers, int target) {  
    	if(numbers!=null&&numbers.length>1){
    		int i=0;
    		int j = numbers.length-1;
    		while(i<j){
    			int sum = numbers[i]+numbers[j];
    			if(sum<target)
    				i++;
    			else if(sum>target)
    				j--;
    			else
    				return new int[2]{i+1,j+1};
    		}
    	}
    	return new int[2];
    }
}
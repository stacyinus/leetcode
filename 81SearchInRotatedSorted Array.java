/*
81. Search in Rotated Sorted Array II

Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/

    public class Solution {
        //if duplicates are allowed, then it is not possible to binary search this problem
        // think about the extreme cases,seach 1 in an array contain all 2s.
        public boolean search(int[] nums, int target) {
        	if(nums == null || nums.length == 0)
        		return false;
            for(int i = 0; i < nums.length; i++){
            	if(nums[i] == target)
            		return true;
            }
            return false;
        }
    }
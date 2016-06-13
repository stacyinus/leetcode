/*
42. Trapping Rain Water 

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 Thanks Marcos for contributing this image!
*/

 /*
2 pointers: 
1) find the first peak from start, find the first peak from end
2) alwasy starting from the smaller side to calculate the trapped water. 
 */
public class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int result = 0;
        while(l < r){
        	//find first left peak starting from l
        	while(l < r && height[l+1] > height[l])
        		l++;
        	//find first right peak starting from r
        	while(l < r && height[r-1] > height[r])
        		r--;
        	if(l == r)
        		break;
        	//calculating from smaller side
        	if(height[l] <= height[r]){ 
        		int k = l+1;
        		while(k < r && height[k] <= height[l]){
        			result += height[l] - height[k]; 
        			k++;
        		}
        		l = k;
        	}
        	else{
        		int k = r-1;
        		while(k > l && height[k] <= height[r]){
        			result += height[r] - height[k]; 
        			k--;
        		}
        		r = k;
        	}
        }
        return result;
    }
}
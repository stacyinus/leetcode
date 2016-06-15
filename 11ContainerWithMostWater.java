/*
11. Container With Most Water

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/
/*
Two Pointers: 2 pointers start from left most and right most, 
move the one with smaller height value each time.
Time: O(n)
*/

public class Solution {
	//this is the basic brutal force method, which is slow and stupid
    public int maxArea(int[] height) {
        int max = 0;
        for(int i=0;i<height.length-1;i++)
        	for(int j=i+1;j<height.length;j++)
        		max = Math.max(max,Math.min(height[i],height[j])*(j-i));
        return max;
    }
    //this is two pointers
    public int maxArea(int[] height) {
    	int i=0,h=0,maxArea=0,j = height.length-1;
    	while(i<j){
    		h = Math.min(height[i],height[j]);
    		maxArea = Math.max(h*(j-i),maxArea);
    		if(height[i]<=h)
    			i++;
    		else
    			j--;
    	}
    	return maxArea;
    }
}
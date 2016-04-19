/*
33. Search in Rotated Sorted Array

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

public class Solution {
    //smart solution: the idea is, find a way to get rid of half of the array
    public int search(int[] nums, int target) {
        int s = 0, e = nums.length-1;
        while(s <= e){
           int m = s + (e-s)/2;
           if(nums[m] == target)
                return m ;
            if(nums[m] > target){
                if(nums[s] == target)
                    return s;                
                else if(nums[m] >= nums[s] && nums[s]>target)
                    s = m+1;
                else
                    e = m-1;
            }else{
                if(nums[e] == target)
                    return e;
                else if(nums[m] <  nums[s] && nums[e]<target )
                    e = m - 1;
                else
                    s = m + 1;
            }
        }
        return -1;
    }

    //smart solution: use the binary serach template
    public int search(int[] nums, int target) {
        int s = 0, e = nums.length-1;
        while(s + 1 < e){
            int m = s + (e-s)/2;
            if(nums[m] == target)
                return m;
            if(nums[m] > nums[s]){
                if(nums[m] > target && nums[s] <= target)
                    e = m;
                else
                    s = m;
            }
            else{
                if(nums[m] < target && nums[e] >= target)
                    s = m;
                else
                    e = m;
            }
        }
        if(nums[s] == target)
            return s;
        if(nums[e] == target)
            return e;
        return -1;
    }

    //my stupid solution: find the start, rotate the array so that it is properly sorted, and then do binary search
    public int search(int[] nums, int target) {
        int s = findStart(nums,0,nums.length-1);
        rotate(nums,0,s-1);
        rotate(nums,s,nums.length-1);
        rotate(nums,0,nums.length-1);
        int r = bSearch(nums,target,0,nums.length-1);
        if(r==-1)
            return r;
        return r+s>=nums.length?(r+s)-nums.length:r+s;
    }

    private int findStart(int[] a, int s, int e){
        if(a[s]<a[e]||s==e)
            return s;
        int mid = s+(e-s)/2;
        if(s==mid)
            return a[s]>a[e]?e:s;
        if(a[s]<a[mid])
            return findStart(a, mid+1,e);
        return findStart(a,s,mid);
    }
    private void rotate(int[] a, int s, int e){
        while(s<e){
            int tmp=a[e];
            a[e]=a[s];
            a[s]=tmp;
            s++;
            e--;
        }
    }
    private int bSearch(int[] a, int t, int s, int e){
        if(s>e)
            return -1;
        if(s==e)
            return a[s]==t?s:-1;
        int mid = s+(e-s)/2;
        if(a[mid]==t)
            return mid;
        if(a[mid]>t)
            return bSearch(a,t,s,mid-1);
        return bSearch(a,t,mid+1,e);
    }
}
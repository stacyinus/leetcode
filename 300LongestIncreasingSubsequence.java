/*
300. Longest Increasing Subsequence
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.

Note that there may be more than one LIS combination, 

it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/

public class Solution {
    //DP solution: T: O(n2)
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] maxs = new int[nums.length];
        int max = 1;
        for(int i = 0; i < nums.length; i++){
            maxs[i] = 1;
            for(int j = i-1; j >= 0; j-- )
                if(nums[i]>nums[j])
                    maxs[i] = Math.max(maxs[i], maxs[j]+1);
            max = Math.max(maxs[i], max );
        }
        return max;
    }
    //DP Solution: T:O(nlogn)
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);  
        int pos = 0;//keeps track of the last inserted position
        for(int i = 1; i< nums.length; i++){
            if(nums[i] > list.get(list.size()-1)){
                list.add(nums[i]);
                pos++;
                continue;
            }
            if(nums[i] == list.get(pos))
                continue;
            if(nums[i] > list.get(pos)){
                list.set(pos+1,nums[i]);
                pos += 1;
            }
            else{
                pos = findFirstGreaterThan(list, nums[i], pos);
                list.set(pos,nums[i]);
            }
        }
        return list.size();
    }

    public int findFirstGreaterThan(ArrayList<Integer> list, int n, int end){
        int s = 0, e = end;
        while(s + 1 < e){
            int m = s + (e - s)/2;
            if(list.get(m) <= n)
                s = m;
            else
                e = m;
        }
        if( list.get(s) > n )
            return s;
        if( list.get(e) > n )
            return e;
        return e+1;
    }
}
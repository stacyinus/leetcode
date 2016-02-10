/*
189. Rotate Array
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Related problem: Reverse Words in a String II
*/

public class Solution {
	//Time O(n),Space O(n) becareful here, java function is pass by reference
    public void rotate(int[] nums, int k) {
        int n = nums.length;
       	k=k%n;
        int[] copy = nums.clone();
        for(int i=0;i<n;i++){
        	if(k>=n)
        		k = k-n;
        	nums[k++]=copy[i];
        }        
    }
    //Time O(n),Space O(1):Rotation
    public void rotate(int[] nums, int k) {
       	k=k%nums.length;    
        rotate(nums,nums.length-k,nums.length-1);
        rotate(nums,0,nums.length-k-1);
        rotate(nums,0,nums.length-1);
    }   
    private void rotate(int[] nums, int s, int e){
        while(s<e){
            int tmp = nums[e];
            nums[e] = nums[s];
            nums[s] = tmp;
            s++;
            e--;
        }
    }
     //Time O(n),Space O(1):Direct move to the next position
    public void rotate(int[] nums, int k){
        k=k%nums.length;   
        int n = nums.length;
        int count = n;
        int preStart = 0;
        int start = 0;
        int toMove = nums[start];
        while(count>0&&k>0){
            int moveTo = (start+k)%n;
            int tmp = nums[moveTo];
            nums[moveTo]=toMove;
            toMove = tmp;
            start = moveTo;
            if(moveTo==preStart){
                preStart++;
                start = preStart;
                toMove = nums[start];
            }
            count--;
        }
    }

    //https://leetcode.com/discuss/27040/java-solution-in-one-pass-o-1-space-o-n-time
    public void rotate(int[] nums, int k){
        if (nums.length == 0) return;
        int n = nums.length;
        while ((k %= n) > 0 && n > 1) {
            int range = n - k;
            for (int i = 1; i <= range; i++) {
                int val = nums[n - i];
                nums[n - i] = nums[n - i - k];
                nums[n - i - k] = val;
            }
            n = k;
            k = n - (range % k);
        }
    }
}
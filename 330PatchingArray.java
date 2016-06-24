/*
330. Patching Array
Given a sorted positive integer array nums and an integer n, 
add/patch elements to the array such that any number in range [1, n] 
inclusive can be formed by the sum of some elements in the array. 
Return the minimum number of patches required.

Example 1:
nums = [1, 3], n = 6
Return 1.

Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.

Example 2:
nums = [1, 5, 10], n = 20
Return 2.
The two patches can be [2, 4].

Example 3:
nums = [1, 2, 2], n = 5
Return 0.

*/

/*
	Example 1:
	nums = [1, 3], n = 6	 missing: 2, 5, 6
	1, 3, 4      +      2

	nums = [2, 3], n = 6	 missing: 1, 4, 6
	1    : 1 , 2, 3,4, 5, 6
	
	 1. find all the combinations in nums, and see which sum is missing. reutrn a[], sorted.
	 2. for each a[i], 
*/
public class Solution {
    public int minPatches(int[] nums, int n) {
        List<Integer> possibleSums = new ArrayList<Integer>();
        getPossibleSums(nums, possibleSums, 0);
        List<Integer> missingSums = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
			if (!possibleSums.contains(i)) {
				missingSums.add(i);
			}
        }
        if (missingSums.size() == 0) {
        	return 0;
        }
        return 
    }

    private int getMinPatches(List<Integer> possibleSums, List<Integer> missingSums) {
    	int num = 0;
    	Set<Integer> checked = new HashSet<Integer>();
    	int missing = missingSums.get(0);
    	missingSums.remove(0);
    	while (missingSums.size() > 0) {
    		for(Integer sum : possibleSums) {
    			if (missingSums.contains(sum + missing)) {
    				missingSums.remove(new Integer (sum + missing));
    			}
    		}
    		num++;
    		possibleSums.add(missing);
    	}
    	return num;
    }

    private void getPossibleSums(int[] nums, List<Integer> result, int s) { 
    	if (s >= nums.length) {
    		return;
    	}
    	help(nums, result, s + 1);
    	for (Integer i : result) {
    		result.add(i + nums[s]);
    	}
    	result.add(nums[s]);
    }
}
/*
4. Median of Two Sorted Arrays 

There are two sorted arrays nums1 and nums2 of size m and n respectively. 
Find the median of the two sorted arrays. 
The overall run time complexity should be O(log (m+n)).	
*/

public class Solution {

	/*
		This is not a O(log (m + n)) method, but got accepted by oj and beat 45 %.
		This is a O(m+n) method. It's like merge 2 sorted array, keep 1 pointer at each array, and always move the 
		one with smaller num value forward, in the mean time count the value that we passed, until we reached target count, which is
		(length1 + length2) /2
	*/
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) return 0;
        if (nums1 == null) {
        	if (nums2.length % 2 == 1) return nums2[nums2.length / 2];
        	else {
        		return (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1])/2;
        	}
        }
        int l1 = nums1.length;
        int l2 = nums2.length;
        int i = 0, j = 0, count = 0;
        boolean n1 = false;
        int pre = 0, cur = 0;

        while (i < l1 || j < l2) {
        	pre = cur;
        	if (i == l1) {
        		cur = nums2[j];
        		j++;
        		n1 = false;
        	}
        	else if (j == l2) {
        		cur = nums1[i];
        		i++;
        		n1 = true;
        	}
        	else if (nums1[i] <= nums2[j]) {
        		cur = nums1[i];
        		i++;
        		n1 = true;
        	}
        	else {
        		cur = nums2[j];
        		j++;
        		n1 = false;
        	}
        	count ++;
        // 	System.out.println("count = " + count );
        // 	System.out.println("cur = " + cur );
        // 	System.out.println("pre = " + pre );
        	if (count == (l1 + l2)/2 + 1){
        		if ((l1 + l2) % 2 == 1) {
        			return cur;
        		}
        		else {
        			return (double)(pre + cur)/2;
        		}
        	}
        }
        return 0;
    }
}
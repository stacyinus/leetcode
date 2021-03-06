/*
Triangle Count

Given an array of integers, how many three numbers can be found in the array, so that we can build an triangle whose three edges length is the three numbers that we find?

Example
Given array S = [3,4,6,7], return 3. They are:

[3,4,6]
[3,6,7]
[4,6,7]
Given array S = [4,4,4,4], return 4. They are:

[4(1),4(2),4(3)]
[4(1),4(2),4(4)]
[4(1),4(3),4(4)]
[4(2),4(3),4(4)]

*/
/*
    Two Pointers: sort, for each number in the array(except for the front 2 numbers), 
    do a "two sum greater than"
*/
public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int s[]) {
        // write your code here
        Arrays.sort(s);
        int k = s.length - 1, count = 0;
        while(k > 1){
            int left = 0, right = k - 1;
            while(left < right){
                if(s[left] + s[right] > s[k]){
                    count += right - left;
                    right--;
                }
                else{
                    left++;
                }
            }
            k--;
        }
        return count;
    }
}

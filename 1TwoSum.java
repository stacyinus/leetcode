/*Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9

Output: index1=1, index2=2*/

public class 1TwoSum {     
	//O(n)
	public int[] twoSum2(int[] nums, int target) {
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();      
		if(nums == null || nums.length < 2)
            return null;
		int[] result = new int[2];        
		for(int i=0;i<nums.length;i++){
			ArrayList<Integer>  value;
			if(!map.containsKey(nums[i]))
				value = new ArrayList<Integer>();      			
			else
				value = map.get(nums[i]);			
			value.add(i+1);
			map.put(nums[i], value );
		}
		
		for(int i: nums){
			if(map.containsKey(target-i)){
				if(i == (target-i)){
					if(map.get(i).size()>1){
						result[0] = map.get(i).get(0);
						result[1] = map.get(i).get(1);
						break;
					}
					else
						continue;
				}
				else {
					result[0] = map.get(i).get(0);
					result[1] = map.get(target-i).get(0);
					break;
				}
			}	
		}
		return result;
    }
    
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if(nums == null || nums.length < 2)
            return null;
        for(int i = 0 ; i< nums.length ; i++){
            if(map.containsKey(nums[i]))
                return new int[]{map.get(nums[i]),i+1};
            else 
                map.put(target - nums[i], i+1);
        }
        return null;
    }
}
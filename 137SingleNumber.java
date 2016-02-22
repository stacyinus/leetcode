/*
137. Single Number II 

Given an array of integers, every element appears three times except for one. Find that single one.
*/

public class 137SingleNumber {
	public int singleNumber(int[] nums) {
		int result=0;
		for(int i=0;i<32;i++){
			int sum=0;
			for(int j=0;j<nums.length;j++)
				if(((nums[j]>>i)&1)>0)
					sum = (sum+1)%3;
			if(sum>0)
				result|= 1<<i;
		}
		return result;
	}
	//More generic way
	public int singleNumber(int[] nums) {

	}
	//Why this is not working?
	//Input:[-2,-2,1,1,-3,1,-3,-3,-4,-2]
	//Output:2147483644
	//Expected:-4
    public int singleNumber3(int[] nums) {
        int[] count = new int[32];
        for(int i=0;i<nums.length;i++){
        	int j=1;
        	int k=0;
        	while(k<32){
        		if((nums[i]&j)>0)
        			count[k]++;
        		k++;
        		j=j<<1;
        	}
        }
        int result = 0;
        for(int i=0;i<32;i++){
        	if(count[i]%3!=0)
        		result |= 1<<i;
        }
        return result;
    }
}
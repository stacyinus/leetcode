/*
280. Wiggle Sort
Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
*/
public class 280WiggleSort {
	//This method is really stupid. You don't need to sort the array first. 
	//see the clever method below 
    public void wiggleSort(int[] nums) {
    	if(nums==null||nums.length<=1)
    		return;
    	int[] copy= new int[nums.length];
    	for(int i=0;i<nums.length;i++)
    		copy[i]=nums[i];    	
    	mergeSort(nums,copy,0,nums.length-1);
    	for(int i=0;i<nums.length;i++)
    		copy[i]=nums[i];   
    	int i = 0;
    	int j = nums.length/2+1;
    	int k = 0;
    	while(k<nums.length){
    		nums[k++] = copy[i++];
    		if(j<nums.length)
    			nums[k++] = copy[j++];
    	}

    }
    private void mergeSort(int[] nums,int[] copy,int s,int e){
    	int m = s+(e-s)/2;
    	mergeSort(nums,copy,s,m);
    	mergeSort(nums,copy,m+1,e);
    	merge(nums.copy,s,m,e);
    }
    private void merge(int[] nums,int[] copy,int s,int m, int e){
    	int i1=s;
    	int i2=m+1;
    	int i = s;
    	while(i<=e){
    		if(i1>mid||i2<=r&&copy[i1]>copy[i2]){
    			nums[i]=copy[i2];
    			i2++;
    		}
    		else{
    			nums[i]=copy[i1];
    			i1++;
    		}
    		i++;
    	}
    }
    /*	clever method, T: O(n), S: O(1)
    	nums[even]<=nums[even+1] && nums[odd]>=nums[odd+1]
    	note: given nums[even]<=nums[even+1], if nums[even+1]<=nums[even+2], then nums[even]<=nums[even+2].
    		  hence, after swaping nums[even+1] and nums[even+2], nums[even] will still be <= the new nums[even+1]; 
    		  so the swap won't break the pre-condition. similarly, given nums[odd]>=nums[odd+1], if nums[odd+1]>=nums[odd+2],
    		  then nums[odd]>=nums[odd+2], after swapping nums[odd+1] and nums[odd+2], nums[odd] will still be >= the new nums[odd+1];
    */
    public void wiggleSort(int[] nums) {
    	if(nums==null||nums.length<=1)
    		return;
    	for(int i=0;i<nums.length-1;i++){
    		if((i%2==0)&&(nums[i]>nums[i+1])||(i%2==1)&&(nums[i]<nums[i+1])){
    			int tmp = 0; 
    			tmp=nums[i];
    			nums[i]=nums[i+1];
    			nums[i+1]=tmp;
    		}

    	}
    }
}
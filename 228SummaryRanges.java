/*
228. Summary Ranges

Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

Credits:
*/
public class 228SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if(nums.length==0) return list;
        String r = Integer.toString(nums[0]);
        for(int i=1;i<nums.length;i++){
        	if(nums[i]-nums[i-1]!=1){
        		if(!r.equals(Integer.toString(nums[i-1])))
        			list.add(r+"->"+nums[i-1]);
        		else
        			list.add(r);
        		r=Integer.toString(nums[i]);
        	}
        }
        if(r.equals(Integer.toString(nums[nums.length-1])))
        	list.add(r);
        else
        	list.add(r+"->"+nums[nums.length-1]);
        return list;
    }
}
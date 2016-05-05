/*
179. Largest Number

Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Subscribe to see which companies asked this question
*/
public class Solution {
	// most concise method using new libs in java 8
    public String largestNumber(int[] num) {
        String[] array = Arrays.stream(num).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(array, (String s1, String s2) -> (s2 + s1).compareTo(s1 + s2));
        return Arrays.stream(array).reduce((x, y) -> x.equals("0") ? y : x + y).get();
    } 
    //convert numbers to strings and compare.
	public class StringComparator implements Comparator<String>{
		public int compare(String a, String b){
			if(a.length() == b.length())
				return b.compareTo(a);//Here use b.compareTo(a) not a.compareTo(b) because you want to sort it desc
			String ab = a + b;
			String ba = b + a;
			return ba.compareTo(ab);
		}
	}
    public String largestNumber(int[] nums) {
        ArrayList<String> numStr = new ArrayList<String>(Arrays.asList(nums));
        Collections.sort(numStr, new StringComparator());
        StrinbBuilder sb = new StringBuilder();
        for(String s : numStr)
        	sb.append(s);
        String res = sb.toString();
        if(res.length() > 0 && res.charAt(0) == '0')
        	return "0";
        return res;

    }



}	
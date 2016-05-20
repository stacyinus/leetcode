/*
273. Integer to English Words

Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 - 1.

For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
*/

//2^31 -1 = 2,147,483,647
public class Solution {
	HashMap<Integer, String> map = getIntegerToStringMap();
    public String numberToWords(int num) {
        if(num == 0)
        	return "Zero";
        String result = "";
        int count = 0;
        while( num/1000 > 0 ){
        	int tmp = num % 1000;
        	if(tmp > 0)
	        	result = numberToWords(tmp, count) + " " + result;
        	num = num/1000;
        	count++;
        }
        if(num > 0)
        	result = numberToWords(num, count) + " " + result;
        return result.trim();
    }
    private String numberToWords(int tmp, int count){
    	String s = "";
    	if(tmp / 100 > 0){
    		s   = map.get(tmp / 100) + " " + "Hundred";
    		tmp = tmp % 100;
    	}
    	if(tmp / 10 > 1 ){
    		s  += " " + map.get(tmp - (tmp % 10));
    		tmp = tmp % 10;
    	}
    	if(tmp / 10 == 1 ){
    		s  += " " + map.get(tmp);
    		tmp = tmp / 100;
    	}
    	if(tmp > 0)
    		s += " " + map.get(tmp);
    	if(count == 1)
    		s += " " + "Thousand";
    	if(count == 2)
    		s += " " + "Million";
    	if(count == 3)
    		s += " " + "Billion";
    	return s.trim();
    }
    public HashMap<Integer, String> getIntegerToStringMap(){
    	HashMap<Integer, String> map = new HashMap<Integer, String>();
    	map.put(1, "One");
    	map.put(2, "Two");
    	map.put(3, "Three");
    	map.put(4, "Four");
    	map.put(5, "Five");
    	map.put(6, "Six");
    	map.put(7, "Seven");
    	map.put(8, "Eight");
    	map.put(9, "Nine");
    	map.put(10, "Ten");
    	map.put(11, "Eleven");
    	map.put(12, "Twelve");
    	map.put(13, "Thirteen");
    	map.put(14, "Fourteen");
    	map.put(15, "Fifteen");
    	map.put(16, "Sixteen");
    	map.put(17, "Seventeen");
    	map.put(18, "Eighteen");
    	map.put(19, "Nineteen");
    	map.put(20, "Twenty");
    	map.put(30, "Tirty");
    	map.put(40, "Forty");
    	map.put(50, "Fifty");
    	map.put(60, "Sixty");
    	map.put(70, "Seventy");
    	map.put(80, "Eighty");
    	map.put(90, "Ninety");
    	return map;
    }
}
/*
166. Fraction to Recurring Decimal

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
*/
//Test case: 0/2, 1/2, 2/3, 10/5,100/3,4/333,1/90
public class Solution {
    public String fractionToDecimal(int numerator1, int denominator1) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        boolean pos = (numerator1 < 0 && denominator1 < 0) || (numerator1 > 0 && denominator1 > 0 );
        if(!pos) sb.append("-");
        long numerator = Math.abs(numerator1);
        long denominator = Math.abs(denominator1);

        if(numerator<denominator && numerator != 0){
        	sb.append("0.");
        	numerator *= 10;
            map.put(numerator,sb.length());
        	while(numerator<denominator){
        		sb.append("0");
        		numerator *= 10;
        	}

        }
        int r = numerator % denominator;
        int t = numerator / denominator;           
        while(r != 0 && !map.containsKey(r)){
        	sb.append(String.valueOf(t));
        	numerator = r * 10;
        	if(sb.indexOf(".") == -1)
        		sb.append(".");
        	map.put(r,sb.length());	
        	while(numerator < denominator){
        		sb.append("0");
        		numerator *= 10;
        	}
        	r = numerator % denominator;
        	t = numerator / denominator;
        }
        sb.append(String.valueOf(t));
        if(r == 0)
        	return sb.toString();
        return sb.substring(0,map.get(r)) + "(" + sb.substring(map.get(r)) + ")";
    }
}
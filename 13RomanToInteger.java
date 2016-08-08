/*
13. Roman to Integer
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/
/*
    MCM XC VI = 1900 + 90 + 6
*/

public class Solution {
    //end to front
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int value = 0;
        int prev = 0;
        for(int i=s.length()-1;i>=0;i--){
        	int cur = map.get(s.charAt(i));
        	if(cur>=prev)
        		value = cur + value;
        	else
        		value = value - cur;
        	prev = cur;
        }
        return value;
    }

    //front to end
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0, i = 0;
        while (i < s.length()) {//IV
            int cur = map.get(s.charAt(i));
            int next = i == s.length() - 1 ? 0 : map.get(s.charAt(i + 1));
            if (cur < next) {
                cur = next - cur;
                i ++;
            }
            result += cur;
            i++;
        }
        
        return result;   
    }    
}
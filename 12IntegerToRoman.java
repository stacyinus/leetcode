/*
12. Integer to Roman

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/

public class 12IntegerToRoman {
    public String intToRoman(int num) {
    	int[] a = new int[]{1000,500,100,50,10,5,1};
    	String[] b= new String[]{"M","D","C","L","X","V","I"};
    	int i=0;
    	String r="";
    	while(i<a.length-1){
    		if(num/a[i]==1){
    			if(num/a[i+1]==9)
    				r+=b[i+1]+b[i-1];
    			else
    				r+=b[i];
    		}
    		else if(num/a[i]>1){
    			
    		}
    		i++;
    	}
         
    }
}
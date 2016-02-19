/*
12. Integer to Roman

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/

public class 12IntegerToRoman {
    public String intToRoman(int num) {
        String[] b= new String[]{"M","D","C","L","X","V","I"};
        int i=b.length-1;
        String r="";
        int d=0;
        while(num>0&&i>=0){
            d=num%10;
            String tmp ="";
            if (d==9){
                d-=9;
                tmp=b[i]+b[i-2];
            }
            if(d>=5){
                d-=5;
                tmp=b[i-1];
            }
            if(d==4){
                d-=4;
                tmp+=b[i]+b[i-1];
            }   
            if(d<4){
                for(int j=d;j>0;j--)
                    tmp+=b[i];                
            }
            if(!tmp.equals(""))
                r=tmp+r;
            i-=2;
            num/=10;
        }
        return r;
    }
}
/*
12. Integer to Roman

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/
/*
    special case: 9, 4
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
// I think this one is clearner.
public class Solution {
    public String intToRoman(int num) {
        String result = "";
        char[][] chart = new char[][]{{'I','V'},{'X','L'},{'C','D'},{'M','*'}};
        for (int i = 0; i < 4; i ++) {
            int tmp = num % 10;
            StringBuilder sb = new StringBuilder();
            if (tmp == 9) {
                sb.append(chart[i][0]).append(chart[i + 1][0]);
                tmp -= 9;
            }
            else if (tmp == 4) {
                sb.append(chart[i][0]).append(chart[i][1]);
                tmp -= 4;
            }
            else if (tmp >= 5) {
                sb.append(chart[i][1]);
                tmp -= 5;
            }
            while (tmp > 0) {
                sb.append(chart[i][0]);
                tmp--;
            }
            num /= 10;
            result = sb.toString() + result;
        }
        return result;
    }

}
/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

*/

public class 6ZigzagConversion {
    public String convert(String s, int numRows) {
    	StringBuilder[] sb = new StringBuilder[numRows];
    	for(int i=0;i<numRows;i++)
    		sb[i] = new StringBuilder();
        for(int i=0;i<s.length();){
        	for(int j=0;j<numRows&&i<s.length();j++)
        		sb[j].append(s.charAt(i++));
        	for(int j=numRows-2;j>0&&i<s.length();j--)
        		sb[j].append(s.charAt(i++));
        }
        for(int i=1;i<numRows;i++)
    		sb[0].append(sb[i]);
    	return(sb[0].toString());
    }
}
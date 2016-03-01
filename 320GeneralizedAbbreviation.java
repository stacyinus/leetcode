/*
320. Generalized Abbreviation
Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
*/

public class 320GeneralizedAbbreviation {
     public List<String> generateAbbreviations(String word) {
     	list<String> list = new ArrayList<String>();
     	char[] chars = word.toCharArray();
     	for(int n=0;n<chars.length;n++){
	     	generateAbbreviations(word, n, list);
	     	
     	}

     }
     private void generateAbbreviations(String word, int n, List<String> list ) {
     	if(n==0)
     		list.add(word);
     	for(int i=0;i<=chars.length-n;i++){
	     	list.add(word.substring(0,i+n-1) + Integer.toString(n) + word.substring(i+n));	    
	    } 
     }
}
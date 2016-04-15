/*
320. Generalized Abbreviation
Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
*/

public class 320GeneralizedAbbreviation {
     public List<String> generateAbbreviations(String word) {
     	List<String> list = new ArrayList<String>();
          generateAbbreviations(list, word, 1,0);
          return list;
     }
     private void generateAbbreviations(List<String> list， String word, int n, int pos ) {
          list.add(word);
          while(pos+n<=word.length()){
               for(int i=pos;i+n<=word.length();i++){
                    String firstPart = "", lastPart = "";
                    if(i>0)
                         firstPart = word.substring(０, i);
                    if(i<word.length()-1)
                         lastPart = word.substring(i+n,word.length());
                    String s =  firstPart +Integer.toString(n) + lastPart;
                    generateAbbreviations(list, s, n, i+2);
               }       
               n++;        
          }
     }
}
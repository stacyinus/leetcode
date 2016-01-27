/*
You are playing the following Flip Game with your friend: Given a string that contains only these 

two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". 

The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
 

If there is no valid move, return an empty list [].
*/

public class 293FlipGame{
	public ArrayList<String> getAllPossibleStates(String s){
		ArrayList<String> list = new ArrayList<String>(); 
		if(s==null||s.length()==0||s.length()==1)
			return list; 
		for(int i=0;i<s.length()-1;i++){
			if(s.substring(i,i+2).equals("++"))
				list.add(s.substring(0,i)+s.substring(i).replaceFirst("++","--"));
		}
		return list;
	}

}
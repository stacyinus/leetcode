/*
17. Letter Combinations of a Phone Number 

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/
public class Solution {
    public List<String> letterCombinations(String digits) {
    	List<String> list = new ArrayList<String>();
        if(digits==null||digits.length()==0)
        	return list;
        HashMap<Integer,List<String>> map = buildMap();
        char[] d = digits.toCharArray();
        for(int i=0;i<d.length;i++){
        	int tmp = d[i]-'0';
        	if(tmp>=2 && tmp<= 9){
        	 	List<String> tmpList = map.get(tmp);
        	 	if(list.size()==0){
        	 		list = tmpList;
        	 		continue;
        	 	}
        	 	List newList = new ArrayList<String>();
        	 	for(int j=0;j<list.size();j++){
        	 		for(int k=0;k<tmpList.size();k++)
        	 			newList.add(list.get(j)+tmpList.get(k));
        	 	}
        	 	list = newList;
        	}
        }
        return list;
    }
	private HashMap<Integer,List<String>> buildMap(){
		HashMap<Integer,List<String>> map = new HashMap<Integer,List<String>>();
		map.put(2,Arrays.asList(new String[]{"a","b","c"}));
		map.put(3,Arrays.asList(new String[]{"d","e","f"}));
		map.put(4,Arrays.asList(new String[]{"g","h","i"}));
		map.put(5,Arrays.asList(new String[]{"j","k","l"}));
		map.put(6,Arrays.asList(new String[]{"m","n","o"}));
		map.put(7,Arrays.asList(new String[]{"p","q","r","s"}));
		map.put(8,Arrays.asList(new String[]{"t","u","v"}));
		map.put(9,Arrays.asList(new String[]{"w","x","y","z"}));
		return map;
	}
}
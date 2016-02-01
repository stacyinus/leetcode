/*
249. Group Shifted Strings

Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
Return:
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
*/
public class 249GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
		HashMap<String,List<String>> map = new HashMap<String,List<String>>();
		for(int i=0;i<strings.length;i++){
			String s = shift(strings[i]);
			ArrayList<String> list;
			if(map.contains(s))
				list = map.get(s);
			else
				list = new ArrayList<String>();
			list.add(strings[i]);
			map.put(s,list);
		}
		return Arrays.asList(map.values());
	}
	private String shift(String s){
		if(s.length()==0) return "";
		int move = s.charAt(0)-'a';
		if(move==0) return s;
		StringBuilder sb = new StringBuilder();
		sb.append('a');
		for(int i=1;i<s.length();i++){
			char c = s.charAt(i)-move;
			if(c<'a')
				c=c+'a';
			sb.append(c);
		}
		return(sb.toString());
	}
}
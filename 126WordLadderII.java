/*
126. Word Ladder II 
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
	
*/
/*
	[[hit]]
	[[hit,hot]]
	[[hit,hot,dot][hit, hot, lot]]
	[[hit,hot,dot,dog][hit, hot, lot, log]]
	Use BFS, each time , 

*/

public class Solution {
    public List<List<String>> findLadders(String start, String end,
            Set<String> dict) {
        List<List<String>> ladders = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();

        dict.add(start);
        dict.add(end);
 
        bfs(map, distance, start, end, dict);
        
        List<String> path = new ArrayList<String>();
        
        dfs(ladders, path, end, start, distance, map);

        return ladders;
    }

    void dfs(List<List<String>> ladders, List<String> path, String crt,
            String start, Map<String, Integer> distance,
            Map<String, List<String>> map) {
        path.add(crt);
        if (crt.equals(start)) {
            Collections.reverse(path);
            ladders.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } else {
            for (String next : map.get(crt)) {
                if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) { 
                    dfs(ladders, path, next, start, distance, map);
                }
            }           
        }
        path.remove(path.size() - 1);
    }

    void bfs(Map<String, List<String>> map, Map<String, Integer> distance,
            String start, String end, Set<String> dict) {
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        distance.put(start, 0);
        for (String s : dict) {
            map.put(s, new ArrayList<String>());
        }
        
        while (!q.isEmpty()) {
            String crt = q.poll();

            List<String> nextList = expand(crt, dict);
            for (String next : nextList) {
                map.get(next).add(crt);
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(crt) + 1);
                    q.offer(next);
                }
            }
        }
    }

    List<String> expand(String crt, Set<String> dict) {
        List<String> expansion = new ArrayList<String>();

        for (int i = 0; i < crt.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != crt.charAt(i)) {
                    String expanded = crt.substring(0, i) + ch
                            + crt.substring(i + 1);
                    if (dict.contains(expanded)) {
                        expansion.add(expanded);
                    }
                }
            }
        }

        return expansion;
    }	

    // fXXX, i give up, it's always memory limit exceed....
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> result = new ArrayList<List<String>>();
        Queue<List<String>> queue = new LinkedList<List<String>>();
        List<String> list = new ArrayList<String>();
        list.add(beginWord);
        queue.offer(list);
        boolean end = false;
        while (queue.size() > 0) {
        	int size = queue.size();
        	for (int i = 0; i < size; i++ ) {
        		List<String> curList = queue.poll();
        		//System.out.println("size = " + size + "  curlist =" + Arrays.toString(curList.toArray()));
        		String curWord = curList.get(curList.size() - 1);//get last word in curList
        		//System.out.println("curWord = " + curWord );
        		Set<String> exclude = new HashSet<String>(curList);
                Set<String> curSet = new HashSet<String>(wordList);
                curSet.removeAll(exclude);
                //System.out.println("curSet = " + Arrays.toString(curSet.toArray()));
        		for (int j = 0; j < curWord.length(); j++) {
        			char c = curWord.charAt(j);
        			//System.out.println("c = " + c);
        			for (char k = 'a'; k <= 'z'; k++) {
        				if(c == k) continue;
        				String tmpString = replace(curWord,j,k);
                        if (tmpString.equals(endWord)) {
                            end = true;
                            List<String> copyList = new ArrayList<String>(curList);
                            copyList.add(tmpString);
                            result.add(copyList);
                            //System.out.println("result add " + Arrays.toString(copyList.toArray()));
                        }
        				else if (curSet.contains(tmpString)) {
        					List<String> copyList = new ArrayList<String>(curList);
        					copyList.add(tmpString);
                            queue.offer(copyList);
                            //System.out.println("queue add " + Arrays.toString(copyList.toArray()));
        				}
        			}	
        		}
        	}
            if (end) {
                return result;
            }            
        }
        return result;
    }
    private String replace(String str, int pos, char c){
    	char[] a = str.toCharArray();
    	a[pos] = c;
    	return new String(a);
    }    
}
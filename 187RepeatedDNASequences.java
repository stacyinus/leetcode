/*
187. Repeated DNA Sequences
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, 
it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].

*/

/*
    Track a sliding window substring of size 10, and keep the substring in a hashmap. if count == 1, add to final result.

    Todo: rolling hash. A=1, C=2, G=3, T=4. turn the number to 
*/

public class Solution {
    //Rolling Hash
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<String>();
        if (s == null || s.length() < 10) {
            return list;
        }
        HashMap<Character, Integer> dic = new HashMap<Character, Integer> ();
        dic.put('A', 0);
        dic.put('C', 1);
        dic.put('G', 2);
        dic.put('T', 3);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer> ();
        int num = 0;
        for (int i = 0; i < 10; i++) {
            num = (num << 2) + dic.get(s.charAt(i));
        }
        map.put(num, 1);
        int mask = (1 << 18) - 1;
        for (int i = 10 ; i < s.length(); i++) {
            num = ((num & mask) << 2 ) + dic.get(s.charAt(i));
            if (!map.containsKey(num)) {
                map.put(num, 1);
            }
            else if (map.get(num) == 1) {
                list.add(s.substring(i - 9, i + 1));
                map.put(num, map.get(num) + 1);
            }
            else {
                map.put(num, map.get(num) + 1);
            }

        }
        return list;

    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<String>();
        if (s == null || s.length() < 10) {
            return list;
        }
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0,10));
        map.put(s.substring(0,10), 1);
        int i = 0;
        while ( i + 10 < s.length() ) {
            sb.append(s.charAt(i + 10));
            String cur = sb.substring(i+1);
            if (!map.containsKey(cur)) {
                map.put(cur, 1);
            }
            else if (map.get(cur) == 1) {
                list.add(cur);
                map.put(cur, map.get(cur) + 1);
            }
            else {
                map.put(cur, map.get(cur) + 1);
            }
            i++;
        }
        return list;
    }
}
/*
第一轮实现分页显示。给了以下一些输入数据，要求将以下行分页显示，每页12行，其中每行已经按score排好序，分页显示的时候如果有相同host id的行，则将后面同host id的行移到下一页。

[

"host_id,listing_id,score,city",

"1,28,300.1,SanFrancisco",

"4,5,209.1,SanFrancisco",

"20,7,208.1,SanFrancisco",

"23,8,207.1,SanFrancisco",

"16,10,206.1,Oakland",

"1,16,205.1,SanFrancisco",

"6,29,204.1,SanFrancisco",

"7,20,203.1,SanFrancisco",

"8,21,202.1,SanFrancisco",

"2,18,201.1,SanFrancisco",

"2,30,200.1,SanFrancisco",

"15,27,109.1,Oakland",

"10,13,108.1,Oakland",

"11,26,107.1,Oakland",

"12,9,106.1,Oakland",

"13,1,105.1,Oakland",

"22,17,104.1,Oakland",

"1,2,103.1,Oakland",

"28,24,102.1,Oakland",

"18,14,11.1,SanJose",

"6,25,10.1,Oakland",

"19,15,9.1,SanJose",

"3,19,8.1,SanJose",

"3,11,7.1,Oakland",

"27,12,6.1,Oakland",

"1,3,5.1,Oakland",

"25,4,4.1,SanJose",

"5,6,3.1,SanJose",

"29,22,2.1,SanJose",

"30,23,1.1,SanJose"

]


*/


public class Solution {
  	public static void displayPages(List<String> input) {
  		HashSet<String> hostIds = new HashSet<String>();
  		List<String> buffer = ArrayList<String>();
  		int count = 0;
  		int page = 1;
  		for(int i=0;i<input.length;i++){
  			if(count==12)
  				count=0;
  			if(count==0){
  				hostIds.clear();
  				System.out.println("Page " + page++);
  				count = processBuffer(buffer,hostIds);
  			}
	  		String[] entry = input.get(i).split(",");
	  		if(!hostIds.contains(entry[0])){
	  			hostIds.add(entry[0]);
	  			System.out.println(input.get(i));
	  			count++;
	  		}
	  		else
	  			buffer.add(input.get(i));
  		}
  	}

  	private int processBuffer(List<String> buffer,HashSet<String> hostIds){
  		Iterator i = buffer.iterator();
  		int count = 0;
  		while(count<12&&i.hasNext()){
  			String entryString = i.next();
  			String[] entry = entryString.split(",");
  			if(!hostIds.contains(entry[0])){
  				hostIds.add(entry[0]);
  				System.out.println(entryString);
  				i.remove();
  				count++;
  			}
  		}
  		return count;
  	}

	public static void main(String[] args) {
    String[] strs = new String[]{
      "1,28,300.1,SanFrancisco",
      "4,5,209.1,SanFrancisco",
      "20,7,208.1,SanFrancisco",
      "23,8,207.1,SanFrancisco",
      "16,10,206.1,Oakland",
      "1,16,205.1,SanFrancisco",
      "6,29,204.1,SanFrancisco",
      "7,20,203.1,SanFrancisco",
      "8,21,202.1,SanFrancisco",
      "2,18,201.1,SanFrancisco",
      "2,30,200.1,SanFrancisco",
      "15,27,109.1,Oakland",
      "10,13,108.1,Oakland",
      "11,26,107.1,Oakland",
      "12,9,106.1,Oakland",
      "13,1,105.1,Oakland",
      "22,17,104.1,Oakland",
      "1,2,103.1,Oakland",
      "28,24,102.1,Oakland",
      "18,14,11.1,SanJose",
      "6,25,10.1,Oakland",
      "19,15,9.1,SanJose",
      "3,19,8.1,SanJose",
      "3,11,7.1,Oakland",
      "27,12,6.1,Oakland",
      "1,3,5.1,Oakland",
      "25,4,4.1,SanJose",
      "5,6,3.1,SanJose",
      "29,22,2.1,SanJose",
      "30,23,1.1,SanJose"
    };
    List<String> input = new ArrayList<>(Arrays.asList(strs));
    displayPages(input);
  }         	
  
}
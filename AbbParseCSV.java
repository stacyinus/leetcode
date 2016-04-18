/*
John,Smith,john.smith@gmail.com,Los Angeles,1
Jane,Roberts,janer@msn.com,"San Francisco, CA",0
"Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1
"""Alexandra Alex"""
John|Smith|john.smith@gmail.com|Los Angeles|1
Jane|Roberts|janer@msn.com|San Francisco, CA|0
Alexandra "Alex"|Menendez|alex.menendez@gmail.com|Miami|1
"Alexandra Alex"
*/

Class Solution{
	public static void parse(String file){
		int quote = 0;
		for(int i=0;i<file.length();i++){
			char c = file.charAt(i);
			if(c=='"')
				quote++;
			if(c==','&&quote%2!=0)
				

		}	
	}
}
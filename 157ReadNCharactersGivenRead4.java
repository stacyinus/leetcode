/*
157.Read N Characters Given Read4
The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
Note:
The read function will only be called once for each test case.
*/

/** The read4 API is defined in the parent class Reader4. int read4(char[] buf); */
 
public class 157ReadNCharactersGivenRead4 extends Reader4 {
/**
* @param buf 　Destination buffer
* @param n　　　Maximum number of characters to read
* @return　    The number of characters read
*/
	// read4 reads 4 characters from a file into "buf" char array, 
	//and implement a function that reads n characters from the file into "buf" char array.
    public int read(char[] buf, int n) {
    	if(n<=0)
    		return 0;
    	int read = 0;
    	char[] buffer = new char[4];
    	boolean eof = false;
    	int tmp = 0;
    	while(!(tmp<4)&&read<n){
    		tmp = read4(buffer);
    		int l = Math.min(tmp,n-read);//This is to prevent over-read
    		read+=l;
    		System.arraycopy(buffer,0,buf,read,l);
    	}
    	return read;
    }
}
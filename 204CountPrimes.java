/*
204. Count Primes 

Description:

Count the number of prime numbers less than a non-negative number, n.
*/
public class 204CountPrimes  {
    //refer to https://leetcode.com/problems/count-primes/ for hint. 
    //Sieve of Eratosthenes algorithm
    public int countPrimes(int n) {
        boolean[] x = new boolean[n];
        for(int i=2;i*i<n;i++){
            if(x[i]) continue;
            int j = 0;
            int index = i*i+j*i;
            while(index<n){
                x[index]=true;
                j++;
                index = i*i+j*i;
            }
        }
        int count = 0;
        for(int i=2;i<n;i++)
            if(!x[i])
                count++;
        return count;
    }

}
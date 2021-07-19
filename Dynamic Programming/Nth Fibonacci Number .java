// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution 
{
    static long nthFibonacci(long n)
    {
        // code here
        
        //I have used Tabulation Method..(..Dynamic Programming..)
        int N = (int)n;  // for index purpose..
        
        long dp[] = new long[N+2];
        
        dp[0]=0;  //0th value.
        dp[1]=1;  //1st value..
        
        int i;
        for(i=2;i<=N;i++)
        {
            dp[i] = (dp[i-1]+dp[i-2])%1000000007;  //for every value mod of 1000000007 as the value can be sometimes very big.
        }
        long val = dp[N]%1000000007;
        return val;  //return the nth value of the fibonacci series.
      
        /*int a=0,b=1,c;
        if(N==0)
        {
            return a;
        }
        for(int i=2;i<=n;i++)
        {
            c=a+b;
            a=b;
            b=c;
        }
        return b;*/
    }
}

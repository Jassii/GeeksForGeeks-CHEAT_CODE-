//////////////////////////////////////////////////////D Y N A M I C  P R O G R A M M I N G ///////////////////////////////////////////////////////////// 

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        int i,j;
        int n = str.length();
        //dynammic programming..
        
        int dp[][] = new int[n+1][n+1];
        
        for(i=0;i<=str.length();i++)
        {
            for(j=0;j<=str.length();j++)
            {
                if(i==0 || j==0) //base case..
                {
                    dp[i][j] = 0;
                }
                else if((str.charAt(i-1)==str.charAt(j-1)) && i!=j) //if character matches..
                {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}

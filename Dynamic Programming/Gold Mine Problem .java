// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} // } Driver Code Ends


//User function Template for Java

class Solution
{
    static int maxGold(int n, int m, int M[][])
    {
        // code here
        
        //create a dp array..
        int dp[][] = new int[n+1][m+1];  //(why thissssssssssss)
        
        int i,j;
        
        for(j=M[0].length-1;j>=0;j--)  //go to the last column and then move to the front.
        {
            for(i=0;i<M.length;i++)  //traverse all the rows in that column..
            {
                if(j==M[0].length-1)  //if it is a last column
                {
                    dp[i][j] = M[i][j];
                }
                else if(i==0)  //if it is a first row..
                {
                    dp[i][j] = M[i][j] + Math.max(dp[i][j+1],dp[i+1][j+1]);
                    //dp[i][j] = max;
                }
                else if(i==M.length-1)  //if it is a last row..
                {
                    dp[i][j] = M[i][j] + Math.max(dp[i][j+1],dp[i-1][j+1]);
                     //= max;
                }
                else//rest of it..now there will be three options..
                {
                    dp[i][j] = M[i][j] + Math.max(dp[i][j+1],Math.max(dp[i+1][j+1],dp[i-1][j+1]));
                }
            }
        }
        //now the maximum of the 0th column will be my answer..
        int maxx = dp[0][0];
        //will traverse the 0th column,
        for(i=1;i<n;i++)
        {
            if(dp[i][0]>maxx)
            {
                maxx = dp[i][0];
            }
            //max = Math.max(max,dp[i][0]);
        }
        return maxx;
    }
}

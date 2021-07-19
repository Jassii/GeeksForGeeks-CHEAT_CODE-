// { Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}// } Driver Code Ends


class Solution
{
    //Function to count number of ways to reach the nth stair.
    
    int countWays(int n)
    {
        // your code here
        
        //Tabulation Method..dynamic programming method..
        int dp[] = new int[n+1];
        int i;
        dp[0]=1;  //one way 
        dp[1]=1;  //one way
        //dp[2] = 2;  //two ways..
        
        for(i=2;i<=n;i++)
        {
            dp[i] = (dp[i-1]+dp[i-2])%1000000007;  //for every value mod operation.
        }
        
        return dp[n]%1000000007;
    
        
      //Memoiation Method.(recursive + memozation)
        
       /* int dp[] = new int[n+1];
        int i;
        
        int count = Count(n,dp);
        return count;
    }
    public int Count(int n,int dp[])
    {
        if(n==0)
        {
            return 1;
        }
        else if(n==1 || n==2)
        {
            return n;
        }
        if(dp[n]>0)//already solved
        {
            return dp[n];
        }
        int sum = Count(n-1,dp)+Count(n-2,dp);
        dp[n] = sum;
        return sum;*/
    }
}

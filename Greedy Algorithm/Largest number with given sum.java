// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		
	    while(t-- >0)
	    {
	        String inputLine[] = br.readLine().trim().split(" ");
	        
	        //taking n and sum
            int n = Integer.parseInt(inputLine[0]);
            int sum = Integer.parseInt(inputLine[1]);
            
            //calling largestNumber() function
            System.out.println(new Solution().largestNumber(n, sum));
	    }
    }
}// } Driver Code Ends




class Solution
{
    //Function to return the largest possible number of n digits
    //with sum equal to given sum.
    static String largestNumber(int n, int sum)
    {
        // add your code here
        int arr[] = new int[n];
        int i;
        for(i=0;i<n;i++)
        {
            if((sum-9)>=0)
            {
                arr[i]=9;
                sum = sum-9;
            }
            else
            {
                arr[i]=sum;
                sum=0;
                break;
            }
        }
        
        if(sum!=0)
        {
            return "-1";
        }
        
        String s="";
        for(i=0;i<n;i++)
        {
            s = s+arr[i];
        }
        return s;
    }
}

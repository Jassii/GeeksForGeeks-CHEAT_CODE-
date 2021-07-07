// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function Template for Java


class Solution
{
    
    /*  Function to calculate the longest consecutive ones
    *   N: given input to calculate the longest consecutive ones
    */
    public static int maxConsecutiveOnes(int N) 
    {
        // Your code here
        String s = Integer.toBinaryString(N);
        int i;
        int max=Integer.MIN_VALUE;
        int count=0;
        for(i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                count++;
                if(count>max)
                {
                    max=count;
                }
            }
            else
            {
                count=0;
            }
        }
        return max;
    }
}



// { Driver Code Starts.

class Main {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//input n
		    
		    Solution obj = new Solution();
		    
		    //calling maxConsecutiveOnes() function
		    System.out.println(obj.maxConsecutiveOnes(n));
		}
	}
}


  // } Driver Code Ends

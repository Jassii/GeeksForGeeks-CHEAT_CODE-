// Given an array of N integers. Your task is to print the sum of all of the integers.
 

// Example 1:

// Input:
// 4
// 1 2 3 4
// Output:
// 10
 

// Example 2:

// Input:
// 6
// 5 8 3 10 22 45
// Output:
// 93
 

// Your Task:  
// You don't need to read input or print anything. Your task is to complete the function getSum() which takes the array A[] and its size N as inputs and returns the sum of array in a new line.


// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(1)


// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.getSum(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    
    public long getSum(long a[], long n)
    {
        // Your code goes here
        long sum=0;
        int i;
        for(i=0;i<n;i++)
        {
            sum = sum + a[i];
        }
        return sum;
    }
}

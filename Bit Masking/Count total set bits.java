// You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).

// Example 1:

// Input: N = 4
// Output: 5
// Explanation:
// For numbers from 1 to 4.
// For 1: 0 0 1 = 1 set bits
// For 2: 0 1 0 = 1 set bits
// For 3: 0 1 1 = 2 set bits
// For 4: 1 0 0 = 1 set bits
// Therefore, the total set bits is 5.
// Example 2:

// Input: N = 17
// Output: 35
// Explanation: From numbers 1 to 17(both inclusive), 
// the total number of set bits is 35.

// Your Task: The task is to complete the function countSetBits() that takes n as a parameter and returns the count of all bits.

// Expected Time Complexity: O(log N).
// Expected Auxiliary Space: O(1).


// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;


 // } Driver Code Ends
//User function Template for Java

class Solution
{
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n)
    {
        // Your code here
        
        //BASIC APPROACH..OR..BRUTE FORCE APPROACH..
        /*int fcount=0;
        int i;
        for(i=1;i<=n;i++)
        {
            //using Brian Kernighans Algorithm to find the set bit of the number.
            int count=0;
            int k = i;
            while(k!=0)
            {
                int rsbm = k & -k;
                k = k-rsbm;
                count++;
            }
            fcount = fcount + count;
        }
        return fcount;*/
        
        
        //much optimized approach..
        //first find the max power of 2 number less than n..
        if(n==0)
        {
            return 0;
        }
        int x = largest_power_of_2_inrange(n);  //will recieve the power value..
        int bitsupto2raisx = x*(1 << (x-1));/*this is 2^(x-1)*/
        
        int msb2raisexton = n - (1 << x) + 1;  //last max set bits from 2^x till n.
        
        int remaining = n- (1<<x);
        int ans = bitsupto2raisx+msb2raisexton+countSetBits(remaining);
        return ans;
    }
    //largest power of x till n..
    public static int largest_power_of_2_inrange(int n)
    {
        int x=0; //this will tell about the power..
        while((1<<x)<=n)
        {
            x++;  
        }
        return x-1;  //as x was one more which made condition wrong..
    }
}

// { Driver Code Starts.

// Driver code
class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//testcases
		int x, n;
		while(t-->0) {
	        n = sc.nextInt();//input n

		    Solution obj = new Solution();

		    System.out.println(obj.countSetBits(n));//calling countSetBits() method
		}
	}
}
  // } Driver Code Ends

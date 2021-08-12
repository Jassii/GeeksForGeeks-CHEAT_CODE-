// Given an array arr[] of size n, find the first repeating element. The element should occurs more than once and the index of its first occurrence should be the smallest.

 

// Example 1:

// Input:
// n = 7
// arr[] = {1, 5, 3, 4, 3, 5, 6}
// Output: 2
// Explanation: 
// 5 is appearing twice and 
// its first appearence is at index 2 
// which is less than 3 whose first 
// occuring index is 3.

// Example 2:

// Input:
// n = 4
// arr[] = {1, 2, 3, 4}
// Output: -1
// Explanation: 
// All elements appear only once so 
// answer is -1.

// Your Task:
// You don't need to read input or print anything. Complete the function firstRepeated() which takes arr and n as input parameters and return the position of the first repeating element. If there is no such element, return -1.
// The position you return should be according to 1-based indexing. 

 

// Expected Time Complexity: O(nlogn)
// Expected Auxilliary Space: O(n)
// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //Taking input using class Scanner
		Scanner sc=new Scanner(System.in);
		
		//Taking total count of testcases
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    //taking total count of elements
		    int n=sc.nextInt();
		    
		    //creating a new array of size n
		    int arr[]=new int[n];
		    
		    //inserting elements to the array
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextInt();
		    }
		    Solution ob = new Solution();
		    //calling firstRepeated method 
		    //and printing the result
		    System.out.println(ob.firstRepeated(arr,n));
		}
		
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return the position of the first repeating element.
    public static int firstRepeated(int []arr, int n) 
    {
        //Your code here
        Map<Integer,Integer> M = new HashMap<>();
        
        int i;
        int index=-1;
        for(i=arr.length-1;i>=0;i--)
        {
            //insetead of using list i have simply used hashing and you can see
            //that i have got the output..
            //But in case of list time limit exceeded..
            
            if(M.containsKey(arr[i]))
            {
                index = i+1;
                M.put(arr[i],M.get(arr[i])+1);
            }
            else
            {
                M.put(arr[i],1);
            }
        }
        return index;
    }
}

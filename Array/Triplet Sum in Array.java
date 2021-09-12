// Given an array arr of size n and an integer X. Find if there's a triplet in the array which sums up to the given integer X.


// Example 1:

// Input:
// n = 6, X = 13
// arr[] = [1 4 45 6 10 8]
// Output:
// 1
// Explanation:
// The triplet {1, 4, 8} in 
// the array sums up to 13.
// Example 2:

// Input:
// n = 5, X = 10
// arr[] = [1 2 4 3 6]
// Output:
// 1
// Explanation:
// The triplet {1, 3, 6} in 
// the array sums up to 10.

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function find3Numbers() which takes the array arr[], the size of the array (n) and the sum (X) as inputs and returns True if there exists a triplet in the array arr[] which sums up to X and False otherwise.


// Expected Time Complexity: O(n2)
// Expected Auxiliary Space: O(1)

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int X = Integer.parseInt(inputLine[1]);
		    int A[] = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        A[i] = Integer.parseInt(inputLine[i]);
		    }
		    Solution ob=new Solution();
		    boolean ans = ob.find3Numbers(A, n, X);
		    System.out.println(ans?1:0);
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find if there exists a triplet in the 
    //array A[] which sums up to X.
    public static boolean find3Numbers(int A[], int n, int X) 
    { 
       // Your code Here
       
       //BRUTE FORCE APPROACH
       int i,j,k;
       for(i=0;i<n-2;i++)
       {
           for(j=i+1;j<n-1;j++)
           {
               for(k=i+2;k<n;k++)
               {
                   if(A[i]+A[j]+A[k]==X)
                   {
                       return true;
                   }
               }
           }
       }
       return false;
       
       /********************ANOTHER APPROACH USING SET.************************************/
       
       int i,j;
       for(i=0;i<n-2;i++)
       {
           //i have to create a set again and again..(for new triplets)..
           Set<Integer> set = new HashSet<>();
          
           //current (a+b+c=d)  (d-a-b)  inorder to find (c)..
           int current=X-A[i];
           for(j=i+1;j<n;j++)
           {
               if(set.contains(current-A[j])) //if set contains that difference.
               {
                   return true;  //then return true..
               }
               set.add(A[j]);  //other wise add that element in the index.
               //and check untill you find the triplets..
           }
       }
       return false;
    }
}

// Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears more than N/2 times in the array.
 

// Example 1:

// Input:
// N = 3 
// A[] = {1,2,3} 
// Output:
// -1
// Explanation:
// Since, each element in 
// {1,2,3} appears only once so there 
// is no majority element.
// Example 2:

// Input:
// N = 5 
// A[] = {3,1,3,3,2} 
// Output:
// 3
// Explanation:
// Since, 3 is present more
// than N/2 times, so it is 
// the majority element.

// Your Task:
// The task is to complete the function majorityElement() which returns the majority element in the array. If no majority exists, return -1.
 

// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(1).






// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
        // your code here
        /*if(size==1)
        {
            return a[0];
        }
        Map<Integer,Integer> M = new HashMap<>();
        int i;
        for(i=0;i<size;i++)
        {
            if(M.containsKey(a[i]))
            {
                M.put(a[i],M.get(a[i])+1);
            }
            else
            {
                M.put(a[i],1);
            }
        }
        int max = Integer.MIN_VALUE;
        int key=-1;
        for(Map.Entry<Integer,Integer> entry:M.entrySet())
        {
            if(entry.getValue()>size/2 && entry.getValue()>max)
            {
            max = entry.getValue();
            key = entry.getKey();
            }
        }
        if(max==Integer.MIN_VALUE)
        {
            return -1;
        }
        return key;*/
        
        
        //ANOTHER METHOD..
        
        /*if(size==1)
        {
            return a[0];
        }
        Arrays.sort(a);
        int i;
        int count=1;
        for(i=1;i<size;i++)
        {
            if(a[i]==a[i-1])
            {
               count++;
               if(count>size/2)
               {
                   return a[i];
               }
            }
            else
            {
                count=1;
            }
        }
        return -1;*/
    }
}

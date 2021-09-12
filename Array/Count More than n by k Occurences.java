// Given an array arr[] of size N and an element k. The task is to find all elements in array that appear more than n/k times.

// Example 1:

// Input:
// N = 8
// arr[] = {3,1,2,2,1,2,3,3}
// k = 4
// Output: 2
// Explanation: In the given array, 3 and
//  2 are the only elements that appears 
// more than n/k times.
// Example 2:

// Input:
// N = 4
// arr[] = {2,3,3,2}
// k = 3
// Output: 2
// Explanation: In the given array, 3 and 2 
// are the only elements that appears more 
// than n/k times. So the count of elements 
// are 2.
// Your Task:
// The task is to complete the function countOccurence() which returns count of elements with more than n/k times appearance.

// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(N).

// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            System.out.println(new Solution().countOccurence(arr, n, k));
        }
    }
}
// } Driver Code Ends




class Solution 
{
    //Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k) 
    {
        // your code here,return the answer
        
        //will be using the concept of Hashing..so that
        //the problem can be executed in **O(n)** time complexity..
        
        int count=0;  //number of elements..
        Map<Integer,Integer> M = new HashMap<>();  //(number,count)
        
        int i;
        for(i=0;i<n;i++)
        {
            int val=arr[i];
            if(!M.containsKey(val))
            {
                M.put(val,1);
            }
            else
            {
                M.put(val,M.get(val)+1);
            }
        }
        
        //now will be traversing the map..and whose count is more than n/k times
        //will increase the count..
        
        for(Map.Entry<Integer,Integer> entry:M.entrySet())
        {
            if(entry.getValue()>(int)(n/k))
            {
                count++;
            }
        }
        return count;
    }
}

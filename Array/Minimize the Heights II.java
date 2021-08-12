// Given an array arr[] denoting heights of N towers and a positive integer K, you have to modify the height of each tower either by increasing or decreasing them by K only once. After modifying, height should be a non-negative integer. 
// Find out what could be the possible minimum difference of the height of shortest and longest towers after you have modified each tower.

// A slight modification of the problem can be found here.


// Example 1:

// Input:
// K = 2, N = 4
// Arr[] = {1, 5, 8, 10}
// Output:
// 5
// Explanation:
// The array can be modified as 
// {3, 3, 6, 8}. The difference between 
// the largest and the smallest is 8-3 = 5.
// Example 2:

// Input:
// K = 3, N = 5
// Arr[] = {3, 9, 12, 16, 20}
// Output:
// 11
// Explanation:
// The array can be modified as
// {6, 12, 9, 13, 17}. The difference between 
// the largest and the smallest is 17-6 = 11. 

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function getMinDiff() which takes the arr[], n and k as input parameters and returns an integer denoting the minimum difference.


// Expected Time Complexity: O(N*logN)
// Expected Auxiliary Space: O(N)
// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, n, k);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution 
{
    int getMinDiff(int[] arr, int n, int k) 
    {
        // code here
        
        //first sort the array ..even it is already sorted..sort it again.
        Arrays.sort(arr);
        
        int result = arr[n-1]-arr[0];  //max difference we can get(b-a)..
        int i,maxE=0,minE=0;
        for(i=1;i<=n-1;i++)
        {
            if(arr[i]>=k)
            {
                maxE = Math.max(arr[i-1]+k,arr[n-1]-k);
                minE = Math.min(arr[0]+k,arr[i]-k);
                
                result = Math.min(result,maxE-minE);
            }
        }
        return result;
    }
}

// Given a boolean 2D array of n x m dimensions where each row is sorted. Find the 0-based index of the first row that has the maximum number of 1's.

// Example 1:

// Input: 
// N = 4 , M = 4
// Arr[][] = {{0, 1, 1, 1},
//            {0, 0, 1, 1},
//            {1, 1, 1, 1},
//            {0, 0, 0, 0}}
// Output: 2
// Explanation: Row 2 contains 4 1's (0-based
// indexing).

// Example 2:

// Input: 
// N = 2, M = 2
// Arr[][] = {{0, 0}, {1, 1}}
// Output: 1
// Explanation: Row 1 contains 2 1's (0-based
// indexing).

// Your Task:  
// You don't need to read input or print anything. Your task is to complete the function rowWithMax1s() which takes the array of booleans arr[][], n and m as input parameters and returns the 0-based index of the first row that has the most number of 1s. If no such row exists, return -1.
 

// Expected Time Complexity: O(N+M)
// Expected Auxiliary Space: O(1)
  
// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int rowWithMax1s(int arr[][], int n, int m) 
    {
        // code here
        
        //Brute Force Approach..
        /*int max=0,index=-1;
        int i,j;
        for(i=0;i<n;i++)
        {
            int count=0;
            for(j=0;j<m;j++)
            {
                if(arr[i][j]==1)
                {
                    count++;
                }
            }
            if(count>max)
            {
                max = Math.max(max,count);
                index = i;
            }
        }
        if(index==-1)
        {
            return -1;
        }
        return index;*/
        
        
        //Optimised Approach..
        //using binary search..
        
        /*int i=0,index=-1;
        int ans=Integer.MAX_VALUE;
        for(i=0;i<n;i++)
        {
            boolean one = false;
            int l=0,h=m-1;
            while(l<=h)
            {
                int mid = l + (h-l)/2;  //middle index..
                //if element at (i,mid) is 1..then it means that its right side
                //will be one..but out main motive is to find the first index of the
                //1 of each row..
                if(arr[i][mid]==1)  
                {
                    //so that this should run for one time only.
                    if(one!=true)
                    {
                        one = true;
                    }
                    
                    h = mid-1;
                }
                else
                {
                    l = mid+1; //at the end this will contain the first position of 1.
                }
            }
            if(one==true)  //that in a row ..1 is there or not..
            {
                if(l<ans)  //if it is less than the ans..update ans and index..both
                {
                    ans=l;//this has stored the first index of 1..
                    index= i; //update the index too..
                }
            }
        }
        return index;*/
        
        //Another Better Approach....from the earlier one..
        //log(m+n)...time complexity.
        
        int i,j;
        int col=m-1; //pointing the last column.
        int row=-1;
        //traversing the matrix row by row..
        for(i=0;i<n;i++)
        {
            
            for(j=col;j>=0;j--)
            {
                if(arr[i][j]==1)
                {
                    row=i;  //can be a winner..
                    //we will skip this column..as we havw got 1 in that row..
                    col--;
                }
                else //if it doesn't matches..then simply break that row..and move
                //to the next row..
                {
                    break;
                }
            }
        }
        //base condition that the matrix no one's..
        if(row==-1)
        {
            return -1;
        }
        return row;
    }
}

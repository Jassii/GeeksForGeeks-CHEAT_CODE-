// Given an NxN matrix Mat. Sort all elements of the matrix.

// Example 1:

// Input:
// N=4
// Mat=[[10,20,30,40],
// [15,25,35,45] 
// [27,29,37,48] 
// [32,33,39,50]]
// Output:
// 10 15 20 25 
// 27 29 30 32
// 33 35 37 39
// 40 45 48 50
// Explanation:
// Sorting the matrix gives this result.
// Example 2:

// Input:
// N=3
// Mat=[[1,5,3],[2,8,7],[4,6,9]]
// Output:
// 1 2 3 
// 4 5 6
// 7 8 9
// Explanation:
// Sorting the matrix gives this result.
// Your Task:
// You don't need to read input or print anything. Your task is to complete the function sortedMatrix() which takes the integer N and the matrix Mat as input parameters and returns the sorted matrix.


// Expected Time Complexity:O(N2LogN)
// Expected Auxillary Space:O(N2)

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            int v[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < N; j++) v[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            int ans[][] = ob.sortedMatrix(N, v);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution 
{
    int[][] sortedMatrix(int N, int arr[][]) 
    {
        // code here
     
        //My main motive is to sort the matrix..
        int i,j;
        
        int temp[] = new int[N*N];
        
        int k=0;
        for(i=0;i<N;i++)
        {
            for(j=0;j<N;j++)
            {
                temp[k] = arr[i][j];
                k++;
            }
        }
        
        //sort the temp array.
        Arrays.sort(temp);
        
        k=0;
        for(i=0;i<N;i++)
        {
            for(j=0;j<N;j++)
            {
                arr[i][j] = temp[k];
                k++;
            }
        }
        //now we have got the matrix in which all elements are sorted..
        return arr;
    }
}

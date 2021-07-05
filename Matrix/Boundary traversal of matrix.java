// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            int matrix[][] = new int[n][m];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.boundaryTraversal(matrix, n, m);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        // code here 
        
        ArrayList<Integer> bt = new ArrayList<>();
        int i;
        if(n==1)  //only one row.
        {
            for(i=0;i<m;i++)
            {
                bt.add(matrix[0][i]);
            }
            return bt;
        }
        else if(m==1)  //if only one column is there..
        {
            for(i=0;i<n;i++)
            {
                bt.add(matrix[i][0]);
            }
            return bt;
        }
        else  //when more than one row and column is there..
        {
            //first row
            for(i=0;i<m;i++)
            {
                bt.add(matrix[0][i]);
            }
            //last column
            for(i=1;i<n;i++)
            {
                bt.add(matrix[i][m-1]);
            }
            //last row.
            for(i=m-2;i>=0;i--)
            {
                bt.add(matrix[n-1][i]);
            }
            //first column.
            for(i=n-2;i>0;i--)
            {
                bt.add(matrix[i][0]);
            }
        }
        return bt;
    }
}

// { Driver Code Starts
//Initial Template for Java

import java.util.*; 
import java.io.*;
import java.lang.*;

class GFG
{
	public static void main(String[] args) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] matrix = new int[n][m];
            
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    matrix[i][j] = sc.nextInt();
            
            Solution ob = new Solution();
            ob.diagonalSort(matrix,n,m);
            printMatrix (matrix);
        }
	} 
	
	static void printMatrix(int arr[][]) 
	{ 
		for (int i = 0; i < arr.length; i++) { 
			for (int j = 0; j < arr[0].length; j++) 
				System.out.print(arr[i][j] + " "); 
			System.out.println(""); 
		} 
	} 
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    void diagonalSort(int matrix[][], int n, int m)
    {
        // code here
        int i,j;
        //Our first motive is to create a lower triangle list and 
        //upper triangle list and major list..
        ArrayList<ArrayList<Integer>> lowerT = new ArrayList<>();
        ArrayList<ArrayList<Integer>> upperT = new ArrayList<>();
        
        for(i=0;i<n;i++)
        {
            ArrayList<Integer> empty = new ArrayList<>();
            lowerT.add(empty);
        }
        for(i=0;i<m;i++)
        {
            ArrayList<Integer> empty = new ArrayList<>();
            upperT.add(empty);
        }
        
        ArrayList<Integer> majorL = new ArrayList<>();
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(j<i)
                {
                    lowerT.get(i-j).add(matrix[i][j]);
                }
                else if(j>i)
                {
                    upperT.get(j-i).add(matrix[i][j]);
                }
                else
                {
                    majorL.add(matrix[i][j]);
                }
            }
        }
        //now sort each list of upperT in descending order
        for(i=0;i<upperT.size();i++)
        {
            Collections.sort(upperT.get(i),Collections.reverseOrder());
        }
        //now sort each list of lowerT in ascending order
        for(i=0;i<lowerT.size();i++)
        {
            Collections.sort(lowerT.get(i));
        }
        
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(j<i)
                {
                    matrix[i][j] = lowerT.get(i-j).get(0);
                    lowerT.get(i-j).remove(0);
                }
                else if(j>i)
                {
                    matrix[i][j] = upperT.get(j-i).get(0);
                    upperT.get(j-i).remove(0);
                }
                else
                {
                    matrix[i][j] = majorL.get(0);
                    majorL.remove(0);
                }
            }
        }
    }
}

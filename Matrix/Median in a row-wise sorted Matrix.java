// Given a row wise sorted matrix of size RxC where R and C are always odd, find the median of the matrix.

// Example 1:

// Input:
// R = 3, C = 3
// M = [[1, 3, 5], 
//      [2, 6, 9], 
//      [3, 6, 9]]

// Output: 5

// Explanation:
// Sorting matrix elements gives us 
// {1,2,3,3,5,6,6,9,9}. Hence, 5 is median. 
 

// Example 2:

// Input:
// R = 3, C = 1
// M = [[1], [2], [3]]
// Output: 2

// Your Task:  
// You don't need to read input or print anything. Your task is to complete the function median() which takes the integers R and C along with the 2D matrix as input parameters and returns the median of the matrix.

// Expected Time Complexity: O(32 * R * log(C))
// Expected Auxiliary Space: O(1)


// Constraints:
// 1<= R,C <=150
// 1<= matrix[i][j] <=2000
// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            String line[] = read.readLine().trim().split("\\s+");
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[c++]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int median(int matrix[][], int r, int c) 
    {
        // code here
        
        //One approach..
       /*ArrayList<Integer> arr = new ArrayList<>();
       int i,j;
       for(i=0;i<r;i++)
       {
           for(j=0;j<c;j++)
           {
               arr.add(matrix[i][j]);
           }
       }
        Collections.sort(arr); //sort the array list
        int mI = arr.size()/2;
        return arr.get(mI);*/
        
        //Another approach..Using Binary Search..
        
        int end = 2000;
        int start = 0;
        int n = r*c; //number of elements..
        int mid=0;
        while(start<=end)
        {
            mid = (start+end)/2;  
            //now i have to find the number of elements which are less than the mid.
            int i;
            int ans=0; //this will store the count..
            for(i=0;i<r;i++)
            {
                int l=0,h=c-1; //index wise..
                while(l<=h)
                {
                    int m = l + (h-l)/2;
                    if(matrix[i][m]<=mid)
                    {
                        l = m+1;
                    }
                    else
                    {
                        h = m-1;
                    }
                }
                ans +=l;
            }
            if(ans<=n/2)
            {
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        return start;
    }
}

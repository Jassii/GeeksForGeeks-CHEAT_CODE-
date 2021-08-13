// Given a matrix of size r*c. Traverse the matrix in spiral form.

// Example 1:

// Input:
// r = 4, c = 4
// matrix[][] = {{1, 2, 3, 4},
//            {5, 6, 7, 8},
//            {9, 10, 11, 12},
//            {13, 14, 15,16}}
// Output: 
// 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
// Explanation:

// Example 2:

// Input:
// r = 3, c = 4  
// matrix[][] = {{1, 2, 3, 4},
//            {5, 6, 7, 8},
//            {9, 10, 11, 12}}
// Output: 
// 1 2 3 4 8 12 11 10 9 5 6 7
// Explanation:
// Applying same technique as shown above, 
// output for the 2nd testcase will be 
// 1 2 3 4 8 12 11 10 9 5 6 7.

// Your Task:
// You dont need to read input or print anything. Complete the function spirallyTraverse() that takes matrix, r and c as input parameters and returns a list of integers denoting the spiral traversal of matrix. 

// Expected Time Complexity: O(r*c)
// Expected Auxiliary Space: O(r*c), for returning the answer only.

// { Driver Code Starts
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
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int f, int e)
    {
        // code here 
        if(f==0 && e==0)
        {
            return new ArrayList<>(); //return the empty list.
        }
        
        
        
        ArrayList<Integer> list = new ArrayList<>(); //final list.
        
        int r1,r2,c1,c2;
        
        r1=0;  //top to bottom.
        r2=f-1; //bottom to top..
        c1=0; //left to right.
        c2=e-1; //right to left..
        
        while(r1<=r2 && c1<=c2)  //this has to be there..to consider all the elements..
        {
          //for first row.
            for(int c=c1;c<=c2;c++)
            {
                list.add(matrix[r1][c]);
            }
          
          //for last column..
            for(int r=r1+1;r<=r2;r++)
            {
                list.add(matrix[r][c2]);
            }
          //condition to check if next row or next column is there or not..
            if(r1<r2 && c1<c2)
            {
              //this is for the last row.
                for(int c=c2-1;c>=c1;c--)
                {
                    list.add(matrix[r2][c]);
                }
              //this is for the first column..
                for(int r=r2-1;r>r1;r--)
                {
                    list.add(matrix[r][c1]);
                }
            }
          //increase r1 and c2----and---decrease r2 and c2....as they have already been traversed..
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return list;
    }
}

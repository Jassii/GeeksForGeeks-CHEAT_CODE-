// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution 
{
    ArrayList<Long> nthRowOfPascalTriangle(int n) 
    {
        // code here
        ArrayList<ArrayList<Long>> list = new ArrayList<>(); //list of list.. 
        
        //Basic condition..
        if(n==0)
        {
            return new ArrayList<>();  //return empty list..
        }
        
        ArrayList<Long> first_row = new ArrayList<>();
        first_row.add((long)1);  //this tells about the first row..
        
        list.add(first_row);  //add the first row..  
        int i,j;
        
        //till where we have to traverse..(already first row inserted..)
        for(i=1;i<n;i++)
        {
            //we grab the previous row or list.
            ArrayList<Long> prev = list.get(i-1);  //before list(i-1)
            
            ArrayList<Long> curr = new ArrayList<>();  //current row..or list
            
            //if you can see that the first and the last element is 1..for every row.
            //curr.add((long)1);
            
            //this is actually for the number of elements in the list..
            for(j=0;j<=i;j++)  
            {
                if(j==i || j==0)  //if its first and the last..value..
                {
                    curr.add((long)1);
                }
                else  //if not add the value..
                {
                    curr.add(( prev.get(j-1) + prev.get(j))%1000000007);
                }
            }
            list.add(curr);
        }
        return list.get(n-1);
    }
}

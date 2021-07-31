// Consider a sample space S consisting of all perfect squares starting from 1, 4, 9 and so on. You are given a number N, you have to output the number of integers less than N in the sample space S.

 

// Example 1:

// Input :
// N = 9
// Output:
// 2
// Explanation:
// 1 and 4 are the only Perfect Squares
// less than 9. So, the Output is 2.
// Example 2:

// Input :
// N = 3
// Output:
// 1
// Explanation:
// 1 is the only Perfect Square
// less than 3. So, the Output is 1.
 

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function countSquares() which takes an Integer N as input and returns the answer.

 

// Expected Time Complexity: O(sqrt(N))
// Expected Auxiliary Space: O(1)



// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countSquares(N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    static int countSquares(int N) 
    {
        // code here
        
        //done the square in the for loop only..
        /*int count=0;
        int i;
        for(i=1;i*i<N;i++)
        {
            count++;  //increase the count..
        }
        return count;*/
        
        //optimised approach..
        
        //There are sqrt(n) perfect squares between 1 and n..
        return (int)Math.floor(Math.sqrt(N-1));  //done n-1 because n is not included..
    }
}

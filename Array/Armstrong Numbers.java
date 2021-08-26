// For a given 3 digit number, find whether it is armstrong number or not. An Armstrong number of three digits is an integer such that the sum of the cubes of its digits is equal to the number itself. Return "Yes" if it is a armstrong number else return "No".
// NOTE: 371 is an Armstrong number since 33 + 73 + 13 = 371

// Example 1:

// Input: N = 153
// Output: "Yes"
// Explanation: 153 is an Armstrong number
// since 13 + 53 + 33 = 153.
// Hence answer is "Yes".
// Example 2:

// Input: N = 370
// Output: "Yes"
// Explanation: 370 is an Armstrong number
// since 33 + 73 + 03 = 370.
// Hence answer is "Yes".

// Your Task:  
// You dont need to read input or print anything. Complete the function armstrongNumber() which takes n as input parameter and returns "Yes" if it is a armstrong number else returns "No"..

// Expected Time Complexity: O(1)
// Expected Auxiliary Space: O(1)

// { Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution 
{
    static String armstrongNumber(int n)
    {
        // code here
        int k=n;
        int sum=0;
        while(k>0)
        {
            int l=k%10;  //last digit..
            sum = sum + l*l*l;;
            k = k/10;
        }
        if(sum==n)
        {
            return "Yes";
        }
        return "No";
    }
}

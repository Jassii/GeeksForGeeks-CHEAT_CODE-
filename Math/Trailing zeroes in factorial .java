// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


//very importtant question..

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();
			
            Solution ob = new Solution();
            int ans  = ob.trailingZeroes(N);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    static int trailingZeroes(int N)
    {
        // Write your code here
        //no use of using BigInteger Class..
        
        int count=0;
        int j=5;  //Number having 0 will be divisible by 5.
        while(j<=N)
        {
            count = count + N/j;
            j = j*5;
        }
        return count;
    }
}

// { Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();

            Solution ob = new Solution();
            int cnt = ob.setBits(N);
            System.out.println(cnt);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution 
{
    static int setBits(int N) 
    {
        // code here
        String s = Integer.toBinaryString(N);  //into binary string.
        int i,count=0;
        
        //basinc stupid way to solve this program..
        /*for(i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                count++;
            }
        }
        return count;*/
        
        
        //Kerninghan's algorithm..much better approach..to solve this approach..
        while(N!=0)
        {
            int rsbm = N&-N;
            N = N-rsbm;
            count++;
        }
        return count;
    }
}

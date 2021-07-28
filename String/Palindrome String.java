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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPlaindrome(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int isPlaindrome(String S) 
    {
        // code here
        
        //you could have also done by taking String Buffer..
        
        char ch[] = S.toCharArray();
        int start=0;
        int end=ch.length-1;
        while(start<end)
        {
            char c = ch[start];
            ch[start] = ch[end];
            ch[end] = c;
            start++;
            end--;
        }
        
        String str = new String(ch);
        if(str.equals(S))
        {
            return 1;
        }
        return 0;
    }
}

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
            System.out.println(ob.findMaxLen(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution 
{
    static int findMaxLen(String S) 
    {
        // code here
        int i;
        int count=0;
        
        if(S.length()==0)
        {
            return count;
        }
        Stack<Integer> s = new Stack<>();
        s.push(-1);  
        int result=0;
        for(i=0;i<S.length();i++)
        {
            if(S.charAt(i)=='(')
            {
                s.push(i);  //push that index.
            }
            else
            {
                if(!s.isEmpty())
                {
                    s.pop();
                }
                if(!s.isEmpty())
                {
                    result = Math.max(result,i-s.peek());
                }
                else
                {
                    s.push(i);
                }
            }
        }
       return result;
    }
}

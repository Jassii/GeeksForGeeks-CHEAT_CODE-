// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}// } Driver Code Ends




class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // add your code here
        
        Stack<Character> stack = new Stack<>();
        char ch[] = x.toCharArray();
        int i;
        for(i=0;i<ch.length;i++)
        {
            if(ch[i]=='(' || ch[i]=='{' || ch[i]=='[')
            {
                stack.push(ch[i]);
            }
            
            
            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if(stack.isEmpty())
            {
                return false;
            }
            
            
            else if(ch[i]==')')
            {
                if(stack.pop()!='(')
                {
                    return false;
                }
            }
            else if(ch[i]=='}')
            {
                if(stack.pop()!='{')
                {
                    return false;
                }
            }
            else if(ch[i]==']')
            {
                if(stack.pop()!='[')
                {
                    return false;
                }
            }
            else
            {
                continue;
            }
        }
        if(stack.isEmpty())
        {
            return true;
        }
        return false;
    }
}

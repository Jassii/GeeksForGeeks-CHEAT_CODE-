// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().infixToPostfix(br.readLine().trim()));
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to convert an infix expression to a postfix expression.
	public static String infixToPostfix(String exp) 
	{
		// Your code here
		String res = "";
		Stack<Character> s = new Stack<>();
		int i;
		for(i=0;i<exp.length();i++)
		{
		    char c = exp.charAt(i);  //particular character.
		    
		    if(c>='a' && c<='z') //if it is an aplhabet
		    {
		        res = res+c;  //add it to the string.
		    }
		    
		    else if(c=='(')  
		    {
		        s.push(c);
		    }
		    else if(c==')')  //if it is a closing brace..then simply pop untill '('..
		    {
		        while(!s.isEmpty() && s.peek()!='(')
		        {
		                res = res+s.peek();
		                s.pop();
		        }
		        //for removing '('...
		        if(!s.isEmpty())
		        {
		            s.pop();
		        }
		    }
		    else
		    {
		        while(!s.isEmpty() && priority(s.peek())>=priority(c))
		        {
		            res = res+s.peek();
		            s.pop();
		        }
		        s.push(c);
		    }
		}
		    
		while(!s.isEmpty())
		{
		    res = res + s.peek();
		    s.pop();
		}
		return res;
	} 
	public static int priority(char a)
	{
	    if(a=='^')
	    {
	        return 3;
	    }
	    else if(a=='*' || a=='/')
	    {
	        return 2;
	    }
	    else if(a=='+' || a=='-')
	    {
	        return 1;
	    }
	    return -1;
	}
}

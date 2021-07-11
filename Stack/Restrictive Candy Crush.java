// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.math.*;
import java.io.*;

class FastReader{ 
	BufferedReader br; 
	StringTokenizer st; 

	public FastReader(){ 
		br = new BufferedReader(new InputStreamReader(System.in)); 
	} 

	String next(){ 
		while (st == null || !st.hasMoreElements()){ 
			try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
		} 
		return st.nextToken(); 
	} 

	String nextLine(){ 
		String str = ""; 
		try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
		return str; 
	} 
} 

class Gfg
{
    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int k = Integer.parseInt(sc.next());
            String s = sc.next();
            Solution T = new Solution();
            out.println(T.reduced_String(k, s));
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

/*
    Note: Use StringBuilder/StringBuffer class for String concatenation(if any).
    While using String class, on each concatenation a new copy of the string is created, so that 
    the overall complexity is O(n^2) . Fortunately in Java we could solve this with a StringBuffer/StringBuffer, 
    which has O(1) complexity for each append.
*/

class Pair
{
    int val;
    char c;
    Pair(char c,int val)
    {
        this.c = c;
        this.val=val;
    }
}

class Solution
{
    public static String reduced_String(int k, String s)
    {
        // Your code goes here
        if(k==1)
        {
            String ans = "";
            return ans;
        }
        Stack<Pair> st = new Stack<>();
       int l = s.length();
       int count=0;
       int i;
       for(i=0;i<l;i++)
       {
           if(st.size()==0)  //for empty stack.
           {
               st.push(new Pair(s.charAt(i),1));
               continue;
           }
           if(st.peek().c==s.charAt(i))
           {
               Pair p = st.peek();
               st.pop();
               p.val = p.val+1;
               if(p.val==k)
               {
                   continue;
               }
               else
               {
                   st.push(p);
               }
           }
           else
           {
               st.push(new Pair(s.charAt(i),1));
           }
       }
       
       StringBuffer str = new StringBuffer();
       while(!st.isEmpty())
       {
           char c = st.peek().c;
           count = st.peek().val;
           while(count>0)
           {
               str.append(c);
               count--;
           }
           st.pop();
       }
       str.reverse();
       String S = str.toString();
       return S;
    }
}

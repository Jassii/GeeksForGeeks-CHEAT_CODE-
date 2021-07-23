// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- >0)
        {
            String str = read.readLine();
            System.out.println(new Reverse().reverseWord(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
    {
        // Reverse the string str
        if(str.length()==1)
        {
            return str;
        }
        
        char ch[] = str.toCharArray();
        int start=0;
        int end=ch.length-1;
        while(start<end)  //swapping is done..
        {
            char t = ch[start];
            ch[start] = ch[end];
            ch[end] = t;
            start++;
            end--;
        }
        str = new String(ch);
        return str;
    }
}

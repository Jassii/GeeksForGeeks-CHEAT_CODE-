// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


 // } Driver Code Ends
//User function Template for Java

class Solution
{
    public int reverseBits(int n)
    {
        //code here
        String s = Integer.toBinaryString(n);
        char ch[] = s.toCharArray();
        int start=0;
        int end = ch.length-1;
        while(start<end)
        {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
       s = new String(ch);  
       int val = Integer.parseInt(s,2);
       return val;
    }
}

// { Driver Code Starts.

class BitWise
{
	static int n;
	static int k;
	
	// Driver Code
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); //Inputting the testcases
		
		while(t>0) //While testcases exist
		{
			
			n = Integer.parseInt(br.readLine()); //Input N
			
			Solution obj = new Solution();
			
			System.out.println(obj.reverseBits(n));
            
            t--;
		}
		
		br.close();
	}
	
	
}  // } Driver Code Ends

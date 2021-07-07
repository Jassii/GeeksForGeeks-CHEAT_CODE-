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
    int sum(int a , int b)
    {
        //code here
        return Integer.sum(a,b);
    }
}

// { Driver Code Starts.

class BitWise
{
	
	
	// Driver Code
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); //Inputting the testcases
		
		while(t>0) //While testcases exist
		{
			
		  String S[] = br.readLine().split(" ");
            
            int a = Integer.parseInt(S[0]);
            int b = Integer.parseInt(S[1]);
            
			
			Solution obj = new Solution();
			
			System.out.println(obj.sum(a,b));
            
            t--;
		}
		
		br.close();
	}
	
	
}  // } Driver Code Ends

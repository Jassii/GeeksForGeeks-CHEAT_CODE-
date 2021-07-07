// { Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


 // } Driver Code Ends
//User function Template for Java


class CheckBit
{
    // Function to check if Kth bit is set or not.
    static boolean checkKthBit(int n, int k)
    {
        // Your code here
        String s = Integer.toBinaryString(n);
        int i;
        for(i=s.length()-1;i>=0;i--)
        {
            if(k==0)
            {
                if(s.charAt(i)=='1')
                {
                    return true;
                }
            }
            k--;
        }
        return false;
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
			k = Integer.parseInt(br.readLine()); // Input K
			
			CheckBit obj = new CheckBit();
			
			if(obj.checkKthBit(n, k))
				System.out.println("Yes"); //If true, print Yes
				
			else
				System.out.println("No");	// Else print No
            
            t--;
		}
		
		br.close();
	}
	
	
}  // } Driver Code Ends

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int m = Integer.parseInt(inputLine[0]);
		    int n = Integer.parseInt(inputLine[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.numberOfPaths(m, n));
		}
	}
}



// } Driver Code Ends


class Solution
{
    long numberOfPaths(int m, int n) 
    {
        // Code Here
        
        //base case..
        if(n==1 || m==1)  //we have to return the number of ways..
        {
            return 1;  //there will be only one way for this condition.
        }
        return numberOfPaths(m-1,n)+(long)numberOfPaths(m,n-1);
    }
    
}

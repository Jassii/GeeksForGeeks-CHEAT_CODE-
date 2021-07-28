// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().getPairsCount(arr, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int getPairsCount(int[] arr, int n, int k) 
    {
        // code here
        
        //Brute force approach will be taking nested loops and checking for each element.
        //O(n^2) Time complexity..
        
        HashMap<Integer,Integer> M = new HashMap<>();
        int i;
        for(i=0;i<n;i++)
        {
            if(M.containsKey(arr[i]))
            {
                M.put(arr[i],M.get(arr[i])+1);
            }
            else
            {
                M.put(arr[i],1);
            }
        }
        
        int twice_count=0;
        for(i=0;i<n;i++)
        {
            int val = k-arr[i];
            if(M.get(val)!=null)
            {
                twice_count += M.get(val);
            }
            
            //to avoid pairs..
            if(val==arr[i])  //(3,2,1) ...S=6..6-3=3  ..Map will check for the elemnt 
            //of the same index value 3..so reduce it by one..
            {
                twice_count--;
            }
        }
        return twice_count/2;
    }
}

// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int findMaxSum(int arr[], int n) 
    {
        // code here
        if(n==0)
        {
            return 0;
        }
        if(n==1)
        {
            return arr[0];
        }
        if(n==2)
        {
            int max = Math.max(arr[0],arr[1]);
            return max;
        }
        int incl = arr[0];
        int excl = 0;
        int excl_new=0;
        int i;
        for(i=1;i<n;i++)
        {
            excl_new = (incl>excl)? incl:excl;
            
            incl = excl+arr[i];
            excl = excl_new;
        }
        return Math.max(incl,excl);
    }
}

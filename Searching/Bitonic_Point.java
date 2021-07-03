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

            int ans = new Solution().findMaximum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution 
{
    int findMaximum(int[] arr, int n) 
    {
        // code here
        int pos = max(arr,0,n-1);
        return arr[pos];
        
        //not acceptable..solution..
        /*Arrays.sort(arr);
        int val = arr[n-1];
        
        return val;*/
    }
    static int max(int arr[],int start,int end)
    {
        while(start<=end)
        {
            //if there is only one element in the array..
            if(start==end)
            {
                return start;
            }
            
            //if there are two elements in the array..
            if ((end == start + 1) && arr[start] >= arr[end])
            {
                return start;
            }
            if ((end == start + 1) && arr[start] < arr[end]) 
            {
                return end;
            }
            
            //if more than 2 elements in the array..
            int m = (start+end)/2;
            if(arr[m]>arr[m-1] && arr[m]>arr[m+1])
            {
                 return m;
            }
            else if(arr[m-1]>arr[m] && arr[m]>arr[m+1])
            {
                return max(arr,start,m-1);
            }
            else
            {
                return max(arr,m+1,end);
            }
        }
        return 1;
    }
}

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String st[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(st[0]);
            int K = Integer.parseInt(st[1]);
            String st1[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(st1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.toyCount(N, K, arr));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int toyCount(int N, int K, int arr[])
    {
        // code here
        /***********************First Method.*********************************/
        //arrange in ascending order.
        Arrays.sort(arr);
        int i;
        int count=0;
        for(i=0;i<N;i++)
        {
            if(K>=0 && arr[i]<=K)
            {
                K = K-arr[i];
                count++;
            }
        }
        return count;
        
        
        /********************************Second Method*****************************/
        int j,sum=0;
        for(j=0;j<N;j++)
        {
            if(sum+arr[j]>K)
            {
                break;
            }
            else
            {
                sum = sum+arr[j];
            }
        }
        return j;  //this will tell about the number of toys.
    }
}

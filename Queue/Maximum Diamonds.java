// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int K = Integer.parseInt(S[1]);
            
            int[] A = new int[N];
            
            String S1[] = read.readLine().split(" ");
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxDiamonds(A,N,K));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    static int maxDiamonds(int[] A, int N, int K) 
    {
        // code here
        //we will use max heap..
        int sum=0;
        PriorityQueue<Integer>  P = new PriorityQueue<>(Collections.reverseOrder());
        int i;
        for(i=0;i<A.length;i++)
        {
            P.add(A[i]);
        }
        for(i=0;i<K;i++)
        {
            //System.out.println(P);
            int val=P.poll();
            sum = sum+val;
            P.add(val/2);
        }
        return sum;
    }
}

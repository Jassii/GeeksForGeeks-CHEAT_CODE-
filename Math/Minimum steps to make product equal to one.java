// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.makeProductOne(arr,N));
        }
    }
}
/User function Template for Java

class Solution 
{
    static int makeProductOne(int[] arr, int N) 
    {
        // code here
        int i;
        int count=0;
        int countz=0;
        int countn=0;
        for(i=0;i<N;i++)
        {
            int num=arr[i];
            if(num>0)  //positive number reduced to 1.
            {
                count = count+num-1;
            }
            else if(num<0)  //negative number reduced to -1.
            {
                countn++;
                int dif =(int)Math.abs(num+1);
                count = count+dif;
            }
            else
            {
                countz++;
            }
        }
        if(countn%2!=0) //number of negative number is odd
        {
            if(countz==0)
            {
               count = count+2; 
            }
            else
            {
                count = count+countz*1;
            }
        }
        else
        {
            if(countz!=0)
            {
                count = count + countz*1;
            }
        }
        return count;
    }
}

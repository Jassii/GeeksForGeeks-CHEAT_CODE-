// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
        // your code here
        Map<Integer,Integer> M = new HashMap<>();
        int i;
        for(i=0;i<size;i++)
        {
            if(M.containsKey(a[i]))
            {
                M.put(a[i],M.get(a[i])+1);
            }
            else
            {
                M.put(a[i],1);
            }
        }
        int max = Integer.MIN_VALUE;
        int key=0;
        for(Map.Entry<Integer,Integer> entry:M.entrySet())
        {
            if(entry.getValue()>(size/2) && entry.getValue()>max)
            {
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        if(max==Integer.MIN_VALUE)
        {
            return -1;
        }
        return key;
    }
}

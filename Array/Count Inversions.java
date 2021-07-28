// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        long i,j;
        
        //brute force approach..
        //long count=0;
        /*for(i=0;i<N-1;i++)
        {
            for(j=i+1;j<N;j++)
            {
                if(arr[(int)i]>arr[(int)j])
                {
                    count++;
                }
            }
        }*/
        
        long count = MergeSortCount(arr,0,N-1);
        return count;
    }
    
    public static long MergeSortCount(long arr[],long l,long r)
    {
        long count=0;
        if(l<r)
        {
            long m = (l+r)/2;
            count = count + MergeSortCount(arr,l,m);
            
            count = count + MergeSortCount(arr,m+1,r);
            
            count = count + Merge(arr,l,m,r);
        }
        return count;
    }
    
    public static long Merge(long arr[],long l,long m,long r)
    {
        long n1 = m-l+1;
        long n2 = r-m;
        long left[] = new long[(int)n1];
        long right[] = new long[(int)n2];
        for(long i=0;i<n1;i++)
        {
            left[(int)i] = arr[(int)l + (int)i];
        }
        for(long i=0;i<n2;i++)
        {
            right[(int)i] = arr[(int)m + (int)i + 1];
        }
        
        long i=0,j=0,k=l,swaps=0;
        
        while(i<n1 && j<n2)
        {
            if(left[(int)i]<=right[(int)j])
            {
                arr[(int)k] = left[(int)i];
                i++;
            }
            else
            {
                arr[(int)k]=right[(int)j];
                j++;
                
                //very importtant line..
                swaps = swaps + (m+1) - (l+i);
                
            }
            k++;
        }
        while(i<left.length)
        {
            arr[(int)k] = left[(int)i];
            i++;
            k++;
        }
        while(j<right.length)
        {
            arr[(int)k] = right[(int)j];
            j++;
            k++;
        }
        return swaps;
    }
}

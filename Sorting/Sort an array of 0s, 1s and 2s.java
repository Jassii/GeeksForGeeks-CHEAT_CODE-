// { Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


 // } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int a[], int n)
    {
        // code here 
    /************First Method*************************************/
    //First method includes counting number of 0's,1's and 2's..
    //and filling the values in the array accordingly..
        
       int i;
        int c0=0,c1=0,c2=0;
        for(i=0;i<a.length;i++)
        {
            if(a[i]==0)
            {
                c0++;
            }
            else if(a[i]==1)
            {
                c1++;
            }
            else
            {
                c2++;
            }
        }
        for(i=0;i<c0;i++)
        {
            a[i]=0;
        }
        for(i=0;i<c1;i++)
        {
            a[i+c0] = 1;
        }
        for(i=0;i<c2;i++)
        {
            a[i+c1+c0] = 2;
        }
        
/*****************Second Method****************************************/

//Secind method includes of taking 3 variables..(low,mid,high)  ..low for 0
//mid for 1 and high for 2.. 
        
        int i;
        int low=0,mid=0,high=n-1;
        for(i=0;i<a.length;i++)
        {
            if(a[i]==0)
            {
                low++;
                mid++;
            }
            else if(a[i]==1)
            {
                mid++;
            }
            else
            {
                high--;
            }
        }
        
        for(i=0;i<low;i++)
        {
            a[i] = 0;
        }
        for(i=low;i<mid;i++)
        {
            a[i]=1;
        }
        for(i=high+1;i<n;i++)
        {
            a[i]=2;
        }
    }
}

// { Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}

  // } Driver Code Ends

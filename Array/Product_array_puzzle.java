// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int[] array = new int[n];
        	for (int i=0; i<n ; i++ ) {
        		array[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array, n); 

           	for (int i = 0; i < n; i++) { 
				System.out.print(ans[i]+" ");
			} 
            System.out.println();
            t--;
        }
    } 
} 
  

// } Driver Code Ends


//User function Template for Java


class Solution 
{ 
	public static long[] productExceptSelf(int nums[], int n) 
	{ 
        // code here
        long P[] = new long[n];  //product array.
        if(n==1)//when length of the array is one..
        {
            P[0]=1;
            return P; //return the product array..
        }
        int i;
        //making product array from the left side of the array
        long temp=1;
        for(i=0;i<n;i++)
        {
            P[i]=temp;
            temp =  temp*nums[i];
        }
        
        //now again making product from the right side of the array..
        long temp1=1;
        for(i=n-1;i>=0;i--)
        {
            P[i] = P[i]*temp1;
            temp1 = temp1*nums[i];
        }
        return P;
	} 
}

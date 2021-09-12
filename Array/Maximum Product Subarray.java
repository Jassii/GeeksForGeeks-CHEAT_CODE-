// Given an array Arr[] that contains N integers (may be positive, negative or zero). Find the product of the maximum product subarray.

// Example 1:

// Input:
// N = 5
// Arr[] = {6, -3, -10, 0, 2}
// Output: 180
// Explanation: Subarray with maximum product
// is [6, -3, -10] which gives product as 180.
// Example 2:

// Input:
// N = 6
// Arr[] = {2, 3, 4, 5, -1, 0}
// Output: 120
// Explanation: Subarray with maximum product
// is [2, 3, 4, 5] which gives product as 120.
// Your Task:
// You don't need to read input or print anything. Your task is to complete the function maxProduct() which takes the array of integers arr and n as parameters and returns an integer denoting the answer.
// Note: Use 64-bit integer data type to avoid overflow.

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(1)


// { Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution 
{
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) 
    {
        // code here
        
        //just similar to the Kadane's algorithm..but only change is of the negative
        //values..
        
        long maxV = (long)arr[0];  //max value..
        long minV = (long)arr[0];  //min value..
        long maxProduct=(long)arr[0]; //this will store the final result..
        
        int i;
        for(i=1;i<n;i++)
        {
            //if the number at the specific index is negative..
            //then swap the maxV and minV..
            if(arr[i]<0)
            {
                long temp = maxV;
                maxV=minV;
                minV=temp;
            }
            
            //coz after multiplying min value with the negative value..it will be 
            //maximum..
            
            maxV = Math.max((long)arr[i],maxV*(long)arr[i]);
            minV = Math.min((long)arr[i],minV*(long)arr[i]);
            
            //at last max of (maxProdcut and maxV) will be the value....
            maxProduct = Math.max(maxProduct,maxV);

        }
        return maxProduct;
    }
}

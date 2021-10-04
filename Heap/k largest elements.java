// Given an array Arr of N positive integers, find K largest elements from the array.  The output elements should be printed in decreasing order.

// Example 1:

// Input:
// N = 5, K = 2
// Arr[] = {12, 5, 787, 1, 23}
// Output: 787 23
// Explanation: 1st largest element in the
// array is 787 and second largest is 23.
// Example 2:

// Input:
// N = 7, K = 3
// Arr[] = {1, 23, 12, 9, 30, 2, 50}
// Output: 50 30 23
// Explanation: 3 Largest element in the
// array are 50, 30 and 23.
// Your Task:
// You don't need to read input or print anything. Your task is to complete the function kLargest() which takes the array of integers arr, n and k as parameters and returns an array of integers denoting the answer. The array should be in decreasing order.

// Expected Time Complexity: O(N + KlogK)
// Expected Auxiliary Space: O(K+(N-K)*logK)


// { Driver Code Starts
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().kLargest(arr, n, k);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution 
{
    int[] kLargest(int[] arr, int n, int k) 
    {
        // code here
        
        //i will be creating a max heap..and will create an array of k size.
        int large[] = new int[k]; 
        
        PriorityQueue<Integer> P = new PriorityQueue<>(Collections.reverseOrder()); //max heap..
        int i;
        for(i=0;i<n;i++)
        {
            P.add(arr[i]);  //it will automatically arranges the elements in the form of max heap
        }
         
        //now poll the elements k times and store the elements in the array.
        
        int j=0; //index for the (large array)..
        for(i=1;i<=k;i++)
        {
            large[j]=P.peek(); //insert the element in the large array..
            P.poll(); //remove the element from the priority queue.
            j++; //increment the index position..
        }
        
        return large;  //return the array..
    }
}

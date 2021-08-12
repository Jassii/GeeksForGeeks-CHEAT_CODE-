// Given a sorted array A of size N, delete all the duplicates elements from A.
// Note: Don't use set or HashMap to solve the problem.


// Example 1:

// Input:
// N = 5
// Array = {2, 2, 2, 2, 2}
// Output: 2
// Explanation: After removing all the duplicates 
// only one instance of 2 will remain.
// Example 2:

// Input:
// N = 3
// Array = {1, 2, 2}
// Output: 1 2 

// Your Task:  
// You dont need to read input or print anything. Complete the function remove_duplicate() which takes the array A[] and its size N as input parameters and modifies it in place to delete all the duplicates. The function must return an integer X denoting the new modified size of the array. 
// Note: The generated output will print all the elements of the modified array from index 0 to X-1.


// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(1)
// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int a[] = new int[N];
            for(int i=0; i<N; i++)
                a[i] = sc.nextInt();
            
            Solution g = new Solution();
            int n = g.remove_duplicate(a,N);
            
            for(int i=0; i<n; i++)
                System.out.print(a[i]+" ");
            System.out.println();
            T--;
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int remove_duplicate(int A[],int N)
    {
        // code here
        Arrays.sort(A);  //sort the array..
        
        int i;
        int j=0;
        for(i=0;i<N-1;i++)
        {
            if(A[i]!=A[i+1])
            {
                A[j] = A[i];
                j++;
            }
        }
        //now adding the last element from the array..to its new poistion.j
        A[j] = A[N-1];
        return j+1;
    }
}

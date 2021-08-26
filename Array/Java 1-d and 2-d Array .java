// Given a integer n. We have n*n values of a 2-d array, and  n values of 1-d array. 
//Task is to find the sum of the left diagonal values of the 2-d array and the max element of the 1-d array and print them with space in between.

// Example 1:

// â€‹Input : arr[][] = {{1,2,3}, {4,5,6}, {7, 8,9}} 
//         and N = 3
// brr[] = {3, 6, 9}
// Output : 15 9
// Explanation:
// 1 2 3
// 4 5 6
// 7 8 9
// So, this sum of left diagonal (1+ 5 + 9) = 15
// The maximum element in an array brr is 9
// So, will return {15, 9} as an answer.

// â€‹Example 2:

// Input : arr[][] = {{1,2}, {1, 2}} and N = 2
// brr[] = {10, 1} 
// Output :  3 10 
 

// Your Task:
// This is a function problem. The input is already taken care of by the driver code. You only need to complete the function array() that takes a two-dimension array (a), another one dimension array (b), sizeOfArray (n), and return the ArrayList which is having the sum of the diagonal elements of the array a and the maximum number of the array b. The driver code takes care of the printing.

// Expected Time Complexity: O(N2).
// Expected Auxiliary Space: O(1).

// { Driver Code Starts
// Java program to demonstrate working of Scanner in Java
import java.util.*;
import java.io.*;
class Abc
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int[] a[],b;
            a= new int[n][n];
            b= new int[n];
            int sum=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    int p=sc.nextInt();
                    a[i][j]=p;
                }
            }
            int Max=0;
            for(int i=0;i<n;i++)
            {
                int p=sc.nextInt();
                b[i]=p;
            }
            Complete obj = new Complete();
            ArrayList<Integer> ans;
            ans = obj.array(a, b, n);
            for(int i: ans)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Complete
{
    public static ArrayList<Integer> array(int a[][], int b[], int n)
    {
        // Complete the function
        Arrays.sort(b);
        int max = b[n-1];  //last element will be the maximum element.
        
        //now i have to find the sum of the diagnol of the 2D array.
        int i,j;
        int sum=0;
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                if(i==j)
                {
                    sum = sum + a[i][j];
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(sum);
        res.add(max);
        return res;
    }
}

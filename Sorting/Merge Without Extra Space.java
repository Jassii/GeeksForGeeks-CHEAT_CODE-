// Given two sorted arrays arr1[] of size N and arr2[] of size M. Each array is sorted in non-decreasing order. Merge the two arrays into one sorted array in non-decreasing order without using any extra space.


// Example 1:

// Input:
// N = 4, M = 5
// arr1[] = {1, 3, 5, 7}
// arr2[] = {0, 2, 6, 8, 9}
// Output: 0 1 2 3 5 6 7 8 9
// Explanation: Since you can't use any 
// extra space, modify the given arrays
// to form 
// arr1[] = {0, 1, 2, 3}
// arr2[] = {5, 6, 7, 8, 9}

// Example 2:

// Input:
// N = 2, M = 3
// arr1[] = {10, 12}
// arr2[] = {5, 18, 20}
// Output: 5 10 12 18 20
// Explanation: Since you can't use any
// extra space, modify the given arrays
// to form 
// arr1[] = {5, 10}
// arr2[] = {12, 18, 20}
 

// Your Task:
// You don't need to read input or print anything. Complete the function merge() which takes the two arrays arr1[], arr2[] and their sizes n and m, as input parameters. The function does not return anything. Use the given arrays to sort and merge arr1[] and arr2[] in-place. 
// Note: The generated output will print all the elements of arr1[] followed by all the elements of arr[2].


// Expected Time Complexity: O((n+m)*log(n+m))
// Expected Auxiliary Space: O(1)

// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int arr1[] = new int[n];
            int arr2[] = new int[m];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().merge(arr1, arr2, n, m);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < n; i++) {
                str.append(arr1[i] + " ");
            }
            for (int i = 0; i < m; i++) {
                str.append(arr2[i] + " ");
            }
            System.out.println(str);
        }
    }
}// } Driver Code Ends


class Solution 
{

    public void merge(int arr1[], int arr2[], int n, int m) 
    {
        // code here
        /*if(arr1[n-1]>arr2[0])
        {
            //swap it..
            int temp = arr1[n-1];
            arr1[n-1] = arr2[0];
            arr2[0]=temp;
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            merge(arr1,arr2,n,m);
        }*/
        
      
      //optimised solution..
      
        int i=0,j=0;
        int k = n-1;
        while(i<=k && j<m)
        {
            if(arr1[i]>arr2[j])
            {
                int temp = arr1[k];
                arr1[k] = arr2[j];
                arr2[j] = temp;
                k--;
                j++;
            }
            else
            {
                i++;
            }
        }
        //now its time to sort both the arrays..
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}

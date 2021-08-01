// Example 1:

// Input:
// N = 2
// Arr[] = {2, 2}
// Output: 2 1
// Explanation: Repeating number is 2 and 
// smallest positive missing number is 1.
// Example 2:

// Input:
// N = 3
// Arr[] = {1, 3, 3}
// Output: 3 2
// Explanation: Repeating number is 3 and 
// smallest positive missing number is 2.
// Your Task:
// You don't need to read input or print anything. Your task is to complete the function findTwoElement() which takes the array of integers arr and n as parameters and returns an array of integers of size 2 denoting the answer ( The first index contains B and second index contains A.)

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(1)

/*****************************************************************************************************************************/
// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solve 
{
    int[] findTwoElement(int arr[], int n) 
    {
        // code here
        int visited[] = new int[n];  //it will check if the element is visited or not.
        int res[] = new int[2]; //final array..
        int i,A=0,B=0;
        for(i=0;i<n;i++) //initialize the values with 0..
        {
            visited[i]=0;
        }
        
        //traverse the array..
        for(i=0;i<arr.length;i++)
        {
            int val=arr[i];
            if(visited[val-1]==0)//not visited..
            {
                visited[val-1] = -1; //update to -1..that means visited.
            }
            else  //visited..
            {
                B=val; //repeating element. 
                //don't break it here...bcoz of which..many values will be left unvisited..
            }
        }
        for(i=0;i<n;i++)
        {
            if(visited[i]==0)  //if any indx is not visited..
            {
                A=i+1; //missing element.  //we want the first missing element.
                break;  //that is why break..
            }
        }
        //in the end result array..
        res[0]=B;  
        res[1]=A;
        //return the result array.
        return res;
    }
}

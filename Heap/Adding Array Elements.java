// { Driver Code Starts
//Initial Template for Java




import java.io.*;
import java.util.*;

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

            int ans = new Solution().minOperations(arr, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java





class Solution 
{
    int minOperations(int[] arr, int n, int k) 
    {
        // code here
        if(n==0)
        {
            return -1;
        }
        
        //here we will take a look of a MIN_HEAP..
        PriorityQueue<Integer> P = new PriorityQueue<>();
        int i;
        for(i=0;i<n;i++)
        {
            P.add(arr[i]);
        }
        //queue will be arranged in the form of MIN_HEAP.
        int count=0;  //will count the number of operations.
        int a=0,b=0;
        while(!P.isEmpty() && P.peek()<k)
        {
            if(!P.isEmpty())
            {
                 a = P.poll();
            }
            
            if(!P.isEmpty())
            {
                 b = P.poll();
            }
            else
            {
                return -1;
            }
            P.add(a+b);
            count++;
        }
        return count;
    }
}

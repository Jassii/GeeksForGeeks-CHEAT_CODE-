// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    void rearrange(int arr[], int n) 
    {
        // code here
       
      //make separate elements for positive and negative integers..
      //and further update the value of the array according to the given condition..
      
      
       List<Integer> P = new ArrayList<>();  //positive list
       for(int i=0;i<arr.length;i++)
       {
           if(arr[i]>=0)
           {
               P.add(arr[i]);
           }
       }
      
      
       List<Integer> N = new ArrayList<>();  //negative list.
       for(int i=0;i<arr.length;i++)
       {
           if(arr[i]<0)
           {
               N.add(arr[i]);
           }
       }
      
      
       int p = P.size();  //positive list size. 
       int n1 = N.size();  //negative list size.
       
       int i=0,j=0;
       int k=0;
       while(i<p && j<n1)
       {
           if(k%2==0)  //even index. - positive value..
           {
               arr[k] = P.get(i);
               i++;
           }
           else  //odd index.. - negative value..
           {
               arr[k] = N.get(j);
               j++;
           }
           k++;  //increase the main array index..
       }
       while(i<p)  //remaining elements..for positive array.
       {
           arr[k] = P.get(i);
           i++;
           k++;
       }
       while(j<n1)   //remaining elements..for negative array.
       {
           arr[k] = N.get(j);
           j++;
           k++;
       }
    }
}

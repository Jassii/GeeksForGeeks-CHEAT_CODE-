// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Solution
{
    String longestCommonPrefix(String arr[], int n)
    {
        // code here
         
        //when the size of the array is empty.. 
        if(n==0)
        {
            return "";
        } 
        //if size of the array is one.
        else if(n==1)
        {
            return arr[0]; 
        }
        
        //if more than one element is there..
        //sort the array in ascending order.
        Arrays.sort(arr);
        
        //minimum string/\.
        String min = arr[0];  //minimum string
        int i=0;
        String res=""; //final string.
        int end = min.length();  //length of the minimum string.
        
        //traverse the min string and compare it with the last index string.
        while(i<end && min.charAt(i)==arr[n-1].charAt(i))
        {
            i++;  //if it matches increase the value of i.
        }
        
        //create a substring from (0,i) from min string.
        for(int a=0;a<i;a++)
        {
            res = res+min.charAt(a);
        }
        
        //if final string is empty(no matching string is there in the array)
        if(res=="")
        {
            return "-1";
        }
        //else return the largest common prefix in an array.
        return res;
    }
}

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] sortedArrayToBST(int[] nums)
    {
        // Code here
       ArrayList<Integer> fa = new ArrayList<>();
        //here array is already sorted.
        int arr[] = new int[nums.length];
        int start=0;
        int end=nums.length-1;
        fa = isUtil(nums,start,end,fa);
        int i;
        for(i=0;i<fa.size();i++)
        {
            arr[i] = fa.get(i);
        }
        return arr;
        // return nums;
    }
    public ArrayList<Integer> isUtil(int nums[],int start,int end,ArrayList<Integer> fa)
    {
        if(start>end)
        {
            return new ArrayList<>();
        }
        
        int mid = (start+end)/2;
        fa.add(nums[mid]);
        
        ArrayList<Integer> left = isUtil(nums,start,mid-1,fa); //for left subtree.
        ArrayList<Integer> right = isUtil(nums,mid+1,end,fa); //for right subtree.
        
        return fa;
    }
}

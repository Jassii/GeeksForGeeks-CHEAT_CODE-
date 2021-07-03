// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG
{
    public static void main (String[] args)
	{
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        while(t-->0)
        {
            int n = in.nextInt();
            
            int tree[]= new int[n];
            for(int i=0; i<n; i++)
                tree[i] = in.nextInt();
            int k = in.nextInt();
            
            Solution x = new Solution();
            System.out.println( x.find_height(tree,n,k) );
        }
	}
}// } Driver Code Ends


class Solution
{
    static int wood_collected(int tree[],int n,int m)
    {
        int count=0;
        int i;
        for(i=0;i<n;i++)
        {
            if(tree[i]>m)
            {
                count=count+tree[i]-m;
            }
        }
        return count;
    }
    static int find_height(int tree[], int n, int k)
    {
        //sorting the array.
        Arrays.sort(tree);
        int l=0;  //first index.
        int h = tree[n-1];  //highest element.
        while(l<=h)
        {
            int mid = (l+h)/2;
            int val = wood_collected(tree,n,mid);
            if(val==k)
            {
                return mid;
            }
            else if(val>k)
            {
                l = mid+1;
            }
            else
            {
                h = mid-1;
            }
        }
        return -1;
    }
}

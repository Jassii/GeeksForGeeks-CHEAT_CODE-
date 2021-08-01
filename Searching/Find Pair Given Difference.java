// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int l = sc.nextInt();
            int n = sc.nextInt();
            
            int arr[] =  new int[l];
            
            for(int i = 0;i<l;i++)
                arr[i] = sc.nextInt();
            
            Solution ob = new Solution();
                
            if(ob.findPair(arr, l, n)==true)
                System.out.println(1);
                
            else
                System.out.println(-1);    
                
        }
        
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        //code here.
        
        //using HashSet
       /* Set<Integer> set = new HashSet<>();
        int i;
        for(i=0;i<size;i++)
        {
            set.add(arr[i]);
        }
        for(i=0;i<size;i++)
        {
            int val=arr[i];
            if(set.contains(n+val))
            {
                return true;
            }
        }
        return false;*/
        
        //for this first sort the array..
        Arrays.sort(arr);
        
        int i=0,j=1;
        while(i<size && j<size)
        {
            if(arr[j]-arr[i]==n)
            {
                return true;
            }
            else if(arr[j]-arr[i]<n)  //if it is less..then inc j as we have to 
            //increase the difference..
            {
                j++;
            }
            else  //if greater then we have to decrease the difference..
            {
                i++;
            }
        }
        return false;
    }
}

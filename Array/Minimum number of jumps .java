// { Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}
// } Driver Code Ends


class Solution
{
    static int minJumps(int[] arr)
    {
        // your code here
        if(arr[0]==0)
        {
            return -1;
        }
        int max=0;
        int jump=0;
        int halt=0;
        int i;
        int n = arr.length;
        for(i=0;i<n-1;i++)
        {
            max = Math.max(max,arr[i]+i);
            if(max>=arr.length-1)
            {
                jump++;
                return jump;
            }
            if(i==halt)
            {
                halt=max;
                jump++;
            }
        }
        if(halt>=arr.length-1)
        {
            return jump;
        }
        return -1;
        
        
        
        /*int i;
        int n = arr.length;
        if(n==1)  
        {
            return 0;  //no jump is required..
        }
        else if(arr[0]==0)
        {
            return -1;
        }
        
        int maxR = arr[0];
        int step=arr[0];
        int jump=1;  
        for(i=1;i<n;i++)
        {
            if(arr[i]==n-1)  //if i has reached the end of the array.
            {
                return jump;  //return the jump..
            }
            //kaha tk hm pahuch skte hai value ki help se..
            maxR = Math.max(maxR,i+arr[i]);  //(index + 1).
            step--;
            if(step==0)
            {
                jump++;
                if(i>maxR)
                {
                    return -1; 
                }
                else
                {
                    step = maxR-i;
                }
            }
        }
        return jump;*/
    }
}

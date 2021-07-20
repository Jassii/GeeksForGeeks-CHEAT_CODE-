// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            StringBuilder out = new StringBuilder();
            ans = ob.jugglerSequence(N);
            for(int i = 0;i < ans.size();i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static List<Integer> jugglerSequence(int N)
    {
        // code here
        ArrayList<Integer> list = new ArrayList<>(); //this will store the value.
        
        list = seq(list,N);  //result list.
        return list;  //return th final list..
    }
    static ArrayList<Integer> seq(ArrayList<Integer> list,int N)
    {
        list.add(N);  //first input the value..
        if(N!=1)  //check if its not the end..bcoz after that value won'y be changed.
        {
            if(N%2==0)  //if its a even number..
            {
                int val = (int)Math.floor((int)Math.pow(N,0.5));
                 return seq(list,val);  //calling function recursively.
            }
            else  //odd number..
            {
                int val = (int)Math.floor((int)Math.pow(N,1.5));
                return seq(list,val); //calling function recursively.
            }
        }
        return list;  //in the end return the list..
    }
}

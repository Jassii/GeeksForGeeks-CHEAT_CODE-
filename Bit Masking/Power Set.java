// Given a string S find all possible subsequences of the string in lexicographically-sorted order.

// Example 1:

// Input : str = "abc"
// Output: a ab abc ac b bc c
// Explanation : There are 7 substrings that 
// can be formed from abc.
// Example 2:

// Input: str = "aa"
// Output: a a aa
// Explanation : There are 3 substrings that 
// can be formed from aa.
// Your Task:
// You don't need to read ot print anything. Your task is to complete the function AllPossibleStrings() which takes S as input parameter and returns a list of all possible substrings(non-empty) that can be formed from S in lexicographically-sorted order.
 

// Expected Time Complexity: O(2n) where n is the length of the string
// Expected Space Complexity : O(n * 2n)

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
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        
        
        List<String> list = new ArrayList<>();
        
        if(s.length()==1)
        {
            list.add(s);
            return list;
        }
        //find the size of the power set..(final)..2^n
        int n = s.length();
        
        int pow_set_size = 1<<n; //this will be the size of the power set..
        int counter,j;
        
        for(counter=0;counter<pow_set_size;counter++)//traverse the power set
        {
            String val="";
            for(j=0;j<n;j++)
            {
                //if jth bit in the counter is set, then assign jth element from the string into the list.
                if((counter & (1<<j)) > 0)
                {
                    val = val+ Character.toString(s.charAt(j));
                }
            }
            if(val!="")
            {
                list.add(val);
            }
        }
        
        Collections.sort(list);
        
        return list;
    }
}

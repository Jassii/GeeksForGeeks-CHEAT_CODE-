// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            RomanToNumber rn = new RomanToNumber();
            System.out.println(rn.romanToDecimal(roman));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class RomanToNumber 
{
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) 
    {
        // code here
        
        //if length of the string is 0..
        if(str.length()==0)
        {
            return 0;
        }
        
        int sum=0;
        int i;
        for(i=0;i<str.length()-1;i++)
        {
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(i+1);
            int val1 = intValue(ch1);
            int val2 = intValue(ch2);
            //if the first index value is greater than or equal to the next index value.
            if(val1>=val2)
            {
                sum = sum+val1;  
            }
            else  //if not decrease its value..
            {
                sum = sum-val1;
            }
        }
        //this is for the last index value..
        char c = str.charAt(str.length()-1);
        int val3 = intValue(c);
        
        sum = sum + val3;
        
        return sum;
    }
    
    //you can use MAP for this instead of function..
    public static int intValue(char ch)
    {
        int val=0;
        if(ch=='I')
        {
            val= 1;
        }
        else if(ch=='V')
        {
            val= 5;
        }
        else if(ch=='X')
        {
            val= 10;
        }
        else if(ch=='L')
        {
            val= 50;
        }
        else if(ch=='C')
        {
            val= 100;
        }
        else if(ch=='D')
        {
            val= 500;
        }
        else if(ch=='M')
        {
            val = 1000;
        }
        return val;
    }
}

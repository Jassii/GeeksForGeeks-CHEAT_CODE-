// Given a two integers say a and b. Find the quotient after dividing a by b without using multiplication, division and mod operator.

// Example: 

// Input : a = 10, b = 3
// Output : 3

// Input : a = 43, b = -8
// Output :  -5 


/*Java implementation to Divide two
integers without using multiplication,
division and mod operator*/
 
import java.io.*;
 
class GFG
{
     
    // Function to divide a by b and
    // return floor value it
    
    static int divide(int dividend, int divisor)
    {
        //first we have to check if any of the number is positive or negative..
      // Calculate sign of divisor i.e.,
        // sign will be negative only iff
        // either one of them is negative
        // otherwise it will be positive
        int sign = ((dividend<0)^(divisor<0))?-1:1;
        
      // Update both divisor and
        // dividend positive
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
      // Initialize the quotient
        int quotient = 0;
        while(dividend>=divisor)
        {
            dividend = dividend-divisor;
            quotient++;
        }
      
      //if the sign value computed earlier is -1 then negate the value of quotient
        if(sign==-1)
        {
            return quotient*-1;
        }
      
        return quotient;
    }
    public static void main (String[] args)
    {
        int a = 10;
        int b = 3;
         
        System.out.println(divide(a, b));
         
        a = 43;
        b = -8;
         
        System.out.println(divide(a, b));
    }
}

// Given an integer n, calculate the square of a number without using *, / and pow(). 

// Examples : 

// Input: n = 5
// Output: 25

// Input: 7
// Output: 49

// Input: n = 12
// Output: 144
  
// We can do it in O(Logn) time using bitwise operators. The idea is based on the following fact.

//   square(n) = 0 if n == 0
//   if n is even 
//      square(n) = 4*square(n/2) 
//   if n is odd
//      square(n) = 4*square(floor(n/2)) + 4*floor(n/2) + 1 

// Examples
//   square(6) = 4*square(3)
//   square(3) = 4*(square(1)) + 4*1 + 1 = 9
//   square(7) = 4*square(3) + 4*3 + 1 = 4*9 + 4*3 + 1 = 49  

import java.util.*;
class Main
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();  //value whose square we have to find..
        int val = square(n);
        System.out.println("Square of the number is "+val);
    }
    //this function will calculate the square of the number..
    public static int square(int n)
    {
        if(n==0)  //if n is zero..
        {
            return 0;
        }
        if(n%2==0)  //if n is even..
        {
            return 4*square(n/2);
        }
        else //if n is odd..
        {
            return 4*square((int)Math.floor(n/2)) + 4*(int)Math.floor(n/2)+1;  //this floor is used because then n will be 1.then 0 value.
        }
    }
}

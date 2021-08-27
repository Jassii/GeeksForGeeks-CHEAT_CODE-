// // Given an integer N, find its factorial.

// // Example 1:

// // Input: N = 5
// // Output: 120
// // Explanation : 5! = 1*2*3*4*5 = 120
// // Example 2:

// // Input: N = 10
// // Output: 3628800
// // Explanation :
// // 10! = 1*2*3*4*5*6*7*8*9*10 = 3628800

// // Your Task:
// // You don't need to read input or print anything. Complete the function factorial() that takes integer N as input parameter and returns a list of integers denoting the digits that make up the factorial of N.


// // Expected Time Complexity : O(N2)
// // Expected Auxilliary Space : O(1)
// multiply(res[], x) 
// 1) Initialize carry as 0. 
// 2) Do following for i = 0 to res_size – 1 
// ….a) Find value of res[i] * x + carry. Let this value be prod. 
// ….b) Update res[i] by storing last digit of prod in it. 
// ….c) Update carry by storing remaining digits in carry. 
// 3) Put all digits of carry in res[] and increase res_size by number of digits in carry.

// Example to show working of multiply(res[], x)
// A number 5189 is stored in res[] as following.
// res[] = {9, 8, 1, 5}
// x = 10

// Initialize carry = 0;

// i = 0, prod = res[0]*x + carry = 9*10 + 0 = 90.
// res[0] = 0, carry = 9

// i = 1, prod = res[1]*x + carry = 8*10 + 9 = 89
// res[1] = 9, carry = 8

// i = 2, prod = res[2]*x + carry = 1*10 + 8 = 18
// res[2] = 8, carry = 1

// i = 3, prod = res[3]*x + carry = 5*10 + 1 = 51
// res[3] = 1, carry = 5

// res[4] = carry = 5

// res[] = {0, 9, 8, 1, 5} 

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    static ArrayList<Integer> factorial(int N)
    {
        //code here
        
        //this array list will store the factorial of the number..
        ArrayList<Integer> res = new ArrayList<Integer>(); 
        
        //initialize the res by 1..
        res.add(1);
        int res_size=1; //size of the array list..
        
        // Apply simple factorial formula
        // n! = 1 * 2 * 3 * 4...*n
        for(int x=2;x<=N;x++)
        {
            res_size = multiply(x,res,res_size);
        }
        
        Collections.reverse(res);
        return res;
    }
    
    static int multiply(int x,ArrayList<Integer> res,int res_size)
    {
        int carry=0; //initialize carry
        
        // One by one multiply n with individual
        // digits of res
        for(int i=0;i<res_size;i++)
        {
            int prod = res.get(i)*x+carry;
            res.set(i,prod%10);//assign the last element..
            carry = prod/10; //rest of the element will come in the carry
        }
        //input all the carry element in the res..
        while(carry!=0)
        {
            res.add(carry%10);
            carry = carry/10;
            res_size++;
        }
        return res_size;
        
    }
}

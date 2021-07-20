// { Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();//total testcases
        while (T-- > 0) {
            Hanoi obj = new Hanoi();
            int N;
            
            //taking input N
            N = sc.nextInt();

            //calling toh() method 
            System.out.println(obj.toh(N, 1, 3, 2));
        }
    }
}





// } Driver Code Ends


// User function Template for Java


// avoid space at the starting of the string in "move disk....."
class Hanoi 
{
    public long count=0;
    
    public long toh(int N, int from, int to, int aux) 
    {
        // Your code here
        
        //N tells about the number of discs..
        //axu ..auxiliary rod..
        
        //basic condition..
        if(N==1)  //if only one disk is there..
        {
            System.out.println("move disk 1 from rod "+from+" to rod "+to);
            count = 1;
            return count;
        }
         
        count = toh(N-1,from,aux,to)+1;
        
        System.out.println("move disk "+N+" from rod "+from+" to rod "+to);
        count = count + toh(N-1,aux,to,from);
        //count++;
        //System.out.println("Move disk "+N+" from rod "+from+" to rod "+to);
        return count;
    }
}

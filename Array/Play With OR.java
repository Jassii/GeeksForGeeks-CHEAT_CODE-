// You are given an array arr[], you have to re-construct an array arr[].
// The values in arr[] are obtained by doing OR(bitwise or) of consecutive elements in the array.

// Example 1:

// â€‹Input : arr[ ] = {10, 11, 1, 2, 3}
// Output : 11 11 3 3 3
// Explanation:
// At index 0, arr[0] or arr[1] = 11
// At index 1, arr[1] or arr[2] = 11
// At index 2, arr[2] or arr[3] = 3
// ...
// At index 4, No element is left So, it will 
// remain as it is.
// New Array will be {11, 11, 3, 3, 3}.

// â€‹Example 2:

// Input : arr[ ] = {5, 9, 2, 6} 
// Output :  13 11 6 6 
 

// Your Task:
// This is a function problem. The input is already taken care of by the driver code. You only need to complete the function game_with_number() that takes an array (arr), sizeOfArray (n), and return the array re-constructed array arr. The driver code takes care of the printing.

// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(1).

// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Complete obj = new Complete();
		    arr = obj.game_with_number(arr, sizeOfArray);
		    for(int i=0; i< sizeOfArray;i++){
		        System.out.print(arr[i] + " ");
		    }
		    System.out.println();
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Complete{
    
   
    // Function for finding maximum and value pair
    public static int[] game_with_number (int arr[], int n) 
    {
        // Complete the function
        int i;
        for(i=0;i<n-1;i++)
        {
            arr[i] = arr[i]|arr[i+1];  //bitwise or operator..
        }
        return arr;
    }
}

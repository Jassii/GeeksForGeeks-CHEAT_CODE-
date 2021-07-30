// Split the binary string into substrings with equal number of 0s and 1s

// Given a binary string str of length N, the task is to find the maximum count of consecutive substrings str can be divided into such that all the substrings are balanced i.e. they have equal number of 0s and 1s. If it is not possible to split str satisfying the conditions then print -1.
// Example: 
 

// Input: str = “0100110101” 
// Output: 4 
// The required substrings are “01”, “0011”, “01” and “01”.

// Input: str = “0111100010” 
// Output: 3 

// Input: str = “0000000000” 
// Output: -1

/****************************************  C  O  D  E   ************************************************************/

import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		String S = sc.nextLine();  //input the string.
	
		int count=0;  //final count..
		int co=0;  //count of ones..
		int cz=0;  //count of zeros..
		
		//traverse the string..
		int i;
		for(i=0;i<S.length();i++)
		{
		    if(S.charAt(i)=='0')
		    {
		        cz++;  //increase the count of zeros..
		    }
		    else  //if it matches with the ones..
		    {
		        co++; //increase the count of ones..
		    }
		    //whenever they both are equal..increment the count..(for every iteration checkk...)
		    if(cz==co)
		    {
		        count++;  //increase the count..
		    }
		}
		
		//now after counting if any of them is absent then the count will be equal to zero..
		if(count==0) //or we can say that it is not possible to split the string..
		{
		    System.out.println("-1");  
		    System.exit(0); //terminate the program..
		}
		System.out.println(count);  //else print the count..
	}
}

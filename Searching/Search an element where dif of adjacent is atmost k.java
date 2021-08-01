// Searching in an array where adjacent differ by at most k

// A step array is an array of integers where each element has a difference of at most k with its neighbor. Given a key x, we need to find the index value of x if multiple-element exist to return the first occurrence of the key.
// Examples: 
 

// Input : arr[] = {4, 5, 6, 7, 6}
//            k = 1
//            x = 6
// Output : 2
// The first index of 6 is 2.

// Input : arr[] = {20, 40, 50, 70, 70, 60}  
//           k = 20
//           x = 60
// Output : 5
// The index of 60 is 5

/*******************************************  C  O  D  E  **********************************************************************/
//similar to the search the element having adj dif of 1..


import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int arr[] = {2, 4, 5, 7, 7, 6};
		int x = 6;
		int k = 2;
		//Brute force approach..is to traverse the array.. and returning the first index where it matches.
		
		//another approach...just taking the help of the dif between the value and the target value..
		int start=0;
		int i;
		for(i=0;i<arr.length;i++)
		{
		    if(arr[start]==x)  //if it matches with the target ..break and return the index..
		    {
		         break;
		    }
		    int dif = Math.max(1,Math.abs(arr[start]-x)/k);  //jb division 0 aa jaye..to ek step toh chalna hee 
		    //hoga na..tbhi max...lagaya hai...
		    start = start + dif;
		}
		System.out.println("First occurenece is "+start);  //at the end it will contains the index..
	}
}

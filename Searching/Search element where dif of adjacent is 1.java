// Search an element in an array where difference between adjacent elements is 1

// Given an array where difference between adjacent elements is 1, write an algorithm to search for an element in the array and return the position of the element (return the first occurrence).
// Examples : 

// Let element to be searched be x

// Input: arr[] = {8, 7, 6, 7, 6, 5, 4, 3, 2, 3, 4, 3}     
//        x = 3
// Output: Element 3 found at index 7

// Input: arr[] =  {1, 2, 3, 4, 5, 4}
//        x = 5
// Output: Element 5 found at index 4 

// A Simple Approach is to traverse the given array one by one and compare every element with given element ‘x’. If matches, then return index.
// The above solution can be Optimized using the fact that difference between all adjacent elements is 1. The idea is to start comparing from the leftmost element and find the difference between current array element and x. Let this difference be ‘diff’. From the given property of array, we always know that x must be at-least ‘diff’ away, so instead of searching one by one, we jump ‘diff’.



import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int arr[] = {8, 7, 6, 7, 6, 5, 4, 3, 2, 3, 4, 3};
		int x = 3;
		
		//Brute force approach..is to traverse the array.. and returning the first index where it matches.
		
		//another approach...just taking the help of the dif between the value and the target value..
		int start=0;
		int i;
		for(i=0;i<arr.length;i++)
		{
		    if(arr[start]==x)
		    {
		         break;
		    }
		    int dif = Math.abs(arr[start]-x);
		    start = start + dif; //increase the start value with the value of the dif..
		}
		System.out.println("First occurenece is "+start);
	}
}

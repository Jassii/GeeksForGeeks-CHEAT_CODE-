/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) 
	{
		int[] arr = { 1,2,3,4,5,6 };
		//i'll be using two pointer approach..
		int start=0;
		int end=arr.length-1;
		while(start<=end)
		{
		    if(arr[start]<0 && arr[end]<0)  //left and right negative..
		    {
		        start++;
		    }
		    else if(arr[start]<0 && arr[end]>0) //left negative and right positive..
		    {
		        start++;
		        end--;
		    }
		    else if(arr[start]>0 && arr[end]>0)  //both positive..
		    {
		        end--;
		    }
		    else if(arr[start]>0 && arr[end]<0)  //left positive and right negative..
		    {
		        //swap the values..
		        int temp = arr[start];
		        arr[start] = arr[end];
		        arr[end] = temp;
		        start++;
		        end--;
		    }
		}
		int i;
		for(i=0;i<arr.length;i++)
		{
		    System.out.print(arr[i]+" ");
		}
	}
}

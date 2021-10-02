// Given an array of size N. The task is to sort the array elements by completing functions heapify() and buildHeap() which are used to implement Heap Sort.


// Example 1:

// Input:
// N = 5
// arr[] = {4,1,3,9,7}
// Output:
// 1 3 4 7 9
// Explanation:
// After sorting elements
// using heap sort, elements will be
// in order as 1,3,4,7,9.
// Example 2:

// Input:
// N = 10
// arr[] = {10,9,8,7,6,5,4,3,2,1}
// Output:
// 1 2 3 4 5 6 7 8 9 10
// Explanation:
// After sorting elements
// using heap sort, elements will be
// in order as 1, 2,3,4,5,6,7,8,9,10.

// Your Task :
// You don't have to read input or print anything. Your task is to complete the functions heapify(), buildheap() and heapSort() where heapSort() and buildheap() takes the array and it's size as input and heapify() takes the array, it's size and an index i as input. Complete and use these functions to sort the array using heap sort algorithm.
// Note: You don't have to return the sorted list. You need to sort the array "arr" in place.


// Expected Time Complexity: O(N * Log(N)).
// Expected Auxiliary Space: O(1).

// { Driver Code Starts
import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    
}


// } Driver Code Ends


class Solution
{
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        // Your code here
        
        //build heap..
        for(int i=n/2-1;i>=0;i--)
        {
            heapify(arr,n,i);
        }
        
        //now its time to delete the nodes..
        for(int i=n-1;i>0;i--)
        {
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            
            heapify(arr,i,0);
        }
        
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        // Your code here
        
        int largest=i;
        int l = 2*i+1;
        int r = 2*i+2;
        
        if(l<n && arr[l]>arr[largest])
        {
            largest=l;
        }
        if(r<n && arr[r]>arr[largest])
        {
            largest=r;
        }
        
        //if the largest value is updated..
        if(largest!=i)
        {
            //swap the elements..
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            
            //now do the heapify for the new largest value..
            heapify(arr,n,largest);
            
        }
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        //code here
        buildHeap(arr,n);
    }
 }

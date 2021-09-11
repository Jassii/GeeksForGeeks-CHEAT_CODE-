// Given two n-ary trees. Check if they are mirror images of each other or not. You are also given e denoting the number of edges in both trees, 
//and two arrays, A[] and B[]. Each array has 2*e space separated values u,v denoting an edge from u to v for the both trees.

// Example 1:

// Input:
// n = 3, e = 2
// A[] = {1, 2, 1, 3}
// B[] = {1, 3, 1, 2}
// Output:
// 1
// Explanation:
//    1          1
//  / \        /  \
// 2   3      3    2 
// As we can clearly see, the second tree
// is mirror image of the first.
// Example 2:

// Input:
// n = 3, e = 2
// A[] = {1, 2, 1, 3}
// B[] = {1, 2, 1, 3}
// Output:
// 0
// Explanation:
//    1          1
//  / \        /  \
// 2   3      2    3 
// As we can clearly see, the second tree
// isn't mirror image of the first.

// Your Task:
// You don't need to read input or print anything. 
  //Your task is to complete the function checkMirrorTree() which takes 2 Integers n, and e;  
  //and two arrays A[] and B[] of size 2*e as input and returns 1 if the trees are mirror images of each other and 0 if not.


// Expected Time Complexity: O(n)
// Expected Auxiliary Space: O(n)

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int e = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] A = new int[2*e];
            int[] B = new int[2*e];
            
            for(int i=0; i<2*e; i++)
            {
                A[i] = Integer.parseInt(S1[i]);
                B[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.checkMirrorTree(n,e,A,B));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    static int checkMirrorTree(int n, int e, int[] A, int[] B) 
    {
        // code here
        
        //now i have two arrays..and i have to check if they are mirror or not.
        int i;
        
        //I have to use a list of stack and a list of queue..
        List<Stack<Integer>> stack = new ArrayList<>();
        List<Queue<Integer>> queue = new ArrayList<>();
        
        
        //e--> number of edges..
        //n--> number of nodes..(3 in this case..)
        
        //for all nodes initialize the list of stack and list of queue..
        for(i=0;i<=n;i++)
        {
            //initialize with the empty stack.
            stack.add(new Stack<>());
            
            //initialize with the empty queue.
            Queue<Integer> q = new LinkedList<>();
            
            queue.add(q);
        }
        
        //now traverse both the arrays....
        for(i=0;i<A.length;i=i+2)
        {
            stack.get(A[i]).push(A[i+1]); //get the 0th and access the next element..
            queue.get(B[i]).add(B[i+1]); //similar with the queue..
        }
        
        //now its time to compare the elements..
        for(i=0;i<=n;i++)
        {
            //untill the particular index is empty..
            while(!stack.get(i).isEmpty() && !queue.get(i).isEmpty())
            {
                int a = stack.get(i).pop();
                int b = queue.get(i).poll();
                if(a!=b)
                {
                    return 0;
                }
            }
        }
        return 1;
    }
}

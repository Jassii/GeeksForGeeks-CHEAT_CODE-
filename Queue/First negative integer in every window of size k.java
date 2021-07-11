// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            
            Compute obj = new Compute();
            long answer[] = obj.printFirstNegativeInteger(a, n, k);
            int sz = answer.length;
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<sz;i++)
                output.append(answer[i]+" ");
            System.out.println(output);
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
       int i,j;
       Queue<Long> q = new LinkedList<>();
       for(i=0;i<=A.length-K;i++)
       {
           boolean enter=false;
           for(j=i;j<i+K;j++)
           {
               if(A[j]<0)
               {
                   q.add(A[j]);
                  
                   enter=true;
                   break;
               }
               else
               {
                   continue;
               }
           }
         if(enter==false)
         {
             q.add((long)0);
         }
       }
        int size = q.size();
       
        long res[] = new long[size];
        i=0;  //for index.
      
        while(!q.isEmpty())
        {
            
            
            res[i]=q.peek();
            q.poll();
            i++;
        }
        
        
        return res;
    }
}

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i + 1]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[] ans = obj.topK(nums, k);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution 
{
    public int[] topK(int[] nums, int k) 
    {
        // Code here
        
        Map<Integer,Integer> M = new HashMap<>();
        int i;
        for(i=0;i<nums.length;i++)
        {
            if(M.containsKey(nums[i]))
            {
                M.put(nums[i],M.get(nums[i])+1);
            }
            else
            {
                M.put(nums[i],1);
            }
        }
        //creating a maxHeap..
        PriorityQueue<Map.Entry<Integer,Integer>> P = new PriorityQueue<>((n1,n2)->n1.getValue().equals(n2.getValue())?Integer.compare(n2.getKey(),n1.getKey()):Integer.compare(n2.getValue(),n1.getValue()));                 
        for(Map.Entry<Integer,Integer> entry:M.entrySet())
        {
            P.add(entry);
        }
        
        //arranged on the basis of their frequency.
        int arr[] = new int[k];
        for(i=0;i<k && !P.isEmpty();i++)
        {
            int val = P.peek().getKey();
            arr[i]=val;
            P.poll();
        }
        return arr;
    }
}

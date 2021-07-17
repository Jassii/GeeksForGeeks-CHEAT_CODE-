// { Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.dfsOfGraph(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        
        int start=0;  //starting index.
        boolean visited[] = new boolean[V]; //visited array
        
        ArrayList<Integer> result = new ArrayList<>();
        result = dfs(start,visited,adj,result);  //calling the function..
        
        return result;
    }
    public ArrayList<Integer> dfs(int start,boolean visited[],ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> result)
    {
        visited[start]=true;
        result.add(start);
        
        //neighbours of the value.
        ArrayList<Integer> l = adj.get(start);
        int i;
        
        for(i=0;i<l.size();i++)
        {
            int p = l.get(i);
            if(!visited[p])
            {
                //visited[p]=true;
                dfs(p,visited,adj,result);
            }
        }
        return result;
    }
}

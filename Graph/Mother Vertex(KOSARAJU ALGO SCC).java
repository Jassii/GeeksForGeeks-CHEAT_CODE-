// { Driver Code Starts
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
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends

//  The idea is based on Kosaraju's Strongly Connected Component Algorithm.

class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        
        boolean visited[] = new boolean[V];
        int v=-1;  //this is actually last finished vertex..or mother vertex or root.
        int i;
        for(i=0;i<V;i++)
        {
            if(!visited[i])
            {
                dfsUtil(i,adj,visited);
                v=i;
            }
        }
        //now v must be storing the vertex which can be a mother vertex.
        boolean check[] = new boolean[V];  //this will check
        dfsUtil(v,adj,check);
       
        for(i=0;i<V;i++)
        {
            if(!check[i])
            {
                return -1;
            }
        }
        return v;
    }
    public void dfsUtil(int v,ArrayList<ArrayList<Integer>>adj,boolean visited[])
    {
        visited[v]=true;
        //find its neighbours.
        ArrayList<Integer> l = adj.get(v);
        int i;
        for(i=0;i<l.size();i++)
        {
            int p = l.get(i);
            if(!visited[p])
            {
                dfsUtil(p,adj,visited);
            }
        }
    }
}
        
        
        
        
        /************Not Efficient for the large graph*********************/
        /*ArrayList<Integer> res = new ArrayList<>();
        
        int i,j;
        for(i=0;i<V;i++)
        {
            
            //System.out.print("For value "+i+" ");
            boolean visited[] = new boolean[V];  //boolean array..
            for(int k=0;k<V;k++)
            {
                visited[k]=false;
            }
            
            //for particular node value..find its neighbour.
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            
            while(!q.isEmpty())
            {
                int value = q.poll();//remove the top element..
                visited[value]=true;  //current node is visited..
                
                //neighbour of the value..
                ArrayList<Integer> ch = adj.get(value);
                 //traverse the neighbour..and update the visited array..
                 if(ch.isEmpty())
                 {
                     break;
                 }
                 
                 for(j=0;j<ch.size();j++)
                 {
                     int val = ch.get(j);
                     if(!visited[val])
                     {
                        //visited[val]=true;
                        q.add(val);
                     }
                 }
            }
            boolean exist = true;
            for(j=0;j<visited.length;j++)
            {
                if(visited[j]==false)
                {
                    exist=false;
                }
            }
            if(exist==true)
            {
                res.add(i);
            }
            //System.out.println("valid list is "+res);
        }
        //now the minimum value will be the answer..
        Collections.sort(res);
        
        //System.out.println(res);
        
        if(res.isEmpty())
        {
            return -1;
        }
        return res.get(0);*/

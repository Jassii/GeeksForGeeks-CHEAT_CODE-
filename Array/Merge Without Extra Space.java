// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int arr1[] = new int[n];
            int arr2[] = new int[m];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().merge(arr1, arr2, n, m);

            StringBuffer str = new StringBuffer();
            for (int i = 0; i < n; i++) {
                str.append(arr1[i] + " ");
            }
            for (int i = 0; i < m; i++) {
                str.append(arr2[i] + " ");
            }
            System.out.println(str);
        }
    }
}// } Driver Code Ends


class Solution 
{
    public void merge(int arr1[], int arr2[], int n, int m) 
    {
        // code here
        
        //this method is time taking..
        
        /*int i=0,j=0;
        while(i<n)
        {
            if(arr1[i]>arr2[j])
            {
                int temp = arr1[i];
                arr1[i]=arr2[j];
                arr2[j]=temp;
                i++;
                Arrays.sort(arr2);  //sort second array again and again..
            }
        }*/
        
        int i=0;  //first array..
        int k=n-1;  //will point to the last element of the first array..
        int j=0;  //for second array..
        
        while(i<=k && j<m)
        {
            if(arr1[i]>arr2[j])
            {
                //swap with the last..
                int temp = arr1[k];
                arr1[k] = arr2[j];
                arr2[j]=temp;
                j++;
                k--;
            }
            else
            {
                i++;
            }
        }
       
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
    }
}

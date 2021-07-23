class Solution 
{
    public int maxProfit(int[] prices) 
    {
        int i;
        int max=0;
        int min=Integer.MAX_VALUE;
        for(i=0;i<prices.length;i++)
        {
            if(prices[i]<min)
            {
                min=prices[i];  //for finding the min cost value..
            }
            max = Math.max(max,prices[i]-min);  //this is basically considered for the max profit.
        }
        return max;//return the max profit..
    }
}

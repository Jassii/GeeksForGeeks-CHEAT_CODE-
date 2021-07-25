class Solution 
{
    public int[][] merge(int[][] intervals) 
    {
        //before starting kindly sort the array..
        //Arrays.sort(intervals, Comparator.comparingDouble(o -> o[0]));
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        
        int row = intervals.length;
        int col = intervals[0].length;
        if(row==1 || col==1)
        {
            return intervals;
        }
        
        ArrayList<int[]> list = new ArrayList<>();
        int newinterval[] = intervals[0];
        
        list.add(newinterval);
        
        for(int[] interval:intervals)
        {
            if(interval[0]<=newinterval[1])
            {
                newinterval[1] = Math.max(interval[1],newinterval[1]);
            }
            else
            {
                newinterval=interval;
                list.add(newinterval);
            }
        }
        return list.toArray(new int[list.size()][]);
        
    }
}

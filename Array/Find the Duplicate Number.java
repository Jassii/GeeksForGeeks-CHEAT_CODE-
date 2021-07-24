class Solution 
{
    public int findDuplicate(int[] nums) 
    {
        //using map method//
        //not efficient..method.
        /*Map<Integer,Integer> M = new HashMap<>();
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
        int val=0;
        for(Map.Entry<Integer,Integer> entry:M.entrySet())
        {
            if(entry.getValue()>1)
            {
                val = entry.getKey();
                break;
            }
        }
        return val;*/
        
        //trying with the optimised way..
        
        //sort the array..values will come closer..
        if(nums.length==0)
        {
            return -1;
        }
        Arrays.sort(nums);
        int i,val=0;
        for(i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1])
            {
                val=nums[i];
                break;
            }
            else
            {
                continue;
            }
        }
        return val;
    }
}

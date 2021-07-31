class Solution 
{
    public int search(int[] nums, int target) 
    {
        //have done with O(n) time complexity..
        
        /*if(nums.length==1)
        {
            if(nums[0]==target)
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }
        
        //traverse the array and check if its equal..
        int i;
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]==target)
            {
                return i;
            }
        }
        return -1;*/
        
        //now first find the rotated index..
        
        //or our main intention is to find the (pivot index....)or smallest element index
        if(nums.length==0)
        {
            return -1;
        }
        
        
        int left=0;
        int right=nums.length-1;
        
        while(left<right)
        {
            //modified binary search type..
            int mid=(left+right)/2; //middle index..
            if(nums[mid]>nums[right])
            {
                left=mid+1;
            }
            else
            {
                right=mid;
            }
        }
        
        //(low) will be containg the minimum element index..
        
        int start=left;  //starting index..
        
        
        //this below step will actually decrease the array to be checked..
        left=0;
        right=nums.length-1;
        
        if(target>=nums[start] && target<=nums[right])  //(0,1,2)
        {
            left = start;  //will check only the right side of the array..
        }
        else  //(4,5,6,7)
        { 
            right=start;  //now will be checking the left side of the array..
        }
        
        
        //now we do the regular binary search.
        while(left<=right)
        {
            int mid = (left+right)/2;
            if(nums[mid]==target)  //if it matches with the element at the middle index..
            {
                return mid;
            }
            else if(target>nums[mid])
            {
                left = mid+1;
            }
            else
            {
                right = mid-1;
            }
        }
        return -1;
                
    }
}

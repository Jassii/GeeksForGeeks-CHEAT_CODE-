// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.



class Solution 
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        //Brute Force approach..
        /*int i,j;
        int r = matrix.length;
        int c = matrix[0].length;
        for(i=0;i<r;i++)
        {
            for(j=0;j<c;j++)
            {
                if(matrix[i][j]==target)
                {
                    return true;
                }
            }
        }
        return false;*/
        
        //Optimized apporach..
        
        int r = matrix.length;
        int c = matrix[0].length;
        //if size is 0 and 0..(both)
        if(r==0 && c==0)
        {
            return false;
        }
        
        //if it is not in range..
        if(target<matrix[0][0] || target>matrix[r-1][c-1])
        {
            return false;
        }
        
        int i=0,j=c-1;
        while(i<r && j>=0)
        {
            if(matrix[i][j]==target)
            {
                return true;
            }
            if(target<matrix[i][j]) //if it is less than then simply subtract the column..
            {
                j--;
            }
            else  //if it is more than the last value of the row..then definitely it will be in the next row..
            {
                i++;
            }
        }
        return false;  //if not found..return false..
    }
}

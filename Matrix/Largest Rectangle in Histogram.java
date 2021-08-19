// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

// Input: heights = [2,1,5,6,2,3]
// Output: 10
// Explanation: The above is a histogram where width of each bar is 1.
// The largest rectangle is shown in the red area, which has an area = 10 units.

class Solution 
{
    public int largestRectangleArea(int[] heights) 
    {
        Stack<Integer> S = new Stack<>(); //this will help in finding the left and right index.
        
        int left[] = new int[heights.length]; //left side index.
        int right[] = new int[heights.length]; //right side index.
       int area=0;
        
        //traversing from left side of the heights array.
        //for left side..
        int i;
        for(i=0;i<heights.length;i++)
        {
            if(S.isEmpty()) //for first element.
            {
                left[i] = 0;
                S.push(i);  //push the index not the value..
            }
            else //when stack is not empty.
            {
                while(!S.isEmpty() && (heights[S.peek()]>=heights[i]))
                {
                    S.pop();
                }
                //can be a case (stack empty or heights is less than i'th element.)
                left[i] = (S.isEmpty())?0:S.peek()+1;
                S.push(i);
            }
        }
        
        //before making a right side array..first clear the stack..
        while(!S.isEmpty())
        {
            S.pop();
        }
        
        //traversing from right side of the heights array.
        //for right side..
        for(i=heights.length-1;i>=0;i--)
        {
            if(S.isEmpty())
            {
                right[i] = heights.length-1;
                S.push(i);
            }
            else
            {
                while(!S.isEmpty() && heights[S.peek()]>=heights[i])
                {
                    S.pop();
                }
                right[i] = S.isEmpty()?heights.length-1:S.peek()-1;
                S.push(i);
            }
        }
        
        //now we have to find the area for each bar..
        for(i=0;i<heights.length;i++)
        {
            int num = right[i]-left[i]+1; //this will tell about the widht of the rectangle.
            area = Math.max(area,heights[i]*num);
        }
        
        return area;
    }
}

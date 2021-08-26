// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// Implement the MinStack class:

// MinStack() initializes the stack object.
// void push(val) pushes the element val onto the stack.
// void pop() removes the element on the top of the stack.
// int top() gets the top element of the stack.
// int getMin() retrieves the minimum element in the stack.
 

// Example 1:

// Input
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]

// Output
// [null,null,null,null,-3,null,0,-2]

// Explanation
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin(); // return -3
// minStack.pop();
// minStack.top();    // return 0
// minStack.getMin(); // return -2
 

// Constraints:

// -231 <= val <= 231 - 1
// Methods pop, top and getMin operations will always be called on non-empty stacks.
// At most 3 * 104 calls will be made to push, pop, top, and getMin.

class MinStack 
{
    /** initialize your data structure here. */
    Stack<Integer> S;
    int min;
    public MinStack() 
    {
        S = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    //consider the stack contains the minimum value.
    
    public void push(int val) 
    {
        if(val<=min) //value to be inserted is less than minvalue..
        {
            S.push(min); //push the min value first
            
            min = val;//minimum value will be updated.
        }
        S.push(val);  //now smaller value will be at the top..
    }
    
    //now its time to pop the element.
    public void pop() 
    {
        //if the pop element is the min value..
        if(S.pop()==min) //if pop value matches with the min value..
        {
            //update the min value. to the original min value of two times pop..
            min = S.pop();
        }
    }
    
    //return the peek element from the stack..
    public int top() 
    {
        return S.peek();
    }
     
    
    //return the min value from the stack..
    public int getMin() 
    {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

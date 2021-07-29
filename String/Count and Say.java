class Solution 
{
    public String countAndSay(int n) 
    {
       //some base cases..
        if(n==1)
        {
            return "1";
        }
        if(n==2)
        {
            return "11";
        }
        
        String S = "11";
        
        
        int c=1;  //for any character min count will be 1..
        int i,j;
        for(i=3;i<=n;i++)  //till the nth value..
        {
            S = S+'&'; //As the value is update for every value of i..
            String t = "";  //final string..
            
            for(j=1;j<S.length();j++)
            {
                 if(S.charAt(j)==S.charAt(j-1))  //if equal..update the count..
                 {
                     c++;
                 }
                 else  //if not..
                 {
                     t = t + Integer.toString(c);  //add the count first..
                     t = t + Character.toString(S.charAt(j-1));  //then the respective value..
                     c=1;  //initialize the count value to 1..
                 } 
            }
            S=t;  //update the value of S...
        }    
        return S;  //return the string.
    }
}

import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
	    Scanner sc = new Scanner(System.in);
    /*************************************************************************************************************************************/
    //Using HashMap.
	    String S = "geeksforgeeks";
	    HashMap<Character,Integer> M = new HashMap<>();
	    int i;
	    for(i=0;i<S.length();i++)
	    {
	        char ch = S.charAt(i);
	        if(M.containsKey(ch))
	        {
	            M.put(ch,M.get(ch)+1);
	        }
	        else
	        {
	            M.put(ch,1);
	        }
	    }
	    for(Map.Entry<Character,Integer> entry : M.entrySet())
	    {
	        if(entry.getValue()>1)
	        {
	            System.out.println(entry.getKey()+"  "+entry.getValue());
	        }
	    }
    /************************************************************************************************************************************/
    //One more method to get the count and the character as well..(Using only array..)
    
    
    int no=256;
    int count[] = new int[no];
    int i;
    for(i=0;i<S.length();i++)
    {
      char ch = S.charAt(i);
      count[ch]++;
    }
    for(i=0;i<no;i++)
    {
      if(count[i]>1)
      {
        System.out.println((char)i+"   "+count[i]);
      }
    }
	}
}

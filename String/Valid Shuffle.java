// Java Program to Check if a string is a valid shuffle of two distinct strings


// In this example, we will check if a string is the valid shuffle of two other strings in Java.

// Example S1 = XY, S2 = 12

// Let S3 = 1XY2  ....."YES"..
//     S3 = Y1X2 ......"YES"..
//     S3 = Y21XX ....."NO"..
    
    
/********************************************  C  O  D  E  ***********************************************************/
    



import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
	    Scanner sc = new Scanner(System.in);
	    String s1 = sc.nextLine();
	    String s2 = sc.nextLine();
	    
	    String s3 = sc.nextLine();
	    
	    String temp = s1.concat(s2);  //concat both the strings s1 and s2..
	    
	    //now compare temp with s3..
	    //traverse s3..
	    int i;
	    for(i=0;i<s3.length();i++)
	    {
	        char ch = s3.charAt(i);
	        
	        //now for this particular character, we will check if it is present in temp or not.if "yes" remove 
	        //that character from the temp..and continue..
	        
	        int index = temp.indexOf(ch);
	        if(index==-1)
	        {
	            System.out.println("NO String s3 is not a valid shuffle..");
	            System.exit(0);
	        }
	        else
	        {
	            //now that we have the index of that character in temp...now we will remove that character..from temp.
	            temp = temp.substring(0,index)+temp.substring(index+1);
	        }
	    }
	   System.out.println("YES the string S3 is a valid shuffle..");
	}
}    

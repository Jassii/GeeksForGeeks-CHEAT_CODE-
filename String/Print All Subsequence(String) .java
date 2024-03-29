// Print all subsequences of a string

// Given a string, we have to find out all subsequences of it. A String is a subsequence of a given String, that is generated by deleting some character of a given string without changing its order.

// Examples: 

// Input : abc
// Output : a, b, c, ab, bc, ac, abc

// Input : aaa
// Output : a, aa, aaa

/******************************************  C  O  D  E  ********************************************************************/

import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		String S = sc.nextLine();  //input the string.
		
		Set<String> set = new HashSet<>(); //tis is used for removing duplicates..
		
		//will be using recursive method..
		func("",0,S.length(),S,set);  //final string,index, length of the string , Original string..
		System.out.println(set);
	}
	
	public static void func(String t,int i,int n,String S,Set<String> set)  
	{
	    //Base case..that means one iteration is completed..or one substring is formed..
	    if(i==n)
	    {
	        if(!set.contains(t))
	        {
	            set.add(t);
	        }
	    }
	    else
	    {
	        //ek baar include na karao..
	        func(t,i+1,n,S,set);
	        //ab ek baar include kra do.
	        t = t + Character.toString(S.charAt(i));  //include kra diya i'th character ko.
	        func(t,i+1,n,S,set);
	    }
	    
	}
}

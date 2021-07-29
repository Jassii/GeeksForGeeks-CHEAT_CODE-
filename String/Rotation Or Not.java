A Program to check if strings are rotations of each other or not

// Difficulty Level : Easy

// Last Updated : 20 Jul, 2021


// Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1? 
// (eg given s1 = ABCD and s2 = CDAB, return true, given s1 = ABCD, and s2 = ACBD , return false)


/***********************************************  C  O  D   E ***********************************************************************/


import java.util.*;
public class Main
{
	public static void main(String[] args) 
	{
	    Scanner sc = new Scanner(System.in);
	    String s1 = sc.nextLine();
	    String s2 = sc.nextLine();
	    
	    //if you have to check if the string is rotation of other string..then simpy do this..
	    
	    String temp = s1.concat(s1);  //concat the same string twice..
	    
	    //now check if the s2 is there in temp as the substring..
	    if(temp.contains(s2))
	    {
	        System.out.println("Yes they both are the rotations of each other..");
	        System.exit(0);
	    }
	    System.out.println("No they are not the rotations of each other..");
	}
}

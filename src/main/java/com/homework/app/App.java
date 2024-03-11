package com.homework.app;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    //Methods aim is getting First count1 elements of x1 and first count2 elements of x2, later picking up a number randomly.
    public static Integer randomSelect(ArrayList<Integer> x1, ArrayList<Integer> x2, int count1, int count2){
    	ArrayList<Integer> all=new ArrayList<>();
    	
    	if(x1!=null) for(int i=0;i<count1;i++) if(x1.size()>i) all.add(x1.get(i));
    	if(x2!=null) for(int i=0;i<count2;i++) if(x2.size()>i) all.add(x2.get(i)); 
    	
    	if(all.size()==0) return null;
    	//all now contains all the possible numbers, now randomly select one
    	return all.get((int)(Math.random()*all.size()));
    	
    }
}

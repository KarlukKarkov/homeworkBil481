package com.homework.app;
import java.util.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
  public void testEmptyLists(){
	ArrayList<Integer> x1= new ArrayList<>();
	ArrayList<Integer> x2= new ArrayList<>();
	assertEquals(null, App.randomSelect(x1,x2,x1.size(),x2.size()));
}

public void testLongerLimits(){
	ArrayList<Integer> x1= new ArrayList<>();
	ArrayList<Integer> x2= new ArrayList<>();
	x1.add(1);
	x2.add(1);
	assertEquals(1, (int)App.randomSelect(x1,x2,5,5));
}

public void testNullLists(){
	assertEquals(null, App.randomSelect(null,null,0,0));
}

public void testNullListsWithLongerLimits(){
	assertEquals(null,App.randomSelect(null,null,3,3));
}

}

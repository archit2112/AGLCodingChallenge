package com.dev;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ConsumeWebServiceTest {
	ConsumeWebService cws = new ConsumeWebService();
	ArrayList<String> names = new ArrayList<String>();
	
	@Before
	public void init(){
	names.add("Betty");
	names.add("Amy");
	names.add("Zen");
	names.add("Stephan");
	}
	
	@Test
	public void testSortAndPrint_sizeTest() {
		cws.sortAndPrint(names);
		assertEquals("Checking size of List", 4, names.size());
	}
	@Test
	public void testSortAndPrint_orderTest() {
		cws.sortAndPrint(names);
		assertEquals("Checking sorting order", "[Amy, Betty, Stephan, Zen]", names.toString());
	}
	@Test
	public void testGetJSONfromService_invalidServiceTest() {
		//should return an empty JSON string
		assertEquals("Checking returned JSON Strinf", "", cws.getJSONfromService("http://agl-developer-test.azurewebsites.com"));
	}
	

}

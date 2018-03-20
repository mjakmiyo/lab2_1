package edu.iis.mto.bsearch;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class BinarySearchTest {
	
	int testarray[] = {1, 3, 4, 5, 6, 7, 8};
	
	@Test
	public void ElementFoundinSequence()
	{
		assertThat(BinarySearch.search(1, testarray).isFound(), Matchers.is(true));
	}
	
	@Test
	public void ElementNotFoundinSequence()
	{
		assertThat(BinarySearch.search(9, testarray).isFound(), Matchers.is(false));
	}
	
	@Test
	public void IsAFirstElement()
	{
		int element = 0;
		assertThat(BinarySearch.search(1, testarray).getPosition() -1, Matchers.is(element));
	}
	
	@Test
	public void IsALastElement()
	{
		int element = testarray.length -1 ;
		assertThat(BinarySearch.search(8, testarray).getPosition() -1, Matchers.is(element));
	}
	
	@Test
	public void IsAMiddleElement()
	{
		int element = testarray.length/2 +1;
		assertThat(BinarySearch.search(testarray[testarray.length/2 +1], testarray).getPosition() -1, Matchers.is(element));
	}
	
	@Test (expected=ArrayIndexOutOfBoundsException.class)
	public void ElementNotFoundinSquenceButLargerThanOne()
	{
		int element = 2;
		assertThat(testarray[BinarySearch.search(element, testarray).getPosition()], Matchers.is(-1));
	}

}



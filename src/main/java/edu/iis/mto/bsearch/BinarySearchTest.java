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
		int element = 1;
		assertThat(BinarySearch.search(element, testarray).getPosition() -1, Matchers.is(element));
	}
	
	@Test
	public void IsALastElement()
	{
		int element = 8 ;
		assertThat(BinarySearch.search(element, testarray).getPosition() -1, Matchers.is(element));
	}
	
	@Test
	public void IsAMiddleElement()
	{
		int element = testarray.length/2 +1;
		assertThat(BinarySearch.search(element, testarray).getPosition() -1, Matchers.is(element));
	}
	
	@Test
	public void ElementNotFoundinSquenceButLargerThanOne()
	{
		int element = 9;
		assertThat(BinarySearch.search(element, testarray).getPosition() -1, Matchers.is(element));
	}
	
}

package lab2_1;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;

public class Tests {
	
	int[] oneElementArray;
	int[] biggerArrayOdd;
	int[] biggerArrayEven;
	
	@Before
	public void testData() {
		 this.oneElementArray = new int[] {5};
		 this.biggerArrayOdd = new int[] {1,2,3,4,5};
		 this.biggerArrayEven = new int[] {0,1,2,3,4,5};
	}
	
	@After
	public void tearDown() throws Exception {
		this.oneElementArray = null;
		this.biggerArrayOdd = null;
		this.biggerArrayEven = null;
	}
	
	@Test
	public void Length1ShouldBeInSequence() {
		assertTrue(BinarySearch.search(5, oneElementArray).isFound());
	}
	
	@Test
	public void Length1ShouldNotBeInSequence() {
		assertFalse(BinarySearch.search(1, oneElementArray).isFound());
	}
	
	@Test
	public void ShouldBeFirst() {
		assertEquals(1, BinarySearch.search(1, biggerArrayOdd).getPosition());
	}
	
	@Test
	public void ShouldBeLast() {		
		assertEquals(biggerArrayOdd.length, BinarySearch.search(5, biggerArrayOdd).getPosition());
	}
	
	@Test
	public void ShouldBeInTheMiddleOddArray() {
		assertThat(3, is(BinarySearch.search(3, biggerArrayOdd).getPosition()));
	}
	
	@Test
	public void ShouldBeInTheMiddleEvenArray() {
		assertThat(4, is(BinarySearch.search(3, biggerArrayEven).getPosition()));
	}
	
	@Test
	public void ShouldNotBeInSequence() {
		assertFalse(BinarySearch.search(8, biggerArrayOdd).isFound());
	}
}

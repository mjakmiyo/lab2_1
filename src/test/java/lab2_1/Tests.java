package lab2_1;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;

public class Tests {
	
	@Test
	public void Length1ShouldBeInSequence() {
		assertTrue(BinarySearch.search(5, new int[] {5}).isFound());
	}
	
	@Test
	public void Length1ShouldNotBeInSequence() {
		assertFalse(BinarySearch.search(5, new int[] {0}).isFound());
	}
	
	@Test
	public void ShouldBeFirst() {
		assertEquals(1, BinarySearch.search(1, new int[] {1,3,2,1}).getPosition());
	}
	
	@Test
	public void ShouldBeLast() {
		assertEquals(5 , BinarySearch.search(5, new int[] {4,1,2,3,5}).getPosition());
	}
	
	@Test
	public void ShouldBeInTheMiddle() {
		assertEquals(2 , BinarySearch.search(2, new int[] {1,2,4}).getPosition());
	}
	
	@Test
	public void NotInSequence() {
		assertEquals(false , BinarySearch.search(8, new int[] {1,2,4,11,12,15}).isFound());
	}
}

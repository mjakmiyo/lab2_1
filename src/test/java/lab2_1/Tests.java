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
}

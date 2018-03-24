package lab2_1;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;

public class Tests {
	
	@Test
	public void ShouldBeInOneElementSequence() {
		final boolean EXPECTED = true;
		int key = 3;
		int[]  oneElementArray = new int[] {3};
		assertThat(EXPECTED,is(BinarySearch.search(key, oneElementArray).isFound()));
	}
	
	@Test
	public void ShouldNotBeInOneElementSequence() {
		final boolean EXPECTED = false;
		int key = 5;
		int[] oneElementArray = new int[] {3};
		assertThat(EXPECTED,is(BinarySearch.search(key, oneElementArray).isFound()));
	}
	
	@Test
	public void ShouldBeFirst() {
		final int EXPECTED = 1;
		int key = 1;
		int[] biggerArray = new int[] {1,2,3,4,5};
		assertThat(EXPECTED, is(BinarySearch.search(key, biggerArray).getPosition()));
	}
	
	@Test
	public void ShouldBeLast() {	
		int key = 9;
		int[] biggerArray = new int[] {5,6,7,8,9};
		final int EXPECTED = biggerArray.length;
		assertThat(EXPECTED, is(BinarySearch.search(key, biggerArray).getPosition()));
	}
	
	@Test
	public void ShouldBeInTheMiddleOddArray() {
		int key = 17;
		int[] biggerArray = new int[] {15,16,17,18,19};
		final int EXPECTED = (biggerArray.length/2)+1;
		assertThat(EXPECTED, is(BinarySearch.search(key, biggerArray).getPosition()));
	}
	
	@Test
	public void ShouldBeInTheMiddleEvenArray() {
		int key = 118;
		int[] biggerArray = new int[] {115,116,117,118,119,120};
		final int EXPECTED = (biggerArray.length/2)+1;
		assertThat(EXPECTED, is(BinarySearch.search(key, biggerArray).getPosition()));
	}
	
	@Test
	public void ShouldNotBeInSequence() {
		int key = 17;
		int[] biggerArray = new int[] {1,2,3,4,5};
		final boolean EXPECTED = false;
		assertThat(EXPECTED, is(BinarySearch.search(key, biggerArray).isFound()));
	}
	
	@Test
	public void ShouldBeInSequence() {
		int key = 1;
		int key2 = 3;
		int key3 = 5;
		int[] biggerArray = new int[] {1,2,3,4,5};
		final boolean EXPECTED = true;
		assertThat(EXPECTED, allOf(is(BinarySearch.search(key, biggerArray).isFound()), is(BinarySearch.search(key2, biggerArray).isFound()), is(BinarySearch.search(key3, biggerArray).isFound())));
	}
}

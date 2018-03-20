package lab2_1;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;

public class Tests {
	
	int[] oneElementArray;
	int[] biggerArray;
	int key;
	
	@Test
	public void Length1ShouldBeInSequence() {
		final boolean EXPECTED = true;
		this.key = 3;
		this.oneElementArray = new int[] {3};
		assertThat(EXPECTED,is(BinarySearch.search(key, oneElementArray).isFound()));
	}
	
	@Test
	public void Length1ShouldNotBeInSequence() {
		final boolean EXPECTED = false;
		this.key = 5;
		this.oneElementArray = new int[] {3};
		assertThat(EXPECTED,is(BinarySearch.search(key, oneElementArray).isFound()));
	}
	
	@Test
	public void ShouldBeFirst() {
		final int EXPECTED = 1;
		this.key = 1;
		this.biggerArray = new int[] {1,2,3,4,5};
		assertThat(EXPECTED, is(BinarySearch.search(key, biggerArray).getPosition()));
	}
	
	@Test
	public void ShouldBeLast() {	
		this.key = 9;
		this.biggerArray = new int[] {5,6,7,8,9};
		final int EXPECTED = biggerArray.length;
		assertThat(EXPECTED, is(BinarySearch.search(key, biggerArray).getPosition()));
	}
	
	@Test
	public void ShouldBeInTheMiddleOddArray() {
		this.key = 17;
		this.biggerArray = new int[] {15,16,17,18,19};
		final int EXPECTED = (biggerArray.length/2)+1;
		assertThat(EXPECTED, is(BinarySearch.search(key, biggerArray).getPosition()));
	}
	
	@Test
	public void ShouldBeInTheMiddleEvenArray() {
		this.key = 118;
		this.biggerArray = new int[] {115,116,117,118,119,120};
		final int EXPECTED = (biggerArray.length/2)+1;
		assertThat(EXPECTED, is(BinarySearch.search(key, biggerArray).getPosition()));
	}
	
	@Test
	public void ShouldNotBeInSequence() {
		this.key = 17;
		this.biggerArray = new int[] {1,2,3,4,5};
		final boolean EXPECTED = false;
		assertThat(EXPECTED, is(BinarySearch.search(key, biggerArray).isFound()));
	}
}

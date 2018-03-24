package lab2_1;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;

public class Tests {	
	
	@Test(expected = IllegalArgumentException.class )
    public void SequenceShouldBeEmpty(){
		SearchResult result = new SearchResult();
        int[] sequence = new int[0];
        int key = 3;
        result = BinarySearch.search(key, sequence);

    }
	
	@Test
    public void SequenceShouldNotBeSorted() {
        int[] notSortedSequence = {25, 345, 1, 1000, 10};
        final boolean EXPECTED = false;
        int key = 25;
        SearchResult result = new SearchResult();      
        BinarySearch.search(key, notSortedSequence);        
		result = BinarySearch.search(key, notSortedSequence);
		assertThat(EXPECTED, is(result.isFound()));
    }
	
	@Test
	public void ShouldBeInOneElementSequence() {
		final boolean EXPECTED = true;
		SearchResult result = new SearchResult();
		int key = 3;
		int[]  singleElementSequence = new int[] {3};
		result = BinarySearch.search(key, singleElementSequence);
		assertThat(EXPECTED,is(result.isFound()));
	}
	
	@Test
	public void ShouldNotBeInOneElementSequence() {
		final boolean EXPECTED = false;
		SearchResult result = new SearchResult();
		int key = 5;
		int[] singleElementSequence = new int[] {3};
		result = BinarySearch.search(key, singleElementSequence);
		assertThat(EXPECTED,is(result.isFound()));
	}
	
	@Test
	public void ShouldBeFirst() {
		final int EXPECTED = 1;
		SearchResult result = new SearchResult();
		int key = 1;
		int[] multiElementsSequence = new int[] {1,2,3,4,5};
		result = BinarySearch.search(key, multiElementsSequence);
		assertThat(EXPECTED, is(result.getPosition()));
	}
	
	@Test
	public void ShouldBeLast() {	
		int key = 9;
		SearchResult result = new SearchResult();
		int[] multiElementsSequence = new int[] {5,6,7,8,9};
		final int EXPECTED = multiElementsSequence.length;
		result = BinarySearch.search(key, multiElementsSequence);
		assertThat(EXPECTED, is(result.getPosition()));
	}
	
	@Test
	public void ShouldBeInTheMiddleOddArray() {
		int key = 17;
		SearchResult result = new SearchResult();
		int[] multiElementsSequence = new int[] {15,16,17,18,19};
		final int EXPECTED = (multiElementsSequence.length/2)+1;
		result = BinarySearch.search(key, multiElementsSequence);
		assertThat(EXPECTED, is(result.getPosition()));
	}
	
	@Test
	public void ShouldBeInTheMiddleEvenArray() {
		int key = 118;
		SearchResult result = new SearchResult();
		int[] multiElementsSequence = new int[] {115,116,117,118,119,120};
		final int EXPECTED = (multiElementsSequence.length/2)+1;
		result = BinarySearch.search(key, multiElementsSequence);
		assertThat(EXPECTED, is(result.getPosition()));
	}
	
	@Test
	public void ShouldNotBeInSequence() {
		int key = 17;
		SearchResult result = new SearchResult();
		int[] multiElementsSequence = new int[] {1,2,3,4,5};
		final boolean EXPECTED = false;
		result = BinarySearch.search(key, multiElementsSequence);
		assertThat(EXPECTED, is(result.isFound()));
	}
	
	@Test
	public void ShouldBeInSequence() {
		int key = 1;
		int key2 = 3;
		int key3 = 5;
		SearchResult result = new SearchResult();
		SearchResult result2 = new SearchResult();
		SearchResult result3 = new SearchResult();
		int[] multiElementsSequence = new int[] {1,2,3,4,5};
		final boolean EXPECTED = true;
		result = BinarySearch.search(key, multiElementsSequence);
		result2 = BinarySearch.search(key2, multiElementsSequence);
		result3 = BinarySearch.search(key3, multiElementsSequence);
		assertThat(EXPECTED, allOf(is(result.isFound()), is(result2.isFound()), is(result3.isFound())));
	}
}

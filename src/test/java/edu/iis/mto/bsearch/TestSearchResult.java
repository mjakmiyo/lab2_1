package edu.iis.mto.bsearch;

import org.junit.Test;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.is;

public class TestSearchResult {
	
	SearchResult searchResult;
	
	@Test(expected=IllegalArgumentException.class)
	public void isSequenceEmpty() {
		int seq[]= {};
		int key=777;
		searchResult=BinarySearch.search(key, seq);
	}
	
	@Test
	public void foundInSequence() {
		int key=7;
		int seq[]= {7};
		searchResult=BinarySearch.search(key, seq);
		Assert.assertThat(searchResult.isFound(), is(true));
	}
	
	@Test
	public void notFoundInSequence() {
		int key=7;
		int seq[]= {8};
		searchResult=BinarySearch.search(key, seq);
		Assert.assertThat(searchResult.isFound(), is(false));
	}
	
	@Test
	public void isFirstInSequence() {
		int key=7;
		int seq[]= {7,8,9,13,20,55,111};
		int index=1;
		searchResult=BinarySearch.search(key, seq);
		Assert.assertThat(searchResult.getPosition(), is(index));
	}
	
	@Test
	public void isLastInSequence() {
		int key=7;
		int seq[]= {5,6,7,19,23,25,32,41};
		int index=seq.length;
		searchResult=BinarySearch.search(key, seq);
		Assert.assertThat(searchResult.getPosition(),is(index));
	}
	
	@Test
	public void isMiddleInSequence() {
		int key=20;
		int seq[]= {5,6,7,19,20,25,43,111,120};
		int index=seq.length/2+1;
		searchResult=BinarySearch.search(key, seq);
		Assert.assertThat(searchResult.getPosition(),is(index));
	}
	
	@Test
	public void notFoundInSequenceWithNumberOfElementsGreaterThanOne() {
		int key=68;
		int seq[]= {5,6,7,34,53,99,111,122};
		searchResult=BinarySearch.search(key, seq);
		Assert.assertThat(searchResult.isFound(),is(false));
	}
}

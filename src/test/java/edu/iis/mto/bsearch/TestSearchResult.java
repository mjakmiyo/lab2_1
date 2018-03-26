package edu.iis.mto.bsearch;

import org.junit.Assert;
import org.junit.Test;

public class TestSearchResult {
	
	SearchResult searchResult;
	
	@Test
	public void foundInSequence() {
		int key=7;
		int seq[]= {7};
		searchResult=BinarySearch.search(key, seq);
		Assert.assertTrue(searchResult.isFound());
	}
	
	@Test
	public void notFoundInSequence() {
		int key=7;
		int seq[]= {8};
		searchResult=BinarySearch.search(key, seq);
		Assert.assertFalse(searchResult.isFound());
	}
	
	@Test
	public void isFirstInSequence() {
		int key=7;
		int seq[]= {7,8,9,13,20,55,111};
		int index=1;
		searchResult=BinarySearch.search(key, seq);
		Assert.assertEquals(index,searchResult.getPosition());
	}
	
	@Test
	public void isLastInSequence() {
		int key=7;
		int seq[]= {5,6,7,19,23,25,32,41};
		int index=3;
		searchResult=BinarySearch.search(key, seq);
		Assert.assertEquals(index,searchResult.getPosition());
	}
	
	@Test
	public void isMiddleInSequence() {
		int key=20;
		int seq[]= {5,6,7,19,20,25,43,111,120};
		int index=5;
		searchResult=BinarySearch.search(key, seq);
		Assert.assertEquals(index,searchResult.getPosition());
	}
	
	@Test
	public void notFoundInSequenceWithNumberOfElementsGreaterThanOne() {
		int key=68;
		int seq[]= {5,6,7,34,53,99,111,122};
		searchResult=BinarySearch.search(key, seq);
		Assert.assertFalse(searchResult.isFound());
	}
}

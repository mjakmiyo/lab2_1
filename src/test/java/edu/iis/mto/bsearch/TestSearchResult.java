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
		int seq[]= {7,8,9};
		int index=1;
		searchResult=BinarySearch.search(key, seq);
		Assert.assertEquals(index,searchResult.getPosition());
	}
	
	@Test
	public void isLastInSequence() {
		int key=7;
		int seq[]= {5,6,7};
		int index=3;
		searchResult=BinarySearch.search(key, seq);
		Assert.assertEquals(index,searchResult.getPosition());
	}
	
	@Test
	public void isMiddleInSequence() {
		int key=6;
		int seq[]= {5,6,7};
		int index=2;
		searchResult=BinarySearch.search(key, seq);
		Assert.assertEquals(index,searchResult.getPosition());
	}
}

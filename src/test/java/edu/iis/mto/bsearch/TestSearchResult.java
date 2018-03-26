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
}

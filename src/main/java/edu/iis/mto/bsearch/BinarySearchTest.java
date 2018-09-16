package edu.iis.mto.bsearch;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BinarySearchTest {
	@Test
	public void itemShouldBeFoundAtBeginningOfManyElementsSequence() {
		final int key = 1;
		final int[] seq = { 1, 2, 3, 4, 5 };
		final SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(searchResult.isFound(), is(true));
		assertThat(seq[searchResult.getPosition()], is(key));
	}

	@Test
	public void itemShouldBeFoundInOneElementSequence() {
		final int key = 1;
		final int[] seq = { key };
		final SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(searchResult.isFound(), is(true));
		assertThat(seq[searchResult.getPosition()], is(key));
	}

	@Test
	public void itemShouldNotBeFoundInOneElementSequence() {
		final int key = 1;
		final int[] seq = { 0 };
		final SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(searchResult.isFound(), is(false));
		assertThat(searchResult.getPosition(), is(-1));
	}

}
package edu.iis.mto.bsearch;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BinarySearchTest {
	@Test(expected = IllegalArgumentException.class)
	public void exceptionShouldBeThrownForEmptySequence() {
		final int key = 1;
		final int[] seq = {};
		BinarySearch.search(key, seq);
	}

	@Test
	public void itemShouldBeFoundAtBeginningOfManyElementsSequence() {
		final int key = 1;
		final int[] seq = { 1, 2, 3, 4, 5 };
		final SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(searchResult.isFound(), is(true));
		assertThat(seq[searchResult.getPosition()], is(key));
	}

	@Test
	public void itemShouldBeFoundInEndOfManyElementsSequence() {
		final int key = 5;
		final int[] seq = { 1, 2, 3, 4, 5 };
		final SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(searchResult.isFound(), is(true));
		assertThat(seq[searchResult.getPosition()], is(key));
	}

	@Test
	public void itemShouldBeFoundInMiddleOfManyElementsSequence() {
		final int key = 3;
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
	public void itemShouldBeFoundLeftFromMidInManyElementsSequence() {
		final int key = 3;
		final int[] seq = { 1, 2, 3, 4, 5, 6 };
		final SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(searchResult.isFound(), is(true));
		assertThat(seq[searchResult.getPosition()], is(key));
	}

	@Test
	public void itemShouldBeFoundRightFromMidInManyElementsSequence() {
		final int key = 4;
		final int[] seq = { 1, 2, 3, 4, 5, 6 };
		final SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(searchResult.isFound(), is(true));
		assertThat(seq[searchResult.getPosition()], is(key));
	}

	@Test
	public void itemShouldNotBeFoundInManyElementsSequence() {
		final int key = 6;
		final int[] seq = { 1, 2, 3, 4, 5 };
		final SearchResult searchResult = BinarySearch.search(key, seq);
		assertThat(searchResult.isFound(), is(false));
		assertThat(searchResult.getPosition(), is(-1));
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
package edu.iis.mto.bsearch;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void elementIsInOneElementSeq(){
        int searched = 0;
        int[] sequence = {0};
        SearchResult searchResult = BinarySearch.search(searched, sequence);
        assertThat(searchResult.isFound(), is(true));
        assertThat(sequence[searchResult.getPosition()], is(searched));
    }

    @Test
    public void elementIsNotInOneElementSeq(){
        int searched = 1;
        int[] sequence = {0};
        SearchResult searchResult = BinarySearch.search(searched, sequence);
        assertThat(searchResult.isFound(), is(false));
        assertThat(searchResult.getPosition(), is(-1));
    }

    @Test
    public void elementIsFirst(){
        int searched = 10;
        int[] sequence = {10, 20, 30};
        SearchResult searchResult = BinarySearch.search(searched, sequence);
        assertThat(searchResult.isFound(), is(true));
        assertThat(sequence[searchResult.getPosition()], is(searched));
    }

    @Test
    public void elementIsLast(){
        int searched = 30;
        int[] sequence = {10, 20, 30};
        SearchResult searchResult = BinarySearch.search(searched, sequence);
        assertThat(searchResult.isFound(), is(true));
        assertThat(sequence[searchResult.getPosition()], is(searched));
    }

    @Test
    public void elementIsInMiddle(){
        int searched = 20;
        int[] sequence = {10, 20, 30};
        SearchResult searchResult = BinarySearch.search(searched, sequence);
        assertThat(searchResult.isFound(), is(true));
        assertThat(sequence[searchResult.getPosition()], is(searched));
    }

    @Test
    public void elementIsOneAfterMiddle(){
        int searched = 20;
        int[] sequence = {10, 20, 30, 40, 50};
        SearchResult searchResult = BinarySearch.search(searched, sequence);
        assertThat(searchResult.isFound(), is(true));
        assertThat(sequence[searchResult.getPosition()], is(searched));
    }

    @Test
    public void elementIsOneBeforeMiddle(){
        int searched = 40;
        int[] sequence = {10, 20, 30, 40, 50};
        SearchResult searchResult = BinarySearch.search(searched, sequence);
        assertThat(searchResult.isFound(), is(true));
        assertThat(sequence[searchResult.getPosition()], is(searched));
    }

    @Test
    public void elementIsNotInFewElementsSeq(){
        int searched = 1;
        int[] sequence = {10, 20, 30};
        SearchResult searchResult = BinarySearch.search(searched, sequence);
        assertThat(searchResult.isFound(), is(false));
        assertThat(searchResult.getPosition(), is(-1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroElementsSeqThrowsException(){
        int searched = 1;
        int[] sequence = {};
        BinarySearch.search(searched, sequence);
    }

    @Test
    public void performanceIsLogarythmic(){
        int arrayLength = 1000000;
        int searched = arrayLength - 1;
        int[] sequence = new int[arrayLength];
        for(int i = 0; i < arrayLength; i++){
            sequence[i] = i;
        }
        SearchResult searchResult = BinarySearch.search(searched, sequence);
        assertThat((double)searchResult.getNumberOfIteration(), not(greaterThan(Math.ceil(Math.log(arrayLength) / Math.log(2)))));
    }
}
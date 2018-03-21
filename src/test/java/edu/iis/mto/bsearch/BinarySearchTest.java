package edu.iis.mto.bsearch;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
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
    public void elementIsFirstInFewElementsSeq(){
        int searched = 10;
        int[] sequence = {10, 20, 30};
        SearchResult searchResult = BinarySearch.search(searched, sequence);
        assertThat(searchResult.isFound(), is(true));
        assertThat(sequence[searchResult.getPosition()], is(searched));
    }

    @Test
    public void elementIsLastInFewElementsSeq(){
        int searched = 30;
        int[] sequence = {10, 20, 30};
        SearchResult searchResult = BinarySearch.search(searched, sequence);
        assertThat(searchResult.isFound(), is(true));
        assertThat(sequence[searchResult.getPosition()], is(searched));
    }

    @Test
    public void elementIsInMiddleInFewElementsSeq(){
        int searched = 20;
        int[] sequence = {10, 20, 30};
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

    @Test
    public void zeroElementsSeqThrowsException(){
        int searched = 1;
        int[] sequence = {};
        try {
            BinarySearch.search(searched, sequence);
            fail();
        } catch (IllegalArgumentException ex){
        }
    }
}
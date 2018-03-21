package edu.iis.mto.bsearch;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void elementIsInOneElementSeq(){
        int searched = 0;
        int[] sequence = {0};
        SearchResult searchResult = BinarySearch.search(searched, sequence);
        assertTrue(searchResult.isFound());
        assertEquals(searched, sequence[searchResult.getPosition()]);
    }

    @Test
    public void elementIsNotInOneElementSeq(){
        int searched = 1;
        int[] sequence = {0};
        SearchResult searchResult = BinarySearch.search(searched, sequence);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    public void elementIsFirstInFewElementsSeq(){
        int searched = 10;
        int[] sequence = {10, 20, 30};
        SearchResult searchResult = BinarySearch.search(searched, sequence);
        assertTrue(searchResult.isFound());
        assertEquals(searched, sequence[searchResult.getPosition()]);
    }

    @Test
    public void elementIsLastInFewElementsSeq(){
        int searched = 30;
        int[] sequence = {10, 20, 30};
        SearchResult searchResult = BinarySearch.search(searched, sequence);
        assertTrue(searchResult.isFound());
        assertEquals(searched, sequence[searchResult.getPosition()]);
    }

    @Test
    public void elementIsInMiddleInFewElementsSeq(){
        int searched = 20;
        int[] sequence = {10, 20, 30};
        SearchResult searchResult = BinarySearch.search(searched, sequence);
        assertTrue(searchResult.isFound());
        assertEquals(searched, sequence[searchResult.getPosition()]);
    }

    @Test
    public void elementIsNotInFewElementsSeq(){
        int searched = 1;
        int[] sequence = {10, 20, 30};
        SearchResult searchResult = BinarySearch.search(searched, sequence);
        assertFalse(searchResult.isFound());
        assertEquals(-1, searchResult.getPosition());
    }

    @Test
    public void ZeroElementsSeqThrowsException(){
        int searched = 1;
        int[] sequence = {};
        try {
            SearchResult searchResult = BinarySearch.search(searched, sequence);
            fail();
        } catch (IllegalArgumentException ex){
        }
    }
}
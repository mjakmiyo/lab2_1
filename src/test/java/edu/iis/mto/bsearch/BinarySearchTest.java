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
}
package edu.iis.mto.bsearch;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class Testy_v1 {

    private BinarySearch binarySearch;
    private SearchResult searchResult;


    @Before
    public void setup() {
        binarySearch = new BinarySearch();
        searchResult = new SearchResult();

    }

    @Test
    public void oneElementIsInSequence() {
        int[] seq = {1};
        int key = 1;
        searchResult = binarySearch.search(key, seq);
        Assert.assertEquals(searchResult.isFound()==true && searchResult.getPosition()==key, seq[0]==1);

    }



    @Test
    public void oneElementIsNotInSequence() {
        int[] seq = {1};
        int key = 2;
        searchResult = binarySearch.search(key, seq);
        Assert.assertTrue(searchResult.isFound()==false && searchResult.getPosition()==-1);
    }

    @Test
    public void firstElementInSequence() {
        int[] seq = {1,2,3,5};
        int key = 1;
        searchResult = binarySearch.search(key, seq);
        Assert.assertTrue(searchResult.isFound()==true && searchResult.getPosition()==1);
    }
    @Test
    public void lastElementInSequence() {
        int[] seq = {1,2,4,5,6,10,13,15};
        int key = 15;
        searchResult = binarySearch.search(key, seq);
        Assert.assertTrue(searchResult.isFound()==true && searchResult.getPosition()==seq.length);
    }

    @Test
    public void middleElementInSequence() {
        int[] seq = {1,2,4,5,10,11,13,14,15,20,22};
        int key = 11;
        searchResult = binarySearch.search(key, seq);
        Assert.assertTrue(searchResult.isFound()==true && searchResult.getPosition()==6);
    }

    @Test
    public void elementNotInSequence() {
        int[] seq = {1,2,4,5,6,10,13,15,16,19};
        int key = 20;
        searchResult = binarySearch.search(key, seq);
        Assert.assertTrue(searchResult.isFound()==false && searchResult.getPosition()==-1);
    }
}

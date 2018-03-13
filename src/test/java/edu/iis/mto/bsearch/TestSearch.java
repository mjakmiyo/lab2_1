package edu.iis.mto.bsearch;

import org.junit.Assert;
import org.junit.Test;

public class TestSearch {

    @Test
    public void isFound() {
        int key = 5;
        int seq[] = {5};
        SearchResult search = BinarySearch.search(key, seq);
        Assert.assertTrue(search.isFound());
    }

}

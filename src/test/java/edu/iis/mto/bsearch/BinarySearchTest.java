package edu.iis.mto.bsearch;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BinarySearchTest {

    private BinarySearch binarySearch;


    @Before
    public void setup() {
        binarySearch = new BinarySearch();

    }

    @Test
    public void oneElementIsInSequence() {
        int[] seq = {1};
        int key = 1;
        assertEquals(binarySearch.search(key, seq).isFound() == true && binarySearch.search(key, seq).getPosition() == key, seq[0] == 1);
    }


    @Test
    public void oneElementIsNotInSequence() {
        int[] seq = {1};
        int key = 2;
        assertTrue(binarySearch.search(key, seq).isFound() == false && binarySearch.search(key, seq).getPosition() == -1);
    }

    @Test
    public void firstElementInSequence() {
        int[] seq = {1, 2, 3, 5};
        int key = 1;
        assertTrue(binarySearch.search(key, seq).isFound() == true && binarySearch.search(key, seq).getPosition() == 1);
    }

    @Test
    public void lastElementInSequence() {
        int[] seq = {1, 2, 4, 5, 6, 10, 13, 15};
        int key = 15;
        assertTrue(binarySearch.search(key, seq).isFound() == true && binarySearch.search(key, seq).getPosition() == seq.length);
    }

    @Test
    public void middleElementInSequence() {
        int[] seq = {1, 2, 4, 5, 10, 11, 13, 14, 15, 20, 22};
        int key = 11;
        assertTrue(binarySearch.search(key, seq).isFound() == true && binarySearch.search(key, seq).getPosition() == 6);
    }

    @Test
    public void elementNotInSequence() {
        int[] seq = {1, 2, 4, 5, 6, 10, 13, 15, 16, 19};
        int key = 20;
        assertTrue(binarySearch.search(key, seq).isFound() == false && binarySearch.search(key, seq).getPosition() == -1);
    }
}

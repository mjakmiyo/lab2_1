package edu.iis.mto.bsearch;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static edu.iis.mto.bsearch.BinarySearch.search;

import static org.junit.Assert.assertTrue;

public class BinarySearchTest {

    @Before
    public void setup() {

    }

    @Test
    public void keyIsInOneElementSequence() {
        int[] seq = {3};
        int key = 3;
        assertTrue(search(key, seq).isFound() && search(key, seq).getPosition() == 1);
    }


    @Test
    public void keyIsNotInOneElementSequence() {
        int[] seq = {1};
        int key = 2;
        assertTrue(!search(key, seq).isFound() && search(key, seq).getPosition() == -1);
    }

    @Test
    public void keyIsFirstElementInSequence() {
        int[] seq = {1, 2, 3, 5};
        int key = 1;
        assertTrue(search(key, seq).isFound() && search(key, seq).getPosition() == 1);
    }

    @Test
    public void keyIsLastElementInSequence() {
        int[] seq = {1, 2, 4, 5, 6, 10, 13, 15};
        int key = 15;
        assertTrue(search(key, seq).isFound() && search(key, seq).getPosition() == seq.length);
    }

    @Test
    public void keyIsMiddleElementInSequence() {
        int[] seq = {1, 2, 4, 5, 10, 11, 13, 14, 15, 20, 22};
        int key = 11;
        assertTrue(search(key, seq).isFound() && search(key, seq).getPosition() == 6);
    }

    @Test
    public void keyIsNotInSequence() {
        int[] seq = {1, 2, 4, 5, 6, 10, 13, 15, 16, 19};
        int key = 20;
        assertTrue(!search(key, seq).isFound() && search(key, seq).getPosition() == -1);
    }
}

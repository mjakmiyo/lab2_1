package edu.iis.mto.bsearch;

import org.junit.Before;
import org.junit.Test;

import static edu.iis.mto.bsearch.BinarySearch.search;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BinarySearchTest {

    @Before
    public void setup() {

    }

    @Test
    public void keyIsInOneElementSequence() {
        int[] seq = {3};
        int key = 3;
        int expectedPosition = 1;
        assertThat(search(key, seq).getPosition(), is(expectedPosition));
    }

    @Test
    public void keyIsNotInOneElementSequence() {
        int[] seq = {1};
        int key = 2;
        int expectedPosition = -1;
        assertThat(search(key, seq).getPosition(), is(expectedPosition));
    }

    @Test
    public void keyIsFirstElementInSequence() {
        int[] seq = {1, 2, 3, 5};
        int key = 1;
        int expectedPosition = 1;
        assertThat(search(key, seq).getPosition(), is(expectedPosition));
    }

    @Test
    public void keyIsLastElementInSequence() {
        int[] seq = {1, 2, 4, 5, 6, 10, 13, 15};
        int key = 15;
        int expectedPosition = seq.length;
        assertThat(search(key, seq).getPosition(), is(expectedPosition));
    }

    @Test
    public void keyIsLeftMiddleElementInEvenSequence() {
        int[] seq = {1, 2, 4, 5, 10, 11, 13, 14, 15, 20};
        int key = 10;
        int expectedPosition = 5;
        assertThat(search(key, seq).getPosition(), is(expectedPosition));
    }

    @Test
    public void keyIsRightMiddleElementInEvenSequence() {
        int[] seq = {1, 2, 4, 5, 10, 11, 13, 14, 15, 20};
        int key = 11;
        int expectedPosition = 6;
        assertThat(search(key, seq).getPosition(), is(expectedPosition));
    }

    @Test
    public void keyIsMiddleElementInOddSequence() {
        int[] seq = {1, 2, 4, 5, 6, 10, 11, 13, 14, 15, 20};
        int key = 10;
        int expectedPosition = 6;
        assertThat(search(key, seq).getPosition(), is(expectedPosition));
    }

    @Test
    public void keyIsNotInSequence() {
        int[] seq = {1, 2, 4, 5, 6, 10, 13, 15, 16, 19};
        int key = 20;
        int expectedPosition = -1;
        assertThat(search(key, seq).getPosition(), is(expectedPosition));
    }

    @Test
    public void keyIsNotInEmptySequence() {
        int[] seq = {};
        int key = 20;
        int expectedPosition = -1;
        assertThat(search(key, seq).getPosition(), is(expectedPosition));
    }
}

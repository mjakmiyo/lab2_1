package edu.iis.mto.bsearch;

import org.junit.Before;
import org.junit.Test;

import static edu.iis.mto.bsearch.BinarySearch.isSorted;
import static edu.iis.mto.bsearch.BinarySearch.search;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BinarySearchTest {

    @Before
    public void setup() {

    }

    @Test
    public void keyIsInOneElementSequence() {
        int[] seq = {3};
        int key = 3;
        int position = 1;
        assertThat(search(key, seq).getPosition(), is(position));
    }

    @Test
    public void keyIsNotInOneElementSequence() {
        int[] seq = {1};
        int key = 2;
        int position = -1;
        assertThat(search(key, seq).getPosition(), is(position));
    }

    @Test
    public void keyIsFirstElementInSequence() {
        int[] seq = {1, 2, 3, 5};
        int key = 1;
        int position = 1;
        assertThat(search(key, seq).getPosition(), is(position));
    }

    @Test
    public void keyIsLastElementInSequence() {
        int[] seq = {1, 2, 4, 5, 6, 10, 13, 15};
        int key = 15;
        int position = seq.length;
        assertThat(search(key, seq).getPosition(), is(position));
    }

    @Test
    public void keyIsMiddleElementInEvenSequence() {
        int[] seq = {1, 2, 4, 5, 10, 11, 13, 14, 15, 20};
        int key = 10;
        int position = (seq.length + 1) / 2;
        assertThat(search(key, seq).getPosition(), is(position));
    }

    @Test
    public void keyIsMiddleElementInOddSequence() {
        int[] seq = {1, 2, 4, 5, 6, 10, 11, 13, 14, 15, 20};
        int key = 10;
        int position = (seq.length + 1) / 2;
        assertThat(search(key, seq).getPosition(), is(position));
    }

    @Test
    public void keyIsNotInSequence() {
        int[] seq = {1, 2, 4, 5, 6, 10, 13, 15, 16, 19};
        int key = 20;
        int position = -1;
        assertThat(search(key, seq).getPosition(), is(position));
    }

    @Test
    public void keyIsNotInEmptySequence() {
        int[] seq = {};
        int key = 20;
        int position = -1;
        assertThat(search(key, seq).getPosition(), is(position));
    }
    @Test
    public void keyIsInNotSortedSequence() {
        int[] seq = {10, 12, 11, 5, 6, 10, 13, 4, 16, 19};
        int key = 10;
        int position = -1;
        assertThat(isSorted(seq), is(false));
        // TO DO check if sequence is sorted
        //TO DO check if sequence have duplicates -> throw IllegalArgumentException
        // TO DO if seq is empty get IllegalArgumentException
        //assertThat(search(key, seq).getPosition(), is(position));
    }
}

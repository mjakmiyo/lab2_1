package edu.iis.mto.bsearch;

import org.junit.Before;
import org.junit.Test;

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
        assertThat( search( key, seq ).getPosition(), is(1) );
    }


    @Test
    public void keyIsNotInOneElementSequence() {
        int[] seq = {1};
        int key = 2;
        assertThat( search( key, seq ).getPosition(), is(-1) );
    }

    @Test
    public void keyIsFirstElementInSequence() {
        int[] seq = {1, 2, 3, 5};
        int key = 1;
        assertThat( search( key, seq ).getPosition() , is(1));
    }

    @Test
    public void keyIsLastElementInSequence() {
        int[] seq = {1, 2, 4, 5, 6, 10, 13, 15};
        int key = 15;
        assertThat( search( key, seq ).getPosition() ,is(seq.length));
    }

    @Test
    public void keyIsMiddleElementInSequence() {
        int[] seq = {1, 2, 4, 5, 10, 11, 13, 14, 15, 20};
        int key = 10;
        assertThat( search( key, seq ).getPosition(), is((seq.length+1)/2));
    }

    @Test
    public void keyIsNotInSequence() {
        int[] seq = {1, 2, 4, 5, 6, 10, 13, 15, 16, 19};
        int key = 20;
        assertThat( search( key, seq ).getPosition(),is(-1));
    }
}

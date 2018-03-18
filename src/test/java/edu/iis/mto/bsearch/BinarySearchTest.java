package edu.iis.mto.bsearch;

import org.junit.Before;
import org.junit.Test;

import static edu.iis.mto.bsearch.BinarySearch.search;
import static org.junit.Assert.*;

public class BinarySearchTest {


    private static int size = (int) Math.ceil(Math.random() * 100 + 2);
    private static int[] seq;

    @Before
    public void setUp() {
        seq = new int[size];
        for(int i = size; i > 0; i--) {
            seq[i - 1] = i;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void showErrorWhenSeqIsEmpty() throws IllegalArgumentException{
        search(0, new int[0]);
    }

    @Test
    public void findElementInSeqWhenSeqLengthIsOne(){
        seq = new int[1];
        seq[0] = 1;
        assertTrue(search(1, seq).isFound());
    }

    @Test
    public void notFindElementInSeqWhenSeqLengthIsOne(){
        seq = new int[1];
        seq[0] = 1;
        assertTrue(!search(2, seq).isFound());
    }

    @Test
    public void notFindElementInSeqWhenSeqLengthIsBiggerThanOne(){
        assertTrue(!search(250, seq).isFound());
    }

    @Test
    public void findElementInSeqOnFirstPositionWhenSeqLengthIsBiggerThanOne(){
        assertTrue(search(seq[0], seq).getPosition() == 1);
    }

    @Test
    public void findElementInSeqOnLastPositionWhenSeqLengthIsBiggerThanOne(){
        assertTrue(search(seq[seq.length-1], seq).getPosition() == seq.length);
    }

    @Test
    public void findElementInSeqOnMiddlePositionWhenSeqLengthIsBiggerThanOne(){
        assertTrue(search(seq[(seq.length-1)/2], seq).getPosition() == (seq.length+1)/2);
    }
}
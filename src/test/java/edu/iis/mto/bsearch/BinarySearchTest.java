package edu.iis.mto.bsearch;

import org.junit.Test;

import static edu.iis.mto.bsearch.BinarySearch.search;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test(expected = IllegalArgumentException.class)
    public void showErrorWhenSeqIsEmpty() throws IllegalArgumentException{
        int key = 0;
        int[] seq = new int[0];
        search(key, seq);
    }

    @Test
    public void findElementInSeqWhenSeqLengthIsOne(){
        int key = 1;
        int[] seq = new int[1];
        seq[0] = 1;
        assertTrue(search(key, seq).isFound());
    }

    @Test
    public void notFindElementInSeqWhenSeqLengthIsOne(){
        int key = 2;
        int[] seq = new int[1];
        seq[0] = 1;
        assertTrue(!search(key, seq).isFound());
    }

    @Test
    public void notFindElementInSeqWhenSeqLengthIsBiggerThanOne(){
        int key = 250;
        int size = (int) Math.ceil(Math.random() * 100 + 2);
        int[] seq = new int[size];
        for(; size > 0; size--) {
            seq[size - 1] = size;
        }
        assertTrue(!search(key, seq).isFound());
    }

    @Test
    public void findElementInSeqOnFirstPositionWhenSeqLengthIsBiggerThanOne(){
        int size = (int) Math.ceil(Math.random() * 100 + 2);
        int[] seq = new int[size];
        for(; size > 0; size--) {
            seq[size - 1] = size;
        }
        int key = seq[0];
        assertTrue(search(key, seq).getPosition() == 1);
    }

    @Test
    public void findElementInSeqOnLastPositionWhenSeqLengthIsBiggerThanOne(){
        int size = (int) Math.ceil(Math.random() * 100 + 2);
        int[] seq = new int[size];
        for(; size > 0; size--) {
            seq[size - 1] = size;
        }
        int key = seq[seq.length-1];
        assertTrue(search(key, seq).getPosition() == seq.length);
    }

    @Test
    public void findElementInSeqOnMiddlePositionWhenSeqLengthIsBiggerThanOne(){
        int size = (int) Math.ceil(Math.random() * 100 + 2);
        int[] seq = new int[size];
        for(; size > 0; size--) {
            seq[size - 1] = size;
        }
        int key = seq[(seq.length-1)/2];
        assertTrue(search(key, seq).getPosition() == (seq.length+1)/2);
    }
}
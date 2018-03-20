package edu.iis.mto.bsearch;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import org.junit.Assert;
import org.junit.Test;

public class TestSearch {

    @Test
    public void isFound() {
        int key = 5;
        int seq[] = {5};
        SearchResult search = BinarySearch.search(key, seq);
        Assert.assertThat(search.isFound(), is(true));
    }

    @Test
    public void isNotFound() {
        int key = 5;
        int seq[] = {15};
        SearchResult search = BinarySearch.search(key, seq);
        Assert.assertThat(search.isFound(), is(not(true)));
    }

    @Test
    public void isFirstElement() {
        int key = 1;
        int position = 1;
        int seq[] = {1, 5, 6, 9, 10, 15, 17, 20, 25, 30, 40, 55};
        SearchResult search = BinarySearch.search(key, seq);
        Assert.assertThat(search.getPosition(), is(position));
    }

    @Test
    public void isLastElement() {
        int key = 55;
        int seq[] = {1, 5, 6, 9, 10, 15, 20, 25, 40, 55};
        int position = seq.length;
        SearchResult search = BinarySearch.search(key, seq);
        Assert.assertThat(search.getPosition(), is(position));
    }

    @Test
    public void isMiddleElement() {
        int key = 9;
        int seq[] = {1, 5, 6, 9, 10, 18, 31};
        int position = seq.length / 2 + 1;
        SearchResult search = BinarySearch.search(key, seq);
        Assert.assertThat(search.getPosition(), is(position));
    }

    @Test
    public void isNotFoundInLongerSequence() {
        int key = 13;
        int seq[] = {1, 5, 6, 9, 10, 15, 20, 25, 40, 55};
        SearchResult search = BinarySearch.search(key, seq);
        Assert.assertThat(search.isFound(), is(not(true)));
    }

    @Test
    public void isLeftMiddleInEvenSequence() {
        int key = 9;
        int seq[] = {1, 5, 6, 9, 10, 18, 31, 45};
        int position = seq.length / 2;
        SearchResult search = BinarySearch.search(key, seq);
        Assert.assertThat(search.getPosition(), is(position));
    }

    @Test
    public void isRightMiddleInEvenSequence() {
        int key = 10;
        int seq[] = {1, 5, 6, 9, 10, 18, 31, 45};
        int position = seq.length / 2 + 1;
        SearchResult search = BinarySearch.search(key, seq);
        Assert.assertThat(search.getPosition(), is(position));
    }
}

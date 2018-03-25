import edu.iis.mto.bsearch.BinarySearch;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinarySearchTests {

    @Test
    public void shouldFoundKeyInSequenceWithLength1() {
        int[] sequence = new int[] {1};
        int key = 1;
        assertThat(BinarySearch.search(key, sequence).isFound(), is(true));
    }
    @Test
    public void shouldNotFoundKeyInSequenceWithLength1() {
        int[] sequence = new int[] {2};
        int key = 3;
        assertThat(BinarySearch.search(key, sequence).isFound(), is(false));
    }
    @Test
    public void soughtKeyShouldBeFirstOnElementList() {
        int[] sequence = new int[] {1, 2, 3, 4};
        int key = 1;
        int position = 1;
        assertThat(BinarySearch.search(key, sequence).getPosition(), is(position));
    }
    @Test
    public void soughtKeyShouldBeLastOnElementList() {
        int[] sequence = new int[] {5, 7, 10, 13, 16};
        int key = 16;
        int position = 5;
        assertThat(BinarySearch.search(key, sequence).getPosition(), is(position));
    }
    @Test
    public void soughtKeyShouldBeInMiddleOfEvenLengthElementList() {
        int[] sequence = new int[] {6, 12, 18, 24, 36, 52};
        int key = 18;
        int position = 3;
        assertThat(BinarySearch.search(key, sequence).getPosition(), is(position));
    }
    @Test
    public void soughtKeyShouldBeInMiddleOfOddLengthElementList() {
        int[] sequence = new int[] {7, 13, 21, 25, 30};
        int key = 21;
        int position = 3;
        assertThat(BinarySearch.search(key, sequence).getPosition(), is(position));
    }
    @Test
    public void soughtKeyShouldBeInPreviousToMiddlePositionOfEvenLengthElementList() {
        int[] sequence = new int[] {2, 5, 8, 11, 14, 17, 20, 23, 26, 29};
        int key = 11;
        int position = 4;
        assertThat(BinarySearch.search(key, sequence).getPosition(), is(position));
    }
    @Test
    public void soughtKeyShouldBeInPreviousToMiddlePositionOfOddLengthElementList() {
        int[] sequence = new int[] {20, 24, 31, 36, 42, 47, 52, 56, 61, 66, 72};
        int key = 42;
        int position = 5;
        assertThat(BinarySearch.search(key, sequence).getPosition(), is(position));
    }
    @Test
    public void soughtKeyShouldBeInNextToMiddlePositionOfEvenLengthElementList() {
        int[] sequence = new int[] {5, 10, 15, 16, 25, 30, 31, 40, 45, 46};
        int key = 30;
        int position = 6;
        assertThat(BinarySearch.search(key, sequence).getPosition(), is(position));
    }
    @Test
    public void soughtKeyShouldBeInNextToMiddlePositionOfOddLengthElementList() {
        int[] sequence = new int[] {10, 12, 15, 18, 21, 23, 26, 28, 30, 33, 36};
        int key = 26;
        int position = 7;
        assertThat(BinarySearch.search(key, sequence).getPosition(), is(position));
    }
    @Test
    public void shouldFoundKeyInSequenceWithLengthBiggerThan1() {
        int[] sequence = new int[] {0, 2, 5, 6, 8, 11, 12, 14};
        int key = 12;
        assertThat(BinarySearch.search(key, sequence).isFound(), is(true));
    }
    @Test
    public void shouldNotFoundKeyInSequenceWithLengthBiggerThan1() {
        int[] sequence = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        int key = 9999;
        assertThat(BinarySearch.search(key, sequence).isFound(), is(false));
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException() {
        int[] sequence = new int[0];
        BinarySearch.search(9999, sequence);
    }
}


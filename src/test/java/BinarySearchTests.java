import edu.iis.mto.bsearch.BinarySearch;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinarySearchTests {

    private static int[] emptySequence;
    private static int[] oneElementSequence;
    private static int[] evenLengthSequence;
    private static int[] oddLengthSequence;

    @BeforeClass
    public static void setUpBeforeClass() {
        emptySequence = new int[0];
        oneElementSequence = new int[] {5};
        evenLengthSequence = new int[] {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        oddLengthSequence = new int[] {2, 4, 6, 8, 10, 12, 14, 16, 18};
    }

    @AfterClass
    public static void tearDownAfterClass() {
        emptySequence = null;
        oneElementSequence = null;
        evenLengthSequence = null;
        oddLengthSequence = null;
    }

    @Test
    public void shouldFoundKeyInSequenceWithLength1() {
        int key = oneElementSequence[0];
        assertThat(BinarySearch.search(key, oneElementSequence).isFound(), is(true));
    }
    @Test
    public void shouldNotFoundKeyInSequenceWithLength1() {
        int key = oneElementSequence[0] + 1;
        assertThat(BinarySearch.search(key, oneElementSequence).isFound(), is(false));
    }
    @Test
    public void soughtKeyShouldBeFirstOnElementList() {
        int key = evenLengthSequence[0];
        int position = 1;
        assertThat(BinarySearch.search(key, evenLengthSequence).getPosition(), is(position));
    }
    @Test
    public void soughtKeyShouldBeLastOnElementList() {
        int key = evenLengthSequence[evenLengthSequence.length - 1];
        int position = evenLengthSequence.length;
        assertThat(BinarySearch.search(key, evenLengthSequence).getPosition(), is(position));
    }
    @Test
    public void soughtKeyShouldBeInMiddleOfEvenLengthElementList() {
        int key = evenLengthSequence[evenLengthSequence.length / 2 - 1];
        int position = evenLengthSequence.length / 2;
        assertThat(BinarySearch.search(key, evenLengthSequence).getPosition(), is(position));
    }
    @Test
    public void soughtKeyShouldBeInMiddleOfOddLengthElementList() {
        int key = oddLengthSequence[oddLengthSequence.length / 2];
        int position = oddLengthSequence.length / 2 + 1;
        assertThat(BinarySearch.search(key, oddLengthSequence).getPosition(), is(position));
    }
    @Test
    public void soughtKeyShouldBeInPreviousToMiddlePositionOfEvenLengthElementList() {
        int key = evenLengthSequence[evenLengthSequence.length / 2 - 2];
        int position = evenLengthSequence.length / 2 - 1;
        assertThat(BinarySearch.search(key, evenLengthSequence).getPosition(), is(position));
    }
    @Test
    public void soughtKeyShouldBeInPreviousToMiddlePositionOfOddLengthElementList() {
        int key = oddLengthSequence[oddLengthSequence.length / 2 - 1];
        int position = oddLengthSequence.length / 2;
        assertThat(BinarySearch.search(key, oddLengthSequence).getPosition(), is(position));
    }
    @Test
    public void soughtKeyShouldBeInNextToMiddlePositionOfEvenLengthElementList() {
        int key = evenLengthSequence[evenLengthSequence.length / 2];
        int position = evenLengthSequence.length / 2 + 1;
        assertThat(BinarySearch.search(key, evenLengthSequence).getPosition(), is(position));
    }
    @Test
    public void soughtKeyShouldBeInNextToMiddlePositionOfOddLengthElementList() {
        int key = oddLengthSequence[oddLengthSequence.length / 2 + 1];
        int position = oddLengthSequence.length / 2 + 2;
        assertThat(BinarySearch.search(key, oddLengthSequence).getPosition(), is(position));
    }
    @Test
    public void shouldFoundKeyInSequenceWithLengthBiggerThan1() {
        int key = evenLengthSequence[2];
        assertThat(BinarySearch.search(key, evenLengthSequence).isFound(), is(true));
    }
    @Test
    public void shouldNotFoundKeyInSequenceWithLengthBiggerThan1() {
        int key = 9999;
        assertThat(BinarySearch.search(key, evenLengthSequence).isFound(), is(false));
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException() {
        BinarySearch.search(9999, emptySequence);
    }
}


import edu.iis.mto.bsearch.BinarySearch;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinarySearchTests {

    private static int[] emptySequence;
    private static int[] oneElementSequence;
    private static int[] longSequence;

    @BeforeClass
    public static void setUpBeforeClass() {
        emptySequence = new int[0];
        oneElementSequence = new int[] {5};
        longSequence = new int[] {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
    }

    @AfterClass
    public static void tearDownAfterClass() {
        emptySequence = null;
        oneElementSequence = null;
        longSequence = null;
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
        int key = longSequence[0];
        int position = 1;
        assertThat(BinarySearch.search(key, longSequence).getPosition(), is(position));
    }
    @Test
    public void soughtKeyShouldBeLastOnElementList() {
        int key = longSequence[longSequence.length - 1];
        int position = longSequence.length;
        assertThat(BinarySearch.search(key, longSequence).getPosition(), is(position));
    }
    @Test
    public void soughtKeyShouldBeInMiddleOnElementList() {
        int key = longSequence[longSequence.length / 2 - 1];
        int position = longSequence.length / 2;
        assertThat(BinarySearch.search(key, longSequence).getPosition(), is(position));
    }
    @Test
    public void shouldFoundKeyInSequenceWithLengthBiggerThan1() {
        int key = longSequence[2];
        assertThat(BinarySearch.search(key, longSequence).isFound(), is(true));
    }
    @Test
    public void shouldNotFoundKeyInSequenceWithLengthBiggerThan1() {
        int key = 9999;
        assertThat(BinarySearch.search(key, longSequence).isFound(), is(false));
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException() {
        BinarySearch.search(9999, emptySequence);
    }
}

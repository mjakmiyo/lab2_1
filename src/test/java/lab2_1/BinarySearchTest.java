package lab2_1;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;


public class BinarySearchTest {

    int in[] = {1, 2, 3, 5, 9, 10, 15, 20, 35};
    int in2[] = {};

    @Test
    public void elementFoundedInSequence() {
        assertTrue(BinarySearch.search(1, in).isFound());
    }

    @Test
    public void elementNotFoundedInSequence() {
        assertFalse(BinarySearch.search(4, in).isFound());
    }

    @Test
    public void elementFoundedInSequenceGetFirstElement() {
        int value = 1;
        assertThat(in[BinarySearch.search(value, in).getPosition() - 1], Matchers.is(value));
    }

    @Test
    public void elementFoundedInSequenceGetLastElement() {
        int value = 35;
        assertThat(in[BinarySearch.search(value, in).getPosition() - 1], Matchers.is(value));
    }

    @Test
    public void elementFoundedInSequenceGetMiddleElement() {
        int value = in.length / 2 + 1;
        assertThat(in[BinarySearch.search(value, in).getPosition() - 1], Matchers.is(value));
    }

    @Test
    public void elementNotFoundedInSequenceWithPosition() {
        int value = 4;
        assertThat(in[BinarySearch.search(value, in).getPosition() - 1], Matchers.is(-1));
    }

    @Test
    public void sequenceInsertedIsEmpty() {
        try {
            BinarySearch.search(1, in2);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}

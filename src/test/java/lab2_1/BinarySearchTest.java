package lab2_1;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;


public class BinarySearchTest {
    
    int seq[] = {1, 3, 4, 7, 9, 13, 21, 22, 34, 42, 49};

    @Test
    public void searchingForExistingKeyInSequenceShouldReturnTrue() {
        int value = 3;
        assertTrue(BinarySearch.search(value, seq).isFound());
    }

    @Test
    public void searchingForNotExistingKeyInSequenceShouldReturnFalse() {
        int value = 6;
        assertFalse(BinarySearch.search(value, seq).isFound());
    }
    
    @Test
    public void positionOfSearchingFirstKeyInSequenceShouldReturnOne() {
        int value = 1;
        assertThat(BinarySearch.search(value, seq).getPosition(), Matchers.is(1));
    }
    
    @Test
    public void positionOfSearchingLastKeyInSequenceShouldReturnLengthOfSequence() {
        int value = 49;
        assertThat(BinarySearch.search(value, seq).getPosition(), Matchers.is(seq.length));
    }
    
    @Test
    public void positionOfSearchingCenterKeyInSequenceShouldReturnHalfPlusOneOfSequenceLength() {
        int value = 13;
        assertThat(BinarySearch.search(value, seq).getPosition(), Matchers.is(seq.length/2+1));
    }
    
    @Test
    public void positionOfSearchingNotExistingKeyShouldReturnMinusOne() {
        int value = 6;
        assertThat(BinarySearch.search(value, seq).getPosition(), Matchers.is(-1));
    }
    
}

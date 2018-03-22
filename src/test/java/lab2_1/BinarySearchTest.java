package lab2_1;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;


public class BinarySearchTest {
    
    int evenSeq[] = {1, 3, 4, 7, 9, 13, 21, 22, 34, 42};
    int oddSeq[] = {1, 2, 7, 12, 24, 37, 45, 57, 68, 77, 78};

    @Test
    public void searchingForExistingKeyInSequenceShouldReturnTrue() {
        int value = 3;
        assertTrue(BinarySearch.search(value, evenSeq).isFound());
    }

    @Test
    public void searchingForNotExistingKeyInSequenceShouldReturnFalse() {
        int value = 6;
        assertFalse(BinarySearch.search(value, evenSeq).isFound());
    }
    
    @Test
    public void positionOfSearchingFirstKeyInSequenceShouldReturnOne() {
        int value = 1;
        int position = 1;
        assertThat(BinarySearch.search(value, evenSeq).getPosition(), Matchers.is(position));
    }
    
    @Test
    public void positionOfSearchingLastKeyInSequenceShouldReturnLengthOfSequence() {
        int value = 42;
        int position = evenSeq.length;
        assertThat(BinarySearch.search(value, evenSeq).getPosition(), Matchers.is(position));
    }
    
    @Test
    public void positionOfSearchingCenterKeyInOddSequenceShouldReturnHalfPlusOneOfSequenceLength() {
        int value = 37;
        int position = oddSeq.length/2+1;
        assertThat(BinarySearch.search(value, oddSeq).getPosition(), Matchers.is(position));
    }
    
    @Test
    public void positionOfSearchingLeftCenterKeyInEvenSequenceShouldReturnHalfOfSequenceLength() {
        int value = 9;
        int position = evenSeq.length/2;
        assertThat(BinarySearch.search(value, evenSeq).getPosition(), Matchers.is(position));
    }
    
    @Test
    public void positionOfSearchingRightCenterKeyInEvenSequenceShouldReturnHalfPlusOneOfSequenceLength() {
        int value = 13;
        int position = evenSeq.length/2+1;
        assertThat(BinarySearch.search(value, evenSeq).getPosition(), Matchers.is(position));
    }
    
    @Test
    public void positionOfSearchingNotExistingKeyShouldReturnMinusOne() {
        int value = 6;
        int position = -1;
        assertThat(BinarySearch.search(value, evenSeq).getPosition(), Matchers.is(position));
    }
    
}

package lab2_1;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;


public class BinarySearchTest {

    @Test
    public void searchingForExistingKeyInSequenceShouldReturnTrue() {
        int seq[] = {1, 3, 4, 7, 9, 28, 49};
        int value = 3;
        assertTrue(BinarySearch.search(value, seq).isFound());
    }

    @Test
    public void searchingForNotExistingKeyInSequenceShouldReturnFalse() {
        int seq[] = {4, 7, 12};
        int value = 6;
        assertFalse(BinarySearch.search(value, seq).isFound());
    }
    
    @Test
    public void positionOfSearchingFirstKeyInSequenceShouldReturnOne() {
        int seq[] = {3, 7, 9, 13, 22, 48};
        int value = 3;
        int position = 1;
        assertThat(BinarySearch.search(value, seq).getPosition(), Matchers.is(position));
    }
    
    @Test
    public void positionOfSearchingLastKeyInSequenceShouldReturnLengthOfSequence() {
        int seq[] = {2, 4, 14, 29, 32, 33, 49, 59};
        int value = 59;
        int position = seq.length;
        assertThat(BinarySearch.search(value, seq).getPosition(), Matchers.is(position));
    }
    
    @Test
    public void positionOfSearchingCenterKeyInOddSequenceShouldReturnCorrectPosition() {
        int seq[] = {1, 2, 7, 12, 24, 37, 45, 57, 68, 77, 78};
        int value = 37;
        int position = 6;
        assertThat(BinarySearch.search(value, seq).getPosition(), Matchers.is(position));
    }
    
    @Test
    public void positionOfSearchingLeftCenterKeyInEvenSequenceShouldReturnCorrectPosition() {
        int seq[] = {1, 3, 4, 7, 9, 13, 21, 22, 34, 42};
        int value = 9;
        int position = 5;
        assertThat(BinarySearch.search(value, seq).getPosition(), Matchers.is(position));
    }
    
    @Test
    public void positionOfSearchingRightCenterKeyInEvenSequenceShouldReturnCorrectPosition() {
        int seq[] = {1, 3, 8, 11, 12, 13, 14, 22, 38, 97};
        int value = 13;
        int position = 6;
        assertThat(BinarySearch.search(value, seq).getPosition(), Matchers.is(position));
    }
    
    @Test
    public void positionOfSearchingNotExistingKeyShouldReturnMinusOne() {
        int seq[] = {2, 4, 5, 7, 9, 30, 42};
        int value = 6;
        int position = -1;
        assertThat(BinarySearch.search(value, seq).getPosition(), Matchers.is(position));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void searchingInEmptySequenceShouldThrowIllegalArgumentException() {
        int seq[] = {};
        int value = 1;
        BinarySearch.search(value, seq);
    }
    
}

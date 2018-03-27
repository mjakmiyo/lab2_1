package lab2_1;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;

public class BinarySearchTest {

	int seq[] = { 1, 2, 3, 5, 9, 10, 15, 20, 35 };
	int seq2[] = {};
	int seq3[]= {1,2,3,4,5,6,7,8,9,10};

	@Test
	public void elementFoundedInSequence() {
		assertThat(BinarySearch.search(1, seq).isFound(), Matchers.is(true));
	}

	@Test
	public void elementNotFoundedInSequence() {
		assertThat(BinarySearch.search(4, seq).isFound(), Matchers.is(false));
	}

	@Test
	public void elementFoundedInSequenceOnFirstPosition() {
		int value = 1;
		int pos = 1;
		assertThat(BinarySearch.search(value, seq).getPosition(), Matchers.is(pos));
	}

	@Test
	public void elementFoundedInSequenceOnLastPosition() {
		int value = 35;
		int pos = 9;
		assertThat(BinarySearch.search(value, seq).getPosition(), Matchers.is(pos));
	}

	@Test
	public void elementFoundedInSequenceOnMiddlePosition() {
		int value = 9;
		int pos = seq.length / 2 + 1;
		assertThat(BinarySearch.search(value, seq).getPosition(), Matchers.is(pos));
	}
	@Test
	public void elementNotFoundedInSequenceReturningPosition() {
		int value = 4;
		int pos = -1;
		assertThat(BinarySearch.search(value, seq).getPosition(), Matchers.is(pos));
	}

	@Test(expected = IllegalArgumentException.class)
	public void sequenceEmptyException() {
		int value = 4;
		BinarySearch.search(value, seq2);
	}
	@Test
	public void elementFoundedInSequenceOnLeftMiddlePosition() {
		int value=5;
		int pos=seq3.length/2;
		assertThat(BinarySearch.search(value, seq3).getPosition(), Matchers.is(pos));
	}
	@Test
	public void elementFoundedInSequenceOnRightMiddlePosition() {
		int value=6;
		int pos=seq3.length/2+1;
		assertThat(BinarySearch.search(value, seq3).getPosition(), Matchers.is(pos));
	}
}

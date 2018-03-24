import edu.iis.mto.bsearch.BinarySearch;
import org.junit.Assert;
import org.junit.Test;


public class BinarySearchTests {
    @Test
    public void shouldFoundKeyInSequenceWithLength1() {
        Assert.assertTrue(BinarySearch.search(1, new int[] {1, 2 ,3}).isFound());
    }
    @Test
    public void shouldNotFoundKeyInSequenceWithLength1() {
        Assert.assertFalse(BinarySearch.search(1, new int[] {5, 8, 12, 40}).isFound());
    }
    @Test
    public void soughtKeyShouldBeFirstOnElementList() {
        Assert.assertEquals(1 ,BinarySearch.search(1, new int[] {1, 3, 5}).getPosition());
    }
    @Test
    public void soughtKeyShouldBeLastOnElementList() {
        Assert.assertEquals(3 ,BinarySearch.search(3, new int[] {1, 2, 3}).getPosition());
    }
    @Test
    public void soughtKeyShouldBeInMiddleOnElementList() {
        Assert.assertEquals(3 ,BinarySearch.search(2, new int[] {0, 1, 2, 5, 9}).getPosition());
    }
    @Test
    public void shouldFoundKeyInSequenceWithLengthBiggerThan1() {
        Assert.assertTrue(BinarySearch.search(12, new int[] {1, 2, 4, 5, 12, 14}).isFound());
    }
    @Test
    public void shouldNotFoundKeyInSequenceWithLengthBiggerThan1() {
        Assert.assertFalse(BinarySearch.search(6, new int[] {1, 2, 4, 5, 12, 14}).isFound());
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException() {
        BinarySearch.search(52, new int[0]);
    }
}

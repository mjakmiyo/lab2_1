import edu.iis.mto.bsearch.BinarySearch;
import org.junit.Assert;
import org.junit.Test;


public class BinarySearchTests {
    @Test
    public void shouldFoundKeyInSequenceWithLength1() {
        Assert.assertTrue(BinarySearch.search(1, new int[] {1}).isFound());
    }
    @Test
    public void shouldNotFoundKeyInSequenceWithLength1() {
        Assert.assertFalse(BinarySearch.search(1, new int[] {5}).isFound());
    }
    @Test
    public void soughtKeyShouldBeFirstOnElementList() {
        Assert.assertEquals(1 ,BinarySearch.search(1, new int[] {1, 5, 3}).getPosition());
    }
    @Test
    public void soughtKeyShouldBeLastOnElementList() {
        Assert.assertEquals(3 ,BinarySearch.search(3, new int[] {7, 1, 3}).getPosition());
    }
    @Test
    public void soughtKeyShouldBeInMiddleOnElementList() {
        Assert.assertEquals(3 ,BinarySearch.search(2, new int[] {7, 1, 2, 5, 9}).getPosition());
    }
    @Test
    public void shouldFoundKeyInSequenceWithLengthBiggerThan1() {
        Assert.assertTrue(BinarySearch.search(0, new int[] {7, 0, 2, 5}).isFound());
    }
}

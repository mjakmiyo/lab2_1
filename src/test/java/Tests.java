import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/*

Długość sekwencji wejściowej
Element wyszukiwany
1
Jest w sekwencji
1
Nie ma w sekwencji
>1
Jest pierwszym elementem
> 1
Jest ostatnim elementem
> 1
Jest środkowym elementem
> 1
NIe ma w sekwencji

 */
public class Tests {
    static int[] seq;
    static SearchResult result;


    @Test(expected = NullPointerException.class)
    public void isEmptyElementSequence(){
        seq[0]=1;
    }
    //zadanie 3
    @Test
    public void isInOneElementSequence(){
        seq=new int[1];
        int value = 3;
        seq[0]=value;
        result = BinarySearch.search(value, seq);
        assertThat(result.isFound(),is(true));
    }
    @Test
    public void isNotInOneElementSequence(){
        seq=new int[1];
        int value = 4;
        seq[0]=value;
        result = BinarySearch.search(value+1, seq);
        assertThat(result.isFound(),is(false));
        assertThat(result.getPosition(),is(-1));
    }
    @Test
    public void isFirstInManyElementSequence(){
        seq=new int[2];
        int value = 4;
        final int EXPECTED_POSITION = 0;
        seq[0]=value;
        seq[1]=23;
        result = BinarySearch.search(value, seq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(EXPECTED_POSITION));
    }
    @Test
    public void isLastInManyElementSequence(){
        seq=new int[4];
        int value = 23;
        final int EXPECTED_POSITION = seq.length - 1;
        seq[0]=4;
        seq[1]=5;
        seq[2]=6;
        seq[3]=value;
        result = BinarySearch.search(value, seq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getPosition(), is(EXPECTED_POSITION));
    }
    @Test
    public void isMiddleInManyOddElementSequence(){
        seq=new int[3];
        int value = 23;
        final int EXPECTED_POSITION = seq.length/2;
        seq[0]=4;
        seq[1]=15;
        seq[2]=value;
        result = BinarySearch.search(15, seq);
        result = BinarySearch.search(value, seq);
        assertThat(result.isFound(), is(true));
        assertThat(result.getCenter(), is(EXPECTED_POSITION));
    }
    @Test
    public void isNotInManyElementSequence(){
        seq=new int[6];
        int value = 7;
        final int EXPECTED_POSITION = -1;
        seq[0]=4;
        seq[1]=15;
        seq[2]=23;
        seq[3]=24;
        seq[4]=115;
        seq[5]=223;
        result = BinarySearch.search(value, seq);
        assertThat(result.isFound(), is(false));
        assertThat(result.getPosition(), is(EXPECTED_POSITION));
    }
}
/*
SearchResult search(int key, int[] seq)
		Warunki wejściowe (preconditions):
	Długość sekwencji wejściowej > 0, sekwencja posortowana rosnąco bez duplikatów.
Warunki wyjściowe (postconditions):
 		Długość sekwencji wejściowej == 0 -> IllegalArgumentException
	LUB
element znaleziony -> searchResult.isFound() == true && searchResult.getPosition() == i takie, że seq[i] == key
	LUB
element nieznaleziony -> searchResult.isFound() == false && searchResult.getPosition == -1

 */

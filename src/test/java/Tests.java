import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import org.junit.Assert;
import org.junit.Test;
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

    //zadanie 3
    @Test
    public void isInOneElementSequence(){
        seq=new int[1];
        seq[0]=3;
        Assert.assertEquals(true,BinarySearch.search(3, seq).isFound());
    }
    @Test
    public void isNotInOneElementSequence(){
        seq=new int[1];
        seq[0]=4;
        Assert.assertEquals(false,BinarySearch.search(3, seq).isFound());
    }
    @Test
    public void isFirstInManyElementSequence(){
        seq=new int[2];
        seq[0]=4;
        seq[1]=23;
        result = BinarySearch.search(4, seq);
        Assert.assertEquals(1,result.getPosition());
    }
    @Test
    public void isLastInManyElementSequence(){
        seq=new int[4];
        seq[0]=4;
        seq[1]=5;
        seq[2]=6;
        seq[3]=23;
        result = BinarySearch.search(23, seq);
        Assert.assertEquals(seq.length,result.getPosition());
    }
    @Test
    public void isMiddleInManyOddElementSequence(){
        seq=new int[3];
        seq[0]=4;
        seq[1]=15;
        seq[2]=23;
        result = BinarySearch.search(15, seq);
        //Check if length of sequence is odd
        Assert.assertEquals(15, result.getCenter());
        if(seq.length % 2 == 1){
            Assert.assertEquals(seq.length-seq.length/2,result.getPosition());
        }
        Assert.assertTrue((seq.length-seq.length/2 == result.getPosition()| seq.length/2== result.getPosition()));
        //seq.length/2
    }
    @Test
    public void isNotInManyElementSequence(){
        seq=new int[6];
        seq[0]=4;
        seq[1]=15;
        seq[2]=23;
        seq[3]=24;
        seq[4]=115;
        seq[5]=223;
        result = BinarySearch.search(7, seq);
        Assert.assertEquals(false,result.isFound());
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

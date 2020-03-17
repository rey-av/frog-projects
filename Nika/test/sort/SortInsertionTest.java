package sort;

import com.frog.nika.sort.sortClass.SortInsertion;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SortInsertionTest {

    int[] arrRandom = {4, 12, 6, 0, -299, 321};
    int[] arrOrdered = {-299, 0, 4, 6, 12, 321};


    @Test
    public void SortTest() {
        SortInsertion sort = new SortInsertion();
        sort.Sort(arrRandom);
        Assert.assertArrayEquals("Array is not sorted", arrOrdered, arrRandom);
    }


    @Test
    public void SortNegativeTest() {
    }

}

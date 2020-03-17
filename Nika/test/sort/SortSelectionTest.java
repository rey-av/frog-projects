package sort;

import com.frog.nika.sort.sortClass.SortSelection;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SortSelectionTest {

    int[] arrRandom = {4, 12, 6, 0, -299, 321};
    int[] arrOrdered = {-299, 0, 4, 6, 12, 321};


    @Test
    public void SortTest() {
        SortSelection sort = new SortSelection();
        sort.Sort(arrRandom);
        Assert.assertArrayEquals("Array is not sorted", arrOrdered, arrRandom);
    }


    @Test
    public void SortNegativeTest() {
    }

}

import com.frog.veronika.search.RandomData;
import com.frog.veronika.search.searcherClass.SearchLinear;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SearchLinearTest {

    private int[] arr = new int[]{2, 10, 32, 1, 0, 31, 66};

    @Test
    public void SearchTest() {
        RandomData random = new RandomData();
        random.setArray(arr);

        SearchLinear search = new SearchLinear();
        int index = search.Search(random.getArray(), 32); // index = 2
        Assert.assertEquals("Invalid index: ", 2, index);
        // assertEquals([message,] expected, actual)
    }


    @Test
    public void SearchNegativeTest() {
        RandomData random = new RandomData();
        random.setArray(arr);

        SearchLinear search = new SearchLinear();
        int index = search.Search(random.getArray(), 666);
        Assert.assertNotEquals("Invalid index: ", 2, index);

        int index2 = search.Search(null, 666);
        Assert.assertEquals("Invalid index", -1, index2);
    }

}


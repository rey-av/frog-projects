import com.frog.veronika.search.RandomData;
import com.frog.veronika.search.searcherClass.SearchBinary;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SearchBinaryTest {

    private int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    RandomData random = new RandomData();

    @Test
    public void SearchTest() {
        random.setArray(arr);

        SearchBinary search = new SearchBinary();
        int index = search.Search(random.getArray(), 4); // index = 3
        Assert.assertEquals("Invalid index: ", 3, index);
    }


    @Test
    public void SearchNegativeTest() {
        random.setArray(arr);

        SearchBinary search = new SearchBinary();
        int index = search.Search(random.getArray(), 666);
        Assert.assertEquals("Invalid index: ", -1, index);

        int index2 = search.Search(null, 666);
        Assert.assertEquals("Invalid index", -1, index2);
    }

}

public class SearchAlgorithms {


    public static int BinSearch(int N, int[] A)
    {
        int index = -1;
        int leftIndex = 0;
        int indexRight = A.length - 1;
        if (N < A[leftIndex] || N > A[indexRight])
            return index;
        if (N == A[leftIndex]) {
            index = leftIndex;
            return index;
        }
        if (N == A[indexRight]) {
            index = indexRight;
            return index;
        }
        while (leftIndex != indexRight - 1)
        {
            int midIndex = (leftIndex + indexRight) / 2;

            if (N == A[midIndex]) {
                index = midIndex;
                return index;
            }
            if (N < A[midIndex]) {
                indexRight = midIndex;
            }
            else {
                leftIndex = midIndex;
            }
        }
        return index;
    }
}

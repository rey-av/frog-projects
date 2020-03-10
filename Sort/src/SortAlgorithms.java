public class SortAlgorithms {


    private static int[] Merge(int[] A, int[] B) {
        int lengthA = A.length;
        int lengthB = B.length;
        int lengthMerged = lengthA + lengthB;
        int[] merged = new int[lengthMerged];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < lengthA) {
            while ((j < lengthB) && (B[j] <= A[i])) {
                merged[k++] = B[j++];
            }
            merged[k++] = A[i++];
        }
        while (j < lengthB) {
            merged[k++] = B[j++];
        }

        return merged;
    }


    public static int[] sortMerge(int[] A) {
        int lengthA = A.length;
        if (lengthA <= 1) {
            return A;
        }
        int rightHalf = lengthA / 2;
        int leftHalf = lengthA - rightHalf;
        int[] A1 = new int[rightHalf];
        int[] A2 = new int[leftHalf];

        for (int k = 0; k < rightHalf; k++) {
            A1[k] = A[k];
        }
        for (int k = 0; k < leftHalf; k++) {
            A2[k] = A[rightHalf + k];
        }

        A1 = sortMerge(A1);
        A2 = sortMerge(A2);
        int[] sorted = Merge(A1, A2);
        return sorted;
    }


    public static void sortBubble(int[] array) {
        int placeholder;
        boolean swapped;
        for (int i = 0; i < array.length; i++) {
            swapped = false;
            for (int j = 1; j < array.length; j++) {
                if (array[j - 1] > array[j]) {
                    placeholder = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = placeholder;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }


    public static void sortShaker(int[] A){
        int placeholder;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < A.length - 1; i++) {
                if (A[i - 1] > A[i]) {
                    placeholder = A[i - 1];
                    A[i - 1] = A[i];
                    A[i] = placeholder;
                    swapped = true;
                }
            }

            for (int j = A.length-1; j > 0; j--) {
                if (A[j - 1] > A[j]) {
                    placeholder = A[j - 1];
                    A[j - 1] = A[j];
                    A[j] = placeholder;
                    swapped = true;
                }
            }
        } while (swapped);
    }
}

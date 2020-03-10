public class Main {
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7, 4, 9, -1, 0};
        SortAlgorithms.sortShaker(arr);
        int index = SearchAlgorithms.BinSearch(0, arr);
        if(index==-1){
            System.out.println("No element found");
            return;
        }
        System.out.println("The number is at index " + index);
        System.out.println("Sorted array:");
        for (int element : arr){
            System.out.println(element + " ");
        }
    }
}

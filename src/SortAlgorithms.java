public class SortAlgorithms {
    private int comparisonCount;

    public SortAlgorithms() {
        comparisonCount = 0;
    }

    public void bubbleSort(String[] arr) {
        int n = arr.length;
        comparisonCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                comparisonCount++;
                if (arr[j - 1].compareTo(arr[j]) > 0) {
                    String temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("Sorted array: " + String.join(", ", arr));
        System.out.println("Bubble Sort - Number of comparisons: " + comparisonCount);
    }

    public void quickSort(String[] array) {
        comparisonCount = 0;
        quickSortHelper(array, 0, array.length - 1);
        System.out.println("Sorted array: " + String.join(", ", array));
        System.out.println("Quicksort - Number of comparisons: " + comparisonCount);
    }

    private void quickSortHelper(String[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSortHelper(array, low, pi - 1);
            quickSortHelper(array, pi + 1, high);
        }
    }

    private int partition(String[] array, int low, int high) {
        String pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            comparisonCount++;
            if (array[j].compareTo(pivot) < 0) {
                i++;
                String temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        String temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public void mergeSort(String[] array) {
        comparisonCount = 0;
        mergeSortHelper(array, 0, array.length - 1);
        System.out.println("Sorted array: " + String.join(", ", array));
        System.out.println("Merge Sort - Number of comparisons: " + comparisonCount);
    }

    private void mergeSortHelper(String[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSortHelper(array, left, middle);
            mergeSortHelper(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private void merge(String[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        String[] L = new String[n1];
        String[] R = new String[n2];

        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, middle + 1, R, 0, n2);

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            comparisonCount++;
            if (L[i].compareTo(R[j]) <= 0) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
}
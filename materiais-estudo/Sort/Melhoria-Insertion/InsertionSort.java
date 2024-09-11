public class InsertionSort {

    private static int pesBin (int[] array, int key, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
               
            if (array[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low; 
    }

    private static void sort(int []array, int n) {
		for (int i = 1; i < n; i++) {
			int key = array[i];
            int j = pesBin(array, key, 0, i - 1);
            
            for (int k = i - 1 ; k >= j ; k--) {
                array[k + 1] = array[k];
            }
            array[j] = key;
        }
	}

    public static void main(String[] args) {
        int []array = {-9, 2, -4, 1, -6, 5};
        int n = array.length;

        sort(array, n);

        for (int i = 0 ; i < n ; i++) {
            System.out.println(array[i]);
        }
            
    }
}

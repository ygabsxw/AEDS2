public class BubbleSort {

    private static void swap (int []array, int j) {
        int aux = array[j];
        array[j] = array[j + 1];
        array[j + 1] = aux;
    }

    private static void sort(int []array, int n) {
        int i, j;  
        int troca = 1;

		for (i = (n - 1); i > 0; i--) {
			for (j = troca - 1, troca = 0 ; j < (n - 1) ; j++) {
				if (array[j] > array[j + 1]) {
                    if (troca == 0) troca = j;
                    swap(array, j);
				}
			}
            if (troca == 0) i = 0;
		}
   }

   public static void main(String[] args) {
    int []array = {9, 10, 4, 6, 5, 3, 8, 7, 2, 1};
    int n = array.length;

    sort(array, n);

    for (int i = 0 ; i < n ; i++) {
        System.out.println(array[i]);
    }
        
}
}

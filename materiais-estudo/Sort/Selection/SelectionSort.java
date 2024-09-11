public class SelectionSort {

    private static void swap (int []array, int menor, int i) {
        int aux = array[menor];
        array[menor] = array[i];
        array[i] = aux;    
    }


    private static void sort(int []array, int n) {
        int negativo = 0;
		for (int i = 0; i < (n - 1); i++) {
            if (array[i] < 0) {
                swap(array, negativo, i);
                negativo++;
            }
			int menor = i;
			for (int j = (i + 1); j < n; j++){
                if (array[menor] > array[j]){
				    menor = j;
				}
			}
			swap(array, menor, i);
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

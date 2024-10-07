import java.util.Arrays;
import java.util.Random;

public class QuickSortVariations {

    // Método para trocar elementos no array
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    // 1. QuickSort com o primeiro elemento como pivô
    void QuickSortFirstPivot(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partitionFirstPivot(array, left, right);
            QuickSortFirstPivot(array, left, pivotIndex - 1);
            QuickSortFirstPivot(array, pivotIndex + 1, right);
        }
    }

    private int partitionFirstPivot(int[] array, int left, int right) {
        int pivot = array[left];
        int i = left + 1;
        int j = right;

        while (i <= j) {
            while (i <= j && array[i] <= pivot)
                i++;
            while (i <= j && array[j] > pivot)
                j--;
            if (i < j)
                swap(array, i, j);
        }
        swap(array, left, j);
        return j;
    }

    // 2. QuickSort com o último elemento como pivô
    void QuickSortLastPivot(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partitionLastPivot(array, left, right);
            QuickSortLastPivot(array, left, pivotIndex - 1);
            QuickSortLastPivot(array, pivotIndex + 1, right);
        }
    }

    private int partitionLastPivot(int[] array, int left, int right) {
        swap(array, left, right); // Move o pivô para o início
        int pivot = array[left];
        int i = left + 1;
        int j = right;

        while (i <= j) {
            while (i <= j && array[i] <= pivot)
                i++;
            while (i <= j && array[j] > pivot)
                j--;
            if (i < j)
                swap(array, i, j);
        }
        swap(array, left, j);
        return j;
    }

    // 3. QuickSort com pivô aleatório
    void QuickSortRandomPivot(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partitionRandomPivot(array, left, right);
            QuickSortRandomPivot(array, left, pivotIndex - 1);
            QuickSortRandomPivot(array, pivotIndex + 1, right);
        }
    }

    private int partitionRandomPivot(int[] array, int left, int right) {
        int randomPivotIndex = left + (int)(Math.random() * (right - left + 1));
        swap(array, left, randomPivotIndex); // Move o pivô para o início
        int pivot = array[left];
        int i = left + 1;
        int j = right;

        while (i <= j) {
            while (i <= j && array[i] <= pivot)
                i++;
            while (i <= j && array[j] > pivot)
                j--;
            if (i < j)
                swap(array, i, j);
        }
        swap(array, left, j);
        return j;
    }

    // 4. QuickSort com mediana de três elementos
    void QuickSortMedianOfThree(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partitionMedianOfThree(array, left, right);
            QuickSortMedianOfThree(array, left, pivotIndex - 1);
            QuickSortMedianOfThree(array, pivotIndex + 1, right);
        }
    }

    private int partitionMedianOfThree(int[] array, int left, int right) {
        int mid = left + (right - left) / 2;
        int pivotIndex = medianOfThree(array, left, mid, right);
        swap(array, left, pivotIndex); // Move o pivô para o início
        int pivot = array[left];
        int i = left + 1;
        int j = right;

        while (i <= j) {
            while (i <= j && array[i] <= pivot)
                i++;
            while (i <= j && array[j] > pivot)
                j--;
            if (i < j)
                swap(array, i, j);
        }
        swap(array, left, j);
        return j;
    }

    private int medianOfThree(int[] array, int a, int b, int c) {
        int x = array[a];
        int y = array[b];
        int z = array[c];
        if ((x > y) != (x > z))
            return a;
        else if ((y > x) != (y > z))
            return b;
        else
            return c;
    }

    // Métodos para gerar diferentes tipos de arrays
    int[] generateOrderedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = i;
        return array;
    }

    int[] generateNearlyOrderedArray(int size, int swaps) {
        int[] array = generateOrderedArray(size);
        Random rand = new Random();
        for (int i = 0; i < swaps; i++) {
            int index1 = rand.nextInt(size);
            int index2 = rand.nextInt(size);
            swap(array, index1, index2);
        }
        return array;
    }

    int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++)
            array[i] = rand.nextInt(size * 10); // Ajuste o multiplicador conforme necessário
        return array;
    }

    // Método para medir o tempo de execução
    long measureSortTime(int[] array, String methodName) {
        long startTime = System.nanoTime();
        switch (methodName) {
            case "FirstPivot":
                QuickSortFirstPivot(array, 0, array.length - 1);
                break;
            case "LastPivot":
                QuickSortLastPivot(array, 0, array.length - 1);
                break;
            case "RandomPivot":
                QuickSortRandomPivot(array, 0, array.length - 1);
                break;
            case "MedianOfThree":
                QuickSortMedianOfThree(array, 0, array.length - 1);
                break;
            default:
                throw new IllegalArgumentException("Método inválido");
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Método principal para executar os testes
    public static void main(String[] args) {
        QuickSortVariations sorter = new QuickSortVariations();

        int[] sizes = {100, 1000, 10000};
        String[] methods = {"FirstPivot", "LastPivot", "RandomPivot", "MedianOfThree"};
        String[] arrayTypes = {"Ordered", "NearlyOrdered", "Random"};

        for (int size : sizes) {
            System.out.println("Array size: " + size);
            for (String arrayType : arrayTypes) {
                System.out.println("  Array type: " + arrayType);
                int[] originalArray = null;
                switch (arrayType) {
                    case "Ordered":
                        originalArray = sorter.generateOrderedArray(size);
                        break;
                    case "NearlyOrdered":
                        originalArray = sorter.generateNearlyOrderedArray(size, size / 10);
                        break;
                    case "Random":
                        originalArray = sorter.generateRandomArray(size);
                        break;
                }
                for (String method : methods) {
                    int[] arrayToSort = Arrays.copyOf(originalArray, originalArray.length);
                    long time = sorter.measureSortTime(arrayToSort, method);
                    System.out.printf("    %s: %d ns\n", method, time);
                }
            }
            System.out.println();
        }
    }
}
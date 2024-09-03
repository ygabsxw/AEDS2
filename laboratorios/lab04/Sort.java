import java.util.Scanner;

public class Sort {

    static void sortSortSort(Entry[] entries) {
        for (int i = 0; i < entries.length - 1; i++) {
            int menor = i;

            for (int j = i + 1; j < entries.length; j++) {
                if (entries[j].compareTo(entries[menor]) < 0) {
                    menor = j;
                }
            }

            swap(i, menor, entries);
        }

    }

    static void swap(int i, int j, Entry[] entries) {
        Entry temp = entries[i];
        entries[i] = entries[j];
        entries[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        int M;

        do {
            N = sc.nextInt();
            M = sc.nextInt();

            Entry[] entries = new Entry[N];

            for (int i = 0; i < N; i++)
                entries[i] = new Entry(sc.nextInt(), M);

            sortSortSort(entries);

            printOutput(entries, N, M);

        } while (N != 0 && M != 0);

        sc.close();
    }

    static void printOutput(Entry[] entries, int N, int M) {
        System.out.print(N + " ");
        System.out.println(M);
        for (Entry entry : entries)
            System.out.println(entry.number);
    }

}

class Entry {
    int number;
    int mod;

    public Entry(int number, int modOp) {
        this.number = number;
        this.mod = number % modOp;
    }

    public int compareTo(Entry other) {
        int diff = 0;
        int modDiff = this.mod - other.mod;
        int parityDiff = (this.number % 2) - (other.number % 2);
        int numberDiff = this.number - other.number;

        if (modDiff != 0) {
            diff = modDiff;
        } else if (parityDiff != 0) {
            diff = -parityDiff;
        } else {
            if (this.number % 2 == 0) {
                diff = numberDiff;
            } else {
                diff = -numberDiff;
            }
        }

        return diff;
    }
}
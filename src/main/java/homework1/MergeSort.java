package homework1;

import java.util.Comparator;

public class MergeSort {
    public static void sort(Entry[] entries) {
        if (entries.length > 1) {
            int mid = entries.length / 2;

            Entry[] left = new Entry[mid];
            Entry[] right = new Entry[entries.length - mid];

            System.arraycopy(entries, 0, left, 0, mid);
            System.arraycopy(entries, mid, right, 0, entries.length - mid);

            sort(left);
            sort(right);

            merge(entries, left, right);
        }
    }
    private static void merge(Entry[] result, Entry[] left, Entry[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }
}

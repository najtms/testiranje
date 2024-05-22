package homework1;

public class BinarySearch {
    public static int[] search(Entry[] entries, String searchableName) {
        int left = 0;
        int right = entries.length - 1;
        int startIndex = -1;
        int endIndex = -1;

        // Pocni index X
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (entries[mid].getName().compareTo(searchableName) >= 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < entries.length && entries[left].getName().equals(searchableName)) {
            startIndex = left;
        } else {
            return new int[]{};
        }

        // Zadnji index x
        right = entries.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (entries[mid].getName().compareTo(searchableName) <= 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        endIndex = right;

        return new int[]{startIndex, endIndex};
    }
}
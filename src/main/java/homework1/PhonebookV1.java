package homework1;


import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;


public class PhonebookV1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path to the CSV file: ");
        String filePath = scanner.nextLine();

        try {
            Entry[] entries = FileUtils.readFile(filePath);
            MergeSort.sort(entries);
            FileUtils.writeToFile(entries, "sorted_" + filePath);

            while (true) {
                System.out.print("Enter a name to search or -1 to exit: ");
                String searchName = scanner.nextLine();
                if (searchName.equals("-1")) {
                    break;
                }

                int[] result = BinarySearch.search(entries, searchName);
                if (result.length == 0) {
                    System.out.println("No entries found for " + searchName);
                } else {
                    int startIndex = result[0];
                    int endIndex = result[1];
                    System.out.println("Found " + (endIndex - startIndex + 1) + " entries:");
                    for (int i = startIndex; i <= endIndex; i++) {
                        System.out.println(entries[i]);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading or writing the file: " + e.getMessage());
        }
    }
}

package homework1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtils {

    public static Entry[] readFile(String filePath) throws IOException {
        List<Entry> entries = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = parseLine(line);
                if (data.length == 7) {
                    entries.add(new Entry(data[0], data[1], data[2], data[3], data[4], data[5], data[6]));
                }
            }
        }
        return entries.toArray(new Entry[0]);
    }

    public static void writeToFile(Entry[] entries, String filePath) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (Entry entry : entries) {
                bufferedWriter.write(entry.toString());
                bufferedWriter.newLine();
            }
        }
    }
    private static String[] parseLine(String line) {
        List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        char[] dontNeed = {',', ';'};
        boolean inQuotes = false;

        for (char ch : line.toCharArray()) {
            if (ch == '\"') {
                inQuotes = !inQuotes;
            } else if (!inQuotes && (ch == dontNeed[0] || ch == dontNeed[1])) {
                result.add(stringBuilder.toString().trim());
                stringBuilder.setLength(0);
            } else {
                stringBuilder.append(ch);
            }
        }
        result.add(stringBuilder.toString().trim());

        return result.toArray(new String[0]);
    }
}

package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkHours {
    public String minWork(String filePath) {
        String minWorker = "";
        try (BufferedReader reader = new BufferedReader(Files.newBufferedReader(Path.of(filePath)))) {
            minWorker = getMinWorker(minWorker, reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return minWorker;
    }

    private String getMinWorker(String minWorker, BufferedReader reader) throws IOException {
        String line;
        int hour = Integer.MAX_VALUE;
        while ((line = reader.readLine()) != null) {
            int workHour = getWorkHourFromString(line);
            if (workHour < hour) {
                hour = workHour;
                minWorker = getWorkerFromString(line);
            }
        }
        return minWorker;
    }

    private int getWorkHourFromString(String str) {
        String[] splittedStr = str.split(",");
        try {
            return Integer.parseInt(splittedStr[1]);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid number format");
        }
    }

    private String getWorkerFromString(String str) {
        String[] splittedStr = str.split(",");
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(splittedStr[0]).append(": ").append(splittedStr[2]);
            return stringBuilder.toString();
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid format");
        }
    }
}

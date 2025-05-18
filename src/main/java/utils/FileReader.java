package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class FileReader {

    public static List<String> readFile(String fileName) {
        String filePath = "src/test/resources/" + fileName;
        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + fileName);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + fileName, e);
        }
        return lines;
    }

    public static Map<String, VehicleData> getVehicleData(String path) {
        Map<String, VehicleData> map = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path))) {
            String line = bufferedReader.readLine();
             while (line != null) {
                 String[] data = line.split(",");
                 if (data.length >= 4) {
                     String vehicleReg = data[0].trim();
                     String make = data[1].trim();
                     String model = data[1].trim();
                     String year = data[2].trim();
                     map.put(vehicleReg.replace(" ", ""), new VehicleData(data[0], data[1], data[2], data[3]));
                 }
                 line = bufferedReader.readLine();
             }
        } catch (IOException e) {
            throw new RuntimeException("Error reading vehicle data file: " + path);
        }
        return map;
    }
}

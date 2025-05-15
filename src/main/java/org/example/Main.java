package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVParser;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String csvFilePath = "foreign_names.csv";

        try (InputStream in = Main.class.getClassLoader().getResourceAsStream(csvFilePath)) {
            if (in == null) {
                throw new FileNotFoundException("File not found: " + csvFilePath);
            }

            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(';')
                    .build();

            CSVReader reader = new CSVReaderBuilder(new InputStreamReader(in, StandardCharsets.UTF_8))
                    .withCSVParser(parser)
                    .build();

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                System.out.println(Arrays.toString(nextLine));
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("Error reading CSV file", e);
        }
    }
}
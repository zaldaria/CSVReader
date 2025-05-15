package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVParser;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        String csvFilePath = "foreign_names.csv";
        LinkedList<Person> people = new LinkedList<>();
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

            String[] nextLine = reader.readNext();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            while ((nextLine = reader.readNext()) != null) {
                System.out.println(Arrays.toString(nextLine));
                Person person = new Person(nextLine[0],nextLine[1], nextLine[2], LocalDate.parse(nextLine[3], formatter), new Department(nextLine[4]), Double.parseDouble(nextLine[5]));
                people.add(person);
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("Error reading CSV file", e);
        }

        System.out.println("\n ----- List of people data : ----- \n");
        for (int i=0; i< people.size();i++){
            System.out.println((i+1) + ". " + people.get(i).toString());
        }
    }
}
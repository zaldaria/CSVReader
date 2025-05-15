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

/**
 * Главный класс приложения для обработки CSV-файла с информацией о людях.
 * <p>
 * Читает данные из CSV-файла, парсит их в объекты Person и выводит результат.
 * </p>
 */
public class Main {

    /**
     * Точка входа в приложение.
     * <p>
     * Обрабатывает CSV-файл, содержащий информацию о людях, и выводит результат.
     * </p>
     *
     * @param args аргументы командной строки (не используются)
     * @throws RuntimeException если произошла ошибка при чтении или обработке файла
     */
    public static void main(String[] args) {
        String csvFilePath = "foreign_names.csv";
        LinkedList<Person> people = new LinkedList<>();

        try (InputStream in = Main.class.getClassLoader().getResourceAsStream(csvFilePath)) {
            if (in == null) {
                throw new FileNotFoundException("File not found: " + csvFilePath);
            }

            // Настройка парсера CSV с разделителем ';'
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(';')
                    .build();

            // Создание CSVReader с указанными настройками
            CSVReader reader = new CSVReaderBuilder(new InputStreamReader(in, StandardCharsets.UTF_8))
                    .withCSVParser(parser)
                    .build();

            // Пропускаем заголовок (первую строку)
            String[] nextLine = reader.readNext();

            // Форматтер для даты в формате "день.месяц.год"
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

            // Чтение данных из CSV и создание объектов Person
            while ((nextLine = reader.readNext()) != null) {
                System.out.println(Arrays.toString(nextLine));
                Person person = new Person(
                        nextLine[0],    // ID
                        nextLine[1],   // Имя
                        nextLine[2],    // Пол
                        LocalDate.parse(nextLine[3], formatter), // Дата рождения
                        new Department(nextLine[4]), // Отдел
                        Double.parseDouble(nextLine[5]) // Зарплата
                );
                people.add(person);
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("Error reading CSV file", e);
        }

        // Вывод результатов
        System.out.println("\n ----- List of people data : ----- \n");
        for (int i = 0; i < people.size(); i++) {
            System.out.println((i + 1) + ". " + people.get(i).toString());
        }
    }
}
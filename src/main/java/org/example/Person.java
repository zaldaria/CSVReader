package org.example;

import java.time.LocalDate;

/**
 * Класс, представляющий информацию о человеке/сотруднике.
 * Содержит персональные данные и информацию о работе.
 */
public class Person {
    private String id;
    private String name;
    private String gender;
    private Department department;
    private Double salary;
    private LocalDate birthDate;

    /**
     * Конструктор для создания объекта Person.
     *
     * @param _id идентификатор человека
     * @param _name имя человека
     * @param _gender пол человека
     * @param _date дата рождения
     * @param _department отдел, в котором работает человек
     * @param _salary зарплата человека
     */
    Person(String _id, String _name, String _gender, LocalDate _date, Department _department, Double _salary) {
        id = _id;
        name = _name;
        gender = _gender;
        department = _department;
        salary = _salary;
        birthDate = _date;
    }

    /**
     * Получает идентификатор человека.
     *
     * @return идентификатор человека
     */
    public String getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор человека.
     *
     * @param id новый идентификатор
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Получает имя человека.
     *
     * @return имя человека
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя человека.
     *
     * @param name новое имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получает пол человека.
     *
     * @return пол человека
     */
    public String getGender() {
        return gender;
    }

    /**
     * Устанавливает пол человека.
     *
     * @param gender новый пол
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Получает отдел, в котором работает человек.
     *
     * @return объект Department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Устанавливает отдел для человека.
     *
     * @param department новый отдел
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Получает зарплату человека.
     *
     * @return значение зарплаты
     */
    public Double getSalary() {
        return salary;
    }

    /**
     * Устанавливает зарплату человека.
     *
     * @param salary новая зарплата
     */
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    /**
     * Получает дату рождения человека.
     *
     * @return дата рождения
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Устанавливает дату рождения человека.
     *
     * @param birthDate новая дата рождения
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Возвращает строковое представление объекта Person.
     * Формат: "id name gender birthDate department salary"
     *
     * @return строковое представление
     */
    public String toString() {
        return id + " " + name + " " + gender + " " + birthDate + " " + department + " " + salary;
    }
}
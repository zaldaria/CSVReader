package org.example;

import java.time.LocalDate;

public class Person {
    private String id;
    private String name;
    private String gender;
    private Department department;
    private Double salary;
    private LocalDate birthDate;
    Person(String _id, String _name, String _gender, LocalDate _date, Department _department, Double _salary ){
        id = _id;
        name = _name;
        gender = _gender;
        department = _department;
        salary = _salary;
        birthDate = _date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String toString(){
        return id + " " + name + " " + gender + " " + birthDate + " " + department + " " + salary;
    }

}


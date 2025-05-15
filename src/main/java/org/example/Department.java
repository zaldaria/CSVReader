package org.example;
import java.util.Random;

public class Department{
    private Integer id;
    private String name;
    Department(String _name){
        id = generateDepartmentID();
        name = _name;
    }
    Department(Integer _id, String _name){
        id = _id;
        name = _name;
    }

    public String toString(){
        return id + " - " + name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int generateDepartmentID() {
        Random random = new Random();
        return random.nextInt(100000);
    }
}

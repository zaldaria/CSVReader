package org.example;
import java.util.Random;
/**
 * Класс, представляющий отдел в организации.
 * <p>
 * Содержит информацию об идентификаторе отдела и его названии.
 * Идентификатор может быть задан явно или сгенерирован автоматически.
 * </p>
 */
public class Department{
    /** Уникальный идентификатор отдела */
    private Integer id;
    /** Название отдела */
    private String name;
    /**
     * Конструктор для создания отдела с автоматической генерацией ID.
     *
     * @param _name название отдела
     */
    Department(String _name){
        id = generateDepartmentID();
        name = _name;
    }
    /**
     * Конструктор для создания отдела с указанным ID.
     *
     * @param _id уникальный идентификатор отдела
     * @param _name название отдела
     */
    Department(Integer _id, String _name){
        id = _id;
        name = _name;
    }
    /**
     * Возвращает строковое представление отдела в формате "ID - Название".
     *
     * @return строковое представление объекта
     */
    public String toString(){
        return id + " - " + name;
    }
    /**
     * Получает идентификатор отдела.
     *
     * @return уникальный идентификатор отдела
     */
    public Integer getId() {
        return id;
    }
    /**
     * Устанавливает идентификатор отдела.
     *
     * @param id новый идентификатор
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Получает название отдела.
     *
     * @return название отдела
     */
    public String getName() {
        return name;
    }
    /**
     * Устанавливает название отдела.
     *
     * @param name новое название
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Генерирует случайный идентификатор отдела, случайное число в диапазоне от 0 до 99999 включительно.
     * </p>
     *
     * @return случайно сгенерированный идентификатор отдела
     */
    public static int generateDepartmentID() {
        Random random = new Random();
        return random.nextInt(100000);
    }
}

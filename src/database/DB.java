package database;
import entity.*;
import utility.*;

public class DB {
    public static Student[] students;

    public static void save() {
        FileUtility.writeObjectToFile(DB.students, "students.obj");
    }

    public static void initialize() {
        try {
            students = (Student[]) FileUtility.readObjectFromFile("students.obj");
        } catch (Exception e) {
            students = new Student[0];
        }
    }
}

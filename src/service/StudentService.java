package service;
import entity.*;
import utility.*;
import database.*;

public class StudentService extends ManagementService{

    @Override
    public void process() {
        int studentMenu = InputUtility.askInt("Icra etmek istediyiniz emeliyyati secin: \n" +
                "1. Qeydiyyata almaq isteyirem \n" +
                "2. Axtarish vermek isteyirem \n" +
                "3. Silmek isteyirem \n" +
                "4. Melumat deyishmek isteyirem \n" +
                "5. Hamisini gormek isteyirem \n");
        if (studentMenu == 1) {
            register();
            DB.save();
        } else if (studentMenu == 2) {
            search();
        } else if (studentMenu == 3) {
            delete();
            DB.save();
        } else if (studentMenu == 4) {
            update();
            DB.save();
        } else if (studentMenu == 5) {
            showAll();
        }
    }
    @Override
    public void register() {
        int registrationCount = InputUtility.askInt("Neche telebe qeydiyyata almaq isteyirsiniz:");
        Student[] oldStudents =  DB.students;
        Student[] newStudents = new Student [registrationCount]; //??????

        for (int i = 0; i < registrationCount; i++) {
            newStudents[i] = prepareStudent();
        }

        Student[] result = new Student[oldStudents.length + newStudents.length]; //arrayin limitinin genişlənmədsi
//        System.arraycopy(oldStudents,0,result,0,oldStudents.length); // src - source array, srcPos - starting position in the source array, dest - destination array, destPos - starting position in the destination data, length - the number of array elements to be copied
//        System.arraycopy(newStudents,0,result,oldStudents.length,newStudents.length);
        for (int i=0;i< oldStudents.length;i++) {
            result[i] = oldStudents[i];
        }

        for (int i=0;i< newStudents.length;i++) {
            result[oldStudents.length + i] = newStudents[i];
        }

        DB.students = result;
    }

    @Override
    public void search() {
        String search = InputUtility.askString("Adini ve ya soyadini daxil edin:");
        for (int i = 0; i < DB.students.length; i++) {
            Student student = DB.students[i];
            if (StringUtility.containsIgnoreCase(student.getName(), search) ||
                    StringUtility.containsIgnoreCase(student.getSurname(), search)) {
                System.out.println(i + "." + student);
            }
        }
    }
    @Override
    public void delete() {
        search();

        int studentNumber = InputUtility.askInt("Nomresini daxil edin:");

        DB.students[studentNumber] = null;
        Student[] newStudents = new Student[DB.students.length - 1]; //???????????
        int j = 0;
        for (int i = 0; i < DB.students.length; i++) {
            if (DB.students[i] != null) {
                newStudents[j] = DB.students[i];
                j++;
            }
        }
        DB.students = newStudents;
    }
    @Override
    public void update() {
        search();

        int studentNumber = InputUtility.askInt("Nomresini daxil edin:");

        Student student = DB.students[studentNumber];

        while (true) {
            String field = InputUtility.askString("Hansi melumati daxil etmek isteyirsiniz: ");
            if (field.equalsIgnoreCase("name")) {
                student.setName(InputUtility.askString("Telebenin adini daxil edin: "));
            } else if (field.equalsIgnoreCase("surname")) {
                student.setSurname(InputUtility.askString("Telebenin soyadini daxil edin: "));
            } else if (field.equalsIgnoreCase("age")) {
                student.setAge(InputUtility.askInt("Telebenin yashini daxil edin: "));
            } else if (field.equalsIgnoreCase("scholarship")) {
                student.setScholarship(InputUtility.askDouble("Telebenin teqaudunu daxil edin: "));
            } else if (field.equalsIgnoreCase("university")) {
                University university = new University();
                university.setName(InputUtility.askString("Telebenin universitetini daxil edin"));
                student.setUniversity(university);
            } else if (field.equalsIgnoreCase("done")) {
                break;
            }
        }
    }
    @Override
    public void showAll() {
        for (int i = 0; i < DB.students.length; i++) {
            System.out.println(DB.students[i]);
        }
    }
    private static Student prepareStudent() {
        Student student = new Student();

        student.setName(InputUtility.askString("Telebenin adini daxil edin: "));
        student.setSurname(InputUtility.askString("Telebenin soyadini daxil edin: "));
        student.setAge(InputUtility.askInt("Telebenin yashini daxil edin: "));
        student.setScholarship(InputUtility.askDouble("Telebenin teqaudunu daxil edin: "));

        University university = new University();
        university.setName(InputUtility.askString("Telebenin universitetini daxil edin"));

        student.setUniversity(university);

        return student;
    }
}

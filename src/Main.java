import utility.*;

import java.lang.reflect.Method;

public class Main {

    // File ile student registration system
//    public static void main(String[] args) {
//
//        DB.initialize();
//
//        while (true) {
//            int menu = InputUtility.askInt(
//                    "telebeler yoxsa Muellimler haqqinda emeliyyat icra etmek istetyirsiniz: \n" +
//                            "1. Muelimler \n" +
//                            "2. Telebeler \n" +
//                            "3. Exit");
//            ManagementService service = null; //???????
//            if (menu == 1) {
//                service = new TeacherService();
//            } else if (menu == 2) {
//                service = new StudentService();
//
//            } else if (menu == 3) {
//                System.exit(0);
//            } else {
//                System.out.println("emeliyyat duzgun daxil edilmeyib");
//            }
//
//            if (menu == 1 || menu == 2) {
//                service.process();
//            }
//        }
//    }

    //Reflection APİ
    public static void main(String[] args) throws Exception {
        Method method = StringUtility.class.getDeclaredMethod("containsIgnoreCase2", String.class, String.class);
        method.setAccessible(true);

        Boolean result = (Boolean) method.invoke(StringUtility.class, "Salam", "Salam");

        System.out.println(result);
    }
}
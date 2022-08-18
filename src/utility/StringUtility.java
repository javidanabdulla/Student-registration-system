package utility;

public class StringUtility {

    public static boolean containsIgnoreCase(String val1, String val2) {
        return val1.toLowerCase().contains(val2.toLowerCase());
    }

    private static boolean containsIgnoreCase2(String val1, String val2) {
        return val1.toLowerCase().contains(val2.toLowerCase());
    }
}

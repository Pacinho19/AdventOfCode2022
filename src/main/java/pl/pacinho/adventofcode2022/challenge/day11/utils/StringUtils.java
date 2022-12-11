package pl.pacinho.adventofcode2022.challenge.day11.utils;

public class StringUtils {

    public static Long getLongValue(String str) {
        String number = getNumber(str);
        if (number.isEmpty()) return -1L;
        return Long.parseLong(number);
    }

    private static String getNumber(String str) {
        return str.replaceAll("\\D+", "");
    }
}
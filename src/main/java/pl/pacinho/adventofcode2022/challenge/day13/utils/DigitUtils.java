package pl.pacinho.adventofcode2022.challenge.day13.utils;

public class DigitUtils {

    public static boolean isDigit(String sign) {
        try {
            Integer.parseInt(sign);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

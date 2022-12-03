package pl.pacinho.adventofcode2022.challenge.day3.utils;

public class PointsCalculator {
    public static long calculate(Character ch) {
        String letter = String.valueOf(ch);
        return (AlphabetUtils.alphabet.indexOf(letter.toLowerCase().toCharArray()[0])
                + 1) + getTypeOfLetter(letter);
    }

    private static long getTypeOfLetter(String letter) {
        return letter.toUpperCase().equals(letter)
                ? 26
                : 0;
    }
}
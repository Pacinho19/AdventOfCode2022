package pl.pacinho.adventofcode2022.challenge.day3;

import junit.framework.TestCase;
import org.junit.Test;

public class Day3Part1Test extends TestCase {

    @Test
    public void testCalculate() {
        assertEquals(157, new Day3Part1().calculate("challenges\\day3\\example.txt"));
    }
}
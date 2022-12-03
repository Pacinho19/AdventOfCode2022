package pl.pacinho.adventofcode2022.challenge.day3;

import junit.framework.TestCase;
import org.junit.Test;

public class Day3Part2Test extends TestCase {

    @Test
    public void testCalculate() {
        assertEquals(70, new Day3Part2().calculate("challenges\\day3\\example.txt"));
    }
}
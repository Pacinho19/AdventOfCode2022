package pl.pacinho.adventofcode2022.challenge.day1;

import junit.framework.TestCase;
import org.junit.Test;

public class Day1Part2Test extends TestCase {

    @Test
    public void testCalculate() {
        assertEquals(45000, new Day1Part2().calculate("challenges\\day1\\example.txt"));
    }
}
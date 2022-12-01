package pl.pacinho.adventofcode2022.challenge.day1;

import junit.framework.TestCase;
import org.junit.Test;

public class Day1Part1Test extends TestCase{

    @Test
    public void testCalculate() {
        assertEquals(24000, new Day1Part1().calculate("challenges\\day1\\example.txt"));
    }
}
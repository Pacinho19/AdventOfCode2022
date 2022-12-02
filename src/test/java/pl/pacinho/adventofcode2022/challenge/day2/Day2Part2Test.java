package pl.pacinho.adventofcode2022.challenge.day2;

import junit.framework.TestCase;
import org.junit.Test;

public class Day2Part2Test extends TestCase {
    @Test
    public void testCalculate() {
        assertEquals(12, new Day2Part2().calculate("challenges\\day2\\example.txt"));
    }
}
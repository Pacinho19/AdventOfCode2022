package pl.pacinho.adventofcode2022.challenge.day9;

import junit.framework.TestCase;
import org.junit.Test;

public class Day9Part2Test extends TestCase {

    @Test
    public void testCalculate() {
        assertEquals(36, new Day9Part2().calculate("challenges\\day9\\example2.txt"));
    }
}
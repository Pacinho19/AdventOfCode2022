package pl.pacinho.adventofcode2022.challenge.day9;

import junit.framework.TestCase;
import org.junit.Test;

public class Day9Part1Test extends TestCase {

    @Test
    public void testCalculate() {
        assertEquals(13, new Day9Part1().calculate("challenges\\day9\\example.txt"));
    }
}
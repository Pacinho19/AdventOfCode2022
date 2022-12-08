package pl.pacinho.adventofcode2022.challenge.day8;

import junit.framework.TestCase;
import org.junit.Test;

public class Day8Part1Test extends TestCase {

    @Test
    public void testCalculate() {
        assertEquals(21, new Day8Part1().calculate("challenges\\day8\\example.txt"));
    }
}
package pl.pacinho.adventofcode2022.challenge.day8;

import junit.framework.TestCase;
import org.junit.Test;

public class Day8Part2Test extends TestCase {

    @Test
    public void testCalculate() {
        assertEquals(8, new Day8Part2().calculate("challenges\\day8\\example.txt"));
    }
}
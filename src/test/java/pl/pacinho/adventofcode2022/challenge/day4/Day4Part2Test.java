package pl.pacinho.adventofcode2022.challenge.day4;

import junit.framework.TestCase;
import org.junit.Test;

public class Day4Part2Test extends TestCase {

    @Test
    public void testCalculate() {
        assertEquals(4, new Day4Part2().calculate("challenges\\day4\\example.txt"));
    }
}
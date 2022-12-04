package pl.pacinho.adventofcode2022.challenge.day4;

import junit.framework.TestCase;
import org.junit.Test;

public class Day4Part1Test extends TestCase {

    @Test
    public void testCalculate() {
        assertEquals(2, new Day4Part1().calculate("challenges\\day4\\example.txt"));
    }
}
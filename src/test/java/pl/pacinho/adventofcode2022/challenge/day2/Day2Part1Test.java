package pl.pacinho.adventofcode2022.challenge.day2;

import junit.framework.TestCase;
import org.junit.Test;

public class Day2Part1Test extends TestCase {

    @Test
    public void testCalculate() {
        assertEquals(15, new Day2Part1().calculate("challenges\\day2\\example.txt"));
    }
}
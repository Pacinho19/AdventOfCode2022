package pl.pacinho.adventofcode2022.challenge.day11;

import junit.framework.TestCase;
import org.junit.Test;

public class Day11Part1Test extends TestCase {

    @Test
    public void testCalculate() {
        assertEquals(10605, new Day11Part1().calculate("challenges\\day11\\example.txt"));
    }
}
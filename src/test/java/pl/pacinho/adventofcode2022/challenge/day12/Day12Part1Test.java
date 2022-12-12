package pl.pacinho.adventofcode2022.challenge.day12;

import junit.framework.TestCase;
import org.junit.Test;

public class Day12Part1Test extends TestCase {

    @Test
    public void testCalculate() {
        assertEquals(31, new Day12Part1Dijkstry().calculate("challenges\\day12\\example.txt"));
    }
}
package pl.pacinho.adventofcode2022.challenge.day10;

import junit.framework.TestCase;
import org.junit.Test;
import pl.pacinho.adventofcode2022.challenge.day9.Day9Part1;

public class Day10Part1Test extends TestCase {

    @Test
    public void testCalculate() {
        assertEquals(0, new Day10Part1().calculate("challenges\\day10\\example.txt"));
    }
}
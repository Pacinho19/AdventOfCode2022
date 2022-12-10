package pl.pacinho.adventofcode2022.challenge.day10;

import junit.framework.TestCase;
import org.junit.Test;

public class Day10Part1Test extends TestCase {

    @Test
    public void testCalculate() {
        assertEquals(13140, new Day10Part1().calculate("challenges\\day10\\example.txt"));
    }

}
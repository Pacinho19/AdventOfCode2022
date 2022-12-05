package pl.pacinho.adventofcode2022.challenge.day5;

import junit.framework.TestCase;
import org.junit.Test;

public class Day5Part2Test extends TestCase {

    @Test
    public void testCalculate() {
        assertEquals("MCD", new Day5Part2().calculate("challenges\\day5\\example.txt"));
    }
}
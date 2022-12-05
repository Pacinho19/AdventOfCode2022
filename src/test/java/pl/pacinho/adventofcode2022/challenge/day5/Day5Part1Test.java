package pl.pacinho.adventofcode2022.challenge.day5;

import junit.framework.TestCase;
import org.junit.Test;

public class Day5Part1Test extends TestCase {

    @Test
    public void testCalculate() {
        assertEquals("CMZ", new Day5Part1().calculate("challenges\\day5\\example.txt"));
    }
}
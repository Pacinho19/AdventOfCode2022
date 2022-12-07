package pl.pacinho.adventofcode2022.challenge.day7;

import junit.framework.TestCase;
import org.junit.Test;

public class Day7Part1Test extends TestCase {

    @Test
    public void testCalculate() {
        assertEquals(95437, new Day7Part1().calculate("challenges\\day7\\example.txt"));
    }
}
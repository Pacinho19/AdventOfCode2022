package pl.pacinho.adventofcode2022.challenge.day7;

import junit.framework.TestCase;
import org.junit.Test;

public class Day7Part2Test extends TestCase {

    @Test
    public void testCalculate() {
        assertEquals(24933642, new Day7Part2().calculate("challenges\\day7\\example.txt"));
    }
}
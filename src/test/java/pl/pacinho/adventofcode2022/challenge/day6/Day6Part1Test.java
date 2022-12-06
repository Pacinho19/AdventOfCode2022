package pl.pacinho.adventofcode2022.challenge.day6;

import junit.framework.TestCase;
import org.junit.Test;

public class Day6Part1Test extends TestCase {

    @Test
    public void testCalculate() {
        assertEquals(7, new Day6Part1().calculate("challenges\\day6\\example.txt"));
    }

    @Test
    public void testCalculate2() {
        assertEquals(5, new Day6Part1().calculate("challenges\\day6\\example2.txt"));
    }

    @Test
    public void testCalculate3() {
        assertEquals(6, new Day6Part1().calculate("challenges\\day6\\example3.txt"));
    }

    @Test
    public void testCalculate4() {
        assertEquals(10, new Day6Part1().calculate("challenges\\day6\\example4.txt"));
    }

    @Test
    public void testCalculate5() {
        assertEquals(11, new Day6Part1().calculate("challenges\\day6\\example5.txt"));
    }
}
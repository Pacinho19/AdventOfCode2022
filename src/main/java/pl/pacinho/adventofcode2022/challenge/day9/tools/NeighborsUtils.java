package pl.pacinho.adventofcode2022.challenge.day9.tools;

import java.util.List;

public class NeighborsUtils {

    public static List<String> getNeighbors(int x, int y) {
        return List.of(
                "" + (x - 1) + "," + (y + 1) //TOP LEFT
                , "" + (x) + "," + (y + 1)  //TOP
                , "" + (x + 1) + "," + (y + 1) //TOP RIGHT
                , "" + (x - 1) + "," + (y) //LEFT
                , "" + (x) + "," + (y) //SELF
                , "" + (x + 1) + "," + (y) //RIGHT
                , "" + (x - 1) + "," + (y - 1) //BOOTOM LEFT
                , "" + (x) + "," + (y - 1) //BOOTOM
                , "" + (x + 1) + "," + (y - 1) //BOOTOM RIGHT
        );
    }

    public static List<String> getNeighborsDiagonally(int x, int y) {
        return List.of(
                "" + (x - 1) + "," + (y + 1) //TOP LEFT
                , "" + (x + 1) + "," + (y + 1) //TOP RIGHT
                , "" + (x - 1) + "," + (y - 1) //BOOTOM LEFT
                , "" + (x + 1) + "," + (y - 1) //BOOTOM RIGHT
        );
    }
}

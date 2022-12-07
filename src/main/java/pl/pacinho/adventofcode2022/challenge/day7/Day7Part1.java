package pl.pacinho.adventofcode2022.challenge.day7;

import pl.pacinho.adventofcode2022.challenge.CalculateI;
import pl.pacinho.adventofcode2022.challenge.day7.filesystem.model.enums.Command;
import pl.pacinho.adventofcode2022.challenge.day7.filesystem.model.enums.CommandType;
import pl.pacinho.adventofcode2022.challenge.day7.filesystem.tools.FileSystemTools;
import pl.pacinho.adventofcode2022.challenge.day7.model.FileSystem;
import pl.pacinho.adventofcode2022.challenge.day7.model.MyFile;
import pl.pacinho.adventofcode2022.utils.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Day7Part1 implements CalculateI {

    private static final Long SIZE_LIMIT = 100000L;

    @Override
    public long calculate(String filePath) {
        FileUtils.readTxt(new File(filePath))
                .stream()
                .skip(1)
                .map(s -> new Command(s, CommandType.parse(s)))
                .forEach(Command::runCommand);

        return FileSystem.getInstance()
                .getRoot()
                .getFiles()
                .stream()
                .map(s -> FileSystemTools.lisOfDir(s, new ArrayList<>()))
                .flatMap(List::stream)
                .map(MyFile::getSize)
                .filter(size -> size <= SIZE_LIMIT)
                .reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        System.out.println(
                new Day7Part1().calculate("challenges\\day7\\input.txt")
        );
    }
}

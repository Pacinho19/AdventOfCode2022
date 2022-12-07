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
import java.util.Comparator;
import java.util.List;

public class Day7Part2 implements CalculateI {

    private static final Long FILE_SYSTEM_SIZE = 70000000L;
    private static final Long UPDATE_REQUIRED_SIZE = 30000000L;

    @Override
    public long calculate(String filePath) {
        if (FileSystem.getInstance().getRoot() == null)
            FileUtils.readTxt(new File(filePath))
                    .stream()
                    .skip(1)
                    .map(s -> new Command(s, CommandType.parse(s)))
                    .forEach(c -> c.runCommand(FileSystem.getInstance()));

        long missingSize = Math.abs(FILE_SYSTEM_SIZE - FileSystem.getInstance().getRoot().getSize() - UPDATE_REQUIRED_SIZE);

        return FileSystem.getInstance()
                .getRoot()
                .getFiles()
                .stream()
                .map(s -> FileSystemTools.lisOfDir(s, new ArrayList<>()))
                .flatMap(List::stream)
                .map(MyFile::getSize)
                .filter(size -> size >= missingSize)
                .min(Comparator.comparing(Long::longValue))
                .orElse(0L);
    }

    public static void main(String[] args) {
        System.out.println(
                new Day7Part2().calculate("challenges\\day7\\input.txt")
        );
    }
}

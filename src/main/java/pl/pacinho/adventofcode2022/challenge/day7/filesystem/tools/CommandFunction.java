package pl.pacinho.adventofcode2022.challenge.day7.filesystem.tools;

import pl.pacinho.adventofcode2022.challenge.day7.filesystem.model.enums.CommandType;
import pl.pacinho.adventofcode2022.challenge.day7.model.FileSystem;
import pl.pacinho.adventofcode2022.challenge.day7.model.MyFile;
import pl.pacinho.adventofcode2022.challenge.day7.model.enums.FileType;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class CommandFunction {

    private static  final FileSystem filesystem = FileSystem.getInstance();
    public static final Consumer<String> CD = (String param) -> {
        String name = param.replace(CommandType.CD.getCmd(), "").trim();
        MyFile dir;
        if (name.equals(".."))
            dir = filesystem.getActualLocation().getParent();
        else
            dir = filesystem.getActualLocation() .getByName(name);

        filesystem.setActualLocation(dir);
    };

    public static final Consumer<String> DIR = (String param) ->
            filesystem.getActualLocation().addFile(
                    new MyFile(filesystem.getActualLocation(), param.split(" ")[1], 0, FileType.DIR)
            );
    public static final Consumer<String> FILE = (String param) ->
            filesystem.getActualLocation().addFile(
                    new MyFile(filesystem.getActualLocation(), param.split(" ")[1], Long.parseLong(param.split(" ")[0]), FileType.FILE)
            );

}

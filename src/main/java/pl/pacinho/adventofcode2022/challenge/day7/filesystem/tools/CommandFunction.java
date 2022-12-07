package pl.pacinho.adventofcode2022.challenge.day7.filesystem.tools;

import pl.pacinho.adventofcode2022.challenge.day7.filesystem.model.enums.CommandType;
import pl.pacinho.adventofcode2022.challenge.day7.model.FileSystem;
import pl.pacinho.adventofcode2022.challenge.day7.model.MyFile;
import pl.pacinho.adventofcode2022.challenge.day7.model.enums.FileType;

import java.util.function.BiConsumer;

public class CommandFunction {
    public static final BiConsumer<String, FileSystem> CD = (String param, FileSystem filesystem) -> {
        String name = param.replace(CommandType.CD.getCmd(), "").trim();
        MyFile dir;
        if (name.equals(".."))
            dir = filesystem.getActualLocation().getParent();
        else
            dir = filesystem.getActualLocation() .getByName(name);

        filesystem.setActualLocation(dir);
    };

    public static final BiConsumer<String, FileSystem> DIR = (String param, FileSystem filesystem) ->
            filesystem.getActualLocation().addFile(
                    new MyFile(filesystem.getActualLocation(), param.split(" ")[1], 0, FileType.DIR)
            );
    public static final BiConsumer<String, FileSystem> FILE = (String param, FileSystem filesystem) ->
            filesystem.getActualLocation().addFile(
                    new MyFile(filesystem.getActualLocation(), param.split(" ")[1], Long.parseLong(param.split(" ")[0]), FileType.FILE)
            );

}

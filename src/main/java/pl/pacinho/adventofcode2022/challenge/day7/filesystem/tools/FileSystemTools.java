package pl.pacinho.adventofcode2022.challenge.day7.filesystem.tools;

import pl.pacinho.adventofcode2022.challenge.day7.model.MyFile;
import pl.pacinho.adventofcode2022.challenge.day7.model.enums.FileType;

import java.util.ArrayList;
import java.util.List;

public class FileSystemTools {

    public static List<MyFile> lisOfDir(MyFile f, ArrayList<MyFile> lisOfDir) {
        if (f.getFileType() == FileType.FILE) return lisOfDir;

        lisOfDir.add(f);
        f.getFiles().forEach(f1 -> lisOfDir(f1, lisOfDir));

        return lisOfDir;
    }
}

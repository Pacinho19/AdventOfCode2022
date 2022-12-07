package pl.pacinho.adventofcode2022.challenge.day7.model;

import lombok.Getter;
import lombok.Setter;
import pl.pacinho.adventofcode2022.challenge.day7.model.enums.FileType;

@Getter
public class FileSystem {

    private MyFile root;
    @Setter
    private MyFile actualLocation;

     FileSystem() {
        MyFile root = new MyFile(null, "root", 0, FileType.DIR);
        this.root = root;
        this.actualLocation = root;
    }

    private static FileSystem self;
    public static FileSystem getInstance() {
        if(self==null) self = new FileSystem();
        return self;
    }
}

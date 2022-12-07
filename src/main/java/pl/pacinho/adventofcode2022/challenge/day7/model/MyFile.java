package pl.pacinho.adventofcode2022.challenge.day7.model;

import lombok.Getter;
import lombok.SneakyThrows;
import pl.pacinho.adventofcode2022.challenge.day7.model.enums.FileType;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Getter
public class MyFile {

    private MyFile parent;
    private String name;
    private long size;
    private FileType fileType;
    private List<MyFile> files;

    public MyFile(MyFile parent, String name, long size, FileType fileType) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.fileType = fileType;
        this.files = new ArrayList<>();
    }

    public void addFile(MyFile file) {
        this.addSize(file.getSize());
        this.files.add(file);
    }

    public void addSize(long size) {
        if(this.getParent()!=null)
            this.getParent().addSize(size);
        this.size += size;
    }

    @SneakyThrows
    public MyFile getByName(String name) {
        return this.files
                .stream()
                .filter(file -> file.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new FileNotFoundException(name));
    }

    @Override
    public String toString() {
        return this.name + "(" + this.getFileType().name() + ", size=" + this.size+")";
    }
}

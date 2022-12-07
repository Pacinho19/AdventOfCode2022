package pl.pacinho.adventofcode2022.challenge.day7.filesystem.model.enums;

import pl.pacinho.adventofcode2022.challenge.day7.model.FileSystem;

public record Command(String text, CommandType commandType) {
    public void runCommand() {
        this.commandType.runCommand(text);
    }
}

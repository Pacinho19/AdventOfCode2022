package pl.pacinho.adventofcode2022.challenge.day7.filesystem.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.pacinho.adventofcode2022.challenge.day7.filesystem.tools.CommandFunction;
import pl.pacinho.adventofcode2022.challenge.day7.model.FileSystem;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@RequiredArgsConstructor
public enum CommandType {

    CD("$ cd", CommandFunction.CD),
    LS("$ ls", null),
    DIR("dir", CommandFunction.DIR),
    FILE("", CommandFunction.FILE);

    @Getter
    private final String cmd;
    private final Consumer<String> function;

    public void runCommand(String params) {
        if (function == null) return;
        function.accept(params);
    }

    public static CommandType parse(String text) {
        return Arrays.stream(CommandType.values())
                .filter(cmd -> text.startsWith(cmd.getCmd()))
                .findFirst()
                .orElse(CommandType.FILE);
    }
}

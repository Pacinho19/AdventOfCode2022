package pl.pacinho.adventofcode2022.challenge.day13;

import org.apache.commons.collections4.ListUtils;
import pl.pacinho.adventofcode2022.challenge.CalculateI;
import pl.pacinho.adventofcode2022.challenge.day13.model.Signal;
import pl.pacinho.adventofcode2022.challenge.day13.utils.SignalUtils;
import pl.pacinho.adventofcode2022.utils.FileUtils;

import java.io.File;
import java.util.List;
import java.util.stream.IntStream;

public class Day13Part1 implements CalculateI {


    //To low 5344
    //To high 7487

    @Override
    public long calculate(String filePath) {
        List<Signal> signals = ListUtils.partition(
                        FileUtils.readTxt(new File(filePath))
                                .stream()
                                .filter(l -> !l.trim().isEmpty())
                                .toList(),
                        2
                ).stream()
                .map(SignalUtils::parse)
                .toList();

        return IntStream.range(0, signals.size())
                .boxed()
                .mapToInt(i -> SignalUtils.isRightOrder(signals.get(i)) ? i + 1 : 0)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(
                new Day13Part1().calculate("challenges\\day13\\input.txt")
        );
    }
}
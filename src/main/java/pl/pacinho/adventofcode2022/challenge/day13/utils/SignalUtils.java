package pl.pacinho.adventofcode2022.challenge.day13.utils;

import pl.pacinho.adventofcode2022.challenge.day13.model.Packet;
import pl.pacinho.adventofcode2022.challenge.day13.model.PacketValue;
import pl.pacinho.adventofcode2022.challenge.day13.model.Side;
import pl.pacinho.adventofcode2022.challenge.day13.model.Signal;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class SignalUtils {
    public static Signal parse(List<String> sb) {
        Signal signal = new Signal();
        parsePackets(sb.get(0), signal.getLeft());
        parsePackets(sb.get(1), signal.getRight());
        return signal;
    }

    private static void parsePackets(String line, Side side) {
        List<String> items = Arrays.stream(line
                        .split(""))
                .toList();

        AtomicInteger order = new AtomicInteger(0);
        AtomicInteger group = new AtomicInteger(0);
        items.forEach(
                sign -> {
                    if (DigitUtils.isDigit(sign)) addValue(side, order, group, sign);
                    else if (sign.equals(",")) return;
                    else if (sign.equals("[")) newPacket(side, group);
                    else if (sign.equals("]")) side.setCurrentPacket(side.getCurrentPacket().getParent());
                }
        );

    }

    private static void addValue(Side side, AtomicInteger order, AtomicInteger group, String sign) {
        Packet currentPacket = side.getCurrentPacket();
        if(currentPacket.getGroup()==null) currentPacket.setGroup(group.getAndAdd(1));
        currentPacket.addValue(new PacketValue(order.getAndAdd(1), Integer.parseInt(sign)));
    }


    private static void newPacket(Side side, AtomicInteger group) {
        Packet packet = new Packet(side.getCurrentPacket());
        if (side.getMainPacket() == null)
            side.setMainPacket(packet);
        else{
            packet.setGroup(group.getAndAdd(1));
            side.getCurrentPacket().addSubpackage(packet);
        }

        side.setCurrentPacket(packet);
    }

    public static boolean isRightOrder(Signal signal) {
        int order = 0;
        while (true) {
            Item itemLeft = getItemToCompare(order, signal.getLeft().getMainPacket());
            Item itemRight = getItemToCompare(order, signal.getRight().getMainPacket());
            if (itemLeft == null && itemRight != null) return true;
            else if (itemRight == null) return false;
            else if (itemLeft.packet().getGroup() == itemRight.packet().getGroup()
                     && itemLeft.value() < itemRight.value()) return true;
            else if (itemLeft.packet().getGroup() == itemRight.packet().getGroup()
                     && itemLeft.value() > itemRight.value()) return false;
            order++;
        }
    }

    private static Item getItemToCompare(int order, Packet item) {
        while (true) {
            for (PacketValue pv : item.getValues()) {
                if (pv.order() == order)
                    return new Item(pv.value(), pv.order(), item);

            }
            return item.getSubPackets()
                    .stream()
                    .map(p -> getItemToCompare(order, p))
                    .filter(Objects::nonNull)
                    .findFirst()
                    .orElse(null);
        }

    }
}

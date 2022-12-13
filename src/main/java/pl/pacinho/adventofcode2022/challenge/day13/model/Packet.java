package pl.pacinho.adventofcode2022.challenge.day13.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Packet {

    private Packet parent;
    private List<PacketValue> values;
    private List<Packet> subPackets;

    @Setter
    private Integer group;

    public Packet(Packet parent) {
        this.parent = parent;
        this.values = new ArrayList<>();
        this.subPackets = new ArrayList<>();
    }

    public void addValue(PacketValue value) {
        this.values.add(value);
    }

    public void addSubpackage(Packet subpackage) {
        this.subPackets.add(subpackage);
    }
}

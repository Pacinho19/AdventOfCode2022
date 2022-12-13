package pl.pacinho.adventofcode2022.challenge.day13.model;

import lombok.Getter;


@Getter
public class Signal {

    private Side left;
    private Side right;

    public Signal() {
        this.left = new Side();
        this.right = new Side();
    }

}

package pl.pacinho.adventofcode2022.challenge.day9.model.elf;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public abstract class Body {

    private int x;
    private int y;

    public Body() {
        this.x = 0;
        this.y = 0;
    }

    public String getPosition() {
        return this.x + "," + this.y;
    }

    public void changeX(int value) {
        this.x = x + value;
    }

    public void changeY(int value) {
        this.y = y + value;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}

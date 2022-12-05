package Fleet;

import Fleet.Ships;

public class Nau extends Ships {
    private String name = "NAU";
    private int occupy = 4;
    private int uses = 1;

    public int getOccupy() {
        return occupy;
    }

    public String getName() {
        return name;
    }
}

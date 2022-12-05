package Fleet;

import Fleet.Ships;

public class Submarine extends Ships {
    private String name = "SUBMARINE";
    private int occupy = 1;
    private int uses = 3;

    public int getOccupy() {
        return occupy;
    }

    public String getName() {
        return name;
    }
}

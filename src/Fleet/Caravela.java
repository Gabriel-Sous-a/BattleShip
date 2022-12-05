package Fleet;

import Fleet.Ships;

public class Caravela extends Ships {
    private String name = "CARAVELA";
    private int occupy = 3;
    private int uses = 1;

    public int getOccupy() {
        return occupy;
    }

    public String getName() {
        return name;
    }
}

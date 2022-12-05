package Fleet;

import Fleet.Ships;

public class GunBoat extends Ships {
    private String name = "GUNBOAT";
    private int occupy = 2;
    private int uses = 2;

    public int getOccupy() {
        return occupy;
    }

    public String getName() {
        return name;
    }
}

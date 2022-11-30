public class Board {
    static String meh = " ";
    private String grid[][] = new String[10][10];
    private String tacticalGrid[][] = new String[10][10];

    private int counterWin = 0;


    public void board() {

        clear(grid);
        clear(tacticalGrid);

        /*System.out.println();
            System.out.print("      A   B   C   D   E   F   G   H   I   J                         A   B   C   D   E   F   G   H   I   J \n");
            System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
            System.out.print("  1 | "+grid[0][0]+" | "+grid[0][1]+" | "+grid[0][2]+" | "+grid[0][3]+" | "+grid[0][4]+" | "+grid[0][5]+" | "+grid[0][6]+" | "+grid[0][7]+" | "+grid[0][8]+" | "+grid[0][9]+" |                   1 | "+tacticalGrid[0][0]+" | "+tacticalGrid[0][1]+" | "+tacticalGrid[0][2]+" | "+tacticalGrid[0][3]+" | "+tacticalGrid[0][4]+" | "+tacticalGrid[0][5]+" | "+tacticalGrid[0][6]+" | "+tacticalGrid[0][7]+" | "+tacticalGrid[0][8]+" | "+tacticalGrid[0][9]+" |\n");
            System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
            System.out.print("  2 | "+grid[1][0]+" | "+grid[1][1]+" | "+grid[1][2]+" | "+grid[1][3]+" | "+grid[1][4]+" | "+grid[1][5]+" | "+grid[1][6]+" | "+grid[1][7]+" | "+grid[1][8]+" | "+grid[1][9]+" |                   2 | "+tacticalGrid[1][0]+" | "+tacticalGrid[1][1]+" | "+tacticalGrid[1][2]+" | "+tacticalGrid[1][3]+" | "+tacticalGrid[1][4]+" | "+tacticalGrid[1][5]+" | "+tacticalGrid[1][6]+" | "+tacticalGrid[1][7]+" | "+tacticalGrid[1][8]+" | "+tacticalGrid[1][9]+" |\n");
            System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
            System.out.print("  3 | "+grid[2][0]+" | "+grid[2][1]+" | "+grid[2][2]+" | "+grid[2][3]+" | "+grid[2][4]+" | "+grid[2][5]+" | "+grid[2][6]+" | "+grid[2][7]+" | "+grid[2][8]+" | "+grid[2][9]+" |                   3 | "+tacticalGrid[2][0]+" | "+tacticalGrid[2][1]+" | "+tacticalGrid[2][2]+" | "+tacticalGrid[2][3]+" | "+tacticalGrid[2][4]+" | "+tacticalGrid[2][5]+" | "+tacticalGrid[2][6]+" | "+tacticalGrid[2][7]+" | "+tacticalGrid[2][8]+" | "+tacticalGrid[2][9]+" |\n");
            System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
            System.out.print("  4 | "+grid[3][0]+" | "+grid[3][1]+" | "+grid[3][2]+" | "+grid[3][3]+" | "+grid[3][4]+" | "+grid[3][5]+" | "+grid[3][6]+" | "+grid[3][7]+" | "+grid[3][8]+" | "+grid[3][9]+" |                   4 | "+tacticalGrid[3][0]+" | "+tacticalGrid[3][1]+" | "+tacticalGrid[3][2]+" | "+tacticalGrid[3][3]+" | "+tacticalGrid[3][4]+" | "+tacticalGrid[3][5]+" | "+tacticalGrid[3][6]+" | "+tacticalGrid[3][7]+" | "+tacticalGrid[3][8]+" | "+tacticalGrid[3][9]+" |\n");
            System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
            System.out.print("  5 | "+grid[4][0]+" | "+grid[4][1]+" | "+grid[4][2]+" | "+grid[4][3]+" | "+grid[4][4]+" | "+grid[4][5]+" | "+grid[4][6]+" | "+grid[4][7]+" | "+grid[4][8]+" | "+grid[4][9]+" |                   5 | "+tacticalGrid[4][0]+" | "+tacticalGrid[4][1]+" | "+tacticalGrid[4][2]+" | "+tacticalGrid[4][3]+" | "+tacticalGrid[4][4]+" | "+tacticalGrid[4][5]+" | "+tacticalGrid[4][6]+" | "+tacticalGrid[4][7]+" | "+tacticalGrid[4][8]+" | "+tacticalGrid[4][9]+" |\n");
            System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
            System.out.print("  6 | "+grid[5][0]+" | "+grid[5][1]+" | "+grid[5][2]+" | "+grid[5][3]+" | "+grid[5][4]+" | "+grid[5][5]+" | "+grid[5][6]+" | "+grid[5][7]+" | "+grid[5][8]+" | "+grid[5][9]+" |                   6 | "+tacticalGrid[5][0]+" | "+tacticalGrid[5][1]+" | "+tacticalGrid[5][2]+" | "+tacticalGrid[5][3]+" | "+tacticalGrid[5][4]+" | "+tacticalGrid[5][5]+" | "+tacticalGrid[5][6]+" | "+tacticalGrid[5][7]+" | "+tacticalGrid[5][8]+" | "+tacticalGrid[5][9]+" |\n");
            System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
            System.out.print("  7 | "+grid[6][0]+" | "+grid[6][1]+" | "+grid[6][2]+" | "+grid[6][3]+" | "+grid[6][4]+" | "+grid[6][5]+" | "+grid[6][6]+" | "+grid[6][7]+" | "+grid[6][8]+" | "+grid[6][9]+" |                   7 | "+tacticalGrid[6][0]+" | "+tacticalGrid[6][1]+" | "+tacticalGrid[6][2]+" | "+tacticalGrid[6][3]+" | "+tacticalGrid[6][4]+" | "+tacticalGrid[6][5]+" | "+tacticalGrid[6][6]+" | "+tacticalGrid[6][7]+" | "+tacticalGrid[6][8]+" | "+tacticalGrid[6][9]+" |\n");
            System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
            System.out.print("  8 | "+grid[7][0]+" | "+grid[7][1]+" | "+grid[7][2]+" | "+grid[7][3]+" | "+grid[7][4]+" | "+grid[7][5]+" | "+grid[7][6]+" | "+grid[7][7]+" | "+grid[7][8]+" | "+grid[7][9]+" |                   8 | "+tacticalGrid[7][0]+" | "+tacticalGrid[7][1]+" | "+tacticalGrid[7][2]+" | "+tacticalGrid[7][3]+" | "+tacticalGrid[7][4]+" | "+tacticalGrid[7][5]+" | "+tacticalGrid[7][6]+" | "+tacticalGrid[7][7]+" | "+tacticalGrid[7][8]+" | "+tacticalGrid[7][9]+" |\n");
            System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
            System.out.print("  9 | "+grid[8][0]+" | "+grid[8][1]+" | "+grid[8][2]+" | "+grid[8][3]+" | "+grid[8][4]+" | "+grid[8][5]+" | "+grid[8][6]+" | "+grid[8][7]+" | "+grid[8][8]+" | "+grid[8][9]+" |                   9 | "+tacticalGrid[8][0]+" | "+tacticalGrid[8][1]+" | "+tacticalGrid[8][2]+" | "+tacticalGrid[8][3]+" | "+tacticalGrid[8][4]+" | "+tacticalGrid[8][5]+" | "+tacticalGrid[8][6]+" | "+tacticalGrid[8][7]+" | "+tacticalGrid[8][8]+" | "+tacticalGrid[8][9]+" |\n");
            System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
            System.out.print(" 10 | "+grid[9][0]+" | "+grid[9][1]+" | "+grid[9][2]+" | "+grid[9][3]+" | "+grid[9][4]+" | "+grid[9][5]+" | "+grid[9][6]+" | "+grid[9][7]+" | "+grid[9][8]+" | "+grid[9][9]+" |                  10 | "+tacticalGrid[9][0]+" | "+tacticalGrid[9][1]+" | "+tacticalGrid[9][2]+" | "+tacticalGrid[9][3]+" | "+tacticalGrid[9][4]+" | "+tacticalGrid[9][5]+" | "+tacticalGrid[9][6]+" | "+tacticalGrid[9][7]+" | "+tacticalGrid[9][8]+" | "+tacticalGrid[9][9]+" |\n");
            System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
            System.out.println();
*/

    }

    public void tacticalBoard() {

        System.out.println();
        System.out.print("      A   B   C   D   E   F   G   H   I   J                         A   B   C   D   E   F   G   H   I   J \n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  1 | "+grid[0][0]+" | "+grid[0][1]+" | "+grid[0][2]+" | "+grid[0][3]+" | "+grid[0][4]+" | "+grid[0][5]+" | "+grid[0][6]+" | "+grid[0][7]+" | "+grid[0][8]+" | "+grid[0][9]+" |                   1 | "+tacticalGrid[0][0]+" | "+tacticalGrid[0][1]+" | "+tacticalGrid[0][2]+" | "+tacticalGrid[0][3]+" | "+tacticalGrid[0][4]+" | "+tacticalGrid[0][5]+" | "+tacticalGrid[0][6]+" | "+tacticalGrid[0][7]+" | "+tacticalGrid[0][8]+" | "+tacticalGrid[0][9]+" |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  2 | "+grid[1][0]+" | "+grid[1][1]+" | "+grid[1][2]+" | "+grid[1][3]+" | "+grid[1][4]+" | "+grid[1][5]+" | "+grid[1][6]+" | "+grid[1][7]+" | "+grid[1][8]+" | "+grid[1][9]+" |                   2 | "+tacticalGrid[1][0]+" | "+tacticalGrid[1][1]+" | "+tacticalGrid[1][2]+" | "+tacticalGrid[1][3]+" | "+tacticalGrid[1][4]+" | "+tacticalGrid[1][5]+" | "+tacticalGrid[1][6]+" | "+tacticalGrid[1][7]+" | "+tacticalGrid[1][8]+" | "+tacticalGrid[1][9]+" |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  3 | "+grid[2][0]+" | "+grid[2][1]+" | "+grid[2][2]+" | "+grid[2][3]+" | "+grid[2][4]+" | "+grid[2][5]+" | "+grid[2][6]+" | "+grid[2][7]+" | "+grid[2][8]+" | "+grid[2][9]+" |                   3 | "+tacticalGrid[2][0]+" | "+tacticalGrid[2][1]+" | "+tacticalGrid[2][2]+" | "+tacticalGrid[2][3]+" | "+tacticalGrid[2][4]+" | "+tacticalGrid[2][5]+" | "+tacticalGrid[2][6]+" | "+tacticalGrid[2][7]+" | "+tacticalGrid[2][8]+" | "+tacticalGrid[2][9]+" |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  4 | "+grid[3][0]+" | "+grid[3][1]+" | "+grid[3][2]+" | "+grid[3][3]+" | "+grid[3][4]+" | "+grid[3][5]+" | "+grid[3][6]+" | "+grid[3][7]+" | "+grid[3][8]+" | "+grid[3][9]+" |                   4 | "+tacticalGrid[3][0]+" | "+tacticalGrid[3][1]+" | "+tacticalGrid[3][2]+" | "+tacticalGrid[3][3]+" | "+tacticalGrid[3][4]+" | "+tacticalGrid[3][5]+" | "+tacticalGrid[3][6]+" | "+tacticalGrid[3][7]+" | "+tacticalGrid[3][8]+" | "+tacticalGrid[3][9]+" |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  5 | "+grid[4][0]+" | "+grid[4][1]+" | "+grid[4][2]+" | "+grid[4][3]+" | "+grid[4][4]+" | "+grid[4][5]+" | "+grid[4][6]+" | "+grid[4][7]+" | "+grid[4][8]+" | "+grid[4][9]+" |                   5 | "+tacticalGrid[4][0]+" | "+tacticalGrid[4][1]+" | "+tacticalGrid[4][2]+" | "+tacticalGrid[4][3]+" | "+tacticalGrid[4][4]+" | "+tacticalGrid[4][5]+" | "+tacticalGrid[4][6]+" | "+tacticalGrid[4][7]+" | "+tacticalGrid[4][8]+" | "+tacticalGrid[4][9]+" |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  6 | "+grid[5][0]+" | "+grid[5][1]+" | "+grid[5][2]+" | "+grid[5][3]+" | "+grid[5][4]+" | "+grid[5][5]+" | "+grid[5][6]+" | "+grid[5][7]+" | "+grid[5][8]+" | "+grid[5][9]+" |                   6 | "+tacticalGrid[5][0]+" | "+tacticalGrid[5][1]+" | "+tacticalGrid[5][2]+" | "+tacticalGrid[5][3]+" | "+tacticalGrid[5][4]+" | "+tacticalGrid[5][5]+" | "+tacticalGrid[5][6]+" | "+tacticalGrid[5][7]+" | "+tacticalGrid[5][8]+" | "+tacticalGrid[5][9]+" |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  7 | "+grid[6][0]+" | "+grid[6][1]+" | "+grid[6][2]+" | "+grid[6][3]+" | "+grid[6][4]+" | "+grid[6][5]+" | "+grid[6][6]+" | "+grid[6][7]+" | "+grid[6][8]+" | "+grid[6][9]+" |                   7 | "+tacticalGrid[6][0]+" | "+tacticalGrid[6][1]+" | "+tacticalGrid[6][2]+" | "+tacticalGrid[6][3]+" | "+tacticalGrid[6][4]+" | "+tacticalGrid[6][5]+" | "+tacticalGrid[6][6]+" | "+tacticalGrid[6][7]+" | "+tacticalGrid[6][8]+" | "+tacticalGrid[6][9]+" |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  8 | "+grid[7][0]+" | "+grid[7][1]+" | "+grid[7][2]+" | "+grid[7][3]+" | "+grid[7][4]+" | "+grid[7][5]+" | "+grid[7][6]+" | "+grid[7][7]+" | "+grid[7][8]+" | "+grid[7][9]+" |                   8 | "+tacticalGrid[7][0]+" | "+tacticalGrid[7][1]+" | "+tacticalGrid[7][2]+" | "+tacticalGrid[7][3]+" | "+tacticalGrid[7][4]+" | "+tacticalGrid[7][5]+" | "+tacticalGrid[7][6]+" | "+tacticalGrid[7][7]+" | "+tacticalGrid[7][8]+" | "+tacticalGrid[7][9]+" |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print("  9 | "+grid[8][0]+" | "+grid[8][1]+" | "+grid[8][2]+" | "+grid[8][3]+" | "+grid[8][4]+" | "+grid[8][5]+" | "+grid[8][6]+" | "+grid[8][7]+" | "+grid[8][8]+" | "+grid[8][9]+" |                   9 | "+tacticalGrid[8][0]+" | "+tacticalGrid[8][1]+" | "+tacticalGrid[8][2]+" | "+tacticalGrid[8][3]+" | "+tacticalGrid[8][4]+" | "+tacticalGrid[8][5]+" | "+tacticalGrid[8][6]+" | "+tacticalGrid[8][7]+" | "+tacticalGrid[8][8]+" | "+tacticalGrid[8][9]+" |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.print(" 10 | "+grid[9][0]+" | "+grid[9][1]+" | "+grid[9][2]+" | "+grid[9][3]+" | "+grid[9][4]+" | "+grid[9][5]+" | "+grid[9][6]+" | "+grid[9][7]+" | "+grid[9][8]+" | "+grid[9][9]+" |                  10 | "+tacticalGrid[9][0]+" | "+tacticalGrid[9][1]+" | "+tacticalGrid[9][2]+" | "+tacticalGrid[9][3]+" | "+tacticalGrid[9][4]+" | "+tacticalGrid[9][5]+" | "+tacticalGrid[9][6]+" | "+tacticalGrid[9][7]+" | "+tacticalGrid[9][8]+" | "+tacticalGrid[9][9]+" |\n");
        System.out.print("    |---|---|---|---|---|---|---|---|---|---|                     |---|---|---|---|---|---|---|---|---|---|\n");
        System.out.println();


    }

    public void clear(String tempGrid[][]) {
        for (int i = 0; i < tempGrid.length; i++) {
            for (int j = 0; j < tempGrid[i].length; j++) {
                tempGrid[i][j] = " ";
            }
        }
    }

    public String[][] getGrid() {
        return grid;
    }

    public String[][] getTacticalGrid() {
        return tacticalGrid;
    }

    public int getCounterWin() {
        return counterWin;
    }

    public void setCounterWin(int counterWin) {
        this.counterWin = counterWin;
    }
}

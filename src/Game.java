import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Board player1 = new Board();
    private Board player2 = new Board();
    private ArrayList<Ships> holder = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    private String letterToNum[] = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    public void run() {
        player1.board();
        player2.board();
        putShips(player1);
        printSpace();
        System.out.println("Now your turn player 2");
        putShips(player2);
        printSpace();
        System.out.println("Game Time");
        while (true) {
            System.out.println("What position to attack? P1");
            player1.tacticalBoard();
            System.out.println("player2 board");
            player2.tacticalBoard();
            String attackPostition = scan.next();
            if (attack(player1, player2, attackPostition)){
                System.out.println("Attack Again");
                attackPostition = scan.next();
                attack(player1, player2, attackPostition);
            }
            printSpace();
            System.out.println("Your turn P2");
            player2.tacticalBoard();
            System.out.println("player1 board");
            player1.tacticalBoard();
            attackPostition = scan.next();
            if (attack(player2, player1, attackPostition)){
                System.out.println("Attack Again");
                attackPostition = scan.next();
                attack(player2, player1, attackPostition);
            }
            printSpace();
            if (player1.getCounterWin() == 14 || player2.getCounterWin() == 14) {
                break;
            }
        }
    }

    public void putShips(Board player) {
        shipList();
        for (int i = 0; i < holder.size(); i++) {
            player.tacticalBoard();
            print();
            System.out.println("What ship?");
            String ship = scan.next();
            System.out.println("Choose position");
            String position = scan.next();
            System.out.println("Choose direction");
            String positionDirection = scan.next();
            separateString(position);
            fillerDirection(positionDirection, ship, searchLetter(separateString(position)), separateInt(position), player);
        }
    }

    public int searchLetter(String letter) {
        for (int i = 0; i < letterToNum.length; i++) {
            if (letterToNum[i].contains(letter)) {
                return i;
            }
        }
        return 0;
    }

    public void shipList() {
        //holder.add(new NoahsArk());
        holder.add(new Nau());
        /*holder.add(new Caravela());
        for (int j = 0; j < 3; j++) {
            holder.add(new Submarine());
        }
        for (int j = 0; j < 2; j++) {
            holder.add(new GunBoat());
        }*/
    }

    public void print() {
        for (int i = 0; i < holder.size(); i++) {
            System.out.println(holder.get(i).getName());
        }
    }

    public String separateString(String position) {
        String letter = position.substring(0, 1);
        return letter;
    }

    public int separateInt(String position) {
        String num = position.substring(1);
        int index = Integer.parseInt(num);
        return index - 1;
    }

    public void fillerDirection(String choice, String ship, int secondIndex, int firstIndex, Board player) {
        int tempOcuppy = 0;
        int safe = 0;
        //ships size
        for (int i = 0; i < this.holder.size(); i++) {
            if (holder.get(i).getName().contains(ship)) {
                tempOcuppy = holder.get(i).getOccupy();
                safe = i;
            }
        }
        if (checkSize(choice, secondIndex, firstIndex, player, tempOcuppy)) {
            //horizontal and vertical
            switch (choice) {
                case "h":
                    if ((secondIndex + tempOcuppy) < player.getGrid().length) {
                        for (int i = 0; i < tempOcuppy; i++) {
                            checkPutShips(firstIndex, secondIndex + i, player);
                        }
                        holder.remove(safe);
                        return;
                    }
                    System.out.println("doesn't fit there mate");
                    break;
                case "v":
                    if ((firstIndex + tempOcuppy) < player.getGrid()[firstIndex].length) {
                        for (int i = 0; i < tempOcuppy; i++) {
                            checkPutShips(firstIndex + i, secondIndex, player);
                        }
                        holder.remove(safe);
                        return;
                    }
                    System.out.println("doesn't fit there mate");
                    return;
                default:
            }
        }
        System.out.println("try again");
    }

    public void checkPutShips(int indexFirst, int indexLast, Board player) {

        if (player.getGrid()[indexFirst][indexLast].equals(" ")) {
            player.getGrid()[indexFirst][indexLast] = "O";
        } else {
            System.out.println("try again");
        }
    }

    public boolean check(int indexFirst, int indexLast, Board playerT, Board player) {
        int counter = 0;
        if (playerT.getGrid()[indexFirst][indexLast].equals("O")) {
            playerT.getGrid()[indexFirst][indexLast] = "X";
            player.getTacticalGrid()[indexFirst][indexLast] = "X";
            counter++;
            player.setCounterWin(counter);
            return true;
        }
        if (playerT.getGrid()[indexFirst][indexLast].equals(" ")) {
            playerT.getGrid()[indexFirst][indexLast] = "-";
            player.getTacticalGrid()[indexFirst][indexLast] = "-";
        }
        return false;
    }

    public boolean checkSize(String choice, int secondIndex, int firstIndex, Board player, int tempOcuppy) {
        int counter = 0;
        for (int i = 0; i < tempOcuppy; i++) {
            if ((firstIndex + i) >= player.getGrid().length || (secondIndex + i) >= player.getGrid().length) {
                return false;
            }

            if (choice.contains("h") && player.getGrid()[firstIndex][secondIndex + i].equals(" ")) {
                counter++;
            }
            if (choice.contains("v") && player.getGrid()[firstIndex + i][secondIndex].equals(" ")) {
                counter++;
            }
        }
        return counter == tempOcuppy;
    }

    public boolean attack(Board player, Board playerT, String position) {
        if (check(separateInt(position), searchLetter(separateString(position)), playerT, player)) {
            return true;
        }
        return false;
    }

    public void printSpace() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }
}


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
        System.out.println("Player 1 name");
        String name = scan.next();
        player1.setName(name);
        System.out.println("Player 2 name");
        name = scan.next();
        player2.setName(name);
        putShips(player1);
        printSpace();
        System.out.println("Now your turn player 2");
        putShips(player2);
        printSpace();
        System.out.println("Game Time");
        while (player1.getCounterWin() != 4 || player2.getCounterWin() != 4) {
            System.out.println("What position to attack? P1");
            player1.tacticalBoard();
            //System.out.println("player2 board");
            //player2.tacticalBoard();
            attackRep(player1, player2, "1");
            if (player1.getCounterWin() == 4 || player2.getCounterWin() == 4){
                break;
            }
            printSpace();
            System.out.println("Your turn P2");
            player2.tacticalBoard();
            //System.out.println("player1 board");
            //player1.tacticalBoard();
            attackRep(player2, player1, "2");
            printSpace();
        }
        System.out.println(checkPlayer(player1, player2).getName() + " Won");
    }

    public boolean attackRep (Board player1, Board player2, String whatPlayer) {
        if (whatPlayer.equals("1")){
            if (player1.getCounterWin() == 4 || player2.getCounterWin() == 4){
                return false;
            }
            System.out.println("Attack");
            String attackPosition = scan.next();
            if (attack(player1, player2, attackPosition)) {
                player1.tacticalBoard();
                //System.out.println("player2 board");
                //player2.tacticalBoard();
                return attackRep(player1, player2, "1");
            }
            player1.tacticalBoard();
            System.out.println("player2 board");
            player2.tacticalBoard();
            return false;
        } else {
            if (player1.getCounterWin() == 4 || player2.getCounterWin() == 4){
                return false;
            }
            System.out.println("Attack");
            String attackPosition = scan.next();
            if (attack(player1, player2, attackPosition)) {
                //player1.tacticalBoard();
                //System.out.println("player2 board");
                player2.tacticalBoard();
                return attackRep(player1, player2, "2");
            }
            player1.tacticalBoard();
            System.out.println("player2 board");
            player2.tacticalBoard();
            return false;
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
        for (Ships ships : holder) {
            System.out.println(ships.getName());
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
        if (playerT.getGrid()[indexFirst][indexLast].equals("O")) {
            playerT.getGrid()[indexFirst][indexLast] = "X";
            player.getTacticalGrid()[indexFirst][indexLast] = "X";
            player.setCounterWin(player.getCounterWin()+1);
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
        return check(separateInt(position), searchLetter(separateString(position)), playerT, player);
    }

    public void printSpace() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }

    public Board checkPlayer(Board player1, Board player2){
        if (player1.getCounterWin() < player2.getCounterWin()){
            return player2;
        }else {
            return player1;
        }
    }
}


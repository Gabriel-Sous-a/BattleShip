import Fleet.Nau;
import Fleet.Ships;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Game {
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    private Board player1 = new Board();
    private Board player2 = new Board();
    private ArrayList<Ships> holder = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    private String letterToNum[] = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    public void gameRunning () {
        System.out.println(PURPLE + "\n" +
                ".______        ___   .___________.___________. __       _______     _______. __    __   __  .______   \n" +
                "|   _  \\      /   \\  |           |           ||  |     |   ____|   /       ||  |  |  | |  | |   _  \\  \n" +
                "|  |_)  |    /  ^  \\ `---|  |----`---|  |----`|  |     |  |__     |   (----`|  |__|  | |  | |  |_)  | \n" +
                "|   _  <    /  /_\\  \\    |  |        |  |     |  |     |   __|     \\   \\    |   __   | |  | |   ___/  \n" +
                "|  |_)  |  /  _____  \\   |  |        |  |     |  `----.|  |____.----)   |   |  |  |  | |  | |  |      \n" +
                "|______/  /__/     \\__\\  |__|        |__|     |_______||_______|_______/    |__|  |__| |__| | _|      \n" + RESET
        );
        runLoop();
    }
    public boolean runLoop () {
        run();
        System.out.println("Do you want to play again?");
        String end = scan.next();
        while(!end.equals("n") && !end.equals("y")){
            System.out.println("wrong input");
            end = scan.next();
        }
        if (end.equals("y")) {
            return runLoop();
        }else {
            return false;
        }
    }

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
        while (player1.getCounterWin() != 17 || player2.getCounterWin() != 17) {
            System.out.println("What position to attack? P1");
            player1.tacticalBoard();
            //System.out.println("player2 board");
            //player2.tacticalBoard();
            attackRep(player1, player2, "1");
            if (player1.getCounterWin() == 17 || player2.getCounterWin() == 17){
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
            if (player1.getCounterWin() == 17 || player2.getCounterWin() == 17){
                return false;
            }
            System.out.println("Attack player 1");
            String attackPosition = scan.next().toUpperCase();
            while (!checkString(attackPosition)){
                System.out.println("Wrong input");
                attackPosition = scan.next().toUpperCase();
            }
            if (attack(player1, player2, attackPosition) && checkString(attackPosition)) {
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
            if (player1.getCounterWin() == 17 || player2.getCounterWin() == 17){
                return false;
            }
            System.out.println("Attack player 2");
            String attackPosition = scan.next().toUpperCase();
            while (!checkString(attackPosition)){
                System.out.println("Wrong input");
                attackPosition = scan.next().toUpperCase();
            }
            if (attack(player1, player2, attackPosition) && checkString(attackPosition)) {
                //player1.tacticalBoard();
                //System.out.println("player2 board");
                player1.tacticalBoard();
                return attackRep(player1, player2, "2");
            }
            player1.tacticalBoard();
            System.out.println("player2 board");
            player2.tacticalBoard();
            return false;
        }
    }

    public boolean attack(Board player, Board playerT, String position) {
        return check(separateInt(position), searchLetter(separateString(position)), playerT, player);
    }

    public void putShips(Board player) {
        shipList();
        System.out.println(holder.size());
        for (int i = 0; i < 6; i++) {
            player.tacticalBoard();
            print();
            System.out.println("What ship?");
            String ship = scan.next().toUpperCase();
            while (!checkArray(ship)){
                System.out.println("Wrong input");
                ship = scan.next().toUpperCase();
            }
            System.out.println("Choose position");
            String position = scan.next().toUpperCase();
            while (!checkString(position)){
                System.out.println("Wrong input");
                position = scan.next().toUpperCase();
            }
            System.out.println("Choose direction");
            String positionDirection = scan.next().toLowerCase();
            while (!checkDirection(positionDirection)){
                System.out.println("Wrong input");
                positionDirection = scan.next().toLowerCase();
            }
            separateString(position);
            fillerDirection(positionDirection, ship, searchLetter(separateString(position)), separateInt(position), player);
        }
    }

    public void shipList() {
        holder.add(new Fleet.NoahsArk());
        holder.add(new Nau());
        holder.add(new Fleet.Caravela());
            holder.add(new Fleet.Submarine());
        for (int j = 0; j < 2; j++) {
            holder.add(new Fleet.GunBoat());
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
            player.getGrid()[indexFirst][indexLast] = YELLOW + "O" + RESET;
        } else {
            System.out.println("try again");
        }
    }

    public boolean check(int indexFirst, int indexLast, Board playerT, Board player) {
        if (playerT.getGrid()[indexFirst][indexLast].equals(YELLOW + "O" + RESET)) {
            playerT.getGrid()[indexFirst][indexLast] = RED + "X" + RESET;
            player.getTacticalGrid()[indexFirst][indexLast] = RED + "X" + RESET;
            player.setCounterWin(player.getCounterWin()+1);
            return true;
        }
        if (playerT.getGrid()[indexFirst][indexLast].equals(" ")) {
            playerT.getGrid()[indexFirst][indexLast] = BLUE + "-" + RESET;
            player.getTacticalGrid()[indexFirst][indexLast] =BLUE + "-" + RESET;
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

    public Board checkPlayer(Board player1, Board player2){
        if (player1.getCounterWin() < player2.getCounterWin()){
            return player2;
        }else {
            return player1;
        }
    }

    public boolean checkString (String position) {
        Pattern pattern = Pattern.compile( "[A-Z][1-9]|[a-z][1-9]");
        Matcher matcher = pattern.matcher(position) ;
        return matcher.find();
    }

    public boolean checkArray (String ship) {
        for (int i = 0; i < holder.size(); i++) {
            if(holder.get(i).getName().contains(ship.toUpperCase())){
                return true;
            }
        }
        return false;
    }

    public boolean checkDirection (String direction){
        return direction.equals("h") || direction.equals("v");
    }

    public void printSpace() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }
}


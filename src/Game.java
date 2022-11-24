import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Board player1 = new Board();
    private Board player2 = new Board();
    private ArrayList<Ships> holder = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    private String letterToNum[] = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

    public void run() {
        while (true) {

        }
    }

    public void putShips() {
        System.out.println("What ship?");
        shipList();
        print();
        System.out.println("Choose first position");
        String position = scan.next();
        System.out.println("Choose last position");
        String positionFinal = scan.next();
        /*separateString(position);
        separateInt(position);
        separateString(positionFinal);
        separateInt(positionFinal);*/

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
        holder.add(new NoahsArk());
        holder.add(new Nau());
        holder.add(new Caravela());
        for (int j = 0; j < 3; j++) {
            holder.add(new Submarine());
        }
        for (int j = 0; j < 2; j++) {
            holder.add(new GunBoat());
        }
    }

    public void print() {
        for (int i = 0; i < holder.size(); i++) {
            System.out.println(holder.get(i).getName());
        }
    }

    public String separateString(String position) {
        String letter = position.substring(0, 1);
        System.out.println(letter);
        System.out.println(searchLetter(letter));
        return letter;
    }

    public int separateInt(String position) {
        String num = position.substring(1);
        System.out.println(num);
        int index = Integer.parseInt(num);
        return index - 1;
    }

    public void filler(int indexFirst, int indexLast, int indexFirst2, int indexLast2, Board player) {
        if (indexFirst == indexFirst2) {

        }
        if (indexLast == indexLast2) {

        }
    }

    public void check(int indexFirst, int indexLast, Board player) {
        if (player.getGrid()[indexFirst][indexLast].equals("O")) {
            player.getGrid()[indexFirst][indexLast] = "X";
        }
        if (!player.getGrid()[indexFirst][indexLast].equals(" ")) {
            System.out.println("try again");
        } else {
            player.getGrid()[indexFirst][indexLast] = "O";
        }
    }
}


package Ideas_Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TicTacToe {
    /**
     * |---|---|---|
     * | 0 | 1 | 2 |
     * |-----------|
     * | 3 | 4 | 5 |
     * |-----------|
     * | 6 | 7 | 8 |
     * |---|---|---|         my understanding of board
     */

    static Scanner in;
    static String[] board;
    static String turn;
    static Random rnd;

    public static void main(String[] args) throws InterruptedException {
        in = new Scanner(System.in);
        rnd = new Random();
        board = new String[9];
        turn = null;
        String winner = null;
        populateEmptyBoard();

        System.out.println("Welcome to 2 Player Board Game!");
        System.out.println("--------------------------------");
        wait(1);
        System.out.println("The game is as follows: ");
        System.out.println("|-------|-------|-------|\n" +
                "| (1,1) | (1,2) | (1,3) |\n" +
                "|-----------------------|\n" +
                "| (2,1) | (2,2) | (2,3) |\n" +
                "|-----------------------|\n" +
                "| (3,1) | (3,2) | (3,3) |\n" +
                "|-------|-------|-------|");
        wait(1);
        System.out.print("Who will be the first player? 1/ for you to play first  /2 for computer  /");
        int player = in.nextInt();
        if (player == 1)
            turn = "P";
        else if (player == 2)
            turn = "C";
        System.out.println("--------------------------------");

        while (winner == null) {
            int cpos;
            if (turn.equals("C")) {
                System.out.println("Computer is playing ...");
                do {
                    cpos = rnd.nextInt(9);
                } while (!board[cpos].equals(" "));

                wait(1);
                System.out.println("Computer has played " + convertSingleToCoordinates(cpos));
                wait(1);
                board[cpos] = turn;
                printBoard();
                winner = checkWinner();
                wait(1);
                turn = "P";
            } else if (turn.equals("P")){
                System.out.println("Your turn!");
                System.out.println("Enter row id: ");
                int row = in.nextInt();
                System.out.println("Enter Column id: ");
                int col = in.nextInt();
                int place = convertCoordinatesToSingle(row,col);
                if (board[place].equals((" "))) {
                    board[place] = turn;
                    System.out.println("After player moves, board is: ");
                    printBoard();
                    winner = checkWinner();
                    turn = "C";
                    wait(1);
                } else {
                    System.out.println("Slot already taken; re-enter slot number:");
                }
            }
        }

        if (winner.equalsIgnoreCase("tie")) {
            System.out.println("Tie!");
        } else {
            if (winner.equals("C"))
                System.out.println("Congratulations! Computer won!");
            else if (winner.equals("P"))
                System.out.println("Congratulations! Player(You) won!");
        }
    }


    static String checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = null;
            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("PPP")) {
                return "P";
            } else if (line.equals("CCC")) {
                return "C";
            }
        }

        List<String> list = Arrays.asList(board);
        for (int a = 0; a < 9; a++) {
            if (list.contains((" "))) {
                break;
            } else if (a == 8) return "tie";
        }
        return null;
    }

    static void printBoard() {
        System.out.println("|-----------|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|-----------|");
    }

    static void populateEmptyBoard() {
        for (int a = 0; a < 9; a++) {
            //board[a] = String.valueOf(a + 1);
            board[a] = " ";
        }
    }

    static String convertSingleToCoordinates(int number){
        if (number == 0)
            return "(1,1)";
        else if (number == 1)
            return "(1,2)";
        else if (number == 2)
            return "(1,3)";
        else if (number == 3)
            return "(2,1)";
        else if (number == 4)
            return "(2,2)";
        else if (number == 5)
            return "(2,3)";
        else if (number == 6)
            return "(3,1)";
        else if (number == 7)
            return "(3,2)";
        else if (number == 8)
            return "(3,3)";
        else return null;
    }

    static int convertCoordinatesToSingle(int row, int col){
        if (row == 1 && col == 1)
            return 0;
        else if (row == 1 && col == 2)
            return 1;
        else if (row == 1 && col == 3)
            return 2;
        else if (row == 2 && col == 1)
            return 3;
        else if (row == 2 && col == 2)
            return 4;
        else if (row == 2 && col == 3)
            return 5;
        else if (row == 3 && col == 1)
            return 6;
        else if (row == 3 && col == 2)
            return 7;
        else if (row == 3 && col == 3)
            return 8;
        else return 0;
    }

    static void wait(int sec) throws InterruptedException {
        TimeUnit.SECONDS.sleep(sec);
    }
}


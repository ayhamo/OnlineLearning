package Ideas_Test;

import java.util.Scanner;

public class DartGame {
    public static void main(String[] args) {

        /*
        You are given a square dart board as shown below. Assume that we are
        throwing darts to hit this board. All darts hit the board, at any random
        coordinate (x,y).

                1
                ^
                |.     B
           C    |   .
                |  A   .
    -1<---------|----------> 1
         D   .  |
          .     |    F
       .     E  |

        Write a complete Java program that simulates this dart game. Read the
        number of darts to be thrown from the user (from the keyboard). Randomly
        generate the target coordinates of the darts on the board (by generating
        a random number that is valid inside the board. Check the boarders of the
        dart area). Display their coordinates and the region of target.
        Lastly, display the statistics of the number and percentage of dart hits
        for each region. If the dart falls on a boundary between the regions,
        consider its region as undecided.
         */

        Scanner input = new Scanner(System.in);
        double x, y;

        int a, b, c, d, e, f,unDecided;
        a = 0; b = 0; c = 0;
        d = 0; e = 0; f = 0;
        unDecided = 0;

        System.out.println("DART GAME!");
        System.out.print("Enter the number of darts to be thrown: ");
        double many = input.nextDouble();

        for (int i = 1; i <= many; i++) {

            x = Math.random();
            y = Math.random();

            x = (int) (x * 10) % 10;
            x = x / 10;

            y = (int) (y * 10) % 10;
            y = y / 10;


            if (Math.random() >= 0.5) {
                x = (-1) * x;
            }
            if (Math.random() >= 0.5) {
                y = (-1) * y;
            }

            System.out.println("\nDart " + i + ":");

            System.out.println("Coordinate: (" + x + "," + y + ")");

            if (x == 0.0 || y == 0.0){
                unDecided++;
                System.out.println("Undecided");
                continue;
            }


            if (x > 0 && y > 0) {
                if (x + y < 1) {
                    System.out.println("Region: A");
                    a++; // a = a + 1
                }else if (x + y > 1) {
                    System.out.println("Region: B");
                    b++;
                }else {
                    System.out.println("Undecided");
                    unDecided++;
                }
            }else if (x < 0 && y > 0) {
                System.out.println("Region: C");
                c++;
            }else if (x < 0 && y < 0) {
                if (x < y) {
                    System.out.println("Region: D");
                    d++;
                }else if (x > y) {
                    System.out.println("Region: E");
                    e++;
                }else {
                    System.out.println("Undecided");
                    unDecided++;
                }
            }else if (x > 0 && y < 0) {
                System.out.println("Region: F");
                f++;
            }
        }

        System.out.println("\nRegion statistics: ");
        System.out.println("A: " + a + " dart " + " (" + (a*100)/many + "%)");
        System.out.println("B: " + b + " dart " + " (" + (b*100)/many + "%)");
        System.out.println("C: " + c + " dart " + " (" + (c*100)/many + "%)");
        System.out.println("D: " + d + " dart " + " (" + (d*100)/many + "%)");
        System.out.println("E: " + e + " dart " + " (" + (e*100)/many + "%)");
        System.out.println("F: " + f + " dart " + " (" + (f*100)/many + "%)");
        System.out.println("Undecided: " + unDecided + " dart " + " (" + (unDecided*100)/many + "%)");
    }
}


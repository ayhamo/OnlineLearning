package Ideas_Test;

import java.util.Scanner;

public class DigitGame {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("*Hello in Digit Library*");
        int number;
        boolean working = true;
        while (working) {
            System.out.println("Digit Library Menu: "
                    + "\n1. Least significant digit" + "\n2. ith digit" + "\n3. Sum of digits with limit"
                    + "\n4. Count digits" + "\n5. Remove digitK" + "\n6. Remove digit with value"
                    + "\n7. Generate random number" + "\n8. Reverse digits" + "\n9. Check palindrome"
                    + "\n10. CharDigitSum" + "\n11. Quit");
            System.out.print("Choose action to perform: ");
            int n = scn.nextInt();
            switch (n) {
                case 1:
                    System.out.print("Enter the number to find least digit: ");
                    number = scn.nextInt();
                    System.out.println("Least digit from the given number is " + digitZero(number));
                    break;
                case 2:
                    System.out.print("Enter the number to find digits: ");
                    number = scn.nextInt();
                    System.out.print("Enter index of the number you want: ");
                    int index = scn.nextInt();
                    System.out.println("The " + index +"th index from the number " + number + " is " + digiti(number,index));
                    break;
                case 3:
                    System.out.print("Enter the number to find digit: ");
                    number = scn.nextInt();
                    System.out.print("Enter a limit: ");
                    int limit = scn.nextInt();
                    System.out.println("The limit digit sum is calculated as: " + digitLimitSum(number,limit));
                    break;
                case 4:
                    System.out.print("Enter the number to find digit: ");
                    number = scn.nextInt();
                    System.out.print("Enter which number to check how many: ");
                    int k = scn.nextInt();
                    System.out.println("there are " + digitCount(number,k)  + " of the number " + k);
                    break;
                case 5:
                case 10:
                    System.out.println(CharDigitSum("hello"));

                case 11:
                    System.out.println("Thank you for using our program, Goodbye");
                    working = false;
                    break;
                default:
                    System.out.println("Please choose a number between 1 and 11");
            }
        }

    }

    public static int digitZero(int p) {
        int o = p % 10;
        return o;
    }

    public static int digiti(int number,int index) {
        int count = 0;
        while (number!= 0){
            if (count == index) {
            return number%10;
            }
            number = number/10;
            count++;
        }
        return 0;
    }

    public static int digitLimitSum(int n, int limit){
        int sum = 0;
        while (n != 0){
            int o = n%10;
            if (o > limit){
                sum = sum + o;
            }
            n = n/10;
        }
        return sum;
    }

    public static int digitCount(int n, int k) {
        int count = 0;
        while (n != 0){
            int o = n%10;
            if (o == k){
                count++;
            }
            n = n/10;
        }
        return count;
    }

    public static int digitRemoveK(int n, int k) {

        return 0;
    }

    public static int digitRemove(int n, int k) {

        return 0;
    }

    public static int CharDigitSum(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            //sum = sum + String.valueOf(str.charAt(i));
        }
        return sum;
    }

}

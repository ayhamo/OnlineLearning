package Code_Acadmy;

import java.util.ArrayList;

class IsPrime {
    public static void main(String[] args) {

        IsPrime pd = new IsPrime();
        int[] numbers = {6, 29, 28, 33, 11, 100, 101, 43, 89};
        System.out.println(pd.onlyPrimes(numbers));
    }

    public static boolean isPrime(int number) {
        if (number == 2) {
            return true;
        } else if (number < 2) {
            return false;
        } else {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static ArrayList<Integer> onlyPrimes(int[] numbers) {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int number : numbers) {

            if (isPrime(number)) {
                primes.add(number);
            }
        }

        return primes;
    }
}

package org.example.generator;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberGenerator {
    public static void main(String[] args) {
        int limit = 100; // Limit to generate prime numbers
        List<Integer> primeNumbers = generatePrimeNumbers(limit);
        System.out.println("Generated Prime Numbers:");
        for (int number : primeNumbers) {
            System.out.println(number);
        }
    }

    public static List<Integer> generatePrimeNumbers(int limit) {
        List<Integer> primeNumbers = new ArrayList<>();

        for (int number = 2; number <= limit; number++) {
            if (isPrimeNumber(number)) {
                primeNumbers.add(number);
            }
        }

        return primeNumbers;
    }

    public static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}

package org.example.generator;
import java.util.ArrayList;
import java.util.List;

public class PerfectNumberGenerator {
    public static void main(String[] args) {
        int limit = 100; // Batas untuk menghasilkan bilangan sempurna
        List<Integer> perfectNumbers = generatePerfectNumbers(limit);
        System.out.println("Generated Perfect Numbers:");
        for (int number : perfectNumbers) {
            System.out.println(number);
        }
    }

    public static List<Integer> generatePerfectNumbers(int limit) {
        List<Integer> perfectNumbers = new ArrayList<>();

        for (int number = 1; number <= limit; number++) {
            if (isPerfectNumber(number)) {
                perfectNumbers.add(number);
            }
        }

        return perfectNumbers;
    }

    public static boolean isPerfectNumber(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }
}

package org.example.generator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OddNumberGenerator {
    public static void main(String[] args) {
        int count = 10; // Number of even numbers to generate
        List<Integer> evenNumbers = generateOddNumbers(count);
        System.out.println("Generated even numbers: " + evenNumbers);
    }

    public static List<Integer> generateOddNumbers(int count) {
        List<Integer> evenNumbers = new ArrayList<>();
        Random random = new Random();

        while (evenNumbers.size() < count) {
            int number = random.nextInt(100) + 1; // Generate a random number between 1 and 100
            if (number % 2 != 0) {
                evenNumbers.add(number);
            }
        }

        return evenNumbers;
    }
}

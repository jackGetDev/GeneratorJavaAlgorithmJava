package org.example.generator;

import java.util.ArrayList;
import java.util.List;

public class FibonacciGenerator {
    public static void main(String[] args) {
        int count = 10; // Number of Fibonacci numbers to generate
        List<Integer> fibonacciSequence = generateFibonacciSequence(count);
        System.out.println("Generated Fibonacci sequence: " + fibonacciSequence);
    }

    public static List<Integer> generateFibonacciSequence(int count) {
        List<Integer> fibonacciSequence = new ArrayList<>();

        if (count >= 1) {
            fibonacciSequence.add(0);
        }
        if (count >= 2) {
            fibonacciSequence.add(1);
        }

        for (int i = 2; i < count; i++) {
            int num = fibonacciSequence.get(i - 1) + fibonacciSequence.get(i - 2);
            fibonacciSequence.add(num);
        }

        return fibonacciSequence;
    }
}

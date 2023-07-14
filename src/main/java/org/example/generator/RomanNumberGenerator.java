package org.example.generator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanNumberGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number (1-3999): ");
        int number = scanner.nextInt();
        scanner.close();

        String romanNumeral = generateRomanNumber(number);
        System.out.println("Generated Roman numeral: " + romanNumeral);
    }

    public static String generateRomanNumber(int number) {
        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("Invalid number. Roman numerals are valid for values between 1 and 3999.");
        }

        Map<Integer, String> romanMap = new LinkedHashMap<>();
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        StringBuilder romanNumber = new StringBuilder();
        for (Map.Entry<Integer, String> entry : romanMap.entrySet()) {
            int value = entry.getKey();
            String symbol = entry.getValue();
            while (number >= value) {
                romanNumber.append(symbol);
                number -= value;
            }
        }

        return romanNumber.toString();
    }
}

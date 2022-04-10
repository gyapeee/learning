package com.gyapeee.learn;

import java.util.Arrays;
import java.util.List;

public class Palindrome {
    public static void main(String[] args) {
        List<String> stringsToTest =
                Arrays.asList("abba", "ab Ba", "madam", "carrac", "xxbyx", "puppy");

        stringsToTest.forEach(s -> System.out.println(isPalindromeSimple(s)));
        System.out.println("----");
        stringsToTest.forEach(s -> System.out.println(isPalindromeRecursive(s)));
    }

    public static boolean isPalindromeSimple(String text) {
        // remove the whitespaces
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        int legth = clean.length();
        int forward = 0;
        int backward = clean.length() - 1;
        while (backward > forward) {
            char forwardChar = clean.charAt(forward++);
            char backwardChar = clean.charAt(backward--);
            if (forwardChar != backwardChar) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        return palindromeRecusion(clean, 0, clean.length() - 1);
    }

    private static boolean palindromeRecusion(String text, int forward, int backward) {
        if (forward == backward) {
            return true;
        }
        if (text.charAt(forward) != text.charAt(backward)) {
            return false;
        }
        if (forward < backward + 1) {
            return palindromeRecusion(text, ++forward, --backward);
        }
        return true;
    }
}

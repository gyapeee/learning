package com.gyapeee.learn;


public class BinaryGapMain {

    public static void main(String[] args) {
        for (int i = 0; i < 550; i++) {
            System.out.println("Max of " + i + ": ");
            System.out.println(solution(i));
        }


    }

    public static int solution(int n) {
        convertIntToBinaryString(n);
        n >>>= Integer.numberOfTrailingZeros(n);
        convertIntToBinaryString(n);
        int steps = 0;
        while ((n & (n + 1)) != 0) {
            n |= n >>> 1;
            steps++;
            System.out.println("Steps " + steps);
            convertIntToBinaryString(n, "n");
            convertIntToBinaryString(n + 1, "n + 1");
            convertIntToBinaryString(n >>> 1, "n>>>1 ");
            convertIntToBinaryString(n, "n|=n1");
            convertIntToBinaryString(n & (n + 1), "n&n+1");
        }
        return steps;
    }

    static String convertIntToBinaryString(int integerToConvert, String msg) {
        // Convert the input to char arrays
        String binaryString = Integer.toBinaryString(integerToConvert);
        System.out.println("\tInput is " + (msg.equals("n") ? "    n" : msg) + " 0b" + binaryString);
        return binaryString;
    }

    static String convertIntToBinaryString(int integerToConvert) {
        // Convert the input to char arrays
        String binaryString = Integer.toBinaryString(integerToConvert);
        System.out.println("\tInput is 0b" + binaryString);
        return binaryString;
    }

}

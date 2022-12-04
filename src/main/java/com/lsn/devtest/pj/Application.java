package com.lsn.devtest.pj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputLines = new ArrayList<>();
        try {
            int expectedNumberOfInputLines = Integer.parseInt(scanner.nextLine());

            while (scanner.hasNextLine())
                inputLines.add(scanner.nextLine());

            if (inputLines.size() != expectedNumberOfInputLines)
                throw new IllegalArgumentException(
                        String.format("Expected %d lines of input, but was %d", expectedNumberOfInputLines, inputLines.size()));
        } catch (RuntimeException e) {
            System.out.println("Wrong input! " + e.getMessage());
        }

        System.out.println(Processor.process(inputLines));
    }
}

package com.lsn.devtest.pj;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine())
            System.out.println(Processor.process(scanner.nextLine()));
    }
}

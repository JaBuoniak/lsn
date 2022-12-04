package com.lsn.devtest.pj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Processor {
    private final static int SUM = 13;

    public static String process(String input) {
        List<Integer> inputIntegers = findAllIntegers(input);
        LinkedList<Integer> lowerNumbers = new LinkedList<>();
        LinkedList<Integer> higherNumbers = new LinkedList<>();
        for (Integer number : inputIntegers) {
            if (number <= SUM / 2)
                lowerNumbers.add(number);
            else
                higherNumbers.add(number);
        }
        lowerNumbers.sort(Integer::compare);

        StringBuilder builder = new StringBuilder();
        for (Integer number : lowerNumbers) {
            Integer complementNumber = SUM - number;
            if (higherNumbers.remove(complementNumber))
                builder.append(String.format("%d %d\n", number, complementNumber));
        }

        return builder.toString().trim();
    }

    private static List<Integer> findAllIntegers(String input) {
        Pattern pattern = Pattern.compile("-?\\d+");
        Matcher matcher = pattern.matcher(input);

        List<Integer> integers = new ArrayList<>();
        while (matcher.find()) {
            integers.add(Integer.parseInt(matcher.group()));
        }
        return integers;
    }
}

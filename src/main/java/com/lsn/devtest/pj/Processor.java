package com.lsn.devtest.pj;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Processor {
    public static String process(String input) {
        List<Integer> inputIntegers = findAllIntegers(input);
        TreeSet<Integer> sortedDistinct = new TreeSet<>(Integer::compare);
        sortedDistinct.addAll(inputIntegers);

        return String.format("%s\ncount: %d\ndistinct: %d\nmin: %d\nmax: %d",
                toString(sortedDistinct),
                inputIntegers.size(),
                sortedDistinct.size(),
                sortedDistinct.first(),
                sortedDistinct.last());
    }

    private static String toString(SortedSet<Integer> integers) {
        return integers.stream().map(String::valueOf).collect(Collectors.joining(" "));
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

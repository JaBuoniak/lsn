package com.lsn.devtest.pj;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.util.List;

public class ProcessorTest {
    @Test
    public void process_providedExample() {
        List<String> input = List.of("2 3", "1 2", "5 6");

        assertThat(Processor.process(input)).isEqualTo(2);
    }

    @Test
    public void process_complicatedExample() {
        List<String> input = List.of("2 3", "1 2", "5 6", "10 12", "10 9", "9 5");

        assertThat(Processor.process(input)).isEqualTo(2);
    }

    @Test
    public void process_moreComplicatedExample() {
        List<String> input = List.of("1 3", "2 4", "3 5", "5 7", "4 6", "6 8", "8 7");

        assertThat(Processor.process(input)).isEqualTo(1);
    }

    @Test
    public void process_biggerInput() {
        List<String> input = List.of("88 34", "34 94", "94 11", "11 62", "62 38", "83 58", "65 93", "93 22", "22 73",
                "73 9", "9 65", "73 2", "2 63", "63 80", "56 23", "23 52", "52 26", "23 74", "74 64", "72 96", "96 49",
                "49 12", "96 1", "1 41", "49 17", "17 99", "83 68", "68 28", "28 66", "68 13", "13 82", "28 53", "53 58");

        assertThat(Processor.process(input)).isEqualTo(5);
    }
}
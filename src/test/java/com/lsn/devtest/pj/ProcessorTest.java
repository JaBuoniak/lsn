package com.lsn.devtest.pj;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProcessorTest {

    @Test
    public void process_providedExample() {
        String input = "1 2 10 7 5 7 3 6 6 13 0";

        String output = Processor.process(input);

        assertThat(output).isEqualTo(
                "0 13\n" +
                "3 10\n" +
                "6 7\n" +
                "6 7");
    }

    @Test
    public void process_withNegatives() {
        String input = "1 -2 10 7 15 7 3 -12 6 25 6 13 0";

        String output = Processor.process(input);

        assertThat(output).isEqualTo(
                "-12 25\n" +
                "-2 15\n" +
                "0 13\n" +
                "3 10\n" +
                "6 7\n" +
                "6 7");
    }

    @Test
    public void process_withInvalidInput_shouldTakeOnlyIntegers() {
        String input = "1.2 10,7 5e7x3 6.06 13 0.000";

        String output = Processor.process(input);

        assertThat(output).isEqualTo(
                "0 13\n" +
                "3 10\n" +
                "6 7\n" +
                "6 7");
    }

    @Test
    public void process_withNoMatches() {
        String input = "1 -2 11 7 14 8 3 -13 4 25 34 13 20";

        String output = Processor.process(input);

        assertThat(output).isEmpty();
    }
}
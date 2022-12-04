package com.lsn.devtest.pj;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ProcessorTest {

    @Test
    public void process_providedExample() {
        String input = "1 10 20 20 2 5";

        String output = Processor.process(input);

        String[] outputLines = output.split("\n");
        assertThat(outputLines.length).isEqualTo(5);
        assertThat(outputLines[0]).isEqualTo("1 2 5 10 20");
        assertThat(outputLines[1]).isEqualTo("count: 6");
        assertThat(outputLines[2]).isEqualTo("distinct: 5");
        assertThat(outputLines[3]).isEqualTo("min: 1");
        assertThat(outputLines[4]).isEqualTo("max: 20");
    }

    @Test
    public void process_withNegatives() {
        String input = "3 12 -20 21 -2 5 -2 2";

        String output = Processor.process(input);

        String[] outputLines = output.split("\n");
        assertThat(outputLines.length).isEqualTo(5);
        assertThat(outputLines[0]).isEqualTo("-20 -2 2 3 5 12 21");
        assertThat(outputLines[1]).isEqualTo("count: 8");
        assertThat(outputLines[2]).isEqualTo("distinct: 7");
        assertThat(outputLines[3]).isEqualTo("min: -20");
        assertThat(outputLines[4]).isEqualTo("max: 21");
    }

    @Test
    public void process_withInvalidInput_shouldTakeOnlyIntegers() {
        String input = "3 1.2 5,02 -2a 5 w2";

        String output = Processor.process(input);

        String[] outputLines = output.split("\n");
        assertThat(outputLines.length).isEqualTo(5);
        assertThat(outputLines[0]).isEqualTo("-2 1 2 3 5");
        assertThat(outputLines[1]).isEqualTo("count: 8");
        assertThat(outputLines[2]).isEqualTo("distinct: 5");
        assertThat(outputLines[3]).isEqualTo("min: -2");
        assertThat(outputLines[4]).isEqualTo("max: 5");
    }
}
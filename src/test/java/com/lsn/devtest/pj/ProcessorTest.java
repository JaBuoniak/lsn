package com.lsn.devtest.pj;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ProcessorTest {

    @Test
    public void process_providedExample() {
        String input = "1 10 20 20 2 5";

        String output = Processor.process(input);

        String[] outputLines = output.split(System.lineSeparator());
        assertThat(outputLines.length).isEqualTo(5);
        assertThat(outputLines[0]).isEqualTo("1 2 5 10 20");
        assertThat(outputLines[1]).isEqualTo("count: 6");
        assertThat(outputLines[2]).isEqualTo("distinct: 5");
        assertThat(outputLines[3]).isEqualTo("min: 1");
        assertThat(outputLines[4]).isEqualTo("max: 20");
    }
}
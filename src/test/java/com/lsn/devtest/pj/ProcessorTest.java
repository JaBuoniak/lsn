package com.lsn.devtest.pj;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProcessorTest {

    @Test
    public void process_providedExample() {
        String input = "1 2 10 7 5 3 6 6 13 0";

        String output = Processor.process(input);

        assertThat(output).isEqualTo(
                "0 13\n" +
                "3 10\n" +
                "6 7\n" +
                "6 7");
    }
}
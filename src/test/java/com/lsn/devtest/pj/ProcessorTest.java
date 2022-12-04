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
}
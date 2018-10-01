package org.sample;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;

import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import java.math.BigDecimal;

@Measurement(timeUnit = TimeUnit.MICROSECONDS)
@Warmup(timeUnit = TimeUnit.MICROSECONDS)
public class MyBenchmark {
    @Benchmark
    @BenchmarkMode(value = { Mode.AverageTime})
    public void createBigDecimalFromFormattedDouble() {
        DecimalFormat df = new DecimalFormat("##0.00");
        new BigDecimal(df.format(47.0));
        new BigDecimal(df.format(324.6));
        new BigDecimal(df.format(4.3));
        new BigDecimal(df.format(123.93));
        new BigDecimal(df.format(997.01));
    }

    @Benchmark
    @BenchmarkMode(value = { Mode.AverageTime})
    public void createBigDecimalFromDoubleWithScale() {
        DecimalFormat df = new DecimalFormat("##0.00");
        new BigDecimal(47.0).setScale(2, BigDecimal.ROUND_HALF_UP);
        new BigDecimal(324.6).setScale(2, BigDecimal.ROUND_HALF_UP);
        new BigDecimal(4.3).setScale(2, BigDecimal.ROUND_HALF_UP);
        new BigDecimal(123.93).setScale(2, BigDecimal.ROUND_HALF_UP);
        new BigDecimal(997.01).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}

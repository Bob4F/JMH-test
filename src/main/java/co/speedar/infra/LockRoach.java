package co.speedar.infra;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.locks.Lock;

/**
 * @author Lucas
 * @ClassName T
 * @Data 2020-01-02
 * @Version 1.0
 */
@Fork(jvmArgsPrepend = {"-XX:-UseBiasedLocking"})
@State(Scope.Benchmark)

public class LockRoach {
    int x;

    @Benchmark
    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public void test() {
        for (int c = 0; c < 100; c++) {
            synchronized (this) {
                x += 0x42;
            }
        }
    }

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(LockRoach.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .threads(1)
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}

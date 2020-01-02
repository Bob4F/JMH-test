package co.speedar.infra;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author Lucas
 * @ClassName HelloWorld
 * @Data 2020-01-02
 * @Version 1.0
 */
public class JMH_HelloWorld {

    @Benchmark
    public void wellHelloThere() {
        // this method was intentionally left blank.
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                // 需要测试的类
                .include(JMH_HelloWorld.class.getSimpleName())
                // 执行几次
                .forks(1)
                .build();
        new Runner(opt).run();
    }

}

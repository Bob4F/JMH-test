package co.speedar.infra.gc;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author Lucas
 * @ClassName AllocArray
 * @Data 2020-01-02
 * @Version 1.0
 */
@Warmup(iterations = 3) // 预热
@Measurement(iterations = 3) // 每次测试 三轮
@Fork(3) // 进行 fork 的次数。这里则 JMH 会 fork 出三个进程来进行测试。
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class AllocArray {

    @Benchmark
    public Object test() {
        final int size = 50_000_000;
        Object[] objects = new Object[size];
        for (int c = 0; c < size; c++) {
            objects[c] = new Object();
        }
        return objects;
    }


    /*

        Benchmark        Mode  Cnt     Score     Error  Units
        AllocArray.test    ss    9  2432.431 ± 454.504  ms/op
        测试结果：
        test方法 方法平均耗时 2432.4ms,误差在正负450ms之间，
            cnt 9说明一共执行了9次方法
            mode ss 代表 @BenchmarkMode(Mode.SingleShotTime)
     */

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().
                include(AllocArray.class.getSimpleName()).
                build();
        new Runner(opt).run();
    }

}

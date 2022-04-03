package com.athaydes.kotlin.part2;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * https://medium.com/@BladeCoder/exploring-kotlins-hidden-costs-part-2-324a4a50b70
 */
@Warmup(iterations = 2, time = 1, timeUnit = MILLISECONDS)
public class KotlinBenchmarkPart2 {

    @State(Scope.Thread)
    public static class TestState {
        int a = 10;
        String who = "John";
        int[] intArray = new int[]{5, 0, 3, -1, -6, 7, -7, 4};
    }

    @Benchmark
    public int javaLocalFunction(TestState state) {
        return JavaExamples.runJavaLocalFunction(state.a);
    }

    @Benchmark
    public int kotlinLocalFunctionCapturingLocalVariable(TestState state) {
        return Kotlin_sourcesKt.runLocalFunctionCapturingLocalVariable(state.a);
    }

    @Benchmark
    public int kotlinLocalFunctionWithoutCapturingLocalVariable(TestState state) {
        return Kotlin_sourcesKt.runLocalFunctionWithoutCapturingLocalVariable(state.a);
    }

    @Benchmark
    public void javaSayHello(TestState state, Blackhole blackHole) {
        JavaExamples.sayHello(state.who, blackHole);
    }

    @Benchmark
    public void kotlinSayHello(TestState state, Blackhole blackHole) {
        Kotlin_sourcesKt.sayHello(state.who, blackHole);
    }

    @Benchmark
    public void javaIntVarargs(Blackhole blackHole, TestState state) {
        JavaExamples.runPrintDouble(blackHole, state.intArray);
    }

    @Benchmark
    public void kotlinIntVarargs(Blackhole blackHole, TestState state) {
        Kotlin_sourcesKt.runPrintDouble(blackHole, state.intArray);
    }
}

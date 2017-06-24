package com.athaydes.kotlin.part2;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

public class KotlinBenchmarkPart2 {

    @State( Scope.Thread )
    public static class TestState {
        int a = 10;
        String who = "John";
        int[] intArray = new int[]{ 5, 0, 3, -1, -6, 7, -7, 4 };
    }

    @GenerateMicroBenchmark
    public int javaLocalFunction( TestState state ) {
        return JavaExamples.runJavaLocalFunction( state.a );
    }

    @GenerateMicroBenchmark
    public int kotlinLocalFunctionCapturingLocalVariable( TestState state ) {
        return Kotlin_sourcesKt.runLocalFunctionCapturingLocalVariable( state.a );
    }

    @GenerateMicroBenchmark
    public int kotlinLocalFunctionWithoutCapturingLocalVariable( TestState state ) {
        return Kotlin_sourcesKt.runLocalFunctionWithoutCapturingLocalVariable( state.a );
    }

    @GenerateMicroBenchmark
    public String javaSayHello( TestState state ) {
        return JavaExamples.sayHello( state.who );
    }

    @GenerateMicroBenchmark
    public String kotlinSayHello( TestState state ) {
        return Kotlin_sourcesKt.sayHello( state.who );
    }

    @GenerateMicroBenchmark
    public int[] javaIntVarargs( TestState state ) {
        return JavaExamples.runPrintDouble( state.intArray );
    }

    @GenerateMicroBenchmark
    public int[] kotlinIntVarargs( TestState state ) {
        return Kotlin_sourcesKt.runPrintDouble( state.intArray );
    }
}

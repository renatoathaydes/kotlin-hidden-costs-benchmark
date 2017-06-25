package com.athaydes.kotlin.part2;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.logic.BlackHole;

/**
 * https://medium.com/@BladeCoder/exploring-kotlins-hidden-costs-part-2-324a4a50b70
 */
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
    public void javaSayHello( TestState state, BlackHole blackHole ) {
        JavaExamples.sayHello( state.who, blackHole );
    }

    @GenerateMicroBenchmark
    public void kotlinSayHello( TestState state, BlackHole blackHole ) {
        Kotlin_sourcesKt.sayHello( state.who, blackHole );
    }

    @GenerateMicroBenchmark
    public void javaIntVarargs( BlackHole blackHole, TestState state ) {
        JavaExamples.runPrintDouble( blackHole, state.intArray );
    }

    @GenerateMicroBenchmark
    public void kotlinIntVarargs( BlackHole blackHole, TestState state ) {
        Kotlin_sourcesKt.runPrintDouble( blackHole, state.intArray );
    }
}

package com.athaydes.kotlin.part1;

import com.athaydes.kotlin.MyClass;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import static com.athaydes.kotlin.Kotlin_sourcesKt.runCompanionObjectCallToPrivateConstructor;
import static com.athaydes.kotlin.Kotlin_sourcesKt.runKotlinBoxedFunction;
import static com.athaydes.kotlin.Kotlin_sourcesKt.runKotlinInlinedFunction;

@State( Scope.Benchmark )
public class KotlinBenchmarkPart1 {

    private Database db = new Database();

    @GenerateMicroBenchmark
    public void empty() {
    }

    @GenerateMicroBenchmark
    public int javaToIntFunction() {
        return JavaExamples.runJavaToIntFunction( db );
    }

    @GenerateMicroBenchmark
    public int kotlinBoxedFunction() {
        return runKotlinBoxedFunction( db );
    }

    @GenerateMicroBenchmark
    public int kotlinInlinedFunction() {
        return runKotlinInlinedFunction( db );
    }

    @GenerateMicroBenchmark
    public MyClass kotlinPrivateConstructorCallFromCompanionObject() {
        return runCompanionObjectCallToPrivateConstructor();
    }

    @GenerateMicroBenchmark
    public MyJavaClass javaPrivateConstructorCallFromStaticMethod() {
        return MyJavaClass.runPrivateConstructorFromStaticMethod();
    }

}

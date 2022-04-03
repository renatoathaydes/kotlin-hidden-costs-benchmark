package com.athaydes.kotlin.part1;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * https://medium.com/@BladeCoder/exploring-kotlins-hidden-costs-part-1-fbb9935d9b62
 */
@State(Scope.Benchmark)
@Warmup(iterations = 2, time = 1, timeUnit = MILLISECONDS)
public class KotlinBenchmarkPart1 {

    private Database db = new Database();

    @Benchmark
    public void empty() {
    }

    @Benchmark
    public int javaLambda() {
        return JavaExamples.runJavaLambda(db);
    }

    @Benchmark
    public int kotlinLambda() {
        return Kotlin_sourcesKt.runKotlinLambda(db);
    }

    @Benchmark
    public int kotlinInlinedFunction() {
        return Kotlin_sourcesKt.runKotlinInlinedFunction(db);
    }

    @Benchmark
    public String kotlinPrivateConstructorCallFromCompanionObject() {
        return Kotlin_sourcesKt.runCompanionObjectCallToPrivateConstructor();
    }

    @Benchmark
    public String javaPrivateConstructorCallFromStaticMethod() {
        return JavaExamples.runPrivateConstructorFromStaticMethod();
    }

}

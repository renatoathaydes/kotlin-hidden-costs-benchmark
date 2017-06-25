package com.athaydes.kotlin.part1;

import com.athaydes.kotlin.Kotlin_sourcesKt;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

/**
 * https://medium.com/@BladeCoder/exploring-kotlins-hidden-costs-part-1-fbb9935d9b62
 */
@State( Scope.Benchmark )
public class KotlinBenchmarkPart1 {

    private Database db = new Database();

    @GenerateMicroBenchmark
    public void empty() {
    }

    @GenerateMicroBenchmark
    public int javaLambda() {
        return JavaExamples.runJavaLambda( db );
    }

    @GenerateMicroBenchmark
    public int kotlinLambda() {
        return Kotlin_sourcesKt.runKotlinLambda( db );
    }

    @GenerateMicroBenchmark
    public int kotlinInlinedFunction() {
        return Kotlin_sourcesKt.runKotlinInlinedFunction( db );
    }

    @GenerateMicroBenchmark
    public String kotlinPrivateConstructorCallFromCompanionObject() {
        return Kotlin_sourcesKt.runCompanionObjectCallToPrivateConstructor();
    }

    @GenerateMicroBenchmark
    public String javaPrivateConstructorCallFromStaticMethod() {
        return JavaExamples.runPrivateConstructorFromStaticMethod();
    }

}

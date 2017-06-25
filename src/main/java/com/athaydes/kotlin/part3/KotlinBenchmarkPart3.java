package com.athaydes.kotlin.part3;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.logic.BlackHole;

import static java.util.Arrays.asList;

/**
 * https://medium.com/@BladeCoder/exploring-kotlins-hidden-costs-part-3-3bf6e0dbf0a4
 */
public class KotlinBenchmarkPart3 {

    @State( Scope.Benchmark )
    public static class TestState {
        int i = 44;
        String name = "John";
        SparseArray<String> sparseArray = new SparseArray<>( asList( "A", "B", "Hi", "ZZ", "FFF" ) );
    }

    @GenerateMicroBenchmark
    public void javaSimplyInitializedProperty( BlackHole blackHole ) {
        JavaExamples.runStringDelegateExample( blackHole );
    }

    @GenerateMicroBenchmark
    public void kotlinDelegateProperty( BlackHole blackHole ) {
        Kotlin_sourcesKt.runStringDelegateExample( blackHole );
    }

    @GenerateMicroBenchmark
    public boolean kotlinLocallyDeclaredRange( TestState testState ) {
        return Kotlin_sourcesKt.runIsInOneToTenWithLocalRange( testState.i );
    }

    @GenerateMicroBenchmark
    public boolean kotlinIndirectRange( TestState testState ) {
        return Kotlin_sourcesKt.runIsInOneToTenWithIndirectRange( testState.i );
    }

    @GenerateMicroBenchmark
    public boolean javaStringComparisons( TestState testState ) {
        return JavaExamples.isBetweenNames( testState.name );
    }

    @GenerateMicroBenchmark
    public boolean kotlinStringRangeInclusionWithLocalRange( TestState testState ) {
        return Kotlin_sourcesKt.isBetweenNamesWithLocalRange( testState.name );
    }

    @GenerateMicroBenchmark
    public boolean kotlinStringRangeInclusionWithConstantRange( TestState testState ) {
        return Kotlin_sourcesKt.isBetweenNamesWithConstantRange( testState.name );
    }

    @GenerateMicroBenchmark
    public void kotlinRangeForEachFunction( BlackHole blackHole ) {
        Kotlin_sourcesKt.rangeForEachMethod( blackHole );
    }

    @GenerateMicroBenchmark
    public void kotlinRangeForEachLoop( BlackHole blackHole ) {
        Kotlin_sourcesKt.rangeForEachLoop( blackHole );
    }

    @GenerateMicroBenchmark
    public void kotlinRangeForEachLoopWithStep1( BlackHole blackHole ) {
        Kotlin_sourcesKt.rangeForEachLoopWithStep1( blackHole );
    }

    @GenerateMicroBenchmark
    public void kotlinCustomIndicesIteration( TestState testState, BlackHole blackHole ) {
        Kotlin_sourcesKt.printValuesUsingIndices( testState.sparseArray, blackHole );
    }

    @GenerateMicroBenchmark
    public void kotlinIterationUsingLastIndexRange( TestState testState, BlackHole blackHole ) {
        Kotlin_sourcesKt.printValuesUsingLastIndexRange( testState.sparseArray, blackHole );
    }


}

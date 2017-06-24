package com.athaydes.kotlin.part2;

import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class JavaExamples {

    public static int runJavaLocalFunction( int a ) {
        return someMath( a );
    }

    public static int someMath( int a ) {
        IntUnaryOperator sumSquare = ( int b ) -> ( a + b ) * ( a + b );

        return sumSquare.applyAsInt( 1 ) + sumSquare.applyAsInt( 2 );
    }

    public static String sayHello( String who ) {
        return "Hello " + who;
    }

    public static int[] runPrintDouble( int[] values ) {
        return printDouble( values );
    }

    public static int[] printDouble( int... values ) {
        return IntStream.of( values ).map( it -> it * 2 ).toArray();
    }
}

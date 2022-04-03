package com.athaydes.kotlin.part2;


import org.openjdk.jmh.infra.Blackhole;

import java.util.function.IntUnaryOperator;

public class JavaExamples {

    public static int runJavaLocalFunction( int a ) {
        return someMath( a );
    }

    public static int someMath( int a ) {
        IntUnaryOperator sumSquare = ( int b ) -> ( a + b ) * ( a + b );

        return sumSquare.applyAsInt( 1 ) + sumSquare.applyAsInt( 2 );
    }

    public static void sayHello( String who, Blackhole blackHole ) {
        blackHole.consume( "Hello " + who );
    }

    public static void runPrintDouble( Blackhole blackHole, int[] values ) {
        printDouble( blackHole, values );
    }

    public static void printDouble( Blackhole blackHole, int... values ) {
        for (int value : values) {
            blackHole.consume( value );
        }
    }

}

package com.athaydes.kotlin.part2;

import org.openjdk.jmh.logic.BlackHole;

import java.util.function.IntUnaryOperator;

public class JavaExamples {

    public static int runJavaLocalFunction( int a ) {
        return someMath( a );
    }

    public static int someMath( int a ) {
        IntUnaryOperator sumSquare = ( int b ) -> ( a + b ) * ( a + b );

        return sumSquare.applyAsInt( 1 ) + sumSquare.applyAsInt( 2 );
    }

    public static void sayHello( String who, BlackHole blackHole ) {
        blackHole.consume( "Hello " + who );
    }

    public static void runPrintDouble( BlackHole blackHole, int[] values ) {
        printDouble( blackHole, values );
    }

    public static void printDouble( BlackHole blackHole, int... values ) {
        for (int value : values) {
            blackHole.consume( value );
        }
    }

}

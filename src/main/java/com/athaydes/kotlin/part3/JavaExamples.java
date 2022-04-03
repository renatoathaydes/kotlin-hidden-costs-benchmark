package com.athaydes.kotlin.part3;


import org.openjdk.jmh.infra.Blackhole;

public class JavaExamples {

    public static void runStringDelegateExample(Blackhole blackHole ) {
        Example2 example2 = new Example2();
        example2.initialize();
        blackHole.consume( example2.p );
        blackHole.consume( example2.p );
    }

    public static boolean isBetweenNames( String name ) {
        return name.compareTo( "Alfred" ) >= 0 &&
                name.compareTo( "Alicia" ) <= 0;
    }


    public static class DelegatePropertyTest {

        public static String stringValue = "hello";

        public static String someOperation() {
            return stringValue;
        }

    }

}

class Example2 {
    public String p;

    public void initialize() {
        p = JavaExamples.DelegatePropertyTest.someOperation();
    }
}


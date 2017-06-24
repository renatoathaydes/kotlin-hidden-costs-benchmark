package com.athaydes.kotlin.part1;

import java.util.function.ToIntFunction;

/**
 * Translation of the Kotlin examples to Java.
 */
public class JavaExamples {

    public static int runJavaToIntFunction( Database db ) {
        int deletedRows = transaction( db, ( database ) ->
                database.delete( "Customer", null, null ) );

        return deletedRows;
    }

    public static int transaction( Database db, ToIntFunction<Database> body ) {
        db.beginTransaction();
        try {
            int result = body.applyAsInt( db );
            db.setTransactionSuccessful();
            return result;
        } finally {
            db.endTransaction();
        }
    }
}

class MyJavaClass {
    private int hello = 0;

    private MyJavaClass() {
    }

    public static MyJavaClass runPrivateConstructorFromStaticMethod() {
        return newInstance();
    }

    public static MyJavaClass newInstance() {
        return new MyJavaClass();
    }
}

class MyJavaClass2 {
    private static final String TAG = "TAG";

    public static String helloWorld() {
        return TAG;
    }
}
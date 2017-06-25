package com.athaydes.kotlin.part1;

import java.util.function.ToIntFunction;

import static com.athaydes.kotlin.part1.MyJavaClass.newInstance;

/**
 * Translation of the Kotlin examples to Java.
 */
public class JavaExamples {

    public static int runJavaLambda( Database db ) {
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

    public static String runPrivateConstructorFromStaticMethod() {
        MyJavaClass myJavaClass = newInstance();
        return myJavaClass.helloWorld();
    }
}

class MyJavaClass {

    private static final String TAG = "TAG";

    private MyJavaClass() {
    }

    public static String helloWorld() {
        return TAG;
    }

    public static MyJavaClass newInstance() {
        return new MyJavaClass();
    }
}

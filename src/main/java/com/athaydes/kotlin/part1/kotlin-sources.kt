package com.athaydes.kotlin

import com.athaydes.kotlin.part1.Database

/**
 * Higher-order functions and Lambda expressions
 */
fun runKotlinBoxedFunction(db: Database): Int {
    val deletedRows = transaction(db) {
        it.delete("Customers", null, null)
    }

    return deletedRows
}

fun runKotlinInlinedFunction(db: Database): Int {
    val deletedRows = inlineTransaction(db) {
        it.delete("Customers", null, null)
    }

    return deletedRows
}

fun transaction(db: Database, body: (Database) -> Int): Int {
    db.beginTransaction()
    try {
        val result = body(db)
        db.setTransactionSuccessful()
        return result
    } finally {
        db.endTransaction()
    }
}

inline fun inlineTransaction(db: Database, body: (Database) -> Int): Int {
    db.beginTransaction()
    try {
        val result = body(db)
        db.setTransactionSuccessful()
        return result
    } finally {
        db.endTransaction()
    }
}

fun runCompanionObjectCallToPrivateConstructor(): MyClass {
    return MyClass.newInstance()
}

class MyClass private constructor() {

    private var hello = 0

    companion object {
        fun newInstance() = MyClass()
    }
}

class MyClass2 {

    companion object {
        private val TAG = "TAG"
    }

    fun helloWorld() = TAG
}
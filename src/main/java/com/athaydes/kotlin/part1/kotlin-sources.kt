package com.athaydes.kotlin

import com.athaydes.kotlin.part1.Database

fun runKotlinLambda(db: Database): Int {
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

fun runCompanionObjectCallToPrivateConstructor(): String {
    val myClass = MyClass.newInstance()
    return myClass.helloWorld()
}

class MyClass private constructor() {

    companion object {
        private val TAG = "TAG"

        fun newInstance() = MyClass()
    }

    fun helloWorld() = TAG
}

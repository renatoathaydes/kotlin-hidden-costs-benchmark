package com.athaydes.kotlin.part2

import org.openjdk.jmh.logic.BlackHole

fun runLocalFunctionCapturingLocalVariable(a: Int): Int {
    return someMath(a)
}

fun runLocalFunctionWithoutCapturingLocalVariable(a: Int): Int {
    return someMath2(a)
}

fun someMath(a: Int): Int {
    fun sumSquare(b: Int) = (a + b) * (a + b)

    return sumSquare(1) + sumSquare(2)
}

fun someMath2(a: Int): Int {
    fun sumSquare(a: Int, b: Int) = (a + b) * (a + b)

    return sumSquare(a, 1) + sumSquare(a, 2)
}

fun sayHello(who: String, blackHole: BlackHole) = blackHole.consume("Hello $who")

fun runPrintDouble(blackHole: BlackHole, values: IntArray) {
    printDouble(blackHole, *values)
}

fun printDouble(blackHole: BlackHole, vararg values: Int) {
    for (value in values) {
        blackHole.consume(value)
    }
}


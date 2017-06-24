package com.athaydes.kotlin.part2

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

fun sayHello(who: String) = "Hello $who"

fun runPrintDouble(values: IntArray): IntArray {
    return printDouble(*values)
}

fun printDouble(vararg values: Int): IntArray =
        values.map { it * 2 }.toIntArray()


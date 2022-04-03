package com.athaydes.kotlin.part3

import com.athaydes.kotlin.part3.JavaExamples.DelegatePropertyTest.someOperation
import org.openjdk.jmh.infra.Blackhole
import kotlin.reflect.KProperty

class StringDelegate {
    private var cache: String? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        var result = cache
        if (result == null) {
            result = someOperation()
            cache = result
        }
        return result!!
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        cache = value
    }
}

class Example {
    var p: String by StringDelegate()
}

fun runStringDelegateExample(blackHole: Blackhole) {
    val example = Example()
    blackHole.consume(example.p)
    blackHole.consume(example.p)
}

fun runIsInOneToTenWithLocalRange(a: Int): Boolean {
    return isInOneToTenWithLocalRange(a)
}

fun isInOneToTenWithLocalRange(i: Int) = i in 1..10

fun isInOneToTenWithLocalRangeAndStep1(i: Int) = i in 1..10 step 1

fun runIsInOneToTenWithIndirectRange(a: Int): Boolean {
    return isInOneToTenWithIndirectRange(a)
}

private val myRange get() = 1..10

fun isInOneToTenWithIndirectRange(i: Int) = i in myRange

fun isBetweenNamesWithLocalRange(name: String): Boolean {
    return name in "Alfred".."Alicia"
}

private val NAMES = "Alfred".."Alicia"

fun isBetweenNamesWithConstantRange(name: String): Boolean {
    return name in NAMES
}

fun rangeForEachMethod(blackHole: Blackhole) {
    (1..10).forEach {
        blackHole.consume(it)
    }
}

fun rangeForEachLoop(blackHole: Blackhole) {
    for (it in 1..10) {
        blackHole.consume(it)
    }
}

fun rangeForEachLoopWithStep1(blackHole: Blackhole) {
    for (it in 1..10 step 1) {
        blackHole.consume(it)
    }
}

/**
 * SparseArray fake implementation.
 */
class SparseArray<out T>(val collection: List<T>) {
    fun size() = collection.size
    fun valueAt(index: Int) = collection[index]
}

inline val SparseArray<*>.indices: IntRange
    get() = 0 until size()

fun printValuesUsingIndices(map: SparseArray<String>, blackHole: Blackhole) {
    for (i in map.indices) {
        blackHole.consume(map.valueAt(i))
    }
}

inline val SparseArray<*>.lastIndex: Int
    get() = size() - 1

fun printValuesUsingLastIndexRange(map: SparseArray<String>, blackHole: Blackhole) {
    for (i in 0..map.lastIndex) {
        blackHole.consume(map.valueAt(i))
    }
}


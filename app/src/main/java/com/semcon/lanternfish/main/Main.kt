package com.semcon.lanternfish.main

fun main(args: Array<String>) {
    var fishList = args.first().split(',').map { it.trim().toInt() }.toMutableList()
    println("Initial state: $fishList")
    startSimulation(fishList, 18)
}

fun startSimulation(fishList: MutableList<Int>, days: Int): MutableList<Int> {
    repeat(days) { days ->
        fishList.mapOnCurrentList { if (it > 0) it - 1 else 6 }
        fishList.count { it == 6 }.let {
            fishList.addAll(MutableList(it) { 8 })
        }
        println("After ${days + 1} days: $fishList")
    }
    return fishList
}

inline fun <T> MutableList<T>.mapOnCurrentList(mutator: (T) -> T) {
    val iterator = this.listIterator()
    while (iterator.hasNext()) {
        val oldValue = iterator.next()
        val newValue = mutator(oldValue)
        if (newValue !== oldValue) {
            iterator.set(newValue)
        }
    }
}
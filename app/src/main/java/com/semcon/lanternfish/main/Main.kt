package com.semcon.lanternfish.main

import com.semcon.lanternfish.model.Lanternfish

fun main(args: Array<String>) {
    var fishList = args.first().split(',')
        .map { Lanternfish(it.trim().toInt()) }
        .toMutableList()
    println("Initial state: $fishList")
    startSimulation(fishList, 80)
    println("After 80 days there are : ${fishList.count()} lanternfish")
}

fun startSimulation(fishList: MutableList<Lanternfish>, days: Int): MutableList<Lanternfish> {
    repeat(days) { days ->
        fishList.mapOnCurrentList { lanternfish -> lanternfish.anotherDayPassed() }
        fishList.count { it.newlyReset }.let {
            fishList.addAll(MutableList(it) { Lanternfish() })
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
package com.semcon.lanternfish.main

fun main(args: Array<String>) {
    var input = args.first().split(',').map { it.toInt() }.toMutableList()
    println("Initial state: $input")
}
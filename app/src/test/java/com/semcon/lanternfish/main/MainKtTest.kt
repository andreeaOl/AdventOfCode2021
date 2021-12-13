package com.semcon.lanternfish.main

import com.semcon.lanternfish.model.Lanternfish
import org.junit.Assert.assertEquals
import org.junit.Test

class MainKtTest {
    private val initialList = mutableListOf(3,4,3,1,2).map { Lanternfish(it) }.toMutableList()
    @Test
    fun given18DaysOfSimulation_startSimulationList_isAsExpected() {
        val expectedList = mutableListOf(6,0,6,4,5,6,0,1,1,2,6,0,1,1,1,2,2,3,3,4,6,7,8,8,8,8)
        assertEquals(expectedList, startSimulation(initialList, 18).map { it.internalTimer })
    }

    @Test
    fun given18DaysOfSimulation_startSimulationList_contains26Fish() {
        val expectedFishAmount = 26
        assertEquals(expectedFishAmount, startSimulation(initialList, 18).count())
    }

    @Test
    fun given80DaysOfSimulation_startSimulationList_contains5934Fish() {
        val expectedFishAmount = 5934
        assertEquals(expectedFishAmount, startSimulation(initialList, 80).count())
    }

}
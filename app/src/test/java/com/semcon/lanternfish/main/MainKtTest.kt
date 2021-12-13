package com.semcon.lanternfish.main

import org.junit.Assert.assertEquals
import org.junit.Test

class MainKtTest {

    @Test
    fun startSimulation() {
        val initialList = mutableListOf(3,4,3,1,2)
        val expectedList = mutableListOf(6,0,6,4,5,6,0,1,1,2,6,0,1,1,1,2,2,3,3,4,6,7,8,8,8,8)
        assertEquals(expectedList, startSimulation(initialList, 18))
    }
}
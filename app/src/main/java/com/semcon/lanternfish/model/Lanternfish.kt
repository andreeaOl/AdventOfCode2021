package com.semcon.lanternfish.model

class Lanternfish(var internalTimer: Int = 8, var newlyReset: Boolean = false) {
    fun anotherDayPassed(): Lanternfish {
        if (internalTimer > 0) decreaseInternalTimer() else reset()
        return this
    }
    private fun reset() {
        this.internalTimer = 6
        newlyReset = true
    }
    private fun decreaseInternalTimer() {
        internalTimer -= 1
        newlyReset = false
    }
    override fun toString(): String = internalTimer.toString()
}
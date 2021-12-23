package com.elo7.commandcenter.vehicle

enum class Orientation(private val id: Int, val description: String) {
    NORTH(1, "North"),
    EAST(2, "East"),
    SOUTH(3, "South"),
    WEST(4, "West");

    fun changeOrientationFromDirectionInput(direction: String) : Orientation {
        return when(direction) {
            "l" -> {
                if(id == 1) WEST
                else fromId(id-1)
            }
            "r" -> {
                if(id == 4) NORTH
                else fromId(id+1)
            }
            else -> this
        }
    }

    private fun fromId(value: Int) = values().first { it.id == value }
}
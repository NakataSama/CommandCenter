package com.elo7.commandcenter.vehicle

class Position(
    private val x: Int,
    private val y: Int
) {
    fun changePositionBasedOnOrientation(orientation: Orientation) : Position {
        var newX = x
        var newY = y
        when(orientation) {
            Orientation.NORTH -> newY++
            Orientation.EAST -> newX++
            Orientation.SOUTH -> newY--
            Orientation.WEST -> newX--
        }
        return Position(newX, newY)
    }

    override fun toString(): String {
        return StringBuilder()
            .append("Position X: $x\n")
            .append("Position Y: $y\n")
            .toString()
    }
}
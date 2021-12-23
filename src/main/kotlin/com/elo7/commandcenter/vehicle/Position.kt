package com.elo7.commandcenter.vehicle

class Position(
    private val x: Int,
    private val y: Int
) {
    fun getX() = x
    fun getY() = y

    fun changePositionBasedOnOrientation(orientation: Orientation): Position {
        return when (orientation) {
            Orientation.NORTH -> Position(x, y + 1)
            Orientation.EAST -> Position(x + 1, y)
            Orientation.SOUTH -> Position(x, y - 1)
            Orientation.WEST -> Position(x - 1, y)
        }
    }

    override fun toString(): String {
        return StringBuilder()
            .append("Position X: $x\n")
            .append("Position Y: $y\n")
            .toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Position

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }
}
package com.elo7.commandcenter.vehicle

import com.elo7.commandcenter.field.Field

abstract class Vehicle(
    private val id: Int,
    private val name: String,
    private val position: Position,
    private val orientation: Orientation,
    private val field: Field
) {
    fun getVehicleId() = id
    fun getCurrentPosition() = position

    abstract fun move(): Vehicle
    abstract fun rotate(direction: String): Vehicle

    protected fun isPositionValid(vehicleId: Int, nextPosition: Position) =
        isPositionWithinFieldLimits(nextPosition) && field.isPositionAvailable(vehicleId, nextPosition)

    private fun isPositionWithinFieldLimits(nextPosition: Position) = when {
        (nextPosition.getX() > field.getLimitX() ||
                nextPosition.getY() > field.getLimitY() ||
                nextPosition.getX() < 0 ||
                nextPosition.getY() < 0) -> false
        else -> true
    }


}
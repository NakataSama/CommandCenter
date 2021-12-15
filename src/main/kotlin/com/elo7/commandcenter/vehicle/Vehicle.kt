package com.elo7.commandcenter.vehicle

import com.elo7.commandcenter.field.Field

abstract class Vehicle(
    private val name: String,
    private val position: Position,
    private val orientation: Orientation,
    private val field: Field
) {
    abstract fun move() : Vehicle
    abstract fun rotate(direction: String) : Vehicle
}
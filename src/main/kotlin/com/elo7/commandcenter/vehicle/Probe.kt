package com.elo7.commandcenter.vehicle

import com.elo7.commandcenter.field.Field

class Probe(
    private val id: Int,
    private val name: String,
    private val position: Position,
    private val orientation: Orientation,
    private val field: Field
) : Vehicle(id, name, position, orientation, field) {

    override fun move(): Probe {
        val nextPosition = position.changePositionBasedOnOrientation(orientation)
        return if (isPositionValid(id, nextPosition)) Probe(
            id,
            name,
            nextPosition,
            orientation,
            field)
        else {
            println("Invalid Movement")
            this
        }
    }

    override fun rotate(direction: String) : Probe {
        return Probe(
            id,
            name,
            position,
            orientation.changeOrientationFromDirectionInput(direction),
            field)
    }

    override fun toString(): String {
        return StringBuilder()
            .append("Name: $name\n")
            .append(position)
            .append("Facing: ${orientation.description}\n")
            .toString()
    }
}
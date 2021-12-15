package com.elo7.commandcenter.vehicle

import com.elo7.commandcenter.field.Field

class Probe(
    private val name: String,
    private val position: Position,
    private val orientation: Orientation,
    private val field: Field
) : Vehicle(
    name,
    position,
    orientation,
    field
) {

    override fun move(): Probe {
        return Probe(
            name,
            position.changePositionBasedOnOrientation(orientation),
            orientation,
            field)
    }

    override fun rotate(direction: String) : Probe {
        return Probe(
            name,
            position,
            orientation.changeOrientationFromDirectionInput(direction),
            field)
    }

    override fun toString(): String {
        return StringBuilder()
            .append("Name: $name\n")
            .append(position)
            .append("Facing: ${orientation.description}")
            .toString()
    }
}
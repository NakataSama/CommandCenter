package com.elo7.commandcenter.field

import com.elo7.commandcenter.vehicle.Vehicle

class Field(
    private val name: String,
    private val limitX: Int,
    private val limitY: Int,
    private val vehicles: List<Vehicle>
) {

}
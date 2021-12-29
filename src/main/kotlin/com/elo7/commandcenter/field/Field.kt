package com.elo7.commandcenter.field

import com.elo7.commandcenter.vehicle.Position
import com.elo7.commandcenter.vehicle.Vehicle

class Field(
    private val id: Int,
    private val name: String,
    private val limitX: Int,
    private val limitY: Int,
    private val vehicles: MutableList<Vehicle>
) {
    fun getLimitX() = limitX
    fun getLimitY() = limitY
    fun getVehicles() = vehicles

    fun saveVehicle(request: Vehicle) : Field {
        return when (getVehicleById(request.getVehicleId()) != null) {
            true -> {
                if (isPositionAvailable(request.getVehicleId(), request.getCurrentPosition()))
                    vehicles[vehicles.indexOf(getVehicleById(request.getVehicleId()))] = request
                Field(id, name, limitX, limitY, vehicles)
            }
            else -> {
                vehicles.add(request)
                Field(id, name, limitX, limitY, vehicles)
            }
        }
    }

    private fun getVehicleById(id: Int) : Vehicle? {
        return vehicles.find { it.getVehicleId() == id }
    }

    fun isPositionAvailable(vehicleId: Int, position: Position): Boolean {
        val occupiedPositions = vehicles.associate { it.getVehicleId() to it.getCurrentPosition() }
        return when {
            occupiedPositions.containsValue(position) ->
                vehicleId == occupiedPositions.filterValues { it == position }.keys.first()
            else -> true
        }
    }

    override fun toString(): String {
        return super.toString()
    }
}
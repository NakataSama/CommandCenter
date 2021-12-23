import com.elo7.commandcenter.field.Field
import com.elo7.commandcenter.vehicle.Orientation
import com.elo7.commandcenter.vehicle.Position
import com.elo7.commandcenter.vehicle.Probe

fun main() {
    val field = Field(1, "Hello",2,2, mutableListOf())
    var probe = Probe(1, "HelloWorld", Position(0,0), Orientation.NORTH, field)
    var probe2 = Probe(2, "HelloWorld", Position(0,0), Orientation.NORTH, field)
    field.saveVehicle(probe.rotate("r").move())
    field.saveVehicle(probe2.rotate("r").move())
    println(field.getVehicles())
}
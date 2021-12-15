import com.elo7.commandcenter.field.Field
import com.elo7.commandcenter.vehicle.Orientation
import com.elo7.commandcenter.vehicle.Position
import com.elo7.commandcenter.vehicle.Probe

fun main() {
    val probe = Probe("HelloWorld", Position(0,0), Orientation.NORTH, Field("Hello",1,1, listOf()))
    val probe2 = probe
        .rotate("l")
        .rotate("l")

    println(probe)
    println(probe2)
}
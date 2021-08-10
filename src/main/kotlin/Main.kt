import robot.*

fun main() {
    val logger = Logger()
    val battery = Battery(logger)
    val vision = Vision(logger, battery)
    val deathRay = DeathRay(logger, battery)
    val killerRobot = KillerRobot(logger, battery, vision, deathRay)
    killerRobot.start()
}
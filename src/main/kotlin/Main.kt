import dagger.DaggerApplicationComponent

fun main() {
    val applicationComponent = DaggerApplicationComponent.builder().build()
    val killerRobot = applicationComponent.killerRobot()
    killerRobot.start()
}
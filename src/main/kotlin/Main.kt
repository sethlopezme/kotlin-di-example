import di.ApplicationComponent

fun main() {
    val applicationComponent = ApplicationComponent()
    val killerRobot = applicationComponent.createKillerRobot()
    killerRobot.start()
}
package di

import robot.KillerRobot

class ApplicationComponent {
    private val robotModule = RobotModule()

    fun createKillerRobot(): KillerRobot {
        val logger = robotModule.provideLogger()
        val battery = robotModule.provideBattery(logger)
        val vision = robotModule.provideVision(logger, battery)
        val deathRay = robotModule.provideDeathRay(logger, battery)
        return robotModule.provideKillerRobot(logger, battery, vision, deathRay)
    }
}
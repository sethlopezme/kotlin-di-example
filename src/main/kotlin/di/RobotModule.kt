package di

import robot.Battery
import robot.DeathRay
import robot.KillerRobot
import robot.Logger
import robot.Vision

class RobotModule {
    private var loggerInstance: Logger? = null
    private var batteryInstance: Battery? = null
    private var visionInstance: Vision? = null
    private var deathRayInstance: DeathRay? = null

    fun provideLogger(): Logger {
        return if (loggerInstance != null) {
            loggerInstance!!
        } else {
            val logger = Logger()
            loggerInstance = logger
            logger
        }
    }

    fun provideBattery(logger: Logger): Battery {
        return if (batteryInstance != null) {
            batteryInstance!!
        } else {
            val battery = Battery(logger)
            batteryInstance = battery
            return battery
        }
    }

    fun provideVision(logger: Logger, battery: Battery): Vision {
        return if (visionInstance != null) {
            visionInstance!!
        } else {
            val vision = Vision(logger, battery)
            visionInstance = vision
            return vision
        }
    }

    fun provideDeathRay(logger: Logger, battery: Battery): DeathRay {
        return if (deathRayInstance != null) {
            deathRayInstance!!
        } else {
            val deathRay = DeathRay(logger, battery)
            deathRayInstance = deathRay
            return deathRay
        }
    }

    fun provideKillerRobot(
        logger: Logger,
        battery: Battery,
        vision: Vision,
        deathRay: DeathRay,
    ): KillerRobot = KillerRobot(logger, battery, vision, deathRay)
}
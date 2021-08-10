package dagger

import javax.inject.Singleton
import robot.KillerRobot

@Singleton
@Component
interface ApplicationComponent {
    fun killerRobot(): KillerRobot
}
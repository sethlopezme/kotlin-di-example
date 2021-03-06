package robot

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Vision @Inject constructor(private val logger: Logger, private val battery: Battery) {

    fun look(): DetectedObject? {
        if (!battery.drawPower()) {
            logger.log("No power. Unable to look.")
            return null
        }

        logger.log("Looking...")
        val num = getRandomNumber()
        val values = DetectedObject.values()
        val result = if (num < values.size) values[num] else null
        logger.log("Object detected: $result")

        return result
    }

    fun getRandomNumber(): Int = (0..9).random()
}
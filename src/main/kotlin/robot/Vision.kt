package robot

class Vision(private val logger: Logger, private val battery: Battery) {

    fun look(): DetectedObject? {
        if (!battery.drawPower()) {
            logger.log("No power. Unable to look.")
            return null
        }

        logger.log("Looking...")
        val num = getRandomNumber()
        val values = DetectedObject.values()
        val result = if (num < values.size) values[num] else null

        if (result != null) {
            logger.log("Object detected: $result")
        } else {
            logger.log("No objects detected.")
        }

        return result
    }

    fun getRandomNumber(): Int = (0..9).random()
}
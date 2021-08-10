package robot

class DeathRay {

    private val logger = Logger()

    fun fire(): Boolean {
        if (!Battery.drawPower()) {
            logger.log("No power. Unable to fire.")
            return false
        }

        logger.log("Firing death ray.")
        logger.log("*pew* *pew* *pew*")
        return true
    }
}
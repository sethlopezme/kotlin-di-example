package robot

class DeathRay(private val logger: Logger, private val battery: Battery) {

    fun fire(): Boolean {
        if (!battery.drawPower()) {
            logger.log("No power. Unable to fire.")
            return false
        }

        logger.log("Firing death ray.")
        logger.log("*pew* *pew* *pew*")
        return true
    }
}
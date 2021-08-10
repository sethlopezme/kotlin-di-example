package robot

import java.lang.Thread.sleep
import javax.inject.Inject

class KillerRobot @Inject constructor(
    private val logger: Logger,
    private val battery: Battery,
    private val vision: Vision,
    private val deathRay: DeathRay,
) {

    fun start() {
        logger.log("Killer Robot 9000 starting up.\n")

        while (battery.capacity > 0) {
            val obj = vision.look()
            sleep(500)
            when (obj) {
                DetectedObject.ANIMAL -> logger.log("Just the local fauna.")
                DetectedObject.AUTOMOBILE -> logger.log("Just a primitive machine.")
                DetectedObject.HOUSE -> logger.log("Just a shelter for meatbags.")
                DetectedObject.MEATBAG -> {
                    logger.log("*MEATBAG DETECTED!*")
                    val fired = deathRay.fire()
                    if (fired) {
                        logger.log("Take that, meatbag!")
                    } else {
                        logger.log("You'll get away this time, meatbag, but your days are numbered.")
                    }
                }
                DetectedObject.TREE -> logger.log("Just the local flora.")
                null -> logger.log("There's nothing within my field of view.")
            }
            sleep(2000)
            // separate the logs in each loop
            logger.log()
        }

        logger.log("No power remaining. Shutting down.")
    }
}
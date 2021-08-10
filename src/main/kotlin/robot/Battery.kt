package robot

object Battery {

    private val maxCapacity: Int = 10
    var capacity: Int = maxCapacity
        private set
    val percentRemaining: Float
        get() = (capacity / maxCapacity.toFloat()) * 100

    private val logger = Logger()

    fun drawPower(): Boolean {
        val formattedPercentRemaining = "%.2f".format(percentRemaining)
        logger.log("robot.Battery capacity: $capacity/$maxCapacity (${formattedPercentRemaining}%). Drawing power.")
        return if (capacity > 0) {
            capacity--
            true
        } else false
    }
}
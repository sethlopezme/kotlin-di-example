package robot

class Battery(private val logger: Logger) {

    private val maxCapacity: Int = 10
    var capacity: Int = maxCapacity
        private set
    val percentRemaining: Float
        get() = (capacity / maxCapacity.toFloat()) * 100

    fun drawPower(): Boolean {
        val formattedPercentRemaining = "%.2f".format(percentRemaining)
        logger.log("Battery capacity: $capacity/$maxCapacity (${formattedPercentRemaining}%). Drawing power.")
        return if (capacity > 0) {
            capacity--
            true
        } else false
    }
}
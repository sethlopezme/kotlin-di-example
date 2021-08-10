package robot

import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BatteryTest {

    lateinit var battery: Battery

    @Before
    fun setup() {
        val logger = mockk<Logger>(relaxed = true)
        battery = Battery(logger)
    }

    @Test
    fun `drawPower() reduces capacity`() {
        battery.drawPower()
        val expected = 9
        val result = battery.capacity
        assertEquals(expected, result)
    }

    @Test
    fun `percentRemaining is calculated correctly`() {
        val expected1 = 100f
        val result1 = battery.percentRemaining
        assertEquals(expected1, result1)

        battery.drawPower()
        val expected2 = 90f
        val result2 = battery.percentRemaining
        assertEquals(expected2, result2)

        battery.drawPower()
        val expected3 = 80f
        val result3 = battery.percentRemaining
        assertEquals(expected3, result3)
    }
}
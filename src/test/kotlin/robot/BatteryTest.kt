package robot

import org.junit.Assert.assertEquals
import org.junit.Test

// FIXME: Calling battery methods produces side-effects, such as logging
class BatteryTest {

    @Test
    fun `drawPower() reduces capacity`() {
        Battery.drawPower()
        val expected = 9
        val result = Battery.capacity
        assertEquals(expected, result)
    }

    @Test
    fun `percentRemaining is calculated correctly`() {
        val expected1 = 100f
        val result1 = Battery.percentRemaining
        assertEquals(expected1, result1)

        Battery.drawPower()
        val expected2 = 90f
        val result2 = Battery.percentRemaining
        assertEquals(expected2, result2)

        Battery.drawPower()
        val expected3 = 80f
        val result3 = Battery.percentRemaining
        assertEquals(expected3, result3)
    }
}
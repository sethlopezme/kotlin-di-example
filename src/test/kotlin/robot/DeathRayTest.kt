package robot

import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class DeathRayTest {

    lateinit var battery: Battery
    lateinit var deathRay: DeathRay

    @Before
    fun setup() {
        val logger = mockk<Logger>(relaxed = true)
        battery = mockk(relaxed = true)
        deathRay = DeathRay(logger, battery)
    }

    @After
    fun cleanup() {
        clearAllMocks()
    }

    @Test
    fun `fire() returns true when battery capacity is greater than zero`() {
        every { battery.drawPower() } returns true

        val result = deathRay.fire()
        assertTrue(result)
    }

    @Test
    fun `fire() returns false when battery capacity is zero`() {
        every { battery.drawPower() } returns false

        val result = deathRay.fire()
        assertFalse(result)
    }
}
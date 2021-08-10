package robot

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

// FIXME: Calling death ray methods produces side-effects, such as logging and battery drain
class DeathRayTest {

    lateinit var deathRay: DeathRay

    @Before
    fun setup() {
        deathRay = DeathRay()
    }

    // FIXME: Not a good test because we aren't really sure what the capacity of the battery is, we just assume
    @Test
    fun `fire() returns true when battery capacity is greater than zero`() {
        val result = deathRay.fire()
        assertTrue(result)
    }

    // FIXME: Not a good test because we have to manually drain the battery
    @Test
    fun `fire() returns false when battery capacity is zero`() {
        for (i in 0..9) {
            Battery.drawPower()
        }

        val result = deathRay.fire()
        assertFalse(result)
    }
}
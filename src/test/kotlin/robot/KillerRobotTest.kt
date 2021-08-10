package robot

import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Before
import org.junit.Test

class KillerRobotTest {

    lateinit var logger: Logger
    lateinit var battery: Battery
    lateinit var vision: Vision
    lateinit var deathRay: DeathRay
    lateinit var killerRobot: KillerRobot

    @Before
    fun setup() {
        logger = mockk(relaxed = true)
        battery = mockk(relaxed = true)
        vision = mockk(relaxed = true)
        deathRay = mockk(relaxed = true)
        killerRobot = KillerRobot(logger, battery, vision, deathRay)
    }

    @After
    fun cleanup() {
        clearAllMocks()
    }

    @Test
    fun `Performs functions when battery capacity is sufficient`() {
        every { battery.capacity } returnsMany listOf(1, 0)

        killerRobot.start()
        verify(atLeast = 1) { vision.look() }
    }

    @Test
    fun `Performs no functions when battery capacity is zero`() {
        every { battery.capacity } returns 0

        killerRobot.start()
        verify(exactly = 0) { vision.look() }
    }

    @Test
    fun `Uses death ray on MEATBAGs`() {
        every { battery.capacity } returnsMany listOf(1, 0)
        every { vision.look() } returns DetectedObject.MEATBAG

        killerRobot.start()
        verify(atLeast = 1) { deathRay.fire() }
    }
}
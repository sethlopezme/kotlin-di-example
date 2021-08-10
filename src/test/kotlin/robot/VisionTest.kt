package robot

import io.mockk.every
import io.mockk.spyk
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

// FIXME: Calling vision methods produces side-effects, such as logging and battery drain
class VisionTest {

    lateinit var visionSpy: Vision

    @Before
    fun setup() {
        val vision = Vision()
        visionSpy = spyk(vision)
    }

    @Test
    fun `look() returns null when battery capacity is zero`() {
        for (i in 0..9) {
            Battery.drawPower()
        }

        val result = visionSpy.look()
        assertNull(result)
    }

    @Test
    fun `look() returns ANIMAL when number is 0`() {
        every { visionSpy.getRandomNumber() } returns 0

        val expected = DetectedObject.ANIMAL
        val result = visionSpy.look()
        assertEquals(expected, result)
    }

    @Test
    fun `look() returns AUTOMOBILE when number is 1`() {
        every { visionSpy.getRandomNumber() } returns 1

        val expected = DetectedObject.AUTOMOBILE
        val result = visionSpy.look()
        assertEquals(expected, result)
    }

    @Test
    fun `look() returns HOUSE when number is 2`() {
        every { visionSpy.getRandomNumber() } returns 2

        val expected = DetectedObject.HOUSE
        val result = visionSpy.look()
        assertEquals(expected, result)
    }

    @Test
    fun `look() returns MEATBAG when number is 3`() {
        every { visionSpy.getRandomNumber() } returns 3

        val expected = DetectedObject.MEATBAG
        val result = visionSpy.look()
        assertEquals(expected, result)
    }

    @Test
    fun `look() returns TREE when number is 4`() {
        every { visionSpy.getRandomNumber() } returns 4

        val expected = DetectedObject.TREE
        val result = visionSpy.look()
        assertEquals(expected, result)
    }

    @Test
    fun `look() returns null when number is greater than 4`() {
        every { visionSpy.getRandomNumber() } returns 5

        val result = visionSpy.look()
        assertNull(result)
    }
}
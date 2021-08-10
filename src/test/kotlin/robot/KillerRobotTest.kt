package robot

import org.junit.Before
import org.junit.Ignore
import org.junit.Test

class KillerRobotTest {

    lateinit var killerRobot: KillerRobot

    @Before
    fun setup() {
        killerRobot = KillerRobot()
    }

    // FIXME: Not only do we assume a specific battery capacity here, but we also have no way to verify that any
    //        functions have been performed.
    @Ignore
    @Test
    fun `Performs functions when battery capacity is sufficient`() {

    }

    // FIXME: While we can use a for loop to drain the battery, we have no way to verify that functions have not
    //        been performed.
    @Ignore
    @Test
    fun `Performs no functions when battery capacity is zero`() {

    }

    // FIXME: We have no way to ensure that robot.Vision will return a MEATBAG and no way to verify that the death ray
    //        was used.
    @Ignore
    @Test
    fun `Uses death ray on MEATBAGs`() {

    }
}
import org.junit.Test

class RandomNumberGeneratorTest {

    @Test
    fun `getRandom returns value between 0 and 100`() {
        val random = funcTestGetRandom(100)
        assert(random in 0.. 100)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `getRandom throws an exception when negative value is passed`() {
        funcTestGetRandom(-1)
    }
}
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TennisTest {
    private lateinit var tennis: Tennis

    @BeforeEach
    fun setup() {
        tennis = Tennis("First Player", "Second Player")
    }

    @Test
    fun loveAllTest() {
        shouldBeScore("Love all")
    }

    @Test
    fun fifteenLoveTest() {
        givenFirstPlayerScore(1)
        shouldBeScore("Fifteen Love")
    }

    @Test
    fun thirtyLoveTest() {
        givenFirstPlayerScore(2)
        shouldBeScore("Thirty Love")
    }

    @Test
    fun fortyLoveTest() {
        givenFirstPlayerScore(3)
        shouldBeScore("Forty Love")
    }

    @Test
    fun loveFifteenTest() {
        givenSecondPlayerScore(1)
        shouldBeScore("Love Fifteen")
    }

    @Test
    fun loveThirtyTest() {
        givenSecondPlayerScore(2)
        shouldBeScore("Love Thirty")
    }

    @Test
    fun loveFortyTest() {
        givenSecondPlayerScore(3)
        shouldBeScore("Love Forty")
    }

    @Test
    fun fifteenAllTest() {
        givenDeuceScore(1)
        shouldBeScore("Fifteen All")
    }

    @Test
    fun thirtyAllTest() {
        givenDeuceScore(2)
        shouldBeScore("Thirty All")
    }

    @Test
    fun deuceTest() {
        givenDeuce()
        shouldBeScore("Deuce")
    }

    @Test
    fun firstPlayerAdvTest() {
        givenDeuce()
        givenFirstPlayerScore(1)
        shouldBeScore("First Player Adv")
    }

    @Test
    fun secondPlayerAdvTest() {
        givenDeuce()
        givenSecondPlayerScore(1)
        shouldBeScore("Second Player Adv")
    }

    @Test
    fun firstPlayerWinTest() {
        givenDeuce()
        givenFirstPlayerScore(2)
        shouldBeScore("First Player Win")
    }

    @Test
    fun secondPlayerWinTest() {
        givenDeuce()
        givenSecondPlayerScore(2)
        shouldBeScore("Second Player Win")
    }

    private fun givenDeuce() {
        givenFirstPlayerScore(3)
        givenSecondPlayerScore(3)
    }

    private fun givenFirstPlayerScore(times: Int) {
        for (index in 0 until times) {
            tennis.firstPlayerScore()
        }
    }

    private fun givenSecondPlayerScore(times: Int) {
        for (index in 0 until times) {
            tennis.secondPlayerScore()
        }
    }

    private fun givenDeuceScore(times: Int) {
        givenFirstPlayerScore(times)
        givenSecondPlayerScore(times)
    }

    private fun shouldBeScore(excepted: String) {
        assertEquals(excepted, tennis.score())
    }

}
import kotlin.math.abs

class Tennis(private val firstPlayerName: String, private val secondPlayerName: String) {
    private var firstPlayerScoreTimes: Int = 0
    private var secondPlayerScoreTimes: Int = 0
    private val scoreMap = HashMap<Int, String>().apply {
        put(0, "Love")
        put(1, "Fifteen")
        put(2, "Thirty")
        put(3, "Forty")
    }

    fun score(): String {
        if (isSameScore()) {
            return if (isDeuce()) {
                getDeuce()
            } else {
                "${scoreMap[firstPlayerScoreTimes]} All"
            }
        }

        if (firstPlayerScoreTimes > 3 || secondPlayerScoreTimes > 3) {
            if (isAdv()) {
                return "${getPlayerName()} Adv"
            }

            return "${getPlayerName()} Win"
        }
        return "${scoreMap[firstPlayerScoreTimes]} ${scoreMap[secondPlayerScoreTimes]}"
    }

    private fun isSameScore(): Boolean {
        return firstPlayerScoreTimes == secondPlayerScoreTimes
    }

    private fun isDeuce(): Boolean {
        return firstPlayerScoreTimes >= 3
    }

    private fun getDeuce(): String {
        return "Deuce"
    }

    private fun getPlayerName(): String {
        return if (firstPlayerScoreTimes > secondPlayerScoreTimes) firstPlayerName else secondPlayerName
    }

    private fun isAdv(): Boolean {
        return abs(firstPlayerScoreTimes - secondPlayerScoreTimes) == 1
    }

    fun firstPlayerScore() {
        firstPlayerScoreTimes++
    }

    fun secondPlayerScore() {
        secondPlayerScoreTimes++
    }
}
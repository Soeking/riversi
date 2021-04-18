class Game(private var gameSize: Int) {
    //true => black, false => white
    private val stones = Array<Array<Boolean?>>(gameSize) { Array(gameSize) { null } }
    private var turn = true

    init {
        if (gameSize == 8) {
            stones[3][3] = false
            stones[3][4] = true
            stones[4][3] = true
            stones[4][4] = false
        } else {
            stones[2][2] = false
            stones[2][3] = true
            stones[3][2] = true
            stones[3][3] = false
        }
    }

    fun getStones(): List<Triple<Double, Double, Boolean>> {
        return mutableListOf<Triple<Double, Double, Boolean>>().apply {
            for (x in 0 until gameSize) {
                for (y in 0 until gameSize) {
                    stones[x][y]?.let {
                        add(Triple(x.toDouble(), y.toDouble(), it))
                    }
                }
            }
        }
    }

    fun clickBoard(x: Int, y: Int) {
        if (check(x, y)) {
            stones[x][y] = turn
            turn = !turn
        }
    }

    private fun check(x: Int, y: Int): Boolean {
        if (stones[x][y] != null) return false
        return true
    }
}
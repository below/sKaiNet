package org.skainet.simple

class MatrixFactory {
    companion object {
        private val random = kotlin.random.Random(42)
        fun zeros(rows: Int, cols: Int): Matrix = init(rows, cols) { _, _ ->
            0.toDouble()
        }

        fun ones(rows: Int, cols: Int): Matrix = init(rows, cols) { _, _ ->
            1.toDouble()
        }

        fun random(rows: Int, cols: Int): Matrix = init(rows, cols) { _, _ ->
            random.nextDouble()
        }

        fun range(from: Double, to: Double, step: Double): Vector =
            MutableList(((to - from) / step).toInt()) { col ->
                from * (col * step)
            }.toList()

        fun init(rows: Int, cols: Int, init: (row: Int, col: Int) -> Double): Matrix {
            return MutableList(rows) { row ->
                MutableList(cols) { col ->
                    init(row, col)
                }.toList()
            }.toList()
        }
    }
}

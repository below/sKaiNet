package org.skainet.simple

typealias Matrix = List<List<Double>>
typealias Vector = List<Double>
typealias IntVector = List<Int>
typealias FloatVector = List<Float>

fun Vector.toMatrix(): Matrix = MutableList(size) { element ->
    listOf(this[element])
}.toList()

@JvmName("toDoubleMatrix")
fun Vector.toMatrix(columns: Int): Matrix = (0..this.size / columns).map { row ->
    (0..columns).map { col ->
        this[row * columns + col]
    }
}

@JvmName("toFloatMatrix")
fun FloatVector.toMatrix(columns: Int): Matrix = (0..this.size / columns).map { row ->
    (0..columns).map { col ->
        this[row * columns + col].toDouble()
    }
}

@JvmName("toIntMatrix")
fun IntVector.toMatrix(columns: Int): Matrix = (0 until (this.size / columns)).map { row ->
    (0 until columns).map { col ->
        this[row * columns + col].toDouble()
    }
}

fun Matrix.shape(): List<Int> = listOf(this.size, this[0].size)

fun Matrix.print() {

    val multirow = this.count() > 1
    var parentheisChar: String = ""

    this.forEachIndexed { i, row ->

        row.forEachIndexed { j, col ->
            if (j != 0) {
                parentheisChar = " "
            } else if (multirow) {
                if (i == 0) {
                    parentheisChar = "⎛"
                } else if (i < this.size - 1) {
                    parentheisChar = "⎜"
                } else {
                    parentheisChar = "⎝"
                }
            } else {
                parentheisChar = "("
            }
            print(parentheisChar + " ")
            print(col)
            if (j < row.size - 1) {
            }
        }
        if (multirow) {
            if (i == 0) {
                parentheisChar = "⎞"
            } else if (i < this.size - 1) {
                parentheisChar = "⎟"
            } else {
                parentheisChar = "⎠"
            }
        } else {
            parentheisChar = ")"
        }
        println(" " + parentheisChar)
    }
}

fun Matrix.multiply(matrix: Matrix): Matrix {
    return (this.indices).map { i ->
        (0 until matrix.shape()[1]).map { j ->
            var sum = 0.toDouble()
            (0 until this.shape()[1]).forEach { k ->
                sum += (this[i][k] * matrix[k][j])
            }
            sum
        }
    }
}

fun Matrix.multiply(scalar: Double): Matrix = this.map { row ->
    row.map { cell ->
        cell * scalar
    }
}

fun Matrix.add(scalar: Double): Matrix = this.map { row ->
    row.map { cell ->
        cell + scalar
    }
}

fun Matrix.add(matrix: Matrix): Matrix {
    if (this.shape() != matrix.shape()) {
        throw Exception("Matrixes don't match")
    }
    return this.mapIndexed { i, row ->
        row.mapIndexed { j, cell ->
            cell + matrix[i][j]
        }
    }
}

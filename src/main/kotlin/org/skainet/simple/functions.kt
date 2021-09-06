package org.skainet.simple

fun sigmoid(matrix: Matrix): Matrix =
    matrix.map { row ->
        row.map { cell: Double ->
            1 / (1 + kotlin.math.exp(-cell))
        }
    }

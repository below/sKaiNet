package org.skainet.simple

import kotlin.test.Test
import kotlin.test.assertEquals

class MatrixTest {
    @Test
    fun matrixMultiply() {
        // 2x3
        val A = listOf(1, 2, 3, 4, 5, 6).toMatrix(3)
        // 3x2
        val B = listOf(1, 2, 3, 4, 5, 6).toMatrix(2)

        val C = A.multiply(B)

        assertEquals(C[1][1], 64.toDouble())
    }

    @Test
    fun matrixAdd() {
        // 2x3
        val A = listOf(1, 2, 3, 4, 5, 6).toMatrix(3)
        // 3x2
        val B = listOf(1, 2).toMatrix(1)

        val C = A.add(B)

        assertEquals(C[1][1], 7.toDouble())
    }
}
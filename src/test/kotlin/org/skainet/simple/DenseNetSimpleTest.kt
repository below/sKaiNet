package org.skainet.simple

import org.junit.Test

class DenseNetTest {
    @Test
    fun predictOnes() {
        val denseNet = DenseNet(
            listOf(
                Layer(
                    MatrixFactory.ones(4, 2),
                    MatrixFactory.zeros(4, 1)
                ),
                Layer(
                    MatrixFactory.ones(2, 2),
                    MatrixFactory.zeros(2, 1)
                )
            )
        )
        print(denseNet.predict(MatrixFactory.ones(2, 1)))
    }
}

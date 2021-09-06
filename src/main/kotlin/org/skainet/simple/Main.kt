package org.skainet.simple

import kotlin.math.sin

fun main(args: Array<String>) {

    val x = MatrixFactory.range(0.0, 3.14 / 2.0, .1)

    val model = DenseNet(
        listOf(
            // 1. hidden layer
            Layer(
                MatrixFactory.ones(1, 40),
                MatrixFactory.zeros(1, 40)
            ),
            // 2. hidden layer
            Layer(
                MatrixFactory.ones(40, 12),
                MatrixFactory.zeros(40, 12)
            ),
            // output layer
            Layer(
                MatrixFactory.ones(12, 1),
                MatrixFactory.zeros(12, 1)
            )
        )
    )
    val result = model.predict(x.toMatrix())
    print(result.print())
}

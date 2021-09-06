package org.skainet.simple

class DenseNet(private val layers: List<Layer>) {

    fun predict(inputMatrix: Matrix): Matrix {
        var data = inputMatrix
        layers.forEach { layer ->
            val weighted = data.multiply(layer.weights)
            val biased = weighted.add(layer.bias)
            data = sigmoid(biased)
        }
        return data
    }
}

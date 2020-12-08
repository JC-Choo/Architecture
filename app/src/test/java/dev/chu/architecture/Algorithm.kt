package dev.chu.architecture

import org.junit.Test

class Algorithm {
    private val arr = arrayOf(2, 4, 3, 1, 9, 6, 7, 8, 10, 5)

    @Test
    fun 삽입정렬() {
        for (i in 1 until arr.size) {
            for (j in i downTo 1) {
                if (arr[j] < arr[j-1]) {
                    swap(j, j-1)
                }
            }
        }
    }

    @Test
    fun 선택정렬() {
        for (i in 0 until arr.size-1) {
            var min = arr[i]
            var index = i
            for (j in i+1 until arr.size) {
                if (min > arr[j]) {
                    min = arr[j]
                    index = j
                }
            }
            if (i != index)
                swap(i, index)
        }
    }

    private fun swap(num1: Int, num2: Int) {
        val temp = arr[num1]
        arr[num1] = arr[num2]
        arr[num2] = temp
//        print("swap 후 ")
//        arr.forEach { print("$it ") }
//        println()
    }
}
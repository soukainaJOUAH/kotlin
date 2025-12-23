package com.example.myapplication

fun main(){

    fun calculer(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
    }

        val addition = { x: Int, y: Int -> x + y }
        val soustraction = { x: Int, y: Int -> x - y }
        val multiplication = { x: Int, y: Int -> x * y }
        val division = { x: Int, y: Int ->
            if (y != 0) x / y else {
                println("Erreur : division par zéro interdite.")
                0
            }
        }

        println(calculer(10, 5, addition))        // ➜ 15
        println(calculer(10, 5, soustraction))    // ➜ 5
        println(calculer(10, 5, multiplication))  // ➜ 50
        println(calculer(10, 2, division))        // ➜ Erreur + 0
    }



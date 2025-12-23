package com.example.myapplication




fun main(){
    fun diviser(a:Double, b: Double){
        try {
            if (b == 0.0) {
                throw ArithmeticException("Division par zéro")
            }
            val resultat = a / b
            println("La division de $a par $b est : $resultat")
        } catch (e: Exception){
            println("la Division par zéro impossible")
            println("Veuillez utiliser un diviseur différent de 0")
        }
    }

    // Appeler sans println
    diviser(8.0, 2.0)
    diviser(10.0, 0.0)
}
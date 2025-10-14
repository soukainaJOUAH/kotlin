package com.example.myapplication

interface Tva {
    fun getTva()
    fun reduireTva()
}
class Tvav1(val montant: Float) : Tva{
    override fun getTva() {
        val m : Double = montant - montant*0.2
        println("le montant de apres reduction de tva est 20% est : $m")
    }

    override fun reduireTva() {
        println("apres reducion de tva c est 15%")
    }
}
class Tvav2(val montant: Float) : Tva {
    override fun getTva() {
        val m : Double = montant - montant*0.15
        println("le montant de apres reduction de tva est 15% est : $m")
    }

    override fun reduireTva() {
        println("apres reducion de tva v2 c est 15%")
    }
}
fun main() {

    var a = Tvav1(5000f)
    var b = Tvav2(5000f)

    a.getTva()
    b.getTva()
}


package com.example.myapplication

interface  Animal {
    fun manger()
    fun parler()
}

class ane : Animal {
    override fun manger() {
        println("Le ane mange des tben.")
    }

    override fun parler() {
        println("Le ane aboie : hhhh !")
    }
}

class poulet : Animal {
    override fun manger() {
        println("Le poulet mange du dera.")
    }

    override fun parler() {
        println("Le poulet miaule : kok !")
    }
}


fun definirParole(animal: Animal) = animal.parler()


fun main() {
    val ane = ane()
    val poulet = poulet()

    ane.manger()
    definirParole(ane)

    poulet.manger()
    definirParole(poulet)
}
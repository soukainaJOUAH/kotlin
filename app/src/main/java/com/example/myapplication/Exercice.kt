package com.example.myapplication
interface Vehicule {
    fun demarrer()
    fun freiner()
}
class Voiture : Vehicule{
    override fun demarrer() {
        println("le voiture a demarrer")
    }

    override fun freiner() {
        println("le voiture a freiner")
    }
}
class Camion : Vehicule{
    override fun demarrer() {
        println("le Camion a demarrer")
    }

    override fun freiner() {
        println("le Camion a freiner")
    }
}
fun main(){
    val v=Voiture()
        v.demarrer()
        v.freiner()
    val c=Camion()
        c.demarrer()
        c.freiner()
}
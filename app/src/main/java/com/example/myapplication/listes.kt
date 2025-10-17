package com.example.myapplication

class Liste {
    val list: MutableList<Int> = mutableListOf()

    // Remplit la liste avec les valeurs 0, 2, 4, ..., 20
    fun remplirList() {
        for (i in 0..20) {
            list.add(i)
        }
    }

    // Affiche tous les éléments de la liste
    fun afficher() {
        for (elt in list) {
            println(elt)
        }
    }

    // Retourne le maximum
    fun getMax(): Int {
        if (list.isEmpty()) return 0
        var max = list[0]
        for (elt in list) {
            if (elt > max) {
                max = elt
            }
        }
        return max
    }

    // Retourne une nouvelle liste contenant les nombres pairs
    fun getNombrePair(): List<Int> {
        val nvList: MutableList<Int> = mutableListOf()
        for (elt in list) {
            if (elt % 2 == 0) {
                nvList.add(elt)
            }
        }
        return nvList
    }

    fun gitNombrePremier(): List<Int> {
        val nvList: MutableList<Int> = mutableListOf()
        for (elt in list) {
            if (estPremier(elt)) {
                nvList.add(elt)

            }
        }

        return nvList
    }
    private fun estPremier(n: Int): Boolean {

        for (i in 2 until n) {
            if (n % i == 0)
                return false
        }
        return true
    }
}

// Programme principal pour tester
fun main() {
    val maListe = Liste()
    maListe.remplirList()
    println("Contenu de la liste :")
    maListe.afficher()

    println("Maximum de la liste : ${maListe.getMax()}")

    val pairs = maListe.getNombrePair()
    println("Nombres pairs : $pairs")

        val premiers = maListe.gitNombrePremier()
        println("Nombres premiers : $premiers")
    }




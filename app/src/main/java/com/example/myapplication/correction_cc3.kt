package com.example.myapplication

class correction_cc3 {
}
fun calculersommeage(age1 :Int, age2 :Int): Double {
    var somme  = 0.0
    somme = age1.toDouble() + age2.toDouble()
    return  somme
}

fun soustraction(a:Double, b: Double): String{
    val sous = a + b
    return sous.toString()
}
open class ComptesCIH(val type:String)
open class ComptesPaPal(val type:String)

class CompteTrouveException(message:String) : Exception(message)
enum class TypeCompte{PERSONNE,ENTREPRISE,COOPERATIVE}

class Compte(val numero:String,var solde : Double,val nomProprietaire : String,val typeCompte : TypeCompte)
interface InterfaceBanque{
    val listComptes : ArrayList<Compte>
    fun ajouterCompte(compte:Compte)
    fun rechercherCompte(solde:Double, type:TypeCompte):List<Compte>
    fun supprimerCompte(compte:Compte):Boolean
    fun getCapital():Double
    fun transferer(c1:Compte, c2:Compte, montant:Double)
}
class GestionBanque : InterfaceBanque {

    override
    val listComptes: ArrayList<Compte> = arrayListOf()


    override
    fun ajouterCompte(compte: Compte) {
        /*if(listComptes.contains(compte))
            throw CompteTrouveException("compte trouve")*/
        for (c in listComptes){
            if(c.numero == compte.numero){
                throw CompteTrouveException("compte trouve")
            }
        }
        listComptes.add(compte)
    }

    override
    fun rechercherCompte(
        solde: Double,
        type: TypeCompte
    ): List<Compte> {
        val listResults : ArrayList<Compte> = arrayListOf()
        val r = listComptes.filter { it.solde == solde && it.typeCompte == type }
        for (cpt in listComptes){
            if(cpt.solde == solde && cpt.typeCompte.equals(type)){
                listResults.add(cpt)
            }
        }
        return r
    }

    override
    fun supprimerCompte(compte: Compte): Boolean {
        return listComptes.remove(compte)

    }

    override
    fun getCapital(): Double {
        var capital = 0.0
        capital = listComptes.sumOf { it.solde }
        for (c in listComptes){
            capital = capital + c.solde
        }
        return capital
    }
    fun rechercher(c: Compte):Boolean{
        var existe = false
        for( elm in listComptes){
            if(c.equals(elm)){
                existe = true
            }
        }
        return existe
    }
    override
    fun transferer(
        from: Compte,
        to: Compte,
        montant: Double
    ) {
        if(listComptes.contains(from) && listComptes.contains(to)){
            from.solde = from.solde - montant
            to.solde = to.solde + montant
        }
    }

}

fun main(){
    val s = soustraction(5.0,3.0)
    print(s)
}
package exercicis

import java.io.File

fun main(args: Array<String>){
    val fichero = File("Penyagolosa.bmp")

    val fi = FitxerImatge(fichero)
    fi.transformaNegatiu()
    fi.transformaObscur()

    //voluntari
    fi.transformaBlancNegre()
}


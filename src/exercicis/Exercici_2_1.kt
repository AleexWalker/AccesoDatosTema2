package exercicis

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class FitxerImatge(fEnt: File) {
    var f: File = File("Penyagolosa.bmp")

    init {
        // Constructor
        // Control d'existència del fitxer i control de l'extensió .bmp (traure missatges d'error)
        // En cas que tot siga correcte, inicialitzar f amb fEnt
    }

    fun transformaNegatiu() {
        val ficheroEntrada = FileInputStream("Penyagolosa.bmp")
        var lectura = ficheroEntrada.read()

        val ficheroSalida = FileOutputStream("Penyagolosa_n.bmp")

        for (c in 1..54) {
            ficheroSalida.write(lectura)        // Transformar a negatiiu i guardar en _n.bmp
            lectura = ficheroEntrada.read()
        }
        while (lectura != -1) {
            ficheroSalida.write(255 - lectura)
            lectura = ficheroEntrada.read()
        }
        ficheroEntrada.close()
        ficheroSalida.close()
    }

    fun transformaObscur() {
        val ficheroEntrada = FileInputStream("Penyagolosa.bmp")
        var lectura = ficheroEntrada.read()

        val ficheroSalida = FileOutputStream("Penyagolosa_o.bmp")

        for (c in 1..54) {
            ficheroSalida.write(lectura)        // Transformar a una imatge més fosca i guardar en _o.bmp
            lectura = ficheroEntrada.read()
        }
        while (lectura != -1) {
            ficheroSalida.write(lectura/2)
            lectura = ficheroEntrada.read()
        }
        ficheroEntrada.close()
        ficheroSalida.close()
    }

    // Partvoluntària
    fun transformaBlancNegre() {
        val ficheroEntrada = FileInputStream("Penyagolosa.bmp")
        var lectura = ficheroEntrada.read()

        val ficheroSalida = FileOutputStream("Penyagolosa_bn.bmp")
        var auxiliarRed = 0
        var auxiliarGreen = 0
        var auxiliarBlue = 0

        for (c in 1..54) {
            ficheroSalida.write(lectura)        // Transformar a una imatge en blanc i negre i guardar en _bn.bmp
            lectura = ficheroEntrada.read()
        }
        while (auxiliarBlue != -1) {

            auxiliarRed = ficheroEntrada.read()
            auxiliarGreen = ficheroEntrada.read()
            auxiliarBlue = ficheroEntrada.read()
            val total = (auxiliarRed + auxiliarGreen + auxiliarBlue) /3

            for (c in 1..3)
                ficheroSalida.write(total)
        }
        ficheroEntrada.close()
        ficheroSalida.close()
    }
}



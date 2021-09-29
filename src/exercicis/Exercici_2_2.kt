package exercicis

import javax.swing.*
import java.awt.*
import java.io.*

class Exercici_2_2_Pantalla : JFrame() {
    val et_f = JLabel("Fitxer:")
    val fitxer = JTextField(25)
    val obrir = JButton("Obrir")
    val guardar = JButton("Guardar")
    val et_a = JLabel("Contingut:")
    val area = JTextArea(10, 50)
    val scrollPane = JScrollPane(area)

    // en iniciar posem un contenidor per als elements anteriors
    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        setLayout(GridLayout(2, 1))
        setTitle("Editor de text")

        val panell1 = JPanel(GridLayout(0, 1))
        val panell1_1 = JPanel(FlowLayout())
        panell1.add(panell1_1)
        panell1_1.add(et_f)
        panell1_1.add(fitxer)

        val panell1_2 = JPanel(FlowLayout())
        panell1.add(panell1_2)
        panell1_2.add(obrir)
        panell1_2.add(guardar)
        val panell2 = JPanel(GridLayout(0, 1))
        panell2.add(scrollPane)
        area.setEditable(true)

        add(panell1)
        add(panell2)
        pack()

        obrir.addActionListener {
            try {
                val fichero = fitxer.text.toString()
                val ficheroEntrada = FileReader(fichero)              // Instruccions per a bolcar el contingut del fitxer en el JTextArea
                val ficheroSalida = FileWriter(fichero, true)

                var lectura = ficheroEntrada.read()
                area.text = ""

                while (lectura != -1) {
                    area.append(lectura.toChar().toString())
                    lectura = ficheroEntrada.read()
                }
                ficheroEntrada.close()
                ficheroSalida.close()
            } catch (ex:FileNotFoundException){
                fitxer.text = "¡Fichero Inexistente o terminacion erronea!"
            }

        }

        guardar.addActionListener {
            val fichero = fitxer.text.toString()

            val text = area.text.toString()                       // Instruccions per a guardar el contingut del JTextArea al fitxer.
            File(fichero).writeText(text)

        }
    }
}

private fun crearMostrarFinestra() {

    val frame = Exercici_2_2_Pantalla()
    frame.isVisible = true
}

fun main(args: Array<String>) {
    EventQueue.invokeLater(::crearMostrarFinestra)
}
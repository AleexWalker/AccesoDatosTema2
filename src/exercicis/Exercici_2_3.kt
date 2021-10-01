package exercicis

import java.awt.*
import java.io.File
import javax.swing.*


class Exercici_2_3 : JFrame() {
    val area = JTextArea()
    val scrollPane = JScrollPane(area)

    val menu_p = JMenuBar()

    val menu_arxiu = JMenu("Arxiu")
    val menu_ajuda = JMenu("Ajuda")

    val obrir = JMenuItem("Obrir")
    val guardar = JMenuItem("Guardar")
    val guardarCom = JMenuItem("Guardar com ...")
    val eixir = JMenuItem("Eixir")

    val quantA = JMenuItem("Quant a Editor")

    val fCh = JFileChooser()

    // en iniciar posem un contenidor per als elements anteriors
    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        setLayout(BorderLayout())
        setTitle("Editor de text més avançat")
        add(scrollPane)
        area.setEditable(true)

        setSize(750, 400)
        setJMenuBar(menu_p)

        menu_p.add(menu_arxiu)
        menu_p.add(menu_ajuda)

        menu_arxiu.add(obrir)
        menu_arxiu.add(guardar)
        menu_arxiu.add(guardarCom)
        menu_arxiu.add(JSeparator())
        menu_arxiu.add(eixir)

        menu_ajuda.add(quantA);

        obrir.addActionListener { obrir() }

        guardar.addActionListener { guardar() }

        guardarCom.addActionListener { guardarCom() }

        eixir.addActionListener { eixir() }

        quantA.addActionListener { quantA() }
    }

    fun obrir() {
        //do {
        area.text = ""
            fCh.showOpenDialog(scrollPane)                          // Instruccions per a obrir un fitxer i posar el contingut en el JTextArea
            val fichero = File(fCh.selectedFile.name)

            var lector = fichero.readText()
            area.append(lector.toString())
        //} while (eixir())

    }

    fun guardar() {
        if (fCh.selectedFile == null)
            guardarCom()
        else {
            val fichero = File(fCh.selectedFile.name)                   // Instruccions per a guardar el contingut del JTextArea al fitxer.
            val text = area.text.toString()

            fichero.writeText(text)
        }
    }

    fun guardarCom() {
        fCh.showSaveDialog(scrollPane)                              // Instruccions per a guardar el contingut del JTextArea al fitxer, amb la possibilitat de canviar el nom

        val fichero = File(fCh.selectedFile.name).writeText(area.text.toString())
    }

    fun eixir() {
        // Instruccions per a eixir
        System.exit(0)
    }

    fun quantA() {
        JOptionPane.showMessageDialog(quantA,
            "Este es el apartado de FAQ de nuestra empresa, ante cualquier duda contacta mediante nuestro correo electronico: \n" +
                    "accesoDatos@Acceso.org\n" +
                    "o mediante nuestro numero de telefono: \n" +
                    "+12 345 678 910",
            "Acerca de Nosotros",
            JOptionPane.ERROR_MESSAGE);
            // Instruccions per a mostrar un diàleg amb la versió (Acerca de...)
    }
}


fun main(args: Array<String>) {
    EventQueue.invokeLater( { Exercici_2_3().isVisible = true })
}

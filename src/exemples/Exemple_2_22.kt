package exemples

import java.io.CharArrayReader
import java.io.StringReader

fun main(args: Array<String>) {
    val ent_1 = "Aquest és un byte array"
    val f_in = StringReader(ent_1)
    var c = f_in.read()
    while (c != -1) {
        println(c.toChar())
        c = f_in.read()
    }
    f_in.close()
}
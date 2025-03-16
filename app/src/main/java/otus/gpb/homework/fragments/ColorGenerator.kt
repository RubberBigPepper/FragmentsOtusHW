package otus.gpb.homework.fragments

import java.util.Random
import androidx.core.graphics.toColorInt

object ColorGenerator {

    fun generateColor(): Int {
        val nextInt = Random().nextInt(0xffffff + 1)
        val colorCode = String.format("#%06x", nextInt)
        return colorCode.toColorInt()
    }
}
package info.firozansari.espressoexamples

/**
 * Created by Firoz.
 */
class TextSwapper(private val mBeforeText: String, private val mAfterText: String) {
    var currentText: String
        private set

    fun swap(): String {
        currentText = if (currentText == mBeforeText) mAfterText else mBeforeText
        return currentText
    }

    init {
        currentText = mBeforeText
    }
}
package info.firozansari.espressoexamples;

/**
 * Created by Firoz.
 */
public class TextSwapper {
    private String mBeforeText, mAfterText, mCurrentText;


    public TextSwapper(String beforeText, String afterText) {
        mBeforeText = beforeText;
        mAfterText = afterText;
        mCurrentText = mBeforeText;
    }

    public String swap() {
        mCurrentText = getCurrentText().equals(mBeforeText) ? mAfterText : mBeforeText;
        return mCurrentText;
    }

    public String getCurrentText() {
        return mCurrentText;
    }

}

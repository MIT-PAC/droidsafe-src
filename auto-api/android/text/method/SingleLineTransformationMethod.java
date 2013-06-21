package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Rect;
import android.text.Editable;
import android.text.GetChars;
import android.text.Spannable;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import android.view.View;

public class SingleLineTransformationMethod extends ReplacementTransformationMethod {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.702 -0400", hash_original_method = "86DF3C1361F534D6F1A98F6BD7B07246", hash_generated_method = "86DF3C1361F534D6F1A98F6BD7B07246")
        public SingleLineTransformationMethod ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.703 -0400", hash_original_method = "64C6D73F3773427C2A2F245DBEBF22E0", hash_generated_method = "2ADF437FB49E6A588C8F87F3066AA092")
    @DSModeled(DSC.SAFE)
    protected char[] getOriginal() {
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return ORIGINAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.703 -0400", hash_original_method = "44611EB51BD7B665366AA2036C731932", hash_generated_method = "09D90675D1759039528493A05E99DA0A")
    @DSModeled(DSC.SAFE)
    protected char[] getReplacement() {
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return REPLACEMENT;
    }

    
        public static SingleLineTransformationMethod getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new SingleLineTransformationMethod();
        return sInstance;
    }

    
    private static char[] ORIGINAL = new char[] { '\n', '\r' };
    private static char[] REPLACEMENT = new char[] { ' ', '\uFEFF' };
    private static SingleLineTransformationMethod sInstance;
}


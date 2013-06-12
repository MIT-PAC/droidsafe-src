package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static char[] ORIGINAL = new char[] { '\n', '\r' };
    private static char[] REPLACEMENT = new char[] { ' ', '\uFEFF' };
    private static SingleLineTransformationMethod sInstance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.103 -0400", hash_original_method = "64C6D73F3773427C2A2F245DBEBF22E0", hash_generated_method = "61FD973EDEFE726898A080700D138A5D")
    @DSModeled(DSC.SAFE)
    protected char[] getOriginal() {
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return ORIGINAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.103 -0400", hash_original_method = "44611EB51BD7B665366AA2036C731932", hash_generated_method = "59A1E88708D6079ADF63F015103102F1")
    @DSModeled(DSC.SAFE)
    protected char[] getReplacement() {
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return REPLACEMENT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.103 -0400", hash_original_method = "4853BBC3FBC3CF589EEA47536237EC37", hash_generated_method = "B201543D46DD84421BE8C9D74F2BA21C")
    public static SingleLineTransformationMethod getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new SingleLineTransformationMethod();
        return sInstance;
    }

    
}



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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.544 -0400", hash_original_method = "D4568A7EAB6F00728EAF3C3E423FA0FE", hash_generated_method = "D4568A7EAB6F00728EAF3C3E423FA0FE")
    public SingleLineTransformationMethod ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.544 -0400", hash_original_method = "64C6D73F3773427C2A2F245DBEBF22E0", hash_generated_method = "EAD92A3E20FA5CF79B537E15632D835C")
    protected char[] getOriginal() {
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_317488994 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_317488994;
        // ---------- Original Method ----------
        //return ORIGINAL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.545 -0400", hash_original_method = "44611EB51BD7B665366AA2036C731932", hash_generated_method = "859263EEC7083A878B2A6ED63508CEF8")
    protected char[] getReplacement() {
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1057465448 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1057465448;
        // ---------- Original Method ----------
        //return REPLACEMENT;
    }

    
    public static SingleLineTransformationMethod getInstance() {
        if (sInstance != null)
            return sInstance;
        sInstance = new SingleLineTransformationMethod();
        return sInstance;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.545 -0400", hash_original_field = "4AC4EB788451F78EBC24616F6EFC82B2", hash_generated_field = "98B422AB3100EE03E170C8673A5F0723")

    private static char[] ORIGINAL = new char[] { '\n', '\r' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.545 -0400", hash_original_field = "185EEC0054C0F25266726A820450EC7F", hash_generated_field = "4BECEA87476210D9FCD61E1027EFAAFB")

    private static char[] REPLACEMENT = new char[] { ' ', '\uFEFF' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.545 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "6480497BDC465266B7D9E18C73F9BE9F")

    private static SingleLineTransformationMethod sInstance;
}


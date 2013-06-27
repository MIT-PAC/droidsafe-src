package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.text.Editable;

class JapanesePhoneNumberFormatter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.569 -0400", hash_original_method = "8633AFAAB867BB1617201EF2E839378D", hash_generated_method = "8633AFAAB867BB1617201EF2E839378D")
    public JapanesePhoneNumberFormatter ()
    {
        //Synthesized constructor
    }


        public static void format(Editable text) {
        int rootIndex = 1;
        int length = text.length();
        if (length > 3
                && text.subSequence(0, 3).toString().equals("+81")) {
            rootIndex = 3;
        } else if (length < 1 || text.charAt(0) != '0') {
            return;
        }
        CharSequence saved = text.subSequence(0, length);
        int i = 0;
        while (i < text.length()) {
            if (text.charAt(i) == '-') {
                text.delete(i, i + 1);
            } else {
                i++;
            }
        }
        length = text.length();
        int dashposition;
        i = rootIndex;
        int base = 0;
        while (i < length) {
            char ch = text.charAt(i);
            if (!Character.isDigit(ch)) {
                text.replace(0, length, saved);
                return;
            }
            short value = FORMAT_MAP[base + ch - '0'];
            if (value < 0) {
                if (value <= -100) {
                    text.replace(0, length, saved);
                    return;
                }
                int dashPos2 = rootIndex + (Math.abs(value) % 10);
                if (length > dashPos2) {
                    text.insert(dashPos2, "-");
                }
                int dashPos1 = rootIndex + (Math.abs(value) / 10);
                if (length > dashPos1) {
                    text.insert(dashPos1, "-");
                }
                break;
            } else {
                base = value;
                i++;
            }
        }
        if (length > 3 && rootIndex == 3) {
            text.insert(rootIndex, "-");
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.570 -0400", hash_original_field = "A7EC13753EC06139DD5665DC71016EA3", hash_generated_field = "2D8551B50EF5C4008D87F6993010E4DA")

    private static short FORMAT_MAP[] = ;
}


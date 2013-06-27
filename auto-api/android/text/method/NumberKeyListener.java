package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.KeyEvent;
import android.view.View;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

public abstract class NumberKeyListener extends BaseKeyListener implements InputFilter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.029 -0400", hash_original_method = "4B29623A8F76435C1A957FA964420338", hash_generated_method = "4B29623A8F76435C1A957FA964420338")
    public NumberKeyListener ()
    {
        //Synthesized constructor
    }


    protected abstract char[] getAcceptedChars();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.030 -0400", hash_original_method = "C0C70824215D530CCBC4D0D762C70EA3", hash_generated_method = "3BF7073F3FCB3338BD1AAAC4EBCEA038")
    protected int lookup(KeyEvent event, Spannable content) {
        int var1621D9B0E059528E3DCB0577C0A2C9B8_1546026593 = (event.getMatch(getAcceptedChars(), event.getMetaState() | getMetaState(content)));
        addTaint(event.getTaint());
        addTaint(content.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_554819957 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_554819957;
        // ---------- Original Method ----------
        //return event.getMatch(getAcceptedChars(), event.getMetaState() | getMetaState(content));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.044 -0400", hash_original_method = "CB7791CDEF3F29FF221CF4242D732189", hash_generated_method = "F9C1ECA0A524D21E6D3D7D4B6B74C2C5")
    public CharSequence filter(CharSequence source, int start, int end,
                               Spanned dest, int dstart, int dend) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_552803246 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1281166371 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1518667224 = null; //Variable for return #3
        char[] accept;
        accept = getAcceptedChars();
        boolean filter;
        filter = false;
        int i;
        {
            i = start;
            {
                {
                    boolean var7ECCC53748A568D46FD2C52601F853F4_1933220555 = (!ok(accept, source.charAt(i)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_552803246 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1281166371 = "";
        } //End block
        SpannableStringBuilder filtered;
        filtered = new SpannableStringBuilder(source, start, end);
        i -= start;
        end -= start;
        int len;
        len = end - start;
        {
            int j;
            j = end - 1;
            {
                {
                    boolean var14F2A669F71CA4FE1D5A088E37357DB1_717747467 = (!ok(accept, source.charAt(j)));
                    {
                        filtered.delete(j, j + 1);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1518667224 = filtered;
        addTaint(source.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(dest.getTaint());
        addTaint(dstart);
        addTaint(dend);
        CharSequence varA7E53CE21691AB073D9660D615818899_1896664750; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1896664750 = varB4EAC82CA7396A68D541C85D26508E83_552803246;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1896664750 = varB4EAC82CA7396A68D541C85D26508E83_1281166371;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1896664750 = varB4EAC82CA7396A68D541C85D26508E83_1518667224;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1896664750.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1896664750;
        // ---------- Original Method ----------
        //char[] accept = getAcceptedChars();
        //boolean filter = false;
        //int i;
        //for (i = start; i < end; i++) {
            //if (!ok(accept, source.charAt(i))) {
                //break;
            //}
        //}
        //if (i == end) {
            //return null;
        //}
        //if (end - start == 1) {
            //return "";
        //}
        //SpannableStringBuilder filtered =
            //new SpannableStringBuilder(source, start, end);
        //i -= start;
        //end -= start;
        //int len = end - start;
        //for (int j = end - 1; j >= i; j--) {
            //if (!ok(accept, source.charAt(j))) {
                //filtered.delete(j, j + 1);
            //}
        //}
        //return filtered;
    }

    
        protected static boolean ok(char[] accept, char c) {
        for (int i = accept.length - 1; i >= 0; i--) {
            if (accept[i] == c) {
                return true;
            }
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:44.061 -0400", hash_original_method = "A33764BD45F2F5F121C837A63F0C5C57", hash_generated_method = "0663DCAEB2E67A165722F507EBD1B06D")
    @Override
    public boolean onKeyDown(View view, Editable content,
                             int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        int selStart, selEnd;
        {
            int a;
            a = Selection.getSelectionStart(content);
            int b;
            b = Selection.getSelectionEnd(content);
            selStart = Math.min(a, b);
            selEnd = Math.max(a, b);
        } //End block
        {
            selStart = selEnd = 0;
            Selection.setSelection(content, 0);
        } //End block
        int i;
        i = lookup(event, content);
        i = 0;
        int repeatCount;
        repeatCount = event.getRepeatCount();
        repeatCount = 0;
        {
            {
                {
                    Selection.setSelection(content, selEnd);
                } //End block
                content.replace(selStart, selEnd, String.valueOf((char) i));
                adjustMetaAfterKeypress(content);
            } //End block
        } //End block
        {
            {
                boolean var0C02D08E46FB5445DFEFCD06B092449E_1640119823 = (selStart == selEnd && selEnd > 0 &&
                    content.charAt(selStart - 1) == '0');
                {
                    content.replace(selStart - 1, selEnd, String.valueOf('+'));
                    adjustMetaAfterKeypress(content);
                } //End block
            } //End collapsed parenthetic
        } //End block
        adjustMetaAfterKeypress(content);
        boolean var250B4652E205BB567180858BBC354846_1343873597 = (super.onKeyDown(view, content, keyCode, event));
        addTaint(view.getTaint());
        addTaint(content.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1648738482 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1648738482;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}


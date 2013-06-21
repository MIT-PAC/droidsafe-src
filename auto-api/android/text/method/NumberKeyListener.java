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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.507 -0400", hash_original_method = "2E122C36C81AB5355F43AAE9F0CC7229", hash_generated_method = "2E122C36C81AB5355F43AAE9F0CC7229")
        public NumberKeyListener ()
    {
    }


    protected abstract char[] getAcceptedChars();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.514 -0400", hash_original_method = "C0C70824215D530CCBC4D0D762C70EA3", hash_generated_method = "07CC42425F32D9C2496B7768E4E7DDD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int lookup(KeyEvent event, Spannable content) {
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        int var1621D9B0E059528E3DCB0577C0A2C9B8_383367704 = (event.getMatch(getAcceptedChars(), event.getMetaState() | getMetaState(content)));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return event.getMatch(getAcceptedChars(), event.getMetaState() | getMetaState(content));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.514 -0400", hash_original_method = "CB7791CDEF3F29FF221CF4242D732189", hash_generated_method = "D4865EE18CCBCE60D1B0EA295F2B1FEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence filter(CharSequence source, int start, int end,
                               Spanned dest, int dstart, int dend) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(dstart);
        dsTaint.addTaint(source);
        dsTaint.addTaint(dend);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        char[] accept;
        accept = getAcceptedChars();
        boolean filter;
        filter = false;
        int i;
        {
            i = start;
            {
                {
                    boolean var7ECCC53748A568D46FD2C52601F853F4_1162869049 = (!ok(accept, source.charAt(i)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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
                    boolean var14F2A669F71CA4FE1D5A088E37357DB1_588519355 = (!ok(accept, source.charAt(j)));
                    {
                        filtered.delete(j, j + 1);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.515 -0400", hash_original_method = "A33764BD45F2F5F121C837A63F0C5C57", hash_generated_method = "0D5C39E9D54E55D8636CC1C662279932")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyDown(View view, Editable content,
                             int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(view.dsTaint);
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
                boolean var0C02D08E46FB5445DFEFCD06B092449E_991220254 = (selStart == selEnd && selEnd > 0 &&
                    content.charAt(selStart - 1) == '0');
                {
                    content.replace(selStart - 1, selEnd, String.valueOf('+'));
                    adjustMetaAfterKeypress(content);
                } //End block
            } //End collapsed parenthetic
        } //End block
        adjustMetaAfterKeypress(content);
        boolean var250B4652E205BB567180858BBC354846_1061241917 = (super.onKeyDown(view, content, keyCode, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}


package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.view.KeyEvent;
import android.view.View;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

public abstract class NumberKeyListener extends BaseKeyListener implements InputFilter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.725 -0400", hash_original_method = "4B29623A8F76435C1A957FA964420338", hash_generated_method = "4B29623A8F76435C1A957FA964420338")
    public NumberKeyListener ()
    {
        //Synthesized constructor
    }


    protected abstract char[] getAcceptedChars();

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.726 -0400", hash_original_method = "C0C70824215D530CCBC4D0D762C70EA3", hash_generated_method = "BE33E4C80457D88439024393E62D1860")
    protected int lookup(KeyEvent event, Spannable content) {
        addTaint(content.getTaint());
        addTaint(event.getTaint());
        int var11B4B4D24B810B26F362AD5333C5A1BA_1973921262 = (event.getMatch(getAcceptedChars(), event.getMetaState() | getMetaState(content)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_542675718 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_542675718;
        // ---------- Original Method ----------
        //return event.getMatch(getAcceptedChars(), event.getMetaState() | getMetaState(content));
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.727 -0400", hash_original_method = "CB7791CDEF3F29FF221CF4242D732189", hash_generated_method = "AC03C1C0213B8CAA7DDA0D7C0CCA8FB6")
    public CharSequence filter(CharSequence source, int start, int end,
                               Spanned dest, int dstart, int dend) {
        addTaint(dend);
        addTaint(dstart);
        addTaint(dest.getTaint());
        addTaint(end);
        addTaint(start);
        addTaint(source.getTaint());
        char[] accept = getAcceptedChars();
        boolean filter = false;
        int i;
for(i = start;i < end;i++)
        {
    if(!ok(accept, source.charAt(i)))            
            {
                break;
            } //End block
        } //End block
    if(i == end)        
        {
CharSequence var540C13E9E156B687226421B24F2DF178_1531091707 =             null;
            var540C13E9E156B687226421B24F2DF178_1531091707.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1531091707;
        } //End block
    if(end - start == 1)        
        {
CharSequence var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1773788018 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1773788018.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1773788018;
        } //End block
        SpannableStringBuilder filtered = new SpannableStringBuilder(source, start, end);
        i -= start;
        end -= start;
        int len = end - start;
for(int j = end - 1;j >= i;j--)
        {
    if(!ok(accept, source.charAt(j)))            
            {
                filtered.delete(j, j + 1);
            } //End block
        } //End block
CharSequence var59AFDF48DAC2B65C0DC9F976A34BEAF9_704515118 =         filtered;
        var59AFDF48DAC2B65C0DC9F976A34BEAF9_704515118.addTaint(taint);
        return var59AFDF48DAC2B65C0DC9F976A34BEAF9_704515118;
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

    
        @DSModeled(DSC.SAFE)
    protected static boolean ok(char[] accept, char c) {
        for (int i = accept.length - 1; i >= 0; i--) {
            if (accept[i] == c) {
                return true;
            }
        }
        return false;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:46.729 -0400", hash_original_method = "A33764BD45F2F5F121C837A63F0C5C57", hash_generated_method = "DD942458CFB5E183691850C2784B10A0")
    @Override
    public boolean onKeyDown(View view, Editable content,
                             int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(content.getTaint());
        addTaint(view.getTaint());
        int selStart;
        int selEnd;
        {
            int a = Selection.getSelectionStart(content);
            int b = Selection.getSelectionEnd(content);
            selStart = Math.min(a, b);
            selEnd = Math.max(a, b);
        } //End block
    if(selStart < 0 || selEnd < 0)        
        {
            selStart = selEnd = 0;
            Selection.setSelection(content, 0);
        } //End block
        int i = event != null ? lookup(event, content) : 0;
        int repeatCount = event != null ? event.getRepeatCount() : 0;
    if(repeatCount == 0)        
        {
    if(i != 0)            
            {
    if(selStart != selEnd)                
                {
                    Selection.setSelection(content, selEnd);
                } //End block
                content.replace(selStart, selEnd, String.valueOf((char) i));
                adjustMetaAfterKeypress(content);
                boolean varB326B5062B2F0E69046810717534CB09_1915018226 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2143258542 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2143258542;
            } //End block
        } //End block
        else
    if(i == '0' && repeatCount == 1)        
        {
    if(selStart == selEnd && selEnd > 0 &&
                    content.charAt(selStart - 1) == '0')            
            {
                content.replace(selStart - 1, selEnd, String.valueOf('+'));
                adjustMetaAfterKeypress(content);
                boolean varB326B5062B2F0E69046810717534CB09_284387098 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_832062791 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_832062791;
            } //End block
        } //End block
        adjustMetaAfterKeypress(content);
        boolean var5F21C6842D9E32D23C5A1CD0B3EB473F_1219517489 = (super.onKeyDown(view, content, keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1019981327 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1019981327;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}


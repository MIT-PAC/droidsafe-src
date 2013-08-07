package android.text.method;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;




public abstract class NumberKeyListener extends BaseKeyListener implements InputFilter {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.475 -0400", hash_original_method = "4B29623A8F76435C1A957FA964420338", hash_generated_method = "4B29623A8F76435C1A957FA964420338")
    public NumberKeyListener ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    protected abstract char[] getAcceptedChars();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.476 -0400", hash_original_method = "C0C70824215D530CCBC4D0D762C70EA3", hash_generated_method = "FBDBED86B6084C5635075F22C7B29305")
    protected int lookup(KeyEvent event, Spannable content) {
        addTaint(content.getTaint());
        addTaint(event.getTaint());
        int var11B4B4D24B810B26F362AD5333C5A1BA_387608766 = (event.getMatch(getAcceptedChars(), event.getMetaState() | getMetaState(content)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1537701536 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1537701536;
        // ---------- Original Method ----------
        //return event.getMatch(getAcceptedChars(), event.getMetaState() | getMetaState(content));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.478 -0400", hash_original_method = "CB7791CDEF3F29FF221CF4242D732189", hash_generated_method = "FF59935EFD147E31F8E8A8E3ACD5506A")
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
CharSequence var540C13E9E156B687226421B24F2DF178_980521191 =             null;
            var540C13E9E156B687226421B24F2DF178_980521191.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_980521191;
        } //End block
        if(end - start == 1)        
        {
CharSequence var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1955247218 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1955247218.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1955247218;
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
CharSequence var59AFDF48DAC2B65C0DC9F976A34BEAF9_2049635355 =         filtered;
        var59AFDF48DAC2B65C0DC9F976A34BEAF9_2049635355.addTaint(taint);
        return var59AFDF48DAC2B65C0DC9F976A34BEAF9_2049635355;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.480 -0400", hash_original_method = "A33764BD45F2F5F121C837A63F0C5C57", hash_generated_method = "DD73431427813BA63D0684BAAEEAED29")
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
                boolean varB326B5062B2F0E69046810717534CB09_1897263374 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_977475017 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_977475017;
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
                boolean varB326B5062B2F0E69046810717534CB09_261149743 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1843789316 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1843789316;
            } //End block
        } //End block
        adjustMetaAfterKeypress(content);
        boolean var5F21C6842D9E32D23C5A1CD0B3EB473F_1767994698 = (super.onKeyDown(view, content, keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_780349515 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_780349515;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}


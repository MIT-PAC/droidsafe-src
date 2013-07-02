package android.text.method;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.302 -0400", hash_original_method = "4B29623A8F76435C1A957FA964420338", hash_generated_method = "4B29623A8F76435C1A957FA964420338")
    public NumberKeyListener ()
    {
        
    }


    protected abstract char[] getAcceptedChars();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.303 -0400", hash_original_method = "C0C70824215D530CCBC4D0D762C70EA3", hash_generated_method = "9BDFFD802EAEA5F92F87FEB0DD8C4F42")
    protected int lookup(KeyEvent event, Spannable content) {
        int var1621D9B0E059528E3DCB0577C0A2C9B8_1113872797 = (event.getMatch(getAcceptedChars(), event.getMetaState() | getMetaState(content)));
        addTaint(event.getTaint());
        addTaint(content.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_146683926 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_146683926;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.305 -0400", hash_original_method = "CB7791CDEF3F29FF221CF4242D732189", hash_generated_method = "7A1E3116B0AAE5FDF53939A6356B7C75")
    public CharSequence filter(CharSequence source, int start, int end,
                               Spanned dest, int dstart, int dend) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1556061338 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_46975367 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_690758171 = null; 
        char[] accept = getAcceptedChars();
        boolean filter = false;
        int i;
        {
            i = start;
            {
                {
                    boolean var7ECCC53748A568D46FD2C52601F853F4_1795465606 = (!ok(accept, source.charAt(i)));
                } 
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1556061338 = null;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_46975367 = "";
        } 
        SpannableStringBuilder filtered = new SpannableStringBuilder(source, start, end);
        i -= start;
        end -= start;
        int len = end - start;
        {
            int j = end - 1;
            {
                {
                    boolean var14F2A669F71CA4FE1D5A088E37357DB1_2089898707 = (!ok(accept, source.charAt(j)));
                    {
                        filtered.delete(j, j + 1);
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_690758171 = filtered;
        addTaint(source.getTaint());
        addTaint(start);
        addTaint(end);
        addTaint(dest.getTaint());
        addTaint(dstart);
        addTaint(dend);
        CharSequence varA7E53CE21691AB073D9660D615818899_2099574635; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2099574635 = varB4EAC82CA7396A68D541C85D26508E83_1556061338;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_2099574635 = varB4EAC82CA7396A68D541C85D26508E83_46975367;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2099574635 = varB4EAC82CA7396A68D541C85D26508E83_690758171;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2099574635.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2099574635;
        
        
        
        
        
            
                
            
        
        
            
        
        
            
        
        
            
        
        
        
        
            
                
            
        
        
    }

    
    protected static boolean ok(char[] accept, char c) {
        for (int i = accept.length - 1; i >= 0; i--) {
            if (accept[i] == c) {
                return true;
            }
        }
        return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:51.306 -0400", hash_original_method = "A33764BD45F2F5F121C837A63F0C5C57", hash_generated_method = "5A590BF152C71FDDCCC286BC55A91588")
    @Override
    public boolean onKeyDown(View view, Editable content,
                             int keyCode, KeyEvent event) {
        
        int selStart;
        int selEnd;
        {
            int a = Selection.getSelectionStart(content);
            int b = Selection.getSelectionEnd(content);
            selStart = Math.min(a, b);
            selEnd = Math.max(a, b);
        } 
        {
            selStart = selEnd = 0;
            Selection.setSelection(content, 0);
        } 
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
                } 
                content.replace(selStart, selEnd, String.valueOf((char) i));
                adjustMetaAfterKeypress(content);
            } 
        } 
        {
            {
                boolean var0C02D08E46FB5445DFEFCD06B092449E_1303861135 = (selStart == selEnd && selEnd > 0 &&
                    content.charAt(selStart - 1) == '0');
                {
                    content.replace(selStart - 1, selEnd, String.valueOf('+'));
                    adjustMetaAfterKeypress(content);
                } 
            } 
        } 
        adjustMetaAfterKeypress(content);
        boolean var250B4652E205BB567180858BBC354846_257907524 = (super.onKeyDown(view, content, keyCode, event));
        addTaint(view.getTaint());
        addTaint(content.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_121275579 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_121275579;
        
        
    }

    
}


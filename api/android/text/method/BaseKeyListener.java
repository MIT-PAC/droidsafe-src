package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.view.KeyEvent;
import android.view.View;
import android.text.*;
import android.text.method.TextKeyListener.Capitalize;
import android.widget.TextView;

public abstract class BaseKeyListener extends MetaKeyKeyListener implements KeyListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.945 -0400", hash_original_method = "457D2BEC00B20336593EA76F83128980", hash_generated_method = "457D2BEC00B20336593EA76F83128980")
    public BaseKeyListener ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.945 -0400", hash_original_method = "C743EFD1D596571F6949DCD9BEFE98FE", hash_generated_method = "A3A28626A8D54A9679238AC1FE16201C")
    public boolean backspace(View view, Editable content, int keyCode, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(content.getTaint());
        addTaint(view.getTaint());
        boolean var4FB884506044A099219D84656CE1EA96_1296919270 = (backspaceOrForwardDelete(view, content, keyCode, event, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_500633217 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_500633217;
        // ---------- Original Method ----------
        //return backspaceOrForwardDelete(view, content, keyCode, event, false);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.945 -0400", hash_original_method = "44D414C093A103E2D46C2C9EBFB633B7", hash_generated_method = "8745BDD5BCC9AFC1B3024AB0E0FDAFCB")
    public boolean forwardDelete(View view, Editable content, int keyCode, KeyEvent event) {
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(content.getTaint());
        addTaint(view.getTaint());
        boolean var5B5A139D3657A639756C091F15F52ABA_1863620841 = (backspaceOrForwardDelete(view, content, keyCode, event, true));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_618919691 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_618919691;
        // ---------- Original Method ----------
        //return backspaceOrForwardDelete(view, content, keyCode, event, true);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.947 -0400", hash_original_method = "070DF95C0353A773EEB24BBDC2D8297C", hash_generated_method = "3B4072DF33BE2B4F262CA80C4503B8B6")
    private boolean backspaceOrForwardDelete(View view, Editable content, int keyCode,
            KeyEvent event, boolean isForwardDelete) {
        addTaint(isForwardDelete);
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(content.getTaint());
        addTaint(view.getTaint());
        if(!KeyEvent.metaStateHasNoModifiers(event.getMetaState()
                & ~(KeyEvent.META_SHIFT_MASK | KeyEvent.META_ALT_MASK)))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1772068399 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_90955522 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_90955522;
        } //End block
        if(deleteSelection(view, content))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_573302612 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1945673583 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1945673583;
        } //End block
        if(event.isAltPressed() || getMetaState(content, META_ALT_ON) == 1)        
        {
            if(deleteLine(view, content))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_794201797 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1479944331 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1479944331;
            } //End block
        } //End block
        final int start = Selection.getSelectionEnd(content);
        int end;
        if(isForwardDelete || event.isShiftPressed()
                || getMetaState(content, META_SHIFT_ON) == 1)        
        {
            end = TextUtils.getOffsetAfter(content, start);
        } //End block
        else
        {
            end = TextUtils.getOffsetBefore(content, start);
        } //End block
        if(start != end)        
        {
            content.delete(Math.min(start, end), Math.max(start, end));
            boolean varB326B5062B2F0E69046810717534CB09_1919244358 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_394021825 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_394021825;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2084064144 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2043164907 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2043164907;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.948 -0400", hash_original_method = "2C36007D0B232577504AED53A81D7DC4", hash_generated_method = "43999D2C9B3B40AA6481F9A4812ECD77")
    private boolean deleteSelection(View view, Editable content) {
        addTaint(content.getTaint());
        addTaint(view.getTaint());
        int selectionStart = Selection.getSelectionStart(content);
        int selectionEnd = Selection.getSelectionEnd(content);
        if(selectionEnd < selectionStart)        
        {
            int temp = selectionEnd;
            selectionEnd = selectionStart;
            selectionStart = temp;
        } //End block
        if(selectionStart != selectionEnd)        
        {
            content.delete(selectionStart, selectionEnd);
            boolean varB326B5062B2F0E69046810717534CB09_766352376 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_508529323 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_508529323;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_799453506 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_300949606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_300949606;
        // ---------- Original Method ----------
        //int selectionStart = Selection.getSelectionStart(content);
        //int selectionEnd = Selection.getSelectionEnd(content);
        //if (selectionEnd < selectionStart) {
            //int temp = selectionEnd;
            //selectionEnd = selectionStart;
            //selectionStart = temp;
        //}
        //if (selectionStart != selectionEnd) {
            //content.delete(selectionStart, selectionEnd);
            //return true;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.968 -0400", hash_original_method = "AAA6731DEEEC720845223B285BF37660", hash_generated_method = "6ACB12A5B173C0E0500BB0D901F53509")
    private boolean deleteLine(View view, Editable content) {
        addTaint(content.getTaint());
        addTaint(view.getTaint());
        if(view instanceof TextView)        
        {
            final Layout layout = ((TextView) view).getLayout();
            if(layout != null)            
            {
                final int line = layout.getLineForOffset(Selection.getSelectionStart(content));
                final int start = layout.getLineStart(line);
                final int end = layout.getLineEnd(line);
                if(end != start)                
                {
                    content.delete(start, end);
                    boolean varB326B5062B2F0E69046810717534CB09_1640770389 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_116875309 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_116875309;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_556599581 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_316862213 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_316862213;
        // ---------- Original Method ----------
        //if (view instanceof TextView) {
            //final Layout layout = ((TextView) view).getLayout();
            //if (layout != null) {
                //final int line = layout.getLineForOffset(Selection.getSelectionStart(content));
                //final int start = layout.getLineStart(line);
                //final int end = layout.getLineEnd(line);
                //if (end != start) {
                    //content.delete(start, end);
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    static int makeTextContentType(Capitalize caps, boolean autoText) {
        int contentType = InputType.TYPE_CLASS_TEXT;
        switch (caps) {
            case CHARACTERS:
                contentType |= InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS;
                break;
            case WORDS:
                contentType |= InputType.TYPE_TEXT_FLAG_CAP_WORDS;
                break;
            case SENTENCES:
                contentType |= InputType.TYPE_TEXT_FLAG_CAP_SENTENCES;
                break;
        }
        if (autoText) {
            contentType |= InputType.TYPE_TEXT_FLAG_AUTO_CORRECT;
        }
        return contentType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.969 -0400", hash_original_method = "60BF1BEA0D6A99B2655081BEC42DA13C", hash_generated_method = "9AF08A096C4DB7BB8B84A9E10D248858")
    public boolean onKeyDown(View view, Editable content,
                             int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(content.getTaint());
        addTaint(view.getTaint());
        boolean handled;
switch(keyCode){
        case KeyEvent.KEYCODE_DEL:
        handled = backspace(view, content, keyCode, event);
        break;
        case KeyEvent.KEYCODE_FORWARD_DEL:
        handled = forwardDelete(view, content, keyCode, event);
        break;
        default:
        handled = false;
        break;
}        if(handled)        
        {
            adjustMetaAfterKeypress(content);
        } //End block
        boolean var5F21C6842D9E32D23C5A1CD0B3EB473F_2042146712 = (super.onKeyDown(view, content, keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_992934866 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_992934866;
        // ---------- Original Method ----------
        //boolean handled;
        //switch (keyCode) {
            //case KeyEvent.KEYCODE_DEL:
                //handled = backspace(view, content, keyCode, event);
                //break;
            //case KeyEvent.KEYCODE_FORWARD_DEL:
                //handled = forwardDelete(view, content, keyCode, event);
                //break;
            //default:
                //handled = false;
                //break;
        //}
        //if (handled) {
            //adjustMetaAfterKeypress(content);
        //}
        //return super.onKeyDown(view, content, keyCode, event);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.969 -0400", hash_original_method = "D291AC92E2A4746C8F1BADA03A5CE619", hash_generated_method = "5A43C17D4CED2BF70D95C871F390FF91")
    public boolean onKeyOther(View view, Editable content, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(content.getTaint());
        addTaint(view.getTaint());
        if(event.getAction() != KeyEvent.ACTION_MULTIPLE
                || event.getKeyCode() != KeyEvent.KEYCODE_UNKNOWN)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1879763929 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_895035571 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_895035571;
        } //End block
        int selectionStart = Selection.getSelectionStart(content);
        int selectionEnd = Selection.getSelectionEnd(content);
        if(selectionEnd < selectionStart)        
        {
            int temp = selectionEnd;
            selectionEnd = selectionStart;
            selectionStart = temp;
        } //End block
        CharSequence text = event.getCharacters();
        if(text == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_766047107 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_735961564 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_735961564;
        } //End block
        content.replace(selectionStart, selectionEnd, text);
        boolean varB326B5062B2F0E69046810717534CB09_1591311567 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_726563267 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_726563267;
        // ---------- Original Method ----------
        //if (event.getAction() != KeyEvent.ACTION_MULTIPLE
                //|| event.getKeyCode() != KeyEvent.KEYCODE_UNKNOWN) {
            //return false;
        //}
        //int selectionStart = Selection.getSelectionStart(content);
        //int selectionEnd = Selection.getSelectionEnd(content);
        //if (selectionEnd < selectionStart) {
            //int temp = selectionEnd;
            //selectionEnd = selectionStart;
            //selectionStart = temp;
        //}
        //CharSequence text = event.getCharacters();
        //if (text == null) {
            //return false;
        //}
        //content.replace(selectionStart, selectionEnd, text);
        //return true;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.969 -0400", hash_original_field = "57D022DD9BDED0985347A59F06980BAE", hash_generated_field = "E30A96E800BF4F5D9EAF5982A378A4AE")

    static final Object OLD_SEL_START = new NoCopySpan.Concrete();
}


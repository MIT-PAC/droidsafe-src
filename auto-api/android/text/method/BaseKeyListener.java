package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.view.KeyEvent;
import android.view.View;
import android.text.*;
import android.text.method.TextKeyListener.Capitalize;
import android.widget.TextView;

public abstract class BaseKeyListener extends MetaKeyKeyListener implements KeyListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.170 -0400", hash_original_method = "659F82CDBE7177E080914B75F4A7355F", hash_generated_method = "659F82CDBE7177E080914B75F4A7355F")
        public BaseKeyListener ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.170 -0400", hash_original_method = "C743EFD1D596571F6949DCD9BEFE98FE", hash_generated_method = "3B63CDDF343E13D65260A0AC7DAB921C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean backspace(View view, Editable content, int keyCode, KeyEvent event) {
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        boolean var06D71D209D37463B723529ABB247AA4F_1596283964 = (backspaceOrForwardDelete(view, content, keyCode, event, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return backspaceOrForwardDelete(view, content, keyCode, event, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.170 -0400", hash_original_method = "44D414C093A103E2D46C2C9EBFB633B7", hash_generated_method = "D1D8CB04C0F5013F8F002B62FDDA081B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean forwardDelete(View view, Editable content, int keyCode, KeyEvent event) {
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        boolean var7BB3CCE6C4C7A22712598A498C7EF201_621009855 = (backspaceOrForwardDelete(view, content, keyCode, event, true));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return backspaceOrForwardDelete(view, content, keyCode, event, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.171 -0400", hash_original_method = "070DF95C0353A773EEB24BBDC2D8297C", hash_generated_method = "AD317D18CC0AE40396A61C329FF43B67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean backspaceOrForwardDelete(View view, Editable content, int keyCode,
            KeyEvent event, boolean isForwardDelete) {
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(isForwardDelete);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        {
            boolean varCA6B3D1AF11CE1BEC9D7DC5F2C261879_467673809 = (!KeyEvent.metaStateHasNoModifiers(event.getMetaState()
                & ~(KeyEvent.META_SHIFT_MASK | KeyEvent.META_ALT_MASK)));
        } //End collapsed parenthetic
        {
            boolean var3D908796E6EA03E235F38A1EF7D65D8D_1030886154 = (deleteSelection(view, content));
        } //End collapsed parenthetic
        {
            boolean varF6771C8194EBDCF344A000571F865701_537123494 = (event.isAltPressed() || getMetaState(content, META_ALT_ON) == 1);
            {
                {
                    boolean var2F2270AB3C28CCE369E4A20C44F4E64E_1648701383 = (deleteLine(view, content));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        int start;
        start = Selection.getSelectionEnd(content);
        int end;
        {
            boolean varA1638696581CB665742F614EE86553B6_411556868 = (isForwardDelete || event.isShiftPressed()
                || getMetaState(content, META_SHIFT_ON) == 1);
            {
                end = TextUtils.getOffsetAfter(content, start);
            } //End block
            {
                end = TextUtils.getOffsetBefore(content, start);
            } //End block
        } //End collapsed parenthetic
        {
            content.delete(Math.min(start, end), Math.max(start, end));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.172 -0400", hash_original_method = "2C36007D0B232577504AED53A81D7DC4", hash_generated_method = "68AD893C25F077D630996CC2F9ED1762")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean deleteSelection(View view, Editable content) {
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        int selectionStart;
        selectionStart = Selection.getSelectionStart(content);
        int selectionEnd;
        selectionEnd = Selection.getSelectionEnd(content);
        {
            int temp;
            temp = selectionEnd;
            selectionEnd = selectionStart;
            selectionStart = temp;
        } //End block
        {
            content.delete(selectionStart, selectionEnd);
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.173 -0400", hash_original_method = "AAA6731DEEEC720845223B285BF37660", hash_generated_method = "56339621AFE14C3C27DBF87D0CF85C16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean deleteLine(View view, Editable content) {
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        {
            Layout layout;
            layout = ((TextView) view).getLayout();
            {
                int line;
                line = layout.getLineForOffset(Selection.getSelectionStart(content));
                int start;
                start = layout.getLineStart(line);
                int end;
                end = layout.getLineEnd(line);
                {
                    content.delete(start, end);
                } //End block
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.174 -0400", hash_original_method = "60BF1BEA0D6A99B2655081BEC42DA13C", hash_generated_method = "3D1E4B41005F41894B3E65E6A7C362D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onKeyDown(View view, Editable content,
                             int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        boolean handled;
        //Begin case KeyEvent.KEYCODE_DEL 
        handled = backspace(view, content, keyCode, event);
        //End case KeyEvent.KEYCODE_DEL 
        //Begin case KeyEvent.KEYCODE_FORWARD_DEL 
        handled = forwardDelete(view, content, keyCode, event);
        //End case KeyEvent.KEYCODE_FORWARD_DEL 
        //Begin case default 
        handled = false;
        //End case default 
        {
            adjustMetaAfterKeypress(content);
        } //End block
        boolean var250B4652E205BB567180858BBC354846_1504836083 = (super.onKeyDown(view, content, keyCode, event));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.175 -0400", hash_original_method = "D291AC92E2A4746C8F1BADA03A5CE619", hash_generated_method = "0CC60017FCF527E094F516FF6E6320AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean onKeyOther(View view, Editable content, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(content.dsTaint);
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(view.dsTaint);
        {
            boolean var1A1FC70529DDD3D4CE5DC99BF8C3BD59_1599181774 = (event.getAction() != KeyEvent.ACTION_MULTIPLE
                || event.getKeyCode() != KeyEvent.KEYCODE_UNKNOWN);
        } //End collapsed parenthetic
        int selectionStart;
        selectionStart = Selection.getSelectionStart(content);
        int selectionEnd;
        selectionEnd = Selection.getSelectionEnd(content);
        {
            int temp;
            temp = selectionEnd;
            selectionEnd = selectionStart;
            selectionStart = temp;
        } //End block
        CharSequence text;
        text = event.getCharacters();
        content.replace(selectionStart, selectionEnd, text);
        return dsTaint.getTaintBoolean();
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

    
    static final Object OLD_SEL_START = new NoCopySpan.Concrete();
}


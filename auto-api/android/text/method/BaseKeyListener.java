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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.973 -0400", hash_original_method = "457D2BEC00B20336593EA76F83128980", hash_generated_method = "457D2BEC00B20336593EA76F83128980")
    public BaseKeyListener ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.973 -0400", hash_original_method = "C743EFD1D596571F6949DCD9BEFE98FE", hash_generated_method = "B278F534AD9D5E40F4C973F4182250FB")
    public boolean backspace(View view, Editable content, int keyCode, KeyEvent event) {
        boolean var06D71D209D37463B723529ABB247AA4F_12323885 = (backspaceOrForwardDelete(view, content, keyCode, event, false));
        addTaint(view.getTaint());
        addTaint(content.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1430576131 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1430576131;
        // ---------- Original Method ----------
        //return backspaceOrForwardDelete(view, content, keyCode, event, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.974 -0400", hash_original_method = "44D414C093A103E2D46C2C9EBFB633B7", hash_generated_method = "CE0FE78838709A1DD84D26DD67606299")
    public boolean forwardDelete(View view, Editable content, int keyCode, KeyEvent event) {
        boolean var7BB3CCE6C4C7A22712598A498C7EF201_870709076 = (backspaceOrForwardDelete(view, content, keyCode, event, true));
        addTaint(view.getTaint());
        addTaint(content.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1118176399 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1118176399;
        // ---------- Original Method ----------
        //return backspaceOrForwardDelete(view, content, keyCode, event, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.974 -0400", hash_original_method = "070DF95C0353A773EEB24BBDC2D8297C", hash_generated_method = "C86FF5E5DE0342D805253199A76F679B")
    private boolean backspaceOrForwardDelete(View view, Editable content, int keyCode,
            KeyEvent event, boolean isForwardDelete) {
        {
            boolean varCA6B3D1AF11CE1BEC9D7DC5F2C261879_1450715966 = (!KeyEvent.metaStateHasNoModifiers(event.getMetaState()
                & ~(KeyEvent.META_SHIFT_MASK | KeyEvent.META_ALT_MASK)));
        } //End collapsed parenthetic
        {
            boolean var3D908796E6EA03E235F38A1EF7D65D8D_311698220 = (deleteSelection(view, content));
        } //End collapsed parenthetic
        {
            boolean varF6771C8194EBDCF344A000571F865701_1840829348 = (event.isAltPressed() || getMetaState(content, META_ALT_ON) == 1);
            {
                {
                    boolean var2F2270AB3C28CCE369E4A20C44F4E64E_1021750393 = (deleteLine(view, content));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        final int start = Selection.getSelectionEnd(content);
        int end;
        {
            boolean varA1638696581CB665742F614EE86553B6_1036187489 = (isForwardDelete || event.isShiftPressed()
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
        addTaint(view.getTaint());
        addTaint(content.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        addTaint(isForwardDelete);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_560715572 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_560715572;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.975 -0400", hash_original_method = "2C36007D0B232577504AED53A81D7DC4", hash_generated_method = "B6372395C47DA4F304E7B748EC3F5FB5")
    private boolean deleteSelection(View view, Editable content) {
        int selectionStart = Selection.getSelectionStart(content);
        int selectionEnd = Selection.getSelectionEnd(content);
        {
            int temp = selectionEnd;
            selectionEnd = selectionStart;
            selectionStart = temp;
        } //End block
        {
            content.delete(selectionStart, selectionEnd);
        } //End block
        addTaint(view.getTaint());
        addTaint(content.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1101223158 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1101223158;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.975 -0400", hash_original_method = "AAA6731DEEEC720845223B285BF37660", hash_generated_method = "F7DF67C0D9636C4431493FCDBC92FEE5")
    private boolean deleteLine(View view, Editable content) {
        {
            final Layout layout = ((TextView) view).getLayout();
            {
                final int line = layout.getLineForOffset(Selection.getSelectionStart(content));
                final int start = layout.getLineStart(line);
                final int end = layout.getLineEnd(line);
                {
                    content.delete(start, end);
                } //End block
            } //End block
        } //End block
        addTaint(view.getTaint());
        addTaint(content.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_406873017 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_406873017;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.977 -0400", hash_original_method = "60BF1BEA0D6A99B2655081BEC42DA13C", hash_generated_method = "210C15EFF2E394CA3FF7D3F1367C27AE")
    public boolean onKeyDown(View view, Editable content,
                             int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        boolean var250B4652E205BB567180858BBC354846_713352614 = (super.onKeyDown(view, content, keyCode, event));
        addTaint(view.getTaint());
        addTaint(content.getTaint());
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_972711452 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_972711452;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.977 -0400", hash_original_method = "D291AC92E2A4746C8F1BADA03A5CE619", hash_generated_method = "1BFEE31216F644B4A9103B77BAC2B1AA")
    public boolean onKeyOther(View view, Editable content, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var1A1FC70529DDD3D4CE5DC99BF8C3BD59_1870049944 = (event.getAction() != KeyEvent.ACTION_MULTIPLE
                || event.getKeyCode() != KeyEvent.KEYCODE_UNKNOWN);
        } //End collapsed parenthetic
        int selectionStart = Selection.getSelectionStart(content);
        int selectionEnd = Selection.getSelectionEnd(content);
        {
            int temp = selectionEnd;
            selectionEnd = selectionStart;
            selectionStart = temp;
        } //End block
        CharSequence text = event.getCharacters();
        content.replace(selectionStart, selectionEnd, text);
        addTaint(view.getTaint());
        addTaint(content.getTaint());
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1973397237 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1973397237;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.977 -0400", hash_original_field = "57D022DD9BDED0985347A59F06980BAE", hash_generated_field = "E30A96E800BF4F5D9EAF5982A378A4AE")

    static final Object OLD_SEL_START = new NoCopySpan.Concrete();
}


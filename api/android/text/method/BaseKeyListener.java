package android.text.method;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.text.Editable;
import android.text.InputType;
import android.text.Layout;
import android.text.NoCopySpan;
import android.text.Selection;
import android.text.TextUtils;
import android.text.method.TextKeyListener.Capitalize;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;





public abstract class BaseKeyListener extends MetaKeyKeyListener implements KeyListener {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:49.736 -0500", hash_original_method = "2C46F71A06421C2378BF9E5CFE2574AE", hash_generated_method = "7AE5698047C4FAB53B7E2B37A6289C2D")
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:49.731 -0500", hash_original_field = "DF6FFF71E95A22B6D27B0C7B334C0DF0", hash_generated_field = "E30A96E800BF4F5D9EAF5982A378A4AE")
 static final Object OLD_SEL_START = new NoCopySpan.Concrete();
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:38.945 -0400", hash_original_method = "457D2BEC00B20336593EA76F83128980", hash_generated_method = "457D2BEC00B20336593EA76F83128980")
    public BaseKeyListener ()
    {
        //Synthesized constructor
    }

    /**
     * Performs the action that happens when you press the {@link KeyEvent#KEYCODE_DEL} key in
     * a {@link TextView}.  If there is a selection, deletes the selection; otherwise,
     * deletes the character before the cursor, if any; ALT+DEL deletes everything on
     * the line the cursor is on.
     *
     * @return true if anything was deleted; false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:49.731 -0500", hash_original_method = "C743EFD1D596571F6949DCD9BEFE98FE", hash_generated_method = "FEC8D779F4C4042D36C0F36EBDA08029")
    public boolean backspace(View view, Editable content, int keyCode, KeyEvent event) {
        return backspaceOrForwardDelete(view, content, keyCode, event, false);
    }

    /**
     * Performs the action that happens when you press the {@link KeyEvent#KEYCODE_FORWARD_DEL}
     * key in a {@link TextView}.  If there is a selection, deletes the selection; otherwise,
     * deletes the character before the cursor, if any; ALT+FORWARD_DEL deletes everything on
     * the line the cursor is on.
     *
     * @return true if anything was deleted; false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:49.732 -0500", hash_original_method = "44D414C093A103E2D46C2C9EBFB633B7", hash_generated_method = "C9A7237C1E399A37E60EB19B6D52D19F")
    public boolean forwardDelete(View view, Editable content, int keyCode, KeyEvent event) {
        return backspaceOrForwardDelete(view, content, keyCode, event, true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:49.733 -0500", hash_original_method = "070DF95C0353A773EEB24BBDC2D8297C", hash_generated_method = "5E34F6783E50CF98B6D366ABA5C8C50B")
    private boolean backspaceOrForwardDelete(View view, Editable content, int keyCode,
            KeyEvent event, boolean isForwardDelete) {
        // Ensure the key event does not have modifiers except ALT or SHIFT.
        if (!KeyEvent.metaStateHasNoModifiers(event.getMetaState()
                & ~(KeyEvent.META_SHIFT_MASK | KeyEvent.META_ALT_MASK))) {
            return false;
        }

        // If there is a current selection, delete it.
        if (deleteSelection(view, content)) {
            return true;
        }

        // Alt+Backspace or Alt+ForwardDelete deletes the current line, if possible.
        if (event.isAltPressed() || getMetaState(content, META_ALT_ON) == 1) {
            if (deleteLine(view, content)) {
                return true;
            }
        }

        // Delete a character.
        final int start = Selection.getSelectionEnd(content);
        final int end;
        if (isForwardDelete || event.isShiftPressed()
                || getMetaState(content, META_SHIFT_ON) == 1) {
            end = TextUtils.getOffsetAfter(content, start);
        } else {
            end = TextUtils.getOffsetBefore(content, start);
        }
        if (start != end) {
            content.delete(Math.min(start, end), Math.max(start, end));
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:49.734 -0500", hash_original_method = "2C36007D0B232577504AED53A81D7DC4", hash_generated_method = "6F2D55BD0D8644FD18676EB8FAA89F36")
    private boolean deleteSelection(View view, Editable content) {
        int selectionStart = Selection.getSelectionStart(content);
        int selectionEnd = Selection.getSelectionEnd(content);
        if (selectionEnd < selectionStart) {
            int temp = selectionEnd;
            selectionEnd = selectionStart;
            selectionStart = temp;
        }
        if (selectionStart != selectionEnd) {
            content.delete(selectionStart, selectionEnd);
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:49.735 -0500", hash_original_method = "AAA6731DEEEC720845223B285BF37660", hash_generated_method = "2F93290EBB00EC6975F8AB620FEE88FD")
    private boolean deleteLine(View view, Editable content) {
        if (view instanceof TextView) {
            final Layout layout = ((TextView) view).getLayout();
            if (layout != null) {
                final int line = layout.getLineForOffset(Selection.getSelectionStart(content));
                final int start = layout.getLineStart(line);
                final int end = layout.getLineEnd(line);
                if (end != start) {
                    content.delete(start, end);
                    return true;
                }
            }
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:49.737 -0500", hash_original_method = "60BF1BEA0D6A99B2655081BEC42DA13C", hash_generated_method = "7BD99B6E87DE870A2B35A26A9C6BE037")
    public boolean onKeyDown(View view, Editable content,
                             int keyCode, KeyEvent event) {
        boolean handled;
        switch (keyCode) {
            case KeyEvent.KEYCODE_DEL:
                handled = backspace(view, content, keyCode, event);
                break;
            case KeyEvent.KEYCODE_FORWARD_DEL:
                handled = forwardDelete(view, content, keyCode, event);
                break;
            default:
                handled = false;
                break;
        }

        if (handled) {
            adjustMetaAfterKeypress(content);
        }

        return super.onKeyDown(view, content, keyCode, event);
    }

    /**
     * Base implementation handles ACTION_MULTIPLE KEYCODE_UNKNOWN by inserting
     * the event's text into the content.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:49.738 -0500", hash_original_method = "D291AC92E2A4746C8F1BADA03A5CE619", hash_generated_method = "D27DB6A3FB1E267AFA875190E06BE0A1")
    public boolean onKeyOther(View view, Editable content, KeyEvent event) {
        if (event.getAction() != KeyEvent.ACTION_MULTIPLE
                || event.getKeyCode() != KeyEvent.KEYCODE_UNKNOWN) {
            // Not something we are interested in.
            return false;
        }

        int selectionStart = Selection.getSelectionStart(content);
        int selectionEnd = Selection.getSelectionEnd(content);
        if (selectionEnd < selectionStart) {
            int temp = selectionEnd;
            selectionEnd = selectionStart;
            selectionStart = temp;
        }

        CharSequence text = event.getCharacters();
        if (text == null) {
            return false;
        }

        content.replace(selectionStart, selectionEnd, text);
        return true;
    }
}


package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spanned;
import android.text.method.KeyListener;
import android.text.style.SuggestionSpan;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.widget.TextView;





public class EditableInputConnection extends BaseInputConnection {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.601 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.603 -0500", hash_original_field = "F1175B906DA017CE2F4D12AE0F63BECA", hash_generated_field = "92EE8EAF5607AA81AF30E4A149536DEE")

    private static final String TAG = "EditableInputConnection";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.605 -0500", hash_original_field = "49AF0A2A014C0E7F98E27CA30429A8B6", hash_generated_field = "B044D5C32398EDC8D922234EFA4F1DF3")


    private  TextView mTextView;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.608 -0500", hash_original_method = "48AFA0A031D991327826B99C24590A71", hash_generated_method = "46AD4CBDC5729D88971A9845C96156CF")
    
public EditableInputConnection(TextView textview) {
        super(textview, true);
        mTextView = textview;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.611 -0500", hash_original_method = "79431EAAD385E82AA03E24E6CD9A3769", hash_generated_method = "7935515E12FD97D1BDB3547472C93F41")
    
@Override
    public Editable getEditable() {
        TextView tv = mTextView;
        if (tv != null) {
            return tv.getEditableText();
        }
        return null;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.614 -0500", hash_original_method = "47A7176B3179FC9D2FE377D6B6F09D07", hash_generated_method = "12B19D16246B1AAF2772D35C88C3D606")
    
@Override
    public boolean beginBatchEdit() {
        mTextView.beginBatchEdit();
        return true;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.616 -0500", hash_original_method = "2B85862E44056949DE76AFB5C9725EFA", hash_generated_method = "A563B07D459974635608D9C6020F9835")
    
@Override
    public boolean endBatchEdit() {
        mTextView.endBatchEdit();
        return true;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.618 -0500", hash_original_method = "963E6A0CA86932C8F9D879DC40F2C809", hash_generated_method = "86C65C8CDD7D2743B8BC747582CA08D2")
    
@Override
    public boolean clearMetaKeyStates(int states) {
        final Editable content = getEditable();
        if (content == null) return false;
        KeyListener kl = mTextView.getKeyListener();
        if (kl != null) {
            try {
                kl.clearMetaKeyState(mTextView, content, states);
            } catch (AbstractMethodError e) {
                // This is an old listener that doesn't implement the
                // new method.
            }
        }
        return true;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.621 -0500", hash_original_method = "120BCC39A19E9D48E7D09303ED2ED952", hash_generated_method = "74CC2BC9169584E39F8751DD0EF7AE09")
    
@Override
    public boolean commitCompletion(CompletionInfo text) {
        if (DEBUG) Log.v(TAG, "commitCompletion " + text);
        mTextView.beginBatchEdit();
        mTextView.onCommitCompletion(text);
        mTextView.endBatchEdit();
        return true;
    }

    /**
     * Calls the {@link TextView#onCommitCorrection} method of the associated TextView.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.623 -0500", hash_original_method = "DB06BCD96079AC12D626255A3932F1C1", hash_generated_method = "8550311FB925F6E5452CF243B96F5889")
    
@Override
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        if (DEBUG) Log.v(TAG, "commitCorrection" + correctionInfo);
        mTextView.beginBatchEdit();
        mTextView.onCommitCorrection(correctionInfo);
        mTextView.endBatchEdit();
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.626 -0500", hash_original_method = "E62B789941F8A63BCC6EB7B832B68D0F", hash_generated_method = "BBFFF4D23FC889AE2E2994E5198DC34D")
    
@Override
    public boolean performEditorAction(int actionCode) {
        if (DEBUG) Log.v(TAG, "performEditorAction " + actionCode);
        mTextView.onEditorAction(actionCode);
        return true;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.628 -0500", hash_original_method = "7AF0006D10C2DF24946CEF4909222B3C", hash_generated_method = "EB398ECAF5FD6B44665F7308B30094FE")
    
@Override
    public boolean performContextMenuAction(int id) {
        if (DEBUG) Log.v(TAG, "performContextMenuAction " + id);
        mTextView.beginBatchEdit();
        mTextView.onTextContextMenuItem(id);
        mTextView.endBatchEdit();
        return true;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.631 -0500", hash_original_method = "1D36BC67F0D3E0E821622DAE101B8DA4", hash_generated_method = "2E76C79910E20053FDD65673A972F600")
    
@Override
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        if (mTextView != null) {
            ExtractedText et = new ExtractedText();
            if (mTextView.extractText(request, et)) {
                if ((flags&GET_EXTRACTED_TEXT_MONITOR) != 0) {
                    mTextView.setExtracting(request);
                }
                return et;
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.633 -0500", hash_original_method = "66E210A03F4A51E56AF5DC1352B2E636", hash_generated_method = "5373AD6F815FF1B99BFC09B0A933AF20")
    
@Override
    public boolean performPrivateCommand(String action, Bundle data) {
        mTextView.onPrivateIMECommand(action, data);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:44.636 -0500", hash_original_method = "ED478A4EB972D41E370E9603327B3839", hash_generated_method = "61CE22BB2E31AC6CCD0D7C1E9246168A")
    
@Override
    public boolean commitText(CharSequence text, int newCursorPosition) {
        if (mTextView == null) {
            return super.commitText(text, newCursorPosition);
        }
        if (text instanceof Spanned) {
            Spanned spanned = ((Spanned) text);
            SuggestionSpan[] spans = spanned.getSpans(0, text.length(), SuggestionSpan.class);
            mIMM.registerSuggestionSpansForNotification(spans);
        }

        mTextView.resetErrorChangedFlag();
        boolean success = super.commitText(text, newCursorPosition);
        mTextView.hideErrorIfUnchanged();

        return success;
    }
}


package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spanned;
import android.text.method.KeyListener;
import android.text.style.SuggestionSpan;
import android.util.Log;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.widget.TextView;

public class EditableInputConnection extends BaseInputConnection {
    private TextView mTextView;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.058 -0400", hash_original_method = "48AFA0A031D991327826B99C24590A71", hash_generated_method = "2CC8E11F7AD5F1F91C136A093D7D5C07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EditableInputConnection(TextView textview) {
        super(textview, true);
        dsTaint.addTaint(textview.dsTaint);
        // ---------- Original Method ----------
        //mTextView = textview;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.059 -0400", hash_original_method = "79431EAAD385E82AA03E24E6CD9A3769", hash_generated_method = "BAA9ACA44BF92A20BD870B1B3602B432")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Editable getEditable() {
        TextView tv;
        tv = mTextView;
        {
            Editable var7C838A82FB3EB1C366457C870F02262D_1388975281 = (tv.getEditableText());
        } //End block
        return (Editable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //TextView tv = mTextView;
        //if (tv != null) {
            //return tv.getEditableText();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.059 -0400", hash_original_method = "47A7176B3179FC9D2FE377D6B6F09D07", hash_generated_method = "F5C5CFE5B90FA90AD95062F2375E1FA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean beginBatchEdit() {
        mTextView.beginBatchEdit();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mTextView.beginBatchEdit();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.059 -0400", hash_original_method = "2B85862E44056949DE76AFB5C9725EFA", hash_generated_method = "20A70E974BFB334B8C378D5658AAFA62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean endBatchEdit() {
        mTextView.endBatchEdit();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mTextView.endBatchEdit();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.059 -0400", hash_original_method = "963E6A0CA86932C8F9D879DC40F2C809", hash_generated_method = "DB41688766DF18381FBD21FA7DB3FEAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean clearMetaKeyStates(int states) {
        dsTaint.addTaint(states);
        Editable content;
        content = getEditable();
        KeyListener kl;
        kl = mTextView.getKeyListener();
        {
            try 
            {
                kl.clearMetaKeyState(mTextView, content, states);
            } //End block
            catch (AbstractMethodError e)
            { }
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final Editable content = getEditable();
        //if (content == null) return false;
        //KeyListener kl = mTextView.getKeyListener();
        //if (kl != null) {
            //try {
                //kl.clearMetaKeyState(mTextView, content, states);
            //} catch (AbstractMethodError e) {
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.059 -0400", hash_original_method = "120BCC39A19E9D48E7D09303ED2ED952", hash_generated_method = "5AD66039DC19604CCD712F41014940D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean commitCompletion(CompletionInfo text) {
        dsTaint.addTaint(text.dsTaint);
        mTextView.beginBatchEdit();
        mTextView.onCommitCompletion(text);
        mTextView.endBatchEdit();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "commitCompletion " + text);
        //mTextView.beginBatchEdit();
        //mTextView.onCommitCompletion(text);
        //mTextView.endBatchEdit();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.060 -0400", hash_original_method = "DB06BCD96079AC12D626255A3932F1C1", hash_generated_method = "C9D233E5DDF77038D7441F33622F1EFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        dsTaint.addTaint(correctionInfo.dsTaint);
        mTextView.beginBatchEdit();
        mTextView.onCommitCorrection(correctionInfo);
        mTextView.endBatchEdit();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "commitCorrection" + correctionInfo);
        //mTextView.beginBatchEdit();
        //mTextView.onCommitCorrection(correctionInfo);
        //mTextView.endBatchEdit();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.060 -0400", hash_original_method = "E62B789941F8A63BCC6EB7B832B68D0F", hash_generated_method = "B4F500D34CCCE10A1C6F7D3EC4C25923")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean performEditorAction(int actionCode) {
        dsTaint.addTaint(actionCode);
        mTextView.onEditorAction(actionCode);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "performEditorAction " + actionCode);
        //mTextView.onEditorAction(actionCode);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.060 -0400", hash_original_method = "7AF0006D10C2DF24946CEF4909222B3C", hash_generated_method = "5A67A37B098E9D398675A94F2230D65A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean performContextMenuAction(int id) {
        dsTaint.addTaint(id);
        mTextView.beginBatchEdit();
        mTextView.onTextContextMenuItem(id);
        mTextView.endBatchEdit();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "performContextMenuAction " + id);
        //mTextView.beginBatchEdit();
        //mTextView.onTextContextMenuItem(id);
        //mTextView.endBatchEdit();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.060 -0400", hash_original_method = "1D36BC67F0D3E0E821622DAE101B8DA4", hash_generated_method = "EB46036DC2ED2139D1ABC2F7DFCD27A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(request.dsTaint);
        {
            ExtractedText et;
            et = new ExtractedText();
            {
                boolean varFCEACA8CA5C40DCFCB2A18DA8BD5E901_416854267 = (mTextView.extractText(request, et));
                {
                    {
                        mTextView.setExtracting(request);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (ExtractedText)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mTextView != null) {
            //ExtractedText et = new ExtractedText();
            //if (mTextView.extractText(request, et)) {
                //if ((flags&GET_EXTRACTED_TEXT_MONITOR) != 0) {
                    //mTextView.setExtracting(request);
                //}
                //return et;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.060 -0400", hash_original_method = "66E210A03F4A51E56AF5DC1352B2E636", hash_generated_method = "656D7AE2D516994926A203B4A65D480F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean performPrivateCommand(String action, Bundle data) {
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(action);
        mTextView.onPrivateIMECommand(action, data);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mTextView.onPrivateIMECommand(action, data);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.061 -0400", hash_original_method = "ED478A4EB972D41E370E9603327B3839", hash_generated_method = "22699CECA90548ED5F05F3C08C4AE036")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean commitText(CharSequence text, int newCursorPosition) {
        dsTaint.addTaint(newCursorPosition);
        dsTaint.addTaint(text);
        {
            boolean var3232D6DBF4B95A9709C08EED7122DED2_1011906806 = (super.commitText(text, newCursorPosition));
        } //End block
        {
            Spanned spanned;
            spanned = ((Spanned) text);
            SuggestionSpan[] spans;
            spans = spanned.getSpans(0, text.length(), SuggestionSpan.class);
            mIMM.registerSuggestionSpansForNotification(spans);
        } //End block
        mTextView.resetErrorChangedFlag();
        boolean success;
        success = super.commitText(text, newCursorPosition);
        mTextView.hideErrorIfUnchanged();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mTextView == null) {
            //return super.commitText(text, newCursorPosition);
        //}
        //if (text instanceof Spanned) {
            //Spanned spanned = ((Spanned) text);
            //SuggestionSpan[] spans = spanned.getSpans(0, text.length(), SuggestionSpan.class);
            //mIMM.registerSuggestionSpansForNotification(spans);
        //}
        //mTextView.resetErrorChangedFlag();
        //boolean success = super.commitText(text, newCursorPosition);
        //mTextView.hideErrorIfUnchanged();
        //return success;
    }

    
    private static final boolean DEBUG = false;
    private static final String TAG = "EditableInputConnection";
}


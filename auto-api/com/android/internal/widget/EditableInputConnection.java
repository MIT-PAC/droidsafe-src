package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final boolean DEBUG = false;
    private static final String TAG = "EditableInputConnection";
    private final TextView mTextView;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.285 -0400", hash_original_method = "48AFA0A031D991327826B99C24590A71", hash_generated_method = "E82AF7570553EF5539CB6CE45EF07D81")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EditableInputConnection(TextView textview) {
        super(textview, true);
        dsTaint.addTaint(textview.dsTaint);
        // ---------- Original Method ----------
        //mTextView = textview;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.285 -0400", hash_original_method = "79431EAAD385E82AA03E24E6CD9A3769", hash_generated_method = "E1B54D184A97FA668D74710B028671E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Editable getEditable() {
        TextView tv;
        tv = mTextView;
        {
            Editable var7C838A82FB3EB1C366457C870F02262D_918433065 = (tv.getEditableText());
        } //End block
        return (Editable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //TextView tv = mTextView;
        //if (tv != null) {
            //return tv.getEditableText();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.285 -0400", hash_original_method = "47A7176B3179FC9D2FE377D6B6F09D07", hash_generated_method = "3A7C56F791B8902FBC75EA59064EBF80")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean beginBatchEdit() {
        mTextView.beginBatchEdit();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mTextView.beginBatchEdit();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.285 -0400", hash_original_method = "2B85862E44056949DE76AFB5C9725EFA", hash_generated_method = "5DA863B413D5DF81D16C48336B8EF54C")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean endBatchEdit() {
        mTextView.endBatchEdit();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mTextView.endBatchEdit();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.285 -0400", hash_original_method = "963E6A0CA86932C8F9D879DC40F2C809", hash_generated_method = "DEE35AFC028D735DF36091D86394B906")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean clearMetaKeyStates(int states) {
        dsTaint.addTaint(states);
        final Editable content;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.285 -0400", hash_original_method = "120BCC39A19E9D48E7D09303ED2ED952", hash_generated_method = "F51E2A11F5E4A7CC80298D6B86E86AE0")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.286 -0400", hash_original_method = "DB06BCD96079AC12D626255A3932F1C1", hash_generated_method = "DB6A1DA15AF613A9C03C1F68969129C8")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.286 -0400", hash_original_method = "E62B789941F8A63BCC6EB7B832B68D0F", hash_generated_method = "6ABC21FA940CB88B2C41559FD2CBDE5B")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.286 -0400", hash_original_method = "7AF0006D10C2DF24946CEF4909222B3C", hash_generated_method = "23302C206108BB3E262572383BA1879D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.286 -0400", hash_original_method = "1D36BC67F0D3E0E821622DAE101B8DA4", hash_generated_method = "DEA0FBA884AF17729CBE564E344FA201")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(request.dsTaint);
        {
            ExtractedText et;
            et = new ExtractedText();
            {
                boolean varFCEACA8CA5C40DCFCB2A18DA8BD5E901_2115315999 = (mTextView.extractText(request, et));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.286 -0400", hash_original_method = "66E210A03F4A51E56AF5DC1352B2E636", hash_generated_method = "8421FC29B8E269CD81F519F2F0E6955E")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean performPrivateCommand(String action, Bundle data) {
        dsTaint.addTaint(action);
        dsTaint.addTaint(data.dsTaint);
        mTextView.onPrivateIMECommand(action, data);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //mTextView.onPrivateIMECommand(action, data);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.286 -0400", hash_original_method = "ED478A4EB972D41E370E9603327B3839", hash_generated_method = "C342110DA9B60A68ED7AEC14EB99DC8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean commitText(CharSequence text, int newCursorPosition) {
        dsTaint.addTaint(newCursorPosition);
        dsTaint.addTaint(text);
        {
            boolean var3232D6DBF4B95A9709C08EED7122DED2_124706778 = (super.commitText(text, newCursorPosition));
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

    
}



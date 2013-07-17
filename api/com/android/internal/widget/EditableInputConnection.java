package com.android.internal.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.081 -0400", hash_original_field = "59FFF1360E9B57BB348C2BF9F881659F", hash_generated_field = "B044D5C32398EDC8D922234EFA4F1DF3")

    private TextView mTextView;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.081 -0400", hash_original_method = "48AFA0A031D991327826B99C24590A71", hash_generated_method = "F5E7C121122B9E0DC720A281B65F78CC")
    public  EditableInputConnection(TextView textview) {
        super(textview, true);
        mTextView = textview;
        // ---------- Original Method ----------
        //mTextView = textview;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.081 -0400", hash_original_method = "79431EAAD385E82AA03E24E6CD9A3769", hash_generated_method = "FAE5CCD74A10B96749E58F3BC7210FA8")
    @Override
    public Editable getEditable() {
        TextView tv = mTextView;
        if(tv != null)        
        {
Editable var926C39DFB39EF3B61F16708BD5980917_422210889 =             tv.getEditableText();
            var926C39DFB39EF3B61F16708BD5980917_422210889.addTaint(taint);
            return var926C39DFB39EF3B61F16708BD5980917_422210889;
        } //End block
Editable var540C13E9E156B687226421B24F2DF178_1270324716 =         null;
        var540C13E9E156B687226421B24F2DF178_1270324716.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1270324716;
        // ---------- Original Method ----------
        //TextView tv = mTextView;
        //if (tv != null) {
            //return tv.getEditableText();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.081 -0400", hash_original_method = "47A7176B3179FC9D2FE377D6B6F09D07", hash_generated_method = "984F0895FE0B94C0DBEB82380235A491")
    @Override
    public boolean beginBatchEdit() {
        mTextView.beginBatchEdit();
        boolean varB326B5062B2F0E69046810717534CB09_2111077991 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_212336685 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_212336685;
        // ---------- Original Method ----------
        //mTextView.beginBatchEdit();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.081 -0400", hash_original_method = "2B85862E44056949DE76AFB5C9725EFA", hash_generated_method = "30FF151B98F9A40D18F22D23711EE5BC")
    @Override
    public boolean endBatchEdit() {
        mTextView.endBatchEdit();
        boolean varB326B5062B2F0E69046810717534CB09_2101915004 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_199348449 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_199348449;
        // ---------- Original Method ----------
        //mTextView.endBatchEdit();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.082 -0400", hash_original_method = "963E6A0CA86932C8F9D879DC40F2C809", hash_generated_method = "CFC264C17A05A895170231C1206A3C27")
    @Override
    public boolean clearMetaKeyStates(int states) {
        addTaint(states);
        final Editable content = getEditable();
        if(content == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_958777828 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1732159764 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1732159764;
        }
        KeyListener kl = mTextView.getKeyListener();
        if(kl != null)        
        {
            try 
            {
                kl.clearMetaKeyState(mTextView, content, states);
            } //End block
            catch (AbstractMethodError e)
            {
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1049799160 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1550783795 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1550783795;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.082 -0400", hash_original_method = "120BCC39A19E9D48E7D09303ED2ED952", hash_generated_method = "C67DAC3D65C11D2F04272A79882BACC0")
    @Override
    public boolean commitCompletion(CompletionInfo text) {
        addTaint(text.getTaint());
        if(DEBUG){ }        mTextView.beginBatchEdit();
        mTextView.onCommitCompletion(text);
        mTextView.endBatchEdit();
        boolean varB326B5062B2F0E69046810717534CB09_1735625903 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_388667328 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_388667328;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "commitCompletion " + text);
        //mTextView.beginBatchEdit();
        //mTextView.onCommitCompletion(text);
        //mTextView.endBatchEdit();
        //return true;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.082 -0400", hash_original_method = "DB06BCD96079AC12D626255A3932F1C1", hash_generated_method = "6C54B1123C1AEE462A7CEA27A85869FD")
    @Override
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        addTaint(correctionInfo.getTaint());
        if(DEBUG){ }        mTextView.beginBatchEdit();
        mTextView.onCommitCorrection(correctionInfo);
        mTextView.endBatchEdit();
        boolean varB326B5062B2F0E69046810717534CB09_952570211 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1036473693 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1036473693;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "commitCorrection" + correctionInfo);
        //mTextView.beginBatchEdit();
        //mTextView.onCommitCorrection(correctionInfo);
        //mTextView.endBatchEdit();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.082 -0400", hash_original_method = "E62B789941F8A63BCC6EB7B832B68D0F", hash_generated_method = "85B40B6583ECB622F7ECE604F2C919C8")
    @Override
    public boolean performEditorAction(int actionCode) {
        addTaint(actionCode);
        if(DEBUG){ }        mTextView.onEditorAction(actionCode);
        boolean varB326B5062B2F0E69046810717534CB09_1434265761 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_974722284 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_974722284;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "performEditorAction " + actionCode);
        //mTextView.onEditorAction(actionCode);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.082 -0400", hash_original_method = "7AF0006D10C2DF24946CEF4909222B3C", hash_generated_method = "5542E35589DDAA50963FC7AB6DC33A51")
    @Override
    public boolean performContextMenuAction(int id) {
        addTaint(id);
        if(DEBUG){ }        mTextView.beginBatchEdit();
        mTextView.onTextContextMenuItem(id);
        mTextView.endBatchEdit();
        boolean varB326B5062B2F0E69046810717534CB09_422870598 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_66247870 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_66247870;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "performContextMenuAction " + id);
        //mTextView.beginBatchEdit();
        //mTextView.onTextContextMenuItem(id);
        //mTextView.endBatchEdit();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.082 -0400", hash_original_method = "1D36BC67F0D3E0E821622DAE101B8DA4", hash_generated_method = "6C92F16BBA8FC572B3002665A53171C8")
    @Override
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        addTaint(flags);
        addTaint(request.getTaint());
        if(mTextView != null)        
        {
            ExtractedText et = new ExtractedText();
            if(mTextView.extractText(request, et))            
            {
                if((flags&GET_EXTRACTED_TEXT_MONITOR) != 0)                
                {
                    mTextView.setExtracting(request);
                } //End block
ExtractedText varF4C7021EB2647C5C7DCF2D3426CCC9E4_497083829 =                 et;
                varF4C7021EB2647C5C7DCF2D3426CCC9E4_497083829.addTaint(taint);
                return varF4C7021EB2647C5C7DCF2D3426CCC9E4_497083829;
            } //End block
        } //End block
ExtractedText var540C13E9E156B687226421B24F2DF178_1074419778 =         null;
        var540C13E9E156B687226421B24F2DF178_1074419778.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1074419778;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.082 -0400", hash_original_method = "66E210A03F4A51E56AF5DC1352B2E636", hash_generated_method = "C12EBB9A0BB282C2D7330BC78C549074")
    @Override
    public boolean performPrivateCommand(String action, Bundle data) {
        addTaint(data.getTaint());
        addTaint(action.getTaint());
        mTextView.onPrivateIMECommand(action, data);
        boolean varB326B5062B2F0E69046810717534CB09_1588366158 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1526058701 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1526058701;
        // ---------- Original Method ----------
        //mTextView.onPrivateIMECommand(action, data);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.083 -0400", hash_original_method = "ED478A4EB972D41E370E9603327B3839", hash_generated_method = "58D983A47DD74AFD69A0BD16334B2855")
    @Override
    public boolean commitText(CharSequence text, int newCursorPosition) {
        addTaint(newCursorPosition);
        addTaint(text.getTaint());
        if(mTextView == null)        
        {
            boolean var324A71B312F90BDF4597B60B4168456C_310003261 = (super.commitText(text, newCursorPosition));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1188832100 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1188832100;
        } //End block
        if(text instanceof Spanned)        
        {
            Spanned spanned = ((Spanned) text);
            SuggestionSpan[] spans = spanned.getSpans(0, text.length(), SuggestionSpan.class);
            mIMM.registerSuggestionSpansForNotification(spans);
        } //End block
        mTextView.resetErrorChangedFlag();
        boolean success = super.commitText(text, newCursorPosition);
        mTextView.hideErrorIfUnchanged();
        boolean var260CA9DD8A4577FC00B7BD5810298076_2065540389 = (success);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_589052739 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_589052739;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.083 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.083 -0400", hash_original_field = "85062B0FE43FE953F5DABC7BCDD4C5BC", hash_generated_field = "92EE8EAF5607AA81AF30E4A149536DEE")

    private static final String TAG = "EditableInputConnection";
}


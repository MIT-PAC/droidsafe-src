package com.android.internal.widget;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.052 -0400", hash_original_field = "59FFF1360E9B57BB348C2BF9F881659F", hash_generated_field = "B044D5C32398EDC8D922234EFA4F1DF3")

    private TextView mTextView;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.052 -0400", hash_original_method = "48AFA0A031D991327826B99C24590A71", hash_generated_method = "F5E7C121122B9E0DC720A281B65F78CC")
    public  EditableInputConnection(TextView textview) {
        super(textview, true);
        mTextView = textview;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.052 -0400", hash_original_method = "79431EAAD385E82AA03E24E6CD9A3769", hash_generated_method = "F254491ED635F0E53536FE3CA9F2A212")
    @Override
    public Editable getEditable() {
        TextView tv = mTextView;
    if(tv != null)        
        {
Editable var926C39DFB39EF3B61F16708BD5980917_1984798451 =             tv.getEditableText();
            var926C39DFB39EF3B61F16708BD5980917_1984798451.addTaint(taint);
            return var926C39DFB39EF3B61F16708BD5980917_1984798451;
        } 
Editable var540C13E9E156B687226421B24F2DF178_1563661140 =         null;
        var540C13E9E156B687226421B24F2DF178_1563661140.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1563661140;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.052 -0400", hash_original_method = "47A7176B3179FC9D2FE377D6B6F09D07", hash_generated_method = "7D70F76961836FF39114D3FEBE9840C5")
    @Override
    public boolean beginBatchEdit() {
        mTextView.beginBatchEdit();
        boolean varB326B5062B2F0E69046810717534CB09_902394763 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2053853518 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2053853518;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.052 -0400", hash_original_method = "2B85862E44056949DE76AFB5C9725EFA", hash_generated_method = "F0975F1FF8D4BC0AF56BB1AF00648DB3")
    @Override
    public boolean endBatchEdit() {
        mTextView.endBatchEdit();
        boolean varB326B5062B2F0E69046810717534CB09_1080015372 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_155344175 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_155344175;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.053 -0400", hash_original_method = "963E6A0CA86932C8F9D879DC40F2C809", hash_generated_method = "F74126D34A276F4AEB4570E1BC9B92AF")
    @Override
    public boolean clearMetaKeyStates(int states) {
        addTaint(states);
        final Editable content = getEditable();
    if(content == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1737324168 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_32050562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_32050562;
        }
        KeyListener kl = mTextView.getKeyListener();
    if(kl != null)        
        {
            try 
            {
                kl.clearMetaKeyState(mTextView, content, states);
            } 
            catch (AbstractMethodError e)
            {
            } 
        } 
        boolean varB326B5062B2F0E69046810717534CB09_1680078028 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1687523671 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1687523671;
        
        
        
        
        
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.053 -0400", hash_original_method = "120BCC39A19E9D48E7D09303ED2ED952", hash_generated_method = "F85F834CAD70863A59B591F7ACDECD2A")
    @Override
    public boolean commitCompletion(CompletionInfo text) {
        addTaint(text.getTaint());
    if(DEBUG){ }        mTextView.beginBatchEdit();
        mTextView.onCommitCompletion(text);
        mTextView.endBatchEdit();
        boolean varB326B5062B2F0E69046810717534CB09_947694246 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1155089244 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1155089244;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.053 -0400", hash_original_method = "DB06BCD96079AC12D626255A3932F1C1", hash_generated_method = "0D01EF3775943DA3514034DB8F3B3423")
    @Override
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        addTaint(correctionInfo.getTaint());
    if(DEBUG){ }        mTextView.beginBatchEdit();
        mTextView.onCommitCorrection(correctionInfo);
        mTextView.endBatchEdit();
        boolean varB326B5062B2F0E69046810717534CB09_1282142925 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_315236708 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_315236708;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.053 -0400", hash_original_method = "E62B789941F8A63BCC6EB7B832B68D0F", hash_generated_method = "2D3B6D37A9A8A1D2BF168DAD700E0DE1")
    @Override
    public boolean performEditorAction(int actionCode) {
        addTaint(actionCode);
    if(DEBUG){ }        mTextView.onEditorAction(actionCode);
        boolean varB326B5062B2F0E69046810717534CB09_2051982142 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1858557865 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1858557865;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.053 -0400", hash_original_method = "7AF0006D10C2DF24946CEF4909222B3C", hash_generated_method = "C0391549F8AC06E4C419BC3586B022E5")
    @Override
    public boolean performContextMenuAction(int id) {
        addTaint(id);
    if(DEBUG){ }        mTextView.beginBatchEdit();
        mTextView.onTextContextMenuItem(id);
        mTextView.endBatchEdit();
        boolean varB326B5062B2F0E69046810717534CB09_276753497 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1775279933 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1775279933;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.053 -0400", hash_original_method = "1D36BC67F0D3E0E821622DAE101B8DA4", hash_generated_method = "5EE6C4546C378DEDC6EE510C9B400171")
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
                } 
ExtractedText varF4C7021EB2647C5C7DCF2D3426CCC9E4_1040829383 =                 et;
                varF4C7021EB2647C5C7DCF2D3426CCC9E4_1040829383.addTaint(taint);
                return varF4C7021EB2647C5C7DCF2D3426CCC9E4_1040829383;
            } 
        } 
ExtractedText var540C13E9E156B687226421B24F2DF178_1358193204 =         null;
        var540C13E9E156B687226421B24F2DF178_1358193204.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1358193204;
        
        
            
            
                
                    
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.054 -0400", hash_original_method = "66E210A03F4A51E56AF5DC1352B2E636", hash_generated_method = "8E6FD0CC6D11B15A08608D3533C3AD89")
    @Override
    public boolean performPrivateCommand(String action, Bundle data) {
        addTaint(data.getTaint());
        addTaint(action.getTaint());
        mTextView.onPrivateIMECommand(action, data);
        boolean varB326B5062B2F0E69046810717534CB09_1412653987 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1613123015 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1613123015;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.054 -0400", hash_original_method = "ED478A4EB972D41E370E9603327B3839", hash_generated_method = "BC78B22965C569A18FBD21411227E634")
    @Override
    public boolean commitText(CharSequence text, int newCursorPosition) {
        addTaint(newCursorPosition);
        addTaint(text.getTaint());
    if(mTextView == null)        
        {
            boolean var324A71B312F90BDF4597B60B4168456C_1271867273 = (super.commitText(text, newCursorPosition));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1773510428 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1773510428;
        } 
    if(text instanceof Spanned)        
        {
            Spanned spanned = ((Spanned) text);
            SuggestionSpan[] spans = spanned.getSpans(0, text.length(), SuggestionSpan.class);
            mIMM.registerSuggestionSpansForNotification(spans);
        } 
        mTextView.resetErrorChangedFlag();
        boolean success = super.commitText(text, newCursorPosition);
        mTextView.hideErrorIfUnchanged();
        boolean var260CA9DD8A4577FC00B7BD5810298076_782425447 = (success);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1589892927 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1589892927;
        
        
            
        
        
            
            
            
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.054 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.054 -0400", hash_original_field = "85062B0FE43FE953F5DABC7BCDD4C5BC", hash_generated_field = "92EE8EAF5607AA81AF30E4A149536DEE")

    private static final String TAG = "EditableInputConnection";
}


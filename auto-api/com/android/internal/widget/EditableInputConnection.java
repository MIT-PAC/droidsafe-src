package com.android.internal.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.142 -0400", hash_original_field = "59FFF1360E9B57BB348C2BF9F881659F", hash_generated_field = "B044D5C32398EDC8D922234EFA4F1DF3")

    private TextView mTextView;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.143 -0400", hash_original_method = "48AFA0A031D991327826B99C24590A71", hash_generated_method = "F5E7C121122B9E0DC720A281B65F78CC")
    public  EditableInputConnection(TextView textview) {
        super(textview, true);
        mTextView = textview;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.144 -0400", hash_original_method = "79431EAAD385E82AA03E24E6CD9A3769", hash_generated_method = "5FD9867556A5C46078E85FCFEB90A743")
    @Override
    public Editable getEditable() {
        Editable varB4EAC82CA7396A68D541C85D26508E83_1584764166 = null; 
        Editable varB4EAC82CA7396A68D541C85D26508E83_1742346980 = null; 
        TextView tv = mTextView;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1584764166 = tv.getEditableText();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1742346980 = null;
        Editable varA7E53CE21691AB073D9660D615818899_1852037560; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1852037560 = varB4EAC82CA7396A68D541C85D26508E83_1584764166;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1852037560 = varB4EAC82CA7396A68D541C85D26508E83_1742346980;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1852037560.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1852037560;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.144 -0400", hash_original_method = "47A7176B3179FC9D2FE377D6B6F09D07", hash_generated_method = "A8FE6CB2F5BD30AB193C5C9D8978DED9")
    @Override
    public boolean beginBatchEdit() {
        mTextView.beginBatchEdit();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_976780101 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_976780101;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.145 -0400", hash_original_method = "2B85862E44056949DE76AFB5C9725EFA", hash_generated_method = "C360BAEE5A486E9E48F9FCD1C0003013")
    @Override
    public boolean endBatchEdit() {
        mTextView.endBatchEdit();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1751374122 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1751374122;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.145 -0400", hash_original_method = "963E6A0CA86932C8F9D879DC40F2C809", hash_generated_method = "BF210FBF12D271857DCA647F4E85F3C5")
    @Override
    public boolean clearMetaKeyStates(int states) {
        final Editable content = getEditable();
        KeyListener kl = mTextView.getKeyListener();
        {
            try 
            {
                kl.clearMetaKeyState(mTextView, content, states);
            } 
            catch (AbstractMethodError e)
            { }
        } 
        addTaint(states);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1247189502 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1247189502;
        
        
        
        
        
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.145 -0400", hash_original_method = "120BCC39A19E9D48E7D09303ED2ED952", hash_generated_method = "4638198751D899D193499B00E9B3D173")
    @Override
    public boolean commitCompletion(CompletionInfo text) {
        mTextView.beginBatchEdit();
        mTextView.onCommitCompletion(text);
        mTextView.endBatchEdit();
        addTaint(text.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1328367977 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1328367977;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.146 -0400", hash_original_method = "DB06BCD96079AC12D626255A3932F1C1", hash_generated_method = "1B52F3746F105CA2003D2692DA5DCFDE")
    @Override
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        mTextView.beginBatchEdit();
        mTextView.onCommitCorrection(correctionInfo);
        mTextView.endBatchEdit();
        addTaint(correctionInfo.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1683003229 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1683003229;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.146 -0400", hash_original_method = "E62B789941F8A63BCC6EB7B832B68D0F", hash_generated_method = "6892681DC1F05400CDBC5FA35A0E1DA9")
    @Override
    public boolean performEditorAction(int actionCode) {
        mTextView.onEditorAction(actionCode);
        addTaint(actionCode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1867148941 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1867148941;
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.146 -0400", hash_original_method = "7AF0006D10C2DF24946CEF4909222B3C", hash_generated_method = "7993588C0E4AF533872A62B1A8A11543")
    @Override
    public boolean performContextMenuAction(int id) {
        mTextView.beginBatchEdit();
        mTextView.onTextContextMenuItem(id);
        mTextView.endBatchEdit();
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_611273523 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_611273523;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.147 -0400", hash_original_method = "1D36BC67F0D3E0E821622DAE101B8DA4", hash_generated_method = "F3B15EFCE079C4B3951DF442F4CD8F5C")
    @Override
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        ExtractedText varB4EAC82CA7396A68D541C85D26508E83_947744611 = null; 
        ExtractedText varB4EAC82CA7396A68D541C85D26508E83_922705639 = null; 
        {
            ExtractedText et = new ExtractedText();
            {
                boolean varFCEACA8CA5C40DCFCB2A18DA8BD5E901_1379229938 = (mTextView.extractText(request, et));
                {
                    {
                        mTextView.setExtracting(request);
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_947744611 = et;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_922705639 = null;
        addTaint(request.getTaint());
        addTaint(flags);
        ExtractedText varA7E53CE21691AB073D9660D615818899_1704875486; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1704875486 = varB4EAC82CA7396A68D541C85D26508E83_947744611;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1704875486 = varB4EAC82CA7396A68D541C85D26508E83_922705639;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1704875486.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1704875486;
        
        
            
            
                
                    
                
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.148 -0400", hash_original_method = "66E210A03F4A51E56AF5DC1352B2E636", hash_generated_method = "C6C6DCB401FE330A210B24B341410DDA")
    @Override
    public boolean performPrivateCommand(String action, Bundle data) {
        mTextView.onPrivateIMECommand(action, data);
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1435197095 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1435197095;
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.148 -0400", hash_original_method = "ED478A4EB972D41E370E9603327B3839", hash_generated_method = "000C954C0B13AF7E00A8C63337A368EA")
    @Override
    public boolean commitText(CharSequence text, int newCursorPosition) {
        {
            boolean var3232D6DBF4B95A9709C08EED7122DED2_1617255631 = (super.commitText(text, newCursorPosition));
        } 
        {
            Spanned spanned = ((Spanned) text);
            SuggestionSpan[] spans = spanned.getSpans(0, text.length(), SuggestionSpan.class);
            mIMM.registerSuggestionSpansForNotification(spans);
        } 
        mTextView.resetErrorChangedFlag();
        boolean success = super.commitText(text, newCursorPosition);
        mTextView.hideErrorIfUnchanged();
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1915530703 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1915530703;
        
        
            
        
        
            
            
            
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.148 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.148 -0400", hash_original_field = "85062B0FE43FE953F5DABC7BCDD4C5BC", hash_generated_field = "92EE8EAF5607AA81AF30E4A149536DEE")

    private static final String TAG = "EditableInputConnection";
}


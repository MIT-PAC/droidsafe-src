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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.735 -0400", hash_original_field = "59FFF1360E9B57BB348C2BF9F881659F", hash_generated_field = "B044D5C32398EDC8D922234EFA4F1DF3")

    private TextView mTextView;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.735 -0400", hash_original_method = "48AFA0A031D991327826B99C24590A71", hash_generated_method = "F5E7C121122B9E0DC720A281B65F78CC")
    public  EditableInputConnection(TextView textview) {
        super(textview, true);
        mTextView = textview;
        // ---------- Original Method ----------
        //mTextView = textview;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.736 -0400", hash_original_method = "79431EAAD385E82AA03E24E6CD9A3769", hash_generated_method = "8D8640653E4964FA6C548032D642C706")
    @Override
    public Editable getEditable() {
        Editable varB4EAC82CA7396A68D541C85D26508E83_905150923 = null; //Variable for return #1
        Editable varB4EAC82CA7396A68D541C85D26508E83_37242262 = null; //Variable for return #2
        TextView tv;
        tv = mTextView;
        {
            varB4EAC82CA7396A68D541C85D26508E83_905150923 = tv.getEditableText();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_37242262 = null;
        Editable varA7E53CE21691AB073D9660D615818899_1567929504; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1567929504 = varB4EAC82CA7396A68D541C85D26508E83_905150923;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1567929504 = varB4EAC82CA7396A68D541C85D26508E83_37242262;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1567929504.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1567929504;
        // ---------- Original Method ----------
        //TextView tv = mTextView;
        //if (tv != null) {
            //return tv.getEditableText();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.737 -0400", hash_original_method = "47A7176B3179FC9D2FE377D6B6F09D07", hash_generated_method = "2626A4AD8213638E0675FFC7B4826BD9")
    @Override
    public boolean beginBatchEdit() {
        mTextView.beginBatchEdit();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_783357538 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_783357538;
        // ---------- Original Method ----------
        //mTextView.beginBatchEdit();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.737 -0400", hash_original_method = "2B85862E44056949DE76AFB5C9725EFA", hash_generated_method = "92F57675337EF72C57D955A0D8DA1BB9")
    @Override
    public boolean endBatchEdit() {
        mTextView.endBatchEdit();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1539399990 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1539399990;
        // ---------- Original Method ----------
        //mTextView.endBatchEdit();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.737 -0400", hash_original_method = "963E6A0CA86932C8F9D879DC40F2C809", hash_generated_method = "9D9948B676DD093D853683CB3245D8B3")
    @Override
    public boolean clearMetaKeyStates(int states) {
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
        addTaint(states);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1146616193 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1146616193;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.738 -0400", hash_original_method = "120BCC39A19E9D48E7D09303ED2ED952", hash_generated_method = "2B844B110D3AB3E7B20141807EED9C6B")
    @Override
    public boolean commitCompletion(CompletionInfo text) {
        mTextView.beginBatchEdit();
        mTextView.onCommitCompletion(text);
        mTextView.endBatchEdit();
        addTaint(text.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1726398165 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1726398165;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "commitCompletion " + text);
        //mTextView.beginBatchEdit();
        //mTextView.onCommitCompletion(text);
        //mTextView.endBatchEdit();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.738 -0400", hash_original_method = "DB06BCD96079AC12D626255A3932F1C1", hash_generated_method = "8FAB9DD15DF816DE7EDE648E17558A07")
    @Override
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        mTextView.beginBatchEdit();
        mTextView.onCommitCorrection(correctionInfo);
        mTextView.endBatchEdit();
        addTaint(correctionInfo.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_510568950 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_510568950;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "commitCorrection" + correctionInfo);
        //mTextView.beginBatchEdit();
        //mTextView.onCommitCorrection(correctionInfo);
        //mTextView.endBatchEdit();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.738 -0400", hash_original_method = "E62B789941F8A63BCC6EB7B832B68D0F", hash_generated_method = "5EBB08B1A65DBD3654D53C70DA71BED1")
    @Override
    public boolean performEditorAction(int actionCode) {
        mTextView.onEditorAction(actionCode);
        addTaint(actionCode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_438748866 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_438748866;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "performEditorAction " + actionCode);
        //mTextView.onEditorAction(actionCode);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.807 -0400", hash_original_method = "7AF0006D10C2DF24946CEF4909222B3C", hash_generated_method = "AF35EE45BC30F5E1622759C01C8D570A")
    @Override
    public boolean performContextMenuAction(int id) {
        mTextView.beginBatchEdit();
        mTextView.onTextContextMenuItem(id);
        mTextView.endBatchEdit();
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_606620681 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_606620681;
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "performContextMenuAction " + id);
        //mTextView.beginBatchEdit();
        //mTextView.onTextContextMenuItem(id);
        //mTextView.endBatchEdit();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.808 -0400", hash_original_method = "1D36BC67F0D3E0E821622DAE101B8DA4", hash_generated_method = "EA1A0AAE6793C04D894D08AAD1A5ACA7")
    @Override
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        ExtractedText varB4EAC82CA7396A68D541C85D26508E83_483066697 = null; //Variable for return #1
        ExtractedText varB4EAC82CA7396A68D541C85D26508E83_920163004 = null; //Variable for return #2
        {
            ExtractedText et;
            et = new ExtractedText();
            {
                boolean varFCEACA8CA5C40DCFCB2A18DA8BD5E901_1030102597 = (mTextView.extractText(request, et));
                {
                    {
                        mTextView.setExtracting(request);
                    } //End block
                    varB4EAC82CA7396A68D541C85D26508E83_483066697 = et;
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_920163004 = null;
        addTaint(request.getTaint());
        addTaint(flags);
        ExtractedText varA7E53CE21691AB073D9660D615818899_1846825068; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1846825068 = varB4EAC82CA7396A68D541C85D26508E83_483066697;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1846825068 = varB4EAC82CA7396A68D541C85D26508E83_920163004;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1846825068.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1846825068;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.808 -0400", hash_original_method = "66E210A03F4A51E56AF5DC1352B2E636", hash_generated_method = "940AA7F93C752A3A00BEA8087C495963")
    @Override
    public boolean performPrivateCommand(String action, Bundle data) {
        mTextView.onPrivateIMECommand(action, data);
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1660563763 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1660563763;
        // ---------- Original Method ----------
        //mTextView.onPrivateIMECommand(action, data);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.808 -0400", hash_original_method = "ED478A4EB972D41E370E9603327B3839", hash_generated_method = "3946433CB917BF06BA65097A6F5F83CC")
    @Override
    public boolean commitText(CharSequence text, int newCursorPosition) {
        {
            boolean var3232D6DBF4B95A9709C08EED7122DED2_1003232945 = (super.commitText(text, newCursorPosition));
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
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1684945010 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1684945010;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.809 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:26.809 -0400", hash_original_field = "85062B0FE43FE953F5DABC7BCDD4C5BC", hash_generated_field = "AF96C9A3715347577D13839F98483DDC")

    private static String TAG = "EditableInputConnection";
}


package com.android.internal.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;

public class InputConnectionWrapper implements InputConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.737 -0400", hash_original_field = "4AC36937F366B7AB4CCDC4F1F414F47C", hash_generated_field = "1993EA11D8BF196428670F5B97A83039")

    private IInputContext mIInputContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.743 -0400", hash_original_method = "200A59D07195D77203DE13B6F1D7E213", hash_generated_method = "7612BD2DCE02136E56A8BD3FD04ECE95")
    public  InputConnectionWrapper(IInputContext inputContext) {
        mIInputContext = inputContext;
        // ---------- Original Method ----------
        //mIInputContext = inputContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.753 -0400", hash_original_method = "E5D9808718D85F214F56B5C74559D92A", hash_generated_method = "A16E337598B34F61F08673BAEBD2F1F6")
    public CharSequence getTextAfterCursor(int length, int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1765682153 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_652428839 = null; //Variable for return #2
        CharSequence value;
        value = null;
        try 
        {
            InputContextCallback callback;
            callback = InputContextCallback.getInstance();
            mIInputContext.getTextAfterCursor(length, flags, callback.mSeq, callback);
            {
                callback.waitForResultLocked();
                {
                    value = callback.mTextAfterCursor;
                } //End block
            } //End block
            callback.dispose();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1765682153 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_652428839 = value;
        addTaint(length);
        addTaint(flags);
        CharSequence varA7E53CE21691AB073D9660D615818899_175987261; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_175987261 = varB4EAC82CA7396A68D541C85D26508E83_1765682153;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_175987261 = varB4EAC82CA7396A68D541C85D26508E83_652428839;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_175987261.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_175987261;
        // ---------- Original Method ----------
        //CharSequence value = null;
        //try {
            //InputContextCallback callback = InputContextCallback.getInstance();
            //mIInputContext.getTextAfterCursor(length, flags, callback.mSeq, callback);
            //synchronized (callback) {
                //callback.waitForResultLocked();
                //if (callback.mHaveValue) {
                    //value = callback.mTextAfterCursor;
                //}
            //}
            //callback.dispose();
        //} catch (RemoteException e) {
            //return null;
        //}
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.765 -0400", hash_original_method = "161B1891DB80E123B2A48225941EF408", hash_generated_method = "092A2BBA7421C35654B00F4A06AE92F3")
    public CharSequence getTextBeforeCursor(int length, int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_847003054 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2073431056 = null; //Variable for return #2
        CharSequence value;
        value = null;
        try 
        {
            InputContextCallback callback;
            callback = InputContextCallback.getInstance();
            mIInputContext.getTextBeforeCursor(length, flags, callback.mSeq, callback);
            {
                callback.waitForResultLocked();
                {
                    value = callback.mTextBeforeCursor;
                } //End block
            } //End block
            callback.dispose();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_847003054 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2073431056 = value;
        addTaint(length);
        addTaint(flags);
        CharSequence varA7E53CE21691AB073D9660D615818899_491638071; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_491638071 = varB4EAC82CA7396A68D541C85D26508E83_847003054;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_491638071 = varB4EAC82CA7396A68D541C85D26508E83_2073431056;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_491638071.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_491638071;
        // ---------- Original Method ----------
        //CharSequence value = null;
        //try {
            //InputContextCallback callback = InputContextCallback.getInstance();
            //mIInputContext.getTextBeforeCursor(length, flags, callback.mSeq, callback);
            //synchronized (callback) {
                //callback.waitForResultLocked();
                //if (callback.mHaveValue) {
                    //value = callback.mTextBeforeCursor;
                //}
            //}
            //callback.dispose();
        //} catch (RemoteException e) {
            //return null;
        //}
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.770 -0400", hash_original_method = "07C2D6CA43F82EBF9A41822F1A0D86D8", hash_generated_method = "6671A03CC43C14DB5155F70E9B27F2D2")
    public CharSequence getSelectedText(int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_352788642 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1597986091 = null; //Variable for return #2
        CharSequence value;
        value = null;
        try 
        {
            InputContextCallback callback;
            callback = InputContextCallback.getInstance();
            mIInputContext.getSelectedText(flags, callback.mSeq, callback);
            {
                callback.waitForResultLocked();
                {
                    value = callback.mSelectedText;
                } //End block
            } //End block
            callback.dispose();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_352788642 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1597986091 = value;
        addTaint(flags);
        CharSequence varA7E53CE21691AB073D9660D615818899_1874344010; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1874344010 = varB4EAC82CA7396A68D541C85D26508E83_352788642;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1874344010 = varB4EAC82CA7396A68D541C85D26508E83_1597986091;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1874344010.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1874344010;
        // ---------- Original Method ----------
        //CharSequence value = null;
        //try {
            //InputContextCallback callback = InputContextCallback.getInstance();
            //mIInputContext.getSelectedText(flags, callback.mSeq, callback);
            //synchronized (callback) {
                //callback.waitForResultLocked();
                //if (callback.mHaveValue) {
                    //value = callback.mSelectedText;
                //}
            //}
            //callback.dispose();
        //} catch (RemoteException e) {
            //return null;
        //}
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.771 -0400", hash_original_method = "42EA416764DB4DFF051E9040CF49BB73", hash_generated_method = "3F2242F2901CB815DE716A6B1836277E")
    public int getCursorCapsMode(int reqModes) {
        int value;
        value = 0;
        try 
        {
            InputContextCallback callback;
            callback = InputContextCallback.getInstance();
            mIInputContext.getCursorCapsMode(reqModes, callback.mSeq, callback);
            {
                callback.waitForResultLocked();
                {
                    value = callback.mCursorCapsMode;
                } //End block
            } //End block
            callback.dispose();
        } //End block
        catch (RemoteException e)
        { }
        addTaint(reqModes);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391705911 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_391705911;
        // ---------- Original Method ----------
        //int value = 0;
        //try {
            //InputContextCallback callback = InputContextCallback.getInstance();
            //mIInputContext.getCursorCapsMode(reqModes, callback.mSeq, callback);
            //synchronized (callback) {
                //callback.waitForResultLocked();
                //if (callback.mHaveValue) {
                    //value = callback.mCursorCapsMode;
                //}
            //}
            //callback.dispose();
        //} catch (RemoteException e) {
            //return 0;
        //}
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.772 -0400", hash_original_method = "305E28329FA220003F7366DA2A6BF238", hash_generated_method = "296DBA1A54133D0E67971EAF920B98EA")
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        ExtractedText varB4EAC82CA7396A68D541C85D26508E83_302678037 = null; //Variable for return #1
        ExtractedText varB4EAC82CA7396A68D541C85D26508E83_879193474 = null; //Variable for return #2
        ExtractedText value;
        value = null;
        try 
        {
            InputContextCallback callback;
            callback = InputContextCallback.getInstance();
            mIInputContext.getExtractedText(request, flags, callback.mSeq, callback);
            {
                callback.waitForResultLocked();
                {
                    value = callback.mExtractedText;
                } //End block
            } //End block
            callback.dispose();
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_302678037 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_879193474 = value;
        addTaint(request.getTaint());
        addTaint(flags);
        ExtractedText varA7E53CE21691AB073D9660D615818899_1705829251; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1705829251 = varB4EAC82CA7396A68D541C85D26508E83_302678037;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1705829251 = varB4EAC82CA7396A68D541C85D26508E83_879193474;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1705829251.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1705829251;
        // ---------- Original Method ----------
        //ExtractedText value = null;
        //try {
            //InputContextCallback callback = InputContextCallback.getInstance();
            //mIInputContext.getExtractedText(request, flags, callback.mSeq, callback);
            //synchronized (callback) {
                //callback.waitForResultLocked();
                //if (callback.mHaveValue) {
                    //value = callback.mExtractedText;
                //}
            //}
            //callback.dispose();
        //} catch (RemoteException e) {
            //return null;
        //}
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.825 -0400", hash_original_method = "E23EA90B6F67D6C242A9505D14FF1F12", hash_generated_method = "C554AC72085C14E018BC5E2CCD8A7CA0")
    public boolean commitText(CharSequence text, int newCursorPosition) {
        try 
        {
            mIInputContext.commitText(text, newCursorPosition);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1856205222 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1856205222;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.commitText(text, newCursorPosition);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.827 -0400", hash_original_method = "EAB5E616D3D3B282F88520753342CC96", hash_generated_method = "F539269E357A81DBDE3AB8FFF6F24D8B")
    public boolean commitCompletion(CompletionInfo text) {
        try 
        {
            mIInputContext.commitCompletion(text);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(text.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_774183894 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_774183894;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.commitCompletion(text);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.840 -0400", hash_original_method = "6923A4DC7941C069C654C30365BCACDD", hash_generated_method = "FCFA0A5B7DDE57496C3C0616CB5C6847")
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        try 
        {
            mIInputContext.commitCorrection(correctionInfo);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(correctionInfo.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_537008241 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_537008241;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.commitCorrection(correctionInfo);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.841 -0400", hash_original_method = "7022EC7ED2F239685C7BD3195B6CEAE9", hash_generated_method = "DE2D56B1B570C8C1270CFA3B7F580024")
    public boolean setSelection(int start, int end) {
        try 
        {
            mIInputContext.setSelection(start, end);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(start);
        addTaint(end);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1474241819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1474241819;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.setSelection(start, end);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.841 -0400", hash_original_method = "67A8A8F86F1AE5123A01275D8828212B", hash_generated_method = "262604B0D7C1B1F0F86445A0062883F5")
    public boolean performEditorAction(int actionCode) {
        try 
        {
            mIInputContext.performEditorAction(actionCode);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(actionCode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1441431790 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1441431790;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.performEditorAction(actionCode);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.841 -0400", hash_original_method = "F7AEA38F9035D01924C8EE6C58DE4221", hash_generated_method = "4E441BF4F18A6DD72D1EC449D1884AE3")
    public boolean performContextMenuAction(int id) {
        try 
        {
            mIInputContext.performContextMenuAction(id);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2087273400 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2087273400;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.performContextMenuAction(id);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.842 -0400", hash_original_method = "D57326DB6E974535AC174E0CB4F4F72D", hash_generated_method = "3CF49B1F27C31F156CC1DA86255FC9DA")
    public boolean setComposingRegion(int start, int end) {
        try 
        {
            mIInputContext.setComposingRegion(start, end);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(start);
        addTaint(end);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_183067058 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_183067058;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.setComposingRegion(start, end);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.842 -0400", hash_original_method = "DE2855A916E2A0C96139F9B28AC632EF", hash_generated_method = "EE276394143907B635AA30298CD52DE5")
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        try 
        {
            mIInputContext.setComposingText(text, newCursorPosition);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_673286594 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_673286594;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.setComposingText(text, newCursorPosition);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.842 -0400", hash_original_method = "654CA187A88EAE1F2AB6640B00B6686A", hash_generated_method = "605B7C22A49EE52B2C4C1C02E6DA2FC0")
    public boolean finishComposingText() {
        try 
        {
            mIInputContext.finishComposingText();
        } //End block
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_267527438 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_267527438;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.finishComposingText();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.842 -0400", hash_original_method = "F214558E918685C9D34C6BD9CACE39BA", hash_generated_method = "885DF4C2AD7177770912914DAF3EBBC9")
    public boolean beginBatchEdit() {
        try 
        {
            mIInputContext.beginBatchEdit();
        } //End block
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1580290059 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1580290059;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.beginBatchEdit();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.843 -0400", hash_original_method = "FFD20A357B6026C06481613009C9A85C", hash_generated_method = "AABD79B67B784884ED044FE083E99F0B")
    public boolean endBatchEdit() {
        try 
        {
            mIInputContext.endBatchEdit();
        } //End block
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_725171124 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_725171124;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.endBatchEdit();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.843 -0400", hash_original_method = "BDB80433761F466B2EC1080474660009", hash_generated_method = "C8D141033B58ECB2FC9A1589FDA82466")
    public boolean sendKeyEvent(KeyEvent event) {
        try 
        {
            mIInputContext.sendKeyEvent(event);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1265817343 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1265817343;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.sendKeyEvent(event);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.843 -0400", hash_original_method = "3A88C36966ABDB3053599F030E0CFC04", hash_generated_method = "6908F415B99DE4C8A3F678FDC474C633")
    public boolean clearMetaKeyStates(int states) {
        try 
        {
            mIInputContext.clearMetaKeyStates(states);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(states);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1875240114 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1875240114;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.clearMetaKeyStates(states);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.865 -0400", hash_original_method = "A0EA155ACF6A2B88254811510DB0CC9C", hash_generated_method = "1235245D5A8240654A03408B911923B5")
    public boolean deleteSurroundingText(int leftLength, int rightLength) {
        try 
        {
            mIInputContext.deleteSurroundingText(leftLength, rightLength);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(leftLength);
        addTaint(rightLength);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1091917369 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1091917369;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.deleteSurroundingText(leftLength, rightLength);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.886 -0400", hash_original_method = "F356C6E7AA9EF97C6745E94B41944104", hash_generated_method = "9CF594A6700DF853A7F33EBE7BC2B147")
    public boolean reportFullscreenMode(boolean enabled) {
        try 
        {
            mIInputContext.reportFullscreenMode(enabled);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(enabled);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_842974228 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_842974228;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.reportFullscreenMode(enabled);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.887 -0400", hash_original_method = "C4A420F599BD094A8850BEFF4D3FF18D", hash_generated_method = "55E6F0A83BD3E8EB9B3E2E0ABA6B1ECC")
    public boolean performPrivateCommand(String action, Bundle data) {
        try 
        {
            mIInputContext.performPrivateCommand(action, data);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1073244478 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1073244478;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.performPrivateCommand(action, data);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    static class InputContextCallback extends IInputContextCallback.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.887 -0400", hash_original_field = "61A42A5C5A78D6632BB173F2CD44E374", hash_generated_field = "FF1C2ACF522E25E367200C0572BE8DA1")

        public int mSeq;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.887 -0400", hash_original_field = "C871C935A9FFBB5A72B3BC90796F592F", hash_generated_field = "4D2C9CAFD7EF62D4BB15576A5CC2ECC3")

        public boolean mHaveValue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.887 -0400", hash_original_field = "F423FDF2985DDF32E87605AFE9C6978B", hash_generated_field = "58D5B63A8A0C4A7E8BAB109575D64E4D")

        public CharSequence mTextBeforeCursor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.887 -0400", hash_original_field = "65BD4E602AB1BF88FE45543DD84DD6E2", hash_generated_field = "9FB6F0C8456D90D8021099BE30489DC5")

        public CharSequence mTextAfterCursor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.887 -0400", hash_original_field = "7AC72A89563F8A56517E860A9DBEF362", hash_generated_field = "57A04860072A486B5F1E41658D97AC82")

        public CharSequence mSelectedText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.887 -0400", hash_original_field = "A034AA34A307E777C43933E669A375DC", hash_generated_field = "482594694449567A160FA3F5524709A0")

        public ExtractedText mExtractedText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.887 -0400", hash_original_field = "9BC83ACBBA6BD4A8D823866CA0DC5705", hash_generated_field = "C92D0BC414C6A30B2A5E4D2844301587")

        public int mCursorCapsMode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.887 -0400", hash_original_method = "C2F7B541292D8E4E042270C21CD2A858", hash_generated_method = "C2F7B541292D8E4E042270C21CD2A858")
        public InputContextCallback ()
        {
            //Synthesized constructor
        }


                private static InputContextCallback getInstance() {
            synchronized (InputContextCallback.class) {
                InputContextCallback callback;
                if (sInstance != null) {
                    callback = sInstance;
                    sInstance = null;
                    callback.mHaveValue = false;
                } else {
                    callback = new InputContextCallback();
                }
                callback.mSeq = sSequenceNumber++;
                return callback;
            }
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.888 -0400", hash_original_method = "114A3AA754115CB63309037B1A16C75C", hash_generated_method = "DEB7402431C747CDAA87E13C266B649E")
        private void dispose() {
            {
                {
                    mTextAfterCursor = null;
                    mTextBeforeCursor = null;
                    mExtractedText = null;
                    sInstance = this;
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (InputContextCallback.class) {
                //if (sInstance == null) {
                    //mTextAfterCursor = null;
                    //mTextBeforeCursor = null;
                    //mExtractedText = null;
                    //sInstance = this;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.888 -0400", hash_original_method = "361E9A3C637FF701A52DA6E2E96E1B0D", hash_generated_method = "35521854F3A20CDF717B2E2256A272A2")
        public void setTextBeforeCursor(CharSequence textBeforeCursor, int seq) {
            {
                {
                    mTextBeforeCursor = textBeforeCursor;
                    mHaveValue = true;
                    notifyAll();
                } //End block
            } //End block
            addTaint(seq);
            // ---------- Original Method ----------
            //synchronized (this) {
                //if (seq == mSeq) {
                    //mTextBeforeCursor = textBeforeCursor;
                    //mHaveValue = true;
                    //notifyAll();
                //} else {
                    //Log.i(TAG, "Got out-of-sequence callback " + seq + " (expected " + mSeq
                            //+ ") in setTextBeforeCursor, ignoring.");
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.902 -0400", hash_original_method = "364CB8CF32311AACA17721A234C603BF", hash_generated_method = "46F242B621388335E665CA7893A1258E")
        public void setTextAfterCursor(CharSequence textAfterCursor, int seq) {
            {
                {
                    mTextAfterCursor = textAfterCursor;
                    mHaveValue = true;
                    notifyAll();
                } //End block
            } //End block
            addTaint(seq);
            // ---------- Original Method ----------
            //synchronized (this) {
                //if (seq == mSeq) {
                    //mTextAfterCursor = textAfterCursor;
                    //mHaveValue = true;
                    //notifyAll();
                //} else {
                    //Log.i(TAG, "Got out-of-sequence callback " + seq + " (expected " + mSeq
                            //+ ") in setTextAfterCursor, ignoring.");
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.904 -0400", hash_original_method = "22EEF86B76323A3D0B42A8BDC8D7F847", hash_generated_method = "4D56280AFA594989E4FB9F0D2754B932")
        public void setSelectedText(CharSequence selectedText, int seq) {
            {
                {
                    mSelectedText = selectedText;
                    mHaveValue = true;
                    notifyAll();
                } //End block
            } //End block
            addTaint(seq);
            // ---------- Original Method ----------
            //synchronized (this) {
                //if (seq == mSeq) {
                    //mSelectedText = selectedText;
                    //mHaveValue = true;
                    //notifyAll();
                //} else {
                    //Log.i(TAG, "Got out-of-sequence callback " + seq + " (expected " + mSeq
                            //+ ") in setSelectedText, ignoring.");
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.904 -0400", hash_original_method = "998E9B4FE98738EB2922C01E8488A9FE", hash_generated_method = "F12064AAB1720E274421A5EA84B131E8")
        public void setCursorCapsMode(int capsMode, int seq) {
            {
                {
                    mCursorCapsMode = capsMode;
                    mHaveValue = true;
                    notifyAll();
                } //End block
            } //End block
            addTaint(seq);
            // ---------- Original Method ----------
            //synchronized (this) {
                //if (seq == mSeq) {
                    //mCursorCapsMode = capsMode; 
                    //mHaveValue = true;  
                    //notifyAll();
                //} else {
                    //Log.i(TAG, "Got out-of-sequence callback " + seq + " (expected " + mSeq
                            //+ ") in setCursorCapsMode, ignoring.");
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.905 -0400", hash_original_method = "728CBF4CDD80384E151B1C8A539138C4", hash_generated_method = "3E29DBA3FD54BF389313549EF6078E8A")
        public void setExtractedText(ExtractedText extractedText, int seq) {
            {
                {
                    mExtractedText = extractedText;
                    mHaveValue = true;
                    notifyAll();
                } //End block
            } //End block
            addTaint(seq);
            // ---------- Original Method ----------
            //synchronized (this) {
                //if (seq == mSeq) {
                    //mExtractedText = extractedText;
                    //mHaveValue = true;
                    //notifyAll();
                //} else {
                    //Log.i(TAG, "Got out-of-sequence callback " + seq + " (expected " + mSeq
                            //+ ") in setExtractedText, ignoring.");
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.905 -0400", hash_original_method = "0DFF250C75DABF6F6E35FBCC4F44FCEA", hash_generated_method = "F8E382404609B34B32253EDA73E9BED9")
         void waitForResultLocked() {
            long startTime;
            startTime = SystemClock.uptimeMillis();
            long endTime;
            endTime = startTime + MAX_WAIT_TIME_MILLIS;
            {
                long remainingTime;
                remainingTime = endTime - SystemClock.uptimeMillis();
                try 
                {
                    wait(remainingTime);
                } //End block
                catch (InterruptedException e)
                { }
            } //End block
            // ---------- Original Method ----------
            //long startTime = SystemClock.uptimeMillis();
            //long endTime = startTime + MAX_WAIT_TIME_MILLIS;
            //while (!mHaveValue) {
                //long remainingTime = endTime - SystemClock.uptimeMillis();
                //if (remainingTime <= 0) {
                    //Log.w(TAG, "Timed out waiting on IInputContextCallback");
                    //return;
                //}
                //try {
                    //wait(remainingTime);
                //} catch (InterruptedException e) {
                //}
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.906 -0400", hash_original_field = "D625C16187F9C03B97B300FD3342652B", hash_generated_field = "DCD1365E5A67361C91B6DA6E1FDA8881")

        private static String TAG = "InputConnectionWrapper.ICC";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.906 -0400", hash_original_field = "988FFA1F2B606800228BA347483121A3", hash_generated_field = "8C19ECF6955FF34778F11D83BE064C14")

        private static InputContextCallback sInstance = new InputContextCallback();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.906 -0400", hash_original_field = "FD62EFA389E2F9A7398A20D67E683F18", hash_generated_field = "54D86ECADB2242C49D518A04742826C9")

        private static int sSequenceNumber = 1;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.906 -0400", hash_original_field = "6267C4AF26D35EDB744787F96CED4081", hash_generated_field = "65E63CB31DAD0B1B499553FEC66EB35D")

    private static int MAX_WAIT_TIME_MILLIS = 2000;
}


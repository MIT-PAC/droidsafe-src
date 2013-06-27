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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.779 -0400", hash_original_field = "4AC36937F366B7AB4CCDC4F1F414F47C", hash_generated_field = "1993EA11D8BF196428670F5B97A83039")

    private IInputContext mIInputContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.779 -0400", hash_original_method = "200A59D07195D77203DE13B6F1D7E213", hash_generated_method = "7612BD2DCE02136E56A8BD3FD04ECE95")
    public  InputConnectionWrapper(IInputContext inputContext) {
        mIInputContext = inputContext;
        // ---------- Original Method ----------
        //mIInputContext = inputContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.798 -0400", hash_original_method = "E5D9808718D85F214F56B5C74559D92A", hash_generated_method = "94A459E4FEFE678BA7605851DDB4AC3D")
    public CharSequence getTextAfterCursor(int length, int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_521387403 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_629716114 = null; //Variable for return #2
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
            varB4EAC82CA7396A68D541C85D26508E83_521387403 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_629716114 = value;
        addTaint(length);
        addTaint(flags);
        CharSequence varA7E53CE21691AB073D9660D615818899_1988754771; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1988754771 = varB4EAC82CA7396A68D541C85D26508E83_521387403;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1988754771 = varB4EAC82CA7396A68D541C85D26508E83_629716114;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1988754771.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1988754771;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.799 -0400", hash_original_method = "161B1891DB80E123B2A48225941EF408", hash_generated_method = "F043E9DBD1626F9090113A3F82C03BE5")
    public CharSequence getTextBeforeCursor(int length, int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_398326891 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1469302638 = null; //Variable for return #2
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
            varB4EAC82CA7396A68D541C85D26508E83_398326891 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1469302638 = value;
        addTaint(length);
        addTaint(flags);
        CharSequence varA7E53CE21691AB073D9660D615818899_1288846134; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1288846134 = varB4EAC82CA7396A68D541C85D26508E83_398326891;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1288846134 = varB4EAC82CA7396A68D541C85D26508E83_1469302638;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1288846134.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1288846134;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.800 -0400", hash_original_method = "07C2D6CA43F82EBF9A41822F1A0D86D8", hash_generated_method = "6D5A73B5EF1A7E0EB5C70F3819476A4D")
    public CharSequence getSelectedText(int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1878888766 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_601050791 = null; //Variable for return #2
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
            varB4EAC82CA7396A68D541C85D26508E83_1878888766 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_601050791 = value;
        addTaint(flags);
        CharSequence varA7E53CE21691AB073D9660D615818899_731110400; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_731110400 = varB4EAC82CA7396A68D541C85D26508E83_1878888766;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_731110400 = varB4EAC82CA7396A68D541C85D26508E83_601050791;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_731110400.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_731110400;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.804 -0400", hash_original_method = "42EA416764DB4DFF051E9040CF49BB73", hash_generated_method = "C98C9ACAC1F1A1B56274587A06252828")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1502557936 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1502557936;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.805 -0400", hash_original_method = "305E28329FA220003F7366DA2A6BF238", hash_generated_method = "604AAF36A8C787B1DC0D3A2C9ACA467D")
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        ExtractedText varB4EAC82CA7396A68D541C85D26508E83_1310834139 = null; //Variable for return #1
        ExtractedText varB4EAC82CA7396A68D541C85D26508E83_565228590 = null; //Variable for return #2
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
            varB4EAC82CA7396A68D541C85D26508E83_1310834139 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_565228590 = value;
        addTaint(request.getTaint());
        addTaint(flags);
        ExtractedText varA7E53CE21691AB073D9660D615818899_1080162211; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1080162211 = varB4EAC82CA7396A68D541C85D26508E83_1310834139;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1080162211 = varB4EAC82CA7396A68D541C85D26508E83_565228590;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1080162211.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1080162211;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.823 -0400", hash_original_method = "E23EA90B6F67D6C242A9505D14FF1F12", hash_generated_method = "11BF29E7D19B0B2E9442817FE498C3EF")
    public boolean commitText(CharSequence text, int newCursorPosition) {
        try 
        {
            mIInputContext.commitText(text, newCursorPosition);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2002322155 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2002322155;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.commitText(text, newCursorPosition);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.824 -0400", hash_original_method = "EAB5E616D3D3B282F88520753342CC96", hash_generated_method = "BC2B3EE2C7620583428ED22CF49D9B3E")
    public boolean commitCompletion(CompletionInfo text) {
        try 
        {
            mIInputContext.commitCompletion(text);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(text.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1518130635 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1518130635;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.commitCompletion(text);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.824 -0400", hash_original_method = "6923A4DC7941C069C654C30365BCACDD", hash_generated_method = "4913E590F75CA2C58143C4E99DA451F3")
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        try 
        {
            mIInputContext.commitCorrection(correctionInfo);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(correctionInfo.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_340496164 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_340496164;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.commitCorrection(correctionInfo);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.825 -0400", hash_original_method = "7022EC7ED2F239685C7BD3195B6CEAE9", hash_generated_method = "8CB0781F8A2D6CC67AA30D2345B2D240")
    public boolean setSelection(int start, int end) {
        try 
        {
            mIInputContext.setSelection(start, end);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(start);
        addTaint(end);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_36443865 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_36443865;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.setSelection(start, end);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.826 -0400", hash_original_method = "67A8A8F86F1AE5123A01275D8828212B", hash_generated_method = "BD9E88FD2B58BDF7940EE23CDF43E3E4")
    public boolean performEditorAction(int actionCode) {
        try 
        {
            mIInputContext.performEditorAction(actionCode);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(actionCode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2115205574 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2115205574;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.performEditorAction(actionCode);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.826 -0400", hash_original_method = "F7AEA38F9035D01924C8EE6C58DE4221", hash_generated_method = "E2B97586E1155678DA6DC5FCD50B9930")
    public boolean performContextMenuAction(int id) {
        try 
        {
            mIInputContext.performContextMenuAction(id);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1357781554 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1357781554;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.performContextMenuAction(id);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.826 -0400", hash_original_method = "D57326DB6E974535AC174E0CB4F4F72D", hash_generated_method = "47F0658DED729F4E64F2742559489E23")
    public boolean setComposingRegion(int start, int end) {
        try 
        {
            mIInputContext.setComposingRegion(start, end);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(start);
        addTaint(end);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_188522938 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_188522938;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.setComposingRegion(start, end);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.827 -0400", hash_original_method = "DE2855A916E2A0C96139F9B28AC632EF", hash_generated_method = "35E0FA413D9D9DE392A679348EF2C3B4")
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        try 
        {
            mIInputContext.setComposingText(text, newCursorPosition);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1614593826 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1614593826;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.setComposingText(text, newCursorPosition);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.827 -0400", hash_original_method = "654CA187A88EAE1F2AB6640B00B6686A", hash_generated_method = "F7A2B84F2C6542B20F443F5CD5307B5E")
    public boolean finishComposingText() {
        try 
        {
            mIInputContext.finishComposingText();
        } //End block
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_654925318 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_654925318;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.finishComposingText();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.827 -0400", hash_original_method = "F214558E918685C9D34C6BD9CACE39BA", hash_generated_method = "F5B3BE576D4B62762EB9535F652238FF")
    public boolean beginBatchEdit() {
        try 
        {
            mIInputContext.beginBatchEdit();
        } //End block
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1179275878 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1179275878;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.beginBatchEdit();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.838 -0400", hash_original_method = "FFD20A357B6026C06481613009C9A85C", hash_generated_method = "40AC6A012C061E3F627A2ABC5777ED91")
    public boolean endBatchEdit() {
        try 
        {
            mIInputContext.endBatchEdit();
        } //End block
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_184474085 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_184474085;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.endBatchEdit();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.838 -0400", hash_original_method = "BDB80433761F466B2EC1080474660009", hash_generated_method = "6029705CB83521ABAD057800773C286A")
    public boolean sendKeyEvent(KeyEvent event) {
        try 
        {
            mIInputContext.sendKeyEvent(event);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2144847402 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2144847402;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.sendKeyEvent(event);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.838 -0400", hash_original_method = "3A88C36966ABDB3053599F030E0CFC04", hash_generated_method = "D54A98A9B1790EBE59657C986C4FB724")
    public boolean clearMetaKeyStates(int states) {
        try 
        {
            mIInputContext.clearMetaKeyStates(states);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(states);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1298769359 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1298769359;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.clearMetaKeyStates(states);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.839 -0400", hash_original_method = "A0EA155ACF6A2B88254811510DB0CC9C", hash_generated_method = "63130635E6F59F1BF29E5A5CCF8E26C4")
    public boolean deleteSurroundingText(int leftLength, int rightLength) {
        try 
        {
            mIInputContext.deleteSurroundingText(leftLength, rightLength);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(leftLength);
        addTaint(rightLength);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_847654418 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_847654418;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.deleteSurroundingText(leftLength, rightLength);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.839 -0400", hash_original_method = "F356C6E7AA9EF97C6745E94B41944104", hash_generated_method = "864E71E53D9F71368AB1573318C742A3")
    public boolean reportFullscreenMode(boolean enabled) {
        try 
        {
            mIInputContext.reportFullscreenMode(enabled);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(enabled);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1158293496 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1158293496;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.reportFullscreenMode(enabled);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.839 -0400", hash_original_method = "C4A420F599BD094A8850BEFF4D3FF18D", hash_generated_method = "CFCFC1F10FDBD195A965AB1F99EFC11B")
    public boolean performPrivateCommand(String action, Bundle data) {
        try 
        {
            mIInputContext.performPrivateCommand(action, data);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1056405656 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1056405656;
        // ---------- Original Method ----------
        //try {
            //mIInputContext.performPrivateCommand(action, data);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    static class InputContextCallback extends IInputContextCallback.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.848 -0400", hash_original_field = "61A42A5C5A78D6632BB173F2CD44E374", hash_generated_field = "FF1C2ACF522E25E367200C0572BE8DA1")

        public int mSeq;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.848 -0400", hash_original_field = "C871C935A9FFBB5A72B3BC90796F592F", hash_generated_field = "4D2C9CAFD7EF62D4BB15576A5CC2ECC3")

        public boolean mHaveValue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.848 -0400", hash_original_field = "F423FDF2985DDF32E87605AFE9C6978B", hash_generated_field = "58D5B63A8A0C4A7E8BAB109575D64E4D")

        public CharSequence mTextBeforeCursor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.848 -0400", hash_original_field = "65BD4E602AB1BF88FE45543DD84DD6E2", hash_generated_field = "9FB6F0C8456D90D8021099BE30489DC5")

        public CharSequence mTextAfterCursor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.849 -0400", hash_original_field = "7AC72A89563F8A56517E860A9DBEF362", hash_generated_field = "57A04860072A486B5F1E41658D97AC82")

        public CharSequence mSelectedText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.849 -0400", hash_original_field = "A034AA34A307E777C43933E669A375DC", hash_generated_field = "482594694449567A160FA3F5524709A0")

        public ExtractedText mExtractedText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.849 -0400", hash_original_field = "9BC83ACBBA6BD4A8D823866CA0DC5705", hash_generated_field = "C92D0BC414C6A30B2A5E4D2844301587")

        public int mCursorCapsMode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.849 -0400", hash_original_method = "C2F7B541292D8E4E042270C21CD2A858", hash_generated_method = "C2F7B541292D8E4E042270C21CD2A858")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.894 -0400", hash_original_method = "114A3AA754115CB63309037B1A16C75C", hash_generated_method = "DEB7402431C747CDAA87E13C266B649E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.894 -0400", hash_original_method = "361E9A3C637FF701A52DA6E2E96E1B0D", hash_generated_method = "35521854F3A20CDF717B2E2256A272A2")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.895 -0400", hash_original_method = "364CB8CF32311AACA17721A234C603BF", hash_generated_method = "46F242B621388335E665CA7893A1258E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.895 -0400", hash_original_method = "22EEF86B76323A3D0B42A8BDC8D7F847", hash_generated_method = "4D56280AFA594989E4FB9F0D2754B932")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.908 -0400", hash_original_method = "998E9B4FE98738EB2922C01E8488A9FE", hash_generated_method = "F12064AAB1720E274421A5EA84B131E8")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.908 -0400", hash_original_method = "728CBF4CDD80384E151B1C8A539138C4", hash_generated_method = "3E29DBA3FD54BF389313549EF6078E8A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.909 -0400", hash_original_method = "0DFF250C75DABF6F6E35FBCC4F44FCEA", hash_generated_method = "F8E382404609B34B32253EDA73E9BED9")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.909 -0400", hash_original_field = "D625C16187F9C03B97B300FD3342652B", hash_generated_field = "DCD1365E5A67361C91B6DA6E1FDA8881")

        private static String TAG = "InputConnectionWrapper.ICC";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.909 -0400", hash_original_field = "988FFA1F2B606800228BA347483121A3", hash_generated_field = "8C19ECF6955FF34778F11D83BE064C14")

        private static InputContextCallback sInstance = new InputContextCallback();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.909 -0400", hash_original_field = "FD62EFA389E2F9A7398A20D67E683F18", hash_generated_field = "54D86ECADB2242C49D518A04742826C9")

        private static int sSequenceNumber = 1;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.909 -0400", hash_original_field = "6267C4AF26D35EDB744787F96CED4081", hash_generated_field = "65E63CB31DAD0B1B499553FEC66EB35D")

    private static int MAX_WAIT_TIME_MILLIS = 2000;
}


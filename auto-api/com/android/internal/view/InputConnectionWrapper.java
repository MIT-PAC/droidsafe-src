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
    private IInputContext mIInputContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.308 -0400", hash_original_method = "200A59D07195D77203DE13B6F1D7E213", hash_generated_method = "60ABB3D3B49C9D81E0FC35C80B801F1E")
    @DSModeled(DSC.SAFE)
    public InputConnectionWrapper(IInputContext inputContext) {
        dsTaint.addTaint(inputContext.dsTaint);
        // ---------- Original Method ----------
        //mIInputContext = inputContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.308 -0400", hash_original_method = "E5D9808718D85F214F56B5C74559D92A", hash_generated_method = "0F730D3E2DA2DBC0C8ED696D7E6F62E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getTextAfterCursor(int length, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(length);
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
        { }
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.308 -0400", hash_original_method = "161B1891DB80E123B2A48225941EF408", hash_generated_method = "CEE82A71B1BB2152751D2D395B3DD8CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getTextBeforeCursor(int length, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(length);
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
        { }
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.309 -0400", hash_original_method = "07C2D6CA43F82EBF9A41822F1A0D86D8", hash_generated_method = "8E0D201728877C4425DD68563D2130DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getSelectedText(int flags) {
        dsTaint.addTaint(flags);
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
        { }
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.309 -0400", hash_original_method = "42EA416764DB4DFF051E9040CF49BB73", hash_generated_method = "BD5C3FF4569380CF22D52DC69718403F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCursorCapsMode(int reqModes) {
        dsTaint.addTaint(reqModes);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.309 -0400", hash_original_method = "305E28329FA220003F7366DA2A6BF238", hash_generated_method = "D1283D3ACFEC1272E8C8802A2F29F947")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(request.dsTaint);
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
        { }
        return (ExtractedText)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.309 -0400", hash_original_method = "E23EA90B6F67D6C242A9505D14FF1F12", hash_generated_method = "C9D969F60ED08B122D15DC4FEFCA5236")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean commitText(CharSequence text, int newCursorPosition) {
        dsTaint.addTaint(newCursorPosition);
        dsTaint.addTaint(text);
        try 
        {
            mIInputContext.commitText(text, newCursorPosition);
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mIInputContext.commitText(text, newCursorPosition);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.310 -0400", hash_original_method = "EAB5E616D3D3B282F88520753342CC96", hash_generated_method = "13D8232E8EA64A3F50C422EDF7553701")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean commitCompletion(CompletionInfo text) {
        dsTaint.addTaint(text.dsTaint);
        try 
        {
            mIInputContext.commitCompletion(text);
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mIInputContext.commitCompletion(text);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.310 -0400", hash_original_method = "6923A4DC7941C069C654C30365BCACDD", hash_generated_method = "3C431183F47D29568F6A16C85AE0D19D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        dsTaint.addTaint(correctionInfo.dsTaint);
        try 
        {
            mIInputContext.commitCorrection(correctionInfo);
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mIInputContext.commitCorrection(correctionInfo);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.310 -0400", hash_original_method = "7022EC7ED2F239685C7BD3195B6CEAE9", hash_generated_method = "61C5744243908B4404048BFB2312BEA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setSelection(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        try 
        {
            mIInputContext.setSelection(start, end);
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mIInputContext.setSelection(start, end);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.310 -0400", hash_original_method = "67A8A8F86F1AE5123A01275D8828212B", hash_generated_method = "7FD30B43C77CE2039C0E9A048C3986ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performEditorAction(int actionCode) {
        dsTaint.addTaint(actionCode);
        try 
        {
            mIInputContext.performEditorAction(actionCode);
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mIInputContext.performEditorAction(actionCode);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.310 -0400", hash_original_method = "F7AEA38F9035D01924C8EE6C58DE4221", hash_generated_method = "3EC5A0FBA18FB9A128AFC71304B3BA70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performContextMenuAction(int id) {
        dsTaint.addTaint(id);
        try 
        {
            mIInputContext.performContextMenuAction(id);
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mIInputContext.performContextMenuAction(id);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.311 -0400", hash_original_method = "D57326DB6E974535AC174E0CB4F4F72D", hash_generated_method = "B577A262C6E34BB1EDD23D56ED9EED4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setComposingRegion(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        try 
        {
            mIInputContext.setComposingRegion(start, end);
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mIInputContext.setComposingRegion(start, end);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.311 -0400", hash_original_method = "DE2855A916E2A0C96139F9B28AC632EF", hash_generated_method = "4128FD39FFEF59BCF504F53AF59847D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        dsTaint.addTaint(newCursorPosition);
        dsTaint.addTaint(text);
        try 
        {
            mIInputContext.setComposingText(text, newCursorPosition);
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mIInputContext.setComposingText(text, newCursorPosition);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.311 -0400", hash_original_method = "654CA187A88EAE1F2AB6640B00B6686A", hash_generated_method = "49D1B70BDE706169E4D0BA289D3B7B3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean finishComposingText() {
        try 
        {
            mIInputContext.finishComposingText();
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mIInputContext.finishComposingText();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.312 -0400", hash_original_method = "F214558E918685C9D34C6BD9CACE39BA", hash_generated_method = "81E6FDCC803EE3928287EDF869CF8881")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean beginBatchEdit() {
        try 
        {
            mIInputContext.beginBatchEdit();
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mIInputContext.beginBatchEdit();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.312 -0400", hash_original_method = "FFD20A357B6026C06481613009C9A85C", hash_generated_method = "8FFD2EFBC0E20085A5641D06B7FED354")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean endBatchEdit() {
        try 
        {
            mIInputContext.endBatchEdit();
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mIInputContext.endBatchEdit();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.312 -0400", hash_original_method = "BDB80433761F466B2EC1080474660009", hash_generated_method = "30A4F5B7304F2D7E9F8E0CCDA033AE0C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean sendKeyEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        try 
        {
            mIInputContext.sendKeyEvent(event);
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mIInputContext.sendKeyEvent(event);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.312 -0400", hash_original_method = "3A88C36966ABDB3053599F030E0CFC04", hash_generated_method = "8F2AF7A6DBFC0FA7B6DBDC239F883FA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean clearMetaKeyStates(int states) {
        dsTaint.addTaint(states);
        try 
        {
            mIInputContext.clearMetaKeyStates(states);
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mIInputContext.clearMetaKeyStates(states);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.312 -0400", hash_original_method = "A0EA155ACF6A2B88254811510DB0CC9C", hash_generated_method = "5AA57840B453D853C5E2226AB3D9C2F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean deleteSurroundingText(int leftLength, int rightLength) {
        dsTaint.addTaint(leftLength);
        dsTaint.addTaint(rightLength);
        try 
        {
            mIInputContext.deleteSurroundingText(leftLength, rightLength);
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mIInputContext.deleteSurroundingText(leftLength, rightLength);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.313 -0400", hash_original_method = "F356C6E7AA9EF97C6745E94B41944104", hash_generated_method = "E86919DA127C3FE1E2DC40FCA9A8D964")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean reportFullscreenMode(boolean enabled) {
        dsTaint.addTaint(enabled);
        try 
        {
            mIInputContext.reportFullscreenMode(enabled);
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mIInputContext.reportFullscreenMode(enabled);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.313 -0400", hash_original_method = "C4A420F599BD094A8850BEFF4D3FF18D", hash_generated_method = "8BB47CBD631D78FF12DA1A0950D7B839")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean performPrivateCommand(String action, Bundle data) {
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(action);
        try 
        {
            mIInputContext.performPrivateCommand(action, data);
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //mIInputContext.performPrivateCommand(action, data);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    static class InputContextCallback extends IInputContextCallback.Stub {
        public int mSeq;
        public boolean mHaveValue;
        public CharSequence mTextBeforeCursor;
        public CharSequence mTextAfterCursor;
        public CharSequence mSelectedText;
        public ExtractedText mExtractedText;
        public int mCursorCapsMode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.313 -0400", hash_original_method = "BB93BA05BE44A4858D9B4ED0884CD846", hash_generated_method = "BB93BA05BE44A4858D9B4ED0884CD846")
                public InputContextCallback ()
        {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.313 -0400", hash_original_method = "114A3AA754115CB63309037B1A16C75C", hash_generated_method = "DEB7402431C747CDAA87E13C266B649E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.314 -0400", hash_original_method = "361E9A3C637FF701A52DA6E2E96E1B0D", hash_generated_method = "A9E884EABEB9A9D74955E08C8710B262")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setTextBeforeCursor(CharSequence textBeforeCursor, int seq) {
            dsTaint.addTaint(seq);
            dsTaint.addTaint(textBeforeCursor);
            {
                {
                    mHaveValue = true;
                    notifyAll();
                } //End block
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.314 -0400", hash_original_method = "364CB8CF32311AACA17721A234C603BF", hash_generated_method = "0E8DC169E686751927E944274CF26404")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setTextAfterCursor(CharSequence textAfterCursor, int seq) {
            dsTaint.addTaint(seq);
            dsTaint.addTaint(textAfterCursor);
            {
                {
                    mHaveValue = true;
                    notifyAll();
                } //End block
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.314 -0400", hash_original_method = "22EEF86B76323A3D0B42A8BDC8D7F847", hash_generated_method = "D6B6EF9B3EC7295A091BFF271CA3ED86")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setSelectedText(CharSequence selectedText, int seq) {
            dsTaint.addTaint(seq);
            dsTaint.addTaint(selectedText);
            {
                {
                    mHaveValue = true;
                    notifyAll();
                } //End block
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.314 -0400", hash_original_method = "998E9B4FE98738EB2922C01E8488A9FE", hash_generated_method = "DAD5135C73E6907D297496465631F29D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setCursorCapsMode(int capsMode, int seq) {
            dsTaint.addTaint(capsMode);
            dsTaint.addTaint(seq);
            {
                {
                    mHaveValue = true;
                    notifyAll();
                } //End block
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.315 -0400", hash_original_method = "728CBF4CDD80384E151B1C8A539138C4", hash_generated_method = "9F1B159E0D7EAE36727D7CD8721EB1B9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setExtractedText(ExtractedText extractedText, int seq) {
            dsTaint.addTaint(seq);
            dsTaint.addTaint(extractedText.dsTaint);
            {
                {
                    mHaveValue = true;
                    notifyAll();
                } //End block
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.315 -0400", hash_original_method = "0DFF250C75DABF6F6E35FBCC4F44FCEA", hash_generated_method = "F8E382404609B34B32253EDA73E9BED9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        private static final String TAG = "InputConnectionWrapper.ICC";
        private static InputContextCallback sInstance = new InputContextCallback();
        private static int sSequenceNumber = 1;
    }


    
    private static final int MAX_WAIT_TIME_MILLIS = 2000;
}


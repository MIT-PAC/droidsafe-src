package com.android.internal.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;

public class InputConnectionWrapper implements InputConnection {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.190 -0500", hash_original_field = "E9873CB098A2C98AC4D1819D0F91D151", hash_generated_field = "E21C9D56222776C7795AA3D88992FF14")

    private static final int MAX_WAIT_TIME_MILLIS = 2000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.192 -0500", hash_original_field = "72027A70482354298567E3297708A343", hash_generated_field = "1993EA11D8BF196428670F5B97A83039")

    private  IInputContext mIInputContext;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.249 -0500", hash_original_method = "200A59D07195D77203DE13B6F1D7E213", hash_generated_method = "FF2FF88D9D7B9702A26D5DB6F3DE53E0")
    
public InputConnectionWrapper(IInputContext inputContext) {
        mIInputContext = inputContext;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.252 -0500", hash_original_method = "E5D9808718D85F214F56B5C74559D92A", hash_generated_method = "EA3159883AB88ED7C0D6815D39259AEB")
    
public CharSequence getTextAfterCursor(int length, int flags) {
        CharSequence value = null;
        try {
            InputContextCallback callback = InputContextCallback.getInstance();
            mIInputContext.getTextAfterCursor(length, flags, callback.mSeq, callback);
            synchronized (callback) {
                callback.waitForResultLocked();
                if (callback.mHaveValue) {
                    value = callback.mTextAfterCursor;
                }
            }
            callback.dispose();
        } catch (RemoteException e) {
            return null;
        }
        return value;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.255 -0500", hash_original_method = "161B1891DB80E123B2A48225941EF408", hash_generated_method = "6BE8A5259EA2E2E80550F974C27611CE")
    
public CharSequence getTextBeforeCursor(int length, int flags) {
        CharSequence value = null;
        try {
            InputContextCallback callback = InputContextCallback.getInstance();
            mIInputContext.getTextBeforeCursor(length, flags, callback.mSeq, callback);
            synchronized (callback) {
                callback.waitForResultLocked();
                if (callback.mHaveValue) {
                    value = callback.mTextBeforeCursor;
                }
            }
            callback.dispose();
        } catch (RemoteException e) {
            return null;
        }
        return value;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.258 -0500", hash_original_method = "07C2D6CA43F82EBF9A41822F1A0D86D8", hash_generated_method = "3CACE0803BD1CF02DE5BBC803DB93A38")
    
public CharSequence getSelectedText(int flags) {
        CharSequence value = null;
        try {
            InputContextCallback callback = InputContextCallback.getInstance();
            mIInputContext.getSelectedText(flags, callback.mSeq, callback);
            synchronized (callback) {
                callback.waitForResultLocked();
                if (callback.mHaveValue) {
                    value = callback.mSelectedText;
                }
            }
            callback.dispose();
        } catch (RemoteException e) {
            return null;
        }
        return value;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.260 -0500", hash_original_method = "42EA416764DB4DFF051E9040CF49BB73", hash_generated_method = "74FDE82B8EAB8AE4D6B3595F8DB25806")
    
public int getCursorCapsMode(int reqModes) {
        int value = 0;
        try {
            InputContextCallback callback = InputContextCallback.getInstance();
            mIInputContext.getCursorCapsMode(reqModes, callback.mSeq, callback);
            synchronized (callback) {
                callback.waitForResultLocked();
                if (callback.mHaveValue) {
                    value = callback.mCursorCapsMode;
                }
            }
            callback.dispose();
        } catch (RemoteException e) {
            return 0;
        }
        return value;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.262 -0500", hash_original_method = "305E28329FA220003F7366DA2A6BF238", hash_generated_method = "DC40C86ECBA41B8BD9AF2656F892886F")
    
public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        ExtractedText value = null;
        try {
            InputContextCallback callback = InputContextCallback.getInstance();
            mIInputContext.getExtractedText(request, flags, callback.mSeq, callback);
            synchronized (callback) {
                callback.waitForResultLocked();
                if (callback.mHaveValue) {
                    value = callback.mExtractedText;
                }
            }
            callback.dispose();
        } catch (RemoteException e) {
            return null;
        }
        return value;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.265 -0500", hash_original_method = "E23EA90B6F67D6C242A9505D14FF1F12", hash_generated_method = "274B60734FE68353A4CE6904F03D2238")
    
public boolean commitText(CharSequence text, int newCursorPosition) {
        try {
            mIInputContext.commitText(text, newCursorPosition);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.267 -0500", hash_original_method = "EAB5E616D3D3B282F88520753342CC96", hash_generated_method = "FA10DFB6A48E71E81F49311D3B627C3B")
    
public boolean commitCompletion(CompletionInfo text) {
        try {
            mIInputContext.commitCompletion(text);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.269 -0500", hash_original_method = "6923A4DC7941C069C654C30365BCACDD", hash_generated_method = "891092CE7525D640953F70A4EB1C697E")
    
public boolean commitCorrection(CorrectionInfo correctionInfo) {
        try {
            mIInputContext.commitCorrection(correctionInfo);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.272 -0500", hash_original_method = "7022EC7ED2F239685C7BD3195B6CEAE9", hash_generated_method = "C0273145DEAAAF5E483FE20E58A6EBA3")
    
public boolean setSelection(int start, int end) {
        try {
            mIInputContext.setSelection(start, end);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.275 -0500", hash_original_method = "67A8A8F86F1AE5123A01275D8828212B", hash_generated_method = "480A689AD84DA7FBAFED9A0B904DAC65")
    
public boolean performEditorAction(int actionCode) {
        try {
            mIInputContext.performEditorAction(actionCode);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.277 -0500", hash_original_method = "F7AEA38F9035D01924C8EE6C58DE4221", hash_generated_method = "BE59FAC1E7EBE7A91B6F09A9FE24E9C7")
    
public boolean performContextMenuAction(int id) {
        try {
            mIInputContext.performContextMenuAction(id);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.280 -0500", hash_original_method = "D57326DB6E974535AC174E0CB4F4F72D", hash_generated_method = "DBE40ED179C98BEF3FE80DBB5AC8D3A3")
    
public boolean setComposingRegion(int start, int end) {
        try {
            mIInputContext.setComposingRegion(start, end);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.283 -0500", hash_original_method = "DE2855A916E2A0C96139F9B28AC632EF", hash_generated_method = "44924D92C4C4ACA75644C142667070B8")
    
public boolean setComposingText(CharSequence text, int newCursorPosition) {
        try {
            mIInputContext.setComposingText(text, newCursorPosition);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.286 -0500", hash_original_method = "654CA187A88EAE1F2AB6640B00B6686A", hash_generated_method = "BD4B9D90373076A07A4944FD0B892306")
    
public boolean finishComposingText() {
        try {
            mIInputContext.finishComposingText();
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.288 -0500", hash_original_method = "F214558E918685C9D34C6BD9CACE39BA", hash_generated_method = "A3496CBDCEC0C0E5F8C9AA35D8BC71C7")
    
public boolean beginBatchEdit() {
        try {
            mIInputContext.beginBatchEdit();
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.291 -0500", hash_original_method = "FFD20A357B6026C06481613009C9A85C", hash_generated_method = "438706CCA8AEFE590CCD9D5701C9CD83")
    
public boolean endBatchEdit() {
        try {
            mIInputContext.endBatchEdit();
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.293 -0500", hash_original_method = "BDB80433761F466B2EC1080474660009", hash_generated_method = "976159EF6C227ED01611A9ABE8A82929")
    
public boolean sendKeyEvent(KeyEvent event) {
        try {
            mIInputContext.sendKeyEvent(event);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.296 -0500", hash_original_method = "3A88C36966ABDB3053599F030E0CFC04", hash_generated_method = "55CD246EB2ECD4069A65C30C5DAEC100")
    
public boolean clearMetaKeyStates(int states) {
        try {
            mIInputContext.clearMetaKeyStates(states);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.298 -0500", hash_original_method = "A0EA155ACF6A2B88254811510DB0CC9C", hash_generated_method = "8E404725488D5130211C63815BEAC433")
    
public boolean deleteSurroundingText(int leftLength, int rightLength) {
        try {
            mIInputContext.deleteSurroundingText(leftLength, rightLength);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.306 -0500", hash_original_method = "F356C6E7AA9EF97C6745E94B41944104", hash_generated_method = "1F8C63167180B0EC0798136F2D6D2CFE")
    
public boolean reportFullscreenMode(boolean enabled) {
        try {
            mIInputContext.reportFullscreenMode(enabled);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }
    
    static class InputContextCallback extends IInputContextCallback.Stub {
        
        /**
         * Returns an InputContextCallback object that is guaranteed not to be in use by
         * any other thread.  The returned object's 'have value' flag is cleared and its expected
         * sequence number is set to a new integer.  We use a sequence number so that replies that
         * occur after a timeout has expired are not interpreted as replies to a later request.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.223 -0500", hash_original_method = "79199601FF23ED9F63C7B3C367717F98", hash_generated_method = "5144601E411402B9EE9F2A3B02D7F44A")
        
private static InputContextCallback getInstance() {
            synchronized (InputContextCallback.class) {
                // Return sInstance if it's non-null, otherwise construct a new callback
                InputContextCallback callback;
                if (sInstance != null) {
                    callback = sInstance;
                    sInstance = null;
                    
                    // Reset the callback
                    callback.mHaveValue = false;
                } else {
                    callback = new InputContextCallback();
                }
                
                // Set the sequence number
                callback.mSeq = sSequenceNumber++;
                return callback;
            }
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.195 -0500", hash_original_field = "CBCC538686D66B20E25049ECC9B4C638", hash_generated_field = "878BD2023E90083E95CB4B2EC8F39CF9")

        private static final String TAG = "InputConnectionWrapper.ICC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.217 -0500", hash_original_field = "BC26560F1C2F75219862F30C92735A20", hash_generated_field = "EA4A799720EF830A3BCAFCF255C81800")

        // exclusive access to this object.
        private static InputContextCallback sInstance = new InputContextCallback();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.220 -0500", hash_original_field = "AF23F7F3C936766571463C15A537F82B", hash_generated_field = "54D86ECADB2242C49D518A04742826C9")

        private static int sSequenceNumber = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.198 -0500", hash_original_field = "8913F44A11D4302ED7B203F0CF0BA11B", hash_generated_field = "FF1C2ACF522E25E367200C0572BE8DA1")

        public int mSeq;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.201 -0500", hash_original_field = "82DF7D1437FD58E73DAC57D82F78B23A", hash_generated_field = "4D2C9CAFD7EF62D4BB15576A5CC2ECC3")

        public boolean mHaveValue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.204 -0500", hash_original_field = "21C0ECF79BE22DD9690D7AB4B3646B4A", hash_generated_field = "58D5B63A8A0C4A7E8BAB109575D64E4D")

        public CharSequence mTextBeforeCursor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.206 -0500", hash_original_field = "557AAFD88635A37EBFAC4448E1B7DBD5", hash_generated_field = "9FB6F0C8456D90D8021099BE30489DC5")

        public CharSequence mTextAfterCursor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.208 -0500", hash_original_field = "E85F78ABF051A4A919144C0CB6A07EFA", hash_generated_field = "57A04860072A486B5F1E41658D97AC82")

        public CharSequence mSelectedText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.211 -0500", hash_original_field = "7C5C99560AB4918E13830D06100AC03C", hash_generated_field = "482594694449567A160FA3F5524709A0")

        public ExtractedText mExtractedText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.215 -0500", hash_original_field = "7DF3F15A1FF3925669D9ED978BFB9F20", hash_generated_field = "C92D0BC414C6A30B2A5E4D2844301587")

        public int mCursorCapsMode;
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.785 -0400", hash_original_method = "C2F7B541292D8E4E042270C21CD2A858", hash_generated_method = "C2F7B541292D8E4E042270C21CD2A858")
        public InputContextCallback ()
        {
            //Synthesized constructor
        }
        
        /**
         * Makes the given InputContextCallback available for use in the future.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.227 -0500", hash_original_method = "114A3AA754115CB63309037B1A16C75C", hash_generated_method = "782115CA1F540B7D7546684D76970302")
        
private void dispose() {
            synchronized (InputContextCallback.class) {
                // If sInstance is non-null, just let this object be garbage-collected
                if (sInstance == null) {
                    // Allow any objects being held to be gc'ed
                    mTextAfterCursor = null;
                    mTextBeforeCursor = null;
                    mExtractedText = null;
                    sInstance = this;
                }
            }
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.229 -0500", hash_original_method = "361E9A3C637FF701A52DA6E2E96E1B0D", hash_generated_method = "7955AB022F095EAD64DACE6F466DA60D")
        
public void setTextBeforeCursor(CharSequence textBeforeCursor, int seq) {
            synchronized (this) {
                if (seq == mSeq) {
                    mTextBeforeCursor = textBeforeCursor;
                    mHaveValue = true;
                    notifyAll();
                } else {
                    Log.i(TAG, "Got out-of-sequence callback " + seq + " (expected " + mSeq
                            + ") in setTextBeforeCursor, ignoring.");
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.233 -0500", hash_original_method = "364CB8CF32311AACA17721A234C603BF", hash_generated_method = "140E5944110A485BDDA035A0DE57E76F")
        
public void setTextAfterCursor(CharSequence textAfterCursor, int seq) {
            synchronized (this) {
                if (seq == mSeq) {
                    mTextAfterCursor = textAfterCursor;
                    mHaveValue = true;
                    notifyAll();
                } else {
                    Log.i(TAG, "Got out-of-sequence callback " + seq + " (expected " + mSeq
                            + ") in setTextAfterCursor, ignoring.");
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.235 -0500", hash_original_method = "22EEF86B76323A3D0B42A8BDC8D7F847", hash_generated_method = "E6B2A99372859DFC7F8394FF506A693A")
        
public void setSelectedText(CharSequence selectedText, int seq) {
            synchronized (this) {
                if (seq == mSeq) {
                    mSelectedText = selectedText;
                    mHaveValue = true;
                    notifyAll();
                } else {
                    Log.i(TAG, "Got out-of-sequence callback " + seq + " (expected " + mSeq
                            + ") in setSelectedText, ignoring.");
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.238 -0500", hash_original_method = "998E9B4FE98738EB2922C01E8488A9FE", hash_generated_method = "38D53AE280F7DEC3065349D2CEA772B3")
        
public void setCursorCapsMode(int capsMode, int seq) {
            synchronized (this) {
                if (seq == mSeq) {
                    mCursorCapsMode = capsMode; 
                    mHaveValue = true;  
                    notifyAll();
                } else {
                    Log.i(TAG, "Got out-of-sequence callback " + seq + " (expected " + mSeq
                            + ") in setCursorCapsMode, ignoring.");
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.240 -0500", hash_original_method = "728CBF4CDD80384E151B1C8A539138C4", hash_generated_method = "6BF3A4129CED41B2C37962E5521B6A25")
        
public void setExtractedText(ExtractedText extractedText, int seq) {
            synchronized (this) {
                if (seq == mSeq) {
                    mExtractedText = extractedText;
                    mHaveValue = true;
                    notifyAll();
                } else {
                    Log.i(TAG, "Got out-of-sequence callback " + seq + " (expected " + mSeq
                            + ") in setExtractedText, ignoring.");
                }
            }
        }
        
        /**
         * Waits for a result for up to {@link #MAX_WAIT_TIME_MILLIS} milliseconds.
         * 
         * <p>The caller must be synchronized on this callback object.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.243 -0500", hash_original_method = "0DFF250C75DABF6F6E35FBCC4F44FCEA", hash_generated_method = "0DFF250C75DABF6F6E35FBCC4F44FCEA")
        
void waitForResultLocked() {
            long startTime = SystemClock.uptimeMillis();
            long endTime = startTime + MAX_WAIT_TIME_MILLIS;

            while (!mHaveValue) {
                long remainingTime = endTime - SystemClock.uptimeMillis();
                if (remainingTime <= 0) {
                    Log.w(TAG, "Timed out waiting on IInputContextCallback");
                    return;
                }
                try {
                    wait(remainingTime);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:32.308 -0500", hash_original_method = "C4A420F599BD094A8850BEFF4D3FF18D", hash_generated_method = "75255E3CF5D2BCA179DE66E8C41D080F")
    
public boolean performPrivateCommand(String action, Bundle data) {
        try {
            mIInputContext.performPrivateCommand(action, data);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }
}


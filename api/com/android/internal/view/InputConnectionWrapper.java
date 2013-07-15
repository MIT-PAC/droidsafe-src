package com.android.internal.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.706 -0400", hash_original_field = "4AC36937F366B7AB4CCDC4F1F414F47C", hash_generated_field = "1993EA11D8BF196428670F5B97A83039")

    private IInputContext mIInputContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.707 -0400", hash_original_method = "200A59D07195D77203DE13B6F1D7E213", hash_generated_method = "7612BD2DCE02136E56A8BD3FD04ECE95")
    public  InputConnectionWrapper(IInputContext inputContext) {
        mIInputContext = inputContext;
        // ---------- Original Method ----------
        //mIInputContext = inputContext;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.707 -0400", hash_original_method = "E5D9808718D85F214F56B5C74559D92A", hash_generated_method = "3F24C19F09E5CE2A63757E5C2D02A708")
    public CharSequence getTextAfterCursor(int length, int flags) {
        addTaint(flags);
        addTaint(length);
        CharSequence value = null;
        try 
        {
            InputContextCallback callback = InputContextCallback.getInstance();
            mIInputContext.getTextAfterCursor(length, flags, callback.mSeq, callback);
            synchronized
(callback)            {
                callback.waitForResultLocked();
    if(callback.mHaveValue)                
                {
                    value = callback.mTextAfterCursor;
                } //End block
            } //End block
            callback.dispose();
        } //End block
        catch (RemoteException e)
        {
CharSequence var540C13E9E156B687226421B24F2DF178_1605855647 =             null;
            var540C13E9E156B687226421B24F2DF178_1605855647.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1605855647;
        } //End block
CharSequence varAF280DA2BC37D8BE783D8499160168DE_327423035 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_327423035.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_327423035;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.708 -0400", hash_original_method = "161B1891DB80E123B2A48225941EF408", hash_generated_method = "1D284987141D4E9B735A7963FCDE7634")
    public CharSequence getTextBeforeCursor(int length, int flags) {
        addTaint(flags);
        addTaint(length);
        CharSequence value = null;
        try 
        {
            InputContextCallback callback = InputContextCallback.getInstance();
            mIInputContext.getTextBeforeCursor(length, flags, callback.mSeq, callback);
            synchronized
(callback)            {
                callback.waitForResultLocked();
    if(callback.mHaveValue)                
                {
                    value = callback.mTextBeforeCursor;
                } //End block
            } //End block
            callback.dispose();
        } //End block
        catch (RemoteException e)
        {
CharSequence var540C13E9E156B687226421B24F2DF178_1040312709 =             null;
            var540C13E9E156B687226421B24F2DF178_1040312709.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1040312709;
        } //End block
CharSequence varAF280DA2BC37D8BE783D8499160168DE_540881060 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_540881060.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_540881060;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.709 -0400", hash_original_method = "07C2D6CA43F82EBF9A41822F1A0D86D8", hash_generated_method = "8F47A066A24B9C6FCAD38980CC6C072F")
    public CharSequence getSelectedText(int flags) {
        addTaint(flags);
        CharSequence value = null;
        try 
        {
            InputContextCallback callback = InputContextCallback.getInstance();
            mIInputContext.getSelectedText(flags, callback.mSeq, callback);
            synchronized
(callback)            {
                callback.waitForResultLocked();
    if(callback.mHaveValue)                
                {
                    value = callback.mSelectedText;
                } //End block
            } //End block
            callback.dispose();
        } //End block
        catch (RemoteException e)
        {
CharSequence var540C13E9E156B687226421B24F2DF178_1531066545 =             null;
            var540C13E9E156B687226421B24F2DF178_1531066545.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1531066545;
        } //End block
CharSequence varAF280DA2BC37D8BE783D8499160168DE_1567368463 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_1567368463.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_1567368463;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.710 -0400", hash_original_method = "42EA416764DB4DFF051E9040CF49BB73", hash_generated_method = "F9197F3D7527B707C49362D3953C482A")
    public int getCursorCapsMode(int reqModes) {
        addTaint(reqModes);
        int value = 0;
        try 
        {
            InputContextCallback callback = InputContextCallback.getInstance();
            mIInputContext.getCursorCapsMode(reqModes, callback.mSeq, callback);
            synchronized
(callback)            {
                callback.waitForResultLocked();
    if(callback.mHaveValue)                
                {
                    value = callback.mCursorCapsMode;
                } //End block
            } //End block
            callback.dispose();
        } //End block
        catch (RemoteException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1390684332 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_461350045 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_461350045;
        } //End block
        int var2063C1608D6E0BAF80249C42E2BE5804_349375779 = (value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_788218782 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_788218782;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.710 -0400", hash_original_method = "305E28329FA220003F7366DA2A6BF238", hash_generated_method = "2E8B63DC0AD18E60D7942E4B84C30831")
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        addTaint(flags);
        addTaint(request.getTaint());
        ExtractedText value = null;
        try 
        {
            InputContextCallback callback = InputContextCallback.getInstance();
            mIInputContext.getExtractedText(request, flags, callback.mSeq, callback);
            synchronized
(callback)            {
                callback.waitForResultLocked();
    if(callback.mHaveValue)                
                {
                    value = callback.mExtractedText;
                } //End block
            } //End block
            callback.dispose();
        } //End block
        catch (RemoteException e)
        {
ExtractedText var540C13E9E156B687226421B24F2DF178_1016248608 =             null;
            var540C13E9E156B687226421B24F2DF178_1016248608.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1016248608;
        } //End block
ExtractedText varAF280DA2BC37D8BE783D8499160168DE_550734943 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_550734943.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_550734943;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.711 -0400", hash_original_method = "E23EA90B6F67D6C242A9505D14FF1F12", hash_generated_method = "F93062ECA7D51EFBF2B4484C29ECDC50")
    public boolean commitText(CharSequence text, int newCursorPosition) {
        addTaint(newCursorPosition);
        addTaint(text.getTaint());
        try 
        {
            mIInputContext.commitText(text, newCursorPosition);
            boolean varB326B5062B2F0E69046810717534CB09_519839199 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2008988784 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2008988784;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_463121921 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_265516181 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_265516181;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.commitText(text, newCursorPosition);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.711 -0400", hash_original_method = "EAB5E616D3D3B282F88520753342CC96", hash_generated_method = "F4101C966B72C8D14A4B8C0E7B7B3BDB")
    public boolean commitCompletion(CompletionInfo text) {
        addTaint(text.getTaint());
        try 
        {
            mIInputContext.commitCompletion(text);
            boolean varB326B5062B2F0E69046810717534CB09_388867008 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1160107178 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1160107178;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_326012107 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1326718306 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1326718306;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.commitCompletion(text);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.712 -0400", hash_original_method = "6923A4DC7941C069C654C30365BCACDD", hash_generated_method = "FA403E0BA91D728582D273612446B2A2")
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        addTaint(correctionInfo.getTaint());
        try 
        {
            mIInputContext.commitCorrection(correctionInfo);
            boolean varB326B5062B2F0E69046810717534CB09_2114906311 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1706803444 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1706803444;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1334972390 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1555727707 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1555727707;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.commitCorrection(correctionInfo);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.712 -0400", hash_original_method = "7022EC7ED2F239685C7BD3195B6CEAE9", hash_generated_method = "AA6F1F4EAC134E1D3877196A82CBE931")
    public boolean setSelection(int start, int end) {
        addTaint(end);
        addTaint(start);
        try 
        {
            mIInputContext.setSelection(start, end);
            boolean varB326B5062B2F0E69046810717534CB09_547941238 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_416112853 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_416112853;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1257151284 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1439275749 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1439275749;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.setSelection(start, end);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.713 -0400", hash_original_method = "67A8A8F86F1AE5123A01275D8828212B", hash_generated_method = "54FA51C7CF1FA707C23189D1ED5E3E8E")
    public boolean performEditorAction(int actionCode) {
        addTaint(actionCode);
        try 
        {
            mIInputContext.performEditorAction(actionCode);
            boolean varB326B5062B2F0E69046810717534CB09_1343334463 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1700060876 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1700060876;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1656124946 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1391243467 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1391243467;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.performEditorAction(actionCode);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.713 -0400", hash_original_method = "F7AEA38F9035D01924C8EE6C58DE4221", hash_generated_method = "FE4CA695CCB11656896415479A10BA85")
    public boolean performContextMenuAction(int id) {
        addTaint(id);
        try 
        {
            mIInputContext.performContextMenuAction(id);
            boolean varB326B5062B2F0E69046810717534CB09_1924649767 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_73221147 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_73221147;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_951480610 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1109939734 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1109939734;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.performContextMenuAction(id);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.713 -0400", hash_original_method = "D57326DB6E974535AC174E0CB4F4F72D", hash_generated_method = "ADBE29DC1CBA67CAEF5F9B9B5F27FC1F")
    public boolean setComposingRegion(int start, int end) {
        addTaint(end);
        addTaint(start);
        try 
        {
            mIInputContext.setComposingRegion(start, end);
            boolean varB326B5062B2F0E69046810717534CB09_871966299 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1181978090 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1181978090;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_405305421 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1481512324 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1481512324;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.setComposingRegion(start, end);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.714 -0400", hash_original_method = "DE2855A916E2A0C96139F9B28AC632EF", hash_generated_method = "89180E8CCF3221A57A0510FB4593BA9D")
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        addTaint(newCursorPosition);
        addTaint(text.getTaint());
        try 
        {
            mIInputContext.setComposingText(text, newCursorPosition);
            boolean varB326B5062B2F0E69046810717534CB09_669501479 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_64333597 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_64333597;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_619721461 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1732977059 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1732977059;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.setComposingText(text, newCursorPosition);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.714 -0400", hash_original_method = "654CA187A88EAE1F2AB6640B00B6686A", hash_generated_method = "6CE16691B41B8EC5EBC85843F056022F")
    public boolean finishComposingText() {
        try 
        {
            mIInputContext.finishComposingText();
            boolean varB326B5062B2F0E69046810717534CB09_799012430 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1427433378 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1427433378;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1719981324 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_146100730 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_146100730;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.finishComposingText();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.714 -0400", hash_original_method = "F214558E918685C9D34C6BD9CACE39BA", hash_generated_method = "EC9D6479542D37933704D0875DF1CE08")
    public boolean beginBatchEdit() {
        try 
        {
            mIInputContext.beginBatchEdit();
            boolean varB326B5062B2F0E69046810717534CB09_525141302 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_275965950 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_275965950;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_857068929 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1277891568 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1277891568;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.beginBatchEdit();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.715 -0400", hash_original_method = "FFD20A357B6026C06481613009C9A85C", hash_generated_method = "5B9057D14AFE98B434F38637E9DC9813")
    public boolean endBatchEdit() {
        try 
        {
            mIInputContext.endBatchEdit();
            boolean varB326B5062B2F0E69046810717534CB09_450490426 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_595980825 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_595980825;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1842672517 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_233862653 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_233862653;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.endBatchEdit();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.715 -0400", hash_original_method = "BDB80433761F466B2EC1080474660009", hash_generated_method = "B173C2EC5E0FA8C6C2C8EA687294BD93")
    public boolean sendKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        try 
        {
            mIInputContext.sendKeyEvent(event);
            boolean varB326B5062B2F0E69046810717534CB09_250878451 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_454087611 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_454087611;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_951423564 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_598090387 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_598090387;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.sendKeyEvent(event);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.716 -0400", hash_original_method = "3A88C36966ABDB3053599F030E0CFC04", hash_generated_method = "7A43CCF03E2F3B5BB93E64F2AEE4D500")
    public boolean clearMetaKeyStates(int states) {
        addTaint(states);
        try 
        {
            mIInputContext.clearMetaKeyStates(states);
            boolean varB326B5062B2F0E69046810717534CB09_2135672917 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1510239191 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1510239191;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1495298796 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2091073310 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2091073310;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.clearMetaKeyStates(states);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.716 -0400", hash_original_method = "A0EA155ACF6A2B88254811510DB0CC9C", hash_generated_method = "83A8329FB6E48FE335040CE496546A84")
    public boolean deleteSurroundingText(int leftLength, int rightLength) {
        addTaint(rightLength);
        addTaint(leftLength);
        try 
        {
            mIInputContext.deleteSurroundingText(leftLength, rightLength);
            boolean varB326B5062B2F0E69046810717534CB09_1753185073 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1531725969 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1531725969;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_2142029670 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1437722390 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1437722390;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.deleteSurroundingText(leftLength, rightLength);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.716 -0400", hash_original_method = "F356C6E7AA9EF97C6745E94B41944104", hash_generated_method = "519EFDDC5E6021F93EF7834E6A1EC1BB")
    public boolean reportFullscreenMode(boolean enabled) {
        addTaint(enabled);
        try 
        {
            mIInputContext.reportFullscreenMode(enabled);
            boolean varB326B5062B2F0E69046810717534CB09_675984530 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1517442722 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1517442722;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1313276517 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1414319043 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1414319043;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.reportFullscreenMode(enabled);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.717 -0400", hash_original_method = "C4A420F599BD094A8850BEFF4D3FF18D", hash_generated_method = "737525350416C29740D620A0CB1CFE06")
    public boolean performPrivateCommand(String action, Bundle data) {
        addTaint(data.getTaint());
        addTaint(action.getTaint());
        try 
        {
            mIInputContext.performPrivateCommand(action, data);
            boolean varB326B5062B2F0E69046810717534CB09_1166498834 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1032070600 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1032070600;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_134191521 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2131985619 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2131985619;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.performPrivateCommand(action, data);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    static class InputContextCallback extends IInputContextCallback.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.717 -0400", hash_original_field = "61A42A5C5A78D6632BB173F2CD44E374", hash_generated_field = "FF1C2ACF522E25E367200C0572BE8DA1")

        public int mSeq;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.717 -0400", hash_original_field = "C871C935A9FFBB5A72B3BC90796F592F", hash_generated_field = "4D2C9CAFD7EF62D4BB15576A5CC2ECC3")

        public boolean mHaveValue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.717 -0400", hash_original_field = "F423FDF2985DDF32E87605AFE9C6978B", hash_generated_field = "58D5B63A8A0C4A7E8BAB109575D64E4D")

        public CharSequence mTextBeforeCursor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.717 -0400", hash_original_field = "65BD4E602AB1BF88FE45543DD84DD6E2", hash_generated_field = "9FB6F0C8456D90D8021099BE30489DC5")

        public CharSequence mTextAfterCursor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.717 -0400", hash_original_field = "7AC72A89563F8A56517E860A9DBEF362", hash_generated_field = "57A04860072A486B5F1E41658D97AC82")

        public CharSequence mSelectedText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.717 -0400", hash_original_field = "A034AA34A307E777C43933E669A375DC", hash_generated_field = "482594694449567A160FA3F5524709A0")

        public ExtractedText mExtractedText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.717 -0400", hash_original_field = "9BC83ACBBA6BD4A8D823866CA0DC5705", hash_generated_field = "C92D0BC414C6A30B2A5E4D2844301587")

        public int mCursorCapsMode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.718 -0400", hash_original_method = "C2F7B541292D8E4E042270C21CD2A858", hash_generated_method = "C2F7B541292D8E4E042270C21CD2A858")
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.718 -0400", hash_original_method = "114A3AA754115CB63309037B1A16C75C", hash_generated_method = "9BD80E9ED6FC3B32FF54FD83C1DF9459")
        private void dispose() {
            synchronized
(InputContextCallback.class)            {
    if(sInstance == null)                
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.719 -0400", hash_original_method = "361E9A3C637FF701A52DA6E2E96E1B0D", hash_generated_method = "814A0D2CE3D6D41A396D781C1797E8E5")
        public void setTextBeforeCursor(CharSequence textBeforeCursor, int seq) {
            addTaint(seq);
            synchronized
(this)            {
    if(seq == mSeq)                
                {
                    mTextBeforeCursor = textBeforeCursor;
                    mHaveValue = true;
                    notifyAll();
                } //End block
                else
                {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.720 -0400", hash_original_method = "364CB8CF32311AACA17721A234C603BF", hash_generated_method = "975AA37A99088CB886312E87682854CB")
        public void setTextAfterCursor(CharSequence textAfterCursor, int seq) {
            addTaint(seq);
            synchronized
(this)            {
    if(seq == mSeq)                
                {
                    mTextAfterCursor = textAfterCursor;
                    mHaveValue = true;
                    notifyAll();
                } //End block
                else
                {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.721 -0400", hash_original_method = "22EEF86B76323A3D0B42A8BDC8D7F847", hash_generated_method = "7373C5692B3E76C57D3C9353D6192FC4")
        public void setSelectedText(CharSequence selectedText, int seq) {
            addTaint(seq);
            synchronized
(this)            {
    if(seq == mSeq)                
                {
                    mSelectedText = selectedText;
                    mHaveValue = true;
                    notifyAll();
                } //End block
                else
                {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.721 -0400", hash_original_method = "998E9B4FE98738EB2922C01E8488A9FE", hash_generated_method = "0C0A7E94B4E77405E233A018B6CEA3B4")
        public void setCursorCapsMode(int capsMode, int seq) {
            addTaint(seq);
            synchronized
(this)            {
    if(seq == mSeq)                
                {
                    mCursorCapsMode = capsMode;
                    mHaveValue = true;
                    notifyAll();
                } //End block
                else
                {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.722 -0400", hash_original_method = "728CBF4CDD80384E151B1C8A539138C4", hash_generated_method = "1309DAA77656ADC61D18ECA3FC0E6D1A")
        public void setExtractedText(ExtractedText extractedText, int seq) {
            addTaint(seq);
            synchronized
(this)            {
    if(seq == mSeq)                
                {
                    mExtractedText = extractedText;
                    mHaveValue = true;
                    notifyAll();
                } //End block
                else
                {
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

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.722 -0400", hash_original_method = "0DFF250C75DABF6F6E35FBCC4F44FCEA", hash_generated_method = "49A1CCF5EB26A17E95436859628A9D7E")
         void waitForResultLocked() {
            long startTime = SystemClock.uptimeMillis();
            long endTime = startTime + MAX_WAIT_TIME_MILLIS;
            while
(!mHaveValue)            
            {
                long remainingTime = endTime - SystemClock.uptimeMillis();
    if(remainingTime <= 0)                
                {
                    return;
                } //End block
                try 
                {
                    wait(remainingTime);
                } //End block
                catch (InterruptedException e)
                {
                } //End block
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.723 -0400", hash_original_field = "D625C16187F9C03B97B300FD3342652B", hash_generated_field = "878BD2023E90083E95CB4B2EC8F39CF9")

        private static final String TAG = "InputConnectionWrapper.ICC";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.723 -0400", hash_original_field = "988FFA1F2B606800228BA347483121A3", hash_generated_field = "8C19ECF6955FF34778F11D83BE064C14")

        private static InputContextCallback sInstance = new InputContextCallback();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.723 -0400", hash_original_field = "FD62EFA389E2F9A7398A20D67E683F18", hash_generated_field = "54D86ECADB2242C49D518A04742826C9")

        private static int sSequenceNumber = 1;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.723 -0400", hash_original_field = "6267C4AF26D35EDB744787F96CED4081", hash_generated_field = "E21C9D56222776C7795AA3D88992FF14")

    private static final int MAX_WAIT_TIME_MILLIS = 2000;
}


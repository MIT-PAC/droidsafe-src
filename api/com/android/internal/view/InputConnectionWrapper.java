package com.android.internal.view;

// Droidsafe Imports
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class InputConnectionWrapper implements InputConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.772 -0400", hash_original_field = "4AC36937F366B7AB4CCDC4F1F414F47C", hash_generated_field = "1993EA11D8BF196428670F5B97A83039")

    private IInputContext mIInputContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.772 -0400", hash_original_method = "200A59D07195D77203DE13B6F1D7E213", hash_generated_method = "7612BD2DCE02136E56A8BD3FD04ECE95")
    public  InputConnectionWrapper(IInputContext inputContext) {
        mIInputContext = inputContext;
        // ---------- Original Method ----------
        //mIInputContext = inputContext;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.773 -0400", hash_original_method = "E5D9808718D85F214F56B5C74559D92A", hash_generated_method = "24D993B364CEBE6B56EBD339CF8E80F3")
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
CharSequence var540C13E9E156B687226421B24F2DF178_742300195 =             null;
            var540C13E9E156B687226421B24F2DF178_742300195.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_742300195;
        } //End block
CharSequence varAF280DA2BC37D8BE783D8499160168DE_1742729519 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_1742729519.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_1742729519;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.774 -0400", hash_original_method = "161B1891DB80E123B2A48225941EF408", hash_generated_method = "4AC02A1EE419D1812E1172F3A44AF356")
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
CharSequence var540C13E9E156B687226421B24F2DF178_382406610 =             null;
            var540C13E9E156B687226421B24F2DF178_382406610.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_382406610;
        } //End block
CharSequence varAF280DA2BC37D8BE783D8499160168DE_1916440754 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_1916440754.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_1916440754;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.775 -0400", hash_original_method = "07C2D6CA43F82EBF9A41822F1A0D86D8", hash_generated_method = "01E74F3264A46C181519C10EDCDAC262")
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
CharSequence var540C13E9E156B687226421B24F2DF178_641656898 =             null;
            var540C13E9E156B687226421B24F2DF178_641656898.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_641656898;
        } //End block
CharSequence varAF280DA2BC37D8BE783D8499160168DE_392809897 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_392809897.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_392809897;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.776 -0400", hash_original_method = "42EA416764DB4DFF051E9040CF49BB73", hash_generated_method = "BF48C18ACDA801E11DCB95A355F26F5F")
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
            int varCFCD208495D565EF66E7DFF9F98764DA_185629611 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1955403579 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1955403579;
        } //End block
        int var2063C1608D6E0BAF80249C42E2BE5804_208479617 = (value);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833776064 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833776064;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.777 -0400", hash_original_method = "305E28329FA220003F7366DA2A6BF238", hash_generated_method = "07B816D297C939FC6032E78E76D73445")
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
ExtractedText var540C13E9E156B687226421B24F2DF178_501421742 =             null;
            var540C13E9E156B687226421B24F2DF178_501421742.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_501421742;
        } //End block
ExtractedText varAF280DA2BC37D8BE783D8499160168DE_1947674392 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_1947674392.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_1947674392;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.777 -0400", hash_original_method = "E23EA90B6F67D6C242A9505D14FF1F12", hash_generated_method = "8EAD7EC195EE485907A6F221BB3762F5")
    public boolean commitText(CharSequence text, int newCursorPosition) {
        addTaint(newCursorPosition);
        addTaint(text.getTaint());
        try 
        {
            mIInputContext.commitText(text, newCursorPosition);
            boolean varB326B5062B2F0E69046810717534CB09_315004354 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2102391915 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2102391915;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1362118337 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_940351901 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_940351901;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.commitText(text, newCursorPosition);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.778 -0400", hash_original_method = "EAB5E616D3D3B282F88520753342CC96", hash_generated_method = "B6722BC94A79237954E9F04FEDEA3D4E")
    public boolean commitCompletion(CompletionInfo text) {
        addTaint(text.getTaint());
        try 
        {
            mIInputContext.commitCompletion(text);
            boolean varB326B5062B2F0E69046810717534CB09_1409067995 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_595967993 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_595967993;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_953036454 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_445414694 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_445414694;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.commitCompletion(text);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.778 -0400", hash_original_method = "6923A4DC7941C069C654C30365BCACDD", hash_generated_method = "5BA5FD2C1A401F32529A86213FE3FA9B")
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        addTaint(correctionInfo.getTaint());
        try 
        {
            mIInputContext.commitCorrection(correctionInfo);
            boolean varB326B5062B2F0E69046810717534CB09_399649607 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1932906646 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1932906646;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_2034022431 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_807323209 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_807323209;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.commitCorrection(correctionInfo);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.779 -0400", hash_original_method = "7022EC7ED2F239685C7BD3195B6CEAE9", hash_generated_method = "9891778ED56331102E97BCC2ED1853D0")
    public boolean setSelection(int start, int end) {
        addTaint(end);
        addTaint(start);
        try 
        {
            mIInputContext.setSelection(start, end);
            boolean varB326B5062B2F0E69046810717534CB09_294004528 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_527321656 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_527321656;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1257874543 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_175439946 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_175439946;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.setSelection(start, end);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.780 -0400", hash_original_method = "67A8A8F86F1AE5123A01275D8828212B", hash_generated_method = "70DF5D58C7551C2B38425942BAE7671B")
    public boolean performEditorAction(int actionCode) {
        addTaint(actionCode);
        try 
        {
            mIInputContext.performEditorAction(actionCode);
            boolean varB326B5062B2F0E69046810717534CB09_1211947614 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_722362763 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_722362763;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1393803110 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1964271405 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1964271405;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.performEditorAction(actionCode);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.780 -0400", hash_original_method = "F7AEA38F9035D01924C8EE6C58DE4221", hash_generated_method = "D004F4F152687868EA94B5DEFB3385D3")
    public boolean performContextMenuAction(int id) {
        addTaint(id);
        try 
        {
            mIInputContext.performContextMenuAction(id);
            boolean varB326B5062B2F0E69046810717534CB09_1569425568 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_161923749 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_161923749;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_817373522 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1979867876 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1979867876;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.performContextMenuAction(id);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.780 -0400", hash_original_method = "D57326DB6E974535AC174E0CB4F4F72D", hash_generated_method = "229739719DFA7CA36CE2341A45368089")
    public boolean setComposingRegion(int start, int end) {
        addTaint(end);
        addTaint(start);
        try 
        {
            mIInputContext.setComposingRegion(start, end);
            boolean varB326B5062B2F0E69046810717534CB09_541541785 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1310969490 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1310969490;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_561621888 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2115154680 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2115154680;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.setComposingRegion(start, end);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.781 -0400", hash_original_method = "DE2855A916E2A0C96139F9B28AC632EF", hash_generated_method = "B6D855407A29FAD8139E8AAFDA03317F")
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        addTaint(newCursorPosition);
        addTaint(text.getTaint());
        try 
        {
            mIInputContext.setComposingText(text, newCursorPosition);
            boolean varB326B5062B2F0E69046810717534CB09_538757775 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1629732403 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1629732403;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_190784352 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2126366409 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2126366409;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.setComposingText(text, newCursorPosition);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.781 -0400", hash_original_method = "654CA187A88EAE1F2AB6640B00B6686A", hash_generated_method = "889678409D3160A80CCD5EEEC782FBB7")
    public boolean finishComposingText() {
        try 
        {
            mIInputContext.finishComposingText();
            boolean varB326B5062B2F0E69046810717534CB09_215071401 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1884755657 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1884755657;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_684790106 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1179088540 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1179088540;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.finishComposingText();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.782 -0400", hash_original_method = "F214558E918685C9D34C6BD9CACE39BA", hash_generated_method = "057A75D2451BF4DF6F22D4472505FA6E")
    public boolean beginBatchEdit() {
        try 
        {
            mIInputContext.beginBatchEdit();
            boolean varB326B5062B2F0E69046810717534CB09_701593331 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_529755205 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_529755205;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1855998914 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1770866752 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1770866752;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.beginBatchEdit();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.782 -0400", hash_original_method = "FFD20A357B6026C06481613009C9A85C", hash_generated_method = "B90B27A038045B6245A97C24822B8949")
    public boolean endBatchEdit() {
        try 
        {
            mIInputContext.endBatchEdit();
            boolean varB326B5062B2F0E69046810717534CB09_444342097 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_739277329 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_739277329;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1376667290 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1921812892 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1921812892;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.endBatchEdit();
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.783 -0400", hash_original_method = "BDB80433761F466B2EC1080474660009", hash_generated_method = "DB6FFA7C0A24DE43C480DDA99798EC1A")
    public boolean sendKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        try 
        {
            mIInputContext.sendKeyEvent(event);
            boolean varB326B5062B2F0E69046810717534CB09_1085220606 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1999984214 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1999984214;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1711264324 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1550911992 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1550911992;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.sendKeyEvent(event);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.783 -0400", hash_original_method = "3A88C36966ABDB3053599F030E0CFC04", hash_generated_method = "54509AB51DEFC1884FA062139DB03FAE")
    public boolean clearMetaKeyStates(int states) {
        addTaint(states);
        try 
        {
            mIInputContext.clearMetaKeyStates(states);
            boolean varB326B5062B2F0E69046810717534CB09_1429423633 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1758106212 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1758106212;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_586702564 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_858451690 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_858451690;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.clearMetaKeyStates(states);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.784 -0400", hash_original_method = "A0EA155ACF6A2B88254811510DB0CC9C", hash_generated_method = "90F74F2B898ED2DC418A58FEC1836387")
    public boolean deleteSurroundingText(int leftLength, int rightLength) {
        addTaint(rightLength);
        addTaint(leftLength);
        try 
        {
            mIInputContext.deleteSurroundingText(leftLength, rightLength);
            boolean varB326B5062B2F0E69046810717534CB09_2081819588 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2000180494 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2000180494;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_982798091 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_188673840 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_188673840;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.deleteSurroundingText(leftLength, rightLength);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.784 -0400", hash_original_method = "F356C6E7AA9EF97C6745E94B41944104", hash_generated_method = "7577681F786178B1D4B161E84C30DDE2")
    public boolean reportFullscreenMode(boolean enabled) {
        addTaint(enabled);
        try 
        {
            mIInputContext.reportFullscreenMode(enabled);
            boolean varB326B5062B2F0E69046810717534CB09_1582281206 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_544342258 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_544342258;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_696475050 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_536334996 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_536334996;
        } //End block
        // ---------- Original Method ----------
        //try {
            //mIInputContext.reportFullscreenMode(enabled);
            //return true;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.784 -0400", hash_original_method = "C4A420F599BD094A8850BEFF4D3FF18D", hash_generated_method = "7C8D8EDAFBBFF7175DB0EF35AABAD225")
    public boolean performPrivateCommand(String action, Bundle data) {
        addTaint(data.getTaint());
        addTaint(action.getTaint());
        try 
        {
            mIInputContext.performPrivateCommand(action, data);
            boolean varB326B5062B2F0E69046810717534CB09_616146970 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_288147906 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_288147906;
        } //End block
        catch (RemoteException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_904931496 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_18886466 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_18886466;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.784 -0400", hash_original_field = "61A42A5C5A78D6632BB173F2CD44E374", hash_generated_field = "FF1C2ACF522E25E367200C0572BE8DA1")

        public int mSeq;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.784 -0400", hash_original_field = "C871C935A9FFBB5A72B3BC90796F592F", hash_generated_field = "4D2C9CAFD7EF62D4BB15576A5CC2ECC3")

        public boolean mHaveValue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.785 -0400", hash_original_field = "F423FDF2985DDF32E87605AFE9C6978B", hash_generated_field = "58D5B63A8A0C4A7E8BAB109575D64E4D")

        public CharSequence mTextBeforeCursor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.785 -0400", hash_original_field = "65BD4E602AB1BF88FE45543DD84DD6E2", hash_generated_field = "9FB6F0C8456D90D8021099BE30489DC5")

        public CharSequence mTextAfterCursor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.785 -0400", hash_original_field = "7AC72A89563F8A56517E860A9DBEF362", hash_generated_field = "57A04860072A486B5F1E41658D97AC82")

        public CharSequence mSelectedText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.785 -0400", hash_original_field = "A034AA34A307E777C43933E669A375DC", hash_generated_field = "482594694449567A160FA3F5524709A0")

        public ExtractedText mExtractedText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.785 -0400", hash_original_field = "9BC83ACBBA6BD4A8D823866CA0DC5705", hash_generated_field = "C92D0BC414C6A30B2A5E4D2844301587")

        public int mCursorCapsMode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.785 -0400", hash_original_method = "C2F7B541292D8E4E042270C21CD2A858", hash_generated_method = "C2F7B541292D8E4E042270C21CD2A858")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.785 -0400", hash_original_method = "114A3AA754115CB63309037B1A16C75C", hash_generated_method = "9BD80E9ED6FC3B32FF54FD83C1DF9459")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.785 -0400", hash_original_method = "361E9A3C637FF701A52DA6E2E96E1B0D", hash_generated_method = "814A0D2CE3D6D41A396D781C1797E8E5")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.785 -0400", hash_original_method = "364CB8CF32311AACA17721A234C603BF", hash_generated_method = "975AA37A99088CB886312E87682854CB")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.785 -0400", hash_original_method = "22EEF86B76323A3D0B42A8BDC8D7F847", hash_generated_method = "7373C5692B3E76C57D3C9353D6192FC4")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.786 -0400", hash_original_method = "998E9B4FE98738EB2922C01E8488A9FE", hash_generated_method = "0C0A7E94B4E77405E233A018B6CEA3B4")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.786 -0400", hash_original_method = "728CBF4CDD80384E151B1C8A539138C4", hash_generated_method = "1309DAA77656ADC61D18ECA3FC0E6D1A")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.786 -0400", hash_original_method = "0DFF250C75DABF6F6E35FBCC4F44FCEA", hash_generated_method = "49A1CCF5EB26A17E95436859628A9D7E")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.786 -0400", hash_original_field = "D625C16187F9C03B97B300FD3342652B", hash_generated_field = "878BD2023E90083E95CB4B2EC8F39CF9")

        private static final String TAG = "InputConnectionWrapper.ICC";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.786 -0400", hash_original_field = "988FFA1F2B606800228BA347483121A3", hash_generated_field = "8C19ECF6955FF34778F11D83BE064C14")

        private static InputContextCallback sInstance = new InputContextCallback();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.786 -0400", hash_original_field = "FD62EFA389E2F9A7398A20D67E683F18", hash_generated_field = "54D86ECADB2242C49D518A04742826C9")

        private static int sSequenceNumber = 1;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.786 -0400", hash_original_field = "6267C4AF26D35EDB744787F96CED4081", hash_generated_field = "E21C9D56222776C7795AA3D88992FF14")

    private static final int MAX_WAIT_TIME_MILLIS = 2000;
}


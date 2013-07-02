package com.android.internal.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.729 -0400", hash_original_field = "4AC36937F366B7AB4CCDC4F1F414F47C", hash_generated_field = "1993EA11D8BF196428670F5B97A83039")

    private IInputContext mIInputContext;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.729 -0400", hash_original_method = "200A59D07195D77203DE13B6F1D7E213", hash_generated_method = "7612BD2DCE02136E56A8BD3FD04ECE95")
    public  InputConnectionWrapper(IInputContext inputContext) {
        mIInputContext = inputContext;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.730 -0400", hash_original_method = "E5D9808718D85F214F56B5C74559D92A", hash_generated_method = "992EC947807EFE9F0647BCDBC130C2BE")
    public CharSequence getTextAfterCursor(int length, int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1687150562 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1662265034 = null; 
        CharSequence value = null;
        try 
        {
            InputContextCallback callback = InputContextCallback.getInstance();
            mIInputContext.getTextAfterCursor(length, flags, callback.mSeq, callback);
            {
                callback.waitForResultLocked();
                {
                    value = callback.mTextAfterCursor;
                } 
            } 
            callback.dispose();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1687150562 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1662265034 = value;
        addTaint(length);
        addTaint(flags);
        CharSequence varA7E53CE21691AB073D9660D615818899_1511220388; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1511220388 = varB4EAC82CA7396A68D541C85D26508E83_1687150562;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1511220388 = varB4EAC82CA7396A68D541C85D26508E83_1662265034;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1511220388.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1511220388;
        
        
        
            
            
            
                
                
                    
                
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.731 -0400", hash_original_method = "161B1891DB80E123B2A48225941EF408", hash_generated_method = "F542CAFD3065AA3B588C274A10BF6632")
    public CharSequence getTextBeforeCursor(int length, int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1156268136 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_722915996 = null; 
        CharSequence value = null;
        try 
        {
            InputContextCallback callback = InputContextCallback.getInstance();
            mIInputContext.getTextBeforeCursor(length, flags, callback.mSeq, callback);
            {
                callback.waitForResultLocked();
                {
                    value = callback.mTextBeforeCursor;
                } 
            } 
            callback.dispose();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1156268136 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_722915996 = value;
        addTaint(length);
        addTaint(flags);
        CharSequence varA7E53CE21691AB073D9660D615818899_647057738; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_647057738 = varB4EAC82CA7396A68D541C85D26508E83_1156268136;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_647057738 = varB4EAC82CA7396A68D541C85D26508E83_722915996;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_647057738.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_647057738;
        
        
        
            
            
            
                
                
                    
                
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.731 -0400", hash_original_method = "07C2D6CA43F82EBF9A41822F1A0D86D8", hash_generated_method = "7486060C8595D522C4291D100CDE9983")
    public CharSequence getSelectedText(int flags) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1319779933 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1768442942 = null; 
        CharSequence value = null;
        try 
        {
            InputContextCallback callback = InputContextCallback.getInstance();
            mIInputContext.getSelectedText(flags, callback.mSeq, callback);
            {
                callback.waitForResultLocked();
                {
                    value = callback.mSelectedText;
                } 
            } 
            callback.dispose();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1319779933 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1768442942 = value;
        addTaint(flags);
        CharSequence varA7E53CE21691AB073D9660D615818899_1048644543; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1048644543 = varB4EAC82CA7396A68D541C85D26508E83_1319779933;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1048644543 = varB4EAC82CA7396A68D541C85D26508E83_1768442942;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1048644543.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1048644543;
        
        
        
            
            
            
                
                
                    
                
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.732 -0400", hash_original_method = "42EA416764DB4DFF051E9040CF49BB73", hash_generated_method = "041D12CB107E01ECE604CD7B4A38BC7C")
    public int getCursorCapsMode(int reqModes) {
        int value = 0;
        try 
        {
            InputContextCallback callback = InputContextCallback.getInstance();
            mIInputContext.getCursorCapsMode(reqModes, callback.mSeq, callback);
            {
                callback.waitForResultLocked();
                {
                    value = callback.mCursorCapsMode;
                } 
            } 
            callback.dispose();
        } 
        catch (RemoteException e)
        { }
        addTaint(reqModes);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322335439 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322335439;
        
        
        
            
            
            
                
                
                    
                
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.734 -0400", hash_original_method = "305E28329FA220003F7366DA2A6BF238", hash_generated_method = "7D6490644F9CCCF6E992E56C72520D4C")
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        ExtractedText varB4EAC82CA7396A68D541C85D26508E83_1168002614 = null; 
        ExtractedText varB4EAC82CA7396A68D541C85D26508E83_77644165 = null; 
        ExtractedText value = null;
        try 
        {
            InputContextCallback callback = InputContextCallback.getInstance();
            mIInputContext.getExtractedText(request, flags, callback.mSeq, callback);
            {
                callback.waitForResultLocked();
                {
                    value = callback.mExtractedText;
                } 
            } 
            callback.dispose();
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1168002614 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_77644165 = value;
        addTaint(request.getTaint());
        addTaint(flags);
        ExtractedText varA7E53CE21691AB073D9660D615818899_1677177805; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1677177805 = varB4EAC82CA7396A68D541C85D26508E83_1168002614;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1677177805 = varB4EAC82CA7396A68D541C85D26508E83_77644165;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1677177805.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1677177805;
        
        
        
            
            
            
                
                
                    
                
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.734 -0400", hash_original_method = "E23EA90B6F67D6C242A9505D14FF1F12", hash_generated_method = "171B35F7DB2E1BDA009F29CA185DBFD7")
    public boolean commitText(CharSequence text, int newCursorPosition) {
        try 
        {
            mIInputContext.commitText(text, newCursorPosition);
        } 
        catch (RemoteException e)
        { }
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_528148197 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_528148197;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.735 -0400", hash_original_method = "EAB5E616D3D3B282F88520753342CC96", hash_generated_method = "58E6DE06C3E96C2F16AC8BAF562E191F")
    public boolean commitCompletion(CompletionInfo text) {
        try 
        {
            mIInputContext.commitCompletion(text);
        } 
        catch (RemoteException e)
        { }
        addTaint(text.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1853997008 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1853997008;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.735 -0400", hash_original_method = "6923A4DC7941C069C654C30365BCACDD", hash_generated_method = "53E3E409D82A0A30D3A3D4D779AA0F5A")
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        try 
        {
            mIInputContext.commitCorrection(correctionInfo);
        } 
        catch (RemoteException e)
        { }
        addTaint(correctionInfo.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_633690086 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_633690086;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.735 -0400", hash_original_method = "7022EC7ED2F239685C7BD3195B6CEAE9", hash_generated_method = "4099A90EAD7BCCEB982420D2C85E15B6")
    public boolean setSelection(int start, int end) {
        try 
        {
            mIInputContext.setSelection(start, end);
        } 
        catch (RemoteException e)
        { }
        addTaint(start);
        addTaint(end);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1737853590 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1737853590;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.736 -0400", hash_original_method = "67A8A8F86F1AE5123A01275D8828212B", hash_generated_method = "449F12141D73BE895D7B2DEAA151FF23")
    public boolean performEditorAction(int actionCode) {
        try 
        {
            mIInputContext.performEditorAction(actionCode);
        } 
        catch (RemoteException e)
        { }
        addTaint(actionCode);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1997113337 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1997113337;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.736 -0400", hash_original_method = "F7AEA38F9035D01924C8EE6C58DE4221", hash_generated_method = "FBB0176B9D95678F9F3A723578F549E0")
    public boolean performContextMenuAction(int id) {
        try 
        {
            mIInputContext.performContextMenuAction(id);
        } 
        catch (RemoteException e)
        { }
        addTaint(id);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_815759296 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_815759296;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.736 -0400", hash_original_method = "D57326DB6E974535AC174E0CB4F4F72D", hash_generated_method = "AFF101473199EE2791FB1B36BF5EECC9")
    public boolean setComposingRegion(int start, int end) {
        try 
        {
            mIInputContext.setComposingRegion(start, end);
        } 
        catch (RemoteException e)
        { }
        addTaint(start);
        addTaint(end);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1432962845 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1432962845;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.737 -0400", hash_original_method = "DE2855A916E2A0C96139F9B28AC632EF", hash_generated_method = "089B8657FAA86DE734593B420C1B82AF")
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        try 
        {
            mIInputContext.setComposingText(text, newCursorPosition);
        } 
        catch (RemoteException e)
        { }
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1206799278 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1206799278;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.737 -0400", hash_original_method = "654CA187A88EAE1F2AB6640B00B6686A", hash_generated_method = "779CF0DD05F68088AEBD22FBE0389276")
    public boolean finishComposingText() {
        try 
        {
            mIInputContext.finishComposingText();
        } 
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1755291089 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1755291089;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.737 -0400", hash_original_method = "F214558E918685C9D34C6BD9CACE39BA", hash_generated_method = "E6CBD0DD3C66E455C6C71515E475B83F")
    public boolean beginBatchEdit() {
        try 
        {
            mIInputContext.beginBatchEdit();
        } 
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_554257831 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_554257831;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.738 -0400", hash_original_method = "FFD20A357B6026C06481613009C9A85C", hash_generated_method = "84581F0481557640B56984A69521BB5D")
    public boolean endBatchEdit() {
        try 
        {
            mIInputContext.endBatchEdit();
        } 
        catch (RemoteException e)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_718707831 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_718707831;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.738 -0400", hash_original_method = "BDB80433761F466B2EC1080474660009", hash_generated_method = "A268135B6B92DFA1D2DFB39F91C32506")
    public boolean sendKeyEvent(KeyEvent event) {
        try 
        {
            mIInputContext.sendKeyEvent(event);
        } 
        catch (RemoteException e)
        { }
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_831996019 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_831996019;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.738 -0400", hash_original_method = "3A88C36966ABDB3053599F030E0CFC04", hash_generated_method = "5579C3AB4B14B4B990AF8A2C4B6D2CDB")
    public boolean clearMetaKeyStates(int states) {
        try 
        {
            mIInputContext.clearMetaKeyStates(states);
        } 
        catch (RemoteException e)
        { }
        addTaint(states);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1237162307 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1237162307;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.739 -0400", hash_original_method = "A0EA155ACF6A2B88254811510DB0CC9C", hash_generated_method = "D20AC975075E8B0FDA1F5C2BA16C24C7")
    public boolean deleteSurroundingText(int leftLength, int rightLength) {
        try 
        {
            mIInputContext.deleteSurroundingText(leftLength, rightLength);
        } 
        catch (RemoteException e)
        { }
        addTaint(leftLength);
        addTaint(rightLength);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_106144897 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_106144897;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.739 -0400", hash_original_method = "F356C6E7AA9EF97C6745E94B41944104", hash_generated_method = "D6A7DDA9DA1DF2388169214358434D59")
    public boolean reportFullscreenMode(boolean enabled) {
        try 
        {
            mIInputContext.reportFullscreenMode(enabled);
        } 
        catch (RemoteException e)
        { }
        addTaint(enabled);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_676271092 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_676271092;
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.739 -0400", hash_original_method = "C4A420F599BD094A8850BEFF4D3FF18D", hash_generated_method = "672D33D4AA5768DC7B4E4897C8389780")
    public boolean performPrivateCommand(String action, Bundle data) {
        try 
        {
            mIInputContext.performPrivateCommand(action, data);
        } 
        catch (RemoteException e)
        { }
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_190608097 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_190608097;
        
        
            
            
        
            
        
    }

    
    static class InputContextCallback extends IInputContextCallback.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.739 -0400", hash_original_field = "61A42A5C5A78D6632BB173F2CD44E374", hash_generated_field = "FF1C2ACF522E25E367200C0572BE8DA1")

        public int mSeq;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.739 -0400", hash_original_field = "C871C935A9FFBB5A72B3BC90796F592F", hash_generated_field = "4D2C9CAFD7EF62D4BB15576A5CC2ECC3")

        public boolean mHaveValue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.739 -0400", hash_original_field = "F423FDF2985DDF32E87605AFE9C6978B", hash_generated_field = "58D5B63A8A0C4A7E8BAB109575D64E4D")

        public CharSequence mTextBeforeCursor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.739 -0400", hash_original_field = "65BD4E602AB1BF88FE45543DD84DD6E2", hash_generated_field = "9FB6F0C8456D90D8021099BE30489DC5")

        public CharSequence mTextAfterCursor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.739 -0400", hash_original_field = "7AC72A89563F8A56517E860A9DBEF362", hash_generated_field = "57A04860072A486B5F1E41658D97AC82")

        public CharSequence mSelectedText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.739 -0400", hash_original_field = "A034AA34A307E777C43933E669A375DC", hash_generated_field = "482594694449567A160FA3F5524709A0")

        public ExtractedText mExtractedText;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.739 -0400", hash_original_field = "9BC83ACBBA6BD4A8D823866CA0DC5705", hash_generated_field = "C92D0BC414C6A30B2A5E4D2844301587")

        public int mCursorCapsMode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.739 -0400", hash_original_method = "C2F7B541292D8E4E042270C21CD2A858", hash_generated_method = "C2F7B541292D8E4E042270C21CD2A858")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.740 -0400", hash_original_method = "114A3AA754115CB63309037B1A16C75C", hash_generated_method = "DEB7402431C747CDAA87E13C266B649E")
        private void dispose() {
            {
                {
                    mTextAfterCursor = null;
                    mTextBeforeCursor = null;
                    mExtractedText = null;
                    sInstance = this;
                } 
            } 
            
            
                
                    
                    
                    
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.741 -0400", hash_original_method = "361E9A3C637FF701A52DA6E2E96E1B0D", hash_generated_method = "35521854F3A20CDF717B2E2256A272A2")
        public void setTextBeforeCursor(CharSequence textBeforeCursor, int seq) {
            {
                {
                    mTextBeforeCursor = textBeforeCursor;
                    mHaveValue = true;
                    notifyAll();
                } 
            } 
            addTaint(seq);
            
            
                
                    
                    
                    
                
                    
                            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.741 -0400", hash_original_method = "364CB8CF32311AACA17721A234C603BF", hash_generated_method = "46F242B621388335E665CA7893A1258E")
        public void setTextAfterCursor(CharSequence textAfterCursor, int seq) {
            {
                {
                    mTextAfterCursor = textAfterCursor;
                    mHaveValue = true;
                    notifyAll();
                } 
            } 
            addTaint(seq);
            
            
                
                    
                    
                    
                
                    
                            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.742 -0400", hash_original_method = "22EEF86B76323A3D0B42A8BDC8D7F847", hash_generated_method = "4D56280AFA594989E4FB9F0D2754B932")
        public void setSelectedText(CharSequence selectedText, int seq) {
            {
                {
                    mSelectedText = selectedText;
                    mHaveValue = true;
                    notifyAll();
                } 
            } 
            addTaint(seq);
            
            
                
                    
                    
                    
                
                    
                            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.742 -0400", hash_original_method = "998E9B4FE98738EB2922C01E8488A9FE", hash_generated_method = "F12064AAB1720E274421A5EA84B131E8")
        public void setCursorCapsMode(int capsMode, int seq) {
            {
                {
                    mCursorCapsMode = capsMode;
                    mHaveValue = true;
                    notifyAll();
                } 
            } 
            addTaint(seq);
            
            
                
                    
                    
                    
                
                    
                            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.742 -0400", hash_original_method = "728CBF4CDD80384E151B1C8A539138C4", hash_generated_method = "3E29DBA3FD54BF389313549EF6078E8A")
        public void setExtractedText(ExtractedText extractedText, int seq) {
            {
                {
                    mExtractedText = extractedText;
                    mHaveValue = true;
                    notifyAll();
                } 
            } 
            addTaint(seq);
            
            
                
                    
                    
                    
                
                    
                            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.743 -0400", hash_original_method = "0DFF250C75DABF6F6E35FBCC4F44FCEA", hash_generated_method = "BBF5BBEA78875C5072400CC07E68E97D")
         void waitForResultLocked() {
            long startTime = SystemClock.uptimeMillis();
            long endTime = startTime + MAX_WAIT_TIME_MILLIS;
            {
                long remainingTime = endTime - SystemClock.uptimeMillis();
                try 
                {
                    wait(remainingTime);
                } 
                catch (InterruptedException e)
                { }
            } 
            
            
            
            
                
                
                    
                    
                
                
                    
                
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.743 -0400", hash_original_field = "D625C16187F9C03B97B300FD3342652B", hash_generated_field = "878BD2023E90083E95CB4B2EC8F39CF9")

        private static final String TAG = "InputConnectionWrapper.ICC";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.743 -0400", hash_original_field = "988FFA1F2B606800228BA347483121A3", hash_generated_field = "8C19ECF6955FF34778F11D83BE064C14")

        private static InputContextCallback sInstance = new InputContextCallback();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.743 -0400", hash_original_field = "FD62EFA389E2F9A7398A20D67E683F18", hash_generated_field = "54D86ECADB2242C49D518A04742826C9")

        private static int sSequenceNumber = 1;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.743 -0400", hash_original_field = "6267C4AF26D35EDB744787F96CED4081", hash_generated_field = "E21C9D56222776C7795AA3D88992FF14")

    private static final int MAX_WAIT_TIME_MILLIS = 2000;
}


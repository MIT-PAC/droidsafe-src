package com.android.internal.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import java.lang.ref.WeakReference;

public class IInputConnectionWrapper extends IInputContext.Stub {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.125 -0400", hash_original_field = "A2D010B7C3546462A260EC1C5E1ED4C6", hash_generated_field = "BBA366FC8F1B26518754E187C86749B0")

    private WeakReference<InputConnection> mInputConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.125 -0400", hash_original_field = "6C2EA91B438529F1372D806717F5AE04", hash_generated_field = "BAC908CF5B8572ED590A292E13883CF4")

    private Looper mMainLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.126 -0400", hash_original_field = "6D1DA64E705BB119454CD3D6A13CB760", hash_generated_field = "A3B75E764711EA55737A441425E4D843")

    private Handler mH;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.126 -0400", hash_original_method = "9A20FF15705420E23492BF55DF80DCC1", hash_generated_method = "C3D67277BD877481EBAF63AB4875E775")
    public  IInputConnectionWrapper(Looper mainLooper, InputConnection conn) {
        mInputConnection = new WeakReference<InputConnection>(conn);
        mMainLooper = mainLooper;
        mH = new MyHandler(mMainLooper);
        // ---------- Original Method ----------
        //mInputConnection = new WeakReference<InputConnection>(conn);
        //mMainLooper = mainLooper;
        //mH = new MyHandler(mMainLooper);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.126 -0400", hash_original_method = "51DFD52266A16587BB1D688A25EC9E53", hash_generated_method = "1E814109F512C419BDA073E20CCB825E")
    public boolean isActive() {
        boolean varB326B5062B2F0E69046810717534CB09_1151900955 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1197039790 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1197039790;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.127 -0400", hash_original_method = "BDB79A31B9E7C568F9DA8424F1B2AA88", hash_generated_method = "78EB4A534EB968D823C160C616BCA7BF")
    public void getTextAfterCursor(int length, int flags, int seq, IInputContextCallback callback) {
        addTaint(callback.getTaint());
        addTaint(seq);
        addTaint(flags);
        addTaint(length);
        dispatchMessage(obtainMessageIISC(DO_GET_TEXT_AFTER_CURSOR, length, flags, seq, callback));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageIISC(DO_GET_TEXT_AFTER_CURSOR, length, flags, seq, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.127 -0400", hash_original_method = "83476DD996D24314F0D36073D788F8EE", hash_generated_method = "EE0D0BC89C6F9D49F173E0C0250099B5")
    public void getTextBeforeCursor(int length, int flags, int seq, IInputContextCallback callback) {
        addTaint(callback.getTaint());
        addTaint(seq);
        addTaint(flags);
        addTaint(length);
        dispatchMessage(obtainMessageIISC(DO_GET_TEXT_BEFORE_CURSOR, length, flags, seq, callback));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageIISC(DO_GET_TEXT_BEFORE_CURSOR, length, flags, seq, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.127 -0400", hash_original_method = "A721A8133D2DE1034FAEB50C8FE4FD06", hash_generated_method = "402592352EE2E6E8EFB27E622FE2C81C")
    public void getSelectedText(int flags, int seq, IInputContextCallback callback) {
        addTaint(callback.getTaint());
        addTaint(seq);
        addTaint(flags);
        dispatchMessage(obtainMessageISC(DO_GET_SELECTED_TEXT, flags, seq, callback));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageISC(DO_GET_SELECTED_TEXT, flags, seq, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.128 -0400", hash_original_method = "C43DF3E6E3EDAF8991B1451D7C0930B2", hash_generated_method = "D6A5BB3B9FE1A2889D941C57F4D3B8EC")
    public void getCursorCapsMode(int reqModes, int seq, IInputContextCallback callback) {
        addTaint(callback.getTaint());
        addTaint(seq);
        addTaint(reqModes);
        dispatchMessage(obtainMessageISC(DO_GET_CURSOR_CAPS_MODE, reqModes, seq, callback));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageISC(DO_GET_CURSOR_CAPS_MODE, reqModes, seq, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.128 -0400", hash_original_method = "68CBA214FC59FA44F08B8B86723A4DD0", hash_generated_method = "9ADBC51226181C0443ED689576884E77")
    public void getExtractedText(ExtractedTextRequest request,
            int flags, int seq, IInputContextCallback callback) {
        addTaint(callback.getTaint());
        addTaint(seq);
        addTaint(flags);
        addTaint(request.getTaint());
        dispatchMessage(obtainMessageIOSC(DO_GET_EXTRACTED_TEXT, flags,
                request, seq, callback));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageIOSC(DO_GET_EXTRACTED_TEXT, flags,
                //request, seq, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.129 -0400", hash_original_method = "894E006D9CEB98BFF63F2F46F25BC243", hash_generated_method = "ADB8BEBDF346B60B0A687F6BF1501DA1")
    public void commitText(CharSequence text, int newCursorPosition) {
        addTaint(newCursorPosition);
        addTaint(text.getTaint());
        dispatchMessage(obtainMessageIO(DO_COMMIT_TEXT, newCursorPosition, text));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageIO(DO_COMMIT_TEXT, newCursorPosition, text));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.129 -0400", hash_original_method = "CBF7B83C8E625835F649B99623E30868", hash_generated_method = "6F6D3F8E824EF04F7F91C9ADCAE8AE33")
    public void commitCompletion(CompletionInfo text) {
        addTaint(text.getTaint());
        dispatchMessage(obtainMessageO(DO_COMMIT_COMPLETION, text));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageO(DO_COMMIT_COMPLETION, text));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.129 -0400", hash_original_method = "8124D711A8307E610C5DEF0F89DBA666", hash_generated_method = "0D6093C11C9F839F8124EAB3E4BD4877")
    public void commitCorrection(CorrectionInfo info) {
        addTaint(info.getTaint());
        dispatchMessage(obtainMessageO(DO_COMMIT_CORRECTION, info));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageO(DO_COMMIT_CORRECTION, info));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.130 -0400", hash_original_method = "E49BA2D7A7A069DD200E49150DD829D6", hash_generated_method = "F3FED3C6E819F89F7779A5CA238E1136")
    public void setSelection(int start, int end) {
        addTaint(end);
        addTaint(start);
        dispatchMessage(obtainMessageII(DO_SET_SELECTION, start, end));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_SET_SELECTION, start, end));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.130 -0400", hash_original_method = "21817A9A1C101F9FB118DF43CE4E5A0E", hash_generated_method = "635FD31BE0F520FCBE594DD883A46746")
    public void performEditorAction(int id) {
        addTaint(id);
        dispatchMessage(obtainMessageII(DO_PERFORM_EDITOR_ACTION, id, 0));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_PERFORM_EDITOR_ACTION, id, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.130 -0400", hash_original_method = "053D329299E415D96D47FCFD70FD4878", hash_generated_method = "FD2E0620F5C1F6B5199AE31537A0E16A")
    public void performContextMenuAction(int id) {
        addTaint(id);
        dispatchMessage(obtainMessageII(DO_PERFORM_CONTEXT_MENU_ACTION, id, 0));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_PERFORM_CONTEXT_MENU_ACTION, id, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.130 -0400", hash_original_method = "D0BDE81E935635A3C1E1A2527338BB18", hash_generated_method = "5562A809BECCB541BD8D11FF1FE54CBA")
    public void setComposingRegion(int start, int end) {
        addTaint(end);
        addTaint(start);
        dispatchMessage(obtainMessageII(DO_SET_COMPOSING_REGION, start, end));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_SET_COMPOSING_REGION, start, end));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.131 -0400", hash_original_method = "FC274EF8C2FF034547500DAA5F2951F1", hash_generated_method = "4F707EC70BE0E8B09C726F8675E0E454")
    public void setComposingText(CharSequence text, int newCursorPosition) {
        addTaint(newCursorPosition);
        addTaint(text.getTaint());
        dispatchMessage(obtainMessageIO(DO_SET_COMPOSING_TEXT, newCursorPosition, text));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageIO(DO_SET_COMPOSING_TEXT, newCursorPosition, text));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.131 -0400", hash_original_method = "6F02D8053ECF48E238847A2FABA8F899", hash_generated_method = "0EA1C6FF08BDC7474C1F768E99AC789D")
    public void finishComposingText() {
        dispatchMessage(obtainMessage(DO_FINISH_COMPOSING_TEXT));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessage(DO_FINISH_COMPOSING_TEXT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.131 -0400", hash_original_method = "60A7447AAE4F39255FF17C7443EAC7D8", hash_generated_method = "5CC57DDB3768D3025E96C6C50E220E34")
    public void sendKeyEvent(KeyEvent event) {
        addTaint(event.getTaint());
        dispatchMessage(obtainMessageO(DO_SEND_KEY_EVENT, event));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageO(DO_SEND_KEY_EVENT, event));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.131 -0400", hash_original_method = "CDF50C376207E59459DF05B9EB51603A", hash_generated_method = "9CAD595DA93EBD521E468DD65AA910A7")
    public void clearMetaKeyStates(int states) {
        addTaint(states);
        dispatchMessage(obtainMessageII(DO_CLEAR_META_KEY_STATES, states, 0));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_CLEAR_META_KEY_STATES, states, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.131 -0400", hash_original_method = "2E4F7757D66A73FD9325207AD0D4F280", hash_generated_method = "C5909086E54D39C0ED88B1C542D33166")
    public void deleteSurroundingText(int leftLength, int rightLength) {
        addTaint(rightLength);
        addTaint(leftLength);
        dispatchMessage(obtainMessageII(DO_DELETE_SURROUNDING_TEXT,
            leftLength, rightLength));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_DELETE_SURROUNDING_TEXT,
            //leftLength, rightLength));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.132 -0400", hash_original_method = "7A31F16907F3D96E10B72B79CABC1C1A", hash_generated_method = "ABE69A11FC08E9E6D9B71FEA871175F2")
    public void beginBatchEdit() {
        dispatchMessage(obtainMessage(DO_BEGIN_BATCH_EDIT));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessage(DO_BEGIN_BATCH_EDIT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.132 -0400", hash_original_method = "2DD80BF17B03574DE2AF6B49D0CD84C3", hash_generated_method = "A09066AF166CB53E5DD594379D99093E")
    public void endBatchEdit() {
        dispatchMessage(obtainMessage(DO_END_BATCH_EDIT));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessage(DO_END_BATCH_EDIT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.132 -0400", hash_original_method = "A19C601F9A82D2C4B88A8AB8DFBF0737", hash_generated_method = "A200ADC643B9A1C95E870A852290529A")
    public void reportFullscreenMode(boolean enabled) {
        addTaint(enabled);
        dispatchMessage(obtainMessageII(DO_REPORT_FULLSCREEN_MODE, enabled ? 1 : 0, 0));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_REPORT_FULLSCREEN_MODE, enabled ? 1 : 0, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.132 -0400", hash_original_method = "14DBCF261CA01A06A7ACE942F825CE65", hash_generated_method = "B9A521CCF16F0CF39F1393974428439A")
    public void performPrivateCommand(String action, Bundle data) {
        addTaint(data.getTaint());
        addTaint(action.getTaint());
        dispatchMessage(obtainMessageOO(DO_PERFORM_PRIVATE_COMMAND, action, data));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageOO(DO_PERFORM_PRIVATE_COMMAND, action, data));
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.133 -0400", hash_original_method = "F5A5E3786D2DDCB2FEFEBA688154C5D7", hash_generated_method = "72494AAF0D1938806AC67090231D7CA3")
     void dispatchMessage(Message msg) {
        addTaint(msg.getTaint());
    if(Looper.myLooper() == mMainLooper)        
        {
            executeMessage(msg);
            msg.recycle();
            return;
        } //End block
        mH.sendMessage(msg);
        // ---------- Original Method ----------
        //if (Looper.myLooper() == mMainLooper) {
            //executeMessage(msg);
            //msg.recycle();
            //return;
        //}
        //mH.sendMessage(msg);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.134 -0400", hash_original_method = "78BA9F6D5AE481CC7127DB3741BBDA1E", hash_generated_method = "86009720EF1448C83B84C392473AACDB")
     void executeMessage(Message msg) {
        addTaint(msg.getTaint());
switch(msg.what){
        case DO_GET_TEXT_AFTER_CURSOR:
        {
            SomeArgs args = (SomeArgs)msg.obj;
            try 
            {
                InputConnection ic = mInputConnection.get();
    if(ic == null || !isActive())                
                {
                    args.callback.setTextAfterCursor(null, args.seq);
                    return;
                } //End block
                args.callback.setTextAfterCursor(ic.getTextAfterCursor(
                            msg.arg1, msg.arg2), args.seq);
            } //End block
            catch (RemoteException e)
            {
            } //End block
            return;
        } //End block
        case DO_GET_TEXT_BEFORE_CURSOR:
        {
            SomeArgs args = (SomeArgs)msg.obj;
            try 
            {
                InputConnection ic = mInputConnection.get();
    if(ic == null || !isActive())                
                {
                    args.callback.setTextBeforeCursor(null, args.seq);
                    return;
                } //End block
                args.callback.setTextBeforeCursor(ic.getTextBeforeCursor(
                            msg.arg1, msg.arg2), args.seq);
            } //End block
            catch (RemoteException e)
            {
            } //End block
            return;
        } //End block
        case DO_GET_SELECTED_TEXT:
        {
            SomeArgs args = (SomeArgs)msg.obj;
            try 
            {
                InputConnection ic = mInputConnection.get();
    if(ic == null || !isActive())                
                {
                    args.callback.setSelectedText(null, args.seq);
                    return;
                } //End block
                args.callback.setSelectedText(ic.getSelectedText(
                            msg.arg1), args.seq);
            } //End block
            catch (RemoteException e)
            {
            } //End block
            return;
        } //End block
        case DO_GET_CURSOR_CAPS_MODE:
        {
            SomeArgs args = (SomeArgs)msg.obj;
            try 
            {
                InputConnection ic = mInputConnection.get();
    if(ic == null || !isActive())                
                {
                    args.callback.setCursorCapsMode(0, args.seq);
                    return;
                } //End block
                args.callback.setCursorCapsMode(ic.getCursorCapsMode(msg.arg1),
                            args.seq);
            } //End block
            catch (RemoteException e)
            {
            } //End block
            return;
        } //End block
        case DO_GET_EXTRACTED_TEXT:
        {
            SomeArgs args = (SomeArgs)msg.obj;
            try 
            {
                InputConnection ic = mInputConnection.get();
    if(ic == null || !isActive())                
                {
                    args.callback.setExtractedText(null, args.seq);
                    return;
                } //End block
                args.callback.setExtractedText(ic.getExtractedText(
                            (ExtractedTextRequest)args.arg1, msg.arg1), args.seq);
            } //End block
            catch (RemoteException e)
            {
            } //End block
            return;
        } //End block
        case DO_COMMIT_TEXT:
        {
            InputConnection ic = mInputConnection.get();
    if(ic == null || !isActive())            
            {
                return;
            } //End block
            ic.commitText((CharSequence)msg.obj, msg.arg1);
            return;
        } //End block
        case DO_SET_SELECTION:
        {
            InputConnection ic = mInputConnection.get();
    if(ic == null || !isActive())            
            {
                return;
            } //End block
            ic.setSelection(msg.arg1, msg.arg2);
            return;
        } //End block
        case DO_PERFORM_EDITOR_ACTION:
        {
            InputConnection ic = mInputConnection.get();
    if(ic == null || !isActive())            
            {
                return;
            } //End block
            ic.performEditorAction(msg.arg1);
            return;
        } //End block
        case DO_PERFORM_CONTEXT_MENU_ACTION:
        {
            InputConnection ic = mInputConnection.get();
    if(ic == null || !isActive())            
            {
                return;
            } //End block
            ic.performContextMenuAction(msg.arg1);
            return;
        } //End block
        case DO_COMMIT_COMPLETION:
        {
            InputConnection ic = mInputConnection.get();
    if(ic == null || !isActive())            
            {
                return;
            } //End block
            ic.commitCompletion((CompletionInfo)msg.obj);
            return;
        } //End block
        case DO_COMMIT_CORRECTION:
        {
            InputConnection ic = mInputConnection.get();
    if(ic == null || !isActive())            
            {
                return;
            } //End block
            ic.commitCorrection((CorrectionInfo)msg.obj);
            return;
        } //End block
        case DO_SET_COMPOSING_TEXT:
        {
            InputConnection ic = mInputConnection.get();
    if(ic == null || !isActive())            
            {
                return;
            } //End block
            ic.setComposingText((CharSequence)msg.obj, msg.arg1);
            return;
        } //End block
        case DO_SET_COMPOSING_REGION:
        {
            InputConnection ic = mInputConnection.get();
    if(ic == null || !isActive())            
            {
                return;
            } //End block
            ic.setComposingRegion(msg.arg1, msg.arg2);
            return;
        } //End block
        case DO_FINISH_COMPOSING_TEXT:
        {
            InputConnection ic = mInputConnection.get();
    if(ic == null)            
            {
                return;
            } //End block
            ic.finishComposingText();
            return;
        } //End block
        case DO_SEND_KEY_EVENT:
        {
            InputConnection ic = mInputConnection.get();
    if(ic == null || !isActive())            
            {
                return;
            } //End block
            ic.sendKeyEvent((KeyEvent)msg.obj);
            return;
        } //End block
        case DO_CLEAR_META_KEY_STATES:
        {
            InputConnection ic = mInputConnection.get();
    if(ic == null || !isActive())            
            {
                return;
            } //End block
            ic.clearMetaKeyStates(msg.arg1);
            return;
        } //End block
        case DO_DELETE_SURROUNDING_TEXT:
        {
            InputConnection ic = mInputConnection.get();
    if(ic == null || !isActive())            
            {
                return;
            } //End block
            ic.deleteSurroundingText(msg.arg1, msg.arg2);
            return;
        } //End block
        case DO_BEGIN_BATCH_EDIT:
        {
            InputConnection ic = mInputConnection.get();
    if(ic == null || !isActive())            
            {
                return;
            } //End block
            ic.beginBatchEdit();
            return;
        } //End block
        case DO_END_BATCH_EDIT:
        {
            InputConnection ic = mInputConnection.get();
    if(ic == null || !isActive())            
            {
                return;
            } //End block
            ic.endBatchEdit();
            return;
        } //End block
        case DO_REPORT_FULLSCREEN_MODE:
        {
            InputConnection ic = mInputConnection.get();
    if(ic == null || !isActive())            
            {
                return;
            } //End block
            ic.reportFullscreenMode(msg.arg1 == 1);
            return;
        } //End block
        case DO_PERFORM_PRIVATE_COMMAND:
        {
            InputConnection ic = mInputConnection.get();
    if(ic == null || !isActive())            
            {
                return;
            } //End block
            SomeArgs args = (SomeArgs)msg.obj;
            ic.performPrivateCommand((String)args.arg1,
                        (Bundle)args.arg2);
            return;
        } //End block
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.135 -0400", hash_original_method = "92301CED384526FAE2562FC8E2BD0E1D", hash_generated_method = "AD01814BC7640ED896C48B6EB11F675F")
     Message obtainMessage(int what) {
        addTaint(what);
Message var0A074E99CF455DBBC1653B54C1535B52_1793694844 =         mH.obtainMessage(what);
        var0A074E99CF455DBBC1653B54C1535B52_1793694844.addTaint(taint);
        return var0A074E99CF455DBBC1653B54C1535B52_1793694844;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.135 -0400", hash_original_method = "1D375F3B5B7A421102D544B0D8C99910", hash_generated_method = "E7920A7506A1F62E3C52D4B835749464")
     Message obtainMessageII(int what, int arg1, int arg2) {
        addTaint(arg2);
        addTaint(arg1);
        addTaint(what);
Message var2005F2BFA3651910E62A138190D96BC6_1728957791 =         mH.obtainMessage(what, arg1, arg2);
        var2005F2BFA3651910E62A138190D96BC6_1728957791.addTaint(taint);
        return var2005F2BFA3651910E62A138190D96BC6_1728957791;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.135 -0400", hash_original_method = "E41B1E1C050A3613D52D3D6F2431F5B0", hash_generated_method = "553513E64F92ED2A7FE721A18B8DFDD9")
     Message obtainMessageO(int what, Object arg1) {
        addTaint(arg1.getTaint());
        addTaint(what);
Message var12CDD1AFE5E6600F8EC4A70E6284B925_1551655753 =         mH.obtainMessage(what, 0, 0, arg1);
        var12CDD1AFE5E6600F8EC4A70E6284B925_1551655753.addTaint(taint);
        return var12CDD1AFE5E6600F8EC4A70E6284B925_1551655753;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, 0, 0, arg1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.135 -0400", hash_original_method = "C41806B53C46498944BCE998FEC907A1", hash_generated_method = "3E3FA3022DBACC8A99917932A0F39051")
     Message obtainMessageISC(int what, int arg1, int seq, IInputContextCallback callback) {
        addTaint(callback.getTaint());
        addTaint(seq);
        addTaint(arg1);
        addTaint(what);
        SomeArgs args = new SomeArgs();
        args.callback = callback;
        args.seq = seq;
Message varB613521389A33EC54F8F174F01C6658A_1210518367 =         mH.obtainMessage(what, arg1, 0, args);
        varB613521389A33EC54F8F174F01C6658A_1210518367.addTaint(taint);
        return varB613521389A33EC54F8F174F01C6658A_1210518367;
        // ---------- Original Method ----------
        //SomeArgs args = new SomeArgs();
        //args.callback = callback;
        //args.seq = seq;
        //return mH.obtainMessage(what, arg1, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.136 -0400", hash_original_method = "81C8385506FF3623370F9C4C1A9DC229", hash_generated_method = "B4323EFAF6CFECBA5AE084E90A2AC1A3")
     Message obtainMessageIISC(int what, int arg1, int arg2, int seq, IInputContextCallback callback) {
        addTaint(callback.getTaint());
        addTaint(seq);
        addTaint(arg2);
        addTaint(arg1);
        addTaint(what);
        SomeArgs args = new SomeArgs();
        args.callback = callback;
        args.seq = seq;
Message var77BF585217243532581F9F8C4041DDF0_1146515041 =         mH.obtainMessage(what, arg1, arg2, args);
        var77BF585217243532581F9F8C4041DDF0_1146515041.addTaint(taint);
        return var77BF585217243532581F9F8C4041DDF0_1146515041;
        // ---------- Original Method ----------
        //SomeArgs args = new SomeArgs();
        //args.callback = callback;
        //args.seq = seq;
        //return mH.obtainMessage(what, arg1, arg2, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.136 -0400", hash_original_method = "F0BFCDA04898886ED0BDB255B10E7641", hash_generated_method = "F49BB3897330549A1787DE0C6170E978")
     Message obtainMessageIOSC(int what, int arg1, Object arg2, int seq,
            IInputContextCallback callback) {
        addTaint(callback.getTaint());
        addTaint(seq);
        addTaint(arg2.getTaint());
        addTaint(arg1);
        addTaint(what);
        SomeArgs args = new SomeArgs();
        args.arg1 = arg2;
        args.callback = callback;
        args.seq = seq;
Message varB613521389A33EC54F8F174F01C6658A_1956281871 =         mH.obtainMessage(what, arg1, 0, args);
        varB613521389A33EC54F8F174F01C6658A_1956281871.addTaint(taint);
        return varB613521389A33EC54F8F174F01C6658A_1956281871;
        // ---------- Original Method ----------
        //SomeArgs args = new SomeArgs();
        //args.arg1 = arg2;
        //args.callback = callback;
        //args.seq = seq;
        //return mH.obtainMessage(what, arg1, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.136 -0400", hash_original_method = "BDB545C9895C4A044C116EE5375794DB", hash_generated_method = "0F49EA48BDCA206BA9D97AB3DE3AA0CC")
     Message obtainMessageIO(int what, int arg1, Object arg2) {
        addTaint(arg2.getTaint());
        addTaint(arg1);
        addTaint(what);
Message var1EA5D3012D434458EE54B63DB011E658_925895878 =         mH.obtainMessage(what, arg1, 0, arg2);
        var1EA5D3012D434458EE54B63DB011E658_925895878.addTaint(taint);
        return var1EA5D3012D434458EE54B63DB011E658_925895878;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, 0, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.136 -0400", hash_original_method = "0CCDC84288D426642A6380F76E883191", hash_generated_method = "F5182ECD59EB05A35A43916EA414A490")
     Message obtainMessageOO(int what, Object arg1, Object arg2) {
        addTaint(arg2.getTaint());
        addTaint(arg1.getTaint());
        addTaint(what);
        SomeArgs args = new SomeArgs();
        args.arg1 = arg1;
        args.arg2 = arg2;
Message varA09BA0A68969A0A00DFB7B824079B8FE_382353387 =         mH.obtainMessage(what, 0, 0, args);
        varA09BA0A68969A0A00DFB7B824079B8FE_382353387.addTaint(taint);
        return varA09BA0A68969A0A00DFB7B824079B8FE_382353387;
        // ---------- Original Method ----------
        //SomeArgs args = new SomeArgs();
        //args.arg1 = arg1;
        //args.arg2 = arg2;
        //return mH.obtainMessage(what, 0, 0, args);
    }

    
    static class SomeArgs {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.136 -0400", hash_original_field = "E866231598ED4CB18BE5E493240A11B0", hash_generated_field = "524E284308787C3B27AB4CD560A816CF")

        Object arg1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.136 -0400", hash_original_field = "80A26383E00E892C98EBD598EDCC5DBB", hash_generated_field = "2CC0C93F38D97721E695C73C9F8BA144")

        Object arg2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.136 -0400", hash_original_field = "924A8CEEAC17F54D3BE3F8CDF1C04EB2", hash_generated_field = "844B2A0BBAFC5CBF10E337E600D741B3")

        IInputContextCallback callback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.136 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "C4ECE7ED8A0F11C4F90796D05BE13ED7")

        int seq;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.136 -0400", hash_original_method = "C08D0E88500332C6E0DD16EFE525CF46", hash_generated_method = "C08D0E88500332C6E0DD16EFE525CF46")
        public SomeArgs ()
        {
            //Synthesized constructor
        }


    }


    
    class MyHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.136 -0400", hash_original_method = "761ACCB2E72A1319CE4B08F794806580", hash_generated_method = "A640814F3C00E3175ECDA66EED93DC88")
          MyHandler(Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_method = "1DE21F974CC2F2B42894E9D98B8A257E", hash_generated_method = "15278E5DACBF7EA1B3D2398E1D65507D")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
            executeMessage(msg);
            // ---------- Original Method ----------
            //executeMessage(msg);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "2C912F65B7F370D57F762FE5D19D4BE2", hash_generated_field = "900165FF60D4D63B5E39F15ED871ED73")

    static final String TAG = "IInputConnectionWrapper";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "4ED50403A7474ACA03D96962CA629474", hash_generated_field = "93215ED66A3AA28F5E079D863981D641")

    private static final int DO_GET_TEXT_AFTER_CURSOR = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "725D1046CB42EC948EEFC59324072C38", hash_generated_field = "77B723127445ED341C49AD030D289BC5")

    private static final int DO_GET_TEXT_BEFORE_CURSOR = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "C6CB8D044B7A676A21868DBC3B6992E7", hash_generated_field = "51EE3D33C8B20ECFDDE07BBCBB4E376E")

    private static final int DO_GET_SELECTED_TEXT = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "04C50D07812F125F84E41E3BE0DA838C", hash_generated_field = "BCA32ABEAAFC403F2BCED79722EED453")

    private static final int DO_GET_CURSOR_CAPS_MODE = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "9F85CECCAFE485433FF9E0DBDFF4DC0D", hash_generated_field = "48A7DB7FC24E94ED646B2156F252FA2C")

    private static final int DO_GET_EXTRACTED_TEXT = 40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "EC63C304A4880D2F78DBD98961CA7309", hash_generated_field = "12DAACDA0ED408109635B38CF1A26B58")

    private static final int DO_COMMIT_TEXT = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "D86E4E403145879C39C9B7A4B38C9072", hash_generated_field = "2FFC27A574296430573F8BFC6EAE1CE7")

    private static final int DO_COMMIT_COMPLETION = 55;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "FAE7CE09AE518D35FC722221C91CEF12", hash_generated_field = "13680546C8DA0B085E98BFE55C118B2C")

    private static final int DO_COMMIT_CORRECTION = 56;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "2EFDEFD94FC3FF82AA852E1A7ED2F4A0", hash_generated_field = "AD41B2C006D6D67CC8775CEC10520A90")

    private static final int DO_SET_SELECTION = 57;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "B9460B3CF5E7B4EDA7ABAA225E3A7D4C", hash_generated_field = "238C94F032A5384919F7EE90E5313139")

    private static final int DO_PERFORM_EDITOR_ACTION = 58;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "15DFE5D03CFE1F65BF076AD8D56917E0", hash_generated_field = "650AF0A11A874B7C58DD493632230488")

    private static final int DO_PERFORM_CONTEXT_MENU_ACTION = 59;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "D2FE5D65C0E0AC6F0CAC900A4291C782", hash_generated_field = "51F7A494F2D018C46814C47040A1B844")

    private static final int DO_SET_COMPOSING_TEXT = 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "6FAE186F48B537D9F9FF59276A391D10", hash_generated_field = "FA70AA4BBA7C0F3633F481FFABC342F9")

    private static final int DO_SET_COMPOSING_REGION = 63;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "9DF3EFB61898E55F35C2D13EF6043B89", hash_generated_field = "17932C5334A9342E69C604B50A69E95A")

    private static final int DO_FINISH_COMPOSING_TEXT = 65;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "F9906D40C7F6BD5C7A7D51FC303B9805", hash_generated_field = "F567601080EFA0B5B22EEBABDFA2EB65")

    private static final int DO_SEND_KEY_EVENT = 70;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "BEE559E8A44BD9830EB266D1E715794B", hash_generated_field = "E142F65AD117AFEBB852664B04740F3D")

    private static final int DO_DELETE_SURROUNDING_TEXT = 80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "96FC183EC850D36D03AB6F7138058D94", hash_generated_field = "99C6EF96E09AF79D299B8C365DD014F6")

    private static final int DO_BEGIN_BATCH_EDIT = 90;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "332C5FFBA2E78220DCAA7F5F59C064D0", hash_generated_field = "6A5BFE0A81A35CF1D51D4C6C709F0D2E")

    private static final int DO_END_BATCH_EDIT = 95;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "137931DC8B66215806FD27D12075A205", hash_generated_field = "BF40CA519D14B3452BD21538E6037466")

    private static final int DO_REPORT_FULLSCREEN_MODE = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "687DA25EF98F2378B6DFC9AE9155E95E", hash_generated_field = "3AAFBD5EAFB589BEB2464F4FDC3B6CAB")

    private static final int DO_PERFORM_PRIVATE_COMMAND = 120;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.137 -0400", hash_original_field = "51385D060DEB14F8392634E6908C9EA5", hash_generated_field = "69946D6E4D680F21730784713CDC701E")

    private static final int DO_CLEAR_META_KEY_STATES = 130;
}


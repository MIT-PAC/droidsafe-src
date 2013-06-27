package com.android.internal.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.199 -0400", hash_original_field = "A2D010B7C3546462A260EC1C5E1ED4C6", hash_generated_field = "BBA366FC8F1B26518754E187C86749B0")

    private WeakReference<InputConnection> mInputConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.199 -0400", hash_original_field = "6C2EA91B438529F1372D806717F5AE04", hash_generated_field = "BAC908CF5B8572ED590A292E13883CF4")

    private Looper mMainLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.199 -0400", hash_original_field = "6D1DA64E705BB119454CD3D6A13CB760", hash_generated_field = "A3B75E764711EA55737A441425E4D843")

    private Handler mH;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.199 -0400", hash_original_method = "9A20FF15705420E23492BF55DF80DCC1", hash_generated_method = "C3D67277BD877481EBAF63AB4875E775")
    public  IInputConnectionWrapper(Looper mainLooper, InputConnection conn) {
        mInputConnection = new WeakReference<InputConnection>(conn);
        mMainLooper = mainLooper;
        mH = new MyHandler(mMainLooper);
        // ---------- Original Method ----------
        //mInputConnection = new WeakReference<InputConnection>(conn);
        //mMainLooper = mainLooper;
        //mH = new MyHandler(mMainLooper);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.200 -0400", hash_original_method = "51DFD52266A16587BB1D688A25EC9E53", hash_generated_method = "EF5433C9031019719DE95D9344E0EF04")
    public boolean isActive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1044169898 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1044169898;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.200 -0400", hash_original_method = "BDB79A31B9E7C568F9DA8424F1B2AA88", hash_generated_method = "ABB209A3F56953225EC8C46CC85B1AC7")
    public void getTextAfterCursor(int length, int flags, int seq, IInputContextCallback callback) {
        dispatchMessage(obtainMessageIISC(DO_GET_TEXT_AFTER_CURSOR, length, flags, seq, callback));
        addTaint(length);
        addTaint(flags);
        addTaint(seq);
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageIISC(DO_GET_TEXT_AFTER_CURSOR, length, flags, seq, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.200 -0400", hash_original_method = "83476DD996D24314F0D36073D788F8EE", hash_generated_method = "6CC62D522417B969E4C9D4718AFCA28C")
    public void getTextBeforeCursor(int length, int flags, int seq, IInputContextCallback callback) {
        dispatchMessage(obtainMessageIISC(DO_GET_TEXT_BEFORE_CURSOR, length, flags, seq, callback));
        addTaint(length);
        addTaint(flags);
        addTaint(seq);
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageIISC(DO_GET_TEXT_BEFORE_CURSOR, length, flags, seq, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.218 -0400", hash_original_method = "A721A8133D2DE1034FAEB50C8FE4FD06", hash_generated_method = "9F807B0EE2D42DEDEE65B9718AF3363C")
    public void getSelectedText(int flags, int seq, IInputContextCallback callback) {
        dispatchMessage(obtainMessageISC(DO_GET_SELECTED_TEXT, flags, seq, callback));
        addTaint(flags);
        addTaint(seq);
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageISC(DO_GET_SELECTED_TEXT, flags, seq, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.223 -0400", hash_original_method = "C43DF3E6E3EDAF8991B1451D7C0930B2", hash_generated_method = "B6F8FB36CE2D0F4823F4AF590B20D5A9")
    public void getCursorCapsMode(int reqModes, int seq, IInputContextCallback callback) {
        dispatchMessage(obtainMessageISC(DO_GET_CURSOR_CAPS_MODE, reqModes, seq, callback));
        addTaint(reqModes);
        addTaint(seq);
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageISC(DO_GET_CURSOR_CAPS_MODE, reqModes, seq, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.223 -0400", hash_original_method = "68CBA214FC59FA44F08B8B86723A4DD0", hash_generated_method = "D73C425BB23A75CC2235A5B49D60A706")
    public void getExtractedText(ExtractedTextRequest request,
            int flags, int seq, IInputContextCallback callback) {
        dispatchMessage(obtainMessageIOSC(DO_GET_EXTRACTED_TEXT, flags,
                request, seq, callback));
        addTaint(request.getTaint());
        addTaint(flags);
        addTaint(seq);
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageIOSC(DO_GET_EXTRACTED_TEXT, flags,
                //request, seq, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.224 -0400", hash_original_method = "894E006D9CEB98BFF63F2F46F25BC243", hash_generated_method = "3BDC86837C06D9240A9F9981C543ED8F")
    public void commitText(CharSequence text, int newCursorPosition) {
        dispatchMessage(obtainMessageIO(DO_COMMIT_TEXT, newCursorPosition, text));
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageIO(DO_COMMIT_TEXT, newCursorPosition, text));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.224 -0400", hash_original_method = "CBF7B83C8E625835F649B99623E30868", hash_generated_method = "996CCB9204B864A0D975D6DB0BE897D1")
    public void commitCompletion(CompletionInfo text) {
        dispatchMessage(obtainMessageO(DO_COMMIT_COMPLETION, text));
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageO(DO_COMMIT_COMPLETION, text));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.224 -0400", hash_original_method = "8124D711A8307E610C5DEF0F89DBA666", hash_generated_method = "1D67555E50818966A36BBE780BB1BBC9")
    public void commitCorrection(CorrectionInfo info) {
        dispatchMessage(obtainMessageO(DO_COMMIT_CORRECTION, info));
        addTaint(info.getTaint());
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageO(DO_COMMIT_CORRECTION, info));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.224 -0400", hash_original_method = "E49BA2D7A7A069DD200E49150DD829D6", hash_generated_method = "AD8EC72FD27071B065075448FB128197")
    public void setSelection(int start, int end) {
        dispatchMessage(obtainMessageII(DO_SET_SELECTION, start, end));
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_SET_SELECTION, start, end));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.225 -0400", hash_original_method = "21817A9A1C101F9FB118DF43CE4E5A0E", hash_generated_method = "C4320B84C7250A393AE2AECA97686F2B")
    public void performEditorAction(int id) {
        dispatchMessage(obtainMessageII(DO_PERFORM_EDITOR_ACTION, id, 0));
        addTaint(id);
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_PERFORM_EDITOR_ACTION, id, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.237 -0400", hash_original_method = "053D329299E415D96D47FCFD70FD4878", hash_generated_method = "F8DA294E0E30F559226BAAA99F5E0A61")
    public void performContextMenuAction(int id) {
        dispatchMessage(obtainMessageII(DO_PERFORM_CONTEXT_MENU_ACTION, id, 0));
        addTaint(id);
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_PERFORM_CONTEXT_MENU_ACTION, id, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.238 -0400", hash_original_method = "D0BDE81E935635A3C1E1A2527338BB18", hash_generated_method = "6BA5C1F07D338665E5B4CBC7C0B25723")
    public void setComposingRegion(int start, int end) {
        dispatchMessage(obtainMessageII(DO_SET_COMPOSING_REGION, start, end));
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_SET_COMPOSING_REGION, start, end));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.238 -0400", hash_original_method = "FC274EF8C2FF034547500DAA5F2951F1", hash_generated_method = "A4186045CEF0C029B9324922A9632F26")
    public void setComposingText(CharSequence text, int newCursorPosition) {
        dispatchMessage(obtainMessageIO(DO_SET_COMPOSING_TEXT, newCursorPosition, text));
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageIO(DO_SET_COMPOSING_TEXT, newCursorPosition, text));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.238 -0400", hash_original_method = "6F02D8053ECF48E238847A2FABA8F899", hash_generated_method = "0EA1C6FF08BDC7474C1F768E99AC789D")
    public void finishComposingText() {
        dispatchMessage(obtainMessage(DO_FINISH_COMPOSING_TEXT));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessage(DO_FINISH_COMPOSING_TEXT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.239 -0400", hash_original_method = "60A7447AAE4F39255FF17C7443EAC7D8", hash_generated_method = "4BAB8202282289D09F8628CFE6BB2DD3")
    public void sendKeyEvent(KeyEvent event) {
        dispatchMessage(obtainMessageO(DO_SEND_KEY_EVENT, event));
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageO(DO_SEND_KEY_EVENT, event));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.239 -0400", hash_original_method = "CDF50C376207E59459DF05B9EB51603A", hash_generated_method = "4A5EDEAC71DBE7CC29538323E0C6A499")
    public void clearMetaKeyStates(int states) {
        dispatchMessage(obtainMessageII(DO_CLEAR_META_KEY_STATES, states, 0));
        addTaint(states);
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_CLEAR_META_KEY_STATES, states, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.243 -0400", hash_original_method = "2E4F7757D66A73FD9325207AD0D4F280", hash_generated_method = "CD0726CBF7F43F0B461D3B6733A6A4A0")
    public void deleteSurroundingText(int leftLength, int rightLength) {
        dispatchMessage(obtainMessageII(DO_DELETE_SURROUNDING_TEXT,
            leftLength, rightLength));
        addTaint(leftLength);
        addTaint(rightLength);
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_DELETE_SURROUNDING_TEXT,
            //leftLength, rightLength));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.243 -0400", hash_original_method = "7A31F16907F3D96E10B72B79CABC1C1A", hash_generated_method = "ABE69A11FC08E9E6D9B71FEA871175F2")
    public void beginBatchEdit() {
        dispatchMessage(obtainMessage(DO_BEGIN_BATCH_EDIT));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessage(DO_BEGIN_BATCH_EDIT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.244 -0400", hash_original_method = "2DD80BF17B03574DE2AF6B49D0CD84C3", hash_generated_method = "A09066AF166CB53E5DD594379D99093E")
    public void endBatchEdit() {
        dispatchMessage(obtainMessage(DO_END_BATCH_EDIT));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessage(DO_END_BATCH_EDIT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.321 -0400", hash_original_method = "A19C601F9A82D2C4B88A8AB8DFBF0737", hash_generated_method = "9F1A46694EB1820B1A7029D1440EB29D")
    public void reportFullscreenMode(boolean enabled) {
        dispatchMessage(obtainMessageII(DO_REPORT_FULLSCREEN_MODE, enabled ? 1 : 0, 0));
        addTaint(enabled);
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_REPORT_FULLSCREEN_MODE, enabled ? 1 : 0, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.321 -0400", hash_original_method = "14DBCF261CA01A06A7ACE942F825CE65", hash_generated_method = "1AA321B645F8DA138CED567FDCA41D8F")
    public void performPrivateCommand(String action, Bundle data) {
        dispatchMessage(obtainMessageOO(DO_PERFORM_PRIVATE_COMMAND, action, data));
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageOO(DO_PERFORM_PRIVATE_COMMAND, action, data));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.322 -0400", hash_original_method = "F5A5E3786D2DDCB2FEFEBA688154C5D7", hash_generated_method = "42C4DA052A97A1A361EC26CEF324D791")
     void dispatchMessage(Message msg) {
        {
            boolean varAFACA4F92DB746B2983C428CA25E9018_459128292 = (Looper.myLooper() == mMainLooper);
            {
                executeMessage(msg);
                msg.recycle();
            } //End block
        } //End collapsed parenthetic
        mH.sendMessage(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //if (Looper.myLooper() == mMainLooper) {
            //executeMessage(msg);
            //msg.recycle();
            //return;
        //}
        //mH.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.324 -0400", hash_original_method = "78BA9F6D5AE481CC7127DB3741BBDA1E", hash_generated_method = "8BE03F4C99F65637F37F53F5137727A8")
     void executeMessage(Message msg) {
        //Begin case DO_GET_TEXT_AFTER_CURSOR 
        {
            SomeArgs args;
            args = (SomeArgs)msg.obj;
            try 
            {
                InputConnection ic;
                ic = mInputConnection.get();
                {
                    boolean varD6C5F2B148FB14412C339FCDB147699A_367871495 = (ic == null || !isActive());
                    {
                        args.callback.setTextAfterCursor(null, args.seq);
                    } //End block
                } //End collapsed parenthetic
                args.callback.setTextAfterCursor(ic.getTextAfterCursor(
                            msg.arg1, msg.arg2), args.seq);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        //End case DO_GET_TEXT_AFTER_CURSOR 
        //Begin case DO_GET_TEXT_BEFORE_CURSOR 
        {
            SomeArgs args;
            args = (SomeArgs)msg.obj;
            try 
            {
                InputConnection ic;
                ic = mInputConnection.get();
                {
                    boolean varD6C5F2B148FB14412C339FCDB147699A_1953685810 = (ic == null || !isActive());
                    {
                        args.callback.setTextBeforeCursor(null, args.seq);
                    } //End block
                } //End collapsed parenthetic
                args.callback.setTextBeforeCursor(ic.getTextBeforeCursor(
                            msg.arg1, msg.arg2), args.seq);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        //End case DO_GET_TEXT_BEFORE_CURSOR 
        //Begin case DO_GET_SELECTED_TEXT 
        {
            SomeArgs args;
            args = (SomeArgs)msg.obj;
            try 
            {
                InputConnection ic;
                ic = mInputConnection.get();
                {
                    boolean varD6C5F2B148FB14412C339FCDB147699A_2007861891 = (ic == null || !isActive());
                    {
                        args.callback.setSelectedText(null, args.seq);
                    } //End block
                } //End collapsed parenthetic
                args.callback.setSelectedText(ic.getSelectedText(
                            msg.arg1), args.seq);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        //End case DO_GET_SELECTED_TEXT 
        //Begin case DO_GET_CURSOR_CAPS_MODE 
        {
            SomeArgs args;
            args = (SomeArgs)msg.obj;
            try 
            {
                InputConnection ic;
                ic = mInputConnection.get();
                {
                    boolean varD6C5F2B148FB14412C339FCDB147699A_345993444 = (ic == null || !isActive());
                    {
                        args.callback.setCursorCapsMode(0, args.seq);
                    } //End block
                } //End collapsed parenthetic
                args.callback.setCursorCapsMode(ic.getCursorCapsMode(msg.arg1),
                            args.seq);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        //End case DO_GET_CURSOR_CAPS_MODE 
        //Begin case DO_GET_EXTRACTED_TEXT 
        {
            SomeArgs args;
            args = (SomeArgs)msg.obj;
            try 
            {
                InputConnection ic;
                ic = mInputConnection.get();
                {
                    boolean varD6C5F2B148FB14412C339FCDB147699A_1321411493 = (ic == null || !isActive());
                    {
                        args.callback.setExtractedText(null, args.seq);
                    } //End block
                } //End collapsed parenthetic
                args.callback.setExtractedText(ic.getExtractedText(
                            (ExtractedTextRequest)args.arg1, msg.arg1), args.seq);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        //End case DO_GET_EXTRACTED_TEXT 
        //Begin case DO_COMMIT_TEXT 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_456159744 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.commitText((CharSequence)msg.obj, msg.arg1);
        } //End block
        //End case DO_COMMIT_TEXT 
        //Begin case DO_SET_SELECTION 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_80328682 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.setSelection(msg.arg1, msg.arg2);
        } //End block
        //End case DO_SET_SELECTION 
        //Begin case DO_PERFORM_EDITOR_ACTION 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_77422762 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.performEditorAction(msg.arg1);
        } //End block
        //End case DO_PERFORM_EDITOR_ACTION 
        //Begin case DO_PERFORM_CONTEXT_MENU_ACTION 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_298558856 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.performContextMenuAction(msg.arg1);
        } //End block
        //End case DO_PERFORM_CONTEXT_MENU_ACTION 
        //Begin case DO_COMMIT_COMPLETION 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_529268349 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.commitCompletion((CompletionInfo)msg.obj);
        } //End block
        //End case DO_COMMIT_COMPLETION 
        //Begin case DO_COMMIT_CORRECTION 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_2107282578 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.commitCorrection((CorrectionInfo)msg.obj);
        } //End block
        //End case DO_COMMIT_CORRECTION 
        //Begin case DO_SET_COMPOSING_TEXT 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_2034225531 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.setComposingText((CharSequence)msg.obj, msg.arg1);
        } //End block
        //End case DO_SET_COMPOSING_TEXT 
        //Begin case DO_SET_COMPOSING_REGION 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_965014513 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.setComposingRegion(msg.arg1, msg.arg2);
        } //End block
        //End case DO_SET_COMPOSING_REGION 
        //Begin case DO_FINISH_COMPOSING_TEXT 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            ic.finishComposingText();
        } //End block
        //End case DO_FINISH_COMPOSING_TEXT 
        //Begin case DO_SEND_KEY_EVENT 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_839053763 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.sendKeyEvent((KeyEvent)msg.obj);
        } //End block
        //End case DO_SEND_KEY_EVENT 
        //Begin case DO_CLEAR_META_KEY_STATES 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1806958406 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.clearMetaKeyStates(msg.arg1);
        } //End block
        //End case DO_CLEAR_META_KEY_STATES 
        //Begin case DO_DELETE_SURROUNDING_TEXT 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1097898326 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.deleteSurroundingText(msg.arg1, msg.arg2);
        } //End block
        //End case DO_DELETE_SURROUNDING_TEXT 
        //Begin case DO_BEGIN_BATCH_EDIT 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1189552353 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.beginBatchEdit();
        } //End block
        //End case DO_BEGIN_BATCH_EDIT 
        //Begin case DO_END_BATCH_EDIT 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_557175783 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.endBatchEdit();
        } //End block
        //End case DO_END_BATCH_EDIT 
        //Begin case DO_REPORT_FULLSCREEN_MODE 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1151848732 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.reportFullscreenMode(msg.arg1 == 1);
        } //End block
        //End case DO_REPORT_FULLSCREEN_MODE 
        //Begin case DO_PERFORM_PRIVATE_COMMAND 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1340511539 = (ic == null || !isActive());
            } //End collapsed parenthetic
            SomeArgs args;
            args = (SomeArgs)msg.obj;
            ic.performPrivateCommand((String)args.arg1,
                        (Bundle)args.arg2);
        } //End block
        //End case DO_PERFORM_PRIVATE_COMMAND 
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.329 -0400", hash_original_method = "92301CED384526FAE2562FC8E2BD0E1D", hash_generated_method = "A227AD380295477D6B6AE2748A6C70D0")
     Message obtainMessage(int what) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1479060097 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1479060097 = mH.obtainMessage(what);
        addTaint(what);
        varB4EAC82CA7396A68D541C85D26508E83_1479060097.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1479060097;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.330 -0400", hash_original_method = "1D375F3B5B7A421102D544B0D8C99910", hash_generated_method = "759DF05C92C498FCF996A061B058C3F8")
     Message obtainMessageII(int what, int arg1, int arg2) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1630852503 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1630852503 = mH.obtainMessage(what, arg1, arg2);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        varB4EAC82CA7396A68D541C85D26508E83_1630852503.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1630852503;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.330 -0400", hash_original_method = "E41B1E1C050A3613D52D3D6F2431F5B0", hash_generated_method = "57B1543CAB8279078E877AA8B8667FD7")
     Message obtainMessageO(int what, Object arg1) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1676040312 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1676040312 = mH.obtainMessage(what, 0, 0, arg1);
        addTaint(what);
        addTaint(arg1.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1676040312.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1676040312;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, 0, 0, arg1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.338 -0400", hash_original_method = "C41806B53C46498944BCE998FEC907A1", hash_generated_method = "0A3408B20FB65BBDBF9F82A823961641")
     Message obtainMessageISC(int what, int arg1, int seq, IInputContextCallback callback) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1624679070 = null; //Variable for return #1
        SomeArgs args;
        args = new SomeArgs();
        args.callback = callback;
        args.seq = seq;
        varB4EAC82CA7396A68D541C85D26508E83_1624679070 = mH.obtainMessage(what, arg1, 0, args);
        addTaint(what);
        addTaint(arg1);
        addTaint(seq);
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1624679070.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1624679070;
        // ---------- Original Method ----------
        //SomeArgs args = new SomeArgs();
        //args.callback = callback;
        //args.seq = seq;
        //return mH.obtainMessage(what, arg1, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.339 -0400", hash_original_method = "81C8385506FF3623370F9C4C1A9DC229", hash_generated_method = "E151194545EDE28232E815CA7DA3936A")
     Message obtainMessageIISC(int what, int arg1, int arg2, int seq, IInputContextCallback callback) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1005776388 = null; //Variable for return #1
        SomeArgs args;
        args = new SomeArgs();
        args.callback = callback;
        args.seq = seq;
        varB4EAC82CA7396A68D541C85D26508E83_1005776388 = mH.obtainMessage(what, arg1, arg2, args);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        addTaint(seq);
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1005776388.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1005776388;
        // ---------- Original Method ----------
        //SomeArgs args = new SomeArgs();
        //args.callback = callback;
        //args.seq = seq;
        //return mH.obtainMessage(what, arg1, arg2, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.340 -0400", hash_original_method = "F0BFCDA04898886ED0BDB255B10E7641", hash_generated_method = "ECDA5E02A0B049746411CAB51206FE11")
     Message obtainMessageIOSC(int what, int arg1, Object arg2, int seq,
            IInputContextCallback callback) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1287991360 = null; //Variable for return #1
        SomeArgs args;
        args = new SomeArgs();
        args.arg1 = arg2;
        args.callback = callback;
        args.seq = seq;
        varB4EAC82CA7396A68D541C85D26508E83_1287991360 = mH.obtainMessage(what, arg1, 0, args);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2.getTaint());
        addTaint(seq);
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1287991360.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1287991360;
        // ---------- Original Method ----------
        //SomeArgs args = new SomeArgs();
        //args.arg1 = arg2;
        //args.callback = callback;
        //args.seq = seq;
        //return mH.obtainMessage(what, arg1, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.341 -0400", hash_original_method = "BDB545C9895C4A044C116EE5375794DB", hash_generated_method = "3F6C4D74417BE79AEB1295B322E7E707")
     Message obtainMessageIO(int what, int arg1, Object arg2) {
        Message varB4EAC82CA7396A68D541C85D26508E83_726766020 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_726766020 = mH.obtainMessage(what, arg1, 0, arg2);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_726766020.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_726766020;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, 0, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.353 -0400", hash_original_method = "0CCDC84288D426642A6380F76E883191", hash_generated_method = "2757970FECBDB8DA4EA7B8495BE13200")
     Message obtainMessageOO(int what, Object arg1, Object arg2) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1531781996 = null; //Variable for return #1
        SomeArgs args;
        args = new SomeArgs();
        args.arg1 = arg1;
        args.arg2 = arg2;
        varB4EAC82CA7396A68D541C85D26508E83_1531781996 = mH.obtainMessage(what, 0, 0, args);
        addTaint(what);
        addTaint(arg1.getTaint());
        addTaint(arg2.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1531781996.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1531781996;
        // ---------- Original Method ----------
        //SomeArgs args = new SomeArgs();
        //args.arg1 = arg1;
        //args.arg2 = arg2;
        //return mH.obtainMessage(what, 0, 0, args);
    }

    
    static class SomeArgs {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.353 -0400", hash_original_field = "E866231598ED4CB18BE5E493240A11B0", hash_generated_field = "524E284308787C3B27AB4CD560A816CF")

        Object arg1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.354 -0400", hash_original_field = "80A26383E00E892C98EBD598EDCC5DBB", hash_generated_field = "2CC0C93F38D97721E695C73C9F8BA144")

        Object arg2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.354 -0400", hash_original_field = "924A8CEEAC17F54D3BE3F8CDF1C04EB2", hash_generated_field = "844B2A0BBAFC5CBF10E337E600D741B3")

        IInputContextCallback callback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.354 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "C4ECE7ED8A0F11C4F90796D05BE13ED7")

        int seq;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.354 -0400", hash_original_method = "C08D0E88500332C6E0DD16EFE525CF46", hash_generated_method = "C08D0E88500332C6E0DD16EFE525CF46")
        public SomeArgs ()
        {
            //Synthesized constructor
        }


    }


    
    class MyHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.355 -0400", hash_original_method = "761ACCB2E72A1319CE4B08F794806580", hash_generated_method = "A640814F3C00E3175ECDA66EED93DC88")
          MyHandler(Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.374 -0400", hash_original_method = "1DE21F974CC2F2B42894E9D98B8A257E", hash_generated_method = "C43F62157A101926E70BDCE0229F24F6")
        @Override
        public void handleMessage(Message msg) {
            executeMessage(msg);
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            //executeMessage(msg);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.374 -0400", hash_original_field = "2C912F65B7F370D57F762FE5D19D4BE2", hash_generated_field = "45A3A08DFBD4A0C5D0DC0843BE34C5FF")

    static String TAG = "IInputConnectionWrapper";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.374 -0400", hash_original_field = "4ED50403A7474ACA03D96962CA629474", hash_generated_field = "4026C1A31143E1FC6243587CDC8A47EB")

    private static int DO_GET_TEXT_AFTER_CURSOR = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.374 -0400", hash_original_field = "725D1046CB42EC948EEFC59324072C38", hash_generated_field = "537446BF01BEE971BF922CB733652EDF")

    private static int DO_GET_TEXT_BEFORE_CURSOR = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.374 -0400", hash_original_field = "C6CB8D044B7A676A21868DBC3B6992E7", hash_generated_field = "1A41952BB6DAFA8269E42812E78642E3")

    private static int DO_GET_SELECTED_TEXT = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.374 -0400", hash_original_field = "04C50D07812F125F84E41E3BE0DA838C", hash_generated_field = "867F92E6C33FB2FE0E6ED3A0595872C6")

    private static int DO_GET_CURSOR_CAPS_MODE = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.374 -0400", hash_original_field = "9F85CECCAFE485433FF9E0DBDFF4DC0D", hash_generated_field = "1A5C3533CDA869A37FDF47CF8153F3D7")

    private static int DO_GET_EXTRACTED_TEXT = 40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.374 -0400", hash_original_field = "EC63C304A4880D2F78DBD98961CA7309", hash_generated_field = "9542C6D486E3EAE3C994D938CDC432E0")

    private static int DO_COMMIT_TEXT = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.374 -0400", hash_original_field = "D86E4E403145879C39C9B7A4B38C9072", hash_generated_field = "C06FCF93DA9989BA1259825C7D735CBD")

    private static int DO_COMMIT_COMPLETION = 55;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.375 -0400", hash_original_field = "FAE7CE09AE518D35FC722221C91CEF12", hash_generated_field = "3429D2AC4B33EC0AF94E694DFBD1DEA2")

    private static int DO_COMMIT_CORRECTION = 56;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.375 -0400", hash_original_field = "2EFDEFD94FC3FF82AA852E1A7ED2F4A0", hash_generated_field = "74C504C2AAEAF94B8D5317306878CEF0")

    private static int DO_SET_SELECTION = 57;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.375 -0400", hash_original_field = "B9460B3CF5E7B4EDA7ABAA225E3A7D4C", hash_generated_field = "C04643E590FFF56E7DB35E61513AE9E0")

    private static int DO_PERFORM_EDITOR_ACTION = 58;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.375 -0400", hash_original_field = "15DFE5D03CFE1F65BF076AD8D56917E0", hash_generated_field = "1D39461762095C500F9BDBFBB170C4EF")

    private static int DO_PERFORM_CONTEXT_MENU_ACTION = 59;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.375 -0400", hash_original_field = "D2FE5D65C0E0AC6F0CAC900A4291C782", hash_generated_field = "203904F06196608967CD60AA8D80834F")

    private static int DO_SET_COMPOSING_TEXT = 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.375 -0400", hash_original_field = "6FAE186F48B537D9F9FF59276A391D10", hash_generated_field = "EED43D23E3FC5288C41B74DEC57A4FBD")

    private static int DO_SET_COMPOSING_REGION = 63;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.375 -0400", hash_original_field = "9DF3EFB61898E55F35C2D13EF6043B89", hash_generated_field = "34B8137EEEFD47505BA2280332427342")

    private static int DO_FINISH_COMPOSING_TEXT = 65;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.375 -0400", hash_original_field = "F9906D40C7F6BD5C7A7D51FC303B9805", hash_generated_field = "8F75CC6BF6B81EB67FFFA8096B064EAB")

    private static int DO_SEND_KEY_EVENT = 70;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.375 -0400", hash_original_field = "BEE559E8A44BD9830EB266D1E715794B", hash_generated_field = "B08CD227D1703742A25ADDC892D029EE")

    private static int DO_DELETE_SURROUNDING_TEXT = 80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.375 -0400", hash_original_field = "96FC183EC850D36D03AB6F7138058D94", hash_generated_field = "1AE272F5BA9272A40215806E3E6C8336")

    private static int DO_BEGIN_BATCH_EDIT = 90;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.375 -0400", hash_original_field = "332C5FFBA2E78220DCAA7F5F59C064D0", hash_generated_field = "B75CF582845C2161C95BA4AF99B1EEE5")

    private static int DO_END_BATCH_EDIT = 95;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.376 -0400", hash_original_field = "137931DC8B66215806FD27D12075A205", hash_generated_field = "4618427735FCD0DB7B1150E8078E8441")

    private static int DO_REPORT_FULLSCREEN_MODE = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.376 -0400", hash_original_field = "687DA25EF98F2378B6DFC9AE9155E95E", hash_generated_field = "587D562A8474E5FAD167E0336414D345")

    private static int DO_PERFORM_PRIVATE_COMMAND = 120;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:26.376 -0400", hash_original_field = "51385D060DEB14F8392634E6908C9EA5", hash_generated_field = "96ACFE4B77C55E1682AF0577A0C8A394")

    private static int DO_CLEAR_META_KEY_STATES = 130;
}


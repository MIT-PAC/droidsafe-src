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
    static String TAG = "IInputConnectionWrapper";
    private static int DO_GET_TEXT_AFTER_CURSOR = 10;
    private static int DO_GET_TEXT_BEFORE_CURSOR = 20;
    private static int DO_GET_SELECTED_TEXT = 25;
    private static int DO_GET_CURSOR_CAPS_MODE = 30;
    private static int DO_GET_EXTRACTED_TEXT = 40;
    private static int DO_COMMIT_TEXT = 50;
    private static int DO_COMMIT_COMPLETION = 55;
    private static int DO_COMMIT_CORRECTION = 56;
    private static int DO_SET_SELECTION = 57;
    private static int DO_PERFORM_EDITOR_ACTION = 58;
    private static int DO_PERFORM_CONTEXT_MENU_ACTION = 59;
    private static int DO_SET_COMPOSING_TEXT = 60;
    private static int DO_SET_COMPOSING_REGION = 63;
    private static int DO_FINISH_COMPOSING_TEXT = 65;
    private static int DO_SEND_KEY_EVENT = 70;
    private static int DO_DELETE_SURROUNDING_TEXT = 80;
    private static int DO_BEGIN_BATCH_EDIT = 90;
    private static int DO_END_BATCH_EDIT = 95;
    private static int DO_REPORT_FULLSCREEN_MODE = 100;
    private static int DO_PERFORM_PRIVATE_COMMAND = 120;
    private static int DO_CLEAR_META_KEY_STATES = 130;
    private WeakReference<InputConnection> mInputConnection;
    private Looper mMainLooper;
    private Handler mH;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.232 -0400", hash_original_method = "9A20FF15705420E23492BF55DF80DCC1", hash_generated_method = "D468B500B69F4971621CE0B6533D39A7")
    @DSModeled(DSC.SAFE)
    public IInputConnectionWrapper(Looper mainLooper, InputConnection conn) {
        dsTaint.addTaint(conn.dsTaint);
        dsTaint.addTaint(mainLooper.dsTaint);
        mInputConnection = new WeakReference<InputConnection>(conn);
        mH = new MyHandler(mMainLooper);
        // ---------- Original Method ----------
        //mInputConnection = new WeakReference<InputConnection>(conn);
        //mMainLooper = mainLooper;
        //mH = new MyHandler(mMainLooper);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.271 -0400", hash_original_method = "51DFD52266A16587BB1D688A25EC9E53", hash_generated_method = "B75BCDD0284E8782F473C362E81CDB3E")
    @DSModeled(DSC.SAFE)
    public boolean isActive() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.281 -0400", hash_original_method = "BDB79A31B9E7C568F9DA8424F1B2AA88", hash_generated_method = "AE8EE22023C54C9872507740A1C1FAF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getTextAfterCursor(int length, int flags, int seq, IInputContextCallback callback) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(length);
        dsTaint.addTaint(seq);
        dsTaint.addTaint(callback.dsTaint);
        dispatchMessage(obtainMessageIISC(DO_GET_TEXT_AFTER_CURSOR, length, flags, seq, callback));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageIISC(DO_GET_TEXT_AFTER_CURSOR, length, flags, seq, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.301 -0400", hash_original_method = "83476DD996D24314F0D36073D788F8EE", hash_generated_method = "2A128D14D5B4B515DF529943DAACA4C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getTextBeforeCursor(int length, int flags, int seq, IInputContextCallback callback) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(length);
        dsTaint.addTaint(seq);
        dsTaint.addTaint(callback.dsTaint);
        dispatchMessage(obtainMessageIISC(DO_GET_TEXT_BEFORE_CURSOR, length, flags, seq, callback));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageIISC(DO_GET_TEXT_BEFORE_CURSOR, length, flags, seq, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.326 -0400", hash_original_method = "A721A8133D2DE1034FAEB50C8FE4FD06", hash_generated_method = "A59F4A45CA1B295439983E92D7ADA904")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getSelectedText(int flags, int seq, IInputContextCallback callback) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(seq);
        dsTaint.addTaint(callback.dsTaint);
        dispatchMessage(obtainMessageISC(DO_GET_SELECTED_TEXT, flags, seq, callback));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageISC(DO_GET_SELECTED_TEXT, flags, seq, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.361 -0400", hash_original_method = "C43DF3E6E3EDAF8991B1451D7C0930B2", hash_generated_method = "589B2024EEACFA64C7AD4B1B14F4BEB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getCursorCapsMode(int reqModes, int seq, IInputContextCallback callback) {
        dsTaint.addTaint(seq);
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(reqModes);
        dispatchMessage(obtainMessageISC(DO_GET_CURSOR_CAPS_MODE, reqModes, seq, callback));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageISC(DO_GET_CURSOR_CAPS_MODE, reqModes, seq, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.375 -0400", hash_original_method = "68CBA214FC59FA44F08B8B86723A4DD0", hash_generated_method = "C3B11D7B9BD62A106F0873D6ED36E2EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getExtractedText(ExtractedTextRequest request,
            int flags, int seq, IInputContextCallback callback) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(seq);
        dsTaint.addTaint(callback.dsTaint);
        dispatchMessage(obtainMessageIOSC(DO_GET_EXTRACTED_TEXT, flags,
                request, seq, callback));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageIOSC(DO_GET_EXTRACTED_TEXT, flags,
                //request, seq, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.389 -0400", hash_original_method = "894E006D9CEB98BFF63F2F46F25BC243", hash_generated_method = "550CC54E1F23F0AC10D51FCFEC525545")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void commitText(CharSequence text, int newCursorPosition) {
        dsTaint.addTaint(newCursorPosition);
        dsTaint.addTaint(text);
        dispatchMessage(obtainMessageIO(DO_COMMIT_TEXT, newCursorPosition, text));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageIO(DO_COMMIT_TEXT, newCursorPosition, text));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.391 -0400", hash_original_method = "CBF7B83C8E625835F649B99623E30868", hash_generated_method = "6D47B786043D9E06FDCEB7097D58D15C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void commitCompletion(CompletionInfo text) {
        dsTaint.addTaint(text.dsTaint);
        dispatchMessage(obtainMessageO(DO_COMMIT_COMPLETION, text));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageO(DO_COMMIT_COMPLETION, text));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.416 -0400", hash_original_method = "8124D711A8307E610C5DEF0F89DBA666", hash_generated_method = "C0430585BD1ED3F6E9A9A71A4B2B2600")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void commitCorrection(CorrectionInfo info) {
        dsTaint.addTaint(info.dsTaint);
        dispatchMessage(obtainMessageO(DO_COMMIT_CORRECTION, info));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageO(DO_COMMIT_CORRECTION, info));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.421 -0400", hash_original_method = "E49BA2D7A7A069DD200E49150DD829D6", hash_generated_method = "E0F0658EFF19C46313AEFE12D5BF4CCA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSelection(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        dispatchMessage(obtainMessageII(DO_SET_SELECTION, start, end));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_SET_SELECTION, start, end));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.463 -0400", hash_original_method = "21817A9A1C101F9FB118DF43CE4E5A0E", hash_generated_method = "21FBE7EAD78C44B06540E7E3D5600471")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void performEditorAction(int id) {
        dsTaint.addTaint(id);
        dispatchMessage(obtainMessageII(DO_PERFORM_EDITOR_ACTION, id, 0));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_PERFORM_EDITOR_ACTION, id, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.483 -0400", hash_original_method = "053D329299E415D96D47FCFD70FD4878", hash_generated_method = "EC5D93690E70CA3182D2A5C0DDE71868")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void performContextMenuAction(int id) {
        dsTaint.addTaint(id);
        dispatchMessage(obtainMessageII(DO_PERFORM_CONTEXT_MENU_ACTION, id, 0));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_PERFORM_CONTEXT_MENU_ACTION, id, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.513 -0400", hash_original_method = "D0BDE81E935635A3C1E1A2527338BB18", hash_generated_method = "ABF72C06E35386702E466FCDCEEECFC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setComposingRegion(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        dispatchMessage(obtainMessageII(DO_SET_COMPOSING_REGION, start, end));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_SET_COMPOSING_REGION, start, end));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.538 -0400", hash_original_method = "FC274EF8C2FF034547500DAA5F2951F1", hash_generated_method = "81608E8D750E50CEE5564B13CACC010B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setComposingText(CharSequence text, int newCursorPosition) {
        dsTaint.addTaint(newCursorPosition);
        dsTaint.addTaint(text);
        dispatchMessage(obtainMessageIO(DO_SET_COMPOSING_TEXT, newCursorPosition, text));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageIO(DO_SET_COMPOSING_TEXT, newCursorPosition, text));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.557 -0400", hash_original_method = "6F02D8053ECF48E238847A2FABA8F899", hash_generated_method = "AD483C4D2718D8E200525EFE94130C91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void finishComposingText() {
        dispatchMessage(obtainMessage(DO_FINISH_COMPOSING_TEXT));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessage(DO_FINISH_COMPOSING_TEXT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.574 -0400", hash_original_method = "60A7447AAE4F39255FF17C7443EAC7D8", hash_generated_method = "F2B5751F7AEA070003F68C113B903AFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendKeyEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        dispatchMessage(obtainMessageO(DO_SEND_KEY_EVENT, event));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageO(DO_SEND_KEY_EVENT, event));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.603 -0400", hash_original_method = "CDF50C376207E59459DF05B9EB51603A", hash_generated_method = "9057B2C8D0713CF887B92AD5F32110AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearMetaKeyStates(int states) {
        dsTaint.addTaint(states);
        dispatchMessage(obtainMessageII(DO_CLEAR_META_KEY_STATES, states, 0));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_CLEAR_META_KEY_STATES, states, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.621 -0400", hash_original_method = "2E4F7757D66A73FD9325207AD0D4F280", hash_generated_method = "B540E1A461255EF88613ED634E1B98C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void deleteSurroundingText(int leftLength, int rightLength) {
        dsTaint.addTaint(leftLength);
        dsTaint.addTaint(rightLength);
        dispatchMessage(obtainMessageII(DO_DELETE_SURROUNDING_TEXT,
            leftLength, rightLength));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_DELETE_SURROUNDING_TEXT,
            //leftLength, rightLength));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.623 -0400", hash_original_method = "7A31F16907F3D96E10B72B79CABC1C1A", hash_generated_method = "62DF7F25A2CA6247B1AD6673A6B92663")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void beginBatchEdit() {
        dispatchMessage(obtainMessage(DO_BEGIN_BATCH_EDIT));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessage(DO_BEGIN_BATCH_EDIT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.640 -0400", hash_original_method = "2DD80BF17B03574DE2AF6B49D0CD84C3", hash_generated_method = "64E204B2538C5E8CAECE24CCF24F16BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void endBatchEdit() {
        dispatchMessage(obtainMessage(DO_END_BATCH_EDIT));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessage(DO_END_BATCH_EDIT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.680 -0400", hash_original_method = "A19C601F9A82D2C4B88A8AB8DFBF0737", hash_generated_method = "00A57DB95A4158CE2490D66F14EE54C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reportFullscreenMode(boolean enabled) {
        dsTaint.addTaint(enabled);
        dispatchMessage(obtainMessageII(DO_REPORT_FULLSCREEN_MODE, enabled ? 1 : 0, 0));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_REPORT_FULLSCREEN_MODE, enabled ? 1 : 0, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.708 -0400", hash_original_method = "14DBCF261CA01A06A7ACE942F825CE65", hash_generated_method = "3AD7972AB45C3DBD9F3085334104EF29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void performPrivateCommand(String action, Bundle data) {
        dsTaint.addTaint(action);
        dsTaint.addTaint(data.dsTaint);
        dispatchMessage(obtainMessageOO(DO_PERFORM_PRIVATE_COMMAND, action, data));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageOO(DO_PERFORM_PRIVATE_COMMAND, action, data));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:49.733 -0400", hash_original_method = "F5A5E3786D2DDCB2FEFEBA688154C5D7", hash_generated_method = "C5F9C798C483F54F80ED08E177F5C3CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        {
            boolean varAFACA4F92DB746B2983C428CA25E9018_1525120024 = (Looper.myLooper() == mMainLooper);
            {
                executeMessage(msg);
                msg.recycle();
            } //End block
        } //End collapsed parenthetic
        mH.sendMessage(msg);
        // ---------- Original Method ----------
        //if (Looper.myLooper() == mMainLooper) {
            //executeMessage(msg);
            //msg.recycle();
            //return;
        //}
        //mH.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:50.018 -0400", hash_original_method = "78BA9F6D5AE481CC7127DB3741BBDA1E", hash_generated_method = "1F5602A1C6F68E30B555A88482C686B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void executeMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        //Begin case DO_GET_TEXT_AFTER_CURSOR 
        {
            SomeArgs args;
            args = (SomeArgs)msg.obj;
            try 
            {
                InputConnection ic;
                ic = mInputConnection.get();
                {
                    boolean varD6C5F2B148FB14412C339FCDB147699A_952380891 = (ic == null || !isActive());
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
                    boolean varD6C5F2B148FB14412C339FCDB147699A_1987859575 = (ic == null || !isActive());
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
                    boolean varD6C5F2B148FB14412C339FCDB147699A_105929828 = (ic == null || !isActive());
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
                    boolean varD6C5F2B148FB14412C339FCDB147699A_1967296682 = (ic == null || !isActive());
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
                    boolean varD6C5F2B148FB14412C339FCDB147699A_525244611 = (ic == null || !isActive());
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
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_140293555 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.commitText((CharSequence)msg.obj, msg.arg1);
        } //End block
        //End case DO_COMMIT_TEXT 
        //Begin case DO_SET_SELECTION 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1763976561 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.setSelection(msg.arg1, msg.arg2);
        } //End block
        //End case DO_SET_SELECTION 
        //Begin case DO_PERFORM_EDITOR_ACTION 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_574447878 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.performEditorAction(msg.arg1);
        } //End block
        //End case DO_PERFORM_EDITOR_ACTION 
        //Begin case DO_PERFORM_CONTEXT_MENU_ACTION 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_527694100 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.performContextMenuAction(msg.arg1);
        } //End block
        //End case DO_PERFORM_CONTEXT_MENU_ACTION 
        //Begin case DO_COMMIT_COMPLETION 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1369686309 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.commitCompletion((CompletionInfo)msg.obj);
        } //End block
        //End case DO_COMMIT_COMPLETION 
        //Begin case DO_COMMIT_CORRECTION 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_520123871 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.commitCorrection((CorrectionInfo)msg.obj);
        } //End block
        //End case DO_COMMIT_CORRECTION 
        //Begin case DO_SET_COMPOSING_TEXT 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1465026204 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.setComposingText((CharSequence)msg.obj, msg.arg1);
        } //End block
        //End case DO_SET_COMPOSING_TEXT 
        //Begin case DO_SET_COMPOSING_REGION 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1899685198 = (ic == null || !isActive());
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
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_139285473 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.sendKeyEvent((KeyEvent)msg.obj);
        } //End block
        //End case DO_SEND_KEY_EVENT 
        //Begin case DO_CLEAR_META_KEY_STATES 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1921692085 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.clearMetaKeyStates(msg.arg1);
        } //End block
        //End case DO_CLEAR_META_KEY_STATES 
        //Begin case DO_DELETE_SURROUNDING_TEXT 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1941391728 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.deleteSurroundingText(msg.arg1, msg.arg2);
        } //End block
        //End case DO_DELETE_SURROUNDING_TEXT 
        //Begin case DO_BEGIN_BATCH_EDIT 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_606947905 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.beginBatchEdit();
        } //End block
        //End case DO_BEGIN_BATCH_EDIT 
        //Begin case DO_END_BATCH_EDIT 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1874951163 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.endBatchEdit();
        } //End block
        //End case DO_END_BATCH_EDIT 
        //Begin case DO_REPORT_FULLSCREEN_MODE 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_2130098205 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.reportFullscreenMode(msg.arg1 == 1);
        } //End block
        //End case DO_REPORT_FULLSCREEN_MODE 
        //Begin case DO_PERFORM_PRIVATE_COMMAND 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_482347004 = (ic == null || !isActive());
            } //End collapsed parenthetic
            SomeArgs args;
            args = (SomeArgs)msg.obj;
            ic.performPrivateCommand((String)args.arg1,
                        (Bundle)args.arg2);
        } //End block
        //End case DO_PERFORM_PRIVATE_COMMAND 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:50.136 -0400", hash_original_method = "92301CED384526FAE2562FC8E2BD0E1D", hash_generated_method = "E29C5F7CBEDF970843CF22CC5ED72551")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Message obtainMessage(int what) {
        dsTaint.addTaint(what);
        Message varFEE2D1EE103817551737291B7608E5CF_246800468 = (mH.obtainMessage(what));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:50.161 -0400", hash_original_method = "1D375F3B5B7A421102D544B0D8C99910", hash_generated_method = "0ABAD541B7CA532BF0D29C9C5B36008B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Message obtainMessageII(int what, int arg1, int arg2) {
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        Message varAF554AB2540DE978951E6EC5F85F2810_1329307798 = (mH.obtainMessage(what, arg1, arg2));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:50.185 -0400", hash_original_method = "E41B1E1C050A3613D52D3D6F2431F5B0", hash_generated_method = "2F3C97DABA9DB92CB605CE7ABAFC48D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Message obtainMessageO(int what, Object arg1) {
        dsTaint.addTaint(arg1.dsTaint);
        dsTaint.addTaint(what);
        Message varDA5F1792EFFA87F1DF926A0581D1337A_1487588375 = (mH.obtainMessage(what, 0, 0, arg1));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, 0, 0, arg1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:50.214 -0400", hash_original_method = "C41806B53C46498944BCE998FEC907A1", hash_generated_method = "838D6BC53E01EA3F5A29D194A337CF4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Message obtainMessageISC(int what, int arg1, int seq, IInputContextCallback callback) {
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        dsTaint.addTaint(seq);
        dsTaint.addTaint(callback.dsTaint);
        SomeArgs args;
        args = new SomeArgs();
        args.callback = callback;
        args.seq = seq;
        Message var4636D3EBA90B94F7BD8E2550AB6B7C26_296209268 = (mH.obtainMessage(what, arg1, 0, args));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = new SomeArgs();
        //args.callback = callback;
        //args.seq = seq;
        //return mH.obtainMessage(what, arg1, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:50.263 -0400", hash_original_method = "81C8385506FF3623370F9C4C1A9DC229", hash_generated_method = "723C68C553E90B303AF16D32F7643398")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Message obtainMessageIISC(int what, int arg1, int arg2, int seq, IInputContextCallback callback) {
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        dsTaint.addTaint(seq);
        dsTaint.addTaint(callback.dsTaint);
        SomeArgs args;
        args = new SomeArgs();
        args.callback = callback;
        args.seq = seq;
        Message varAC3EF224B4A0F6C3A92DBFEB43407C15_2030463783 = (mH.obtainMessage(what, arg1, arg2, args));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = new SomeArgs();
        //args.callback = callback;
        //args.seq = seq;
        //return mH.obtainMessage(what, arg1, arg2, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:50.309 -0400", hash_original_method = "F0BFCDA04898886ED0BDB255B10E7641", hash_generated_method = "E02FF5DB19A90E675A4E5CB6C0FF95A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Message obtainMessageIOSC(int what, int arg1, Object arg2, int seq,
            IInputContextCallback callback) {
        dsTaint.addTaint(arg2.dsTaint);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        dsTaint.addTaint(seq);
        dsTaint.addTaint(callback.dsTaint);
        SomeArgs args;
        args = new SomeArgs();
        args.arg1 = arg2;
        args.callback = callback;
        args.seq = seq;
        Message var4636D3EBA90B94F7BD8E2550AB6B7C26_993687140 = (mH.obtainMessage(what, arg1, 0, args));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = new SomeArgs();
        //args.arg1 = arg2;
        //args.callback = callback;
        //args.seq = seq;
        //return mH.obtainMessage(what, arg1, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:50.322 -0400", hash_original_method = "BDB545C9895C4A044C116EE5375794DB", hash_generated_method = "E6B392D5EF6D3B9C4EE0873E25769C1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Message obtainMessageIO(int what, int arg1, Object arg2) {
        dsTaint.addTaint(arg2.dsTaint);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        Message var670ADA01A86B54F5DD338CBFE2859A08_133803717 = (mH.obtainMessage(what, arg1, 0, arg2));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, 0, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:50.348 -0400", hash_original_method = "0CCDC84288D426642A6380F76E883191", hash_generated_method = "95974E63C9DBF554E9ABD16A479240BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Message obtainMessageOO(int what, Object arg1, Object arg2) {
        dsTaint.addTaint(arg2.dsTaint);
        dsTaint.addTaint(arg1.dsTaint);
        dsTaint.addTaint(what);
        SomeArgs args;
        args = new SomeArgs();
        args.arg1 = arg1;
        args.arg2 = arg2;
        Message var6B3D46964E3CD4869B46C48561D658E2_1104173013 = (mH.obtainMessage(what, 0, 0, args));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = new SomeArgs();
        //args.arg1 = arg1;
        //args.arg2 = arg2;
        //return mH.obtainMessage(what, 0, 0, args);
    }

    
    static class SomeArgs {
        Object arg1;
        Object arg2;
        IInputContextCallback callback;
        int seq;
        
    }


    
    class MyHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:50.381 -0400", hash_original_method = "761ACCB2E72A1319CE4B08F794806580", hash_generated_method = "DB0BBD9DD8D354B255ECFC0BE6ACB2E2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         MyHandler(Looper looper) {
            super(looper);
            dsTaint.addTaint(looper.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:50.406 -0400", hash_original_method = "1DE21F974CC2F2B42894E9D98B8A257E", hash_generated_method = "9A93A58F1E26D53DD7EFDD55EED47BF5")
        @DSModeled(DSC.SAFE)
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            executeMessage(msg);
            // ---------- Original Method ----------
            //executeMessage(msg);
        }

        
    }


    
}



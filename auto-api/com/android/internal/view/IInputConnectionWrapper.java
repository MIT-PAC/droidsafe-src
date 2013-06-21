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
    private WeakReference<InputConnection> mInputConnection;
    private Looper mMainLooper;
    private Handler mH;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.988 -0400", hash_original_method = "9A20FF15705420E23492BF55DF80DCC1", hash_generated_method = "807892640C76D16282B4C5DE4C44254B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.988 -0400", hash_original_method = "51DFD52266A16587BB1D688A25EC9E53", hash_generated_method = "CD1560829A9965E7F2A1763845CBDDCE")
    @DSModeled(DSC.SAFE)
    public boolean isActive() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.988 -0400", hash_original_method = "BDB79A31B9E7C568F9DA8424F1B2AA88", hash_generated_method = "01715EA397FCA011330B5089BAF22716")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getTextAfterCursor(int length, int flags, int seq, IInputContextCallback callback) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(seq);
        dsTaint.addTaint(length);
        dispatchMessage(obtainMessageIISC(DO_GET_TEXT_AFTER_CURSOR, length, flags, seq, callback));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageIISC(DO_GET_TEXT_AFTER_CURSOR, length, flags, seq, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.988 -0400", hash_original_method = "83476DD996D24314F0D36073D788F8EE", hash_generated_method = "77E3E0C33395866A5DBA40BEEECDCCEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getTextBeforeCursor(int length, int flags, int seq, IInputContextCallback callback) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(seq);
        dsTaint.addTaint(length);
        dispatchMessage(obtainMessageIISC(DO_GET_TEXT_BEFORE_CURSOR, length, flags, seq, callback));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageIISC(DO_GET_TEXT_BEFORE_CURSOR, length, flags, seq, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.989 -0400", hash_original_method = "A721A8133D2DE1034FAEB50C8FE4FD06", hash_generated_method = "FCB1D09CDBFFCF85EE157907EF34564C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getSelectedText(int flags, int seq, IInputContextCallback callback) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(seq);
        dispatchMessage(obtainMessageISC(DO_GET_SELECTED_TEXT, flags, seq, callback));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageISC(DO_GET_SELECTED_TEXT, flags, seq, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.989 -0400", hash_original_method = "C43DF3E6E3EDAF8991B1451D7C0930B2", hash_generated_method = "011A28BB02BEFC0A3DF6B93F976E0C95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getCursorCapsMode(int reqModes, int seq, IInputContextCallback callback) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(seq);
        dsTaint.addTaint(reqModes);
        dispatchMessage(obtainMessageISC(DO_GET_CURSOR_CAPS_MODE, reqModes, seq, callback));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageISC(DO_GET_CURSOR_CAPS_MODE, reqModes, seq, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.989 -0400", hash_original_method = "68CBA214FC59FA44F08B8B86723A4DD0", hash_generated_method = "EDB1C523B2C53D70A323BB34C048239D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getExtractedText(ExtractedTextRequest request,
            int flags, int seq, IInputContextCallback callback) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(seq);
        dispatchMessage(obtainMessageIOSC(DO_GET_EXTRACTED_TEXT, flags,
                request, seq, callback));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageIOSC(DO_GET_EXTRACTED_TEXT, flags,
                //request, seq, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.989 -0400", hash_original_method = "894E006D9CEB98BFF63F2F46F25BC243", hash_generated_method = "9DAABFD051B63E6A3B60F63BD5BA36EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void commitText(CharSequence text, int newCursorPosition) {
        dsTaint.addTaint(newCursorPosition);
        dsTaint.addTaint(text);
        dispatchMessage(obtainMessageIO(DO_COMMIT_TEXT, newCursorPosition, text));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageIO(DO_COMMIT_TEXT, newCursorPosition, text));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.989 -0400", hash_original_method = "CBF7B83C8E625835F649B99623E30868", hash_generated_method = "4802C1045E688ECAEF748BF690AE3404")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void commitCompletion(CompletionInfo text) {
        dsTaint.addTaint(text.dsTaint);
        dispatchMessage(obtainMessageO(DO_COMMIT_COMPLETION, text));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageO(DO_COMMIT_COMPLETION, text));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.989 -0400", hash_original_method = "8124D711A8307E610C5DEF0F89DBA666", hash_generated_method = "896246F1A41BF4FBE77223529B557BC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void commitCorrection(CorrectionInfo info) {
        dsTaint.addTaint(info.dsTaint);
        dispatchMessage(obtainMessageO(DO_COMMIT_CORRECTION, info));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageO(DO_COMMIT_CORRECTION, info));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.990 -0400", hash_original_method = "E49BA2D7A7A069DD200E49150DD829D6", hash_generated_method = "8DE08D3229D3C1C3AD98632222938AD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSelection(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        dispatchMessage(obtainMessageII(DO_SET_SELECTION, start, end));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_SET_SELECTION, start, end));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.990 -0400", hash_original_method = "21817A9A1C101F9FB118DF43CE4E5A0E", hash_generated_method = "B2319AA31DF55F9E17220E462378B78A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void performEditorAction(int id) {
        dsTaint.addTaint(id);
        dispatchMessage(obtainMessageII(DO_PERFORM_EDITOR_ACTION, id, 0));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_PERFORM_EDITOR_ACTION, id, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.990 -0400", hash_original_method = "053D329299E415D96D47FCFD70FD4878", hash_generated_method = "B159E3821986DED0C11E04BE44D31FA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void performContextMenuAction(int id) {
        dsTaint.addTaint(id);
        dispatchMessage(obtainMessageII(DO_PERFORM_CONTEXT_MENU_ACTION, id, 0));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_PERFORM_CONTEXT_MENU_ACTION, id, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.990 -0400", hash_original_method = "D0BDE81E935635A3C1E1A2527338BB18", hash_generated_method = "81E351BACBC84BF9D93A94B4E50F150F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setComposingRegion(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        dispatchMessage(obtainMessageII(DO_SET_COMPOSING_REGION, start, end));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_SET_COMPOSING_REGION, start, end));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.990 -0400", hash_original_method = "FC274EF8C2FF034547500DAA5F2951F1", hash_generated_method = "704DFBECD63D828854043553FE97133E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setComposingText(CharSequence text, int newCursorPosition) {
        dsTaint.addTaint(newCursorPosition);
        dsTaint.addTaint(text);
        dispatchMessage(obtainMessageIO(DO_SET_COMPOSING_TEXT, newCursorPosition, text));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageIO(DO_SET_COMPOSING_TEXT, newCursorPosition, text));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.990 -0400", hash_original_method = "6F02D8053ECF48E238847A2FABA8F899", hash_generated_method = "0EA1C6FF08BDC7474C1F768E99AC789D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void finishComposingText() {
        dispatchMessage(obtainMessage(DO_FINISH_COMPOSING_TEXT));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessage(DO_FINISH_COMPOSING_TEXT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.991 -0400", hash_original_method = "60A7447AAE4F39255FF17C7443EAC7D8", hash_generated_method = "EAB941C143ABBD6F3AD99AABD259D11C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendKeyEvent(KeyEvent event) {
        dsTaint.addTaint(event.dsTaint);
        dispatchMessage(obtainMessageO(DO_SEND_KEY_EVENT, event));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageO(DO_SEND_KEY_EVENT, event));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.991 -0400", hash_original_method = "CDF50C376207E59459DF05B9EB51603A", hash_generated_method = "63DC155583D1E147B01A54F87BD96782")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearMetaKeyStates(int states) {
        dsTaint.addTaint(states);
        dispatchMessage(obtainMessageII(DO_CLEAR_META_KEY_STATES, states, 0));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_CLEAR_META_KEY_STATES, states, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.991 -0400", hash_original_method = "2E4F7757D66A73FD9325207AD0D4F280", hash_generated_method = "F93C90531337506548AC9F34E572E456")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.991 -0400", hash_original_method = "7A31F16907F3D96E10B72B79CABC1C1A", hash_generated_method = "ABE69A11FC08E9E6D9B71FEA871175F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void beginBatchEdit() {
        dispatchMessage(obtainMessage(DO_BEGIN_BATCH_EDIT));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessage(DO_BEGIN_BATCH_EDIT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.991 -0400", hash_original_method = "2DD80BF17B03574DE2AF6B49D0CD84C3", hash_generated_method = "A09066AF166CB53E5DD594379D99093E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void endBatchEdit() {
        dispatchMessage(obtainMessage(DO_END_BATCH_EDIT));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessage(DO_END_BATCH_EDIT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.991 -0400", hash_original_method = "A19C601F9A82D2C4B88A8AB8DFBF0737", hash_generated_method = "439E81980BA2034AF03BB7BCE22BDFAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reportFullscreenMode(boolean enabled) {
        dsTaint.addTaint(enabled);
        dispatchMessage(obtainMessageII(DO_REPORT_FULLSCREEN_MODE, enabled ? 1 : 0, 0));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageII(DO_REPORT_FULLSCREEN_MODE, enabled ? 1 : 0, 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.992 -0400", hash_original_method = "14DBCF261CA01A06A7ACE942F825CE65", hash_generated_method = "A4C18AE41680E1C9D48BB03989B2DF5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void performPrivateCommand(String action, Bundle data) {
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(action);
        dispatchMessage(obtainMessageOO(DO_PERFORM_PRIVATE_COMMAND, action, data));
        // ---------- Original Method ----------
        //dispatchMessage(obtainMessageOO(DO_PERFORM_PRIVATE_COMMAND, action, data));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.992 -0400", hash_original_method = "F5A5E3786D2DDCB2FEFEBA688154C5D7", hash_generated_method = "0882DA7CE159BDE6EE214C2DEB49279B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void dispatchMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        {
            boolean varAFACA4F92DB746B2983C428CA25E9018_1154313504 = (Looper.myLooper() == mMainLooper);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.994 -0400", hash_original_method = "78BA9F6D5AE481CC7127DB3741BBDA1E", hash_generated_method = "6CA4B7BBF5ECCCB36BA3B7657D90A7FF")
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
                    boolean varD6C5F2B148FB14412C339FCDB147699A_533044698 = (ic == null || !isActive());
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
                    boolean varD6C5F2B148FB14412C339FCDB147699A_1785562418 = (ic == null || !isActive());
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
                    boolean varD6C5F2B148FB14412C339FCDB147699A_980579210 = (ic == null || !isActive());
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
                    boolean varD6C5F2B148FB14412C339FCDB147699A_843572166 = (ic == null || !isActive());
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
                    boolean varD6C5F2B148FB14412C339FCDB147699A_1439015529 = (ic == null || !isActive());
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
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_761376278 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.commitText((CharSequence)msg.obj, msg.arg1);
        } //End block
        //End case DO_COMMIT_TEXT 
        //Begin case DO_SET_SELECTION 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_660230156 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.setSelection(msg.arg1, msg.arg2);
        } //End block
        //End case DO_SET_SELECTION 
        //Begin case DO_PERFORM_EDITOR_ACTION 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1868547801 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.performEditorAction(msg.arg1);
        } //End block
        //End case DO_PERFORM_EDITOR_ACTION 
        //Begin case DO_PERFORM_CONTEXT_MENU_ACTION 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_680670393 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.performContextMenuAction(msg.arg1);
        } //End block
        //End case DO_PERFORM_CONTEXT_MENU_ACTION 
        //Begin case DO_COMMIT_COMPLETION 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_186194167 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.commitCompletion((CompletionInfo)msg.obj);
        } //End block
        //End case DO_COMMIT_COMPLETION 
        //Begin case DO_COMMIT_CORRECTION 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_833898395 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.commitCorrection((CorrectionInfo)msg.obj);
        } //End block
        //End case DO_COMMIT_CORRECTION 
        //Begin case DO_SET_COMPOSING_TEXT 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_473979680 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.setComposingText((CharSequence)msg.obj, msg.arg1);
        } //End block
        //End case DO_SET_COMPOSING_TEXT 
        //Begin case DO_SET_COMPOSING_REGION 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1885237140 = (ic == null || !isActive());
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
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_914178631 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.sendKeyEvent((KeyEvent)msg.obj);
        } //End block
        //End case DO_SEND_KEY_EVENT 
        //Begin case DO_CLEAR_META_KEY_STATES 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_525388149 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.clearMetaKeyStates(msg.arg1);
        } //End block
        //End case DO_CLEAR_META_KEY_STATES 
        //Begin case DO_DELETE_SURROUNDING_TEXT 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1471068641 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.deleteSurroundingText(msg.arg1, msg.arg2);
        } //End block
        //End case DO_DELETE_SURROUNDING_TEXT 
        //Begin case DO_BEGIN_BATCH_EDIT 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1062468630 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.beginBatchEdit();
        } //End block
        //End case DO_BEGIN_BATCH_EDIT 
        //Begin case DO_END_BATCH_EDIT 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_883245638 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.endBatchEdit();
        } //End block
        //End case DO_END_BATCH_EDIT 
        //Begin case DO_REPORT_FULLSCREEN_MODE 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_980507042 = (ic == null || !isActive());
            } //End collapsed parenthetic
            ic.reportFullscreenMode(msg.arg1 == 1);
        } //End block
        //End case DO_REPORT_FULLSCREEN_MODE 
        //Begin case DO_PERFORM_PRIVATE_COMMAND 
        {
            InputConnection ic;
            ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_306504651 = (ic == null || !isActive());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.995 -0400", hash_original_method = "92301CED384526FAE2562FC8E2BD0E1D", hash_generated_method = "E2B06297D8A361E694C35A07975296DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Message obtainMessage(int what) {
        dsTaint.addTaint(what);
        Message varFEE2D1EE103817551737291B7608E5CF_1460638551 = (mH.obtainMessage(what));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.995 -0400", hash_original_method = "1D375F3B5B7A421102D544B0D8C99910", hash_generated_method = "54C88F4CA77D75F94D976A990E1CD903")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Message obtainMessageII(int what, int arg1, int arg2) {
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        Message varAF554AB2540DE978951E6EC5F85F2810_501429577 = (mH.obtainMessage(what, arg1, arg2));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.996 -0400", hash_original_method = "E41B1E1C050A3613D52D3D6F2431F5B0", hash_generated_method = "E5126DD23AC83361B0DB7B30821D28DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Message obtainMessageO(int what, Object arg1) {
        dsTaint.addTaint(arg1.dsTaint);
        dsTaint.addTaint(what);
        Message varDA5F1792EFFA87F1DF926A0581D1337A_2076296990 = (mH.obtainMessage(what, 0, 0, arg1));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, 0, 0, arg1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.996 -0400", hash_original_method = "C41806B53C46498944BCE998FEC907A1", hash_generated_method = "54E0DB38226741A55344C8BD54B8AFE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Message obtainMessageISC(int what, int arg1, int seq, IInputContextCallback callback) {
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(seq);
        SomeArgs args;
        args = new SomeArgs();
        args.callback = callback;
        args.seq = seq;
        Message var4636D3EBA90B94F7BD8E2550AB6B7C26_751184666 = (mH.obtainMessage(what, arg1, 0, args));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = new SomeArgs();
        //args.callback = callback;
        //args.seq = seq;
        //return mH.obtainMessage(what, arg1, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.996 -0400", hash_original_method = "81C8385506FF3623370F9C4C1A9DC229", hash_generated_method = "04BF53D694F3F055517DB240B75C6BB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Message obtainMessageIISC(int what, int arg1, int arg2, int seq, IInputContextCallback callback) {
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(seq);
        SomeArgs args;
        args = new SomeArgs();
        args.callback = callback;
        args.seq = seq;
        Message varAC3EF224B4A0F6C3A92DBFEB43407C15_1552790445 = (mH.obtainMessage(what, arg1, arg2, args));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = new SomeArgs();
        //args.callback = callback;
        //args.seq = seq;
        //return mH.obtainMessage(what, arg1, arg2, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.996 -0400", hash_original_method = "F0BFCDA04898886ED0BDB255B10E7641", hash_generated_method = "052062F6FF76B866C38B02E48659D682")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Message obtainMessageIOSC(int what, int arg1, Object arg2, int seq,
            IInputContextCallback callback) {
        dsTaint.addTaint(arg2.dsTaint);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(seq);
        SomeArgs args;
        args = new SomeArgs();
        args.arg1 = arg2;
        args.callback = callback;
        args.seq = seq;
        Message var4636D3EBA90B94F7BD8E2550AB6B7C26_1442525950 = (mH.obtainMessage(what, arg1, 0, args));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = new SomeArgs();
        //args.arg1 = arg2;
        //args.callback = callback;
        //args.seq = seq;
        //return mH.obtainMessage(what, arg1, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.996 -0400", hash_original_method = "BDB545C9895C4A044C116EE5375794DB", hash_generated_method = "1D1E15ADC447BECD43AEEB68127903B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Message obtainMessageIO(int what, int arg1, Object arg2) {
        dsTaint.addTaint(arg2.dsTaint);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        Message var670ADA01A86B54F5DD338CBFE2859A08_1811362964 = (mH.obtainMessage(what, arg1, 0, arg2));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, 0, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.997 -0400", hash_original_method = "0CCDC84288D426642A6380F76E883191", hash_generated_method = "8FCFD66AF46E72836C69073063E57437")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Message obtainMessageOO(int what, Object arg1, Object arg2) {
        dsTaint.addTaint(arg2.dsTaint);
        dsTaint.addTaint(arg1.dsTaint);
        dsTaint.addTaint(what);
        SomeArgs args;
        args = new SomeArgs();
        args.arg1 = arg1;
        args.arg2 = arg2;
        Message var6B3D46964E3CD4869B46C48561D658E2_698313531 = (mH.obtainMessage(what, 0, 0, args));
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.997 -0400", hash_original_method = "1DC11EC4B8DE02C86752DC3C92AC9A78", hash_generated_method = "1DC11EC4B8DE02C86752DC3C92AC9A78")
                public SomeArgs ()
        {
        }


    }


    
    class MyHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.997 -0400", hash_original_method = "761ACCB2E72A1319CE4B08F794806580", hash_generated_method = "EEC454106D5898516E458706CD5449DB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         MyHandler(Looper looper) {
            super(looper);
            dsTaint.addTaint(looper.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.997 -0400", hash_original_method = "1DE21F974CC2F2B42894E9D98B8A257E", hash_generated_method = "9CC1BBCD36BD4204192D24639F5DBF79")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            executeMessage(msg);
            // ---------- Original Method ----------
            //executeMessage(msg);
        }

        
    }


    
    static final String TAG = "IInputConnectionWrapper";
    private static final int DO_GET_TEXT_AFTER_CURSOR = 10;
    private static final int DO_GET_TEXT_BEFORE_CURSOR = 20;
    private static final int DO_GET_SELECTED_TEXT = 25;
    private static final int DO_GET_CURSOR_CAPS_MODE = 30;
    private static final int DO_GET_EXTRACTED_TEXT = 40;
    private static final int DO_COMMIT_TEXT = 50;
    private static final int DO_COMMIT_COMPLETION = 55;
    private static final int DO_COMMIT_CORRECTION = 56;
    private static final int DO_SET_SELECTION = 57;
    private static final int DO_PERFORM_EDITOR_ACTION = 58;
    private static final int DO_PERFORM_CONTEXT_MENU_ACTION = 59;
    private static final int DO_SET_COMPOSING_TEXT = 60;
    private static final int DO_SET_COMPOSING_REGION = 63;
    private static final int DO_FINISH_COMPOSING_TEXT = 65;
    private static final int DO_SEND_KEY_EVENT = 70;
    private static final int DO_DELETE_SURROUNDING_TEXT = 80;
    private static final int DO_BEGIN_BATCH_EDIT = 90;
    private static final int DO_END_BATCH_EDIT = 95;
    private static final int DO_REPORT_FULLSCREEN_MODE = 100;
    private static final int DO_PERFORM_PRIVATE_COMMAND = 120;
    private static final int DO_CLEAR_META_KEY_STATES = 130;
}


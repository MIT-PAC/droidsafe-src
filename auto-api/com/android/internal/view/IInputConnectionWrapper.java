package com.android.internal.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.190 -0400", hash_original_field = "A2D010B7C3546462A260EC1C5E1ED4C6", hash_generated_field = "BBA366FC8F1B26518754E187C86749B0")

    private WeakReference<InputConnection> mInputConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.190 -0400", hash_original_field = "6C2EA91B438529F1372D806717F5AE04", hash_generated_field = "BAC908CF5B8572ED590A292E13883CF4")

    private Looper mMainLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.190 -0400", hash_original_field = "6D1DA64E705BB119454CD3D6A13CB760", hash_generated_field = "A3B75E764711EA55737A441425E4D843")

    private Handler mH;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.191 -0400", hash_original_method = "9A20FF15705420E23492BF55DF80DCC1", hash_generated_method = "C3D67277BD877481EBAF63AB4875E775")
    public  IInputConnectionWrapper(Looper mainLooper, InputConnection conn) {
        mInputConnection = new WeakReference<InputConnection>(conn);
        mMainLooper = mainLooper;
        mH = new MyHandler(mMainLooper);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.191 -0400", hash_original_method = "51DFD52266A16587BB1D688A25EC9E53", hash_generated_method = "A2DB8A29644DD90FF2902FE2085D4F9E")
    public boolean isActive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1614527430 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1614527430;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.191 -0400", hash_original_method = "BDB79A31B9E7C568F9DA8424F1B2AA88", hash_generated_method = "ABB209A3F56953225EC8C46CC85B1AC7")
    public void getTextAfterCursor(int length, int flags, int seq, IInputContextCallback callback) {
        dispatchMessage(obtainMessageIISC(DO_GET_TEXT_AFTER_CURSOR, length, flags, seq, callback));
        addTaint(length);
        addTaint(flags);
        addTaint(seq);
        addTaint(callback.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.191 -0400", hash_original_method = "83476DD996D24314F0D36073D788F8EE", hash_generated_method = "6CC62D522417B969E4C9D4718AFCA28C")
    public void getTextBeforeCursor(int length, int flags, int seq, IInputContextCallback callback) {
        dispatchMessage(obtainMessageIISC(DO_GET_TEXT_BEFORE_CURSOR, length, flags, seq, callback));
        addTaint(length);
        addTaint(flags);
        addTaint(seq);
        addTaint(callback.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.192 -0400", hash_original_method = "A721A8133D2DE1034FAEB50C8FE4FD06", hash_generated_method = "9F807B0EE2D42DEDEE65B9718AF3363C")
    public void getSelectedText(int flags, int seq, IInputContextCallback callback) {
        dispatchMessage(obtainMessageISC(DO_GET_SELECTED_TEXT, flags, seq, callback));
        addTaint(flags);
        addTaint(seq);
        addTaint(callback.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.192 -0400", hash_original_method = "C43DF3E6E3EDAF8991B1451D7C0930B2", hash_generated_method = "B6F8FB36CE2D0F4823F4AF590B20D5A9")
    public void getCursorCapsMode(int reqModes, int seq, IInputContextCallback callback) {
        dispatchMessage(obtainMessageISC(DO_GET_CURSOR_CAPS_MODE, reqModes, seq, callback));
        addTaint(reqModes);
        addTaint(seq);
        addTaint(callback.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.192 -0400", hash_original_method = "68CBA214FC59FA44F08B8B86723A4DD0", hash_generated_method = "D73C425BB23A75CC2235A5B49D60A706")
    public void getExtractedText(ExtractedTextRequest request,
            int flags, int seq, IInputContextCallback callback) {
        dispatchMessage(obtainMessageIOSC(DO_GET_EXTRACTED_TEXT, flags,
                request, seq, callback));
        addTaint(request.getTaint());
        addTaint(flags);
        addTaint(seq);
        addTaint(callback.getTaint());
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.192 -0400", hash_original_method = "894E006D9CEB98BFF63F2F46F25BC243", hash_generated_method = "3BDC86837C06D9240A9F9981C543ED8F")
    public void commitText(CharSequence text, int newCursorPosition) {
        dispatchMessage(obtainMessageIO(DO_COMMIT_TEXT, newCursorPosition, text));
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.192 -0400", hash_original_method = "CBF7B83C8E625835F649B99623E30868", hash_generated_method = "996CCB9204B864A0D975D6DB0BE897D1")
    public void commitCompletion(CompletionInfo text) {
        dispatchMessage(obtainMessageO(DO_COMMIT_COMPLETION, text));
        addTaint(text.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.193 -0400", hash_original_method = "8124D711A8307E610C5DEF0F89DBA666", hash_generated_method = "1D67555E50818966A36BBE780BB1BBC9")
    public void commitCorrection(CorrectionInfo info) {
        dispatchMessage(obtainMessageO(DO_COMMIT_CORRECTION, info));
        addTaint(info.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.193 -0400", hash_original_method = "E49BA2D7A7A069DD200E49150DD829D6", hash_generated_method = "AD8EC72FD27071B065075448FB128197")
    public void setSelection(int start, int end) {
        dispatchMessage(obtainMessageII(DO_SET_SELECTION, start, end));
        addTaint(start);
        addTaint(end);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.193 -0400", hash_original_method = "21817A9A1C101F9FB118DF43CE4E5A0E", hash_generated_method = "C4320B84C7250A393AE2AECA97686F2B")
    public void performEditorAction(int id) {
        dispatchMessage(obtainMessageII(DO_PERFORM_EDITOR_ACTION, id, 0));
        addTaint(id);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.193 -0400", hash_original_method = "053D329299E415D96D47FCFD70FD4878", hash_generated_method = "F8DA294E0E30F559226BAAA99F5E0A61")
    public void performContextMenuAction(int id) {
        dispatchMessage(obtainMessageII(DO_PERFORM_CONTEXT_MENU_ACTION, id, 0));
        addTaint(id);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.194 -0400", hash_original_method = "D0BDE81E935635A3C1E1A2527338BB18", hash_generated_method = "6BA5C1F07D338665E5B4CBC7C0B25723")
    public void setComposingRegion(int start, int end) {
        dispatchMessage(obtainMessageII(DO_SET_COMPOSING_REGION, start, end));
        addTaint(start);
        addTaint(end);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.194 -0400", hash_original_method = "FC274EF8C2FF034547500DAA5F2951F1", hash_generated_method = "A4186045CEF0C029B9324922A9632F26")
    public void setComposingText(CharSequence text, int newCursorPosition) {
        dispatchMessage(obtainMessageIO(DO_SET_COMPOSING_TEXT, newCursorPosition, text));
        addTaint(text.getTaint());
        addTaint(newCursorPosition);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.194 -0400", hash_original_method = "6F02D8053ECF48E238847A2FABA8F899", hash_generated_method = "0EA1C6FF08BDC7474C1F768E99AC789D")
    public void finishComposingText() {
        dispatchMessage(obtainMessage(DO_FINISH_COMPOSING_TEXT));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.194 -0400", hash_original_method = "60A7447AAE4F39255FF17C7443EAC7D8", hash_generated_method = "4BAB8202282289D09F8628CFE6BB2DD3")
    public void sendKeyEvent(KeyEvent event) {
        dispatchMessage(obtainMessageO(DO_SEND_KEY_EVENT, event));
        addTaint(event.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.195 -0400", hash_original_method = "CDF50C376207E59459DF05B9EB51603A", hash_generated_method = "4A5EDEAC71DBE7CC29538323E0C6A499")
    public void clearMetaKeyStates(int states) {
        dispatchMessage(obtainMessageII(DO_CLEAR_META_KEY_STATES, states, 0));
        addTaint(states);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.195 -0400", hash_original_method = "2E4F7757D66A73FD9325207AD0D4F280", hash_generated_method = "CD0726CBF7F43F0B461D3B6733A6A4A0")
    public void deleteSurroundingText(int leftLength, int rightLength) {
        dispatchMessage(obtainMessageII(DO_DELETE_SURROUNDING_TEXT,
            leftLength, rightLength));
        addTaint(leftLength);
        addTaint(rightLength);
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.195 -0400", hash_original_method = "7A31F16907F3D96E10B72B79CABC1C1A", hash_generated_method = "ABE69A11FC08E9E6D9B71FEA871175F2")
    public void beginBatchEdit() {
        dispatchMessage(obtainMessage(DO_BEGIN_BATCH_EDIT));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.195 -0400", hash_original_method = "2DD80BF17B03574DE2AF6B49D0CD84C3", hash_generated_method = "A09066AF166CB53E5DD594379D99093E")
    public void endBatchEdit() {
        dispatchMessage(obtainMessage(DO_END_BATCH_EDIT));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.195 -0400", hash_original_method = "A19C601F9A82D2C4B88A8AB8DFBF0737", hash_generated_method = "9F1A46694EB1820B1A7029D1440EB29D")
    public void reportFullscreenMode(boolean enabled) {
        dispatchMessage(obtainMessageII(DO_REPORT_FULLSCREEN_MODE, enabled ? 1 : 0, 0));
        addTaint(enabled);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.196 -0400", hash_original_method = "14DBCF261CA01A06A7ACE942F825CE65", hash_generated_method = "1AA321B645F8DA138CED567FDCA41D8F")
    public void performPrivateCommand(String action, Bundle data) {
        dispatchMessage(obtainMessageOO(DO_PERFORM_PRIVATE_COMMAND, action, data));
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.196 -0400", hash_original_method = "F5A5E3786D2DDCB2FEFEBA688154C5D7", hash_generated_method = "9A30453E13CCDB2DDF6FCDFF796D08FF")
     void dispatchMessage(Message msg) {
        {
            boolean varAFACA4F92DB746B2983C428CA25E9018_1600577684 = (Looper.myLooper() == mMainLooper);
            {
                executeMessage(msg);
                msg.recycle();
            } 
        } 
        mH.sendMessage(msg);
        addTaint(msg.getTaint());
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.198 -0400", hash_original_method = "78BA9F6D5AE481CC7127DB3741BBDA1E", hash_generated_method = "E517AB4695960F5DB9EA41B097409BE5")
     void executeMessage(Message msg) {
        
        {
            SomeArgs args = (SomeArgs)msg.obj;
            try 
            {
                InputConnection ic = mInputConnection.get();
                {
                    boolean varD6C5F2B148FB14412C339FCDB147699A_1113653395 = (ic == null || !isActive());
                    {
                        args.callback.setTextAfterCursor(null, args.seq);
                    } 
                } 
                args.callback.setTextAfterCursor(ic.getTextAfterCursor(
                            msg.arg1, msg.arg2), args.seq);
            } 
            catch (RemoteException e)
            { }
        } 
        
        
        {
            SomeArgs args = (SomeArgs)msg.obj;
            try 
            {
                InputConnection ic = mInputConnection.get();
                {
                    boolean varD6C5F2B148FB14412C339FCDB147699A_1012915403 = (ic == null || !isActive());
                    {
                        args.callback.setTextBeforeCursor(null, args.seq);
                    } 
                } 
                args.callback.setTextBeforeCursor(ic.getTextBeforeCursor(
                            msg.arg1, msg.arg2), args.seq);
            } 
            catch (RemoteException e)
            { }
        } 
        
        
        {
            SomeArgs args = (SomeArgs)msg.obj;
            try 
            {
                InputConnection ic = mInputConnection.get();
                {
                    boolean varD6C5F2B148FB14412C339FCDB147699A_91077268 = (ic == null || !isActive());
                    {
                        args.callback.setSelectedText(null, args.seq);
                    } 
                } 
                args.callback.setSelectedText(ic.getSelectedText(
                            msg.arg1), args.seq);
            } 
            catch (RemoteException e)
            { }
        } 
        
        
        {
            SomeArgs args = (SomeArgs)msg.obj;
            try 
            {
                InputConnection ic = mInputConnection.get();
                {
                    boolean varD6C5F2B148FB14412C339FCDB147699A_1779736828 = (ic == null || !isActive());
                    {
                        args.callback.setCursorCapsMode(0, args.seq);
                    } 
                } 
                args.callback.setCursorCapsMode(ic.getCursorCapsMode(msg.arg1),
                            args.seq);
            } 
            catch (RemoteException e)
            { }
        } 
        
        
        {
            SomeArgs args = (SomeArgs)msg.obj;
            try 
            {
                InputConnection ic = mInputConnection.get();
                {
                    boolean varD6C5F2B148FB14412C339FCDB147699A_273401975 = (ic == null || !isActive());
                    {
                        args.callback.setExtractedText(null, args.seq);
                    } 
                } 
                args.callback.setExtractedText(ic.getExtractedText(
                            (ExtractedTextRequest)args.arg1, msg.arg1), args.seq);
            } 
            catch (RemoteException e)
            { }
        } 
        
        
        {
            InputConnection ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_217396702 = (ic == null || !isActive());
            } 
            ic.commitText((CharSequence)msg.obj, msg.arg1);
        } 
        
        
        {
            InputConnection ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1716560764 = (ic == null || !isActive());
            } 
            ic.setSelection(msg.arg1, msg.arg2);
        } 
        
        
        {
            InputConnection ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_844709573 = (ic == null || !isActive());
            } 
            ic.performEditorAction(msg.arg1);
        } 
        
        
        {
            InputConnection ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1406589346 = (ic == null || !isActive());
            } 
            ic.performContextMenuAction(msg.arg1);
        } 
        
        
        {
            InputConnection ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_347310807 = (ic == null || !isActive());
            } 
            ic.commitCompletion((CompletionInfo)msg.obj);
        } 
        
        
        {
            InputConnection ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1987472186 = (ic == null || !isActive());
            } 
            ic.commitCorrection((CorrectionInfo)msg.obj);
        } 
        
        
        {
            InputConnection ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_867837820 = (ic == null || !isActive());
            } 
            ic.setComposingText((CharSequence)msg.obj, msg.arg1);
        } 
        
        
        {
            InputConnection ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1623126861 = (ic == null || !isActive());
            } 
            ic.setComposingRegion(msg.arg1, msg.arg2);
        } 
        
        
        {
            InputConnection ic = mInputConnection.get();
            ic.finishComposingText();
        } 
        
        
        {
            InputConnection ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1184740507 = (ic == null || !isActive());
            } 
            ic.sendKeyEvent((KeyEvent)msg.obj);
        } 
        
        
        {
            InputConnection ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_2093334894 = (ic == null || !isActive());
            } 
            ic.clearMetaKeyStates(msg.arg1);
        } 
        
        
        {
            InputConnection ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_394694281 = (ic == null || !isActive());
            } 
            ic.deleteSurroundingText(msg.arg1, msg.arg2);
        } 
        
        
        {
            InputConnection ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_2070567074 = (ic == null || !isActive());
            } 
            ic.beginBatchEdit();
        } 
        
        
        {
            InputConnection ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1421713192 = (ic == null || !isActive());
            } 
            ic.endBatchEdit();
        } 
        
        
        {
            InputConnection ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1316725292 = (ic == null || !isActive());
            } 
            ic.reportFullscreenMode(msg.arg1 == 1);
        } 
        
        
        {
            InputConnection ic = mInputConnection.get();
            {
                boolean varCC8C26D5E49C9558783A3A31D1BB0ED2_1491078953 = (ic == null || !isActive());
            } 
            SomeArgs args = (SomeArgs)msg.obj;
            ic.performPrivateCommand((String)args.arg1,
                        (Bundle)args.arg2);
        } 
        
        addTaint(msg.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.199 -0400", hash_original_method = "92301CED384526FAE2562FC8E2BD0E1D", hash_generated_method = "D137A08F99C3BC252BD6025959E109ED")
     Message obtainMessage(int what) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1926554190 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1926554190 = mH.obtainMessage(what);
        addTaint(what);
        varB4EAC82CA7396A68D541C85D26508E83_1926554190.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1926554190;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.199 -0400", hash_original_method = "1D375F3B5B7A421102D544B0D8C99910", hash_generated_method = "A46EC5062E13FC4B353D197EEFAD41A0")
     Message obtainMessageII(int what, int arg1, int arg2) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1845182446 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1845182446 = mH.obtainMessage(what, arg1, arg2);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        varB4EAC82CA7396A68D541C85D26508E83_1845182446.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1845182446;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.199 -0400", hash_original_method = "E41B1E1C050A3613D52D3D6F2431F5B0", hash_generated_method = "15431C972ECC9CDA4032293D986D507D")
     Message obtainMessageO(int what, Object arg1) {
        Message varB4EAC82CA7396A68D541C85D26508E83_40102749 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_40102749 = mH.obtainMessage(what, 0, 0, arg1);
        addTaint(what);
        addTaint(arg1.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_40102749.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_40102749;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.200 -0400", hash_original_method = "C41806B53C46498944BCE998FEC907A1", hash_generated_method = "FA545DE68C8FCD47C75315126DC58F16")
     Message obtainMessageISC(int what, int arg1, int seq, IInputContextCallback callback) {
        Message varB4EAC82CA7396A68D541C85D26508E83_698513656 = null; 
        SomeArgs args = new SomeArgs();
        args.callback = callback;
        args.seq = seq;
        varB4EAC82CA7396A68D541C85D26508E83_698513656 = mH.obtainMessage(what, arg1, 0, args);
        addTaint(what);
        addTaint(arg1);
        addTaint(seq);
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_698513656.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_698513656;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.201 -0400", hash_original_method = "81C8385506FF3623370F9C4C1A9DC229", hash_generated_method = "9D79D611FDB0DF682A234CD8814CA798")
     Message obtainMessageIISC(int what, int arg1, int arg2, int seq, IInputContextCallback callback) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1037335076 = null; 
        SomeArgs args = new SomeArgs();
        args.callback = callback;
        args.seq = seq;
        varB4EAC82CA7396A68D541C85D26508E83_1037335076 = mH.obtainMessage(what, arg1, arg2, args);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        addTaint(seq);
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1037335076.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1037335076;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.201 -0400", hash_original_method = "F0BFCDA04898886ED0BDB255B10E7641", hash_generated_method = "198B0C7BA6301C2C88DB19758A9C649E")
     Message obtainMessageIOSC(int what, int arg1, Object arg2, int seq,
            IInputContextCallback callback) {
        Message varB4EAC82CA7396A68D541C85D26508E83_938383322 = null; 
        SomeArgs args = new SomeArgs();
        args.arg1 = arg2;
        args.callback = callback;
        args.seq = seq;
        varB4EAC82CA7396A68D541C85D26508E83_938383322 = mH.obtainMessage(what, arg1, 0, args);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2.getTaint());
        addTaint(seq);
        addTaint(callback.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_938383322.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_938383322;
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.202 -0400", hash_original_method = "BDB545C9895C4A044C116EE5375794DB", hash_generated_method = "ACB5F8466819DEF377140D20082CCFC1")
     Message obtainMessageIO(int what, int arg1, Object arg2) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1910644096 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1910644096 = mH.obtainMessage(what, arg1, 0, arg2);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1910644096.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1910644096;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.202 -0400", hash_original_method = "0CCDC84288D426642A6380F76E883191", hash_generated_method = "8DC40302B3C4438042DDDA3C639004C7")
     Message obtainMessageOO(int what, Object arg1, Object arg2) {
        Message varB4EAC82CA7396A68D541C85D26508E83_220126183 = null; 
        SomeArgs args = new SomeArgs();
        args.arg1 = arg1;
        args.arg2 = arg2;
        varB4EAC82CA7396A68D541C85D26508E83_220126183 = mH.obtainMessage(what, 0, 0, args);
        addTaint(what);
        addTaint(arg1.getTaint());
        addTaint(arg2.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_220126183.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_220126183;
        
        
        
        
        
    }

    
    static class SomeArgs {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.202 -0400", hash_original_field = "E866231598ED4CB18BE5E493240A11B0", hash_generated_field = "524E284308787C3B27AB4CD560A816CF")

        Object arg1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.202 -0400", hash_original_field = "80A26383E00E892C98EBD598EDCC5DBB", hash_generated_field = "2CC0C93F38D97721E695C73C9F8BA144")

        Object arg2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.202 -0400", hash_original_field = "924A8CEEAC17F54D3BE3F8CDF1C04EB2", hash_generated_field = "844B2A0BBAFC5CBF10E337E600D741B3")

        IInputContextCallback callback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.202 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "C4ECE7ED8A0F11C4F90796D05BE13ED7")

        int seq;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.202 -0400", hash_original_method = "C08D0E88500332C6E0DD16EFE525CF46", hash_generated_method = "C08D0E88500332C6E0DD16EFE525CF46")
        public SomeArgs ()
        {
            
        }


    }


    
    class MyHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.203 -0400", hash_original_method = "761ACCB2E72A1319CE4B08F794806580", hash_generated_method = "A640814F3C00E3175ECDA66EED93DC88")
          MyHandler(Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.203 -0400", hash_original_method = "1DE21F974CC2F2B42894E9D98B8A257E", hash_generated_method = "C43F62157A101926E70BDCE0229F24F6")
        @Override
        public void handleMessage(Message msg) {
            executeMessage(msg);
            addTaint(msg.getTaint());
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.203 -0400", hash_original_field = "2C912F65B7F370D57F762FE5D19D4BE2", hash_generated_field = "900165FF60D4D63B5E39F15ED871ED73")

    static final String TAG = "IInputConnectionWrapper";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.203 -0400", hash_original_field = "4ED50403A7474ACA03D96962CA629474", hash_generated_field = "93215ED66A3AA28F5E079D863981D641")

    private static final int DO_GET_TEXT_AFTER_CURSOR = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.203 -0400", hash_original_field = "725D1046CB42EC948EEFC59324072C38", hash_generated_field = "77B723127445ED341C49AD030D289BC5")

    private static final int DO_GET_TEXT_BEFORE_CURSOR = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.203 -0400", hash_original_field = "C6CB8D044B7A676A21868DBC3B6992E7", hash_generated_field = "51EE3D33C8B20ECFDDE07BBCBB4E376E")

    private static final int DO_GET_SELECTED_TEXT = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.203 -0400", hash_original_field = "04C50D07812F125F84E41E3BE0DA838C", hash_generated_field = "BCA32ABEAAFC403F2BCED79722EED453")

    private static final int DO_GET_CURSOR_CAPS_MODE = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.203 -0400", hash_original_field = "9F85CECCAFE485433FF9E0DBDFF4DC0D", hash_generated_field = "48A7DB7FC24E94ED646B2156F252FA2C")

    private static final int DO_GET_EXTRACTED_TEXT = 40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.203 -0400", hash_original_field = "EC63C304A4880D2F78DBD98961CA7309", hash_generated_field = "12DAACDA0ED408109635B38CF1A26B58")

    private static final int DO_COMMIT_TEXT = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.203 -0400", hash_original_field = "D86E4E403145879C39C9B7A4B38C9072", hash_generated_field = "2FFC27A574296430573F8BFC6EAE1CE7")

    private static final int DO_COMMIT_COMPLETION = 55;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.203 -0400", hash_original_field = "FAE7CE09AE518D35FC722221C91CEF12", hash_generated_field = "13680546C8DA0B085E98BFE55C118B2C")

    private static final int DO_COMMIT_CORRECTION = 56;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.203 -0400", hash_original_field = "2EFDEFD94FC3FF82AA852E1A7ED2F4A0", hash_generated_field = "AD41B2C006D6D67CC8775CEC10520A90")

    private static final int DO_SET_SELECTION = 57;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.203 -0400", hash_original_field = "B9460B3CF5E7B4EDA7ABAA225E3A7D4C", hash_generated_field = "238C94F032A5384919F7EE90E5313139")

    private static final int DO_PERFORM_EDITOR_ACTION = 58;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.203 -0400", hash_original_field = "15DFE5D03CFE1F65BF076AD8D56917E0", hash_generated_field = "650AF0A11A874B7C58DD493632230488")

    private static final int DO_PERFORM_CONTEXT_MENU_ACTION = 59;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.203 -0400", hash_original_field = "D2FE5D65C0E0AC6F0CAC900A4291C782", hash_generated_field = "51F7A494F2D018C46814C47040A1B844")

    private static final int DO_SET_COMPOSING_TEXT = 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.204 -0400", hash_original_field = "6FAE186F48B537D9F9FF59276A391D10", hash_generated_field = "FA70AA4BBA7C0F3633F481FFABC342F9")

    private static final int DO_SET_COMPOSING_REGION = 63;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.204 -0400", hash_original_field = "9DF3EFB61898E55F35C2D13EF6043B89", hash_generated_field = "17932C5334A9342E69C604B50A69E95A")

    private static final int DO_FINISH_COMPOSING_TEXT = 65;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.204 -0400", hash_original_field = "F9906D40C7F6BD5C7A7D51FC303B9805", hash_generated_field = "F567601080EFA0B5B22EEBABDFA2EB65")

    private static final int DO_SEND_KEY_EVENT = 70;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.204 -0400", hash_original_field = "BEE559E8A44BD9830EB266D1E715794B", hash_generated_field = "E142F65AD117AFEBB852664B04740F3D")

    private static final int DO_DELETE_SURROUNDING_TEXT = 80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.204 -0400", hash_original_field = "96FC183EC850D36D03AB6F7138058D94", hash_generated_field = "99C6EF96E09AF79D299B8C365DD014F6")

    private static final int DO_BEGIN_BATCH_EDIT = 90;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.204 -0400", hash_original_field = "332C5FFBA2E78220DCAA7F5F59C064D0", hash_generated_field = "6A5BFE0A81A35CF1D51D4C6C709F0D2E")

    private static final int DO_END_BATCH_EDIT = 95;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.204 -0400", hash_original_field = "137931DC8B66215806FD27D12075A205", hash_generated_field = "BF40CA519D14B3452BD21538E6037466")

    private static final int DO_REPORT_FULLSCREEN_MODE = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.204 -0400", hash_original_field = "687DA25EF98F2378B6DFC9AE9155E95E", hash_generated_field = "3AAFBD5EAFB589BEB2464F4FDC3B6CAB")

    private static final int DO_PERFORM_PRIVATE_COMMAND = 120;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.204 -0400", hash_original_field = "51385D060DEB14F8392634E6908C9EA5", hash_generated_field = "69946D6E4D680F21730784713CDC701E")

    private static final int DO_CLEAR_META_KEY_STATES = 130;
}


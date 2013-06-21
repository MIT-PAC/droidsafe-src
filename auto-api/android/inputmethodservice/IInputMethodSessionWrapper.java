package android.inputmethodservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.os.HandlerCaller;
import com.android.internal.view.IInputMethodCallback;
import com.android.internal.view.IInputMethodSession;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.InputMethodSession;

class IInputMethodSessionWrapper extends IInputMethodSession.Stub implements HandlerCaller.Callback {
    HandlerCaller mCaller;
    InputMethodSession mInputMethodSession;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.239 -0400", hash_original_method = "A974B8A9867F7B3B60633A09BB9A6329", hash_generated_method = "AE1682ED0D45E86C10816E832F203B44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IInputMethodSessionWrapper(Context context,
            InputMethodSession inputMethodSession) {
        dsTaint.addTaint(inputMethodSession.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        mCaller = new HandlerCaller(context, this);
        // ---------- Original Method ----------
        //mCaller = new HandlerCaller(context, this);
        //mInputMethodSession = inputMethodSession;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.240 -0400", hash_original_method = "FE0809D61F310D1DE2584DA263F14DCD", hash_generated_method = "DB2912245C5E0703FEEF5E59D5A5E570")
    @DSModeled(DSC.SAFE)
    public InputMethodSession getInternalInputMethodSession() {
        return (InputMethodSession)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInputMethodSession;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.241 -0400", hash_original_method = "00877500C4B72645AB17DC7FDAE0E34A", hash_generated_method = "072BE4FBDAD99563D8EABA394CA82688")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void executeMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        //Begin case DO_FINISH_INPUT 
        mInputMethodSession.finishInput();
        //End case DO_FINISH_INPUT 
        //Begin case DO_DISPLAY_COMPLETIONS 
        mInputMethodSession.displayCompletions((CompletionInfo[])msg.obj);
        //End case DO_DISPLAY_COMPLETIONS 
        //Begin case DO_UPDATE_EXTRACTED_TEXT 
        mInputMethodSession.updateExtractedText(msg.arg1,
                        (ExtractedText)msg.obj);
        //End case DO_UPDATE_EXTRACTED_TEXT 
        //Begin case DO_DISPATCH_KEY_EVENT 
        {
            HandlerCaller.SomeArgs args;
            args = (HandlerCaller.SomeArgs)msg.obj;
            mInputMethodSession.dispatchKeyEvent(msg.arg1,
                        (KeyEvent)args.arg1,
                        new InputMethodEventCallbackWrapper(
                                (IInputMethodCallback)args.arg2));
            mCaller.recycleArgs(args);
        } //End block
        //End case DO_DISPATCH_KEY_EVENT 
        //Begin case DO_DISPATCH_TRACKBALL_EVENT 
        {
            HandlerCaller.SomeArgs args;
            args = (HandlerCaller.SomeArgs)msg.obj;
            mInputMethodSession.dispatchTrackballEvent(msg.arg1,
                        (MotionEvent)args.arg1,
                        new InputMethodEventCallbackWrapper(
                                (IInputMethodCallback)args.arg2));
            mCaller.recycleArgs(args);
        } //End block
        //End case DO_DISPATCH_TRACKBALL_EVENT 
        //Begin case DO_UPDATE_SELECTION 
        {
            HandlerCaller.SomeArgs args;
            args = (HandlerCaller.SomeArgs)msg.obj;
            mInputMethodSession.updateSelection(args.argi1, args.argi2,
                        args.argi3, args.argi4, args.argi5, args.argi6);
            mCaller.recycleArgs(args);
        } //End block
        //End case DO_UPDATE_SELECTION 
        //Begin case DO_UPDATE_CURSOR 
        {
            mInputMethodSession.updateCursor((Rect)msg.obj);
        } //End block
        //End case DO_UPDATE_CURSOR 
        //Begin case DO_APP_PRIVATE_COMMAND 
        {
            HandlerCaller.SomeArgs args;
            args = (HandlerCaller.SomeArgs)msg.obj;
            mInputMethodSession.appPrivateCommand((String)args.arg1,
                        (Bundle)args.arg2);
            mCaller.recycleArgs(args);
        } //End block
        //End case DO_APP_PRIVATE_COMMAND 
        //Begin case DO_TOGGLE_SOFT_INPUT 
        {
            mInputMethodSession.toggleSoftInput(msg.arg1, msg.arg2);
        } //End block
        //End case DO_TOGGLE_SOFT_INPUT 
        //Begin case DO_FINISH_SESSION 
        {
            mInputMethodSession = null;
        } //End block
        //End case DO_FINISH_SESSION 
        //Begin case DO_VIEW_CLICKED 
        {
            mInputMethodSession.viewClicked(msg.arg1 == 1);
        } //End block
        //End case DO_VIEW_CLICKED 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.241 -0400", hash_original_method = "79448A7650CDA21C9A89B7B8FD63C46C", hash_generated_method = "7E0A06F0572B1B49A610780F58FEC54C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void finishInput() {
        mCaller.executeOrSendMessage(mCaller.obtainMessage(DO_FINISH_INPUT));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessage(DO_FINISH_INPUT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.241 -0400", hash_original_method = "4AB85D57EDDB5A36CCFD4077A8D3DB50", hash_generated_method = "4212E97CE3F99A0909428C69073B268D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void displayCompletions(CompletionInfo[] completions) {
        dsTaint.addTaint(completions[0].dsTaint);
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(
                DO_DISPLAY_COMPLETIONS, completions));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageO(
                //DO_DISPLAY_COMPLETIONS, completions));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.242 -0400", hash_original_method = "0BD6C1A889B6632AAA453DB7F3263BBD", hash_generated_method = "2090E11E1AAE8C0095D75C4425923DC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateExtractedText(int token, ExtractedText text) {
        dsTaint.addTaint(text.dsTaint);
        dsTaint.addTaint(token);
        mCaller.executeOrSendMessage(mCaller.obtainMessageIO(
                DO_UPDATE_EXTRACTED_TEXT, token, text));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageIO(
                //DO_UPDATE_EXTRACTED_TEXT, token, text));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.242 -0400", hash_original_method = "EAAE160B6C5BB7ADDBB833B764EC1908", hash_generated_method = "1AC4D78BBBE835734E7377BD98D4CE43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchKeyEvent(int seq, KeyEvent event, IInputMethodCallback callback) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(seq);
        mCaller.executeOrSendMessage(mCaller.obtainMessageIOO(DO_DISPATCH_KEY_EVENT, seq,
                event, callback));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageIOO(DO_DISPATCH_KEY_EVENT, seq,
                //event, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.242 -0400", hash_original_method = "B66D209112CB2D18AB081107433F0849", hash_generated_method = "60099263CB92A609CCDC33F539E9F14A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchTrackballEvent(int seq, MotionEvent event, IInputMethodCallback callback) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(seq);
        mCaller.executeOrSendMessage(mCaller.obtainMessageIOO(DO_DISPATCH_TRACKBALL_EVENT, seq,
                event, callback));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageIOO(DO_DISPATCH_TRACKBALL_EVENT, seq,
                //event, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.243 -0400", hash_original_method = "8CEFA969398A4D94CA9A297166BCD287", hash_generated_method = "916FA4306B2B2A5B0553404FABF67C72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateSelection(int oldSelStart, int oldSelEnd,
            int newSelStart, int newSelEnd, int candidatesStart, int candidatesEnd) {
        dsTaint.addTaint(candidatesStart);
        dsTaint.addTaint(oldSelStart);
        dsTaint.addTaint(candidatesEnd);
        dsTaint.addTaint(newSelStart);
        dsTaint.addTaint(oldSelEnd);
        dsTaint.addTaint(newSelEnd);
        mCaller.executeOrSendMessage(mCaller.obtainMessageIIIIII(DO_UPDATE_SELECTION,
                oldSelStart, oldSelEnd, newSelStart, newSelEnd,
                candidatesStart, candidatesEnd));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageIIIIII(DO_UPDATE_SELECTION,
                //oldSelStart, oldSelEnd, newSelStart, newSelEnd,
                //candidatesStart, candidatesEnd));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.243 -0400", hash_original_method = "573066B3B680169C0F49551C28C5AAB3", hash_generated_method = "270A3B8C28767E16F88740DAD4D10936")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void viewClicked(boolean focusChanged) {
        dsTaint.addTaint(focusChanged);
        mCaller.executeOrSendMessage(mCaller.obtainMessageI(DO_VIEW_CLICKED, focusChanged ? 1 : 0));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageI(DO_VIEW_CLICKED, focusChanged ? 1 : 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.243 -0400", hash_original_method = "AA4329CCB1121E7E7A4883B7E8B28B3A", hash_generated_method = "32565D4E423108763CFB25A15FD262E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateCursor(Rect newCursor) {
        dsTaint.addTaint(newCursor.dsTaint);
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_UPDATE_CURSOR,
                newCursor));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_UPDATE_CURSOR,
                //newCursor));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.243 -0400", hash_original_method = "198A18639F375147EA5FEBDF12A15204", hash_generated_method = "2458D50A2096242FC242CD272440F2A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void appPrivateCommand(String action, Bundle data) {
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(action);
        mCaller.executeOrSendMessage(mCaller.obtainMessageOO(DO_APP_PRIVATE_COMMAND, action, data));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageOO(DO_APP_PRIVATE_COMMAND, action, data));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.244 -0400", hash_original_method = "E1D5DFD3D112FBD55D45C010A5FB9D8C", hash_generated_method = "76D15B1D332455DA4847DCC23F2BA605")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void toggleSoftInput(int showFlags, int hideFlags) {
        dsTaint.addTaint(showFlags);
        dsTaint.addTaint(hideFlags);
        mCaller.executeOrSendMessage(mCaller.obtainMessageII(DO_TOGGLE_SOFT_INPUT, showFlags, hideFlags));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageII(DO_TOGGLE_SOFT_INPUT, showFlags, hideFlags));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.244 -0400", hash_original_method = "DD8E8E4C57A8296FF535720B90D4809B", hash_generated_method = "DA2B56A0945E112EFB6C9022E5AD067E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void finishSession() {
        mCaller.executeOrSendMessage(mCaller.obtainMessage(DO_FINISH_SESSION));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessage(DO_FINISH_SESSION));
    }

    
    static class InputMethodEventCallbackWrapper implements InputMethodSession.EventCallback {
        IInputMethodCallback mCb;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.245 -0400", hash_original_method = "F69C5DA54CCE399124E2B79C8542153D", hash_generated_method = "02E6409320C6823327E7AC8BF7EEE1D7")
        @DSModeled(DSC.SAFE)
         InputMethodEventCallbackWrapper(IInputMethodCallback cb) {
            dsTaint.addTaint(cb.dsTaint);
            // ---------- Original Method ----------
            //mCb = cb;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.246 -0400", hash_original_method = "7EDF22DE040F47B5D42C1B7CDA3CFBC9", hash_generated_method = "250B624D00F5BF4D6CA5E98087C1E9A0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void finishedEvent(int seq, boolean handled) {
            dsTaint.addTaint(seq);
            dsTaint.addTaint(handled);
            try 
            {
                mCb.finishedEvent(seq, handled);
            } //End block
            catch (RemoteException e)
            { }
            // ---------- Original Method ----------
            //try {
                //mCb.finishedEvent(seq, handled);
            //} catch (RemoteException e) {
            //}
        }

        
    }


    
    private static final String TAG = "InputMethodWrapper";
    private static final boolean DEBUG = false;
    private static final int DO_FINISH_INPUT = 60;
    private static final int DO_DISPLAY_COMPLETIONS = 65;
    private static final int DO_UPDATE_EXTRACTED_TEXT = 67;
    private static final int DO_DISPATCH_KEY_EVENT = 70;
    private static final int DO_DISPATCH_TRACKBALL_EVENT = 80;
    private static final int DO_UPDATE_SELECTION = 90;
    private static final int DO_UPDATE_CURSOR = 95;
    private static final int DO_APP_PRIVATE_COMMAND = 100;
    private static final int DO_TOGGLE_SOFT_INPUT = 105;
    private static final int DO_FINISH_SESSION = 110;
    private static final int DO_VIEW_CLICKED = 115;
}


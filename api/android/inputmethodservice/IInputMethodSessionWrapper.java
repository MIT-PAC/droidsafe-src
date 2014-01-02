package android.inputmethodservice;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.InputMethodSession;

import com.android.internal.os.HandlerCaller;
import com.android.internal.view.IInputMethodCallback;
import com.android.internal.view.IInputMethodSession;






class IInputMethodSessionWrapper extends IInputMethodSession.Stub implements HandlerCaller.Callback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.631 -0500", hash_original_field = "C78C0AF3A280B526CE72F80B5C668B56", hash_generated_field = "7B184F0C0152E5E9C735D79B852D0D03")

    private static final String TAG = "InputMethodWrapper";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.633 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.635 -0500", hash_original_field = "A3EE91493CF0A1795D9124D0DE7FED72", hash_generated_field = "479290E9A9EB32F21922EEA1BB1D645D")

    
    private static final int DO_FINISH_INPUT = 60;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.638 -0500", hash_original_field = "703F85948EEDB9AB53DC57C7EDF14055", hash_generated_field = "D500E3210C36C0D2274EC07536C54253")

    private static final int DO_DISPLAY_COMPLETIONS = 65;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.640 -0500", hash_original_field = "530E9AB3E1AAEE5C66C8715AE84D4B05", hash_generated_field = "A8F7FB104B36FE0FD3E9A1FDA64DADE6")

    private static final int DO_UPDATE_EXTRACTED_TEXT = 67;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.644 -0500", hash_original_field = "F2A617E038136E7B888C3215A877CC5E", hash_generated_field = "AA3314C99D049E97F3033B2FCFF92A0C")

    private static final int DO_DISPATCH_KEY_EVENT = 70;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.646 -0500", hash_original_field = "43467AE6D01D5FC835FFCF4EBF9B50C3", hash_generated_field = "DAFB537AB08618FBB7A82E745ABA4311")

    private static final int DO_DISPATCH_TRACKBALL_EVENT = 80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.648 -0500", hash_original_field = "78C39047202CB223E4836F86FAFB3B3B", hash_generated_field = "7C7C019D06123B94B4998030DCCD4997")

    private static final int DO_UPDATE_SELECTION = 90;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.651 -0500", hash_original_field = "8D8F1E97405BF9EE13EC3BFA49F86FCA", hash_generated_field = "97C62CFDB79B8F81EC3F927E6A6450D0")

    private static final int DO_UPDATE_CURSOR = 95;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.653 -0500", hash_original_field = "B021840CDB15580D1D41F738B3ED2BA3", hash_generated_field = "A9456973FE4A98E9811AE333EC70243A")

    private static final int DO_APP_PRIVATE_COMMAND = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.656 -0500", hash_original_field = "59B887A3385F56908BFCAC155E11FAAE", hash_generated_field = "61091CEE28068FC05C43233A73CDA169")

    private static final int DO_TOGGLE_SOFT_INPUT = 105;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.658 -0500", hash_original_field = "B79743CCF3283E63B25A12D57A27D1B4", hash_generated_field = "827A7101F077497C9F7FCA73651A3AA4")

    private static final int DO_FINISH_SESSION = 110;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.661 -0500", hash_original_field = "00DEF6BB55015467EE70EDB60A0534F0", hash_generated_field = "4D2EA6369B14D4A66FD519A1C8B17EFB")

    private static final int DO_VIEW_CLICKED = 115;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.663 -0500", hash_original_field = "B57F12AA48E3204FC249B7683181CCD8", hash_generated_field = "B57F12AA48E3204FC249B7683181CCD8")


    HandlerCaller mCaller;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.665 -0500", hash_original_field = "0D0863CC1C8DF0F3C80E84309E51575E", hash_generated_field = "0D0863CC1C8DF0F3C80E84309E51575E")

    InputMethodSession mInputMethodSession;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.677 -0500", hash_original_method = "A974B8A9867F7B3B60633A09BB9A6329", hash_generated_method = "A2206AD77B6F2C31FE344B63251AA875")
    
public IInputMethodSessionWrapper(Context context,
            InputMethodSession inputMethodSession) {
        mCaller = new HandlerCaller(context, this);
        mInputMethodSession = inputMethodSession;
    }

    
    static class InputMethodEventCallbackWrapper implements InputMethodSession.EventCallback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.667 -0500", hash_original_field = "4903C6C7AA2E39F51C3230E9003EAA25", hash_generated_field = "4903C6C7AA2E39F51C3230E9003EAA25")

         IInputMethodCallback mCb;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.670 -0500", hash_original_method = "F69C5DA54CCE399124E2B79C8542153D", hash_generated_method = "F69C5DA54CCE399124E2B79C8542153D")
        
InputMethodEventCallbackWrapper(IInputMethodCallback cb) {
            mCb = cb;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.672 -0500", hash_original_method = "7EDF22DE040F47B5D42C1B7CDA3CFBC9", hash_generated_method = "26F23A1E433D7F7DE2BDFD79888E213D")
        
public void finishedEvent(int seq, boolean handled) {
            try {
                mCb.finishedEvent(seq, handled);
            } catch (RemoteException e) {
            }
        }

        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.679 -0500", hash_original_method = "FE0809D61F310D1DE2584DA263F14DCD", hash_generated_method = "1847811CEE0A517628367422540146E9")
    
public InputMethodSession getInternalInputMethodSession() {
        return mInputMethodSession;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.682 -0500", hash_original_method = "00877500C4B72645AB17DC7FDAE0E34A", hash_generated_method = "2B33E7BDA8B47E8634A5D80AC7FEDF2A")
    
public void executeMessage(Message msg) {
        if (mInputMethodSession == null) return;

        switch (msg.what) {
            case DO_FINISH_INPUT:
                mInputMethodSession.finishInput();
                return;
            case DO_DISPLAY_COMPLETIONS:
                mInputMethodSession.displayCompletions((CompletionInfo[])msg.obj);
                return;
            case DO_UPDATE_EXTRACTED_TEXT:
                mInputMethodSession.updateExtractedText(msg.arg1,
                        (ExtractedText)msg.obj);
                return;
            case DO_DISPATCH_KEY_EVENT: {
                HandlerCaller.SomeArgs args = (HandlerCaller.SomeArgs)msg.obj;
                mInputMethodSession.dispatchKeyEvent(msg.arg1,
                        (KeyEvent)args.arg1,
                        new InputMethodEventCallbackWrapper(
                                (IInputMethodCallback)args.arg2));
                mCaller.recycleArgs(args);
                return;
            }
            case DO_DISPATCH_TRACKBALL_EVENT: {
                HandlerCaller.SomeArgs args = (HandlerCaller.SomeArgs)msg.obj;
                mInputMethodSession.dispatchTrackballEvent(msg.arg1,
                        (MotionEvent)args.arg1,
                        new InputMethodEventCallbackWrapper(
                                (IInputMethodCallback)args.arg2));
                mCaller.recycleArgs(args);
                return;
            }
            case DO_UPDATE_SELECTION: {
                HandlerCaller.SomeArgs args = (HandlerCaller.SomeArgs)msg.obj;
                mInputMethodSession.updateSelection(args.argi1, args.argi2,
                        args.argi3, args.argi4, args.argi5, args.argi6);
                mCaller.recycleArgs(args);
                return;
            }
            case DO_UPDATE_CURSOR: {
                mInputMethodSession.updateCursor((Rect)msg.obj);
                return;
            }
            case DO_APP_PRIVATE_COMMAND: {
                HandlerCaller.SomeArgs args = (HandlerCaller.SomeArgs)msg.obj;
                mInputMethodSession.appPrivateCommand((String)args.arg1,
                        (Bundle)args.arg2);
                mCaller.recycleArgs(args);
                return;
            }
            case DO_TOGGLE_SOFT_INPUT: {
                mInputMethodSession.toggleSoftInput(msg.arg1, msg.arg2);
                return;
            }
            case DO_FINISH_SESSION: {
                mInputMethodSession = null;
                return;
            }
            case DO_VIEW_CLICKED: {
                mInputMethodSession.viewClicked(msg.arg1 == 1);
                return;
            }
        }
        Log.w(TAG, "Unhandled message code: " + msg.what);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.685 -0500", hash_original_method = "79448A7650CDA21C9A89B7B8FD63C46C", hash_generated_method = "3DCE23F4CF5627AA1A148AEF4A7423C4")
    
public void finishInput() {
        mCaller.executeOrSendMessage(mCaller.obtainMessage(DO_FINISH_INPUT));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.687 -0500", hash_original_method = "4AB85D57EDDB5A36CCFD4077A8D3DB50", hash_generated_method = "8CDF9C941702043816D16A28DD425FB6")
    
public void displayCompletions(CompletionInfo[] completions) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(
                DO_DISPLAY_COMPLETIONS, completions));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.689 -0500", hash_original_method = "0BD6C1A889B6632AAA453DB7F3263BBD", hash_generated_method = "7BC9EFA76B25C9A9DE1C4C6F0FCB2D35")
    
public void updateExtractedText(int token, ExtractedText text) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageIO(
                DO_UPDATE_EXTRACTED_TEXT, token, text));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.691 -0500", hash_original_method = "EAAE160B6C5BB7ADDBB833B764EC1908", hash_generated_method = "D666539018FF73C2CE73AE52977F6F77")
    
public void dispatchKeyEvent(int seq, KeyEvent event, IInputMethodCallback callback) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageIOO(DO_DISPATCH_KEY_EVENT, seq,
                event, callback));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.694 -0500", hash_original_method = "B66D209112CB2D18AB081107433F0849", hash_generated_method = "FFC13DA52AED1D5EFA3CEC711CB50DD1")
    
public void dispatchTrackballEvent(int seq, MotionEvent event, IInputMethodCallback callback) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageIOO(DO_DISPATCH_TRACKBALL_EVENT, seq,
                event, callback));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.696 -0500", hash_original_method = "8CEFA969398A4D94CA9A297166BCD287", hash_generated_method = "E2D57059BA293597A53A99616033776B")
    
public void updateSelection(int oldSelStart, int oldSelEnd,
            int newSelStart, int newSelEnd, int candidatesStart, int candidatesEnd) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageIIIIII(DO_UPDATE_SELECTION,
                oldSelStart, oldSelEnd, newSelStart, newSelEnd,
                candidatesStart, candidatesEnd));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.698 -0500", hash_original_method = "573066B3B680169C0F49551C28C5AAB3", hash_generated_method = "132CA8E32D85A91C3B48A79C5EADCA70")
    
public void viewClicked(boolean focusChanged) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageI(DO_VIEW_CLICKED, focusChanged ? 1 : 0));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.700 -0500", hash_original_method = "AA4329CCB1121E7E7A4883B7E8B28B3A", hash_generated_method = "09D07BF8CD0A683B2F522B5CD228F023")
    
public void updateCursor(Rect newCursor) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_UPDATE_CURSOR,
                newCursor));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.703 -0500", hash_original_method = "198A18639F375147EA5FEBDF12A15204", hash_generated_method = "FEBCF40C3DDAF5A7AC300BBF69DE8D2E")
    
public void appPrivateCommand(String action, Bundle data) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageOO(DO_APP_PRIVATE_COMMAND, action, data));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.705 -0500", hash_original_method = "E1D5DFD3D112FBD55D45C010A5FB9D8C", hash_generated_method = "5128E958E58D4609A205B7F6C599DDA7")
    
public void toggleSoftInput(int showFlags, int hideFlags) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageII(DO_TOGGLE_SOFT_INPUT, showFlags, hideFlags));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:38.707 -0500", hash_original_method = "DD8E8E4C57A8296FF535720B90D4809B", hash_generated_method = "8B9EFF6D910C24D67BA6619FA9B5D685")
    
public void finishSession() {
        mCaller.executeOrSendMessage(mCaller.obtainMessage(DO_FINISH_SESSION));
    }
}


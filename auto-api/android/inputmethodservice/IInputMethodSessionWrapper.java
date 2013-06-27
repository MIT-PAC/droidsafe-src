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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.292 -0400", hash_original_field = "02B8E2B08EEFD631BD36F22665C339F2", hash_generated_field = "B57F12AA48E3204FC249B7683181CCD8")

    HandlerCaller mCaller;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.292 -0400", hash_original_field = "6B002D47A93D56D201E98DFC8A8B2F6A", hash_generated_field = "0D0863CC1C8DF0F3C80E84309E51575E")

    InputMethodSession mInputMethodSession;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.293 -0400", hash_original_method = "A974B8A9867F7B3B60633A09BB9A6329", hash_generated_method = "725B6F7C1C6E489B51F41CE127A0A5F1")
    public  IInputMethodSessionWrapper(Context context,
            InputMethodSession inputMethodSession) {
        mCaller = new HandlerCaller(context, this);
        mInputMethodSession = inputMethodSession;
        // ---------- Original Method ----------
        //mCaller = new HandlerCaller(context, this);
        //mInputMethodSession = inputMethodSession;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.297 -0400", hash_original_method = "FE0809D61F310D1DE2584DA263F14DCD", hash_generated_method = "D5484D727F6BCA0BC173BF3754A19EB8")
    public InputMethodSession getInternalInputMethodSession() {
        InputMethodSession varB4EAC82CA7396A68D541C85D26508E83_87955764 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_87955764 = mInputMethodSession;
        varB4EAC82CA7396A68D541C85D26508E83_87955764.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_87955764;
        // ---------- Original Method ----------
        //return mInputMethodSession;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.320 -0400", hash_original_method = "00877500C4B72645AB17DC7FDAE0E34A", hash_generated_method = "71E2F742902ED0219279FE08B2579061")
    public void executeMessage(Message msg) {
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
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.321 -0400", hash_original_method = "79448A7650CDA21C9A89B7B8FD63C46C", hash_generated_method = "7E0A06F0572B1B49A610780F58FEC54C")
    public void finishInput() {
        mCaller.executeOrSendMessage(mCaller.obtainMessage(DO_FINISH_INPUT));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessage(DO_FINISH_INPUT));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.329 -0400", hash_original_method = "4AB85D57EDDB5A36CCFD4077A8D3DB50", hash_generated_method = "927472507821ECB14BBA8FD52EBB1ADF")
    public void displayCompletions(CompletionInfo[] completions) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(
                DO_DISPLAY_COMPLETIONS, completions));
        addTaint(completions[0].getTaint());
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageO(
                //DO_DISPLAY_COMPLETIONS, completions));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.330 -0400", hash_original_method = "0BD6C1A889B6632AAA453DB7F3263BBD", hash_generated_method = "D1F6DD547ECCB8D0C370A2DBACE183FF")
    public void updateExtractedText(int token, ExtractedText text) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageIO(
                DO_UPDATE_EXTRACTED_TEXT, token, text));
        addTaint(token);
        addTaint(text.getTaint());
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageIO(
                //DO_UPDATE_EXTRACTED_TEXT, token, text));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.331 -0400", hash_original_method = "EAAE160B6C5BB7ADDBB833B764EC1908", hash_generated_method = "E8EA90328D6DEFFB3BF4FCF68393762B")
    public void dispatchKeyEvent(int seq, KeyEvent event, IInputMethodCallback callback) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageIOO(DO_DISPATCH_KEY_EVENT, seq,
                event, callback));
        addTaint(seq);
        addTaint(event.getTaint());
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageIOO(DO_DISPATCH_KEY_EVENT, seq,
                //event, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.338 -0400", hash_original_method = "B66D209112CB2D18AB081107433F0849", hash_generated_method = "08AC41AFB6F883D10CD66F05F65478DD")
    public void dispatchTrackballEvent(int seq, MotionEvent event, IInputMethodCallback callback) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageIOO(DO_DISPATCH_TRACKBALL_EVENT, seq,
                event, callback));
        addTaint(seq);
        addTaint(event.getTaint());
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageIOO(DO_DISPATCH_TRACKBALL_EVENT, seq,
                //event, callback));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.341 -0400", hash_original_method = "8CEFA969398A4D94CA9A297166BCD287", hash_generated_method = "6165D79A7A3387A1539415204788D706")
    public void updateSelection(int oldSelStart, int oldSelEnd,
            int newSelStart, int newSelEnd, int candidatesStart, int candidatesEnd) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageIIIIII(DO_UPDATE_SELECTION,
                oldSelStart, oldSelEnd, newSelStart, newSelEnd,
                candidatesStart, candidatesEnd));
        addTaint(oldSelStart);
        addTaint(oldSelEnd);
        addTaint(newSelStart);
        addTaint(newSelEnd);
        addTaint(candidatesStart);
        addTaint(candidatesEnd);
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageIIIIII(DO_UPDATE_SELECTION,
                //oldSelStart, oldSelEnd, newSelStart, newSelEnd,
                //candidatesStart, candidatesEnd));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.351 -0400", hash_original_method = "573066B3B680169C0F49551C28C5AAB3", hash_generated_method = "F5323C486430AD2E518829BC437EC24A")
    public void viewClicked(boolean focusChanged) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageI(DO_VIEW_CLICKED, focusChanged ? 1 : 0));
        addTaint(focusChanged);
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageI(DO_VIEW_CLICKED, focusChanged ? 1 : 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.353 -0400", hash_original_method = "AA4329CCB1121E7E7A4883B7E8B28B3A", hash_generated_method = "79ABCCA41B1DC1C5DB75DC87F8C0BB9C")
    public void updateCursor(Rect newCursor) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_UPDATE_CURSOR,
                newCursor));
        addTaint(newCursor.getTaint());
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageO(DO_UPDATE_CURSOR,
                //newCursor));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.354 -0400", hash_original_method = "198A18639F375147EA5FEBDF12A15204", hash_generated_method = "203A9DD349091209329CC5BE239AC359")
    public void appPrivateCommand(String action, Bundle data) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageOO(DO_APP_PRIVATE_COMMAND, action, data));
        addTaint(action.getTaint());
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageOO(DO_APP_PRIVATE_COMMAND, action, data));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.367 -0400", hash_original_method = "E1D5DFD3D112FBD55D45C010A5FB9D8C", hash_generated_method = "EEAC021BEF405126AB9718EE9ECB2B07")
    public void toggleSoftInput(int showFlags, int hideFlags) {
        mCaller.executeOrSendMessage(mCaller.obtainMessageII(DO_TOGGLE_SOFT_INPUT, showFlags, hideFlags));
        addTaint(showFlags);
        addTaint(hideFlags);
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessageII(DO_TOGGLE_SOFT_INPUT, showFlags, hideFlags));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.368 -0400", hash_original_method = "DD8E8E4C57A8296FF535720B90D4809B", hash_generated_method = "DA2B56A0945E112EFB6C9022E5AD067E")
    public void finishSession() {
        mCaller.executeOrSendMessage(mCaller.obtainMessage(DO_FINISH_SESSION));
        // ---------- Original Method ----------
        //mCaller.executeOrSendMessage(mCaller.obtainMessage(DO_FINISH_SESSION));
    }

    
    static class InputMethodEventCallbackWrapper implements InputMethodSession.EventCallback {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.369 -0400", hash_original_field = "BF2154B8BBFCFB3FCA616857B4286387", hash_generated_field = "4903C6C7AA2E39F51C3230E9003EAA25")

        IInputMethodCallback mCb;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.369 -0400", hash_original_method = "F69C5DA54CCE399124E2B79C8542153D", hash_generated_method = "B2C17F4C817962B7FCAE664250BDA861")
          InputMethodEventCallbackWrapper(IInputMethodCallback cb) {
            mCb = cb;
            // ---------- Original Method ----------
            //mCb = cb;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.370 -0400", hash_original_method = "7EDF22DE040F47B5D42C1B7CDA3CFBC9", hash_generated_method = "00EEE6A34AD8ABD81DE525DD70C6D5AB")
        public void finishedEvent(int seq, boolean handled) {
            try 
            {
                mCb.finishedEvent(seq, handled);
            } //End block
            catch (RemoteException e)
            { }
            addTaint(seq);
            addTaint(handled);
            // ---------- Original Method ----------
            //try {
                //mCb.finishedEvent(seq, handled);
            //} catch (RemoteException e) {
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.370 -0400", hash_original_field = "2F0141CD0AA2AC8746CE367240D90F41", hash_generated_field = "A32AB2456B1458570FCDAB0BFF072B5E")

    private static String TAG = "InputMethodWrapper";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.380 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.381 -0400", hash_original_field = "7F768B6A6603BE8439C4F6FEAEB9AAC7", hash_generated_field = "7500D81FA62DC839D5635F6C66EE8EBC")

    private static int DO_FINISH_INPUT = 60;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.381 -0400", hash_original_field = "7E7E80CDB1AE790678E31390AB9F8707", hash_generated_field = "09A3809712166CE7C6C2583DBF69D5C5")

    private static int DO_DISPLAY_COMPLETIONS = 65;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.381 -0400", hash_original_field = "3C008EAD20CA5788FF93FFC485DAF662", hash_generated_field = "2BB0684AA1CFF6E932373D8DCE20B233")

    private static int DO_UPDATE_EXTRACTED_TEXT = 67;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.381 -0400", hash_original_field = "3706FCF11236FE2D0B698633B24D3677", hash_generated_field = "E02726E572960B4BB09ACD4C455FBB5C")

    private static int DO_DISPATCH_KEY_EVENT = 70;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.381 -0400", hash_original_field = "E218BE2B9FF7D52FC62B5E2082E524F2", hash_generated_field = "F930DEC697D467068189AD8D545D57C2")

    private static int DO_DISPATCH_TRACKBALL_EVENT = 80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.381 -0400", hash_original_field = "333F236D1A400109744B82E5C02D3191", hash_generated_field = "41AB4222DD610871E5D416F031FCF437")

    private static int DO_UPDATE_SELECTION = 90;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.381 -0400", hash_original_field = "663D54DD04D27E06C1E54A0916DDC818", hash_generated_field = "346248D82520D47AFFAD61E1DC8B0D1E")

    private static int DO_UPDATE_CURSOR = 95;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.382 -0400", hash_original_field = "E6F5C98BF7AE4CEF3930EF796559BD82", hash_generated_field = "E90829C5AD25EE24E510C938F0350B5E")

    private static int DO_APP_PRIVATE_COMMAND = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.382 -0400", hash_original_field = "13D7442F8BBC66DF593BD3DBE1AA5B1E", hash_generated_field = "A6DE71064713A8CC421CC59EED1ADF67")

    private static int DO_TOGGLE_SOFT_INPUT = 105;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.382 -0400", hash_original_field = "405BD815E34DE69832A7BB7760C939E2", hash_generated_field = "7F926D5BA2991C9E5F5C344B5E393E88")

    private static int DO_FINISH_SESSION = 110;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:17.382 -0400", hash_original_field = "9689AE84974D0188E1C5F881F5A272AD", hash_generated_field = "E86F00DECC578A5258B6317D72068741")

    private static int DO_VIEW_CLICKED = 115;
}


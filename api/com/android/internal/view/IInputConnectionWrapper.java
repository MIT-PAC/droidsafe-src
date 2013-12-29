package com.android.internal.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;





public class IInputConnectionWrapper extends IInputContext.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.241 -0500", hash_original_field = "DA51199C6FA01D1CFDEDCEDF76608D1B", hash_generated_field = "900165FF60D4D63B5E39F15ED871ED73")

    static final String TAG = "IInputConnectionWrapper";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.242 -0500", hash_original_field = "DE3AE329D58BD236ACFD7DCC596A8841", hash_generated_field = "93215ED66A3AA28F5E079D863981D641")


    private static final int DO_GET_TEXT_AFTER_CURSOR = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.243 -0500", hash_original_field = "8CFBE61832B0AFF25F317505D5513ABA", hash_generated_field = "77B723127445ED341C49AD030D289BC5")

    private static final int DO_GET_TEXT_BEFORE_CURSOR = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.244 -0500", hash_original_field = "B48AE58CBCD5C59CAA25F88EE590ED54", hash_generated_field = "51EE3D33C8B20ECFDDE07BBCBB4E376E")

    private static final int DO_GET_SELECTED_TEXT = 25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.244 -0500", hash_original_field = "823EFC3696ADA5B5F751F69B7A930E57", hash_generated_field = "BCA32ABEAAFC403F2BCED79722EED453")

    private static final int DO_GET_CURSOR_CAPS_MODE = 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.245 -0500", hash_original_field = "F9ECA5058C66BC5E1EF18E7E76118143", hash_generated_field = "48A7DB7FC24E94ED646B2156F252FA2C")

    private static final int DO_GET_EXTRACTED_TEXT = 40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.246 -0500", hash_original_field = "8B5FAF4AA6073CA68AC4693064F69F64", hash_generated_field = "12DAACDA0ED408109635B38CF1A26B58")

    private static final int DO_COMMIT_TEXT = 50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.247 -0500", hash_original_field = "DB339655F499787B68F99A19217014AC", hash_generated_field = "2FFC27A574296430573F8BFC6EAE1CE7")

    private static final int DO_COMMIT_COMPLETION = 55;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.248 -0500", hash_original_field = "07B289FD45C6B9D7E7BE2C94EB442466", hash_generated_field = "13680546C8DA0B085E98BFE55C118B2C")

    private static final int DO_COMMIT_CORRECTION = 56;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.249 -0500", hash_original_field = "EC18A93414FC3A73044F5B861F607C9B", hash_generated_field = "AD41B2C006D6D67CC8775CEC10520A90")

    private static final int DO_SET_SELECTION = 57;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.250 -0500", hash_original_field = "C8F4518BFC899D0B8A45F66392B57114", hash_generated_field = "238C94F032A5384919F7EE90E5313139")

    private static final int DO_PERFORM_EDITOR_ACTION = 58;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.250 -0500", hash_original_field = "D2E49847AC3B41088B18D82444D1FADD", hash_generated_field = "650AF0A11A874B7C58DD493632230488")

    private static final int DO_PERFORM_CONTEXT_MENU_ACTION = 59;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.251 -0500", hash_original_field = "05A529B081542C0E0098DE86CACE5114", hash_generated_field = "51F7A494F2D018C46814C47040A1B844")

    private static final int DO_SET_COMPOSING_TEXT = 60;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.252 -0500", hash_original_field = "CAFAF3A9AB31434A6B7DB739BD97EDCA", hash_generated_field = "FA70AA4BBA7C0F3633F481FFABC342F9")

    private static final int DO_SET_COMPOSING_REGION = 63;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.253 -0500", hash_original_field = "58705604B2F88B1ADCDFAD58876C2D79", hash_generated_field = "17932C5334A9342E69C604B50A69E95A")

    private static final int DO_FINISH_COMPOSING_TEXT = 65;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.254 -0500", hash_original_field = "6C2524326FE4516D167C8E6F0647BF0C", hash_generated_field = "F567601080EFA0B5B22EEBABDFA2EB65")

    private static final int DO_SEND_KEY_EVENT = 70;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.255 -0500", hash_original_field = "828EA97A50CB78F8E225DAD8F9E237C6", hash_generated_field = "E142F65AD117AFEBB852664B04740F3D")

    private static final int DO_DELETE_SURROUNDING_TEXT = 80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.256 -0500", hash_original_field = "C3C7BF4C775F51DA43C2B3CA372C4299", hash_generated_field = "99C6EF96E09AF79D299B8C365DD014F6")

    private static final int DO_BEGIN_BATCH_EDIT = 90;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.256 -0500", hash_original_field = "17208B047D0ECF2CDCFCE9DD314C09D4", hash_generated_field = "6A5BFE0A81A35CF1D51D4C6C709F0D2E")

    private static final int DO_END_BATCH_EDIT = 95;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.257 -0500", hash_original_field = "CE099E4678FA4FF39E2E6594434B127D", hash_generated_field = "BF40CA519D14B3452BD21538E6037466")

    private static final int DO_REPORT_FULLSCREEN_MODE = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.258 -0500", hash_original_field = "94DF76B2D00354F43F4A3497982A9E47", hash_generated_field = "3AAFBD5EAFB589BEB2464F4FDC3B6CAB")

    private static final int DO_PERFORM_PRIVATE_COMMAND = 120;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.259 -0500", hash_original_field = "E5402600B2F3B0192F9173F9E9F2CDA3", hash_generated_field = "69946D6E4D680F21730784713CDC701E")

    private static final int DO_CLEAR_META_KEY_STATES = 130;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.260 -0500", hash_original_field = "94FC9D5399021E1DC54EC343560EF6C7", hash_generated_field = "BBA366FC8F1B26518754E187C86749B0")


    private WeakReference<InputConnection> mInputConnection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.261 -0500", hash_original_field = "22AA67C96F8F7AD7DFD89E53DF216F9A", hash_generated_field = "BAC908CF5B8572ED590A292E13883CF4")


    private Looper mMainLooper;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.262 -0500", hash_original_field = "CE7101CE6F8628D8EDF694C2A9A74F21", hash_generated_field = "A3B75E764711EA55737A441425E4D843")

    private Handler mH;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.268 -0500", hash_original_method = "9A20FF15705420E23492BF55DF80DCC1", hash_generated_method = "B07092D417265D7019F8F2C201646265")
    public IInputConnectionWrapper(Looper mainLooper, InputConnection conn) {
        mInputConnection = new WeakReference<InputConnection>(conn);
        mMainLooper = mainLooper;
        mH = new MyHandler(mMainLooper);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.269 -0500", hash_original_method = "51DFD52266A16587BB1D688A25EC9E53", hash_generated_method = "016488F9A5325D275DA87958F42CCA2F")
    public boolean isActive() {
        return true;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.270 -0500", hash_original_method = "BDB79A31B9E7C568F9DA8424F1B2AA88", hash_generated_method = "B686C54385AC2832B07EA62A4743E835")
    public void getTextAfterCursor(int length, int flags, int seq, IInputContextCallback callback) {
        dispatchMessage(obtainMessageIISC(DO_GET_TEXT_AFTER_CURSOR, length, flags, seq, callback));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.270 -0500", hash_original_method = "83476DD996D24314F0D36073D788F8EE", hash_generated_method = "22912B328E5AAF4F84C38A277DCCFFCB")
    public void getTextBeforeCursor(int length, int flags, int seq, IInputContextCallback callback) {
        dispatchMessage(obtainMessageIISC(DO_GET_TEXT_BEFORE_CURSOR, length, flags, seq, callback));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.271 -0500", hash_original_method = "A721A8133D2DE1034FAEB50C8FE4FD06", hash_generated_method = "7092989F4EACEA691A2252D037B47846")
    public void getSelectedText(int flags, int seq, IInputContextCallback callback) {
        dispatchMessage(obtainMessageISC(DO_GET_SELECTED_TEXT, flags, seq, callback));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.272 -0500", hash_original_method = "C43DF3E6E3EDAF8991B1451D7C0930B2", hash_generated_method = "DB694C12FB2DB598F063CCD76AC30413")
    public void getCursorCapsMode(int reqModes, int seq, IInputContextCallback callback) {
        dispatchMessage(obtainMessageISC(DO_GET_CURSOR_CAPS_MODE, reqModes, seq, callback));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.273 -0500", hash_original_method = "68CBA214FC59FA44F08B8B86723A4DD0", hash_generated_method = "50913C7CC00B5C3628272F7DB1847372")
    public void getExtractedText(ExtractedTextRequest request,
            int flags, int seq, IInputContextCallback callback) {
        dispatchMessage(obtainMessageIOSC(DO_GET_EXTRACTED_TEXT, flags,
                request, seq, callback));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.274 -0500", hash_original_method = "894E006D9CEB98BFF63F2F46F25BC243", hash_generated_method = "1EA55B7A11DBAAA44C61EE1DDCBA1C42")
    public void commitText(CharSequence text, int newCursorPosition) {
        dispatchMessage(obtainMessageIO(DO_COMMIT_TEXT, newCursorPosition, text));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.274 -0500", hash_original_method = "CBF7B83C8E625835F649B99623E30868", hash_generated_method = "C71A9A03EAA32C9051B9A39B07D39591")
    public void commitCompletion(CompletionInfo text) {
        dispatchMessage(obtainMessageO(DO_COMMIT_COMPLETION, text));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.276 -0500", hash_original_method = "8124D711A8307E610C5DEF0F89DBA666", hash_generated_method = "1E3F2CC71F7E1274DB7DF432A8FF923B")
    public void commitCorrection(CorrectionInfo info) {
        dispatchMessage(obtainMessageO(DO_COMMIT_CORRECTION, info));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.277 -0500", hash_original_method = "E49BA2D7A7A069DD200E49150DD829D6", hash_generated_method = "0A2A73D1AC263571E477FBD705AEE81E")
    public void setSelection(int start, int end) {
        dispatchMessage(obtainMessageII(DO_SET_SELECTION, start, end));
    }

    
    static class SomeArgs {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.262 -0500", hash_original_field = "524E284308787C3B27AB4CD560A816CF", hash_generated_field = "524E284308787C3B27AB4CD560A816CF")

        Object arg1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.263 -0500", hash_original_field = "2CC0C93F38D97721E695C73C9F8BA144", hash_generated_field = "2CC0C93F38D97721E695C73C9F8BA144")

        Object arg2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.264 -0500", hash_original_field = "844B2A0BBAFC5CBF10E337E600D741B3", hash_generated_field = "844B2A0BBAFC5CBF10E337E600D741B3")

        IInputContextCallback callback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.265 -0500", hash_original_field = "C4ECE7ED8A0F11C4F90796D05BE13ED7", hash_generated_field = "C4ECE7ED8A0F11C4F90796D05BE13ED7")

        int seq;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.184 -0400", hash_original_method = "C08D0E88500332C6E0DD16EFE525CF46", hash_generated_method = "C08D0E88500332C6E0DD16EFE525CF46")
        public SomeArgs ()
        {
            //Synthesized constructor
        }


    }


    
    class MyHandler extends Handler {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.266 -0500", hash_original_method = "761ACCB2E72A1319CE4B08F794806580", hash_generated_method = "761ACCB2E72A1319CE4B08F794806580")
        MyHandler(Looper looper) {
            super(looper);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.267 -0500", hash_original_method = "1DE21F974CC2F2B42894E9D98B8A257E", hash_generated_method = "DFA46ACAF15DF6AAFA15883420C7173D")
        @Override
public void handleMessage(Message msg) {
            executeMessage(msg);
        }

        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.277 -0500", hash_original_method = "21817A9A1C101F9FB118DF43CE4E5A0E", hash_generated_method = "ADE6C8DEFFEE2D54EF0128D190259AF8")
    public void performEditorAction(int id) {
        dispatchMessage(obtainMessageII(DO_PERFORM_EDITOR_ACTION, id, 0));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.278 -0500", hash_original_method = "053D329299E415D96D47FCFD70FD4878", hash_generated_method = "EBC544C7FD956DB1FDBD87ADBD10BC1A")
    public void performContextMenuAction(int id) {
        dispatchMessage(obtainMessageII(DO_PERFORM_CONTEXT_MENU_ACTION, id, 0));
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.279 -0500", hash_original_method = "D0BDE81E935635A3C1E1A2527338BB18", hash_generated_method = "6B55485338A16ED636CB5438779EF798")
    public void setComposingRegion(int start, int end) {
        dispatchMessage(obtainMessageII(DO_SET_COMPOSING_REGION, start, end));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.280 -0500", hash_original_method = "FC274EF8C2FF034547500DAA5F2951F1", hash_generated_method = "C6F7D0C169E32F2139CF95FF797F65C5")
    public void setComposingText(CharSequence text, int newCursorPosition) {
        dispatchMessage(obtainMessageIO(DO_SET_COMPOSING_TEXT, newCursorPosition, text));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.281 -0500", hash_original_method = "6F02D8053ECF48E238847A2FABA8F899", hash_generated_method = "D406A7ABB997ADAAF5D7ED7A73C7ABAA")
    public void finishComposingText() {
        dispatchMessage(obtainMessage(DO_FINISH_COMPOSING_TEXT));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.281 -0500", hash_original_method = "60A7447AAE4F39255FF17C7443EAC7D8", hash_generated_method = "820D213B504BCF3529DD315C8BFD09FD")
    public void sendKeyEvent(KeyEvent event) {
        dispatchMessage(obtainMessageO(DO_SEND_KEY_EVENT, event));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.282 -0500", hash_original_method = "CDF50C376207E59459DF05B9EB51603A", hash_generated_method = "CDDD5E5F534F3CB53D89C2C16D1E1819")
    public void clearMetaKeyStates(int states) {
        dispatchMessage(obtainMessageII(DO_CLEAR_META_KEY_STATES, states, 0));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.283 -0500", hash_original_method = "2E4F7757D66A73FD9325207AD0D4F280", hash_generated_method = "E9938A117524B1EFE8273458BBDD81F2")
    public void deleteSurroundingText(int leftLength, int rightLength) {
        dispatchMessage(obtainMessageII(DO_DELETE_SURROUNDING_TEXT,
            leftLength, rightLength));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.284 -0500", hash_original_method = "7A31F16907F3D96E10B72B79CABC1C1A", hash_generated_method = "6C6CFD60ED1C247D6C44AE2F161E3317")
    public void beginBatchEdit() {
        dispatchMessage(obtainMessage(DO_BEGIN_BATCH_EDIT));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.284 -0500", hash_original_method = "2DD80BF17B03574DE2AF6B49D0CD84C3", hash_generated_method = "7919F528D46238F936D37F756FCE87AE")
    public void endBatchEdit() {
        dispatchMessage(obtainMessage(DO_END_BATCH_EDIT));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.285 -0500", hash_original_method = "A19C601F9A82D2C4B88A8AB8DFBF0737", hash_generated_method = "6FBFFA0AFF8A387ADB6D08B583BB5918")
    public void reportFullscreenMode(boolean enabled) {
        dispatchMessage(obtainMessageII(DO_REPORT_FULLSCREEN_MODE, enabled ? 1 : 0, 0));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.286 -0500", hash_original_method = "14DBCF261CA01A06A7ACE942F825CE65", hash_generated_method = "D2ED6383EF1B89ED1E45945A50DAB1A5")
    public void performPrivateCommand(String action, Bundle data) {
        dispatchMessage(obtainMessageOO(DO_PERFORM_PRIVATE_COMMAND, action, data));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.287 -0500", hash_original_method = "F5A5E3786D2DDCB2FEFEBA688154C5D7", hash_generated_method = "A1BBFB8562CE1F2873E7B8F06FF3267A")
    void dispatchMessage(Message msg) {
        // If we are calling this from the main thread, then we can call
        // right through.  Otherwise, we need to send the message to the
        // main thread.
        if (Looper.myLooper() == mMainLooper) {
            executeMessage(msg);
            msg.recycle();
            return;
        }
        
        mH.sendMessage(msg);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.289 -0500", hash_original_method = "78BA9F6D5AE481CC7127DB3741BBDA1E", hash_generated_method = "BD7781E7C44106F974921C81ACD5568D")
    void executeMessage(Message msg) {
        switch (msg.what) {
            case DO_GET_TEXT_AFTER_CURSOR: {
                SomeArgs args = (SomeArgs)msg.obj;
                try {
                    InputConnection ic = mInputConnection.get();
                    if (ic == null || !isActive()) {
                        Log.w(TAG, "getTextAfterCursor on inactive InputConnection");
                        args.callback.setTextAfterCursor(null, args.seq);
                        return;
                    }
                    args.callback.setTextAfterCursor(ic.getTextAfterCursor(
                            msg.arg1, msg.arg2), args.seq);
                } catch (RemoteException e) {
                    Log.w(TAG, "Got RemoteException calling setTextAfterCursor", e);
                }
                return;
            }
            case DO_GET_TEXT_BEFORE_CURSOR: {
                SomeArgs args = (SomeArgs)msg.obj;
                try {
                    InputConnection ic = mInputConnection.get();
                    if (ic == null || !isActive()) {
                        Log.w(TAG, "getTextBeforeCursor on inactive InputConnection");
                        args.callback.setTextBeforeCursor(null, args.seq);
                        return;
                    }
                    args.callback.setTextBeforeCursor(ic.getTextBeforeCursor(
                            msg.arg1, msg.arg2), args.seq);
                } catch (RemoteException e) {
                    Log.w(TAG, "Got RemoteException calling setTextBeforeCursor", e);
                }
                return;
            }
            case DO_GET_SELECTED_TEXT: {
                SomeArgs args = (SomeArgs)msg.obj;
                try {
                    InputConnection ic = mInputConnection.get();
                    if (ic == null || !isActive()) {
                        Log.w(TAG, "getSelectedText on inactive InputConnection");
                        args.callback.setSelectedText(null, args.seq);
                        return;
                    }
                    args.callback.setSelectedText(ic.getSelectedText(
                            msg.arg1), args.seq);
                } catch (RemoteException e) {
                    Log.w(TAG, "Got RemoteException calling setSelectedText", e);
                }
                return;
            }
            case DO_GET_CURSOR_CAPS_MODE: {
                SomeArgs args = (SomeArgs)msg.obj;
                try {
                    InputConnection ic = mInputConnection.get();
                    if (ic == null || !isActive()) {
                        Log.w(TAG, "getCursorCapsMode on inactive InputConnection");
                        args.callback.setCursorCapsMode(0, args.seq);
                        return;
                    }
                    args.callback.setCursorCapsMode(ic.getCursorCapsMode(msg.arg1),
                            args.seq);
                } catch (RemoteException e) {
                    Log.w(TAG, "Got RemoteException calling setCursorCapsMode", e);
                }
                return;
            }
            case DO_GET_EXTRACTED_TEXT: {
                SomeArgs args = (SomeArgs)msg.obj;
                try {
                    InputConnection ic = mInputConnection.get();
                    if (ic == null || !isActive()) {
                        Log.w(TAG, "getExtractedText on inactive InputConnection");
                        args.callback.setExtractedText(null, args.seq);
                        return;
                    }
                    args.callback.setExtractedText(ic.getExtractedText(
                            (ExtractedTextRequest)args.arg1, msg.arg1), args.seq);
                } catch (RemoteException e) {
                    Log.w(TAG, "Got RemoteException calling setExtractedText", e);
                }
                return;
            }
            case DO_COMMIT_TEXT: {
                InputConnection ic = mInputConnection.get();
                if (ic == null || !isActive()) {
                    Log.w(TAG, "commitText on inactive InputConnection");
                    return;
                }
                ic.commitText((CharSequence)msg.obj, msg.arg1);
                return;
            }
            case DO_SET_SELECTION: {
                InputConnection ic = mInputConnection.get();
                if (ic == null || !isActive()) {
                    Log.w(TAG, "setSelection on inactive InputConnection");
                    return;
                }
                ic.setSelection(msg.arg1, msg.arg2);
                return;
            }
            case DO_PERFORM_EDITOR_ACTION: {
                InputConnection ic = mInputConnection.get();
                if (ic == null || !isActive()) {
                    Log.w(TAG, "performEditorAction on inactive InputConnection");
                    return;
                }
                ic.performEditorAction(msg.arg1);
                return;
            }
            case DO_PERFORM_CONTEXT_MENU_ACTION: {
                InputConnection ic = mInputConnection.get();
                if (ic == null || !isActive()) {
                    Log.w(TAG, "performContextMenuAction on inactive InputConnection");
                    return;
                }
                ic.performContextMenuAction(msg.arg1);
                return;
            }
            case DO_COMMIT_COMPLETION: {
                InputConnection ic = mInputConnection.get();
                if (ic == null || !isActive()) {
                    Log.w(TAG, "commitCompletion on inactive InputConnection");
                    return;
                }
                ic.commitCompletion((CompletionInfo)msg.obj);
                return;
            }
            case DO_COMMIT_CORRECTION: {
                InputConnection ic = mInputConnection.get();
                if (ic == null || !isActive()) {
                    Log.w(TAG, "commitCorrection on inactive InputConnection");
                    return;
                }
                ic.commitCorrection((CorrectionInfo)msg.obj);
                return;
            }
            case DO_SET_COMPOSING_TEXT: {
                InputConnection ic = mInputConnection.get();
                if (ic == null || !isActive()) {
                    Log.w(TAG, "setComposingText on inactive InputConnection");
                    return;
                }
                ic.setComposingText((CharSequence)msg.obj, msg.arg1);
                return;
            }
            case DO_SET_COMPOSING_REGION: {
                InputConnection ic = mInputConnection.get();
                if (ic == null || !isActive()) {
                    Log.w(TAG, "setComposingRegion on inactive InputConnection");
                    return;
                }
                ic.setComposingRegion(msg.arg1, msg.arg2);
                return;
            }
            case DO_FINISH_COMPOSING_TEXT: {
                InputConnection ic = mInputConnection.get();
                // Note we do NOT check isActive() here, because this is safe
                // for an IME to call at any time, and we need to allow it
                // through to clean up our state after the IME has switched to
                // another client.
                if (ic == null) {
                    Log.w(TAG, "finishComposingText on inactive InputConnection");
                    return;
                }
                ic.finishComposingText();
                return;
            }
            case DO_SEND_KEY_EVENT: {
                InputConnection ic = mInputConnection.get();
                if (ic == null || !isActive()) {
                    Log.w(TAG, "sendKeyEvent on inactive InputConnection");
                    return;
                }
                ic.sendKeyEvent((KeyEvent)msg.obj);
                return;
            }
            case DO_CLEAR_META_KEY_STATES: {
                InputConnection ic = mInputConnection.get();
                if (ic == null || !isActive()) {
                    Log.w(TAG, "clearMetaKeyStates on inactive InputConnection");
                    return;
                }
                ic.clearMetaKeyStates(msg.arg1);
                return;
            }
            case DO_DELETE_SURROUNDING_TEXT: {
                InputConnection ic = mInputConnection.get();
                if (ic == null || !isActive()) {
                    Log.w(TAG, "deleteSurroundingText on inactive InputConnection");
                    return;
                }
                ic.deleteSurroundingText(msg.arg1, msg.arg2);
                return;
            }
            case DO_BEGIN_BATCH_EDIT: {
                InputConnection ic = mInputConnection.get();
                if (ic == null || !isActive()) {
                    Log.w(TAG, "beginBatchEdit on inactive InputConnection");
                    return;
                }
                ic.beginBatchEdit();
                return;
            }
            case DO_END_BATCH_EDIT: {
                InputConnection ic = mInputConnection.get();
                if (ic == null || !isActive()) {
                    Log.w(TAG, "endBatchEdit on inactive InputConnection");
                    return;
                }
                ic.endBatchEdit();
                return;
            }
            case DO_REPORT_FULLSCREEN_MODE: {
                InputConnection ic = mInputConnection.get();
                if (ic == null || !isActive()) {
                    Log.w(TAG, "showStatusIcon on inactive InputConnection");
                    return;
                }
                ic.reportFullscreenMode(msg.arg1 == 1);
                return;
            }
            case DO_PERFORM_PRIVATE_COMMAND: {
                InputConnection ic = mInputConnection.get();
                if (ic == null || !isActive()) {
                    Log.w(TAG, "performPrivateCommand on inactive InputConnection");
                    return;
                }
                SomeArgs args = (SomeArgs)msg.obj;
                ic.performPrivateCommand((String)args.arg1,
                        (Bundle)args.arg2);
                return;
            }
        }
        Log.w(TAG, "Unhandled message code: " + msg.what);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.291 -0500", hash_original_method = "92301CED384526FAE2562FC8E2BD0E1D", hash_generated_method = "92301CED384526FAE2562FC8E2BD0E1D")
    Message obtainMessage(int what) {
        return mH.obtainMessage(what);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.291 -0500", hash_original_method = "1D375F3B5B7A421102D544B0D8C99910", hash_generated_method = "1D375F3B5B7A421102D544B0D8C99910")
    Message obtainMessageII(int what, int arg1, int arg2) {
        return mH.obtainMessage(what, arg1, arg2);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.292 -0500", hash_original_method = "E41B1E1C050A3613D52D3D6F2431F5B0", hash_generated_method = "E41B1E1C050A3613D52D3D6F2431F5B0")
    Message obtainMessageO(int what, Object arg1) {
        return mH.obtainMessage(what, 0, 0, arg1);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.293 -0500", hash_original_method = "C41806B53C46498944BCE998FEC907A1", hash_generated_method = "C41806B53C46498944BCE998FEC907A1")
    Message obtainMessageISC(int what, int arg1, int seq, IInputContextCallback callback) {
        SomeArgs args = new SomeArgs();
        args.callback = callback;
        args.seq = seq;
        return mH.obtainMessage(what, arg1, 0, args);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.294 -0500", hash_original_method = "81C8385506FF3623370F9C4C1A9DC229", hash_generated_method = "81C8385506FF3623370F9C4C1A9DC229")
    Message obtainMessageIISC(int what, int arg1, int arg2, int seq, IInputContextCallback callback) {
        SomeArgs args = new SomeArgs();
        args.callback = callback;
        args.seq = seq;
        return mH.obtainMessage(what, arg1, arg2, args);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.295 -0500", hash_original_method = "F0BFCDA04898886ED0BDB255B10E7641", hash_generated_method = "F0BFCDA04898886ED0BDB255B10E7641")
    Message obtainMessageIOSC(int what, int arg1, Object arg2, int seq,
            IInputContextCallback callback) {
        SomeArgs args = new SomeArgs();
        args.arg1 = arg2;
        args.callback = callback;
        args.seq = seq;
        return mH.obtainMessage(what, arg1, 0, args);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.295 -0500", hash_original_method = "BDB545C9895C4A044C116EE5375794DB", hash_generated_method = "BDB545C9895C4A044C116EE5375794DB")
    Message obtainMessageIO(int what, int arg1, Object arg2) {
        return mH.obtainMessage(what, arg1, 0, arg2);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:35.296 -0500", hash_original_method = "0CCDC84288D426642A6380F76E883191", hash_generated_method = "0CCDC84288D426642A6380F76E883191")
    Message obtainMessageOO(int what, Object arg1, Object arg2) {
        SomeArgs args = new SomeArgs();
        args.arg1 = arg1;
        args.arg2 = arg2;
        return mH.obtainMessage(what, 0, 0, args);
    }
}


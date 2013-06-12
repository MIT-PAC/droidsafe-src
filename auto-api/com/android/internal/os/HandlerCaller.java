package com.android.internal.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class HandlerCaller {
    private static String TAG = "HandlerCaller";
    private static boolean DEBUG = false;
    public Context mContext;
    Looper mMainLooper;
    Handler mH;
    Callback mCallback;
    static int ARGS_POOL_MAX_SIZE = 10;
    int mArgsPoolSize;
    SomeArgs mArgsPool;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:39.979 -0400", hash_original_method = "DC16108BBC1F4203D38999AB9D8A499B", hash_generated_method = "DB3F2BE4185C3C80E89522259A779C53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HandlerCaller(Context context, Callback callback) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(callback.dsTaint);
        mMainLooper = context.getMainLooper();
        mH = new MyHandler(mMainLooper);
        // ---------- Original Method ----------
        //mContext = context;
        //mMainLooper = context.getMainLooper();
        //mH = new MyHandler(mMainLooper);
        //mCallback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.006 -0400", hash_original_method = "1F1A7E5A9C662CFE3468FAA77D6AFFBC", hash_generated_method = "0BFEE8C297EF38B3DAD28C41F80D4CEE")
    @DSModeled(DSC.SAFE)
    public HandlerCaller(Context context, Looper looper, Callback callback) {
        dsTaint.addTaint(looper.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(callback.dsTaint);
        mH = new MyHandler(mMainLooper);
        // ---------- Original Method ----------
        //mContext = context;
        //mMainLooper = looper;
        //mH = new MyHandler(mMainLooper);
        //mCallback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.045 -0400", hash_original_method = "C7D786B1A8326469A6C4DF3167D826A7", hash_generated_method = "30A966C9580F49A4BF5304FD794184D1")
    @DSModeled(DSC.SAFE)
    public SomeArgs obtainArgs() {
        {
            SomeArgs args;
            args = mArgsPool;
            {
                mArgsPool = args.next;
                args.next = null;
                mArgsPoolSize--;
            } //End block
        } //End block
        return (SomeArgs)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mH) {
            //SomeArgs args = mArgsPool;
            //if (args != null) {
                //mArgsPool = args.next;
                //args.next = null;
                //mArgsPoolSize--;
                //return args;
            //}
        //}
        //return new SomeArgs();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.111 -0400", hash_original_method = "E4D2DD64F276F5C1793412D257C8C8A2", hash_generated_method = "9B256DA91AA113ABD763FF86CD7DEACF")
    @DSModeled(DSC.SAFE)
    public void recycleArgs(SomeArgs args) {
        dsTaint.addTaint(args.dsTaint);
        {
            {
                args.next = mArgsPool;
                mArgsPoolSize++;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mH) {
            //if (mArgsPoolSize < ARGS_POOL_MAX_SIZE) {
                //args.next = mArgsPool;
                //mArgsPool = args;
                //mArgsPoolSize++;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.201 -0400", hash_original_method = "1A5A4A70D9C2B06EE3F275C367F3D9A3", hash_generated_method = "0B740A71244E240BC4263D4C83B6FA65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void executeOrSendMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        {
            boolean varAFACA4F92DB746B2983C428CA25E9018_913454810 = (Looper.myLooper() == mMainLooper);
            {
                mCallback.executeMessage(msg);
                msg.recycle();
            } //End block
        } //End collapsed parenthetic
        mH.sendMessage(msg);
        // ---------- Original Method ----------
        //if (Looper.myLooper() == mMainLooper) {
            //mCallback.executeMessage(msg);
            //msg.recycle();
            //return;
        //}
        //mH.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.248 -0400", hash_original_method = "F78BB031B72C384E22E1C588BE9C4554", hash_generated_method = "29DD5212326ED3B9AEBC6830EE99FB89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasMessages(int what) {
        dsTaint.addTaint(what);
        boolean var04E4FEC2AB754AB398ED7BC1DC2628AC_1360708157 = (mH.hasMessages(what));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mH.hasMessages(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.277 -0400", hash_original_method = "C5E4F3B1776B7453A41B5A4B222B3CB0", hash_generated_method = "B1383611B273149F7C9AADC5F504926B")
    @DSModeled(DSC.SAFE)
    public void removeMessages(int what) {
        dsTaint.addTaint(what);
        mH.removeMessages(what);
        // ---------- Original Method ----------
        //mH.removeMessages(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.287 -0400", hash_original_method = "9AA1640CA16A58F0D0EB8CAC0A40B330", hash_generated_method = "CFE99AFEFE2896A9064CE7B95516629E")
    @DSModeled(DSC.SAFE)
    public void removeMessages(int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        mH.removeMessages(what, obj);
        // ---------- Original Method ----------
        //mH.removeMessages(what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.318 -0400", hash_original_method = "89209D6CF250959A1CD788CD1CB7EB84", hash_generated_method = "140EDD19DA3239E1452CD66F6F0813B1")
    @DSModeled(DSC.SAFE)
    public void sendMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        mH.sendMessage(msg);
        // ---------- Original Method ----------
        //mH.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.322 -0400", hash_original_method = "92301CED384526FAE2562FC8E2BD0E1D", hash_generated_method = "291BD2F9EA62875BE379B1163CC5B793")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessage(int what) {
        dsTaint.addTaint(what);
        Message varFEE2D1EE103817551737291B7608E5CF_1286546227 = (mH.obtainMessage(what));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.342 -0400", hash_original_method = "9B5888B6830AED9D93456049A7F2C369", hash_generated_method = "516CF05AAB61E328C0B2301DC2CBAF5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageBO(int what, boolean arg1, Object arg2) {
        dsTaint.addTaint(arg2.dsTaint);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        Message varF20A509A3F508168B55393FB2773D601_1649718239 = (mH.obtainMessage(what, arg1 ? 1 : 0, 0, arg2)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1 ? 1 : 0, 0, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.358 -0400", hash_original_method = "EB72AC22C9F7D2FB44688CD09996973C", hash_generated_method = "C30A1B496FEF0459D400B8541B6F139D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageBOO(int what, boolean arg1, Object arg2, Object arg3) {
        dsTaint.addTaint(arg3.dsTaint);
        dsTaint.addTaint(arg2.dsTaint);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        SomeArgs args;
        args = obtainArgs();
        args.arg1 = arg2;
        args.arg2 = arg3;
        Message var9F0D3AB9BC1959279863FA60C33FD8D0_354491189 = (mH.obtainMessage(what, arg1 ? 1 : 0, 0, args)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg2;
        //args.arg2 = arg3;
        //return mH.obtainMessage(what, arg1 ? 1 : 0, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.379 -0400", hash_original_method = "E41B1E1C050A3613D52D3D6F2431F5B0", hash_generated_method = "A65C611E738979FF9EF361C2FDADEF90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageO(int what, Object arg1) {
        dsTaint.addTaint(arg1.dsTaint);
        dsTaint.addTaint(what);
        Message varDA5F1792EFFA87F1DF926A0581D1337A_1901547332 = (mH.obtainMessage(what, 0, 0, arg1));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, 0, 0, arg1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.389 -0400", hash_original_method = "5C01371734D93F096340C1C928E9C4EB", hash_generated_method = "10E1522BD9C14A4B3ADD4C6C63B618BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageI(int what, int arg1) {
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        Message var8FE467076B772E72F773CE8586724794_501823892 = (mH.obtainMessage(what, arg1, 0));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.404 -0400", hash_original_method = "1D375F3B5B7A421102D544B0D8C99910", hash_generated_method = "D40199FB39A67DAC54F377243B01E087")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageII(int what, int arg1, int arg2) {
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        Message varAF554AB2540DE978951E6EC5F85F2810_2016066931 = (mH.obtainMessage(what, arg1, arg2));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.421 -0400", hash_original_method = "BDB545C9895C4A044C116EE5375794DB", hash_generated_method = "92E4CFE33AEDD2A6342C8703719D3579")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageIO(int what, int arg1, Object arg2) {
        dsTaint.addTaint(arg2.dsTaint);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        Message var670ADA01A86B54F5DD338CBFE2859A08_322751527 = (mH.obtainMessage(what, arg1, 0, arg2));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, 0, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.436 -0400", hash_original_method = "C859EEB4CE33BF0B4768A3A7456BD68F", hash_generated_method = "69B9EDD5086E5FD80FFD16F9AA1712AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageIIO(int what, int arg1, int arg2, Object arg3) {
        dsTaint.addTaint(arg3.dsTaint);
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        Message varEA9A794F41E2FC5C5A1B149C0797757B_1263914980 = (mH.obtainMessage(what, arg1, arg2, arg3));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, arg2, arg3);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.486 -0400", hash_original_method = "BCB5A1A15368DDA8D81813390243701E", hash_generated_method = "0D79D5CEB9EADD7988346BC7C7F77EC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageIIOO(int what, int arg1, int arg2,
            Object arg3, Object arg4) {
        dsTaint.addTaint(arg4.dsTaint);
        dsTaint.addTaint(arg3.dsTaint);
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        SomeArgs args;
        args = obtainArgs();
        args.arg1 = arg3;
        args.arg2 = arg4;
        Message varAC3EF224B4A0F6C3A92DBFEB43407C15_316509598 = (mH.obtainMessage(what, arg1, arg2, args));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg3;
        //args.arg2 = arg4;
        //return mH.obtainMessage(what, arg1, arg2, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.550 -0400", hash_original_method = "CB509D134FCA9E5B151CFC9C40C64D1B", hash_generated_method = "C21A06F04F206CCBBED3B3D560A3A3A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageIOO(int what, int arg1, Object arg2, Object arg3) {
        dsTaint.addTaint(arg3.dsTaint);
        dsTaint.addTaint(arg2.dsTaint);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        SomeArgs args;
        args = obtainArgs();
        args.arg1 = arg2;
        args.arg2 = arg3;
        Message var4636D3EBA90B94F7BD8E2550AB6B7C26_412485541 = (mH.obtainMessage(what, arg1, 0, args));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg2;
        //args.arg2 = arg3;
        //return mH.obtainMessage(what, arg1, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.634 -0400", hash_original_method = "36F936CCD9DE9DB810A79A5E8B7C79D8", hash_generated_method = "0606A08E6DE72CF8A446CBDC1AAD3FBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageOO(int what, Object arg1, Object arg2) {
        dsTaint.addTaint(arg2.dsTaint);
        dsTaint.addTaint(arg1.dsTaint);
        dsTaint.addTaint(what);
        SomeArgs args;
        args = obtainArgs();
        args.arg1 = arg1;
        args.arg2 = arg2;
        Message var6B3D46964E3CD4869B46C48561D658E2_21588134 = (mH.obtainMessage(what, 0, 0, args));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg1;
        //args.arg2 = arg2;
        //return mH.obtainMessage(what, 0, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.720 -0400", hash_original_method = "7B7B88DAF1A325732DD11D87B8FA8090", hash_generated_method = "756F776F2E004F8AD8EEEBC7E5FDD9ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageOOO(int what, Object arg1, Object arg2, Object arg3) {
        dsTaint.addTaint(arg3.dsTaint);
        dsTaint.addTaint(arg2.dsTaint);
        dsTaint.addTaint(arg1.dsTaint);
        dsTaint.addTaint(what);
        SomeArgs args;
        args = obtainArgs();
        args.arg1 = arg1;
        args.arg2 = arg2;
        args.arg3 = arg3;
        Message var6B3D46964E3CD4869B46C48561D658E2_899920905 = (mH.obtainMessage(what, 0, 0, args));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg1;
        //args.arg2 = arg2;
        //args.arg3 = arg3;
        //return mH.obtainMessage(what, 0, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.750 -0400", hash_original_method = "43873BAF9CC556751B2F5A72A399C999", hash_generated_method = "3B94F0EA7D8182F69C7AD221AAB8A213")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageOOOO(int what, Object arg1, Object arg2,
            Object arg3, Object arg4) {
        dsTaint.addTaint(arg4.dsTaint);
        dsTaint.addTaint(arg3.dsTaint);
        dsTaint.addTaint(arg2.dsTaint);
        dsTaint.addTaint(arg1.dsTaint);
        dsTaint.addTaint(what);
        SomeArgs args;
        args = obtainArgs();
        args.arg1 = arg1;
        args.arg2 = arg2;
        args.arg3 = arg3;
        args.arg4 = arg4;
        Message var6B3D46964E3CD4869B46C48561D658E2_80478087 = (mH.obtainMessage(what, 0, 0, args));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg1;
        //args.arg2 = arg2;
        //args.arg3 = arg3;
        //args.arg4 = arg4;
        //return mH.obtainMessage(what, 0, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.814 -0400", hash_original_method = "1D875093D7ACE086FCDFA3A9B952F51E", hash_generated_method = "7E3B0EC4D4DDA4AA8D43EEBCE35A44DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageIIII(int what, int arg1, int arg2,
            int arg3, int arg4) {
        dsTaint.addTaint(arg4);
        dsTaint.addTaint(arg3);
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        SomeArgs args;
        args = obtainArgs();
        args.argi1 = arg1;
        args.argi2 = arg2;
        args.argi3 = arg3;
        args.argi4 = arg4;
        Message var6B3D46964E3CD4869B46C48561D658E2_119369913 = (mH.obtainMessage(what, 0, 0, args));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.argi1 = arg1;
        //args.argi2 = arg2;
        //args.argi3 = arg3;
        //args.argi4 = arg4;
        //return mH.obtainMessage(what, 0, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:40.901 -0400", hash_original_method = "3AF5B3474072AA5DC94AC3405EBF7B29", hash_generated_method = "08DEEDB14580D40FD80652287B176995")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageIIIIII(int what, int arg1, int arg2,
            int arg3, int arg4, int arg5, int arg6) {
        dsTaint.addTaint(arg5);
        dsTaint.addTaint(arg4);
        dsTaint.addTaint(arg3);
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        dsTaint.addTaint(arg6);
        SomeArgs args;
        args = obtainArgs();
        args.argi1 = arg1;
        args.argi2 = arg2;
        args.argi3 = arg3;
        args.argi4 = arg4;
        args.argi5 = arg5;
        args.argi6 = arg6;
        Message var6B3D46964E3CD4869B46C48561D658E2_109236636 = (mH.obtainMessage(what, 0, 0, args));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.argi1 = arg1;
        //args.argi2 = arg2;
        //args.argi3 = arg3;
        //args.argi4 = arg4;
        //args.argi5 = arg5;
        //args.argi6 = arg6;
        //return mH.obtainMessage(what, 0, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:41.036 -0400", hash_original_method = "1605D92F345EA1B31CBE383F462424A6", hash_generated_method = "8F7AC6683192887463EF070BBA59A76E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageIIIIO(int what, int arg1, int arg2,
            int arg3, int arg4, Object arg5) {
        dsTaint.addTaint(arg5.dsTaint);
        dsTaint.addTaint(arg4);
        dsTaint.addTaint(arg3);
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        SomeArgs args;
        args = obtainArgs();
        args.arg1 = arg5;
        args.argi1 = arg1;
        args.argi2 = arg2;
        args.argi3 = arg3;
        args.argi4 = arg4;
        Message var6B3D46964E3CD4869B46C48561D658E2_66224784 = (mH.obtainMessage(what, 0, 0, args));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg5;
        //args.argi1 = arg1;
        //args.argi2 = arg2;
        //args.argi3 = arg3;
        //args.argi4 = arg4;
        //return mH.obtainMessage(what, 0, 0, args);
    }

    
    public static class SomeArgs {
        SomeArgs next;
        public Object arg1;
        public Object arg2;
        public Object arg3;
        public Object arg4;
        public int argi1;
        public int argi2;
        public int argi3;
        public int argi4;
        public int argi5;
        public int argi6;
        
    }


    
    class MyHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:41.065 -0400", hash_original_method = "761ACCB2E72A1319CE4B08F794806580", hash_generated_method = "DB0BBD9DD8D354B255ECFC0BE6ACB2E2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         MyHandler(Looper looper) {
            super(looper);
            dsTaint.addTaint(looper.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:41.099 -0400", hash_original_method = "2ADED77FEF883BE82C94E7C39AB99489", hash_generated_method = "D18BAA21E284211676DB6C69B0A3A211")
        @DSModeled(DSC.SAFE)
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            mCallback.executeMessage(msg);
            // ---------- Original Method ----------
            //mCallback.executeMessage(msg);
        }

        
    }


    
    public interface Callback {
        public void executeMessage(Message msg);
    }
    
}



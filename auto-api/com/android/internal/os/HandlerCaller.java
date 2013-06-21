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
    public Context mContext;
    Looper mMainLooper;
    Handler mH;
    Callback mCallback;
    int mArgsPoolSize;
    SomeArgs mArgsPool;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.203 -0400", hash_original_method = "DC16108BBC1F4203D38999AB9D8A499B", hash_generated_method = "B3A1AD2BF451F802F33FF66EF4339F2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HandlerCaller(Context context, Callback callback) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        mMainLooper = context.getMainLooper();
        mH = new MyHandler(mMainLooper);
        // ---------- Original Method ----------
        //mContext = context;
        //mMainLooper = context.getMainLooper();
        //mH = new MyHandler(mMainLooper);
        //mCallback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.204 -0400", hash_original_method = "1F1A7E5A9C662CFE3468FAA77D6AFFBC", hash_generated_method = "9959904499D14BD0EF09F5341232974B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HandlerCaller(Context context, Looper looper, Callback callback) {
        dsTaint.addTaint(looper.dsTaint);
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        mH = new MyHandler(mMainLooper);
        // ---------- Original Method ----------
        //mContext = context;
        //mMainLooper = looper;
        //mH = new MyHandler(mMainLooper);
        //mCallback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.204 -0400", hash_original_method = "C7D786B1A8326469A6C4DF3167D826A7", hash_generated_method = "F8C49AF1785316321D19E9FDDAC3A5DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SomeArgs obtainArgs() {
        {
            SomeArgs args;
            args = mArgsPool;
            {
                mArgsPool = args.next;
                args.next = null;
            } //End block
        } //End block
        SomeArgs var8CEC2221E6D80325DF29500FB9ED111D_1386728206 = (new SomeArgs());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.204 -0400", hash_original_method = "E4D2DD64F276F5C1793412D257C8C8A2", hash_generated_method = "3EC502F56A6F76C9FB0FF8C408A63A2A")
    @DSModeled(DSC.SAFE)
    public void recycleArgs(SomeArgs args) {
        dsTaint.addTaint(args.dsTaint);
        {
            {
                args.next = mArgsPool;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.204 -0400", hash_original_method = "1A5A4A70D9C2B06EE3F275C367F3D9A3", hash_generated_method = "67FF983AD7E70C8C4C451AACA1B09396")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void executeOrSendMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        {
            boolean varAFACA4F92DB746B2983C428CA25E9018_777043919 = (Looper.myLooper() == mMainLooper);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.204 -0400", hash_original_method = "F78BB031B72C384E22E1C588BE9C4554", hash_generated_method = "3E642EF4BCB02CA778DE3F66EC9B8065")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasMessages(int what) {
        dsTaint.addTaint(what);
        boolean var04E4FEC2AB754AB398ED7BC1DC2628AC_1238993624 = (mH.hasMessages(what));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mH.hasMessages(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.205 -0400", hash_original_method = "C5E4F3B1776B7453A41B5A4B222B3CB0", hash_generated_method = "1B78642A3918C44115E5A4ABC5C6475F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeMessages(int what) {
        dsTaint.addTaint(what);
        mH.removeMessages(what);
        // ---------- Original Method ----------
        //mH.removeMessages(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.205 -0400", hash_original_method = "9AA1640CA16A58F0D0EB8CAC0A40B330", hash_generated_method = "E3665AE3CCBC90C750ED7D711661B7DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeMessages(int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        mH.removeMessages(what, obj);
        // ---------- Original Method ----------
        //mH.removeMessages(what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.205 -0400", hash_original_method = "89209D6CF250959A1CD788CD1CB7EB84", hash_generated_method = "E6DDFB5BE4E6ED5CD5CC0A277E16D69C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        mH.sendMessage(msg);
        // ---------- Original Method ----------
        //mH.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.205 -0400", hash_original_method = "92301CED384526FAE2562FC8E2BD0E1D", hash_generated_method = "C6EE1F1B765459FA1726322C2BB5FE0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessage(int what) {
        dsTaint.addTaint(what);
        Message varFEE2D1EE103817551737291B7608E5CF_1453742709 = (mH.obtainMessage(what));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.205 -0400", hash_original_method = "9B5888B6830AED9D93456049A7F2C369", hash_generated_method = "33A91B517837F2D407E7628D902C3A0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageBO(int what, boolean arg1, Object arg2) {
        dsTaint.addTaint(arg2.dsTaint);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        Message varF20A509A3F508168B55393FB2773D601_2111530589 = (mH.obtainMessage(what, arg1 ? 1 : 0, 0, arg2)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1 ? 1 : 0, 0, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.205 -0400", hash_original_method = "EB72AC22C9F7D2FB44688CD09996973C", hash_generated_method = "A1389A05AA003B480A57E740324609BD")
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
        Message var9F0D3AB9BC1959279863FA60C33FD8D0_1431108439 = (mH.obtainMessage(what, arg1 ? 1 : 0, 0, args)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg2;
        //args.arg2 = arg3;
        //return mH.obtainMessage(what, arg1 ? 1 : 0, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.206 -0400", hash_original_method = "E41B1E1C050A3613D52D3D6F2431F5B0", hash_generated_method = "50CD9EE5526F8829328BFF8660B6165D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageO(int what, Object arg1) {
        dsTaint.addTaint(arg1.dsTaint);
        dsTaint.addTaint(what);
        Message varDA5F1792EFFA87F1DF926A0581D1337A_1146287476 = (mH.obtainMessage(what, 0, 0, arg1));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, 0, 0, arg1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.206 -0400", hash_original_method = "5C01371734D93F096340C1C928E9C4EB", hash_generated_method = "ADFC13E32172837BC2A1786EFDF72B48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageI(int what, int arg1) {
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        Message var8FE467076B772E72F773CE8586724794_109922270 = (mH.obtainMessage(what, arg1, 0));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.206 -0400", hash_original_method = "1D375F3B5B7A421102D544B0D8C99910", hash_generated_method = "8076CB5430A3154C971DE267FD0D61EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageII(int what, int arg1, int arg2) {
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        Message varAF554AB2540DE978951E6EC5F85F2810_1888468468 = (mH.obtainMessage(what, arg1, arg2));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.206 -0400", hash_original_method = "BDB545C9895C4A044C116EE5375794DB", hash_generated_method = "CBF987F2878B8AE6022AA9B041FD0D31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageIO(int what, int arg1, Object arg2) {
        dsTaint.addTaint(arg2.dsTaint);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        Message var670ADA01A86B54F5DD338CBFE2859A08_220464222 = (mH.obtainMessage(what, arg1, 0, arg2));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, 0, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.206 -0400", hash_original_method = "C859EEB4CE33BF0B4768A3A7456BD68F", hash_generated_method = "6ABDF9D945718A5CCC51195A75479D5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageIIO(int what, int arg1, int arg2, Object arg3) {
        dsTaint.addTaint(arg3.dsTaint);
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        Message varEA9A794F41E2FC5C5A1B149C0797757B_2096242694 = (mH.obtainMessage(what, arg1, arg2, arg3));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, arg2, arg3);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.207 -0400", hash_original_method = "BCB5A1A15368DDA8D81813390243701E", hash_generated_method = "09B36F5CD86CCE39FA4002ACA8C79B00")
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
        Message varAC3EF224B4A0F6C3A92DBFEB43407C15_1218986603 = (mH.obtainMessage(what, arg1, arg2, args));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg3;
        //args.arg2 = arg4;
        //return mH.obtainMessage(what, arg1, arg2, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.207 -0400", hash_original_method = "CB509D134FCA9E5B151CFC9C40C64D1B", hash_generated_method = "E758A0460F6AE5E55E612C038AFD91BF")
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
        Message var4636D3EBA90B94F7BD8E2550AB6B7C26_657364260 = (mH.obtainMessage(what, arg1, 0, args));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg2;
        //args.arg2 = arg3;
        //return mH.obtainMessage(what, arg1, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.207 -0400", hash_original_method = "36F936CCD9DE9DB810A79A5E8B7C79D8", hash_generated_method = "77D31A510899F8A7B9F69070E62676B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message obtainMessageOO(int what, Object arg1, Object arg2) {
        dsTaint.addTaint(arg2.dsTaint);
        dsTaint.addTaint(arg1.dsTaint);
        dsTaint.addTaint(what);
        SomeArgs args;
        args = obtainArgs();
        args.arg1 = arg1;
        args.arg2 = arg2;
        Message var6B3D46964E3CD4869B46C48561D658E2_1108859922 = (mH.obtainMessage(what, 0, 0, args));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg1;
        //args.arg2 = arg2;
        //return mH.obtainMessage(what, 0, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.207 -0400", hash_original_method = "7B7B88DAF1A325732DD11D87B8FA8090", hash_generated_method = "EE4A88746148B8575EB8C457662773F6")
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
        Message var6B3D46964E3CD4869B46C48561D658E2_1264099406 = (mH.obtainMessage(what, 0, 0, args));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg1;
        //args.arg2 = arg2;
        //args.arg3 = arg3;
        //return mH.obtainMessage(what, 0, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.207 -0400", hash_original_method = "43873BAF9CC556751B2F5A72A399C999", hash_generated_method = "165D8E949F8C6465B2090F8042428811")
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
        Message var6B3D46964E3CD4869B46C48561D658E2_616955175 = (mH.obtainMessage(what, 0, 0, args));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg1;
        //args.arg2 = arg2;
        //args.arg3 = arg3;
        //args.arg4 = arg4;
        //return mH.obtainMessage(what, 0, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.208 -0400", hash_original_method = "1D875093D7ACE086FCDFA3A9B952F51E", hash_generated_method = "8FBE7DF31CAA624FD10E8B2F8580A40F")
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
        Message var6B3D46964E3CD4869B46C48561D658E2_1569982474 = (mH.obtainMessage(what, 0, 0, args));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.argi1 = arg1;
        //args.argi2 = arg2;
        //args.argi3 = arg3;
        //args.argi4 = arg4;
        //return mH.obtainMessage(what, 0, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.208 -0400", hash_original_method = "3AF5B3474072AA5DC94AC3405EBF7B29", hash_generated_method = "07C223510C35F89167DB329030724098")
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
        Message var6B3D46964E3CD4869B46C48561D658E2_1883885990 = (mH.obtainMessage(what, 0, 0, args));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.208 -0400", hash_original_method = "1605D92F345EA1B31CBE383F462424A6", hash_generated_method = "05677E581195ECD1FFCC1FC26617931E")
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
        Message var6B3D46964E3CD4869B46C48561D658E2_2051429098 = (mH.obtainMessage(what, 0, 0, args));
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.208 -0400", hash_original_method = "1DC11EC4B8DE02C86752DC3C92AC9A78", hash_generated_method = "1DC11EC4B8DE02C86752DC3C92AC9A78")
                public SomeArgs ()
        {
        }


    }


    
    class MyHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.208 -0400", hash_original_method = "761ACCB2E72A1319CE4B08F794806580", hash_generated_method = "EEC454106D5898516E458706CD5449DB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         MyHandler(Looper looper) {
            super(looper);
            dsTaint.addTaint(looper.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.209 -0400", hash_original_method = "2ADED77FEF883BE82C94E7C39AB99489", hash_generated_method = "2D72ACB5A41088DBCE31F3500DD501DA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
    
    private static final String TAG = "HandlerCaller";
    private static final boolean DEBUG = false;
    static final int ARGS_POOL_MAX_SIZE = 10;
}


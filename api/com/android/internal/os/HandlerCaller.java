package com.android.internal.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class HandlerCaller {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.493 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "DE8577C1C990964647332D172A1FAC00")

    public Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.493 -0400", hash_original_field = "6C2EA91B438529F1372D806717F5AE04", hash_generated_field = "22AA67C96F8F7AD7DFD89E53DF216F9A")

    Looper mMainLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.493 -0400", hash_original_field = "6D1DA64E705BB119454CD3D6A13CB760", hash_generated_field = "CE7101CE6F8628D8EDF694C2A9A74F21")

    Handler mH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.493 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "1A99E72B6409E38FBCC780D1BAB4898D")

    Callback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.493 -0400", hash_original_field = "BCE6D68C369762660B24A79B1325E5A8", hash_generated_field = "1C9F48D10ECE38E6D9CD4E1243016544")

    int mArgsPoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.493 -0400", hash_original_field = "501F4E68AECE332CAF9C8A8B22C17758", hash_generated_field = "5ED907D190BACFFA2B993A486EE65501")

    SomeArgs mArgsPool;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.494 -0400", hash_original_method = "DC16108BBC1F4203D38999AB9D8A499B", hash_generated_method = "E8E0DE8D7064D85995E397D6F81C7E4B")
    public  HandlerCaller(Context context, Callback callback) {
        mContext = context;
        mMainLooper = context.getMainLooper();
        mH = new MyHandler(mMainLooper);
        mCallback = callback;
        // ---------- Original Method ----------
        //mContext = context;
        //mMainLooper = context.getMainLooper();
        //mH = new MyHandler(mMainLooper);
        //mCallback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.494 -0400", hash_original_method = "1F1A7E5A9C662CFE3468FAA77D6AFFBC", hash_generated_method = "D622C1006F98FB5D313D40384C623E11")
    public  HandlerCaller(Context context, Looper looper, Callback callback) {
        mContext = context;
        mMainLooper = looper;
        mH = new MyHandler(mMainLooper);
        mCallback = callback;
        // ---------- Original Method ----------
        //mContext = context;
        //mMainLooper = looper;
        //mH = new MyHandler(mMainLooper);
        //mCallback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.495 -0400", hash_original_method = "C7D786B1A8326469A6C4DF3167D826A7", hash_generated_method = "DD7A177A450685E51E8656DA754D687D")
    public SomeArgs obtainArgs() {
        synchronized
(mH)        {
            SomeArgs args = mArgsPool;
            if(args != null)            
            {
                mArgsPool = args.next;
                args.next = null;
                mArgsPoolSize--;
SomeArgs var7BCCA1EB8ECD10BA7D4B968A010F7894_414750160 =                 args;
                var7BCCA1EB8ECD10BA7D4B968A010F7894_414750160.addTaint(taint);
                return var7BCCA1EB8ECD10BA7D4B968A010F7894_414750160;
            } //End block
        } //End block
SomeArgs var3D528EF95CDEA694A7BAAAADBA8E1F7D_1353826840 =         new SomeArgs();
        var3D528EF95CDEA694A7BAAAADBA8E1F7D_1353826840.addTaint(taint);
        return var3D528EF95CDEA694A7BAAAADBA8E1F7D_1353826840;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.496 -0400", hash_original_method = "E4D2DD64F276F5C1793412D257C8C8A2", hash_generated_method = "A9D66F406D866E62779A07E177DA3E42")
    public void recycleArgs(SomeArgs args) {
        synchronized
(mH)        {
            if(mArgsPoolSize < ARGS_POOL_MAX_SIZE)            
            {
                args.next = mArgsPool;
                mArgsPool = args;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.496 -0400", hash_original_method = "1A5A4A70D9C2B06EE3F275C367F3D9A3", hash_generated_method = "CDF2C5C0CD517AD635607882E6918464")
    public void executeOrSendMessage(Message msg) {
        addTaint(msg.getTaint());
        if(Looper.myLooper() == mMainLooper)        
        {
            mCallback.executeMessage(msg);
            msg.recycle();
            return;
        } //End block
        mH.sendMessage(msg);
        // ---------- Original Method ----------
        //if (Looper.myLooper() == mMainLooper) {
            //mCallback.executeMessage(msg);
            //msg.recycle();
            //return;
        //}
        //mH.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.497 -0400", hash_original_method = "F78BB031B72C384E22E1C588BE9C4554", hash_generated_method = "1431A00D8681E597AA8B26E134264033")
    public boolean hasMessages(int what) {
        addTaint(what);
        boolean var289AC79E7E0518B3F63B70B6CBD28E15_1341596296 = (mH.hasMessages(what));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1171844758 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1171844758;
        // ---------- Original Method ----------
        //return mH.hasMessages(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.497 -0400", hash_original_method = "C5E4F3B1776B7453A41B5A4B222B3CB0", hash_generated_method = "18A9E313E19276F6F3C486900CFB2E2C")
    public void removeMessages(int what) {
        addTaint(what);
        mH.removeMessages(what);
        // ---------- Original Method ----------
        //mH.removeMessages(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.497 -0400", hash_original_method = "9AA1640CA16A58F0D0EB8CAC0A40B330", hash_generated_method = "66DF94404F9483A0413E5A6D7E40CB20")
    public void removeMessages(int what, Object obj) {
        addTaint(obj.getTaint());
        addTaint(what);
        mH.removeMessages(what, obj);
        // ---------- Original Method ----------
        //mH.removeMessages(what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.498 -0400", hash_original_method = "89209D6CF250959A1CD788CD1CB7EB84", hash_generated_method = "A55856B6484BD15BCE80D587D876BF78")
    public void sendMessage(Message msg) {
        addTaint(msg.getTaint());
        mH.sendMessage(msg);
        // ---------- Original Method ----------
        //mH.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.498 -0400", hash_original_method = "92301CED384526FAE2562FC8E2BD0E1D", hash_generated_method = "585F4992EA41F0F5E07D482D8E0A36E2")
    public Message obtainMessage(int what) {
        addTaint(what);
Message var0A074E99CF455DBBC1653B54C1535B52_779541115 =         mH.obtainMessage(what);
        var0A074E99CF455DBBC1653B54C1535B52_779541115.addTaint(taint);
        return var0A074E99CF455DBBC1653B54C1535B52_779541115;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.498 -0400", hash_original_method = "9B5888B6830AED9D93456049A7F2C369", hash_generated_method = "2B5C49048920C404533CF90B6A4F297B")
    public Message obtainMessageBO(int what, boolean arg1, Object arg2) {
        addTaint(arg2.getTaint());
        addTaint(arg1);
        addTaint(what);
Message var8936877D68185D0B4EB65AC8508991DB_700599739 =         mH.obtainMessage(what, arg1 ? 1 : 0, 0, arg2);
        var8936877D68185D0B4EB65AC8508991DB_700599739.addTaint(taint);
        return var8936877D68185D0B4EB65AC8508991DB_700599739;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1 ? 1 : 0, 0, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.499 -0400", hash_original_method = "EB72AC22C9F7D2FB44688CD09996973C", hash_generated_method = "A38E617A4AAB11F86A80FB2B67389FE4")
    public Message obtainMessageBOO(int what, boolean arg1, Object arg2, Object arg3) {
        addTaint(arg3.getTaint());
        addTaint(arg2.getTaint());
        addTaint(arg1);
        addTaint(what);
        SomeArgs args = obtainArgs();
        args.arg1 = arg2;
        args.arg2 = arg3;
Message var8CD7882DD82B207C219EF242467E72A7_144669184 =         mH.obtainMessage(what, arg1 ? 1 : 0, 0, args);
        var8CD7882DD82B207C219EF242467E72A7_144669184.addTaint(taint);
        return var8CD7882DD82B207C219EF242467E72A7_144669184;
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg2;
        //args.arg2 = arg3;
        //return mH.obtainMessage(what, arg1 ? 1 : 0, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.499 -0400", hash_original_method = "E41B1E1C050A3613D52D3D6F2431F5B0", hash_generated_method = "49904D2FC9646FA33A17E006AC625C9C")
    public Message obtainMessageO(int what, Object arg1) {
        addTaint(arg1.getTaint());
        addTaint(what);
Message var12CDD1AFE5E6600F8EC4A70E6284B925_1177306059 =         mH.obtainMessage(what, 0, 0, arg1);
        var12CDD1AFE5E6600F8EC4A70E6284B925_1177306059.addTaint(taint);
        return var12CDD1AFE5E6600F8EC4A70E6284B925_1177306059;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, 0, 0, arg1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.499 -0400", hash_original_method = "5C01371734D93F096340C1C928E9C4EB", hash_generated_method = "E4904EC72D3C0EA69AC4DE325ABFDAD5")
    public Message obtainMessageI(int what, int arg1) {
        addTaint(arg1);
        addTaint(what);
Message varA61A46C8A8EC07D7F87A90750DD76055_978072744 =         mH.obtainMessage(what, arg1, 0);
        varA61A46C8A8EC07D7F87A90750DD76055_978072744.addTaint(taint);
        return varA61A46C8A8EC07D7F87A90750DD76055_978072744;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.500 -0400", hash_original_method = "1D375F3B5B7A421102D544B0D8C99910", hash_generated_method = "E38875C5D11E3BAD95F5B056703AB20D")
    public Message obtainMessageII(int what, int arg1, int arg2) {
        addTaint(arg2);
        addTaint(arg1);
        addTaint(what);
Message var2005F2BFA3651910E62A138190D96BC6_39018740 =         mH.obtainMessage(what, arg1, arg2);
        var2005F2BFA3651910E62A138190D96BC6_39018740.addTaint(taint);
        return var2005F2BFA3651910E62A138190D96BC6_39018740;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.500 -0400", hash_original_method = "BDB545C9895C4A044C116EE5375794DB", hash_generated_method = "11CF57A773900DB6C729B0BC9E81A69B")
    public Message obtainMessageIO(int what, int arg1, Object arg2) {
        addTaint(arg2.getTaint());
        addTaint(arg1);
        addTaint(what);
Message var1EA5D3012D434458EE54B63DB011E658_690507436 =         mH.obtainMessage(what, arg1, 0, arg2);
        var1EA5D3012D434458EE54B63DB011E658_690507436.addTaint(taint);
        return var1EA5D3012D434458EE54B63DB011E658_690507436;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, 0, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.500 -0400", hash_original_method = "C859EEB4CE33BF0B4768A3A7456BD68F", hash_generated_method = "B394897219CB0FAB09CBBB49C8DC413E")
    public Message obtainMessageIIO(int what, int arg1, int arg2, Object arg3) {
        addTaint(arg3.getTaint());
        addTaint(arg2);
        addTaint(arg1);
        addTaint(what);
Message varA9E913F50F1F9B12E959A49B9E93986F_537218128 =         mH.obtainMessage(what, arg1, arg2, arg3);
        varA9E913F50F1F9B12E959A49B9E93986F_537218128.addTaint(taint);
        return varA9E913F50F1F9B12E959A49B9E93986F_537218128;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, arg2, arg3);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.501 -0400", hash_original_method = "BCB5A1A15368DDA8D81813390243701E", hash_generated_method = "42CC13CDB64AA91F8FD5EB236239F5B0")
    public Message obtainMessageIIOO(int what, int arg1, int arg2,
            Object arg3, Object arg4) {
        addTaint(arg4.getTaint());
        addTaint(arg3.getTaint());
        addTaint(arg2);
        addTaint(arg1);
        addTaint(what);
        SomeArgs args = obtainArgs();
        args.arg1 = arg3;
        args.arg2 = arg4;
Message var77BF585217243532581F9F8C4041DDF0_150494473 =         mH.obtainMessage(what, arg1, arg2, args);
        var77BF585217243532581F9F8C4041DDF0_150494473.addTaint(taint);
        return var77BF585217243532581F9F8C4041DDF0_150494473;
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg3;
        //args.arg2 = arg4;
        //return mH.obtainMessage(what, arg1, arg2, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.502 -0400", hash_original_method = "CB509D134FCA9E5B151CFC9C40C64D1B", hash_generated_method = "55FAB09D6D776550BEAD8FBE5BA7C324")
    public Message obtainMessageIOO(int what, int arg1, Object arg2, Object arg3) {
        addTaint(arg3.getTaint());
        addTaint(arg2.getTaint());
        addTaint(arg1);
        addTaint(what);
        SomeArgs args = obtainArgs();
        args.arg1 = arg2;
        args.arg2 = arg3;
Message varB613521389A33EC54F8F174F01C6658A_1688471037 =         mH.obtainMessage(what, arg1, 0, args);
        varB613521389A33EC54F8F174F01C6658A_1688471037.addTaint(taint);
        return varB613521389A33EC54F8F174F01C6658A_1688471037;
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg2;
        //args.arg2 = arg3;
        //return mH.obtainMessage(what, arg1, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.502 -0400", hash_original_method = "36F936CCD9DE9DB810A79A5E8B7C79D8", hash_generated_method = "E3BB4F2F9250367E395971ACA49890E8")
    public Message obtainMessageOO(int what, Object arg1, Object arg2) {
        addTaint(arg2.getTaint());
        addTaint(arg1.getTaint());
        addTaint(what);
        SomeArgs args = obtainArgs();
        args.arg1 = arg1;
        args.arg2 = arg2;
Message varA09BA0A68969A0A00DFB7B824079B8FE_741212808 =         mH.obtainMessage(what, 0, 0, args);
        varA09BA0A68969A0A00DFB7B824079B8FE_741212808.addTaint(taint);
        return varA09BA0A68969A0A00DFB7B824079B8FE_741212808;
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg1;
        //args.arg2 = arg2;
        //return mH.obtainMessage(what, 0, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.502 -0400", hash_original_method = "7B7B88DAF1A325732DD11D87B8FA8090", hash_generated_method = "0ED58E6DD6C369530B281C7544741465")
    public Message obtainMessageOOO(int what, Object arg1, Object arg2, Object arg3) {
        addTaint(arg3.getTaint());
        addTaint(arg2.getTaint());
        addTaint(arg1.getTaint());
        addTaint(what);
        SomeArgs args = obtainArgs();
        args.arg1 = arg1;
        args.arg2 = arg2;
        args.arg3 = arg3;
Message varA09BA0A68969A0A00DFB7B824079B8FE_1813569007 =         mH.obtainMessage(what, 0, 0, args);
        varA09BA0A68969A0A00DFB7B824079B8FE_1813569007.addTaint(taint);
        return varA09BA0A68969A0A00DFB7B824079B8FE_1813569007;
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg1;
        //args.arg2 = arg2;
        //args.arg3 = arg3;
        //return mH.obtainMessage(what, 0, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.503 -0400", hash_original_method = "43873BAF9CC556751B2F5A72A399C999", hash_generated_method = "95F0720D1C517692B1A3A96E65DEBD5D")
    public Message obtainMessageOOOO(int what, Object arg1, Object arg2,
            Object arg3, Object arg4) {
        addTaint(arg4.getTaint());
        addTaint(arg3.getTaint());
        addTaint(arg2.getTaint());
        addTaint(arg1.getTaint());
        addTaint(what);
        SomeArgs args = obtainArgs();
        args.arg1 = arg1;
        args.arg2 = arg2;
        args.arg3 = arg3;
        args.arg4 = arg4;
Message varA09BA0A68969A0A00DFB7B824079B8FE_1389601579 =         mH.obtainMessage(what, 0, 0, args);
        varA09BA0A68969A0A00DFB7B824079B8FE_1389601579.addTaint(taint);
        return varA09BA0A68969A0A00DFB7B824079B8FE_1389601579;
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg1;
        //args.arg2 = arg2;
        //args.arg3 = arg3;
        //args.arg4 = arg4;
        //return mH.obtainMessage(what, 0, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.503 -0400", hash_original_method = "1D875093D7ACE086FCDFA3A9B952F51E", hash_generated_method = "D1BCEA4B81191A1D4AF436FC7E76BBA4")
    public Message obtainMessageIIII(int what, int arg1, int arg2,
            int arg3, int arg4) {
        addTaint(arg4);
        addTaint(arg3);
        addTaint(arg2);
        addTaint(arg1);
        addTaint(what);
        SomeArgs args = obtainArgs();
        args.argi1 = arg1;
        args.argi2 = arg2;
        args.argi3 = arg3;
        args.argi4 = arg4;
Message varA09BA0A68969A0A00DFB7B824079B8FE_771242192 =         mH.obtainMessage(what, 0, 0, args);
        varA09BA0A68969A0A00DFB7B824079B8FE_771242192.addTaint(taint);
        return varA09BA0A68969A0A00DFB7B824079B8FE_771242192;
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.argi1 = arg1;
        //args.argi2 = arg2;
        //args.argi3 = arg3;
        //args.argi4 = arg4;
        //return mH.obtainMessage(what, 0, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.503 -0400", hash_original_method = "3AF5B3474072AA5DC94AC3405EBF7B29", hash_generated_method = "54E406E3C558C45C4D8F15DB92A9A2C1")
    public Message obtainMessageIIIIII(int what, int arg1, int arg2,
            int arg3, int arg4, int arg5, int arg6) {
        addTaint(arg6);
        addTaint(arg5);
        addTaint(arg4);
        addTaint(arg3);
        addTaint(arg2);
        addTaint(arg1);
        addTaint(what);
        SomeArgs args = obtainArgs();
        args.argi1 = arg1;
        args.argi2 = arg2;
        args.argi3 = arg3;
        args.argi4 = arg4;
        args.argi5 = arg5;
        args.argi6 = arg6;
Message varA09BA0A68969A0A00DFB7B824079B8FE_1634197956 =         mH.obtainMessage(what, 0, 0, args);
        varA09BA0A68969A0A00DFB7B824079B8FE_1634197956.addTaint(taint);
        return varA09BA0A68969A0A00DFB7B824079B8FE_1634197956;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.503 -0400", hash_original_method = "1605D92F345EA1B31CBE383F462424A6", hash_generated_method = "C478A6EBE33F7FAD8B6DCD195FDF3BAA")
    public Message obtainMessageIIIIO(int what, int arg1, int arg2,
            int arg3, int arg4, Object arg5) {
        addTaint(arg5.getTaint());
        addTaint(arg4);
        addTaint(arg3);
        addTaint(arg2);
        addTaint(arg1);
        addTaint(what);
        SomeArgs args = obtainArgs();
        args.arg1 = arg5;
        args.argi1 = arg1;
        args.argi2 = arg2;
        args.argi3 = arg3;
        args.argi4 = arg4;
Message varA09BA0A68969A0A00DFB7B824079B8FE_901145747 =         mH.obtainMessage(what, 0, 0, args);
        varA09BA0A68969A0A00DFB7B824079B8FE_901145747.addTaint(taint);
        return varA09BA0A68969A0A00DFB7B824079B8FE_901145747;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.504 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "11484F719FF74608D959420C9A963381")

        SomeArgs next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.504 -0400", hash_original_field = "E866231598ED4CB18BE5E493240A11B0", hash_generated_field = "F8BED0DABC2D7EE357C5667A5634389E")

        public Object arg1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.504 -0400", hash_original_field = "80A26383E00E892C98EBD598EDCC5DBB", hash_generated_field = "1AFBA2F52DF215183028C3B28AF50E99")

        public Object arg2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.504 -0400", hash_original_field = "3B6478E2D54B4966388CFD33E5E87F78", hash_generated_field = "32BD50E19A34192D3D8DCA48249F94D1")

        public Object arg3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.504 -0400", hash_original_field = "A30A2FC110BD4D958948CA25C30EA076", hash_generated_field = "0B72EB80252CC488C537B500CEB079FF")

        public Object arg4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.504 -0400", hash_original_field = "45EA0AE08E2E96F45B382FC093F32969", hash_generated_field = "FE0C48289B39F618BBE80AECCEF49180")

        public int argi1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.504 -0400", hash_original_field = "AD47A7F028721D8AB76072E225148A71", hash_generated_field = "719DADFF01419F95FA55604041F222BD")

        public int argi2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.504 -0400", hash_original_field = "14D7B84204F2BD6B05340ABF4F0B2AAB", hash_generated_field = "52D274C1AF69DED7FCB42CCCFE797C8A")

        public int argi3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.504 -0400", hash_original_field = "E75D3302A59E1959DB780A5A325B7C45", hash_generated_field = "D2E6B4388CD4F0A3834E1C138D70FE7A")

        public int argi4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.504 -0400", hash_original_field = "EE5EA28C3B85C0B9EA692EFB058FE7B8", hash_generated_field = "6A0B669EF9423FB5FE4F93600C0FAB3B")

        public int argi5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.504 -0400", hash_original_field = "86DD46FF92F86F15DB9BD5F1009F88E1", hash_generated_field = "CDD9FE68E7B33662034DE6F2DF8370F4")

        public int argi6;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.504 -0400", hash_original_method = "C08D0E88500332C6E0DD16EFE525CF46", hash_generated_method = "C08D0E88500332C6E0DD16EFE525CF46")
        public SomeArgs ()
        {
            //Synthesized constructor
        }


    }


    
    class MyHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.504 -0400", hash_original_method = "761ACCB2E72A1319CE4B08F794806580", hash_generated_method = "A640814F3C00E3175ECDA66EED93DC88")
          MyHandler(Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.504 -0400", hash_original_method = "2ADED77FEF883BE82C94E7C39AB99489", hash_generated_method = "CD2909E422C83C96C1F2638E825548F4")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
            mCallback.executeMessage(msg);
            // ---------- Original Method ----------
            //mCallback.executeMessage(msg);
        }

        
    }


    
    public interface Callback {
        public void executeMessage(Message msg);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.504 -0400", hash_original_field = "E6BDB2C205BE7B8612B519CD3335BAE9", hash_generated_field = "0E1C08BBBBDD5ED1C472D14EF0FD5ED7")

    private static final String TAG = "HandlerCaller";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.504 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.504 -0400", hash_original_field = "66D25C509C66E34799882B63277157A0", hash_generated_field = "BCD6C0D163D104E26E069F7BB45809FA")

    static final int ARGS_POOL_MAX_SIZE = 10;
}


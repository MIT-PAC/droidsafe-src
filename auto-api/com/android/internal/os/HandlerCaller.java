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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.370 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "DE8577C1C990964647332D172A1FAC00")

    public Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.370 -0400", hash_original_field = "6C2EA91B438529F1372D806717F5AE04", hash_generated_field = "22AA67C96F8F7AD7DFD89E53DF216F9A")

    Looper mMainLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.370 -0400", hash_original_field = "6D1DA64E705BB119454CD3D6A13CB760", hash_generated_field = "CE7101CE6F8628D8EDF694C2A9A74F21")

    Handler mH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.370 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "1A99E72B6409E38FBCC780D1BAB4898D")

    Callback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.370 -0400", hash_original_field = "BCE6D68C369762660B24A79B1325E5A8", hash_generated_field = "1C9F48D10ECE38E6D9CD4E1243016544")

    int mArgsPoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.370 -0400", hash_original_field = "501F4E68AECE332CAF9C8A8B22C17758", hash_generated_field = "5ED907D190BACFFA2B993A486EE65501")

    SomeArgs mArgsPool;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.378 -0400", hash_original_method = "DC16108BBC1F4203D38999AB9D8A499B", hash_generated_method = "E8E0DE8D7064D85995E397D6F81C7E4B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.384 -0400", hash_original_method = "1F1A7E5A9C662CFE3468FAA77D6AFFBC", hash_generated_method = "D622C1006F98FB5D313D40384C623E11")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.385 -0400", hash_original_method = "C7D786B1A8326469A6C4DF3167D826A7", hash_generated_method = "60EB5C1C60FD047B57313A28412F1408")
    public SomeArgs obtainArgs() {
        SomeArgs varB4EAC82CA7396A68D541C85D26508E83_2093339263 = null; //Variable for return #1
        SomeArgs varB4EAC82CA7396A68D541C85D26508E83_1364574612 = null; //Variable for return #2
        {
            SomeArgs args;
            args = mArgsPool;
            {
                mArgsPool = args.next;
                args.next = null;
                varB4EAC82CA7396A68D541C85D26508E83_2093339263 = args;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1364574612 = new SomeArgs();
        SomeArgs varA7E53CE21691AB073D9660D615818899_1269948069; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1269948069 = varB4EAC82CA7396A68D541C85D26508E83_2093339263;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1269948069 = varB4EAC82CA7396A68D541C85D26508E83_1364574612;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1269948069.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1269948069;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.385 -0400", hash_original_method = "E4D2DD64F276F5C1793412D257C8C8A2", hash_generated_method = "94FB33DE5CFCE949A978443A9476C797")
    public void recycleArgs(SomeArgs args) {
        {
            {
                args.next = mArgsPool;
                mArgsPool = args;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.395 -0400", hash_original_method = "1A5A4A70D9C2B06EE3F275C367F3D9A3", hash_generated_method = "9C8893502A92B2198752A386F531570F")
    public void executeOrSendMessage(Message msg) {
        {
            boolean varAFACA4F92DB746B2983C428CA25E9018_1728514396 = (Looper.myLooper() == mMainLooper);
            {
                mCallback.executeMessage(msg);
                msg.recycle();
            } //End block
        } //End collapsed parenthetic
        mH.sendMessage(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //if (Looper.myLooper() == mMainLooper) {
            //mCallback.executeMessage(msg);
            //msg.recycle();
            //return;
        //}
        //mH.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.395 -0400", hash_original_method = "F78BB031B72C384E22E1C588BE9C4554", hash_generated_method = "BE70DD2263F96638C1235DB3C7FF9E50")
    public boolean hasMessages(int what) {
        boolean var04E4FEC2AB754AB398ED7BC1DC2628AC_74904055 = (mH.hasMessages(what));
        addTaint(what);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1460410394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1460410394;
        // ---------- Original Method ----------
        //return mH.hasMessages(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.395 -0400", hash_original_method = "C5E4F3B1776B7453A41B5A4B222B3CB0", hash_generated_method = "D1A9EC6DE98E8ADCC8FA0507F193E44D")
    public void removeMessages(int what) {
        mH.removeMessages(what);
        addTaint(what);
        // ---------- Original Method ----------
        //mH.removeMessages(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.396 -0400", hash_original_method = "9AA1640CA16A58F0D0EB8CAC0A40B330", hash_generated_method = "7E9F14A6DC78F3D01967C980B0D2408B")
    public void removeMessages(int what, Object obj) {
        mH.removeMessages(what, obj);
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //mH.removeMessages(what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.396 -0400", hash_original_method = "89209D6CF250959A1CD788CD1CB7EB84", hash_generated_method = "3103FD2458A4E73BCF81CCBB4C022677")
    public void sendMessage(Message msg) {
        mH.sendMessage(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //mH.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.396 -0400", hash_original_method = "92301CED384526FAE2562FC8E2BD0E1D", hash_generated_method = "0AE00666F28EC48025E07CA50EC08800")
    public Message obtainMessage(int what) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1734331817 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1734331817 = mH.obtainMessage(what);
        addTaint(what);
        varB4EAC82CA7396A68D541C85D26508E83_1734331817.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1734331817;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.397 -0400", hash_original_method = "9B5888B6830AED9D93456049A7F2C369", hash_generated_method = "F500C45B0A7E4274E5BA95D2959278DB")
    public Message obtainMessageBO(int what, boolean arg1, Object arg2) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1759455595 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1759455595 = mH.obtainMessage(what, arg1 ? 1 : 0, 0, arg2);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1759455595.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1759455595;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1 ? 1 : 0, 0, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.402 -0400", hash_original_method = "EB72AC22C9F7D2FB44688CD09996973C", hash_generated_method = "CACD96C863FC974D976010F0846DB73E")
    public Message obtainMessageBOO(int what, boolean arg1, Object arg2, Object arg3) {
        Message varB4EAC82CA7396A68D541C85D26508E83_2089913152 = null; //Variable for return #1
        SomeArgs args;
        args = obtainArgs();
        args.arg1 = arg2;
        args.arg2 = arg3;
        varB4EAC82CA7396A68D541C85D26508E83_2089913152 = mH.obtainMessage(what, arg1 ? 1 : 0, 0, args);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2.getTaint());
        addTaint(arg3.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2089913152.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2089913152;
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg2;
        //args.arg2 = arg3;
        //return mH.obtainMessage(what, arg1 ? 1 : 0, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.418 -0400", hash_original_method = "E41B1E1C050A3613D52D3D6F2431F5B0", hash_generated_method = "0A41ACB4081AF3EC99F3A551317CFA3F")
    public Message obtainMessageO(int what, Object arg1) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1230095368 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1230095368 = mH.obtainMessage(what, 0, 0, arg1);
        addTaint(what);
        addTaint(arg1.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1230095368.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1230095368;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, 0, 0, arg1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.419 -0400", hash_original_method = "5C01371734D93F096340C1C928E9C4EB", hash_generated_method = "6240DE907466AFCB3FA126F55FC1B56C")
    public Message obtainMessageI(int what, int arg1) {
        Message varB4EAC82CA7396A68D541C85D26508E83_947988314 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_947988314 = mH.obtainMessage(what, arg1, 0);
        addTaint(what);
        addTaint(arg1);
        varB4EAC82CA7396A68D541C85D26508E83_947988314.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_947988314;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.419 -0400", hash_original_method = "1D375F3B5B7A421102D544B0D8C99910", hash_generated_method = "663DD26D2D514CE473BA1AB72156C3DA")
    public Message obtainMessageII(int what, int arg1, int arg2) {
        Message varB4EAC82CA7396A68D541C85D26508E83_147334422 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_147334422 = mH.obtainMessage(what, arg1, arg2);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        varB4EAC82CA7396A68D541C85D26508E83_147334422.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_147334422;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.420 -0400", hash_original_method = "BDB545C9895C4A044C116EE5375794DB", hash_generated_method = "BA5F915746E0A9FC443CAC63948DD247")
    public Message obtainMessageIO(int what, int arg1, Object arg2) {
        Message varB4EAC82CA7396A68D541C85D26508E83_318958674 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_318958674 = mH.obtainMessage(what, arg1, 0, arg2);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_318958674.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_318958674;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, 0, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.420 -0400", hash_original_method = "C859EEB4CE33BF0B4768A3A7456BD68F", hash_generated_method = "F8512E0CE4315894C0417ACD90538275")
    public Message obtainMessageIIO(int what, int arg1, int arg2, Object arg3) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1477964209 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1477964209 = mH.obtainMessage(what, arg1, arg2, arg3);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        addTaint(arg3.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1477964209.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1477964209;
        // ---------- Original Method ----------
        //return mH.obtainMessage(what, arg1, arg2, arg3);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.421 -0400", hash_original_method = "BCB5A1A15368DDA8D81813390243701E", hash_generated_method = "04051EDFBC464A890E2F279DB8BAAB9D")
    public Message obtainMessageIIOO(int what, int arg1, int arg2,
            Object arg3, Object arg4) {
        Message varB4EAC82CA7396A68D541C85D26508E83_602946305 = null; //Variable for return #1
        SomeArgs args;
        args = obtainArgs();
        args.arg1 = arg3;
        args.arg2 = arg4;
        varB4EAC82CA7396A68D541C85D26508E83_602946305 = mH.obtainMessage(what, arg1, arg2, args);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        addTaint(arg3.getTaint());
        addTaint(arg4.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_602946305.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_602946305;
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg3;
        //args.arg2 = arg4;
        //return mH.obtainMessage(what, arg1, arg2, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.421 -0400", hash_original_method = "CB509D134FCA9E5B151CFC9C40C64D1B", hash_generated_method = "60509E373A0862008712E5D5F522A552")
    public Message obtainMessageIOO(int what, int arg1, Object arg2, Object arg3) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1262426592 = null; //Variable for return #1
        SomeArgs args;
        args = obtainArgs();
        args.arg1 = arg2;
        args.arg2 = arg3;
        varB4EAC82CA7396A68D541C85D26508E83_1262426592 = mH.obtainMessage(what, arg1, 0, args);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2.getTaint());
        addTaint(arg3.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1262426592.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1262426592;
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg2;
        //args.arg2 = arg3;
        //return mH.obtainMessage(what, arg1, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.422 -0400", hash_original_method = "36F936CCD9DE9DB810A79A5E8B7C79D8", hash_generated_method = "C10867C00EFFD4A67ADE3BE379F4877D")
    public Message obtainMessageOO(int what, Object arg1, Object arg2) {
        Message varB4EAC82CA7396A68D541C85D26508E83_962867535 = null; //Variable for return #1
        SomeArgs args;
        args = obtainArgs();
        args.arg1 = arg1;
        args.arg2 = arg2;
        varB4EAC82CA7396A68D541C85D26508E83_962867535 = mH.obtainMessage(what, 0, 0, args);
        addTaint(what);
        addTaint(arg1.getTaint());
        addTaint(arg2.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_962867535.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_962867535;
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg1;
        //args.arg2 = arg2;
        //return mH.obtainMessage(what, 0, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.432 -0400", hash_original_method = "7B7B88DAF1A325732DD11D87B8FA8090", hash_generated_method = "5CB1C9D592BE1B917E52253F12814037")
    public Message obtainMessageOOO(int what, Object arg1, Object arg2, Object arg3) {
        Message varB4EAC82CA7396A68D541C85D26508E83_627309814 = null; //Variable for return #1
        SomeArgs args;
        args = obtainArgs();
        args.arg1 = arg1;
        args.arg2 = arg2;
        args.arg3 = arg3;
        varB4EAC82CA7396A68D541C85D26508E83_627309814 = mH.obtainMessage(what, 0, 0, args);
        addTaint(what);
        addTaint(arg1.getTaint());
        addTaint(arg2.getTaint());
        addTaint(arg3.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_627309814.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_627309814;
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg1;
        //args.arg2 = arg2;
        //args.arg3 = arg3;
        //return mH.obtainMessage(what, 0, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.433 -0400", hash_original_method = "43873BAF9CC556751B2F5A72A399C999", hash_generated_method = "C706D50C12FFED9FAB78B9A2254B3359")
    public Message obtainMessageOOOO(int what, Object arg1, Object arg2,
            Object arg3, Object arg4) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1044960271 = null; //Variable for return #1
        SomeArgs args;
        args = obtainArgs();
        args.arg1 = arg1;
        args.arg2 = arg2;
        args.arg3 = arg3;
        args.arg4 = arg4;
        varB4EAC82CA7396A68D541C85D26508E83_1044960271 = mH.obtainMessage(what, 0, 0, args);
        addTaint(what);
        addTaint(arg1.getTaint());
        addTaint(arg2.getTaint());
        addTaint(arg3.getTaint());
        addTaint(arg4.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1044960271.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1044960271;
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.arg1 = arg1;
        //args.arg2 = arg2;
        //args.arg3 = arg3;
        //args.arg4 = arg4;
        //return mH.obtainMessage(what, 0, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.434 -0400", hash_original_method = "1D875093D7ACE086FCDFA3A9B952F51E", hash_generated_method = "7FB740C4FAA36929AAE672AEA16B9269")
    public Message obtainMessageIIII(int what, int arg1, int arg2,
            int arg3, int arg4) {
        Message varB4EAC82CA7396A68D541C85D26508E83_534263326 = null; //Variable for return #1
        SomeArgs args;
        args = obtainArgs();
        args.argi1 = arg1;
        args.argi2 = arg2;
        args.argi3 = arg3;
        args.argi4 = arg4;
        varB4EAC82CA7396A68D541C85D26508E83_534263326 = mH.obtainMessage(what, 0, 0, args);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        addTaint(arg3);
        addTaint(arg4);
        varB4EAC82CA7396A68D541C85D26508E83_534263326.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_534263326;
        // ---------- Original Method ----------
        //SomeArgs args = obtainArgs();
        //args.argi1 = arg1;
        //args.argi2 = arg2;
        //args.argi3 = arg3;
        //args.argi4 = arg4;
        //return mH.obtainMessage(what, 0, 0, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.438 -0400", hash_original_method = "3AF5B3474072AA5DC94AC3405EBF7B29", hash_generated_method = "363116EB23365E589F746290D0B1927C")
    public Message obtainMessageIIIIII(int what, int arg1, int arg2,
            int arg3, int arg4, int arg5, int arg6) {
        Message varB4EAC82CA7396A68D541C85D26508E83_13619165 = null; //Variable for return #1
        SomeArgs args;
        args = obtainArgs();
        args.argi1 = arg1;
        args.argi2 = arg2;
        args.argi3 = arg3;
        args.argi4 = arg4;
        args.argi5 = arg5;
        args.argi6 = arg6;
        varB4EAC82CA7396A68D541C85D26508E83_13619165 = mH.obtainMessage(what, 0, 0, args);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        addTaint(arg3);
        addTaint(arg4);
        addTaint(arg5);
        addTaint(arg6);
        varB4EAC82CA7396A68D541C85D26508E83_13619165.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_13619165;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.439 -0400", hash_original_method = "1605D92F345EA1B31CBE383F462424A6", hash_generated_method = "5CF5FBD926704CF3ACEEFA179E66D394")
    public Message obtainMessageIIIIO(int what, int arg1, int arg2,
            int arg3, int arg4, Object arg5) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1246311324 = null; //Variable for return #1
        SomeArgs args;
        args = obtainArgs();
        args.arg1 = arg5;
        args.argi1 = arg1;
        args.argi2 = arg2;
        args.argi3 = arg3;
        args.argi4 = arg4;
        varB4EAC82CA7396A68D541C85D26508E83_1246311324 = mH.obtainMessage(what, 0, 0, args);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        addTaint(arg3);
        addTaint(arg4);
        addTaint(arg5.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1246311324.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1246311324;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.439 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "11484F719FF74608D959420C9A963381")

        SomeArgs next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.439 -0400", hash_original_field = "E866231598ED4CB18BE5E493240A11B0", hash_generated_field = "F8BED0DABC2D7EE357C5667A5634389E")

        public Object arg1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.439 -0400", hash_original_field = "80A26383E00E892C98EBD598EDCC5DBB", hash_generated_field = "1AFBA2F52DF215183028C3B28AF50E99")

        public Object arg2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.442 -0400", hash_original_field = "3B6478E2D54B4966388CFD33E5E87F78", hash_generated_field = "32BD50E19A34192D3D8DCA48249F94D1")

        public Object arg3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.443 -0400", hash_original_field = "A30A2FC110BD4D958948CA25C30EA076", hash_generated_field = "0B72EB80252CC488C537B500CEB079FF")

        public Object arg4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.443 -0400", hash_original_field = "45EA0AE08E2E96F45B382FC093F32969", hash_generated_field = "FE0C48289B39F618BBE80AECCEF49180")

        public int argi1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.443 -0400", hash_original_field = "AD47A7F028721D8AB76072E225148A71", hash_generated_field = "719DADFF01419F95FA55604041F222BD")

        public int argi2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.443 -0400", hash_original_field = "14D7B84204F2BD6B05340ABF4F0B2AAB", hash_generated_field = "52D274C1AF69DED7FCB42CCCFE797C8A")

        public int argi3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.443 -0400", hash_original_field = "E75D3302A59E1959DB780A5A325B7C45", hash_generated_field = "D2E6B4388CD4F0A3834E1C138D70FE7A")

        public int argi4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.443 -0400", hash_original_field = "EE5EA28C3B85C0B9EA692EFB058FE7B8", hash_generated_field = "6A0B669EF9423FB5FE4F93600C0FAB3B")

        public int argi5;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.443 -0400", hash_original_field = "86DD46FF92F86F15DB9BD5F1009F88E1", hash_generated_field = "CDD9FE68E7B33662034DE6F2DF8370F4")

        public int argi6;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.443 -0400", hash_original_method = "C08D0E88500332C6E0DD16EFE525CF46", hash_generated_method = "C08D0E88500332C6E0DD16EFE525CF46")
        public SomeArgs ()
        {
            //Synthesized constructor
        }


    }


    
    class MyHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.443 -0400", hash_original_method = "761ACCB2E72A1319CE4B08F794806580", hash_generated_method = "A640814F3C00E3175ECDA66EED93DC88")
          MyHandler(Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.445 -0400", hash_original_method = "2ADED77FEF883BE82C94E7C39AB99489", hash_generated_method = "95C0659F392706AADE53A79F4CFA28A1")
        @Override
        public void handleMessage(Message msg) {
            mCallback.executeMessage(msg);
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            //mCallback.executeMessage(msg);
        }

        
    }


    
    public interface Callback {
        public void executeMessage(Message msg);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.445 -0400", hash_original_field = "E6BDB2C205BE7B8612B519CD3335BAE9", hash_generated_field = "DEF6414708AB31002EAFF276D6096DF0")

    private static String TAG = "HandlerCaller";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.447 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:12.447 -0400", hash_original_field = "66D25C509C66E34799882B63277157A0", hash_generated_field = "FCB63BBCBDD11A51134D566EF75E79D9")

    static int ARGS_POOL_MAX_SIZE = 10;
}


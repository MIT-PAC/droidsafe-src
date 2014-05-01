package com.android.internal.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class HandlerCaller {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.242 -0500", hash_original_field = "5337AB2544F40575E26AE97B0BEEB191", hash_generated_field = "0E1C08BBBBDD5ED1C472D14EF0FD5ED7")

    private static final String TAG = "HandlerCaller";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.245 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.286 -0500", hash_original_field = "34377742E5970721907410D9B607AD0A", hash_generated_field = "BCD6C0D163D104E26E069F7BB45809FA")
    
    static final int ARGS_POOL_MAX_SIZE = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.247 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "DE8577C1C990964647332D172A1FAC00")
    
    public  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.249 -0500", hash_original_field = "22AA67C96F8F7AD7DFD89E53DF216F9A", hash_generated_field = "22AA67C96F8F7AD7DFD89E53DF216F9A")
    
     Looper mMainLooper;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.252 -0500", hash_original_field = "CE7101CE6F8628D8EDF694C2A9A74F21", hash_generated_field = "CE7101CE6F8628D8EDF694C2A9A74F21")

     Handler mH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.254 -0500", hash_original_field = "1A99E72B6409E38FBCC780D1BAB4898D", hash_generated_field = "1A99E72B6409E38FBCC780D1BAB4898D")

     Callback mCallback;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.289 -0500", hash_original_field = "1C9F48D10ECE38E6D9CD4E1243016544", hash_generated_field = "1C9F48D10ECE38E6D9CD4E1243016544")

    int mArgsPoolSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.291 -0500", hash_original_field = "5ED907D190BACFFA2B993A486EE65501", hash_generated_field = "5ED907D190BACFFA2B993A486EE65501")

    SomeArgs mArgsPool;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.303 -0500", hash_original_method = "DC16108BBC1F4203D38999AB9D8A499B", hash_generated_method = "2DBB2733D0FAE3A5B97C14EE918D3626")
    
public HandlerCaller(Context context, Callback callback) {
        mContext = context;
        mMainLooper = context.getMainLooper();
        mH = new MyHandler(mMainLooper);
        mCallback = callback;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.306 -0500", hash_original_method = "1F1A7E5A9C662CFE3468FAA77D6AFFBC", hash_generated_method = "863750A07ED2D2EFC66D153414A6AE84")
    
public HandlerCaller(Context context, Looper looper, Callback callback) {
        mContext = context;
        mMainLooper = looper;
        mH = new MyHandler(mMainLooper);
        mCallback = callback;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.308 -0500", hash_original_method = "C7D786B1A8326469A6C4DF3167D826A7", hash_generated_method = "E24882A2F8CF6BE8D9847526EA0B90E5")
    
public SomeArgs obtainArgs() {
        synchronized (mH) {
            SomeArgs args = mArgsPool;
            if (args != null) {
                mArgsPool = args.next;
                args.next = null;
                mArgsPoolSize--;
                return args;
            }
        }
        return new SomeArgs();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.312 -0500", hash_original_method = "E4D2DD64F276F5C1793412D257C8C8A2", hash_generated_method = "84E29FE6A5CFE575F3174CCBD2DEAA44")
    
public void recycleArgs(SomeArgs args) {
        synchronized (mH) {
            if (mArgsPoolSize < ARGS_POOL_MAX_SIZE) {
                args.next = mArgsPool;
                mArgsPool = args;
                mArgsPoolSize++;
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.314 -0500", hash_original_method = "1A5A4A70D9C2B06EE3F275C367F3D9A3", hash_generated_method = "ADC9BEE5E10C478755BBC5FB7FB435D3")
    
public void executeOrSendMessage(Message msg) {
        // If we are calling this from the main thread, then we can call
        // right through.  Otherwise, we need to send the message to the
        // main thread.
        if (Looper.myLooper() == mMainLooper) {
            mCallback.executeMessage(msg);
            msg.recycle();
            return;
        }
        
        mH.sendMessage(msg);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.317 -0500", hash_original_method = "F78BB031B72C384E22E1C588BE9C4554", hash_generated_method = "708A787E87C97D3A73C4B639BD80347C")
    
public boolean hasMessages(int what) {
        return mH.hasMessages(what);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.319 -0500", hash_original_method = "C5E4F3B1776B7453A41B5A4B222B3CB0", hash_generated_method = "E9C6A211EC15DC51D58B9A65C6DA9684")
    
public void removeMessages(int what) {
        mH.removeMessages(what);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.321 -0500", hash_original_method = "9AA1640CA16A58F0D0EB8CAC0A40B330", hash_generated_method = "5294A7DB385A0296D674AE7B78D56E21")
    
public void removeMessages(int what, Object obj) {
        mH.removeMessages(what, obj);
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.323 -0500", hash_original_method = "89209D6CF250959A1CD788CD1CB7EB84", hash_generated_method = "8B544D39D3E5715B3ECDDB1D5C7F3654")
    
public void sendMessage(Message msg) {
        mH.sendMessage(msg);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.325 -0500", hash_original_method = "92301CED384526FAE2562FC8E2BD0E1D", hash_generated_method = "C1293BC0B94C82E57D17015ADCB0C066")
    
public Message obtainMessage(int what) {
        return mH.obtainMessage(what);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.328 -0500", hash_original_method = "9B5888B6830AED9D93456049A7F2C369", hash_generated_method = "FC9D151C825129E20CAD7C0216CFB5D4")
    
public Message obtainMessageBO(int what, boolean arg1, Object arg2) {
        return mH.obtainMessage(what, arg1 ? 1 : 0, 0, arg2);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.331 -0500", hash_original_method = "EB72AC22C9F7D2FB44688CD09996973C", hash_generated_method = "8D6533E4A69254F6A71B45DB53225294")
    
public Message obtainMessageBOO(int what, boolean arg1, Object arg2, Object arg3) {
        SomeArgs args = obtainArgs();
        args.arg1 = arg2;
        args.arg2 = arg3;
        return mH.obtainMessage(what, arg1 ? 1 : 0, 0, args);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.334 -0500", hash_original_method = "E41B1E1C050A3613D52D3D6F2431F5B0", hash_generated_method = "79491A0002947F5331DAF8E22429A23E")
    
public Message obtainMessageO(int what, Object arg1) {
        return mH.obtainMessage(what, 0, 0, arg1);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.336 -0500", hash_original_method = "5C01371734D93F096340C1C928E9C4EB", hash_generated_method = "6614535EABD7CA96835447B6FA34713F")
    
public Message obtainMessageI(int what, int arg1) {
        return mH.obtainMessage(what, arg1, 0);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.339 -0500", hash_original_method = "1D375F3B5B7A421102D544B0D8C99910", hash_generated_method = "FC4ECBACAA288A03620B29254DFEE491")
    
public Message obtainMessageII(int what, int arg1, int arg2) {
        return mH.obtainMessage(what, arg1, arg2);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.342 -0500", hash_original_method = "BDB545C9895C4A044C116EE5375794DB", hash_generated_method = "9ECB0AD4CCF042E34A62456D673A0533")
    
public Message obtainMessageIO(int what, int arg1, Object arg2) {
        return mH.obtainMessage(what, arg1, 0, arg2);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.345 -0500", hash_original_method = "C859EEB4CE33BF0B4768A3A7456BD68F", hash_generated_method = "5E64C13726CDFE6E010C1141E3284D84")
    
public Message obtainMessageIIO(int what, int arg1, int arg2, Object arg3) {
        return mH.obtainMessage(what, arg1, arg2, arg3);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.347 -0500", hash_original_method = "BCB5A1A15368DDA8D81813390243701E", hash_generated_method = "6D9A68588AF8F2CDD3BF0BFDA9428954")
    
public Message obtainMessageIIOO(int what, int arg1, int arg2,
            Object arg3, Object arg4) {
        SomeArgs args = obtainArgs();
        args.arg1 = arg3;
        args.arg2 = arg4;
        return mH.obtainMessage(what, arg1, arg2, args);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.351 -0500", hash_original_method = "CB509D134FCA9E5B151CFC9C40C64D1B", hash_generated_method = "E2A6F6A42CFB25A77F28DE41B0C5D360")
    
public Message obtainMessageIOO(int what, int arg1, Object arg2, Object arg3) {
        SomeArgs args = obtainArgs();
        args.arg1 = arg2;
        args.arg2 = arg3;
        return mH.obtainMessage(what, arg1, 0, args);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.353 -0500", hash_original_method = "36F936CCD9DE9DB810A79A5E8B7C79D8", hash_generated_method = "4C8913689E7A9CDA133D80DE4EC2BAB2")
    
public Message obtainMessageOO(int what, Object arg1, Object arg2) {
        SomeArgs args = obtainArgs();
        args.arg1 = arg1;
        args.arg2 = arg2;
        return mH.obtainMessage(what, 0, 0, args);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.356 -0500", hash_original_method = "7B7B88DAF1A325732DD11D87B8FA8090", hash_generated_method = "C82D09F90609BD7563A092E89488DDA7")
    
public Message obtainMessageOOO(int what, Object arg1, Object arg2, Object arg3) {
        SomeArgs args = obtainArgs();
        args.arg1 = arg1;
        args.arg2 = arg2;
        args.arg3 = arg3;
        return mH.obtainMessage(what, 0, 0, args);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.358 -0500", hash_original_method = "43873BAF9CC556751B2F5A72A399C999", hash_generated_method = "7DC701010AC38C203A9D6C3932EFFB89")
    
public Message obtainMessageOOOO(int what, Object arg1, Object arg2,
            Object arg3, Object arg4) {
        SomeArgs args = obtainArgs();
        args.arg1 = arg1;
        args.arg2 = arg2;
        args.arg3 = arg3;
        args.arg4 = arg4;
        return mH.obtainMessage(what, 0, 0, args);
    }
    
    public static class SomeArgs {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.257 -0500", hash_original_field = "11484F719FF74608D959420C9A963381", hash_generated_field = "11484F719FF74608D959420C9A963381")

        SomeArgs next;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.259 -0500", hash_original_field = "524E284308787C3B27AB4CD560A816CF", hash_generated_field = "F8BED0DABC2D7EE357C5667A5634389E")
        
        public Object arg1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.262 -0500", hash_original_field = "2CC0C93F38D97721E695C73C9F8BA144", hash_generated_field = "1AFBA2F52DF215183028C3B28AF50E99")

        public Object arg2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.264 -0500", hash_original_field = "F56E40D616F19E7BF075AC7D5ACFE7F9", hash_generated_field = "32BD50E19A34192D3D8DCA48249F94D1")

        public Object arg3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.267 -0500", hash_original_field = "110AC7B6C385C5FEFA73505247A775D3", hash_generated_field = "0B72EB80252CC488C537B500CEB079FF")

        public Object arg4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.269 -0500", hash_original_field = "7F0B67CAA7215F665771089342F3DFC5", hash_generated_field = "FE0C48289B39F618BBE80AECCEF49180")

        public int argi1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.272 -0500", hash_original_field = "F1422FA73E9868B70AA2963A9422273F", hash_generated_field = "719DADFF01419F95FA55604041F222BD")

        public int argi2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.275 -0500", hash_original_field = "187B483800D059E986583827D0AD5CD5", hash_generated_field = "52D274C1AF69DED7FCB42CCCFE797C8A")

        public int argi3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.277 -0500", hash_original_field = "F11F8BD2887922A46A5D5562E88B306B", hash_generated_field = "D2E6B4388CD4F0A3834E1C138D70FE7A")

        public int argi4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.279 -0500", hash_original_field = "21DD335F5CEAE8AE91485453EDA375BC", hash_generated_field = "6A0B669EF9423FB5FE4F93600C0FAB3B")

        public int argi5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.281 -0500", hash_original_field = "D0688219C3DCED6A5722DDFD8AD664C7", hash_generated_field = "CDD9FE68E7B33662034DE6F2DF8370F4")

        public int argi6;
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.504 -0400", hash_original_method = "C08D0E88500332C6E0DD16EFE525CF46", hash_generated_method = "C08D0E88500332C6E0DD16EFE525CF46")
        public SomeArgs ()
        {
            //Synthesized constructor
        }

    }
    
    class MyHandler extends Handler {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.294 -0500", hash_original_method = "761ACCB2E72A1319CE4B08F794806580", hash_generated_method = "761ACCB2E72A1319CE4B08F794806580")
        
MyHandler(Looper looper) {
            super(looper);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.296 -0500", hash_original_method = "2ADED77FEF883BE82C94E7C39AB99489", hash_generated_method = "6B32D686C1E8E7F576BB7862DADC6535")
        
@Override
        public void handleMessage(Message msg) {
            mCallback.executeMessage(msg);
        }
        
    }
    
    public interface Callback {
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void executeMessage(Message msg);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.361 -0500", hash_original_method = "1D875093D7ACE086FCDFA3A9B952F51E", hash_generated_method = "0C28DB044155CDE72FF2FD085CD9B2D6")
    
public Message obtainMessageIIII(int what, int arg1, int arg2,
            int arg3, int arg4) {
        SomeArgs args = obtainArgs();
        args.argi1 = arg1;
        args.argi2 = arg2;
        args.argi3 = arg3;
        args.argi4 = arg4;
        return mH.obtainMessage(what, 0, 0, args);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.363 -0500", hash_original_method = "3AF5B3474072AA5DC94AC3405EBF7B29", hash_generated_method = "B22FDA6B5C547FFDA56612B7D52589DC")
    
public Message obtainMessageIIIIII(int what, int arg1, int arg2,
            int arg3, int arg4, int arg5, int arg6) {
        SomeArgs args = obtainArgs();
        args.argi1 = arg1;
        args.argi2 = arg2;
        args.argi3 = arg3;
        args.argi4 = arg4;
        args.argi5 = arg5;
        args.argi6 = arg6;
        return mH.obtainMessage(what, 0, 0, args);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:53.366 -0500", hash_original_method = "1605D92F345EA1B31CBE383F462424A6", hash_generated_method = "33370CDD77A07A070E4E02E5F179931B")
    
public Message obtainMessageIIIIO(int what, int arg1, int arg2,
            int arg3, int arg4, Object arg5) {
        SomeArgs args = obtainArgs();
        args.arg1 = arg5;
        args.argi1 = arg1;
        args.argi2 = arg2;
        args.argi3 = arg3;
        args.argi4 = arg4;
        return mH.obtainMessage(what, 0, 0, args);
    }
}


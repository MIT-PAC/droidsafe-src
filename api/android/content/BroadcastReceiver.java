package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.ActivityManagerNative;
import android.app.ActivityThread;
import android.app.IActivityManager;
import android.app.QueuedWork;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.util.Slog;

public abstract class BroadcastReceiver {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.168 -0400", hash_original_field = "6DD50A78846A573507CD3027E97E1EA6", hash_generated_field = "56CC6D10D54B274449EA4D95649A29AE")

    private PendingResult mPendingResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.168 -0400", hash_original_field = "531E6956D9AF6ECA54301749A881CFAD", hash_generated_field = "D63712D72C7DEA3780B2E3ED680A7016")

    private boolean mDebugUnregister;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.168 -0400", hash_original_method = "2900F07960080430406180ADD3872CDD", hash_generated_method = "4949473B0E069ABC52AE38A1EB5EC2B1")
    public  BroadcastReceiver() {
        // ---------- Original Method ----------
    }

    
    public abstract void onReceive(Context context, Intent intent);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.169 -0400", hash_original_method = "A694EC135053AF2FEB071A12D3EE4319", hash_generated_method = "35D0D4889F216A91DEE118FB3A3AC0BE")
    public final PendingResult goAsync() {
        PendingResult res = mPendingResult;
        mPendingResult = null;
PendingResult varB5053E025797B3BF768F5C37934C244D_614416928 =         res;
        varB5053E025797B3BF768F5C37934C244D_614416928.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_614416928;
        // ---------- Original Method ----------
        //PendingResult res = mPendingResult;
        //mPendingResult = null;
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.171 -0400", hash_original_method = "891D062EE6B5DF300B0D5F817EBA802C", hash_generated_method = "AA2A5E2A0F2DE833ACB97A78D9DBEE0A")
    public IBinder peekService(Context myContext, Intent service) {
        addTaint(service.getTaint());
        addTaint(myContext.getTaint());
        IActivityManager am = ActivityManagerNative.getDefault();
        IBinder binder = null;
        try 
        {
            service.setAllowFds(false);
            binder = am.peekService(service, service.resolveTypeIfNeeded(
                    myContext.getContentResolver()));
        } //End block
        catch (RemoteException e)
        {
        } //End block
IBinder varE3C074C8A98249A08331B334269AEB91_1973532220 =         binder;
        varE3C074C8A98249A08331B334269AEB91_1973532220.addTaint(taint);
        return varE3C074C8A98249A08331B334269AEB91_1973532220;
        // ---------- Original Method ----------
        //IActivityManager am = ActivityManagerNative.getDefault();
        //IBinder binder = null;
        //try {
            //service.setAllowFds(false);
            //binder = am.peekService(service, service.resolveTypeIfNeeded(
                    //myContext.getContentResolver()));
        //} catch (RemoteException e) {
        //}
        //return binder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.172 -0400", hash_original_method = "D9C6679B9D8E9806D41E73EFA120BCFE", hash_generated_method = "D8B058A84574659F09A9DE8C943A316A")
    public final void setResultCode(int code) {
        checkSynchronousHint();
        mPendingResult.mResultCode = code;
        // ---------- Original Method ----------
        //checkSynchronousHint();
        //mPendingResult.mResultCode = code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.173 -0400", hash_original_method = "413D4442793CB2CD30088D833172245E", hash_generated_method = "E2C81F311B8AED28F50D2A23A413AB67")
    public final int getResultCode() {
        int var2B2BA4CA037129453C2092D8613C9F0D_757303258 = (mPendingResult != null ? mPendingResult.mResultCode : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1324523320 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1324523320;
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mResultCode : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.174 -0400", hash_original_method = "326C45A93CAC69AE5F40CC5662FD4E21", hash_generated_method = "C90A109DB604318B2505A1C010330879")
    public final void setResultData(String data) {
        checkSynchronousHint();
        mPendingResult.mResultData = data;
        // ---------- Original Method ----------
        //checkSynchronousHint();
        //mPendingResult.mResultData = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.174 -0400", hash_original_method = "4500B5844C9E31997AA4128C2B631832", hash_generated_method = "093228BC6C47179261C3FA89F0685E27")
    public final String getResultData() {
String var6A28DDDD6F2A36E80C7DF082C1A737CB_1018902120 =         mPendingResult != null ? mPendingResult.mResultData : null;
        var6A28DDDD6F2A36E80C7DF082C1A737CB_1018902120.addTaint(taint);
        return var6A28DDDD6F2A36E80C7DF082C1A737CB_1018902120;
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mResultData : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.175 -0400", hash_original_method = "A002D9C66CF7F2AA1D1827503AAC99EC", hash_generated_method = "AE999306C66D9D7D9F87E31E8790C266")
    public final void setResultExtras(Bundle extras) {
        checkSynchronousHint();
        mPendingResult.mResultExtras = extras;
        // ---------- Original Method ----------
        //checkSynchronousHint();
        //mPendingResult.mResultExtras = extras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.176 -0400", hash_original_method = "4CB90710C7A856F1CF5FAF169A56650C", hash_generated_method = "52E0AD0BABDF8FB259E997ED988D1D8B")
    public final Bundle getResultExtras(boolean makeMap) {
        addTaint(makeMap);
    if(mPendingResult == null)        
        {
Bundle var540C13E9E156B687226421B24F2DF178_331679129 =             null;
            var540C13E9E156B687226421B24F2DF178_331679129.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_331679129;
        } //End block
        Bundle e = mPendingResult.mResultExtras;
    if(!makeMap)        
        {
Bundle var6BFFBFA2F1D556BA80433C2335198CE9_2008015823 =         e;
        var6BFFBFA2F1D556BA80433C2335198CE9_2008015823.addTaint(taint);
        return var6BFFBFA2F1D556BA80433C2335198CE9_2008015823;
        }
    if(e == null)        
        mPendingResult.mResultExtras = e = new Bundle();
Bundle var6BFFBFA2F1D556BA80433C2335198CE9_1505566534 =         e;
        var6BFFBFA2F1D556BA80433C2335198CE9_1505566534.addTaint(taint);
        return var6BFFBFA2F1D556BA80433C2335198CE9_1505566534;
        // ---------- Original Method ----------
        //if (mPendingResult == null) {
            //return null;
        //}
        //Bundle e = mPendingResult.mResultExtras;
        //if (!makeMap) return e;
        //if (e == null) mPendingResult.mResultExtras = e = new Bundle();
        //return e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.177 -0400", hash_original_method = "71BA20FC3DD345B39DB950803A39A1ED", hash_generated_method = "4E29E8202B08EC6E81632318D3263996")
    public final void setResult(int code, String data, Bundle extras) {
        checkSynchronousHint();
        mPendingResult.mResultCode = code;
        mPendingResult.mResultData = data;
        mPendingResult.mResultExtras = extras;
        // ---------- Original Method ----------
        //checkSynchronousHint();
        //mPendingResult.mResultCode = code;
        //mPendingResult.mResultData = data;
        //mPendingResult.mResultExtras = extras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.178 -0400", hash_original_method = "AC60D9C3BD95277DA035DD6FF45A8CCB", hash_generated_method = "614D155200EBE734A23D9A00D2D73617")
    public final boolean getAbortBroadcast() {
        boolean var52C3658BA601DC218244C3815749219A_484297388 = (mPendingResult != null ? mPendingResult.mAbortBroadcast : false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1842651010 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1842651010;
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mAbortBroadcast : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.179 -0400", hash_original_method = "EA4258D43E5FA594C300ACFA62523E77", hash_generated_method = "6C8DB09AA240CF4D79E5212B6813BBD7")
    public final void abortBroadcast() {
        checkSynchronousHint();
        mPendingResult.mAbortBroadcast = true;
        // ---------- Original Method ----------
        //checkSynchronousHint();
        //mPendingResult.mAbortBroadcast = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.180 -0400", hash_original_method = "7C3FDE5990F70723754AFB92AED4E2CB", hash_generated_method = "CC309946A2203D49B8CD5BCA74F2152C")
    public final void clearAbortBroadcast() {
    if(mPendingResult != null)        
        {
            mPendingResult.mAbortBroadcast = false;
        } //End block
        // ---------- Original Method ----------
        //if (mPendingResult != null) {
            //mPendingResult.mAbortBroadcast = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.181 -0400", hash_original_method = "E46A4317E3055902B5625099FF6F383B", hash_generated_method = "A05F5C30B7E13E63720CC45642CF5DFE")
    public final boolean isOrderedBroadcast() {
        boolean varE1622B765B214B5C9D5BBE9448B09A07_1061822123 = (mPendingResult != null ? mPendingResult.mOrderedHint : false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_170088778 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_170088778;
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mOrderedHint : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.181 -0400", hash_original_method = "85C5802A7642DD110CD6FEA4F9597134", hash_generated_method = "602421E7A2CEFA7B574F55AB3FA8268C")
    public final boolean isInitialStickyBroadcast() {
        boolean var45A355815E07CFCC76BFC8EF62D962F5_1797553943 = (mPendingResult != null ? mPendingResult.mInitialStickyHint : false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1313306384 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1313306384;
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mInitialStickyHint : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.182 -0400", hash_original_method = "68B6314C0DA1E37C298D89B55CAE3400", hash_generated_method = "69D814F3B32F84B57634F91799811317")
    public final void setOrderedHint(boolean isOrdered) {
        addTaint(isOrdered);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.183 -0400", hash_original_method = "D4C333B718143025A27C15902000FB77", hash_generated_method = "D9AD103DE2626E233CF20E2D5E772BFB")
    public final void setPendingResult(PendingResult result) {
        mPendingResult = result;
        // ---------- Original Method ----------
        //mPendingResult = result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.183 -0400", hash_original_method = "DB63B22B6D1F06710FF3BD6349434467", hash_generated_method = "5E31E591619C92BC5B9D378A4AC070F4")
    public final PendingResult getPendingResult() {
PendingResult varFDA66089EEC27D31589A7C2426B1144F_1123548236 =         mPendingResult;
        varFDA66089EEC27D31589A7C2426B1144F_1123548236.addTaint(taint);
        return varFDA66089EEC27D31589A7C2426B1144F_1123548236;
        // ---------- Original Method ----------
        //return mPendingResult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.184 -0400", hash_original_method = "A942596201048EAFD951F2DD414301FD", hash_generated_method = "AE10474DE2420C2D522388046B0DF067")
    public final void setDebugUnregister(boolean debug) {
        mDebugUnregister = debug;
        // ---------- Original Method ----------
        //mDebugUnregister = debug;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.185 -0400", hash_original_method = "19A67BCF6BEB94B2ECFD54D952C17B9D", hash_generated_method = "93A2D13941D1969F7B1B2BCC4BFB9A35")
    public final boolean getDebugUnregister() {
        boolean var531E6956D9AF6ECA54301749A881CFAD_2053094689 = (mDebugUnregister);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_148328894 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_148328894;
        // ---------- Original Method ----------
        //return mDebugUnregister;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.185 -0400", hash_original_method = "719234F696D75BD5E624E0997AEC2529", hash_generated_method = "407B5EBB13D7D314AEB818EEDD303B47")
     void checkSynchronousHint() {
    if(mPendingResult == null)        
        {
            IllegalStateException varA46F5C53644BC71E9397C965D29AAAEC_1753588202 = new IllegalStateException("Call while result is not pending");
            varA46F5C53644BC71E9397C965D29AAAEC_1753588202.addTaint(taint);
            throw varA46F5C53644BC71E9397C965D29AAAEC_1753588202;
        } //End block
    if(mPendingResult.mOrderedHint || mPendingResult.mInitialStickyHint)        
        {
            return;
        } //End block
        RuntimeException e = new RuntimeException(
                "BroadcastReceiver trying to return result during a non-ordered broadcast");
        e.fillInStackTrace();
        // ---------- Original Method ----------
        //if (mPendingResult == null) {
            //throw new IllegalStateException("Call while result is not pending");
        //}
        //if (mPendingResult.mOrderedHint || mPendingResult.mInitialStickyHint) {
            //return;
        //}
        //RuntimeException e = new RuntimeException(
                //"BroadcastReceiver trying to return result during a non-ordered broadcast");
        //e.fillInStackTrace();
        //Log.e("BroadcastReceiver", e.getMessage(), e);
    }

    
    public static class PendingResult {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.186 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "B93BF1EFA6B57CC598632E54B97CD147")

        int mType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.186 -0400", hash_original_field = "4543096C53DE46C32336566088E0F654", hash_generated_field = "CDB2CA9D2DC3E6D40D3791F468236C61")

        boolean mOrderedHint;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.187 -0400", hash_original_field = "E325CA8F9CFD351DD035C72EEE389226", hash_generated_field = "13A087E46995ABA3C3337E0311BCBB18")

        boolean mInitialStickyHint;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.187 -0400", hash_original_field = "98E8D2ECD335C543A384E2B940159AF2", hash_generated_field = "DD6EB7EC256F1225D4C6DC1A42FB765B")

        IBinder mToken;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.187 -0400", hash_original_field = "E5CED19E692744D577EC9F38B767773F", hash_generated_field = "457E6BFD9A88F809DF3F4A88B9B7B893")

        int mResultCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.187 -0400", hash_original_field = "3EAEFB392DB2F84FAED87A71E79A1093", hash_generated_field = "9297DC4168CE0E61BD9D0F02E127B543")

        String mResultData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.187 -0400", hash_original_field = "15A7BDFA2595DFC979A8B0D8A65ABE14", hash_generated_field = "F5C1D34888409EAA7782FD08EA76AE47")

        Bundle mResultExtras;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.187 -0400", hash_original_field = "9D0CE3E2384F7D542D6BE0E686CC1587", hash_generated_field = "BE6D043F13884118A46F3E134D0352F1")

        boolean mAbortBroadcast;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.187 -0400", hash_original_field = "BB077E6B2FCDFA3F0EF71EB099A18F49", hash_generated_field = "10598AB9B4F301B505526794EAE9EAF0")

        boolean mFinished;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.189 -0400", hash_original_method = "A092172050E6E1EA8E89A6BB2F65A5D7", hash_generated_method = "7104FB540206A2CEFCEAF057A7D40607")
        public  PendingResult(int resultCode, String resultData, Bundle resultExtras,
                int type, boolean ordered, boolean sticky, IBinder token) {
            mResultCode = resultCode;
            mResultData = resultData;
            mResultExtras = resultExtras;
            mType = type;
            mOrderedHint = ordered;
            mInitialStickyHint = sticky;
            mToken = token;
            // ---------- Original Method ----------
            //mResultCode = resultCode;
            //mResultData = resultData;
            //mResultExtras = resultExtras;
            //mType = type;
            //mOrderedHint = ordered;
            //mInitialStickyHint = sticky;
            //mToken = token;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.189 -0400", hash_original_method = "8D188219D9B47ACA890A3A3FC0E4CDB9", hash_generated_method = "91B3DF7FB9FA90724BCAFC16EA2AF10F")
        public final void setResultCode(int code) {
            checkSynchronousHint();
            mResultCode = code;
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mResultCode = code;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.190 -0400", hash_original_method = "DAC102A9F551BEDDEF83F16167EFAEA6", hash_generated_method = "E9668D03BE7166F01E74789BE621103A")
        public final int getResultCode() {
            int varE5CED19E692744D577EC9F38B767773F_1966460375 = (mResultCode);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1565983023 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1565983023;
            // ---------- Original Method ----------
            //return mResultCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.190 -0400", hash_original_method = "70EE21896C4793F2CD7F1124D2F52609", hash_generated_method = "C6722180D7D266018ABE6FE095677B2C")
        public final void setResultData(String data) {
            checkSynchronousHint();
            mResultData = data;
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mResultData = data;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.191 -0400", hash_original_method = "AF28EEAF3BA9B8705C009D1FCC834AB4", hash_generated_method = "D20588878A8F7F99A83EFB5B60CF70F6")
        public final String getResultData() {
String var7AF81C367EA4623980C8741236739982_1142549106 =             mResultData;
            var7AF81C367EA4623980C8741236739982_1142549106.addTaint(taint);
            return var7AF81C367EA4623980C8741236739982_1142549106;
            // ---------- Original Method ----------
            //return mResultData;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.191 -0400", hash_original_method = "043EFA68A5EC6A2685391992580FAB4F", hash_generated_method = "3DC41E1A385242FB4F17457AEFAB3F81")
        public final void setResultExtras(Bundle extras) {
            checkSynchronousHint();
            mResultExtras = extras;
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mResultExtras = extras;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.192 -0400", hash_original_method = "48408ADF0828FD95531740A7B634349C", hash_generated_method = "D62199C4EB6ADCA983CF85776863B5EB")
        public final Bundle getResultExtras(boolean makeMap) {
            addTaint(makeMap);
            Bundle e = mResultExtras;
    if(!makeMap)            
            {
Bundle var6BFFBFA2F1D556BA80433C2335198CE9_1868941141 =             e;
            var6BFFBFA2F1D556BA80433C2335198CE9_1868941141.addTaint(taint);
            return var6BFFBFA2F1D556BA80433C2335198CE9_1868941141;
            }
    if(e == null)            
            mResultExtras = e = new Bundle();
Bundle var6BFFBFA2F1D556BA80433C2335198CE9_2002139819 =             e;
            var6BFFBFA2F1D556BA80433C2335198CE9_2002139819.addTaint(taint);
            return var6BFFBFA2F1D556BA80433C2335198CE9_2002139819;
            // ---------- Original Method ----------
            //Bundle e = mResultExtras;
            //if (!makeMap) return e;
            //if (e == null) mResultExtras = e = new Bundle();
            //return e;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.193 -0400", hash_original_method = "48338FF93B0D949C9CE50695C92AC674", hash_generated_method = "E3572DCCD03AA2F0DB19C6D7EC1CD89E")
        public final void setResult(int code, String data, Bundle extras) {
            checkSynchronousHint();
            mResultCode = code;
            mResultData = data;
            mResultExtras = extras;
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mResultCode = code;
            //mResultData = data;
            //mResultExtras = extras;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.194 -0400", hash_original_method = "27570BF34E94ABF03E65F54A5F2272E5", hash_generated_method = "A6A95EEFDB118010ECE6507927D1F48C")
        public final boolean getAbortBroadcast() {
            boolean var9D0CE3E2384F7D542D6BE0E686CC1587_913603544 = (mAbortBroadcast);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1505801688 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1505801688;
            // ---------- Original Method ----------
            //return mAbortBroadcast;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.214 -0400", hash_original_method = "1D9776C1F73983B7C91D53BC3475252B", hash_generated_method = "0F92C63DCD6A0EC0FE789EDB71DC5FA6")
        public final void abortBroadcast() {
            checkSynchronousHint();
            mAbortBroadcast = true;
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mAbortBroadcast = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.214 -0400", hash_original_method = "D4C82CDA8EB6714DAE416B0884FCBC85", hash_generated_method = "6C1AABD9192E1E0A43D3F6EB36BA7FB9")
        public final void clearAbortBroadcast() {
            mAbortBroadcast = false;
            // ---------- Original Method ----------
            //mAbortBroadcast = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.215 -0400", hash_original_method = "D8A44D8DD1BCA140D23101E83E968FA0", hash_generated_method = "E5E9DEBA377302377F11891DCBE258DC")
        public final void finish() {
    if(mType == TYPE_COMPONENT)            
            {
                final IActivityManager mgr = ActivityManagerNative.getDefault();
    if(QueuedWork.hasPendingWork())                
                {
                    QueuedWork.singleThreadExecutor().execute( new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.214 -0400", hash_original_method = "30493EB99D3B9C52A729521ECBA96102", hash_generated_method = "2E3B4BD7FCAEF2D6AFF3CFDB9A996A23")
            @Override
            public void run() {
    if(ActivityThread.DEBUG_BROADCAST){ }                sendFinished(mgr);
                // ---------- Original Method ----------
                //if (ActivityThread.DEBUG_BROADCAST) Slog.i(ActivityThread.TAG,
                                    //"Finishing broadcast after work to component " + mToken);
                //sendFinished(mgr);
            }
});
                } //End block
                else
                {
    if(ActivityThread.DEBUG_BROADCAST){ }                    sendFinished(mgr);
                } //End block
            } //End block
            else
    if(mOrderedHint && mType != TYPE_UNREGISTERED)            
            {
    if(ActivityThread.DEBUG_BROADCAST){ }                final IActivityManager mgr = ActivityManagerNative.getDefault();
                sendFinished(mgr);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.215 -0400", hash_original_method = "09CFE321AB9E3444E3559F2B522AB2BE", hash_generated_method = "F089507397C23DBABECD9B2914B0838D")
        public void setExtrasClassLoader(ClassLoader cl) {
            addTaint(cl.getTaint());
    if(mResultExtras != null)            
            {
                mResultExtras.setClassLoader(cl);
            } //End block
            // ---------- Original Method ----------
            //if (mResultExtras != null) {
                //mResultExtras.setClassLoader(cl);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.215 -0400", hash_original_method = "AADF9DDAF1334800EDC66F9968E01FC0", hash_generated_method = "24D6BA3BE4CF4BFE70156A95543EDE9E")
        public void sendFinished(IActivityManager am) {
            addTaint(am.getTaint());
            synchronized
(this)            {
    if(mFinished)                
                {
                    IllegalStateException var837E39E2EF22E9FDB9F1F742200C5639_818243006 = new IllegalStateException("Broadcast already finished");
                    var837E39E2EF22E9FDB9F1F742200C5639_818243006.addTaint(taint);
                    throw var837E39E2EF22E9FDB9F1F742200C5639_818243006;
                } //End block
                mFinished = true;
                try 
                {
    if(mResultExtras != null)                    
                    {
                        mResultExtras.setAllowFds(false);
                    } //End block
    if(mOrderedHint)                    
                    {
                        am.finishReceiver(mToken, mResultCode, mResultData, mResultExtras,
                                mAbortBroadcast);
                    } //End block
                    else
                    {
                        am.finishReceiver(mToken, 0, null, null, false);
                    } //End block
                } //End block
                catch (RemoteException ex)
                {
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (this) {
                //if (mFinished) {
                    //throw new IllegalStateException("Broadcast already finished");
                //}
                //mFinished = true;
                //try {
                    //if (mResultExtras != null) {
                        //mResultExtras.setAllowFds(false);
                    //}
                    //if (mOrderedHint) {
                        //am.finishReceiver(mToken, mResultCode, mResultData, mResultExtras,
                                //mAbortBroadcast);
                    //} else {
                        //am.finishReceiver(mToken, 0, null, null, false);
                    //}
                //} catch (RemoteException ex) {
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.215 -0400", hash_original_method = "82A6C5AFD458725D364E088D203D4257", hash_generated_method = "81BBA58E125434C90F87F7362C620BCF")
         void checkSynchronousHint() {
    if(mOrderedHint || mInitialStickyHint)            
            {
                return;
            } //End block
            RuntimeException e = new RuntimeException(
                    "BroadcastReceiver trying to return result during a non-ordered broadcast");
            e.fillInStackTrace();
            // ---------- Original Method ----------
            //if (mOrderedHint || mInitialStickyHint) {
                //return;
            //}
            //RuntimeException e = new RuntimeException(
                    //"BroadcastReceiver trying to return result during a non-ordered broadcast");
            //e.fillInStackTrace();
            //Log.e("BroadcastReceiver", e.getMessage(), e);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.216 -0400", hash_original_field = "E9B12079BA81E4A9E223E3E69CBCC96B", hash_generated_field = "E4EA6E7A3F4417E09164CDDBDCB8CDCE")

        public static final int TYPE_COMPONENT = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.216 -0400", hash_original_field = "C0B0EFB5AB40BA1A534DADDC23FCCDC9", hash_generated_field = "06907A658310DA1AD3781E70CEE869F6")

        public static final int TYPE_REGISTERED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:08.216 -0400", hash_original_field = "98C92357CF58CE0F12209D8C57F14ED1", hash_generated_field = "502D0CFA37619833702608E6E5D5B79C")

        public static final int TYPE_UNREGISTERED = 2;
    }


    
}


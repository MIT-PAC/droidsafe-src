package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.454 -0400", hash_original_field = "6DD50A78846A573507CD3027E97E1EA6", hash_generated_field = "56CC6D10D54B274449EA4D95649A29AE")

    private PendingResult mPendingResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.455 -0400", hash_original_field = "531E6956D9AF6ECA54301749A881CFAD", hash_generated_field = "D63712D72C7DEA3780B2E3ED680A7016")

    private boolean mDebugUnregister;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.456 -0400", hash_original_method = "2900F07960080430406180ADD3872CDD", hash_generated_method = "4949473B0E069ABC52AE38A1EB5EC2B1")
    public  BroadcastReceiver() {
        // ---------- Original Method ----------
    }

    
    public abstract void onReceive(Context context, Intent intent);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.467 -0400", hash_original_method = "A694EC135053AF2FEB071A12D3EE4319", hash_generated_method = "A2EE7342DAF7CD833A982BFB8C651D92")
    public final PendingResult goAsync() {
        PendingResult varB4EAC82CA7396A68D541C85D26508E83_1783961143 = null; //Variable for return #1
        PendingResult res;
        res = mPendingResult;
        mPendingResult = null;
        varB4EAC82CA7396A68D541C85D26508E83_1783961143 = res;
        varB4EAC82CA7396A68D541C85D26508E83_1783961143.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1783961143;
        // ---------- Original Method ----------
        //PendingResult res = mPendingResult;
        //mPendingResult = null;
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.481 -0400", hash_original_method = "891D062EE6B5DF300B0D5F817EBA802C", hash_generated_method = "A59F154399B696F0ACD3BA9AA42F2CC5")
    public IBinder peekService(Context myContext, Intent service) {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1535616713 = null; //Variable for return #1
        IActivityManager am;
        am = ActivityManagerNative.getDefault();
        IBinder binder;
        binder = null;
        try 
        {
            service.setAllowFds(false);
            binder = am.peekService(service, service.resolveTypeIfNeeded(
                    myContext.getContentResolver()));
        } //End block
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1535616713 = binder;
        addTaint(myContext.getTaint());
        addTaint(service.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1535616713.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1535616713;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.483 -0400", hash_original_method = "D9C6679B9D8E9806D41E73EFA120BCFE", hash_generated_method = "D8B058A84574659F09A9DE8C943A316A")
    public final void setResultCode(int code) {
        checkSynchronousHint();
        mPendingResult.mResultCode = code;
        // ---------- Original Method ----------
        //checkSynchronousHint();
        //mPendingResult.mResultCode = code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.490 -0400", hash_original_method = "413D4442793CB2CD30088D833172245E", hash_generated_method = "F7632301AAE8122D042ABD819AA4C1E4")
    public final int getResultCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_605910902 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_605910902;
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mResultCode : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.495 -0400", hash_original_method = "326C45A93CAC69AE5F40CC5662FD4E21", hash_generated_method = "C90A109DB604318B2505A1C010330879")
    public final void setResultData(String data) {
        checkSynchronousHint();
        mPendingResult.mResultData = data;
        // ---------- Original Method ----------
        //checkSynchronousHint();
        //mPendingResult.mResultData = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.503 -0400", hash_original_method = "4500B5844C9E31997AA4128C2B631832", hash_generated_method = "08463A24D96D0EE8318D03B13B898945")
    public final String getResultData() {
        String varB4EAC82CA7396A68D541C85D26508E83_465821240 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_465821240 = mPendingResult != null ? mPendingResult.mResultData : null;
        varB4EAC82CA7396A68D541C85D26508E83_465821240.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_465821240;
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mResultData : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.504 -0400", hash_original_method = "A002D9C66CF7F2AA1D1827503AAC99EC", hash_generated_method = "AE999306C66D9D7D9F87E31E8790C266")
    public final void setResultExtras(Bundle extras) {
        checkSynchronousHint();
        mPendingResult.mResultExtras = extras;
        // ---------- Original Method ----------
        //checkSynchronousHint();
        //mPendingResult.mResultExtras = extras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.520 -0400", hash_original_method = "4CB90710C7A856F1CF5FAF169A56650C", hash_generated_method = "6F90F024EA92DD20C0B0D4E5C20E8E3F")
    public final Bundle getResultExtras(boolean makeMap) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_403815115 = null; //Variable for return #1
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1146311699 = null; //Variable for return #2
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1433861505 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_403815115 = null;
        } //End block
        Bundle e;
        e = mPendingResult.mResultExtras;
        varB4EAC82CA7396A68D541C85D26508E83_1146311699 = e;
        mPendingResult.mResultExtras = e = new Bundle();
        varB4EAC82CA7396A68D541C85D26508E83_1433861505 = e;
        addTaint(makeMap);
        Bundle varA7E53CE21691AB073D9660D615818899_946805882; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_946805882 = varB4EAC82CA7396A68D541C85D26508E83_403815115;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_946805882 = varB4EAC82CA7396A68D541C85D26508E83_1146311699;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_946805882 = varB4EAC82CA7396A68D541C85D26508E83_1433861505;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_946805882.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_946805882;
        // ---------- Original Method ----------
        //if (mPendingResult == null) {
            //return null;
        //}
        //Bundle e = mPendingResult.mResultExtras;
        //if (!makeMap) return e;
        //if (e == null) mPendingResult.mResultExtras = e = new Bundle();
        //return e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.530 -0400", hash_original_method = "71BA20FC3DD345B39DB950803A39A1ED", hash_generated_method = "4E29E8202B08EC6E81632318D3263996")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.544 -0400", hash_original_method = "AC60D9C3BD95277DA035DD6FF45A8CCB", hash_generated_method = "A0E2084B67AC507F1FA697F20E7F83E3")
    public final boolean getAbortBroadcast() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2099136814 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2099136814;
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mAbortBroadcast : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.545 -0400", hash_original_method = "EA4258D43E5FA594C300ACFA62523E77", hash_generated_method = "6C8DB09AA240CF4D79E5212B6813BBD7")
    public final void abortBroadcast() {
        checkSynchronousHint();
        mPendingResult.mAbortBroadcast = true;
        // ---------- Original Method ----------
        //checkSynchronousHint();
        //mPendingResult.mAbortBroadcast = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.546 -0400", hash_original_method = "7C3FDE5990F70723754AFB92AED4E2CB", hash_generated_method = "8064B6E26B085DBF3888D9560DF7DC7F")
    public final void clearAbortBroadcast() {
        {
            mPendingResult.mAbortBroadcast = false;
        } //End block
        // ---------- Original Method ----------
        //if (mPendingResult != null) {
            //mPendingResult.mAbortBroadcast = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.547 -0400", hash_original_method = "E46A4317E3055902B5625099FF6F383B", hash_generated_method = "4E5554AE5F1524C68DD6DFA648A7F583")
    public final boolean isOrderedBroadcast() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_819464430 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_819464430;
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mOrderedHint : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.558 -0400", hash_original_method = "85C5802A7642DD110CD6FEA4F9597134", hash_generated_method = "CF21077E0E364DEAB745713ADA9AA054")
    public final boolean isInitialStickyBroadcast() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_171673128 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_171673128;
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mInitialStickyHint : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.558 -0400", hash_original_method = "68B6314C0DA1E37C298D89B55CAE3400", hash_generated_method = "69D814F3B32F84B57634F91799811317")
    public final void setOrderedHint(boolean isOrdered) {
        addTaint(isOrdered);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.559 -0400", hash_original_method = "D4C333B718143025A27C15902000FB77", hash_generated_method = "D9AD103DE2626E233CF20E2D5E772BFB")
    public final void setPendingResult(PendingResult result) {
        mPendingResult = result;
        // ---------- Original Method ----------
        //mPendingResult = result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.579 -0400", hash_original_method = "DB63B22B6D1F06710FF3BD6349434467", hash_generated_method = "31375C199E55FC578C6B719A6C575BE4")
    public final PendingResult getPendingResult() {
        PendingResult varB4EAC82CA7396A68D541C85D26508E83_1267047686 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1267047686 = mPendingResult;
        varB4EAC82CA7396A68D541C85D26508E83_1267047686.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1267047686;
        // ---------- Original Method ----------
        //return mPendingResult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.580 -0400", hash_original_method = "A942596201048EAFD951F2DD414301FD", hash_generated_method = "AE10474DE2420C2D522388046B0DF067")
    public final void setDebugUnregister(boolean debug) {
        mDebugUnregister = debug;
        // ---------- Original Method ----------
        //mDebugUnregister = debug;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.583 -0400", hash_original_method = "19A67BCF6BEB94B2ECFD54D952C17B9D", hash_generated_method = "4C99179E3D2710D4AA4605AE06A38E79")
    public final boolean getDebugUnregister() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_818783705 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_818783705;
        // ---------- Original Method ----------
        //return mDebugUnregister;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.584 -0400", hash_original_method = "719234F696D75BD5E624E0997AEC2529", hash_generated_method = "3524DA2E66B95DD8A6D82F927FB675C3")
     void checkSynchronousHint() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Call while result is not pending");
        } //End block
        RuntimeException e;
        e = new RuntimeException(
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.605 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "B93BF1EFA6B57CC598632E54B97CD147")

        int mType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.605 -0400", hash_original_field = "4543096C53DE46C32336566088E0F654", hash_generated_field = "CDB2CA9D2DC3E6D40D3791F468236C61")

        boolean mOrderedHint;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.605 -0400", hash_original_field = "E325CA8F9CFD351DD035C72EEE389226", hash_generated_field = "13A087E46995ABA3C3337E0311BCBB18")

        boolean mInitialStickyHint;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.606 -0400", hash_original_field = "98E8D2ECD335C543A384E2B940159AF2", hash_generated_field = "DD6EB7EC256F1225D4C6DC1A42FB765B")

        IBinder mToken;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.606 -0400", hash_original_field = "E5CED19E692744D577EC9F38B767773F", hash_generated_field = "457E6BFD9A88F809DF3F4A88B9B7B893")

        int mResultCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.606 -0400", hash_original_field = "3EAEFB392DB2F84FAED87A71E79A1093", hash_generated_field = "9297DC4168CE0E61BD9D0F02E127B543")

        String mResultData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.606 -0400", hash_original_field = "15A7BDFA2595DFC979A8B0D8A65ABE14", hash_generated_field = "F5C1D34888409EAA7782FD08EA76AE47")

        Bundle mResultExtras;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.607 -0400", hash_original_field = "9D0CE3E2384F7D542D6BE0E686CC1587", hash_generated_field = "BE6D043F13884118A46F3E134D0352F1")

        boolean mAbortBroadcast;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.607 -0400", hash_original_field = "BB077E6B2FCDFA3F0EF71EB099A18F49", hash_generated_field = "10598AB9B4F301B505526794EAE9EAF0")

        boolean mFinished;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.629 -0400", hash_original_method = "A092172050E6E1EA8E89A6BB2F65A5D7", hash_generated_method = "7104FB540206A2CEFCEAF057A7D40607")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.630 -0400", hash_original_method = "8D188219D9B47ACA890A3A3FC0E4CDB9", hash_generated_method = "91B3DF7FB9FA90724BCAFC16EA2AF10F")
        public final void setResultCode(int code) {
            checkSynchronousHint();
            mResultCode = code;
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mResultCode = code;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.638 -0400", hash_original_method = "DAC102A9F551BEDDEF83F16167EFAEA6", hash_generated_method = "17F25A89421E8640557D12DFEAEB35D6")
        public final int getResultCode() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_761485223 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_761485223;
            // ---------- Original Method ----------
            //return mResultCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.639 -0400", hash_original_method = "70EE21896C4793F2CD7F1124D2F52609", hash_generated_method = "C6722180D7D266018ABE6FE095677B2C")
        public final void setResultData(String data) {
            checkSynchronousHint();
            mResultData = data;
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mResultData = data;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.640 -0400", hash_original_method = "AF28EEAF3BA9B8705C009D1FCC834AB4", hash_generated_method = "AB5430E7E7D9AF148C6775F653AE5E9E")
        public final String getResultData() {
            String varB4EAC82CA7396A68D541C85D26508E83_333840936 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_333840936 = mResultData;
            varB4EAC82CA7396A68D541C85D26508E83_333840936.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_333840936;
            // ---------- Original Method ----------
            //return mResultData;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.641 -0400", hash_original_method = "043EFA68A5EC6A2685391992580FAB4F", hash_generated_method = "3DC41E1A385242FB4F17457AEFAB3F81")
        public final void setResultExtras(Bundle extras) {
            checkSynchronousHint();
            mResultExtras = extras;
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mResultExtras = extras;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.659 -0400", hash_original_method = "48408ADF0828FD95531740A7B634349C", hash_generated_method = "04E00F2CFFD9F9796DB688E0E2EBEF39")
        public final Bundle getResultExtras(boolean makeMap) {
            Bundle varB4EAC82CA7396A68D541C85D26508E83_570258550 = null; //Variable for return #1
            Bundle varB4EAC82CA7396A68D541C85D26508E83_1811770741 = null; //Variable for return #2
            Bundle e;
            e = mResultExtras;
            varB4EAC82CA7396A68D541C85D26508E83_570258550 = e;
            mResultExtras = e = new Bundle();
            varB4EAC82CA7396A68D541C85D26508E83_1811770741 = e;
            addTaint(makeMap);
            Bundle varA7E53CE21691AB073D9660D615818899_765989967; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_765989967 = varB4EAC82CA7396A68D541C85D26508E83_570258550;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_765989967 = varB4EAC82CA7396A68D541C85D26508E83_1811770741;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_765989967.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_765989967;
            // ---------- Original Method ----------
            //Bundle e = mResultExtras;
            //if (!makeMap) return e;
            //if (e == null) mResultExtras = e = new Bundle();
            //return e;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.665 -0400", hash_original_method = "48338FF93B0D949C9CE50695C92AC674", hash_generated_method = "E3572DCCD03AA2F0DB19C6D7EC1CD89E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.685 -0400", hash_original_method = "27570BF34E94ABF03E65F54A5F2272E5", hash_generated_method = "A381A70F9E5D99906DC38BA3C799658D")
        public final boolean getAbortBroadcast() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_206057693 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_206057693;
            // ---------- Original Method ----------
            //return mAbortBroadcast;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.686 -0400", hash_original_method = "1D9776C1F73983B7C91D53BC3475252B", hash_generated_method = "0F92C63DCD6A0EC0FE789EDB71DC5FA6")
        public final void abortBroadcast() {
            checkSynchronousHint();
            mAbortBroadcast = true;
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mAbortBroadcast = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.686 -0400", hash_original_method = "D4C82CDA8EB6714DAE416B0884FCBC85", hash_generated_method = "6C1AABD9192E1E0A43D3F6EB36BA7FB9")
        public final void clearAbortBroadcast() {
            mAbortBroadcast = false;
            // ---------- Original Method ----------
            //mAbortBroadcast = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.706 -0400", hash_original_method = "D8A44D8DD1BCA140D23101E83E968FA0", hash_generated_method = "CA18719C4BAF2AB047B302305B45FF85")
        public final void finish() {
            {
                IActivityManager mgr;
                mgr = ActivityManagerNative.getDefault();
                {
                    boolean var5DFCE705551B272DAF84D13C6908ADBA_323678006 = (QueuedWork.hasPendingWork());
                    {
                        QueuedWork.singleThreadExecutor().execute( new Runnable() {                            
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.706 -0400", hash_original_method = "30493EB99D3B9C52A729521ECBA96102", hash_generated_method = "9E0FC75885C1685D2CF05C0710DCED56")
                            @Override
                            public void run() {
                                sendFinished(mgr);
                                // ---------- Original Method ----------
                                //if (ActivityThread.DEBUG_BROADCAST) Slog.i(ActivityThread.TAG,
                                    //"Finishing broadcast after work to component " + mToken);
                                //sendFinished(mgr);
                            }
});
                    } //End block
                    {
                        sendFinished(mgr);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                IActivityManager mgr;
                mgr = ActivityManagerNative.getDefault();
                sendFinished(mgr);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.707 -0400", hash_original_method = "09CFE321AB9E3444E3559F2B522AB2BE", hash_generated_method = "449E6A93D95685E4BACE2BE26A644340")
        public void setExtrasClassLoader(ClassLoader cl) {
            {
                mResultExtras.setClassLoader(cl);
            } //End block
            addTaint(cl.getTaint());
            // ---------- Original Method ----------
            //if (mResultExtras != null) {
                //mResultExtras.setClassLoader(cl);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.723 -0400", hash_original_method = "AADF9DDAF1334800EDC66F9968E01FC0", hash_generated_method = "82854CD468D87D473A258E20C785332C")
        public void sendFinished(IActivityManager am) {
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Broadcast already finished");
                } //End block
                mFinished = true;
                try 
                {
                    {
                        mResultExtras.setAllowFds(false);
                    } //End block
                    {
                        am.finishReceiver(mToken, mResultCode, mResultData, mResultExtras,
                                mAbortBroadcast);
                    } //End block
                    {
                        am.finishReceiver(mToken, 0, null, null, false);
                    } //End block
                } //End block
                catch (RemoteException ex)
                { }
            } //End block
            addTaint(am.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.725 -0400", hash_original_method = "82A6C5AFD458725D364E088D203D4257", hash_generated_method = "296373C43A6DCF6A0C41E2119507641E")
         void checkSynchronousHint() {
            RuntimeException e;
            e = new RuntimeException(
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.725 -0400", hash_original_field = "E9B12079BA81E4A9E223E3E69CBCC96B", hash_generated_field = "E4EA6E7A3F4417E09164CDDBDCB8CDCE")

        public static final int TYPE_COMPONENT = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.827 -0400", hash_original_field = "C0B0EFB5AB40BA1A534DADDC23FCCDC9", hash_generated_field = "06907A658310DA1AD3781E70CEE869F6")

        public static final int TYPE_REGISTERED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.827 -0400", hash_original_field = "98C92357CF58CE0F12209D8C57F14ED1", hash_generated_field = "502D0CFA37619833702608E6E5D5B79C")

        public static final int TYPE_UNREGISTERED = 2;
    }


    
}


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.039 -0400", hash_original_field = "6DD50A78846A573507CD3027E97E1EA6", hash_generated_field = "56CC6D10D54B274449EA4D95649A29AE")

    private PendingResult mPendingResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.039 -0400", hash_original_field = "531E6956D9AF6ECA54301749A881CFAD", hash_generated_field = "D63712D72C7DEA3780B2E3ED680A7016")

    private boolean mDebugUnregister;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.040 -0400", hash_original_method = "2900F07960080430406180ADD3872CDD", hash_generated_method = "4949473B0E069ABC52AE38A1EB5EC2B1")
    public  BroadcastReceiver() {
        // ---------- Original Method ----------
    }

    
    public abstract void onReceive(Context context, Intent intent);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.045 -0400", hash_original_method = "A694EC135053AF2FEB071A12D3EE4319", hash_generated_method = "995E8495F4BAFB1A0AA47861932E0DE7")
    public final PendingResult goAsync() {
        PendingResult varB4EAC82CA7396A68D541C85D26508E83_113781406 = null; //Variable for return #1
        PendingResult res;
        res = mPendingResult;
        mPendingResult = null;
        varB4EAC82CA7396A68D541C85D26508E83_113781406 = res;
        varB4EAC82CA7396A68D541C85D26508E83_113781406.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_113781406;
        // ---------- Original Method ----------
        //PendingResult res = mPendingResult;
        //mPendingResult = null;
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.055 -0400", hash_original_method = "891D062EE6B5DF300B0D5F817EBA802C", hash_generated_method = "59C4257F9FD640F79846CC4C6733B9BA")
    public IBinder peekService(Context myContext, Intent service) {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_931541804 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_931541804 = binder;
        addTaint(myContext.getTaint());
        addTaint(service.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_931541804.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_931541804;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.099 -0400", hash_original_method = "D9C6679B9D8E9806D41E73EFA120BCFE", hash_generated_method = "D8B058A84574659F09A9DE8C943A316A")
    public final void setResultCode(int code) {
        checkSynchronousHint();
        mPendingResult.mResultCode = code;
        // ---------- Original Method ----------
        //checkSynchronousHint();
        //mPendingResult.mResultCode = code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.100 -0400", hash_original_method = "413D4442793CB2CD30088D833172245E", hash_generated_method = "2D7A1544A4DEAF598982D17393C53496")
    public final int getResultCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_529903717 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_529903717;
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mResultCode : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.111 -0400", hash_original_method = "326C45A93CAC69AE5F40CC5662FD4E21", hash_generated_method = "C90A109DB604318B2505A1C010330879")
    public final void setResultData(String data) {
        checkSynchronousHint();
        mPendingResult.mResultData = data;
        // ---------- Original Method ----------
        //checkSynchronousHint();
        //mPendingResult.mResultData = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.125 -0400", hash_original_method = "4500B5844C9E31997AA4128C2B631832", hash_generated_method = "B8C71613ADCAE4B7391C5D3CCF404EF8")
    public final String getResultData() {
        String varB4EAC82CA7396A68D541C85D26508E83_1270156427 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1270156427 = mPendingResult != null ? mPendingResult.mResultData : null;
        varB4EAC82CA7396A68D541C85D26508E83_1270156427.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1270156427;
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mResultData : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.126 -0400", hash_original_method = "A002D9C66CF7F2AA1D1827503AAC99EC", hash_generated_method = "AE999306C66D9D7D9F87E31E8790C266")
    public final void setResultExtras(Bundle extras) {
        checkSynchronousHint();
        mPendingResult.mResultExtras = extras;
        // ---------- Original Method ----------
        //checkSynchronousHint();
        //mPendingResult.mResultExtras = extras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.161 -0400", hash_original_method = "4CB90710C7A856F1CF5FAF169A56650C", hash_generated_method = "C59EF62D1C9149707EDC8B0D2F3A8410")
    public final Bundle getResultExtras(boolean makeMap) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1148127044 = null; //Variable for return #1
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1675720816 = null; //Variable for return #2
        Bundle varB4EAC82CA7396A68D541C85D26508E83_43750853 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1148127044 = null;
        } //End block
        Bundle e;
        e = mPendingResult.mResultExtras;
        varB4EAC82CA7396A68D541C85D26508E83_1675720816 = e;
        mPendingResult.mResultExtras = e = new Bundle();
        varB4EAC82CA7396A68D541C85D26508E83_43750853 = e;
        addTaint(makeMap);
        Bundle varA7E53CE21691AB073D9660D615818899_1326808589; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1326808589 = varB4EAC82CA7396A68D541C85D26508E83_1148127044;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1326808589 = varB4EAC82CA7396A68D541C85D26508E83_1675720816;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1326808589 = varB4EAC82CA7396A68D541C85D26508E83_43750853;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1326808589.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1326808589;
        // ---------- Original Method ----------
        //if (mPendingResult == null) {
            //return null;
        //}
        //Bundle e = mPendingResult.mResultExtras;
        //if (!makeMap) return e;
        //if (e == null) mPendingResult.mResultExtras = e = new Bundle();
        //return e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.181 -0400", hash_original_method = "71BA20FC3DD345B39DB950803A39A1ED", hash_generated_method = "4E29E8202B08EC6E81632318D3263996")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.186 -0400", hash_original_method = "AC60D9C3BD95277DA035DD6FF45A8CCB", hash_generated_method = "CAC599EE72D9C2F46E2CCE7D562AC56E")
    public final boolean getAbortBroadcast() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_633188116 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_633188116;
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mAbortBroadcast : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.187 -0400", hash_original_method = "EA4258D43E5FA594C300ACFA62523E77", hash_generated_method = "6C8DB09AA240CF4D79E5212B6813BBD7")
    public final void abortBroadcast() {
        checkSynchronousHint();
        mPendingResult.mAbortBroadcast = true;
        // ---------- Original Method ----------
        //checkSynchronousHint();
        //mPendingResult.mAbortBroadcast = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.188 -0400", hash_original_method = "7C3FDE5990F70723754AFB92AED4E2CB", hash_generated_method = "8064B6E26B085DBF3888D9560DF7DC7F")
    public final void clearAbortBroadcast() {
        {
            mPendingResult.mAbortBroadcast = false;
        } //End block
        // ---------- Original Method ----------
        //if (mPendingResult != null) {
            //mPendingResult.mAbortBroadcast = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.189 -0400", hash_original_method = "E46A4317E3055902B5625099FF6F383B", hash_generated_method = "7DB40AE6895623C63F028C208936F762")
    public final boolean isOrderedBroadcast() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_580693309 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_580693309;
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mOrderedHint : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.190 -0400", hash_original_method = "85C5802A7642DD110CD6FEA4F9597134", hash_generated_method = "D5DE5E7EC41AA98E320A3487DADED053")
    public final boolean isInitialStickyBroadcast() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_785506100 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_785506100;
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mInitialStickyHint : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.191 -0400", hash_original_method = "68B6314C0DA1E37C298D89B55CAE3400", hash_generated_method = "69D814F3B32F84B57634F91799811317")
    public final void setOrderedHint(boolean isOrdered) {
        addTaint(isOrdered);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.191 -0400", hash_original_method = "D4C333B718143025A27C15902000FB77", hash_generated_method = "D9AD103DE2626E233CF20E2D5E772BFB")
    public final void setPendingResult(PendingResult result) {
        mPendingResult = result;
        // ---------- Original Method ----------
        //mPendingResult = result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.198 -0400", hash_original_method = "DB63B22B6D1F06710FF3BD6349434467", hash_generated_method = "8C5A36DCFD18566EA6FF6ECB682C81D5")
    public final PendingResult getPendingResult() {
        PendingResult varB4EAC82CA7396A68D541C85D26508E83_431024082 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_431024082 = mPendingResult;
        varB4EAC82CA7396A68D541C85D26508E83_431024082.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_431024082;
        // ---------- Original Method ----------
        //return mPendingResult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.214 -0400", hash_original_method = "A942596201048EAFD951F2DD414301FD", hash_generated_method = "AE10474DE2420C2D522388046B0DF067")
    public final void setDebugUnregister(boolean debug) {
        mDebugUnregister = debug;
        // ---------- Original Method ----------
        //mDebugUnregister = debug;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.218 -0400", hash_original_method = "19A67BCF6BEB94B2ECFD54D952C17B9D", hash_generated_method = "F00BAFD08B24E0B077646169D1F116FA")
    public final boolean getDebugUnregister() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1261175336 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1261175336;
        // ---------- Original Method ----------
        //return mDebugUnregister;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.220 -0400", hash_original_method = "719234F696D75BD5E624E0997AEC2529", hash_generated_method = "3524DA2E66B95DD8A6D82F927FB675C3")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.220 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "B93BF1EFA6B57CC598632E54B97CD147")

        int mType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.221 -0400", hash_original_field = "4543096C53DE46C32336566088E0F654", hash_generated_field = "CDB2CA9D2DC3E6D40D3791F468236C61")

        boolean mOrderedHint;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.230 -0400", hash_original_field = "E325CA8F9CFD351DD035C72EEE389226", hash_generated_field = "13A087E46995ABA3C3337E0311BCBB18")

        boolean mInitialStickyHint;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.230 -0400", hash_original_field = "98E8D2ECD335C543A384E2B940159AF2", hash_generated_field = "DD6EB7EC256F1225D4C6DC1A42FB765B")

        IBinder mToken;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.230 -0400", hash_original_field = "E5CED19E692744D577EC9F38B767773F", hash_generated_field = "457E6BFD9A88F809DF3F4A88B9B7B893")

        int mResultCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.230 -0400", hash_original_field = "3EAEFB392DB2F84FAED87A71E79A1093", hash_generated_field = "9297DC4168CE0E61BD9D0F02E127B543")

        String mResultData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.230 -0400", hash_original_field = "15A7BDFA2595DFC979A8B0D8A65ABE14", hash_generated_field = "F5C1D34888409EAA7782FD08EA76AE47")

        Bundle mResultExtras;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.231 -0400", hash_original_field = "9D0CE3E2384F7D542D6BE0E686CC1587", hash_generated_field = "BE6D043F13884118A46F3E134D0352F1")

        boolean mAbortBroadcast;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.231 -0400", hash_original_field = "BB077E6B2FCDFA3F0EF71EB099A18F49", hash_generated_field = "10598AB9B4F301B505526794EAE9EAF0")

        boolean mFinished;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.232 -0400", hash_original_method = "A092172050E6E1EA8E89A6BB2F65A5D7", hash_generated_method = "7104FB540206A2CEFCEAF057A7D40607")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.249 -0400", hash_original_method = "8D188219D9B47ACA890A3A3FC0E4CDB9", hash_generated_method = "91B3DF7FB9FA90724BCAFC16EA2AF10F")
        public final void setResultCode(int code) {
            checkSynchronousHint();
            mResultCode = code;
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mResultCode = code;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.250 -0400", hash_original_method = "DAC102A9F551BEDDEF83F16167EFAEA6", hash_generated_method = "4942F91427692C7FE131F08E3FB47741")
        public final int getResultCode() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180049135 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180049135;
            // ---------- Original Method ----------
            //return mResultCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.263 -0400", hash_original_method = "70EE21896C4793F2CD7F1124D2F52609", hash_generated_method = "C6722180D7D266018ABE6FE095677B2C")
        public final void setResultData(String data) {
            checkSynchronousHint();
            mResultData = data;
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mResultData = data;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.264 -0400", hash_original_method = "AF28EEAF3BA9B8705C009D1FCC834AB4", hash_generated_method = "DB653209D1E43720F2B90857A65E0B96")
        public final String getResultData() {
            String varB4EAC82CA7396A68D541C85D26508E83_865748877 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_865748877 = mResultData;
            varB4EAC82CA7396A68D541C85D26508E83_865748877.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_865748877;
            // ---------- Original Method ----------
            //return mResultData;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.266 -0400", hash_original_method = "043EFA68A5EC6A2685391992580FAB4F", hash_generated_method = "3DC41E1A385242FB4F17457AEFAB3F81")
        public final void setResultExtras(Bundle extras) {
            checkSynchronousHint();
            mResultExtras = extras;
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mResultExtras = extras;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.289 -0400", hash_original_method = "48408ADF0828FD95531740A7B634349C", hash_generated_method = "21828D5FE8F05A6C393B712021B385A5")
        public final Bundle getResultExtras(boolean makeMap) {
            Bundle varB4EAC82CA7396A68D541C85D26508E83_46803468 = null; //Variable for return #1
            Bundle varB4EAC82CA7396A68D541C85D26508E83_1508366881 = null; //Variable for return #2
            Bundle e;
            e = mResultExtras;
            varB4EAC82CA7396A68D541C85D26508E83_46803468 = e;
            mResultExtras = e = new Bundle();
            varB4EAC82CA7396A68D541C85D26508E83_1508366881 = e;
            addTaint(makeMap);
            Bundle varA7E53CE21691AB073D9660D615818899_2000505062; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_2000505062 = varB4EAC82CA7396A68D541C85D26508E83_46803468;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2000505062 = varB4EAC82CA7396A68D541C85D26508E83_1508366881;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2000505062.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_2000505062;
            // ---------- Original Method ----------
            //Bundle e = mResultExtras;
            //if (!makeMap) return e;
            //if (e == null) mResultExtras = e = new Bundle();
            //return e;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.293 -0400", hash_original_method = "48338FF93B0D949C9CE50695C92AC674", hash_generated_method = "E3572DCCD03AA2F0DB19C6D7EC1CD89E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.314 -0400", hash_original_method = "27570BF34E94ABF03E65F54A5F2272E5", hash_generated_method = "053521EBF0531C27997DD56087B29643")
        public final boolean getAbortBroadcast() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_67335936 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_67335936;
            // ---------- Original Method ----------
            //return mAbortBroadcast;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.315 -0400", hash_original_method = "1D9776C1F73983B7C91D53BC3475252B", hash_generated_method = "0F92C63DCD6A0EC0FE789EDB71DC5FA6")
        public final void abortBroadcast() {
            checkSynchronousHint();
            mAbortBroadcast = true;
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mAbortBroadcast = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.316 -0400", hash_original_method = "D4C82CDA8EB6714DAE416B0884FCBC85", hash_generated_method = "6C1AABD9192E1E0A43D3F6EB36BA7FB9")
        public final void clearAbortBroadcast() {
            mAbortBroadcast = false;
            // ---------- Original Method ----------
            //mAbortBroadcast = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.318 -0400", hash_original_method = "D8A44D8DD1BCA140D23101E83E968FA0", hash_generated_method = "EDF10ED5715FE807A457C2796ECDA23E")
        public final void finish() {
            {
                IActivityManager mgr;
                mgr = ActivityManagerNative.getDefault();
                {
                    boolean var5DFCE705551B272DAF84D13C6908ADBA_523916475 = (QueuedWork.hasPendingWork());
                    {
                        QueuedWork.singleThreadExecutor().execute( new Runnable() {                            
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.318 -0400", hash_original_method = "30493EB99D3B9C52A729521ECBA96102", hash_generated_method = "9E0FC75885C1685D2CF05C0710DCED56")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.352 -0400", hash_original_method = "09CFE321AB9E3444E3559F2B522AB2BE", hash_generated_method = "449E6A93D95685E4BACE2BE26A644340")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.367 -0400", hash_original_method = "AADF9DDAF1334800EDC66F9968E01FC0", hash_generated_method = "82854CD468D87D473A258E20C785332C")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.368 -0400", hash_original_method = "82A6C5AFD458725D364E088D203D4257", hash_generated_method = "296373C43A6DCF6A0C41E2119507641E")
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.369 -0400", hash_original_field = "E9B12079BA81E4A9E223E3E69CBCC96B", hash_generated_field = "E4EA6E7A3F4417E09164CDDBDCB8CDCE")

        public static final int TYPE_COMPONENT = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.369 -0400", hash_original_field = "C0B0EFB5AB40BA1A534DADDC23FCCDC9", hash_generated_field = "06907A658310DA1AD3781E70CEE869F6")

        public static final int TYPE_REGISTERED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.369 -0400", hash_original_field = "98C92357CF58CE0F12209D8C57F14ED1", hash_generated_field = "502D0CFA37619833702608E6E5D5B79C")

        public static final int TYPE_UNREGISTERED = 2;
    }


    
}


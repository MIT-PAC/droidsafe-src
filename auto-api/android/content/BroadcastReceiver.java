package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.008 -0400", hash_original_field = "6DD50A78846A573507CD3027E97E1EA6", hash_generated_field = "56CC6D10D54B274449EA4D95649A29AE")

    private PendingResult mPendingResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.008 -0400", hash_original_field = "531E6956D9AF6ECA54301749A881CFAD", hash_generated_field = "D63712D72C7DEA3780B2E3ED680A7016")

    private boolean mDebugUnregister;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.009 -0400", hash_original_method = "2900F07960080430406180ADD3872CDD", hash_generated_method = "4949473B0E069ABC52AE38A1EB5EC2B1")
    public  BroadcastReceiver() {
        
    }

    
    public abstract void onReceive(Context context, Intent intent);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.010 -0400", hash_original_method = "A694EC135053AF2FEB071A12D3EE4319", hash_generated_method = "48716E623D1A6E97EAC750FAAA0655BA")
    public final PendingResult goAsync() {
        PendingResult varB4EAC82CA7396A68D541C85D26508E83_41189274 = null; 
        PendingResult res = mPendingResult;
        mPendingResult = null;
        varB4EAC82CA7396A68D541C85D26508E83_41189274 = res;
        varB4EAC82CA7396A68D541C85D26508E83_41189274.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_41189274;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.011 -0400", hash_original_method = "891D062EE6B5DF300B0D5F817EBA802C", hash_generated_method = "E6DDDB9EA9707758BCE4FA30A552C688")
    public IBinder peekService(Context myContext, Intent service) {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1972393225 = null; 
        IActivityManager am = ActivityManagerNative.getDefault();
        IBinder binder = null;
        try 
        {
            service.setAllowFds(false);
            binder = am.peekService(service, service.resolveTypeIfNeeded(
                    myContext.getContentResolver()));
        } 
        catch (RemoteException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1972393225 = binder;
        addTaint(myContext.getTaint());
        addTaint(service.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1972393225.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1972393225;
        
        
        
        
            
            
                    
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.012 -0400", hash_original_method = "D9C6679B9D8E9806D41E73EFA120BCFE", hash_generated_method = "D8B058A84574659F09A9DE8C943A316A")
    public final void setResultCode(int code) {
        checkSynchronousHint();
        mPendingResult.mResultCode = code;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.012 -0400", hash_original_method = "413D4442793CB2CD30088D833172245E", hash_generated_method = "E421CC68C9C883762BE71C988F0DF7D4")
    public final int getResultCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_73493056 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_73493056;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.012 -0400", hash_original_method = "326C45A93CAC69AE5F40CC5662FD4E21", hash_generated_method = "C90A109DB604318B2505A1C010330879")
    public final void setResultData(String data) {
        checkSynchronousHint();
        mPendingResult.mResultData = data;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.013 -0400", hash_original_method = "4500B5844C9E31997AA4128C2B631832", hash_generated_method = "FC02991FA9F9CCF13007335C8D596BA0")
    public final String getResultData() {
        String varB4EAC82CA7396A68D541C85D26508E83_1953526040 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1953526040 = mPendingResult != null ? mPendingResult.mResultData : null;
        varB4EAC82CA7396A68D541C85D26508E83_1953526040.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1953526040;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.013 -0400", hash_original_method = "A002D9C66CF7F2AA1D1827503AAC99EC", hash_generated_method = "AE999306C66D9D7D9F87E31E8790C266")
    public final void setResultExtras(Bundle extras) {
        checkSynchronousHint();
        mPendingResult.mResultExtras = extras;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.015 -0400", hash_original_method = "4CB90710C7A856F1CF5FAF169A56650C", hash_generated_method = "8B787EA9F097AD34F44C525B7A59CB8B")
    public final Bundle getResultExtras(boolean makeMap) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_494050489 = null; 
        Bundle varB4EAC82CA7396A68D541C85D26508E83_710475023 = null; 
        Bundle varB4EAC82CA7396A68D541C85D26508E83_2083233303 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_494050489 = null;
        } 
        Bundle e = mPendingResult.mResultExtras;
        varB4EAC82CA7396A68D541C85D26508E83_710475023 = e;
        mPendingResult.mResultExtras = e = new Bundle();
        varB4EAC82CA7396A68D541C85D26508E83_2083233303 = e;
        addTaint(makeMap);
        Bundle varA7E53CE21691AB073D9660D615818899_594267294; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_594267294 = varB4EAC82CA7396A68D541C85D26508E83_494050489;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_594267294 = varB4EAC82CA7396A68D541C85D26508E83_710475023;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_594267294 = varB4EAC82CA7396A68D541C85D26508E83_2083233303;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_594267294.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_594267294;
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.016 -0400", hash_original_method = "71BA20FC3DD345B39DB950803A39A1ED", hash_generated_method = "4E29E8202B08EC6E81632318D3263996")
    public final void setResult(int code, String data, Bundle extras) {
        checkSynchronousHint();
        mPendingResult.mResultCode = code;
        mPendingResult.mResultData = data;
        mPendingResult.mResultExtras = extras;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.017 -0400", hash_original_method = "AC60D9C3BD95277DA035DD6FF45A8CCB", hash_generated_method = "8CFF4E7C6B24C5A067889D155F9518D8")
    public final boolean getAbortBroadcast() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1666147234 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1666147234;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.018 -0400", hash_original_method = "EA4258D43E5FA594C300ACFA62523E77", hash_generated_method = "6C8DB09AA240CF4D79E5212B6813BBD7")
    public final void abortBroadcast() {
        checkSynchronousHint();
        mPendingResult.mAbortBroadcast = true;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.018 -0400", hash_original_method = "7C3FDE5990F70723754AFB92AED4E2CB", hash_generated_method = "8064B6E26B085DBF3888D9560DF7DC7F")
    public final void clearAbortBroadcast() {
        {
            mPendingResult.mAbortBroadcast = false;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.019 -0400", hash_original_method = "E46A4317E3055902B5625099FF6F383B", hash_generated_method = "A33BFBCA81A00BBBA6735414F0D43163")
    public final boolean isOrderedBroadcast() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1120965026 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1120965026;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.019 -0400", hash_original_method = "85C5802A7642DD110CD6FEA4F9597134", hash_generated_method = "A2D6DEF069F83D873D71BD6F723EE613")
    public final boolean isInitialStickyBroadcast() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_149878579 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_149878579;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.020 -0400", hash_original_method = "68B6314C0DA1E37C298D89B55CAE3400", hash_generated_method = "69D814F3B32F84B57634F91799811317")
    public final void setOrderedHint(boolean isOrdered) {
        addTaint(isOrdered);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.020 -0400", hash_original_method = "D4C333B718143025A27C15902000FB77", hash_generated_method = "D9AD103DE2626E233CF20E2D5E772BFB")
    public final void setPendingResult(PendingResult result) {
        mPendingResult = result;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.021 -0400", hash_original_method = "DB63B22B6D1F06710FF3BD6349434467", hash_generated_method = "507438F14BB0C35E23998C69D292C03A")
    public final PendingResult getPendingResult() {
        PendingResult varB4EAC82CA7396A68D541C85D26508E83_1695252611 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1695252611 = mPendingResult;
        varB4EAC82CA7396A68D541C85D26508E83_1695252611.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1695252611;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.021 -0400", hash_original_method = "A942596201048EAFD951F2DD414301FD", hash_generated_method = "AE10474DE2420C2D522388046B0DF067")
    public final void setDebugUnregister(boolean debug) {
        mDebugUnregister = debug;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.022 -0400", hash_original_method = "19A67BCF6BEB94B2ECFD54D952C17B9D", hash_generated_method = "54FB0C781756EC49485649ED820B7461")
    public final boolean getDebugUnregister() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2119939352 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2119939352;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.022 -0400", hash_original_method = "719234F696D75BD5E624E0997AEC2529", hash_generated_method = "AA71A1DFB4A06A537E881E3BC513DF2A")
     void checkSynchronousHint() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Call while result is not pending");
        } 
        RuntimeException e = new RuntimeException(
                "BroadcastReceiver trying to return result during a non-ordered broadcast");
        e.fillInStackTrace();
        
        
            
        
        
            
        
        
                
        
        
    }

    
    public static class PendingResult {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.023 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "B93BF1EFA6B57CC598632E54B97CD147")

        int mType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.023 -0400", hash_original_field = "4543096C53DE46C32336566088E0F654", hash_generated_field = "CDB2CA9D2DC3E6D40D3791F468236C61")

        boolean mOrderedHint;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.023 -0400", hash_original_field = "E325CA8F9CFD351DD035C72EEE389226", hash_generated_field = "13A087E46995ABA3C3337E0311BCBB18")

        boolean mInitialStickyHint;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.023 -0400", hash_original_field = "98E8D2ECD335C543A384E2B940159AF2", hash_generated_field = "DD6EB7EC256F1225D4C6DC1A42FB765B")

        IBinder mToken;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.023 -0400", hash_original_field = "E5CED19E692744D577EC9F38B767773F", hash_generated_field = "457E6BFD9A88F809DF3F4A88B9B7B893")

        int mResultCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.023 -0400", hash_original_field = "3EAEFB392DB2F84FAED87A71E79A1093", hash_generated_field = "9297DC4168CE0E61BD9D0F02E127B543")

        String mResultData;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.023 -0400", hash_original_field = "15A7BDFA2595DFC979A8B0D8A65ABE14", hash_generated_field = "F5C1D34888409EAA7782FD08EA76AE47")

        Bundle mResultExtras;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.023 -0400", hash_original_field = "9D0CE3E2384F7D542D6BE0E686CC1587", hash_generated_field = "BE6D043F13884118A46F3E134D0352F1")

        boolean mAbortBroadcast;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.023 -0400", hash_original_field = "BB077E6B2FCDFA3F0EF71EB099A18F49", hash_generated_field = "10598AB9B4F301B505526794EAE9EAF0")

        boolean mFinished;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.024 -0400", hash_original_method = "A092172050E6E1EA8E89A6BB2F65A5D7", hash_generated_method = "7104FB540206A2CEFCEAF057A7D40607")
        public  PendingResult(int resultCode, String resultData, Bundle resultExtras,
                int type, boolean ordered, boolean sticky, IBinder token) {
            mResultCode = resultCode;
            mResultData = resultData;
            mResultExtras = resultExtras;
            mType = type;
            mOrderedHint = ordered;
            mInitialStickyHint = sticky;
            mToken = token;
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.024 -0400", hash_original_method = "8D188219D9B47ACA890A3A3FC0E4CDB9", hash_generated_method = "91B3DF7FB9FA90724BCAFC16EA2AF10F")
        public final void setResultCode(int code) {
            checkSynchronousHint();
            mResultCode = code;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.025 -0400", hash_original_method = "DAC102A9F551BEDDEF83F16167EFAEA6", hash_generated_method = "002FCE207FA7845A8E97DC48333C2134")
        public final int getResultCode() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2086037141 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2086037141;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.026 -0400", hash_original_method = "70EE21896C4793F2CD7F1124D2F52609", hash_generated_method = "C6722180D7D266018ABE6FE095677B2C")
        public final void setResultData(String data) {
            checkSynchronousHint();
            mResultData = data;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.027 -0400", hash_original_method = "AF28EEAF3BA9B8705C009D1FCC834AB4", hash_generated_method = "98DEF0E59B663649E40F7040B0F6BFEC")
        public final String getResultData() {
            String varB4EAC82CA7396A68D541C85D26508E83_1559401284 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1559401284 = mResultData;
            varB4EAC82CA7396A68D541C85D26508E83_1559401284.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1559401284;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.029 -0400", hash_original_method = "043EFA68A5EC6A2685391992580FAB4F", hash_generated_method = "3DC41E1A385242FB4F17457AEFAB3F81")
        public final void setResultExtras(Bundle extras) {
            checkSynchronousHint();
            mResultExtras = extras;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.030 -0400", hash_original_method = "48408ADF0828FD95531740A7B634349C", hash_generated_method = "ACB34243B95F29E869E8B11003B6755B")
        public final Bundle getResultExtras(boolean makeMap) {
            Bundle varB4EAC82CA7396A68D541C85D26508E83_1476119556 = null; 
            Bundle varB4EAC82CA7396A68D541C85D26508E83_78918429 = null; 
            Bundle e = mResultExtras;
            varB4EAC82CA7396A68D541C85D26508E83_1476119556 = e;
            mResultExtras = e = new Bundle();
            varB4EAC82CA7396A68D541C85D26508E83_78918429 = e;
            addTaint(makeMap);
            Bundle varA7E53CE21691AB073D9660D615818899_1099867735; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1099867735 = varB4EAC82CA7396A68D541C85D26508E83_1476119556;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1099867735 = varB4EAC82CA7396A68D541C85D26508E83_78918429;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1099867735.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1099867735;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.031 -0400", hash_original_method = "48338FF93B0D949C9CE50695C92AC674", hash_generated_method = "E3572DCCD03AA2F0DB19C6D7EC1CD89E")
        public final void setResult(int code, String data, Bundle extras) {
            checkSynchronousHint();
            mResultCode = code;
            mResultData = data;
            mResultExtras = extras;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.032 -0400", hash_original_method = "27570BF34E94ABF03E65F54A5F2272E5", hash_generated_method = "B89E844B6ECADAC137F69822F8A15017")
        public final boolean getAbortBroadcast() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_715873216 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_715873216;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.032 -0400", hash_original_method = "1D9776C1F73983B7C91D53BC3475252B", hash_generated_method = "0F92C63DCD6A0EC0FE789EDB71DC5FA6")
        public final void abortBroadcast() {
            checkSynchronousHint();
            mAbortBroadcast = true;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.033 -0400", hash_original_method = "D4C82CDA8EB6714DAE416B0884FCBC85", hash_generated_method = "6C1AABD9192E1E0A43D3F6EB36BA7FB9")
        public final void clearAbortBroadcast() {
            mAbortBroadcast = false;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.318 -0400", hash_original_method = "D8A44D8DD1BCA140D23101E83E968FA0", hash_generated_method = "EDF10ED5715FE807A457C2796ECDA23E")
        public final void finish() {
            {
                final IActivityManager mgr;
                mgr = ActivityManagerNative.getDefault();
                {
                    boolean var5DFCE705551B272DAF84D13C6908ADBA_523916475 = (QueuedWork.hasPendingWork());
                    {
                        QueuedWork.singleThreadExecutor().execute( new Runnable() {                            
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.318 -0400", hash_original_method = "30493EB99D3B9C52A729521ECBA96102", hash_generated_method = "9E0FC75885C1685D2CF05C0710DCED56")
                            @Override
                            public void run() {
                                sendFinished(mgr);
                                
                                
                                    
                                
                            }
});
                    } 
                    {
                        sendFinished(mgr);
                    } 
                } 
            } 
            {
                IActivityManager mgr;
                mgr = ActivityManagerNative.getDefault();
                sendFinished(mgr);
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.033 -0400", hash_original_method = "09CFE321AB9E3444E3559F2B522AB2BE", hash_generated_method = "449E6A93D95685E4BACE2BE26A644340")
        public void setExtrasClassLoader(ClassLoader cl) {
            {
                mResultExtras.setClassLoader(cl);
            } 
            addTaint(cl.getTaint());
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.034 -0400", hash_original_method = "AADF9DDAF1334800EDC66F9968E01FC0", hash_generated_method = "82854CD468D87D473A258E20C785332C")
        public void sendFinished(IActivityManager am) {
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Broadcast already finished");
                } 
                mFinished = true;
                try 
                {
                    {
                        mResultExtras.setAllowFds(false);
                    } 
                    {
                        am.finishReceiver(mToken, mResultCode, mResultData, mResultExtras,
                                mAbortBroadcast);
                    } 
                    {
                        am.finishReceiver(mToken, 0, null, null, false);
                    } 
                } 
                catch (RemoteException ex)
                { }
            } 
            addTaint(am.getTaint());
            
            
                
                    
                
                
                
                    
                        
                    
                    
                        
                                
                    
                        
                    
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.034 -0400", hash_original_method = "82A6C5AFD458725D364E088D203D4257", hash_generated_method = "111C3CB815EAC8DDB97C0D6AD95C69F8")
         void checkSynchronousHint() {
            RuntimeException e = new RuntimeException(
                    "BroadcastReceiver trying to return result during a non-ordered broadcast");
            e.fillInStackTrace();
            
            
                
            
            
                    
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.035 -0400", hash_original_field = "E9B12079BA81E4A9E223E3E69CBCC96B", hash_generated_field = "E4EA6E7A3F4417E09164CDDBDCB8CDCE")

        public static final int TYPE_COMPONENT = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.035 -0400", hash_original_field = "C0B0EFB5AB40BA1A534DADDC23FCCDC9", hash_generated_field = "06907A658310DA1AD3781E70CEE869F6")

        public static final int TYPE_REGISTERED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:22.035 -0400", hash_original_field = "98C92357CF58CE0F12209D8C57F14ED1", hash_generated_field = "502D0CFA37619833702608E6E5D5B79C")

        public static final int TYPE_UNREGISTERED = 2;
    }


    
}


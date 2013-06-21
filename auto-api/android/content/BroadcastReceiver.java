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
    private PendingResult mPendingResult;
    private boolean mDebugUnregister;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.986 -0400", hash_original_method = "2900F07960080430406180ADD3872CDD", hash_generated_method = "4949473B0E069ABC52AE38A1EB5EC2B1")
    @DSModeled(DSC.SAFE)
    public BroadcastReceiver() {
        // ---------- Original Method ----------
    }

    
    public abstract void onReceive(Context context, Intent intent);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.987 -0400", hash_original_method = "A694EC135053AF2FEB071A12D3EE4319", hash_generated_method = "0A057BC0AF12438AB7CB176138E4FA64")
    @DSModeled(DSC.SAFE)
    public final PendingResult goAsync() {
        PendingResult res;
        res = mPendingResult;
        mPendingResult = null;
        return (PendingResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PendingResult res = mPendingResult;
        //mPendingResult = null;
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.987 -0400", hash_original_method = "891D062EE6B5DF300B0D5F817EBA802C", hash_generated_method = "29B04778380668B044691FCE4F9F40C0")
    @DSModeled(DSC.SPEC)
    public IBinder peekService(Context myContext, Intent service) {
        dsTaint.addTaint(service.dsTaint);
        dsTaint.addTaint(myContext.dsTaint);
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
        return (IBinder)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.988 -0400", hash_original_method = "D9C6679B9D8E9806D41E73EFA120BCFE", hash_generated_method = "295C90065ABC4093853DBAE229785377")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setResultCode(int code) {
        dsTaint.addTaint(code);
        checkSynchronousHint();
        mPendingResult.mResultCode = code;
        // ---------- Original Method ----------
        //checkSynchronousHint();
        //mPendingResult.mResultCode = code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.988 -0400", hash_original_method = "413D4442793CB2CD30088D833172245E", hash_generated_method = "9D53A4C8FD52DB78082B65956C614E62")
    @DSModeled(DSC.SAFE)
    public final int getResultCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mResultCode : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.988 -0400", hash_original_method = "326C45A93CAC69AE5F40CC5662FD4E21", hash_generated_method = "37119D5D4FD95D329A95449283BFE6A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setResultData(String data) {
        dsTaint.addTaint(data);
        checkSynchronousHint();
        mPendingResult.mResultData = data;
        // ---------- Original Method ----------
        //checkSynchronousHint();
        //mPendingResult.mResultData = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.989 -0400", hash_original_method = "4500B5844C9E31997AA4128C2B631832", hash_generated_method = "7EA9BEE060CB88F9B5B001B7EB59B068")
    @DSModeled(DSC.SAFE)
    public final String getResultData() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mResultData : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.989 -0400", hash_original_method = "A002D9C66CF7F2AA1D1827503AAC99EC", hash_generated_method = "685F425FBC073638DD1CFBE60850FB54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setResultExtras(Bundle extras) {
        dsTaint.addTaint(extras.dsTaint);
        checkSynchronousHint();
        mPendingResult.mResultExtras = extras;
        // ---------- Original Method ----------
        //checkSynchronousHint();
        //mPendingResult.mResultExtras = extras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.989 -0400", hash_original_method = "4CB90710C7A856F1CF5FAF169A56650C", hash_generated_method = "F7322EC7CC5A51612387C393D6F90FD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Bundle getResultExtras(boolean makeMap) {
        dsTaint.addTaint(makeMap);
        Bundle e;
        e = mPendingResult.mResultExtras;
        mPendingResult.mResultExtras = e = new Bundle();
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mPendingResult == null) {
            //return null;
        //}
        //Bundle e = mPendingResult.mResultExtras;
        //if (!makeMap) return e;
        //if (e == null) mPendingResult.mResultExtras = e = new Bundle();
        //return e;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.990 -0400", hash_original_method = "71BA20FC3DD345B39DB950803A39A1ED", hash_generated_method = "52139C6B5DD9E200C66408DD03B2E66B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setResult(int code, String data, Bundle extras) {
        dsTaint.addTaint(data);
        dsTaint.addTaint(code);
        dsTaint.addTaint(extras.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.990 -0400", hash_original_method = "AC60D9C3BD95277DA035DD6FF45A8CCB", hash_generated_method = "53AFFA48CBC965CCC1ED71D9E8D8F5F0")
    @DSModeled(DSC.SAFE)
    public final boolean getAbortBroadcast() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mAbortBroadcast : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.990 -0400", hash_original_method = "EA4258D43E5FA594C300ACFA62523E77", hash_generated_method = "6C8DB09AA240CF4D79E5212B6813BBD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void abortBroadcast() {
        checkSynchronousHint();
        mPendingResult.mAbortBroadcast = true;
        // ---------- Original Method ----------
        //checkSynchronousHint();
        //mPendingResult.mAbortBroadcast = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.991 -0400", hash_original_method = "7C3FDE5990F70723754AFB92AED4E2CB", hash_generated_method = "8064B6E26B085DBF3888D9560DF7DC7F")
    @DSModeled(DSC.SAFE)
    public final void clearAbortBroadcast() {
        {
            mPendingResult.mAbortBroadcast = false;
        } //End block
        // ---------- Original Method ----------
        //if (mPendingResult != null) {
            //mPendingResult.mAbortBroadcast = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.991 -0400", hash_original_method = "E46A4317E3055902B5625099FF6F383B", hash_generated_method = "A44EE9ED67984D11550ADA72187EDCC0")
    @DSModeled(DSC.SAFE)
    public final boolean isOrderedBroadcast() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mOrderedHint : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.991 -0400", hash_original_method = "85C5802A7642DD110CD6FEA4F9597134", hash_generated_method = "0A14CD1C78462F6E04F33ABA5219B330")
    @DSModeled(DSC.SAFE)
    public final boolean isInitialStickyBroadcast() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mInitialStickyHint : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.992 -0400", hash_original_method = "68B6314C0DA1E37C298D89B55CAE3400", hash_generated_method = "53A1AD13C01085A1B3E91BAFE5EDE0C2")
    @DSModeled(DSC.SAFE)
    public final void setOrderedHint(boolean isOrdered) {
        dsTaint.addTaint(isOrdered);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.992 -0400", hash_original_method = "D4C333B718143025A27C15902000FB77", hash_generated_method = "79750101DDA3A6D127CB435658B82FA2")
    @DSModeled(DSC.SAFE)
    public final void setPendingResult(PendingResult result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
        //mPendingResult = result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.992 -0400", hash_original_method = "DB63B22B6D1F06710FF3BD6349434467", hash_generated_method = "39198EFC19CDFB8BD3C6B42426378F6D")
    @DSModeled(DSC.SAFE)
    public final PendingResult getPendingResult() {
        return (PendingResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mPendingResult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.993 -0400", hash_original_method = "A942596201048EAFD951F2DD414301FD", hash_generated_method = "DB4A06FDC3C13698A1D35B7FE34B304B")
    @DSModeled(DSC.SAFE)
    public final void setDebugUnregister(boolean debug) {
        dsTaint.addTaint(debug);
        // ---------- Original Method ----------
        //mDebugUnregister = debug;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.993 -0400", hash_original_method = "19A67BCF6BEB94B2ECFD54D952C17B9D", hash_generated_method = "984B55DD0C2CFAD6E7FF4A0BF6B50333")
    @DSModeled(DSC.SAFE)
    public final boolean getDebugUnregister() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDebugUnregister;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.993 -0400", hash_original_method = "719234F696D75BD5E624E0997AEC2529", hash_generated_method = "3524DA2E66B95DD8A6D82F927FB675C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        int mType;
        boolean mOrderedHint;
        boolean mInitialStickyHint;
        IBinder mToken;
        int mResultCode;
        String mResultData;
        Bundle mResultExtras;
        boolean mAbortBroadcast;
        boolean mFinished;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.994 -0400", hash_original_method = "A092172050E6E1EA8E89A6BB2F65A5D7", hash_generated_method = "3948E3265CA0ABA5BEAD8CC1B43FC17A")
        @DSModeled(DSC.SAFE)
        public PendingResult(int resultCode, String resultData, Bundle resultExtras,
                int type, boolean ordered, boolean sticky, IBinder token) {
            dsTaint.addTaint(resultData);
            dsTaint.addTaint(sticky);
            dsTaint.addTaint(resultExtras.dsTaint);
            dsTaint.addTaint(token.dsTaint);
            dsTaint.addTaint(ordered);
            dsTaint.addTaint(resultCode);
            dsTaint.addTaint(type);
            // ---------- Original Method ----------
            //mResultCode = resultCode;
            //mResultData = resultData;
            //mResultExtras = resultExtras;
            //mType = type;
            //mOrderedHint = ordered;
            //mInitialStickyHint = sticky;
            //mToken = token;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.994 -0400", hash_original_method = "8D188219D9B47ACA890A3A3FC0E4CDB9", hash_generated_method = "4A3EA738028055E2AB15C6776DF0E068")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void setResultCode(int code) {
            dsTaint.addTaint(code);
            checkSynchronousHint();
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mResultCode = code;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.995 -0400", hash_original_method = "DAC102A9F551BEDDEF83F16167EFAEA6", hash_generated_method = "7BDA57FF50F89965C6967026C7B7F619")
        @DSModeled(DSC.SAFE)
        public final int getResultCode() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mResultCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.995 -0400", hash_original_method = "70EE21896C4793F2CD7F1124D2F52609", hash_generated_method = "A7DBF06B74A7F253A3132D3586483F52")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void setResultData(String data) {
            dsTaint.addTaint(data);
            checkSynchronousHint();
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mResultData = data;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.995 -0400", hash_original_method = "AF28EEAF3BA9B8705C009D1FCC834AB4", hash_generated_method = "B07E62AF32D5DF45809CBF08531660F1")
        @DSModeled(DSC.SAFE)
        public final String getResultData() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mResultData;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.996 -0400", hash_original_method = "043EFA68A5EC6A2685391992580FAB4F", hash_generated_method = "481E0968694AE068A88DAF5D0A33DCC3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void setResultExtras(Bundle extras) {
            dsTaint.addTaint(extras.dsTaint);
            checkSynchronousHint();
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mResultExtras = extras;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.996 -0400", hash_original_method = "48408ADF0828FD95531740A7B634349C", hash_generated_method = "9B68F8E28C8A07763F58F5C42CC7E9F3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final Bundle getResultExtras(boolean makeMap) {
            dsTaint.addTaint(makeMap);
            Bundle e;
            e = mResultExtras;
            mResultExtras = e = new Bundle();
            return (Bundle)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Bundle e = mResultExtras;
            //if (!makeMap) return e;
            //if (e == null) mResultExtras = e = new Bundle();
            //return e;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.996 -0400", hash_original_method = "48338FF93B0D949C9CE50695C92AC674", hash_generated_method = "FEC3A6793B58442E1A68E621DD3C64E3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void setResult(int code, String data, Bundle extras) {
            dsTaint.addTaint(data);
            dsTaint.addTaint(code);
            dsTaint.addTaint(extras.dsTaint);
            checkSynchronousHint();
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mResultCode = code;
            //mResultData = data;
            //mResultExtras = extras;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.997 -0400", hash_original_method = "27570BF34E94ABF03E65F54A5F2272E5", hash_generated_method = "55445FA16524B79090DD5B451A6B80DA")
        @DSModeled(DSC.SAFE)
        public final boolean getAbortBroadcast() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mAbortBroadcast;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.997 -0400", hash_original_method = "1D9776C1F73983B7C91D53BC3475252B", hash_generated_method = "0F92C63DCD6A0EC0FE789EDB71DC5FA6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void abortBroadcast() {
            checkSynchronousHint();
            mAbortBroadcast = true;
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mAbortBroadcast = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.997 -0400", hash_original_method = "D4C82CDA8EB6714DAE416B0884FCBC85", hash_generated_method = "6C1AABD9192E1E0A43D3F6EB36BA7FB9")
        @DSModeled(DSC.SAFE)
        public final void clearAbortBroadcast() {
            mAbortBroadcast = false;
            // ---------- Original Method ----------
            //mAbortBroadcast = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.999 -0400", hash_original_method = "D8A44D8DD1BCA140D23101E83E968FA0", hash_generated_method = "53450703B89862DFDF6482104281382A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void finish() {
            {
                IActivityManager mgr;
                mgr = ActivityManagerNative.getDefault();
                {
                    boolean var5DFCE705551B272DAF84D13C6908ADBA_1452205064 = (QueuedWork.hasPendingWork());
                    {
                        QueuedWork.singleThreadExecutor().execute( new Runnable() {                            
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.998 -0400", hash_original_method = "30493EB99D3B9C52A729521ECBA96102", hash_generated_method = "9E0FC75885C1685D2CF05C0710DCED56")
                            //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.999 -0400", hash_original_method = "09CFE321AB9E3444E3559F2B522AB2BE", hash_generated_method = "194187BA9399B6B1DA240022660B5078")
        @DSModeled(DSC.BAN)
        public void setExtrasClassLoader(ClassLoader cl) {
            dsTaint.addTaint(cl.dsTaint);
            {
                mResultExtras.setClassLoader(cl);
            } //End block
            // ---------- Original Method ----------
            //if (mResultExtras != null) {
                //mResultExtras.setClassLoader(cl);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.000 -0400", hash_original_method = "AADF9DDAF1334800EDC66F9968E01FC0", hash_generated_method = "EF946FD5063EC5C2B701714AC4BA4227")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void sendFinished(IActivityManager am) {
            dsTaint.addTaint(am.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.000 -0400", hash_original_method = "82A6C5AFD458725D364E088D203D4257", hash_generated_method = "296373C43A6DCF6A0C41E2119507641E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        public static final int TYPE_COMPONENT = 0;
        public static final int TYPE_REGISTERED = 1;
        public static final int TYPE_UNREGISTERED = 2;
    }


    
}


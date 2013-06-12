package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.205 -0400", hash_original_method = "2900F07960080430406180ADD3872CDD", hash_generated_method = "8774C61539997392BA7206E25EA7715C")
    @DSModeled(DSC.SAFE)
    public BroadcastReceiver() {
        // ---------- Original Method ----------
    }

    
    public abstract void onReceive(Context context, Intent intent);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.205 -0400", hash_original_method = "A694EC135053AF2FEB071A12D3EE4319", hash_generated_method = "1122943CC2ED63E381CE580BB6BF176F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.205 -0400", hash_original_method = "891D062EE6B5DF300B0D5F817EBA802C", hash_generated_method = "CC47A1F88878410711495018788ACDD3")
    @DSModeled(DSC.SPEC)
    public IBinder peekService(Context myContext, Intent service) {
        dsTaint.addTaint(myContext.dsTaint);
        dsTaint.addTaint(service.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.206 -0400", hash_original_method = "D9C6679B9D8E9806D41E73EFA120BCFE", hash_generated_method = "EB5E396AB248C0A3D5B9D228CE03A312")
    @DSModeled(DSC.SAFE)
    public final void setResultCode(int code) {
        dsTaint.addTaint(code);
        checkSynchronousHint();
        mPendingResult.mResultCode = code;
        // ---------- Original Method ----------
        //checkSynchronousHint();
        //mPendingResult.mResultCode = code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.206 -0400", hash_original_method = "413D4442793CB2CD30088D833172245E", hash_generated_method = "B8FA259D769B6C9F066B9AEA42885575")
    @DSModeled(DSC.SAFE)
    public final int getResultCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mResultCode : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.206 -0400", hash_original_method = "326C45A93CAC69AE5F40CC5662FD4E21", hash_generated_method = "5D1B94CD045AFA989434E2E108056F83")
    @DSModeled(DSC.SAFE)
    public final void setResultData(String data) {
        dsTaint.addTaint(data);
        checkSynchronousHint();
        mPendingResult.mResultData = data;
        // ---------- Original Method ----------
        //checkSynchronousHint();
        //mPendingResult.mResultData = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.206 -0400", hash_original_method = "4500B5844C9E31997AA4128C2B631832", hash_generated_method = "1C603F7D6EFE50AF3FD79AD63F4B71BA")
    @DSModeled(DSC.SAFE)
    public final String getResultData() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mResultData : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.207 -0400", hash_original_method = "A002D9C66CF7F2AA1D1827503AAC99EC", hash_generated_method = "9E714B8E6426C8FE998E8F432CE8DFF5")
    @DSModeled(DSC.SAFE)
    public final void setResultExtras(Bundle extras) {
        dsTaint.addTaint(extras.dsTaint);
        checkSynchronousHint();
        mPendingResult.mResultExtras = extras;
        // ---------- Original Method ----------
        //checkSynchronousHint();
        //mPendingResult.mResultExtras = extras;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.207 -0400", hash_original_method = "4CB90710C7A856F1CF5FAF169A56650C", hash_generated_method = "1551482727DBEB35977BB084640AE2D5")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.207 -0400", hash_original_method = "71BA20FC3DD345B39DB950803A39A1ED", hash_generated_method = "B1146F6997475BE803E17D7C64E63A90")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.208 -0400", hash_original_method = "AC60D9C3BD95277DA035DD6FF45A8CCB", hash_generated_method = "1CDDE22BD82A730B5C7084A31100F9FD")
    @DSModeled(DSC.SAFE)
    public final boolean getAbortBroadcast() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mAbortBroadcast : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.208 -0400", hash_original_method = "EA4258D43E5FA594C300ACFA62523E77", hash_generated_method = "D742C29BD4E9A9C3CB53EADDF5944965")
    @DSModeled(DSC.SAFE)
    public final void abortBroadcast() {
        checkSynchronousHint();
        mPendingResult.mAbortBroadcast = true;
        // ---------- Original Method ----------
        //checkSynchronousHint();
        //mPendingResult.mAbortBroadcast = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.208 -0400", hash_original_method = "7C3FDE5990F70723754AFB92AED4E2CB", hash_generated_method = "528B74A7FA5FDCEB6AFC3BEC81826B30")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.208 -0400", hash_original_method = "E46A4317E3055902B5625099FF6F383B", hash_generated_method = "310A34C3169139865471A8C2EB3A9301")
    @DSModeled(DSC.SAFE)
    public final boolean isOrderedBroadcast() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mOrderedHint : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.209 -0400", hash_original_method = "85C5802A7642DD110CD6FEA4F9597134", hash_generated_method = "8E984C668A84F5D6DE0932DD458C42D2")
    @DSModeled(DSC.SAFE)
    public final boolean isInitialStickyBroadcast() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mPendingResult != null ? mPendingResult.mInitialStickyHint : false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.209 -0400", hash_original_method = "68B6314C0DA1E37C298D89B55CAE3400", hash_generated_method = "7461749CA99B14F4D868F7A49D6B94E0")
    @DSModeled(DSC.SAFE)
    public final void setOrderedHint(boolean isOrdered) {
        dsTaint.addTaint(isOrdered);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.209 -0400", hash_original_method = "D4C333B718143025A27C15902000FB77", hash_generated_method = "A55E921BE101E5260A5FDD86E02A81A6")
    @DSModeled(DSC.SAFE)
    public final void setPendingResult(PendingResult result) {
        dsTaint.addTaint(result.dsTaint);
        // ---------- Original Method ----------
        //mPendingResult = result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.209 -0400", hash_original_method = "DB63B22B6D1F06710FF3BD6349434467", hash_generated_method = "AE36FE5FAF168829C23784B09DF1E522")
    @DSModeled(DSC.SAFE)
    public final PendingResult getPendingResult() {
        return (PendingResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mPendingResult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.209 -0400", hash_original_method = "A942596201048EAFD951F2DD414301FD", hash_generated_method = "D88D506904528219B1ECBEE275F01C4B")
    @DSModeled(DSC.SAFE)
    public final void setDebugUnregister(boolean debug) {
        dsTaint.addTaint(debug);
        // ---------- Original Method ----------
        //mDebugUnregister = debug;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.210 -0400", hash_original_method = "19A67BCF6BEB94B2ECFD54D952C17B9D", hash_generated_method = "C8A4D6B93DA37F1DA35A416AC227A6C9")
    @DSModeled(DSC.SAFE)
    public final boolean getDebugUnregister() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDebugUnregister;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.210 -0400", hash_original_method = "719234F696D75BD5E624E0997AEC2529", hash_generated_method = "7D86956DBE937876D8EA083F32EDDAE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void checkSynchronousHint() {
        {
            throw new IllegalStateException("Call while result is not pending");
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
        public static final int TYPE_COMPONENT = 0;
        public static final int TYPE_REGISTERED = 1;
        public static final int TYPE_UNREGISTERED = 2;
        final int mType;
        final boolean mOrderedHint;
        final boolean mInitialStickyHint;
        final IBinder mToken;
        int mResultCode;
        String mResultData;
        Bundle mResultExtras;
        boolean mAbortBroadcast;
        boolean mFinished;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.210 -0400", hash_original_method = "A092172050E6E1EA8E89A6BB2F65A5D7", hash_generated_method = "DF9D66359C905C2A2921A4316130B7B5")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.211 -0400", hash_original_method = "8D188219D9B47ACA890A3A3FC0E4CDB9", hash_generated_method = "448D9AB084368EEDC68EFE3F5104CD95")
        @DSModeled(DSC.SAFE)
        public final void setResultCode(int code) {
            dsTaint.addTaint(code);
            checkSynchronousHint();
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mResultCode = code;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.211 -0400", hash_original_method = "DAC102A9F551BEDDEF83F16167EFAEA6", hash_generated_method = "E163C761CC24A0DC41704649F200B418")
        @DSModeled(DSC.SAFE)
        public final int getResultCode() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mResultCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.211 -0400", hash_original_method = "70EE21896C4793F2CD7F1124D2F52609", hash_generated_method = "DEF79553F4D1EF63CE9C179E33416E4A")
        @DSModeled(DSC.SAFE)
        public final void setResultData(String data) {
            dsTaint.addTaint(data);
            checkSynchronousHint();
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mResultData = data;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.211 -0400", hash_original_method = "AF28EEAF3BA9B8705C009D1FCC834AB4", hash_generated_method = "E39425C61A4153105FDEAB0936F7ABA3")
        @DSModeled(DSC.SAFE)
        public final String getResultData() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mResultData;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.212 -0400", hash_original_method = "043EFA68A5EC6A2685391992580FAB4F", hash_generated_method = "B7822A14B6EA842FFE7D5B8D477A7897")
        @DSModeled(DSC.SAFE)
        public final void setResultExtras(Bundle extras) {
            dsTaint.addTaint(extras.dsTaint);
            checkSynchronousHint();
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mResultExtras = extras;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.212 -0400", hash_original_method = "48408ADF0828FD95531740A7B634349C", hash_generated_method = "4E723CBCA2D3E1BAEA730F7FA1BED448")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.212 -0400", hash_original_method = "48338FF93B0D949C9CE50695C92AC674", hash_generated_method = "63C4C4E4C693C47711CACBBAE034D214")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.213 -0400", hash_original_method = "27570BF34E94ABF03E65F54A5F2272E5", hash_generated_method = "A651F2260718EA363374E855EB0CA296")
        @DSModeled(DSC.SAFE)
        public final boolean getAbortBroadcast() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mAbortBroadcast;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.213 -0400", hash_original_method = "1D9776C1F73983B7C91D53BC3475252B", hash_generated_method = "0BCD9DAEA473DA976885EBA807308A88")
        @DSModeled(DSC.SAFE)
        public final void abortBroadcast() {
            checkSynchronousHint();
            mAbortBroadcast = true;
            // ---------- Original Method ----------
            //checkSynchronousHint();
            //mAbortBroadcast = true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.213 -0400", hash_original_method = "D4C82CDA8EB6714DAE416B0884FCBC85", hash_generated_method = "4A1A6C6C057D693DE41557698755FB75")
        @DSModeled(DSC.SAFE)
        public final void clearAbortBroadcast() {
            mAbortBroadcast = false;
            // ---------- Original Method ----------
            //mAbortBroadcast = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.214 -0400", hash_original_method = "D8A44D8DD1BCA140D23101E83E968FA0", hash_generated_method = "56A4371DBB5A6A61EB46152DDDCE5BC4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void finish() {
            {
                final IActivityManager mgr;
                mgr = ActivityManagerNative.getDefault();
                {
                    boolean var5DFCE705551B272DAF84D13C6908ADBA_1774410046 = (QueuedWork.hasPendingWork());
                    {
                        QueuedWork.singleThreadExecutor().execute( new Runnable() {
                        @Override public void run() {
                            if (ActivityThread.DEBUG_BROADCAST) Slog.i(ActivityThread.TAG,
                                    "Finishing broadcast after work to component " + mToken);
                            sendFinished(mgr);
                        }
                    });
                    } //End block
                    {
                        sendFinished(mgr);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                final IActivityManager mgr;
                mgr = ActivityManagerNative.getDefault();
                sendFinished(mgr);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.214 -0400", hash_original_method = "09CFE321AB9E3444E3559F2B522AB2BE", hash_generated_method = "3700D89D534A3513B08CB80DA6480B44")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.214 -0400", hash_original_method = "AADF9DDAF1334800EDC66F9968E01FC0", hash_generated_method = "9D7A8820F36828042729B80947AEB8F9")
        @DSModeled(DSC.SAFE)
        public void sendFinished(IActivityManager am) {
            dsTaint.addTaint(am.dsTaint);
            {
                {
                    throw new IllegalStateException("Broadcast already finished");
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.214 -0400", hash_original_method = "82A6C5AFD458725D364E088D203D4257", hash_generated_method = "8BFBC5598C2AC097C152A42E43361C94")
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

        
    }


    
}



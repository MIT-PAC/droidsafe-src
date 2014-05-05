package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static android.Manifest.permission.READ_PHONE_STATE;
import android.app.ActivityManagerNative;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.Registrant;
import android.os.RegistrantList;
import android.util.Log;
import android.view.WindowManager;

import com.android.internal.R;
import com.android.internal.telephony.CommandsInterface.RadioState;

public abstract class IccCard {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.913 -0500", hash_original_field = "D4D543F1047C9B2003A73F47EAB03030", hash_generated_field = "8A87A39EB5C77A6355AD19F1EDFA4D50")

                                            // Will be updated when SIM_READY.

    /* The extra data for broacasting intent INTENT_ICC_STATE_CHANGE */
    static public final String INTENT_KEY_ICC_STATE = "ss";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.916 -0500", hash_original_field = "14C019495D2A3ECBD00B1A62B83451D5", hash_generated_field = "559004855AF26038D1301B2EB2A81958")

    static public final String INTENT_VALUE_ICC_NOT_READY = "NOT_READY";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.918 -0500", hash_original_field = "BDE099F05029869D451460C1714A230E", hash_generated_field = "09E173E394E5D91B9D74B048E28CDA40")

    static public final String INTENT_VALUE_ICC_ABSENT = "ABSENT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.921 -0500", hash_original_field = "4E16A3976833EDC80BC36BED02F9DBCF", hash_generated_field = "B9ECAC99CC48A7FA1E2E4234F2D4F8DD")

    static public final String INTENT_VALUE_ICC_LOCKED = "LOCKED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.923 -0500", hash_original_field = "1BE80104E88BC642454BEF963C0F8162", hash_generated_field = "299CBCB1408043E9A327CC84FDCBEEB1")

    static public final String INTENT_VALUE_ICC_READY = "READY";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.926 -0500", hash_original_field = "1D1551EC9CAE8BA1B45C8841D26EF42B", hash_generated_field = "B11FF3A7F190CFA1F78B0A44A9BC2F7F")

    static public final String INTENT_VALUE_ICC_IMSI = "IMSI";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.929 -0500", hash_original_field = "72D4D1D5B7AC57F6828C03DCEA5E437D", hash_generated_field = "5A47219824FC4CE98A1CDF755912F5D3")

    static public final String INTENT_VALUE_ICC_LOADED = "LOADED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.931 -0500", hash_original_field = "6C676A675BA4263561E1F04E0574225D", hash_generated_field = "B52DE1E639231C806713539135C0EC44")

    static public final String INTENT_KEY_LOCKED_REASON = "reason";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.934 -0500", hash_original_field = "296BEA6264E8CC889222CD2BB54ACCF3", hash_generated_field = "8CB239DD07ED9D2B9354AF9790A52085")

    static public final String INTENT_VALUE_LOCKED_ON_PIN = "PIN";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.936 -0500", hash_original_field = "6B2F2B2AE90E43FE0919F405A0CCE6C9", hash_generated_field = "9D4E8CF5E08E88C5263AD804A1CC2E40")

    static public final String INTENT_VALUE_LOCKED_ON_PUK = "PUK";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.939 -0500", hash_original_field = "C4B4C965FEE514D058F2B5FBCFEDD63C", hash_generated_field = "E414FAB7F3419E8267A72ED727E98329")

    static public final String INTENT_VALUE_LOCKED_NETWORK = "NETWORK";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.941 -0500", hash_original_field = "E449A9B4FCB309B899F5B8B784CC01E7", hash_generated_field = "1AC6CFB4E094233EA40DDF5454436669")

    static public final String INTENT_VALUE_ABSENT_ON_PERM_DISABLED = "PERM_DISABLED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.944 -0500", hash_original_field = "908E3DA617EDC8301116341FF707E0D5", hash_generated_field = "BB00981FA4DDC48E77E3446841ED578B")

    protected static final int EVENT_ICC_LOCKED_OR_ABSENT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.946 -0500", hash_original_field = "22F5B690EF2CD8E2EE520E9F46E92A53", hash_generated_field = "6A530CAC29AE5BD3085335985B2810BD")

    private static final int EVENT_GET_ICC_STATUS_DONE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.949 -0500", hash_original_field = "2F5C1A623ECC9F5EC5F2AC12DAEB3272", hash_generated_field = "A5743C4EFFAC98F496715C592912CE53")

    protected static final int EVENT_RADIO_OFF_OR_NOT_AVAILABLE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.952 -0500", hash_original_field = "A5B66559D338F68D4D22651C39528487", hash_generated_field = "A8FC0B827122F18799DB60E3B856F9C1")

    private static final int EVENT_PINPUK_DONE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.955 -0500", hash_original_field = "3CEF37B4BA6C90AC77797062EE393BFA", hash_generated_field = "242135FAED9E4D8578354B9454EB35C3")

    private static final int EVENT_REPOLL_STATUS_DONE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.957 -0500", hash_original_field = "9A71B7A14D229C553BA58FF1EB380E01", hash_generated_field = "D730302ED7BCEEDF4EEB2F6802EE57FD")

    protected static final int EVENT_ICC_READY = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.960 -0500", hash_original_field = "778D91F6D5AC97A723EC5F31131A8590", hash_generated_field = "F4D6932778576F707B7936043C92F42A")

    private static final int EVENT_QUERY_FACILITY_LOCK_DONE = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.962 -0500", hash_original_field = "C10CBF9ED0D79F8D777372A994A2C0DB", hash_generated_field = "E362BB0C36E7DC31306182774E294D5E")

    private static final int EVENT_CHANGE_FACILITY_LOCK_DONE = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.964 -0500", hash_original_field = "F3DB81D347D7678B765B3A31FD5CE2CD", hash_generated_field = "97EFE391ADDE4F597A8812D5755BC729")

    private static final int EVENT_CHANGE_ICC_PASSWORD_DONE = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.967 -0500", hash_original_field = "349B3C05E68B574F45A45B321D5C7562", hash_generated_field = "0DB4D493C14133032F82ADA18DCB4118")

    private static final int EVENT_QUERY_FACILITY_FDN_DONE = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.969 -0500", hash_original_field = "B6FD3C0C5B7F992BCFC64C1E4CC8BA8A", hash_generated_field = "9C46342A37891DB5C8514A911C636E35")

    private static final int EVENT_CHANGE_FACILITY_FDN_DONE = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.972 -0500", hash_original_field = "0C184532D7C41DA69738537806A58D47", hash_generated_field = "11BCA9CD0D4020ECA2009590B4FB03A5")

    private static final int EVENT_ICC_STATUS_CHANGED = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.975 -0500", hash_original_field = "4A4FBB303FE21A44A5A86552DCAC9F19", hash_generated_field = "67A04E786502FED24B042568D76A6216")

    private static final int EVENT_CARD_REMOVED = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.977 -0500", hash_original_field = "7F54C8B5F0D7430839EA3F79EF7A5F6E", hash_generated_field = "E825A176BF633732EFFA825E7EFB90AA")

    private static final int EVENT_CARD_ADDED = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.885 -0500", hash_original_field = "18BDC329C18DD371A79CC5D2B91C72D1", hash_generated_field = "621F1F8A1A73F0186C3B2A8FD458DBF8")

    protected String mLogTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.888 -0500", hash_original_field = "98EF8A00223855ADD4046664C356431D", hash_generated_field = "05625C1A8AEC158E47E651E2912A02BB")

    protected boolean mDbg;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.890 -0500", hash_original_field = "4DFC38738F792EE047A12B2367FF8FE4", hash_generated_field = "9B1F8CAC61F695F54D4232EE65554395")

    private IccCardStatus mIccCardStatus = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.892 -0500", hash_original_field = "FDF14B357CA81047BB566D7F43FE741B", hash_generated_field = "B2CB76BA7B9E699C7A661DE6BE3920DB")

    protected State mState = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.894 -0500", hash_original_field = "B504049739EC0253F0006BF183324917", hash_generated_field = "C5284483C4CF8ED630A2E2607ED30E12")

    protected PhoneBase mPhone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.897 -0500", hash_original_field = "B2A45751A2F2A2746290AE187E1CD909", hash_generated_field = "BB4D0C0D6F697E88C9F5A7A0E99C541E")

    private RegistrantList mAbsentRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.899 -0500", hash_original_field = "AD1B2312536B582D9EA7E6D54E9D9F80", hash_generated_field = "7FBB4558DC3714EECB6D5E802875936C")

    private RegistrantList mPinLockedRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.901 -0500", hash_original_field = "3676460D3C258B51A5B2B588A615F813", hash_generated_field = "810D4E60FCDB2F59BE3AFC34BFC4D065")

    private RegistrantList mNetworkLockedRegistrants = new RegistrantList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.903 -0500", hash_original_field = "634B31ADDFD620E22891C51BCAD13FE4", hash_generated_field = "6F5CD85185F4F8603950244B00F7B22C")

    private boolean mDesiredPinLocked;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.906 -0500", hash_original_field = "C8A3628586A70970BF0DC5D80000B904", hash_generated_field = "4055529E8474844347F470FAB93250EC")

    private boolean mDesiredFdnEnabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.908 -0500", hash_original_field = "AA5176B18F77BE079A485C547DBA5338", hash_generated_field = "4F01E642146FEA0D727EF809A7BAFF77")

    private boolean mIccPinLocked = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.911 -0500", hash_original_field = "1AD2F411E97991469AEE3DDDA148C9EE", hash_generated_field = "385C08A9E0809A77275EED9469D8B1F1")

    private boolean mIccFdnEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.729 -0400", hash_original_field = "8DDBBF399F5C4180FC40887A4067CEFE", hash_generated_field = "33F47C802D626FE59E34A5FF2AE3F321")

    protected Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.729 -0400", hash_original_method = "4D8A280AC680F77EA465CFA0E90830BC", hash_generated_method = "628A259BA249F1A1D0ECF617B0AD4CA9")
        @Override
        public void handleMessage(Message msg) {
            AsyncResult ar;
            int serviceClassX;
            serviceClassX = CommandsInterface.SERVICE_CLASS_VOICE +
                            CommandsInterface.SERVICE_CLASS_DATA +
                            CommandsInterface.SERVICE_CLASS_FAX;
            
            mState = null;
            
            updateStateProperty();
            
            broadcastIccStateChangedIntent(INTENT_VALUE_ICC_NOT_READY, null);
            
            mPhone.mCM.getIccCardStatus(obtainMessage(EVENT_GET_ICC_STATUS_DONE));
            
            mPhone.mCM.queryFacilityLock (
                            CommandsInterface.CB_FACILITY_BA_SIM, "", serviceClassX,
                            obtainMessage(EVENT_QUERY_FACILITY_LOCK_DONE));
            
            mPhone.mCM.queryFacilityLock (
                            CommandsInterface.CB_FACILITY_BA_FD, "", serviceClassX,
                            obtainMessage(EVENT_QUERY_FACILITY_FDN_DONE));
            
            mPhone.mCM.getIccCardStatus(obtainMessage(EVENT_GET_ICC_STATUS_DONE));
            
            mPhone.mCM.queryFacilityLock (
                            CommandsInterface.CB_FACILITY_BA_SIM, "", serviceClassX,
                            obtainMessage(EVENT_QUERY_FACILITY_LOCK_DONE));
            
            ar = (AsyncResult)msg.obj;
            
            getIccCardStatusDone(ar);
            
            ar = (AsyncResult)msg.obj;
            
            AsyncResult.forMessage(((Message)ar.userObj)).exception
                                                        = ar.exception;
            
            mPhone.mCM.getIccCardStatus(
                        obtainMessage(EVENT_REPOLL_STATUS_DONE, ar.userObj));
            
            ar = (AsyncResult)msg.obj;
            
            getIccCardStatusDone(ar);
            
            ((Message)ar.userObj).sendToTarget();
            
            ar = (AsyncResult)msg.obj;
            
            onQueryFacilityLock(ar);
            
            ar = (AsyncResult)msg.obj;
            
            onQueryFdnEnabled(ar);
            
            ar = (AsyncResult)msg.obj;
            
            {
                mIccPinLocked = mDesiredPinLocked;
                log( "EVENT_CHANGE_FACILITY_LOCK_DONE: " +
                                "mIccPinLocked= " + mIccPinLocked);
            }
            
            AsyncResult.forMessage(((Message)ar.userObj)).exception
                                                        = ar.exception;
            
            ((Message)ar.userObj).sendToTarget();
            
            ar = (AsyncResult)msg.obj;
            
            {
                mIccFdnEnabled = mDesiredFdnEnabled;
                log("EVENT_CHANGE_FACILITY_FDN_DONE: " +
                                "mIccFdnEnabled=" + mIccFdnEnabled);
            }
            
            AsyncResult.forMessage(((Message)ar.userObj)).exception
                                                        = ar.exception;
            
            ((Message)ar.userObj).sendToTarget();
            
            ar = (AsyncResult)msg.obj;
            
            AsyncResult.forMessage(((Message)ar.userObj)).exception
                                                        = ar.exception;
            
            ((Message)ar.userObj).sendToTarget();
            
            Log.d(mLogTag, "Received Event EVENT_ICC_STATUS_CHANGED");
            
            mPhone.mCM.getIccCardStatus(obtainMessage(EVENT_GET_ICC_STATUS_DONE));
            
            onIccSwap(false);
            
            onIccSwap(true);
            
            addTaint(msg.getTaint());
            
        }
        
};

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.990 -0500", hash_original_method = "A83C78588609731AFA33B82B4815F4C9", hash_generated_method = "6C09E518971340836FFF5E7ED8C84EDC")
    
public IccCard(PhoneBase phone, String logTag, Boolean dbg) {
        mPhone = phone;
        mPhone.mCM.registerForIccStatusChanged(mHandler, EVENT_ICC_STATUS_CHANGED, null);
        mLogTag = logTag;
        mDbg = dbg;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.987 -0500", hash_original_method = "B45586395D9726A6E3A7A444B2DA9D4A", hash_generated_method = "3041CBCDD59FEBAA53583A03841BA798")
    
public State getState() {
        if (mState == null) {
            switch(mPhone.mCM.getRadioState()) {
                /* This switch block must not return anything in
                 * State.isLocked() or State.ABSENT.
                 * If it does, handleSimStatus() may break
                 */
                case RADIO_OFF:
                case RADIO_UNAVAILABLE:
                case SIM_NOT_READY:
                case RUIM_NOT_READY:
                    return State.UNKNOWN;
                case SIM_LOCKED_OR_ABSENT:
                case RUIM_LOCKED_OR_ABSENT:
                    //this should be transient-only
                    return State.UNKNOWN;
                case SIM_READY:
                case RUIM_READY:
                case NV_READY:
                    return State.READY;
                case NV_NOT_READY:
                    return State.ABSENT;
            }
        } else {
            return mState;
        }

        Log.e(mLogTag, "IccCard.getState(): case should never be reached");
        return State.UNKNOWN;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.992 -0500", hash_original_method = "EF67D81D926CA0EC8F8754BC29C8826B", hash_generated_method = "6107104537155EE89F2ED0E8E5D9E448")
    
public void dispose() {
        mPhone.mCM.unregisterForIccStatusChanged(mHandler);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.995 -0500", hash_original_method = "C148A728067D02A221BE75C987C5D733", hash_generated_method = "64BE1B6F3A78A41FF6DFB2C87523D86E")
    
protected void finalize() {
        if(mDbg) Log.d(mLogTag, "IccCard finalized");
    }

    /**
     * Notifies handler of any transition into State.ABSENT
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.997 -0500", hash_original_method = "45A4F957AA9A104F89D6FFEF5C13C9B4", hash_generated_method = "BF180076901D307C137E7743F73C5AD4")
    
public void registerForAbsent(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);

        mAbsentRegistrants.add(r);

        if (getState() == State.ABSENT) {
            r.notifyRegistrant();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.999 -0500", hash_original_method = "A388490F008524959D490318F4B49030", hash_generated_method = "89E2590810C3CD948B6A5C301325A220")
    
public void unregisterForAbsent(Handler h) {
        mAbsentRegistrants.remove(h);
    }

    /**
     * Notifies handler of any transition into State.NETWORK_LOCKED
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.002 -0500", hash_original_method = "DD13D18C49861341C8AF8EABF1CC2E24", hash_generated_method = "CE1A725C767BB05D2C6F7D34CFCB8929")
    
public void registerForNetworkLocked(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);

        mNetworkLockedRegistrants.add(r);

        if (getState() == State.NETWORK_LOCKED) {
            r.notifyRegistrant();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.004 -0500", hash_original_method = "5CEB6427435BFB9EC514E781B4093E7E", hash_generated_method = "AE54CB43A4FB4F74B4E03E7B395EE6BE")
    
public void unregisterForNetworkLocked(Handler h) {
        mNetworkLockedRegistrants.remove(h);
    }

    /**
     * Notifies handler of any transition into State.isPinLocked()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.006 -0500", hash_original_method = "A158B3B1FDF0C70FEF29C25B6F4DD072", hash_generated_method = "48F2139074B53E356A96B80B12FCA88B")
    
public void registerForLocked(Handler h, int what, Object obj) {
        Registrant r = new Registrant (h, what, obj);

        mPinLockedRegistrants.add(r);

        if (getState().isPinLocked()) {
            r.notifyRegistrant();
        }
    }
    
    public enum State {
        UNKNOWN,
        ABSENT,
        PIN_REQUIRED,
        PUK_REQUIRED,
        NETWORK_LOCKED,
        READY,
        NOT_READY,
        PERM_DISABLED;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.981 -0500", hash_original_method = "54DD978A878D83C93C944CF146FC0FEE", hash_generated_method = "64EBE77F963959A7614DC3A9A6A55936")
            
public boolean isPinLocked() {
            return ((this == PIN_REQUIRED) || (this == PUK_REQUIRED));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:10.983 -0500", hash_original_method = "F64830E5A182086A00887EFA5426EBAC", hash_generated_method = "C7FCE09706769F5934028408DBCE2BFA")
            
public boolean iccCardExist() {
            return ((this == PIN_REQUIRED) || (this == PUK_REQUIRED)
                    || (this == NETWORK_LOCKED) || (this == READY)
                    || (this == PERM_DISABLED));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.008 -0500", hash_original_method = "5667345A02500557814700DAC5845BCA", hash_generated_method = "23684C92E898AF5AB7FA66F762311F27")
    
public void unregisterForLocked(Handler h) {
        mPinLockedRegistrants.remove(h);
    }

    /**
     * Supply the ICC PIN to the ICC
     *
     * When the operation is complete, onComplete will be sent to its
     * Handler.
     *
     * onComplete.obj will be an AsyncResult
     *
     * ((AsyncResult)onComplete.obj).exception == null on success
     * ((AsyncResult)onComplete.obj).exception != null on fail
     *
     * If the supplied PIN is incorrect:
     * ((AsyncResult)onComplete.obj).exception != null
     * && ((AsyncResult)onComplete.obj).exception
     *       instanceof com.android.internal.telephony.gsm.CommandException)
     * && ((CommandException)(((AsyncResult)onComplete.obj).exception))
     *          .getCommandError() == CommandException.Error.PASSWORD_INCORRECT
     *
     *
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.011 -0500", hash_original_method = "ADEE02A4D2D0DF5B5C1110C0F3EF40D9", hash_generated_method = "F9D6911F5116DD52009A36CA732D275D")
    
public void supplyPin (String pin, Message onComplete) {
        mPhone.mCM.supplyIccPin(pin, mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.013 -0500", hash_original_method = "F069297D525546A0218C2FB5A43E0287", hash_generated_method = "28D847B30A8A4EDD7DC98BD2FD5DD864")
    
public void supplyPuk (String puk, String newPin, Message onComplete) {
        mPhone.mCM.supplyIccPuk(puk, newPin,
                mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.017 -0500", hash_original_method = "35EFF2F2C787166AB4A51F303C9455F4", hash_generated_method = "0B3170BA0BAA19D62C883A9A8EC60B98")
    
public void supplyPin2 (String pin2, Message onComplete) {
        mPhone.mCM.supplyIccPin2(pin2,
                mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.019 -0500", hash_original_method = "982062922CE016EAC29E809D9B066C8E", hash_generated_method = "CB435DC78203C2E00A805BDF77A2FD81")
    
public void supplyPuk2 (String puk2, String newPin2, Message onComplete) {
        mPhone.mCM.supplyIccPuk2(puk2, newPin2,
                mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.021 -0500", hash_original_method = "96497D4DFF6E2FE9CEEE26788CBD4E3F", hash_generated_method = "F09F8B2FB8209D4399684923099299F8")
    
public void supplyNetworkDepersonalization (String pin, Message onComplete) {
        mPhone.mCM.supplyNetworkDepersonalization(pin,
                mHandler.obtainMessage(EVENT_PINPUK_DONE, onComplete));
    }

    /**
     * Check whether ICC pin lock is enabled
     * This is a sync call which returns the cached pin enabled state
     *
     * @return true for ICC locked enabled
     *         false for ICC locked disabled
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.023 -0500", hash_original_method = "BCA6EFC1210C838BF4CD916790946AA6", hash_generated_method = "EA47A82983C5A0412B6EFC3D5B5BC1CF")
    
public boolean getIccLockEnabled() {
        return mIccPinLocked;
     }

    /**
     * Check whether ICC fdn (fixed dialing number) is enabled
     * This is a sync call which returns the cached pin enabled state
     *
     * @return true for ICC fdn enabled
     *         false for ICC fdn disabled
     */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.025 -0500", hash_original_method = "F2BBF6EB30564DA8841F6D4A48D01D80", hash_generated_method = "D74FAE77089CBC857E6ACA25BA0CC75C")
    
public boolean getIccFdnEnabled() {
        return mIccFdnEnabled;
     }

     /**
      * Set the ICC pin lock enabled or disabled
      * When the operation is complete, onComplete will be sent to its handler
      *
      * @param enabled "true" for locked "false" for unlocked.
      * @param password needed to change the ICC pin state, aka. Pin1
      * @param onComplete
      *        onComplete.obj will be an AsyncResult
      *        ((AsyncResult)onComplete.obj).exception == null on success
      *        ((AsyncResult)onComplete.obj).exception != null on fail
      */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.028 -0500", hash_original_method = "3DCE16ED303A66C1573E6E04CDCFB500", hash_generated_method = "B149D627EC0091F437FF04B73FF202E8")
    
public void setIccLockEnabled (boolean enabled,
             String password, Message onComplete) {
         int serviceClassX;
         serviceClassX = CommandsInterface.SERVICE_CLASS_VOICE +
                 CommandsInterface.SERVICE_CLASS_DATA +
                 CommandsInterface.SERVICE_CLASS_FAX;

         mDesiredPinLocked = enabled;

         mPhone.mCM.setFacilityLock(CommandsInterface.CB_FACILITY_BA_SIM,
                 enabled, password, serviceClassX,
                 mHandler.obtainMessage(EVENT_CHANGE_FACILITY_LOCK_DONE, onComplete));
     }

     /**
      * Set the ICC fdn enabled or disabled
      * When the operation is complete, onComplete will be sent to its handler
      *
      * @param enabled "true" for locked "false" for unlocked.
      * @param password needed to change the ICC fdn enable, aka Pin2
      * @param onComplete
      *        onComplete.obj will be an AsyncResult
      *        ((AsyncResult)onComplete.obj).exception == null on success
      *        ((AsyncResult)onComplete.obj).exception != null on fail
      */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.030 -0500", hash_original_method = "42161809775FC8FDBB38BE3E5058E399", hash_generated_method = "33C21CE5F744E92A5EC8A5A845A8F41B")
    
public void setIccFdnEnabled (boolean enabled,
             String password, Message onComplete) {
         int serviceClassX;
         serviceClassX = CommandsInterface.SERVICE_CLASS_VOICE +
                 CommandsInterface.SERVICE_CLASS_DATA +
                 CommandsInterface.SERVICE_CLASS_FAX +
                 CommandsInterface.SERVICE_CLASS_SMS;

         mDesiredFdnEnabled = enabled;

         mPhone.mCM.setFacilityLock(CommandsInterface.CB_FACILITY_BA_FD,
                 enabled, password, serviceClassX,
                 mHandler.obtainMessage(EVENT_CHANGE_FACILITY_FDN_DONE, onComplete));
     }

     /**
      * Change the ICC password used in ICC pin lock
      * When the operation is complete, onComplete will be sent to its handler
      *
      * @param oldPassword is the old password
      * @param newPassword is the new password
      * @param onComplete
      *        onComplete.obj will be an AsyncResult
      *        ((AsyncResult)onComplete.obj).exception == null on success
      *        ((AsyncResult)onComplete.obj).exception != null on fail
      */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.032 -0500", hash_original_method = "CFACBB8EE591380B6F953CA4501BCE4D", hash_generated_method = "1580BB79817707D8A2233C5030916A09")
    
public void changeIccLockPassword(String oldPassword, String newPassword,
             Message onComplete) {
         mPhone.mCM.changeIccPin(oldPassword, newPassword,
                 mHandler.obtainMessage(EVENT_CHANGE_ICC_PASSWORD_DONE, onComplete));

     }

     /**
      * Change the ICC password used in ICC fdn enable
      * When the operation is complete, onComplete will be sent to its handler
      *
      * @param oldPassword is the old password
      * @param newPassword is the new password
      * @param onComplete
      *        onComplete.obj will be an AsyncResult
      *        ((AsyncResult)onComplete.obj).exception == null on success
      *        ((AsyncResult)onComplete.obj).exception != null on fail
      */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.035 -0500", hash_original_method = "78AE6F1E64D3743DF4893D59C6AFA5E2", hash_generated_method = "1DE91A71C48F1F9A1C0DE9906B406A6A")
    
public void changeIccFdnPassword(String oldPassword, String newPassword,
             Message onComplete) {
         mPhone.mCM.changeIccPin2(oldPassword, newPassword,
                 mHandler.obtainMessage(EVENT_CHANGE_ICC_PASSWORD_DONE, onComplete));

     }

    /**
     * Returns service provider name stored in ICC card.
     * If there is no service provider name associated or the record is not
     * yet available, null will be returned <p>
     *
     * Please use this value when display Service Provider Name in idle mode <p>
     *
     * Usage of this provider name in the UI is a common carrier requirement.
     *
     * Also available via Android property "gsm.sim.operator.alpha"
     *
     * @return Service Provider Name stored in ICC card
     *         null if no service provider name associated or the record is not
     *         yet available
     *
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.037 -0500", hash_original_method = "36F9BD3E61E1BCEF603A3141A3123DC7", hash_generated_method = "91DF635166F7B784DF503A4E8C997E09")
    
public abstract String getServiceProviderName();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.039 -0500", hash_original_method = "26BBB856B8138972809A4E6EC2BCC376", hash_generated_method = "0B08000480DF368F6458C0DE2E68792F")
    
protected void updateStateProperty() {
        mPhone.setSystemProperty(TelephonyProperties.PROPERTY_SIM_STATE, getState().toString());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.041 -0500", hash_original_method = "B8050A82EEEB3E75B61D0D7FED84BD4F", hash_generated_method = "C20278702AC7CD86697444C174679582")
    
private void getIccCardStatusDone(AsyncResult ar) {
        if (ar.exception != null) {
            Log.e(mLogTag,"Error getting ICC status. "
                    + "RIL_REQUEST_GET_ICC_STATUS should "
                    + "never return an error", ar.exception);
            return;
        }
        handleIccCardStatus((IccCardStatus) ar.result);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.045 -0500", hash_original_method = "EDEEC41729C236C302C7B6E1F1DF026D", hash_generated_method = "E6782BCCBAD93DCBBC08F17A4B913EBC")
    
private void handleIccCardStatus(IccCardStatus newCardStatus) {
        boolean transitionedIntoPinLocked;
        boolean transitionedIntoAbsent;
        boolean transitionedIntoNetworkLocked;
        boolean transitionedIntoPermBlocked;
        boolean isIccCardRemoved;
        boolean isIccCardAdded;

        State oldState, newState;

        oldState = mState;
        mIccCardStatus = newCardStatus;
        newState = getIccCardState();
        mState = newState;

        updateStateProperty();

        transitionedIntoPinLocked = (
                 (oldState != State.PIN_REQUIRED && newState == State.PIN_REQUIRED)
              || (oldState != State.PUK_REQUIRED && newState == State.PUK_REQUIRED));
        transitionedIntoAbsent = (oldState != State.ABSENT && newState == State.ABSENT);
        transitionedIntoNetworkLocked = (oldState != State.NETWORK_LOCKED
                && newState == State.NETWORK_LOCKED);
        transitionedIntoPermBlocked = (oldState != State.PERM_DISABLED
                && newState == State.PERM_DISABLED);
        isIccCardRemoved = (oldState != null &&
                        oldState.iccCardExist() && newState == State.ABSENT);
        isIccCardAdded = (oldState == State.ABSENT &&
                        newState != null && newState.iccCardExist());

        if (transitionedIntoPinLocked) {
            if (mDbg) log("Notify SIM pin or puk locked.");
            mPinLockedRegistrants.notifyRegistrants();
            broadcastIccStateChangedIntent(INTENT_VALUE_ICC_LOCKED,
                    (newState == State.PIN_REQUIRED) ?
                       INTENT_VALUE_LOCKED_ON_PIN : INTENT_VALUE_LOCKED_ON_PUK);
        } else if (transitionedIntoAbsent) {
            if (mDbg) log("Notify SIM missing.");
            mAbsentRegistrants.notifyRegistrants();
            broadcastIccStateChangedIntent(INTENT_VALUE_ICC_ABSENT, null);
        } else if (transitionedIntoNetworkLocked) {
            if (mDbg) log("Notify SIM network locked.");
            mNetworkLockedRegistrants.notifyRegistrants();
            broadcastIccStateChangedIntent(INTENT_VALUE_ICC_LOCKED,
                  INTENT_VALUE_LOCKED_NETWORK);
        } else if (transitionedIntoPermBlocked) {
            if (mDbg) log("Notify SIM permanently disabled.");
            broadcastIccStateChangedIntent(INTENT_VALUE_ICC_ABSENT,
                    INTENT_VALUE_ABSENT_ON_PERM_DISABLED);
        }

        if (isIccCardRemoved) {
            mHandler.sendMessage(mHandler.obtainMessage(EVENT_CARD_REMOVED, null));
        } else if (isIccCardAdded) {
            mHandler.sendMessage(mHandler.obtainMessage(EVENT_CARD_ADDED, null));
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.052 -0500", hash_original_method = "482C40D5983445C1A7C95EBEDC56AC82", hash_generated_method = "169CD289CD5CD1C6C677A9F692FAFC27")
    
private void onIccSwap(boolean isAdded) {
        // TODO: Here we assume the device can't handle SIM hot-swap
        //      and has to reboot. We may want to add a property,
        //      e.g. REBOOT_ON_SIM_SWAP, to indicate if modem support
        //      hot-swap.
        DialogInterface.OnClickListener listener = null;

        // TODO: SimRecords is not reset while SIM ABSENT (only reset while
        //       Radio_off_or_not_available). Have to reset in both both
        //       added or removed situation.
        listener = new DialogInterface.OnClickListener() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-05-05 09:46:43.104 -0400", hash_original_method = "9D3F97D682E1929CAA7D6B8E66CF9703", hash_generated_method = "0463FD749C6F3E8DD5354C77C877CBD6")
            
@Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    if (mDbg) log("Reboot due to SIM swap");
                    PowerManager pm = (PowerManager) mPhone.getContext()
                    .getSystemService(Context.POWER_SERVICE);
                    pm.reboot("SIM is added.");
                }
            }

        };

        Resources r = Resources.getSystem();

        String title = (isAdded) ? r.getString(R.string.sim_added_title) :
            r.getString(R.string.sim_removed_title);
        String message = (isAdded) ? r.getString(R.string.sim_added_message) :
            r.getString(R.string.sim_removed_message);
        String buttonTxt = r.getString(R.string.sim_restart_button);

        AlertDialog dialog = new AlertDialog.Builder(mPhone.getContext())
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(buttonTxt, listener)
            .create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        dialog.show();
    }

    /**
     * Interperate EVENT_QUERY_FACILITY_LOCK_DONE
     * @param ar is asyncResult of Query_Facility_Locked
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.055 -0500", hash_original_method = "F212AE1E9E62E46B160458ACE7EF1DC3", hash_generated_method = "50F82A6D728719DE3943F7FE038022B7")
    
private void onQueryFdnEnabled(AsyncResult ar) {
        if(ar.exception != null) {
            if(mDbg) log("Error in querying facility lock:" + ar.exception);
            return;
        }

        int[] ints = (int[])ar.result;
        if(ints.length != 0) {
            mIccFdnEnabled = (0!=ints[0]);
            if(mDbg) log("Query facility lock : "  + mIccFdnEnabled);
        } else {
            Log.e(mLogTag, "[IccCard] Bogus facility lock response");
        }
    }

    /**
     * Interperate EVENT_QUERY_FACILITY_LOCK_DONE
     * @param ar is asyncResult of Query_Facility_Locked
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.057 -0500", hash_original_method = "2D3A559A68B85B440A539D217592B783", hash_generated_method = "61D84E1A54E002117C3340548F175BB7")
    
private void onQueryFacilityLock(AsyncResult ar) {
        if(ar.exception != null) {
            if (mDbg) log("Error in querying facility lock:" + ar.exception);
            return;
        }

        int[] ints = (int[])ar.result;
        if(ints.length != 0) {
            mIccPinLocked = (0!=ints[0]);
            if(mDbg) log("Query facility lock : "  + mIccPinLocked);
        } else {
            Log.e(mLogTag, "[IccCard] Bogus facility lock response");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.059 -0500", hash_original_method = "BEDA05141A25EA0E8449469A2D08AE66", hash_generated_method = "B7F996DB25871C5C292216FCF23110A0")
    
public void broadcastIccStateChangedIntent(String value, String reason) {
        Intent intent = new Intent(TelephonyIntents.ACTION_SIM_STATE_CHANGED);
        intent.addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
        intent.putExtra(Phone.PHONE_NAME_KEY, mPhone.getPhoneName());
        intent.putExtra(INTENT_KEY_ICC_STATE, value);
        intent.putExtra(INTENT_KEY_LOCKED_REASON, reason);
        if(mDbg) log("Broadcasting intent ACTION_SIM_STATE_CHANGED " +  value
                + " reason " + reason);
        ActivityManagerNative.broadcastStickyIntent(intent, READ_PHONE_STATE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.073 -0500", hash_original_method = "531282E014DCDC26F790CA6DADE3C8C6", hash_generated_method = "845333C70AB060A1E5D67E8AFF60DD09")
    
public State getIccCardState() {
        if (mIccCardStatus == null) {
            Log.e(mLogTag, "[IccCard] IccCardStatus is null");
            return IccCard.State.ABSENT;
        }

        // this is common for all radio technologies
        if (!mIccCardStatus.getCardState().isCardPresent()) {
            return IccCard.State.ABSENT;
        }

        RadioState currentRadioState = mPhone.mCM.getRadioState();
        // check radio technology
        if( currentRadioState == RadioState.RADIO_OFF         ||
            currentRadioState == RadioState.RADIO_UNAVAILABLE ||
            currentRadioState == RadioState.SIM_NOT_READY     ||
            currentRadioState == RadioState.RUIM_NOT_READY    ||
            currentRadioState == RadioState.NV_NOT_READY      ||
            currentRadioState == RadioState.NV_READY) {
            return IccCard.State.NOT_READY;
        }

        if( currentRadioState == RadioState.SIM_LOCKED_OR_ABSENT  ||
            currentRadioState == RadioState.SIM_READY             ||
            currentRadioState == RadioState.RUIM_LOCKED_OR_ABSENT ||
            currentRadioState == RadioState.RUIM_READY) {

            State csimState =
                getAppState(mIccCardStatus.getCdmaSubscriptionAppIndex());
            State usimState =
                getAppState(mIccCardStatus.getGsmUmtsSubscriptionAppIndex());

            if(mDbg) log("USIM=" + usimState + " CSIM=" + csimState);

            if (mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE) {
                // UICC card contains both USIM and CSIM
                // Return consolidated status
                return getConsolidatedState(csimState, usimState, csimState);
            }

            // check for CDMA radio technology
            if (currentRadioState == RadioState.RUIM_LOCKED_OR_ABSENT ||
                currentRadioState == RadioState.RUIM_READY) {
                return csimState;
            }
            return usimState;
        }

        return IccCard.State.ABSENT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.076 -0500", hash_original_method = "809395990E0197CB644B1DF3288DB707", hash_generated_method = "EFA8A64136444C079815B62F28C4F4EB")
    
private State getAppState(int appIndex) {
        IccCardApplication app;
        if (appIndex >= 0 && appIndex < IccCardStatus.CARD_MAX_APPS) {
            app = mIccCardStatus.getApplication(appIndex);
        } else {
            Log.e(mLogTag, "[IccCard] Invalid Subscription Application index:" + appIndex);
            return IccCard.State.ABSENT;
        }

        if (app == null) {
            Log.e(mLogTag, "[IccCard] Subscription Application in not present");
            return IccCard.State.ABSENT;
        }

        // check if PIN required
        if (app.pin1.isPermBlocked()) {
            return IccCard.State.PERM_DISABLED;
        }
        if (app.app_state.isPinRequired()) {
            return IccCard.State.PIN_REQUIRED;
        }
        if (app.app_state.isPukRequired()) {
            return IccCard.State.PUK_REQUIRED;
        }
        if (app.app_state.isSubscriptionPersoEnabled()) {
            return IccCard.State.NETWORK_LOCKED;
        }
        if (app.app_state.isAppReady()) {
            return IccCard.State.READY;
        }
        if (app.app_state.isAppNotReady()) {
            return IccCard.State.NOT_READY;
        }
        return IccCard.State.NOT_READY;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.079 -0500", hash_original_method = "292BB37BE4996383C23DC23B1670D1D7", hash_generated_method = "A6835AB82A051F119363C1A081F15739")
    
private State getConsolidatedState(State left, State right, State preferredState) {
        // Check if either is absent.
        if (right == IccCard.State.ABSENT) return left;
        if (left == IccCard.State.ABSENT) return right;

        // Only if both are ready, return ready
        if ((left == IccCard.State.READY) && (right == IccCard.State.READY)) {
            return State.READY;
        }

        // Case one is ready, but the other is not.
        if (((right == IccCard.State.NOT_READY) && (left == IccCard.State.READY)) ||
            ((left == IccCard.State.NOT_READY) && (right == IccCard.State.READY))) {
            return IccCard.State.NOT_READY;
        }

        // At this point, the other state is assumed to be one of locked state
        if (right == IccCard.State.NOT_READY) return left;
        if (left == IccCard.State.NOT_READY) return right;

        // At this point, FW currently just assumes the status will be
        // consistent across the applications...
        return preferredState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.081 -0500", hash_original_method = "B5E8B5923B9BC39502C2387B1882FFE9", hash_generated_method = "23BD5C8D4C974CD6DC893DD6BBADCF34")
    
public boolean isApplicationOnIcc(IccCardApplication.AppType type) {
        if (mIccCardStatus == null) return false;

        for (int i = 0 ; i < mIccCardStatus.getNumApplications(); i++) {
            IccCardApplication app = mIccCardStatus.getApplication(i);
            if (app != null && app.app_type == type) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return true if a ICC card is present
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.083 -0500", hash_original_method = "1BA9D03EECE1275906E702F57E19B9C4", hash_generated_method = "41813692DDA3F373AC45161EDD50D99E")
    
public boolean hasIccCard() {
        if (mIccCardStatus == null) {
            return false;
        } else {
            // Returns ICC card status for both GSM and CDMA mode
            return mIccCardStatus.getCardState().isCardPresent();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.086 -0500", hash_original_method = "8040171B9171EEC88FFD4AC75BEDD9D4", hash_generated_method = "14A82AA4D2ADB8B993AA4D5294B16DAE")
    
private void log(String msg) {
        Log.d(mLogTag, "[IccCard] " + msg);
    }
}


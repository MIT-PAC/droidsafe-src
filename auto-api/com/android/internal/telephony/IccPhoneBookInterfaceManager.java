package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.pm.PackageManager;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ServiceManager;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class IccPhoneBookInterfaceManager extends IIccPhoneBook.Stub {
    protected PhoneBase phone;
    protected AdnRecordCache adnCache;
    protected Object mLock = new Object();
    protected int recordSize[];
    protected boolean success;
    protected List<AdnRecord> records;
    protected Handler mBaseHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.378 -0400", hash_original_method = "F8C0BA183015902A4341C34058945BDE", hash_generated_method = "691A0D538788D0BB08D9876609F9283B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            AsyncResult ar;
            //Begin case EVENT_GET_SIZE_DONE 
            ar = (AsyncResult) msg.obj;
            //End case EVENT_GET_SIZE_DONE 
            //Begin case EVENT_GET_SIZE_DONE 
            {
                {
                    recordSize = (int[])ar.result;
                    logd("GET_RECORD_SIZE Size " + recordSize[0] +
                                    " total " + recordSize[1] +
                                    " #record " + recordSize[2]);
                } //End block
                notifyPending(ar);
            } //End block
            //End case EVENT_GET_SIZE_DONE 
            //Begin case EVENT_UPDATE_DONE 
            ar = (AsyncResult) msg.obj;
            //End case EVENT_UPDATE_DONE 
            //Begin case EVENT_UPDATE_DONE 
            {
                success = (ar.exception == null);
                notifyPending(ar);
            } //End block
            //End case EVENT_UPDATE_DONE 
            //Begin case EVENT_LOAD_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_LOAD_DONE 
            //Begin case EVENT_LOAD_DONE 
            {
                {
                    records = (List<AdnRecord>) ar.result;
                } //End block
                {
                    logd("Cannot load ADN records");
                    {
                        records.clear();
                    } //End block
                } //End block
                notifyPending(ar);
            } //End block
            //End case EVENT_LOAD_DONE 
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.380 -0400", hash_original_method = "AEA2E9D2067E99FB1331FC981CC14937", hash_generated_method = "32A72025DCD374AF1CDBD92E89DAD742")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void notifyPending(AsyncResult ar) {
            dsTaint.addTaint(ar.dsTaint);
            AtomicBoolean status;
            status = (AtomicBoolean) ar.userObj;
            status.set(true);
            mLock.notifyAll();
            // ---------- Original Method ----------
            //if (ar.userObj == null) {
                //return;
            //}
            //AtomicBoolean status = (AtomicBoolean) ar.userObj;
            //status.set(true);
            //mLock.notifyAll();
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.381 -0400", hash_original_method = "A61AB5A9E61C78C524F0A299EDDA8B31", hash_generated_method = "2254754453A57523A33B77ACF458452C")
    @DSModeled(DSC.SAFE)
    public IccPhoneBookInterfaceManager(PhoneBase phone) {
        dsTaint.addTaint(phone.dsTaint);
        // ---------- Original Method ----------
        //this.phone = phone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.381 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    @DSModeled(DSC.SAFE)
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.381 -0400", hash_original_method = "96914FA697D4DDB9AE25582FAB4A6818", hash_generated_method = "1E7A9ED6D1CCD6DE353231DD77EAE9D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void publish() {
        ServiceManager.addService("simphonebook", this);
        // ---------- Original Method ----------
        //ServiceManager.addService("simphonebook", this);
    }

    
    protected abstract void logd(String msg);

    
    protected abstract void loge(String msg);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.382 -0400", hash_original_method = "6BE84EAB1F25CDC10E8188E3A1C3A959", hash_generated_method = "631FDDB0E7243C344A029CC0208D2985")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean updateAdnRecordsInEfBySearch(int efid,
            String oldTag, String oldPhoneNumber,
            String newTag, String newPhoneNumber, String pin2) {
        dsTaint.addTaint(pin2);
        dsTaint.addTaint(newTag);
        dsTaint.addTaint(oldPhoneNumber);
        dsTaint.addTaint(oldTag);
        dsTaint.addTaint(newPhoneNumber);
        dsTaint.addTaint(efid);
        {
            boolean var9B9745B744DE229D86237C6E47057CAE_1149106451 = (phone.getContext().checkCallingOrSelfPermission(
                android.Manifest.permission.WRITE_CONTACTS)
            != PackageManager.PERMISSION_GRANTED);
            {
                if (DroidSafeAndroidRuntime.control) throw new SecurityException(
                    "Requires android.permission.WRITE_CONTACTS permission");
            } //End block
        } //End collapsed parenthetic
        logd("updateAdnRecordsInEfBySearch: efid=" + efid +
                " ("+ oldTag + "," + oldPhoneNumber + ")"+ "==>" +
                " ("+ newTag + "," + newPhoneNumber + ")"+ " pin2=" + pin2);
        efid = updateEfForIccType(efid);
        {
            checkThread();
            success = false;
            AtomicBoolean status;
            status = new AtomicBoolean(false);
            Message response;
            response = mBaseHandler.obtainMessage(EVENT_UPDATE_DONE, status);
            AdnRecord oldAdn;
            oldAdn = new AdnRecord(oldTag, oldPhoneNumber);
            AdnRecord newAdn;
            newAdn = new AdnRecord(newTag, newPhoneNumber);
            adnCache.updateAdnBySearch(efid, oldAdn, newAdn, pin2, response);
            waitForResult(status);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.382 -0400", hash_original_method = "102FC1C0583C00426ED85686CB9EA64E", hash_generated_method = "9B222AD45DEA2B2DF408CCC42F031604")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean updateAdnRecordsInEfByIndex(int efid, String newTag,
            String newPhoneNumber, int index, String pin2) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(pin2);
        dsTaint.addTaint(newTag);
        dsTaint.addTaint(newPhoneNumber);
        dsTaint.addTaint(efid);
        {
            boolean var7C20BC9080702E0128DD71ABE9A4ADDC_376753355 = (phone.getContext().checkCallingOrSelfPermission(
                android.Manifest.permission.WRITE_CONTACTS)
                != PackageManager.PERMISSION_GRANTED);
            {
                if (DroidSafeAndroidRuntime.control) throw new SecurityException(
                    "Requires android.permission.WRITE_CONTACTS permission");
            } //End block
        } //End collapsed parenthetic
        logd("updateAdnRecordsInEfByIndex: efid=" + efid +
                " Index=" + index + " ==> " +
                "("+ newTag + "," + newPhoneNumber + ")"+ " pin2=" + pin2);
        {
            checkThread();
            success = false;
            AtomicBoolean status;
            status = new AtomicBoolean(false);
            Message response;
            response = mBaseHandler.obtainMessage(EVENT_UPDATE_DONE, status);
            AdnRecord newAdn;
            newAdn = new AdnRecord(newTag, newPhoneNumber);
            adnCache.updateAdnByIndex(efid, newAdn, index, pin2, response);
            waitForResult(status);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public abstract int[] getAdnRecordsSize(int efid);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.383 -0400", hash_original_method = "2EC5B47F5C71460FB1C246E071649E17", hash_generated_method = "E0D9FE30A55AAE66021797B895AA86D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<AdnRecord> getAdnRecordsInEf(int efid) {
        dsTaint.addTaint(efid);
        {
            boolean var539E4FD5A70571EEC200A34F44B8BBBA_397563045 = (phone.getContext().checkCallingOrSelfPermission(
                android.Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED);
            {
                if (DroidSafeAndroidRuntime.control) throw new SecurityException(
                    "Requires android.permission.READ_CONTACTS permission");
            } //End block
        } //End collapsed parenthetic
        efid = updateEfForIccType(efid);
        logd("getAdnRecordsInEF: efid=" + efid);
        {
            checkThread();
            AtomicBoolean status;
            status = new AtomicBoolean(false);
            Message response;
            response = mBaseHandler.obtainMessage(EVENT_LOAD_DONE, status);
            adnCache.requestLoadAllAdnLike(efid, adnCache.extensionEfForEf(efid), response);
            waitForResult(status);
        } //End block
        return (List<AdnRecord>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (phone.getContext().checkCallingOrSelfPermission(
                //android.Manifest.permission.READ_CONTACTS)
                //!= PackageManager.PERMISSION_GRANTED) {
            //throw new SecurityException(
                    //"Requires android.permission.READ_CONTACTS permission");
        //}
        //efid = updateEfForIccType(efid);
        //if (DBG) logd("getAdnRecordsInEF: efid=" + efid);
        //synchronized(mLock) {
            //checkThread();
            //AtomicBoolean status = new AtomicBoolean(false);
            //Message response = mBaseHandler.obtainMessage(EVENT_LOAD_DONE, status);
            //adnCache.requestLoadAllAdnLike(efid, adnCache.extensionEfForEf(efid), response);
            //waitForResult(status);
        //}
        //return records;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.383 -0400", hash_original_method = "323B98E2749A47EA83AB3530A004F85D", hash_generated_method = "32480C754D38054A47D096F258C2418F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void checkThread() {
        {
            {
                boolean var939C0019ED0A3EFF0AFB1602184EBB94_1355620681 = (mBaseHandler.getLooper().equals(Looper.myLooper()));
                {
                    loge("query() called on the main UI thread!");
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                        "You cannot call query on this provder from the main UI thread.");
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (!ALLOW_SIM_OP_IN_UI_THREAD) {
            //if (mBaseHandler.getLooper().equals(Looper.myLooper())) {
                //loge("query() called on the main UI thread!");
                //throw new IllegalStateException(
                        //"You cannot call query on this provder from the main UI thread.");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.383 -0400", hash_original_method = "FD540EF7FFA0769933308F8586A1F0A4", hash_generated_method = "5892361A3DD12E3B844AFF565F827B11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void waitForResult(AtomicBoolean status) {
        dsTaint.addTaint(status.dsTaint);
        {
            boolean var54E916846D120E4C0E15EB524D5AB066_12029177 = (!status.get());
            {
                try 
                {
                    mLock.wait();
                } //End block
                catch (InterruptedException e)
                {
                    logd("interrupted while trying to update by search");
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //while (!status.get()) {
            //try {
                //mLock.wait();
            //} catch (InterruptedException e) {
                //logd("interrupted while trying to update by search");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.383 -0400", hash_original_method = "6710BA71BBE2AF73325E69DE756B39B5", hash_generated_method = "8CC5C5E6AAE92336A9200665BC07D0E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int updateEfForIccType(int efid) {
        dsTaint.addTaint(efid);
        {
            {
                boolean var13648D229DF6DF3D9FC1C8923B7156DF_688161658 = (phone.getIccCard().isApplicationOnIcc(IccCardApplication.AppType.APPTYPE_USIM));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (efid == IccConstants.EF_ADN) {
            //if (phone.getIccCard().isApplicationOnIcc(IccCardApplication.AppType.APPTYPE_USIM)) {
                //return IccConstants.EF_PBR;
            //}
        //}
        //return efid;
    }

    
    protected static final boolean DBG = true;
    protected static final boolean ALLOW_SIM_OP_IN_UI_THREAD = false;
    protected static final int EVENT_GET_SIZE_DONE = 1;
    protected static final int EVENT_LOAD_DONE = 2;
    protected static final int EVENT_UPDATE_DONE = 3;
}


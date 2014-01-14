package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import android.content.pm.PackageManager;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ServiceManager;

public abstract class IccPhoneBookInterfaceManager extends IIccPhoneBook.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.106 -0500", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "5F5E7D64B04175B8FA820B2440F700FC")

    protected static final boolean DBG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.123 -0500", hash_original_field = "15D7ED0869755B209208299127695707", hash_generated_field = "1E8984E99524AF28D68E56356A817DB3")

    protected static final boolean ALLOW_SIM_OP_IN_UI_THREAD = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.125 -0500", hash_original_field = "36DCE9B307E8399E358F04CF1F23E76B", hash_generated_field = "B75ECFF18BE57F85BC7759CCE867BB30")

    protected static final int EVENT_GET_SIZE_DONE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.128 -0500", hash_original_field = "95DD1019701DAA926A9B3BD162D13FA0", hash_generated_field = "377496E733F7263CE55C3D4166BA075D")

    protected static final int EVENT_LOAD_DONE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.131 -0500", hash_original_field = "F2C62F27DE465AAB0BC4108A7047CE7A", hash_generated_field = "164C2891BBAF1E0C740CD93CF09B115E")

    protected static final int EVENT_UPDATE_DONE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.108 -0500", hash_original_field = "4D74BFF297E0DF8FA98FF6D8A8DBA78C", hash_generated_field = "4FEA837943E73EF5CB83661843F1AD15")

    protected PhoneBase phone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.110 -0500", hash_original_field = "55862F1A6AE254D83723842B05A3358C", hash_generated_field = "A9FC3B8D9025A6D655B1A245F81835AF")

    protected AdnRecordCache adnCache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.113 -0500", hash_original_field = "83DB9DCBBD2D99A708D9A1934D5CD5AB", hash_generated_field = "CD9F8D1AABF8833BACD5C9B6B52458C3")

    protected final Object mLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.116 -0500", hash_original_field = "194247FA4B05C1FA9D35D476BD5A34BE", hash_generated_field = "E5B26C030F2ABDD85D0CB8A10D64DB7B")

    protected int recordSize[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.118 -0500", hash_original_field = "82A420D00E02DD6885FA8DDB9F1DD1E9", hash_generated_field = "113121599E8140F8C4C329198A2D7722")

    protected boolean success;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.120 -0500", hash_original_field = "21FA2791240FB92737A43802E8AD569C", hash_generated_field = "71F18D31BD5AF48450CA4612AD1865B0")

    protected List<AdnRecord> records;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.989 -0400", hash_original_field = "F240289ECF5C81105F1EF992E6E2ADFE", hash_generated_field = "1DB8578536D5CE25805244FDBD843A4E")

    protected Handler mBaseHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.989 -0400", hash_original_method = "F8C0BA183015902A4341C34058945BDE", hash_generated_method = "941FD1090CAF73E06F07DEB3BDEE7189")
        @Override
        public void handleMessage(Message msg) {
            AsyncResult ar;
            
            ar = (AsyncResult) msg.obj;
            
            {
                {
                    recordSize = (int[])ar.result;
                    logd("GET_RECORD_SIZE Size " + recordSize[0] +
                                    " total " + recordSize[1] +
                                    " #record " + recordSize[2]);
                } 
                notifyPending(ar);
            }
            
            ar = (AsyncResult) msg.obj;
            
            {
                success = (ar.exception == null);
                notifyPending(ar);
            }
            
            ar = (AsyncResult)msg.obj;
            
            {
                {
                    records = (List<AdnRecord>) ar.result;
                } 
                {
                    logd("Cannot load ADN records");
                    {
                        records.clear();
                    } 
                } 
                notifyPending(ar);
            }
            
            addTaint(msg.getTaint());
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.989 -0400", hash_original_method = "AEA2E9D2067E99FB1331FC981CC14937", hash_generated_method = "A9B77AF35C7BC8F11854E73C8BE49190")
        private void notifyPending(AsyncResult ar) {
            AtomicBoolean status = (AtomicBoolean) ar.userObj;
            status.set(true);
            mLock.notifyAll();
            addTaint(ar.getTaint());
            
        }
        
};

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.143 -0500", hash_original_method = "A61AB5A9E61C78C524F0A299EDDA8B31", hash_generated_method = "18B5A62A9ABF8049CDE994F95CE824BC")
    
public IccPhoneBookInterfaceManager(PhoneBase phone) {
        this.phone = phone;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.146 -0500", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "5EA87569AF1433DF9A5120E4976B79C1")
    
public void dispose() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.148 -0500", hash_original_method = "96914FA697D4DDB9AE25582FAB4A6818", hash_generated_method = "D1DA42ADDE2E6B532ED6745729F21D6E")
    
protected void publish() {
        //NOTE service "simphonebook" added by IccSmsInterfaceManagerProxy
        ServiceManager.addService("simphonebook", this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.150 -0500", hash_original_method = "38CE766CCD7AC2AD876D116A52FCCE8F", hash_generated_method = "23BD4551E2B7627F84306D9E9D0D7E90")
    
protected abstract void logd(String msg);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.153 -0500", hash_original_method = "2CB44E3FBD8F4DD8AE1E0D5B11281502", hash_generated_method = "20F0068141A5357E298923EC41F603D8")
    
protected abstract void loge(String msg);

    /**
     * Replace oldAdn with newAdn in ADN-like record in EF
     *
     * getAdnRecordsInEf must be called at least once before this function,
     * otherwise an error will be returned. Currently the email field
     * if set in the ADN record is ignored.
     * throws SecurityException if no WRITE_CONTACTS permission
     *
     * @param efid must be one among EF_ADN, EF_FDN, and EF_SDN
     * @param oldTag adn tag to be replaced
     * @param oldPhoneNumber adn number to be replaced
     *        Set both oldTag and oldPhoneNubmer to "" means to replace an
     *        empty record, aka, insert new record
     * @param newTag adn tag to be stored
     * @param newPhoneNumber adn number ot be stored
     *        Set both newTag and newPhoneNubmer to "" means to replace the old
     *        record with empty one, aka, delete old record
     * @param pin2 required to update EF_FDN, otherwise must be null
     * @return true for success
     */
    @DSSink({DSSinkKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.156 -0500", hash_original_method = "6BE84EAB1F25CDC10E8188E3A1C3A959", hash_generated_method = "7746946CCF90ACBA13801870D8B07536")
    
public boolean
    updateAdnRecordsInEfBySearch (int efid,
            String oldTag, String oldPhoneNumber,
            String newTag, String newPhoneNumber, String pin2) {

        if (phone.getContext().checkCallingOrSelfPermission(
                android.Manifest.permission.WRITE_CONTACTS)
            != PackageManager.PERMISSION_GRANTED) {
            throw new SecurityException(
                    "Requires android.permission.WRITE_CONTACTS permission");
        }

        if (DBG) logd("updateAdnRecordsInEfBySearch: efid=" + efid +
                " ("+ oldTag + "," + oldPhoneNumber + ")"+ "==>" +
                " ("+ newTag + "," + newPhoneNumber + ")"+ " pin2=" + pin2);

        efid = updateEfForIccType(efid);

        synchronized(mLock) {
            checkThread();
            success = false;
            AtomicBoolean status = new AtomicBoolean(false);
            Message response = mBaseHandler.obtainMessage(EVENT_UPDATE_DONE, status);
            AdnRecord oldAdn = new AdnRecord(oldTag, oldPhoneNumber);
            AdnRecord newAdn = new AdnRecord(newTag, newPhoneNumber);
            adnCache.updateAdnBySearch(efid, oldAdn, newAdn, pin2, response);
            waitForResult(status);
        }
        return success;
    }

    /**
     * Update an ADN-like EF record by record index
     *
     * This is useful for iteration the whole ADN file, such as write the whole
     * phone book or erase/format the whole phonebook. Currently the email field
     * if set in the ADN record is ignored.
     * throws SecurityException if no WRITE_CONTACTS permission
     *
     * @param efid must be one among EF_ADN, EF_FDN, and EF_SDN
     * @param newTag adn tag to be stored
     * @param newPhoneNumber adn number to be stored
     *        Set both newTag and newPhoneNubmer to "" means to replace the old
     *        record with empty one, aka, delete old record
     * @param index is 1-based adn record index to be updated
     * @param pin2 required to update EF_FDN, otherwise must be null
     * @return true for success
     */
    @DSSink({DSSinkKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.158 -0500", hash_original_method = "102FC1C0583C00426ED85686CB9EA64E", hash_generated_method = "AD9ECC5986896ECA7D0ABA0605CAB7EB")
    
public boolean
    updateAdnRecordsInEfByIndex(int efid, String newTag,
            String newPhoneNumber, int index, String pin2) {

        if (phone.getContext().checkCallingOrSelfPermission(
                android.Manifest.permission.WRITE_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            throw new SecurityException(
                    "Requires android.permission.WRITE_CONTACTS permission");
        }

        if (DBG) logd("updateAdnRecordsInEfByIndex: efid=" + efid +
                " Index=" + index + " ==> " +
                "("+ newTag + "," + newPhoneNumber + ")"+ " pin2=" + pin2);
        synchronized(mLock) {
            checkThread();
            success = false;
            AtomicBoolean status = new AtomicBoolean(false);
            Message response = mBaseHandler.obtainMessage(EVENT_UPDATE_DONE, status);
            AdnRecord newAdn = new AdnRecord(newTag, newPhoneNumber);
            adnCache.updateAdnByIndex(efid, newAdn, index, pin2, response);
            waitForResult(status);
        }
        return success;
    }

    /**
     * Get the capacity of records in efid
     *
     * @param efid the EF id of a ADN-like ICC
     * @return  int[3] array
     *            recordSizes[0]  is the single record length
     *            recordSizes[1]  is the total length of the EF file
     *            recordSizes[2]  is the number of records in the EF file
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.161 -0500", hash_original_method = "9FB8D2A8F1DAFD7F6DC550B28004A7DD", hash_generated_method = "48F90E8806365397C610A5724EEC45CB")
    
public abstract int[] getAdnRecordsSize(int efid);

    /**
     * Loads the AdnRecords in efid and returns them as a
     * List of AdnRecords
     *
     * throws SecurityException if no READ_CONTACTS permission
     *
     * @param efid the EF id of a ADN-like ICC
     * @return List of AdnRecord
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.164 -0500", hash_original_method = "2EC5B47F5C71460FB1C246E071649E17", hash_generated_method = "14818A383B7131A42ED5AE36C068F8A8")
    
public List<AdnRecord> getAdnRecordsInEf(int efid) {

        if (phone.getContext().checkCallingOrSelfPermission(
                android.Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            throw new SecurityException(
                    "Requires android.permission.READ_CONTACTS permission");
        }

        efid = updateEfForIccType(efid);
        if (DBG) logd("getAdnRecordsInEF: efid=" + efid);

        synchronized(mLock) {
            checkThread();
            AtomicBoolean status = new AtomicBoolean(false);
            Message response = mBaseHandler.obtainMessage(EVENT_LOAD_DONE, status);
            adnCache.requestLoadAllAdnLike(efid, adnCache.extensionEfForEf(efid), response);
            waitForResult(status);
        }
        return records;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.166 -0500", hash_original_method = "323B98E2749A47EA83AB3530A004F85D", hash_generated_method = "72660E03987F54D888D47A37E712BFF9")
    
protected void checkThread() {
        if (!ALLOW_SIM_OP_IN_UI_THREAD) {
            // Make sure this isn't the UI thread, since it will block
            if (mBaseHandler.getLooper().equals(Looper.myLooper())) {
                loge("query() called on the main UI thread!");
                throw new IllegalStateException(
                        "You cannot call query on this provder from the main UI thread.");
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.168 -0500", hash_original_method = "FD540EF7FFA0769933308F8586A1F0A4", hash_generated_method = "FB648F4135D789BCEFBA6B740C1DA4A2")
    
protected void waitForResult(AtomicBoolean status) {
        while (!status.get()) {
            try {
                mLock.wait();
            } catch (InterruptedException e) {
                logd("interrupted while trying to update by search");
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.171 -0500", hash_original_method = "6710BA71BBE2AF73325E69DE756B39B5", hash_generated_method = "35A0CC8BCC0B244794D14FB3B6427BAE")
    
private int updateEfForIccType(int efid) {
        // Check if we are trying to read ADN records
        if (efid == IccConstants.EF_ADN) {
            if (phone.getIccCard().isApplicationOnIcc(IccCardApplication.AppType.APPTYPE_USIM)) {
                return IccConstants.EF_PBR;
            }
        }
        return efid;
    }
}


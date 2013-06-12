package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.android.internal.telephony.gsm.UsimPhoneBookManager;
import java.util.ArrayList;
import java.util.Iterator;

public final class AdnRecordCache extends Handler implements IccConstants {
    PhoneBase phone;
    private UsimPhoneBookManager mUsimPhoneBookManager;
    SparseArray<ArrayList<AdnRecord>> adnLikeFiles
        = new SparseArray<ArrayList<AdnRecord>>();
    SparseArray<ArrayList<Message>> adnLikeWaiters
        = new SparseArray<ArrayList<Message>>();
    SparseArray<Message> userWriteResponse = new SparseArray<Message>();
    static final int EVENT_LOAD_ALL_ADN_LIKE_DONE = 1;
    static final int EVENT_UPDATE_ADN_DONE = 2;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.555 -0400", hash_original_method = "778B025D62231C2A3FAD8914E2C62313", hash_generated_method = "6C8746E136345B9436C67C4D2681E475")
    @DSModeled(DSC.SAFE)
    public AdnRecordCache(PhoneBase phone) {
        dsTaint.addTaint(phone.dsTaint);
        mUsimPhoneBookManager = new UsimPhoneBookManager(phone, this);
        // ---------- Original Method ----------
        //this.phone = phone;
        //mUsimPhoneBookManager = new UsimPhoneBookManager(phone, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.555 -0400", hash_original_method = "C51C4513003EDC9EA86A76A3037140C3", hash_generated_method = "75865624EC779E47028DC63524548C29")
    @DSModeled(DSC.SAFE)
    public void reset() {
        adnLikeFiles.clear();
        mUsimPhoneBookManager.reset();
        clearWaiters();
        clearUserWriters();
        // ---------- Original Method ----------
        //adnLikeFiles.clear();
        //mUsimPhoneBookManager.reset();
        //clearWaiters();
        //clearUserWriters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.555 -0400", hash_original_method = "D74CB42B2A20381108736DF447231499", hash_generated_method = "AB6920320EB602467715B2DC2095E5B5")
    @DSModeled(DSC.SAFE)
    private void clearWaiters() {
        int size;
        size = adnLikeWaiters.size();
        {
            int i;
            i = 0;
            {
                ArrayList<Message> waiters;
                waiters = adnLikeWaiters.valueAt(i);
                AsyncResult ar;
                ar = new AsyncResult(null, null, new RuntimeException("AdnCache reset"));
                notifyWaiters(waiters, ar);
            } //End block
        } //End collapsed parenthetic
        adnLikeWaiters.clear();
        // ---------- Original Method ----------
        //int size = adnLikeWaiters.size();
        //for (int i = 0; i < size; i++) {
            //ArrayList<Message> waiters = adnLikeWaiters.valueAt(i);
            //AsyncResult ar = new AsyncResult(null, null, new RuntimeException("AdnCache reset"));
            //notifyWaiters(waiters, ar);
        //}
        //adnLikeWaiters.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.555 -0400", hash_original_method = "AA0A19B306C1CFC2139DB9008BF6A4C8", hash_generated_method = "B87268EFA4AEFC70263F7D5B35418DCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void clearUserWriters() {
        int size;
        size = userWriteResponse.size();
        {
            int i;
            i = 0;
            {
                sendErrorResponse(userWriteResponse.valueAt(i), "AdnCace reset");
            } //End block
        } //End collapsed parenthetic
        userWriteResponse.clear();
        // ---------- Original Method ----------
        //int size = userWriteResponse.size();
        //for (int i = 0; i < size; i++) {
            //sendErrorResponse(userWriteResponse.valueAt(i), "AdnCace reset");
        //}
        //userWriteResponse.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.555 -0400", hash_original_method = "F416E740ABBE99926C901CF2ED82B3B0", hash_generated_method = "9058FCBD29A02943B764A39BD9CDD036")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayList<AdnRecord> getRecordsIfLoaded(int efid) {
        dsTaint.addTaint(efid);
        ArrayList<AdnRecord> var782F6793FDABD08BA37B9C9E7F193D47_476994549 = (adnLikeFiles.get(efid));
        return (ArrayList<AdnRecord>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return adnLikeFiles.get(efid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.555 -0400", hash_original_method = "0198A12501638F8F5669817EF7B81F42", hash_generated_method = "73FB5FDB6C1FB034C9D2D2386ED0B58D")
    @DSModeled(DSC.SAFE)
     int extensionEfForEf(int efid) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(efid);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //switch (efid) {
            //case EF_MBDN: return EF_EXT6;
            //case EF_ADN: return EF_EXT1;
            //case EF_SDN: return EF_EXT3;
            //case EF_FDN: return EF_EXT2;
            //case EF_MSISDN: return EF_EXT1;
            //case EF_PBR: return 0; 
            //default: return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.555 -0400", hash_original_method = "A626AB07A72819AA36869010FF1E4126", hash_generated_method = "AF3306E4EADF21E1BEC6CEC8FED7F358")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendErrorResponse(Message response, String errString) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(errString);
        {
            Exception e;
            e = new RuntimeException(errString);
            AsyncResult.forMessage(response).exception = e;
            response.sendToTarget();
        } //End block
        // ---------- Original Method ----------
        //if (response != null) {
            //Exception e = new RuntimeException(errString);
            //AsyncResult.forMessage(response).exception = e;
            //response.sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.555 -0400", hash_original_method = "92DB73E806C3C282A27A1468C26BF7B3", hash_generated_method = "48FA9A3FB4F85DFF60A6C896119981CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateAdnByIndex(int efid, AdnRecord adn, int recordIndex, String pin2,
            Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(pin2);
        dsTaint.addTaint(adn.dsTaint);
        dsTaint.addTaint(recordIndex);
        dsTaint.addTaint(efid);
        int extensionEF;
        extensionEF = extensionEfForEf(efid);
        {
            sendErrorResponse(response, "EF is not known ADN-like EF:" + efid);
        } //End block
        Message pendingResponse;
        pendingResponse = userWriteResponse.get(efid);
        {
            sendErrorResponse(response, "Have pending update for EF:" + efid);
        } //End block
        userWriteResponse.put(efid, response);
        new AdnRecordLoader(phone).updateEF(adn, efid, extensionEF,
                recordIndex, pin2,
                obtainMessage(EVENT_UPDATE_ADN_DONE, efid, recordIndex, adn));
        // ---------- Original Method ----------
        //int extensionEF = extensionEfForEf(efid);
        //if (extensionEF < 0) {
            //sendErrorResponse(response, "EF is not known ADN-like EF:" + efid);
            //return;
        //}
        //Message pendingResponse = userWriteResponse.get(efid);
        //if (pendingResponse != null) {
            //sendErrorResponse(response, "Have pending update for EF:" + efid);
            //return;
        //}
        //userWriteResponse.put(efid, response);
        //new AdnRecordLoader(phone).updateEF(adn, efid, extensionEF,
                //recordIndex, pin2,
                //obtainMessage(EVENT_UPDATE_ADN_DONE, efid, recordIndex, adn));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.556 -0400", hash_original_method = "71F49E0E0C93DA66D27CAD14CA0014CE", hash_generated_method = "67042DA684FFD19393D1ABA2E4A1EAE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateAdnBySearch(int efid, AdnRecord oldAdn, AdnRecord newAdn,
            String pin2, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(oldAdn.dsTaint);
        dsTaint.addTaint(pin2);
        dsTaint.addTaint(newAdn.dsTaint);
        dsTaint.addTaint(efid);
        int extensionEF;
        extensionEF = extensionEfForEf(efid);
        {
            sendErrorResponse(response, "EF is not known ADN-like EF:" + efid);
        } //End block
        ArrayList<AdnRecord> oldAdnList;
        {
            oldAdnList = mUsimPhoneBookManager.loadEfFilesFromUsim();
        } //End block
        {
            oldAdnList = getRecordsIfLoaded(efid);
        } //End block
        {
            sendErrorResponse(response, "Adn list not exist for EF:" + efid);
        } //End block
        int index;
        index = -1;
        int count;
        count = 1;
        {
            Iterator<AdnRecord> it;
            it = oldAdnList.iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_1804540935 = (it.hasNext());
            {
                {
                    boolean var109153AE8FA7C60942D7115B9D4CF678_1454437192 = (oldAdn.isEqual(it.next()));
                    {
                        index = count;
                    } //End block
                } //End collapsed parenthetic
                count++;
            } //End block
        } //End collapsed parenthetic
        {
            sendErrorResponse(response, "Adn record don't exist for " + oldAdn);
        } //End block
        {
            AdnRecord foundAdn;
            foundAdn = oldAdnList.get(index-1);
            efid = foundAdn.efid;
            extensionEF = foundAdn.extRecord;
            index = foundAdn.recordNumber;
            newAdn.efid = efid;
            newAdn.extRecord = extensionEF;
            newAdn.recordNumber = index;
        } //End block
        Message pendingResponse;
        pendingResponse = userWriteResponse.get(efid);
        {
            sendErrorResponse(response, "Have pending update for EF:" + efid);
        } //End block
        userWriteResponse.put(efid, response);
        new AdnRecordLoader(phone).updateEF(newAdn, efid, extensionEF,
                index, pin2,
                obtainMessage(EVENT_UPDATE_ADN_DONE, efid, index, newAdn));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.556 -0400", hash_original_method = "05810E0F51AA47EAC0C24CA3CBEDF0F7", hash_generated_method = "A6CBA05E2AF776BEED860ACD7B8BA9E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void requestLoadAllAdnLike(int efid, int extensionEf, Message response) {
        dsTaint.addTaint(extensionEf);
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(efid);
        ArrayList<Message> waiters;
        ArrayList<AdnRecord> result;
        {
            result = mUsimPhoneBookManager.loadEfFilesFromUsim();
        } //End block
        {
            result = getRecordsIfLoaded(efid);
        } //End block
        {
            {
                AsyncResult.forMessage(response).result = result;
                response.sendToTarget();
            } //End block
        } //End block
        waiters = adnLikeWaiters.get(efid);
        {
            waiters.add(response);
        } //End block
        waiters = new ArrayList<Message>();
        waiters.add(response);
        adnLikeWaiters.put(efid, waiters);
        {
            {
                AsyncResult.forMessage(response).exception
                    = new RuntimeException("EF is not known ADN-like EF:" + efid);
                response.sendToTarget();
            } //End block
        } //End block
        new AdnRecordLoader(phone).loadAllFromEF(efid, extensionEf,
            obtainMessage(EVENT_LOAD_ALL_ADN_LIKE_DONE, efid, 0));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.556 -0400", hash_original_method = "06D7CFA235737447F2D0DAD9C5CA936C", hash_generated_method = "C20DF200B88D7511CE422D56E64445E5")
    @DSModeled(DSC.SAFE)
    private void notifyWaiters(ArrayList<Message> waiters, AsyncResult ar) {
        dsTaint.addTaint(waiters.dsTaint);
        dsTaint.addTaint(ar.dsTaint);
        {
            int i, s;
            i = 0;
            s = waiters.size();
            {
                Message waiter;
                waiter = waiters.get(i);
                AsyncResult.forMessage(waiter, ar.result, ar.exception);
                waiter.sendToTarget();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (waiters == null) {
            //return;
        //}
        //for (int i = 0, s = waiters.size() ; i < s ; i++) {
            //Message waiter = waiters.get(i);
            //AsyncResult.forMessage(waiter, ar.result, ar.exception);
            //waiter.sendToTarget();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.557 -0400", hash_original_method = "EDA0843A3B437B2415185CC41779F06F", hash_generated_method = "2587450795E943ACA7A0C75CC50662DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        AsyncResult ar;
        int efid;
        //Begin case EVENT_LOAD_ALL_ADN_LIKE_DONE 
        ar = (AsyncResult) msg.obj;
        //End case EVENT_LOAD_ALL_ADN_LIKE_DONE 
        //Begin case EVENT_LOAD_ALL_ADN_LIKE_DONE 
        efid = msg.arg1;
        //End case EVENT_LOAD_ALL_ADN_LIKE_DONE 
        //Begin case EVENT_LOAD_ALL_ADN_LIKE_DONE 
        ArrayList<Message> waiters;
        //End case EVENT_LOAD_ALL_ADN_LIKE_DONE 
        //Begin case EVENT_LOAD_ALL_ADN_LIKE_DONE 
        waiters = adnLikeWaiters.get(efid);
        //End case EVENT_LOAD_ALL_ADN_LIKE_DONE 
        //Begin case EVENT_LOAD_ALL_ADN_LIKE_DONE 
        adnLikeWaiters.delete(efid);
        //End case EVENT_LOAD_ALL_ADN_LIKE_DONE 
        //Begin case EVENT_LOAD_ALL_ADN_LIKE_DONE 
        {
            adnLikeFiles.put(efid, (ArrayList<AdnRecord>) ar.result);
        } //End block
        //End case EVENT_LOAD_ALL_ADN_LIKE_DONE 
        //Begin case EVENT_LOAD_ALL_ADN_LIKE_DONE 
        notifyWaiters(waiters, ar);
        //End case EVENT_LOAD_ALL_ADN_LIKE_DONE 
        //Begin case EVENT_UPDATE_ADN_DONE 
        ar = (AsyncResult)msg.obj;
        //End case EVENT_UPDATE_ADN_DONE 
        //Begin case EVENT_UPDATE_ADN_DONE 
        efid = msg.arg1;
        //End case EVENT_UPDATE_ADN_DONE 
        //Begin case EVENT_UPDATE_ADN_DONE 
        int index;
        index = msg.arg2;
        //End case EVENT_UPDATE_ADN_DONE 
        //Begin case EVENT_UPDATE_ADN_DONE 
        AdnRecord adn;
        adn = (AdnRecord) (ar.userObj);
        //End case EVENT_UPDATE_ADN_DONE 
        //Begin case EVENT_UPDATE_ADN_DONE 
        {
            adnLikeFiles.get(efid).set(index - 1, adn);
            mUsimPhoneBookManager.invalidateCache();
        } //End block
        //End case EVENT_UPDATE_ADN_DONE 
        //Begin case EVENT_UPDATE_ADN_DONE 
        Message response;
        response = userWriteResponse.get(efid);
        //End case EVENT_UPDATE_ADN_DONE 
        //Begin case EVENT_UPDATE_ADN_DONE 
        userWriteResponse.delete(efid);
        //End case EVENT_UPDATE_ADN_DONE 
        //Begin case EVENT_UPDATE_ADN_DONE 
        AsyncResult.forMessage(response, null, ar.exception);
        //End case EVENT_UPDATE_ADN_DONE 
        //Begin case EVENT_UPDATE_ADN_DONE 
        response.sendToTarget();
        //End case EVENT_UPDATE_ADN_DONE 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}



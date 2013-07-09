package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.224 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "4D74BFF297E0DF8FA98FF6D8A8DBA78C")

    PhoneBase phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.224 -0400", hash_original_field = "7AD5A27BB7D2D34D0C8EDF89584607A1", hash_generated_field = "E3717E9C9DFB544AEE98C8317196D94A")

    private UsimPhoneBookManager mUsimPhoneBookManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.224 -0400", hash_original_field = "9C684D7A3EA68688C4C426C547E2FB4C", hash_generated_field = "FD7F02A9AF4E80E8401852CE1D6CCCF1")

    SparseArray<ArrayList<AdnRecord>> adnLikeFiles = new SparseArray<ArrayList<AdnRecord>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.224 -0400", hash_original_field = "ADAFB2076C74460469DCA43C10C1385F", hash_generated_field = "F4925A71D0D9BED40A87B97AA5176B7D")

    SparseArray<ArrayList<Message>> adnLikeWaiters = new SparseArray<ArrayList<Message>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.224 -0400", hash_original_field = "8478D847935CCE397652858C36803AB9", hash_generated_field = "F677C0CE26C976C7845C3614A71718EB")

    SparseArray<Message> userWriteResponse = new SparseArray<Message>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.224 -0400", hash_original_method = "778B025D62231C2A3FAD8914E2C62313", hash_generated_method = "D7D947F84080CF4D64D3A5D475032C17")
    public  AdnRecordCache(PhoneBase phone) {
        this.phone = phone;
        mUsimPhoneBookManager = new UsimPhoneBookManager(phone, this);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.224 -0400", hash_original_method = "C51C4513003EDC9EA86A76A3037140C3", hash_generated_method = "39E1DB1685B71CBB7026B24F81570F04")
    public void reset() {
        adnLikeFiles.clear();
        mUsimPhoneBookManager.reset();
        clearWaiters();
        clearUserWriters();
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.225 -0400", hash_original_method = "D74CB42B2A20381108736DF447231499", hash_generated_method = "9BE3827E7A42AD6E8202A5C362FF191D")
    private void clearWaiters() {
        int size = adnLikeWaiters.size();
        {
            int i = 0;
            {
                ArrayList<Message> waiters = adnLikeWaiters.valueAt(i);
                AsyncResult ar = new AsyncResult(null, null, new RuntimeException("AdnCache reset"));
                notifyWaiters(waiters, ar);
            } 
        } 
        adnLikeWaiters.clear();
        
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.225 -0400", hash_original_method = "AA0A19B306C1CFC2139DB9008BF6A4C8", hash_generated_method = "5493877FF7FC37824451A2A8753A17EA")
    private void clearUserWriters() {
        int size = userWriteResponse.size();
        {
            int i = 0;
            {
                sendErrorResponse(userWriteResponse.valueAt(i), "AdnCace reset");
            } 
        } 
        userWriteResponse.clear();
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.226 -0400", hash_original_method = "F416E740ABBE99926C901CF2ED82B3B0", hash_generated_method = "FD3239F80FBFF3A195B990A866AA586B")
    public ArrayList<AdnRecord> getRecordsIfLoaded(int efid) {
        ArrayList<AdnRecord> varB4EAC82CA7396A68D541C85D26508E83_1428087210 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1428087210 = adnLikeFiles.get(efid);
        addTaint(efid);
        varB4EAC82CA7396A68D541C85D26508E83_1428087210.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1428087210;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.226 -0400", hash_original_method = "0198A12501638F8F5669817EF7B81F42", hash_generated_method = "9E83AB5F3642CAE68BE364C58A075BDB")
     int extensionEfForEf(int efid) {
        addTaint(efid);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1440135180 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1440135180;
        
        
            
            
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.226 -0400", hash_original_method = "A626AB07A72819AA36869010FF1E4126", hash_generated_method = "C519D630375D34248A722E18F3A8ACDD")
    private void sendErrorResponse(Message response, String errString) {
        {
            Exception e = new RuntimeException(errString);
            AsyncResult.forMessage(response).exception = e;
            response.sendToTarget();
        } 
        addTaint(response.getTaint());
        addTaint(errString.getTaint());
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.227 -0400", hash_original_method = "92DB73E806C3C282A27A1468C26BF7B3", hash_generated_method = "71DC8245313DA2F1856A16155C7976CA")
    public void updateAdnByIndex(int efid, AdnRecord adn, int recordIndex, String pin2,
            Message response) {
        int extensionEF = extensionEfForEf(efid);
        {
            sendErrorResponse(response, "EF is not known ADN-like EF:" + efid);
        } 
        Message pendingResponse = userWriteResponse.get(efid);
        {
            sendErrorResponse(response, "Have pending update for EF:" + efid);
        } 
        userWriteResponse.put(efid, response);
        new AdnRecordLoader(phone).updateEF(adn, efid, extensionEF,
                recordIndex, pin2,
                obtainMessage(EVENT_UPDATE_ADN_DONE, efid, recordIndex, adn));
        addTaint(efid);
        addTaint(adn.getTaint());
        addTaint(recordIndex);
        addTaint(pin2.getTaint());
        addTaint(response.getTaint());
        
        
        
            
            
        
        
        
            
            
        
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.228 -0400", hash_original_method = "71F49E0E0C93DA66D27CAD14CA0014CE", hash_generated_method = "98291439ACDC89EAC26F681792138C3F")
    public void updateAdnBySearch(int efid, AdnRecord oldAdn, AdnRecord newAdn,
            String pin2, Message response) {
        int extensionEF;
        extensionEF = extensionEfForEf(efid);
        {
            sendErrorResponse(response, "EF is not known ADN-like EF:" + efid);
        } 
        ArrayList<AdnRecord> oldAdnList;
        {
            oldAdnList = mUsimPhoneBookManager.loadEfFilesFromUsim();
        } 
        {
            oldAdnList = getRecordsIfLoaded(efid);
        } 
        {
            sendErrorResponse(response, "Adn list not exist for EF:" + efid);
        } 
        int index = -1;
        int count = 1;
        {
            Iterator<AdnRecord> it = oldAdnList.iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_65711011 = (it.hasNext());
            {
                {
                    boolean var109153AE8FA7C60942D7115B9D4CF678_1725817479 = (oldAdn.isEqual(it.next()));
                    {
                        index = count;
                    } 
                } 
            } 
        } 
        {
            sendErrorResponse(response, "Adn record don't exist for " + oldAdn);
        } 
        {
            AdnRecord foundAdn = oldAdnList.get(index-1);
            efid = foundAdn.efid;
            extensionEF = foundAdn.extRecord;
            index = foundAdn.recordNumber;
            newAdn.efid = efid;
            newAdn.extRecord = extensionEF;
            newAdn.recordNumber = index;
        } 
        Message pendingResponse = userWriteResponse.get(efid);
        {
            sendErrorResponse(response, "Have pending update for EF:" + efid);
        } 
        userWriteResponse.put(efid, response);
        new AdnRecordLoader(phone).updateEF(newAdn, efid, extensionEF,
                index, pin2,
                obtainMessage(EVENT_UPDATE_ADN_DONE, efid, index, newAdn));
        addTaint(efid);
        addTaint(oldAdn.getTaint());
        addTaint(newAdn.getTaint());
        addTaint(pin2.getTaint());
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.229 -0400", hash_original_method = "05810E0F51AA47EAC0C24CA3CBEDF0F7", hash_generated_method = "2E2EBCCBA5E4A3E60C301373F960A26E")
    public void requestLoadAllAdnLike(int efid, int extensionEf, Message response) {
        ArrayList<Message> waiters;
        ArrayList<AdnRecord> result;
        {
            result = mUsimPhoneBookManager.loadEfFilesFromUsim();
        } 
        {
            result = getRecordsIfLoaded(efid);
        } 
        {
            {
                AsyncResult.forMessage(response).result = result;
                response.sendToTarget();
            } 
        } 
        waiters = adnLikeWaiters.get(efid);
        {
            waiters.add(response);
        } 
        waiters = new ArrayList<Message>();
        waiters.add(response);
        adnLikeWaiters.put(efid, waiters);
        {
            {
                AsyncResult.forMessage(response).exception
                    = new RuntimeException("EF is not known ADN-like EF:" + efid);
                response.sendToTarget();
            } 
        } 
        new AdnRecordLoader(phone).loadAllFromEF(efid, extensionEf,
            obtainMessage(EVENT_LOAD_ALL_ADN_LIKE_DONE, efid, 0));
        addTaint(efid);
        addTaint(extensionEf);
        addTaint(response.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.229 -0400", hash_original_method = "06D7CFA235737447F2D0DAD9C5CA936C", hash_generated_method = "785379A3876D04A7D2D706A120AEEF6F")
    private void notifyWaiters(ArrayList<Message> waiters, AsyncResult ar) {
        {
            int i = 0;
            int s = waiters.size();
            {
                Message waiter = waiters.get(i);
                AsyncResult.forMessage(waiter, ar.result, ar.exception);
                waiter.sendToTarget();
            } 
        } 
        addTaint(waiters.getTaint());
        addTaint(ar.getTaint());
        
        
            
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.230 -0400", hash_original_method = "EDA0843A3B437B2415185CC41779F06F", hash_generated_method = "31139AC56641BE87559C8B00530CDA43")
    public void handleMessage(Message msg) {
        AsyncResult ar;
        int efid;
        
        ar = (AsyncResult) msg.obj;
        
        
        efid = msg.arg1;
        
        
        ArrayList<Message> waiters;
        
        
        waiters = adnLikeWaiters.get(efid);
        
        
        adnLikeWaiters.delete(efid);
        
        
        {
            adnLikeFiles.put(efid, (ArrayList<AdnRecord>) ar.result);
        } 
        
        
        notifyWaiters(waiters, ar);
        
        
        ar = (AsyncResult)msg.obj;
        
        
        efid = msg.arg1;
        
        
        int index = msg.arg2;
        
        
        AdnRecord adn = (AdnRecord) (ar.userObj);
        
        
        {
            adnLikeFiles.get(efid).set(index - 1, adn);
            mUsimPhoneBookManager.invalidateCache();
        } 
        
        
        Message response = userWriteResponse.get(efid);
        
        
        userWriteResponse.delete(efid);
        
        
        AsyncResult.forMessage(response, null, ar.exception);
        
        
        response.sendToTarget();
        
        addTaint(msg.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.231 -0400", hash_original_field = "03AB7BF51351057C2E3D1FF08AB06611", hash_generated_field = "EF915D97284F3936495B1375E22F8448")

    static final int EVENT_LOAD_ALL_ADN_LIKE_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.231 -0400", hash_original_field = "7C5CFEC1409E135FD47F8C89B6004DD5", hash_generated_field = "45468B5879EA75ECFA4CD728BEBE82F1")

    static final int EVENT_UPDATE_ADN_DONE = 2;
}


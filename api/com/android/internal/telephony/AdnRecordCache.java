package com.android.internal.telephony;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.Iterator;

import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;

import com.android.internal.telephony.gsm.UsimPhoneBookManager;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class AdnRecordCache extends Handler implements IccConstants {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.667 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "4D74BFF297E0DF8FA98FF6D8A8DBA78C")

    PhoneBase phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.667 -0400", hash_original_field = "7AD5A27BB7D2D34D0C8EDF89584607A1", hash_generated_field = "E3717E9C9DFB544AEE98C8317196D94A")

    private UsimPhoneBookManager mUsimPhoneBookManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.667 -0400", hash_original_field = "9C684D7A3EA68688C4C426C547E2FB4C", hash_generated_field = "FD7F02A9AF4E80E8401852CE1D6CCCF1")

    SparseArray<ArrayList<AdnRecord>> adnLikeFiles = new SparseArray<ArrayList<AdnRecord>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.668 -0400", hash_original_field = "ADAFB2076C74460469DCA43C10C1385F", hash_generated_field = "F4925A71D0D9BED40A87B97AA5176B7D")

    SparseArray<ArrayList<Message>> adnLikeWaiters = new SparseArray<ArrayList<Message>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.668 -0400", hash_original_field = "8478D847935CCE397652858C36803AB9", hash_generated_field = "F677C0CE26C976C7845C3614A71718EB")

    SparseArray<Message> userWriteResponse = new SparseArray<Message>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.668 -0400", hash_original_method = "778B025D62231C2A3FAD8914E2C62313", hash_generated_method = "D7D947F84080CF4D64D3A5D475032C17")
    public  AdnRecordCache(PhoneBase phone) {
        this.phone = phone;
        mUsimPhoneBookManager = new UsimPhoneBookManager(phone, this);
        // ---------- Original Method ----------
        //this.phone = phone;
        //mUsimPhoneBookManager = new UsimPhoneBookManager(phone, this);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.668 -0400", hash_original_method = "C51C4513003EDC9EA86A76A3037140C3", hash_generated_method = "39E1DB1685B71CBB7026B24F81570F04")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.669 -0400", hash_original_method = "D74CB42B2A20381108736DF447231499", hash_generated_method = "BA88A2EB7C2D013DD8BB439BD8125703")
    private void clearWaiters() {
        int size = adnLikeWaiters.size();
for(int i = 0;i < size;i++)
        {
            ArrayList<Message> waiters = adnLikeWaiters.valueAt(i);
            AsyncResult ar = new AsyncResult(null, null, new RuntimeException("AdnCache reset"));
            notifyWaiters(waiters, ar);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.670 -0400", hash_original_method = "AA0A19B306C1CFC2139DB9008BF6A4C8", hash_generated_method = "612A107BF31BC92C01AF5FCC19854ACB")
    private void clearUserWriters() {
        int size = userWriteResponse.size();
for(int i = 0;i < size;i++)
        {
            sendErrorResponse(userWriteResponse.valueAt(i), "AdnCace reset");
        } //End block
        userWriteResponse.clear();
        // ---------- Original Method ----------
        //int size = userWriteResponse.size();
        //for (int i = 0; i < size; i++) {
            //sendErrorResponse(userWriteResponse.valueAt(i), "AdnCace reset");
        //}
        //userWriteResponse.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.670 -0400", hash_original_method = "F416E740ABBE99926C901CF2ED82B3B0", hash_generated_method = "92E07E5D02BA07FC56CAC904A013F345")
    public ArrayList<AdnRecord> getRecordsIfLoaded(int efid) {
        addTaint(efid);
ArrayList<AdnRecord> var3D961DBCF8C551D2B336F2C2F608BD6B_910694204 =         adnLikeFiles.get(efid);
        var3D961DBCF8C551D2B336F2C2F608BD6B_910694204.addTaint(taint);
        return var3D961DBCF8C551D2B336F2C2F608BD6B_910694204;
        // ---------- Original Method ----------
        //return adnLikeFiles.get(efid);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.671 -0400", hash_original_method = "0198A12501638F8F5669817EF7B81F42", hash_generated_method = "F0A5BAFB7280BE49D3BC6C27F6CA1C75")
     int extensionEfForEf(int efid) {
        addTaint(efid);
switch(efid){
        case EF_MBDN:
        int var9BA1AD0F3F838540D8B3B9878CB2841A_867126241 = (EF_EXT6);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482076797 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482076797;
        case EF_ADN:
        int varBDA0E5B000FED0C2B584DF9C35F4941A_893634907 = (EF_EXT1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1295561404 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1295561404;
        case EF_SDN:
        int varAABA001D44095BAA84A3FAC7BBE504FC_1333873831 = (EF_EXT3);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1331115516 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1331115516;
        case EF_FDN:
        int var26D4008B4F591CC93530B46722096AA8_1497483310 = (EF_EXT2);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_356047414 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_356047414;
        case EF_MSISDN:
        int varBDA0E5B000FED0C2B584DF9C35F4941A_2107301446 = (EF_EXT1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_840943403 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_840943403;
        case EF_PBR:
        int varCFCD208495D565EF66E7DFF9F98764DA_737140463 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1044638328 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1044638328;
        default:
        int var6BB61E3B7BCE0931DA574D19D1D82C88_561435270 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_963069870 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_963069870;
}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.671 -0400", hash_original_method = "A626AB07A72819AA36869010FF1E4126", hash_generated_method = "D11595183DEC425F7EA8A3F2C9D7DC8C")
    private void sendErrorResponse(Message response, String errString) {
        addTaint(errString.getTaint());
        addTaint(response.getTaint());
        if(response != null)        
        {
            Exception e = new RuntimeException(errString);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.672 -0400", hash_original_method = "92DB73E806C3C282A27A1468C26BF7B3", hash_generated_method = "DDCFAD5CEBCD6AF5A092DD480D70D4E2")
    public void updateAdnByIndex(int efid, AdnRecord adn, int recordIndex, String pin2,
            Message response) {
        addTaint(response.getTaint());
        addTaint(pin2.getTaint());
        addTaint(recordIndex);
        addTaint(adn.getTaint());
        addTaint(efid);
        int extensionEF = extensionEfForEf(efid);
        if(extensionEF < 0)        
        {
            sendErrorResponse(response, "EF is not known ADN-like EF:" + efid);
            return;
        } //End block
        Message pendingResponse = userWriteResponse.get(efid);
        if(pendingResponse != null)        
        {
            sendErrorResponse(response, "Have pending update for EF:" + efid);
            return;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.674 -0400", hash_original_method = "71F49E0E0C93DA66D27CAD14CA0014CE", hash_generated_method = "63A3F87681E3BC0A8B1BE9D64E17F954")
    public void updateAdnBySearch(int efid, AdnRecord oldAdn, AdnRecord newAdn,
            String pin2, Message response) {
        addTaint(response.getTaint());
        addTaint(pin2.getTaint());
        addTaint(newAdn.getTaint());
        addTaint(oldAdn.getTaint());
        addTaint(efid);
        int extensionEF;
        extensionEF = extensionEfForEf(efid);
        if(extensionEF < 0)        
        {
            sendErrorResponse(response, "EF is not known ADN-like EF:" + efid);
            return;
        } //End block
        ArrayList<AdnRecord> oldAdnList;
        if(efid == EF_PBR)        
        {
            oldAdnList = mUsimPhoneBookManager.loadEfFilesFromUsim();
        } //End block
        else
        {
            oldAdnList = getRecordsIfLoaded(efid);
        } //End block
        if(oldAdnList == null)        
        {
            sendErrorResponse(response, "Adn list not exist for EF:" + efid);
            return;
        } //End block
        int index = -1;
        int count = 1;
for(Iterator<AdnRecord> it = oldAdnList.iterator();it.hasNext();)
        {
            if(oldAdn.isEqual(it.next()))            
            {
                index = count;
                break;
            } //End block
            count++;
        } //End block
        if(index == -1)        
        {
            sendErrorResponse(response, "Adn record don't exist for " + oldAdn);
            return;
        } //End block
        if(efid == EF_PBR)        
        {
            AdnRecord foundAdn = oldAdnList.get(index-1);
            efid = foundAdn.efid;
            extensionEF = foundAdn.extRecord;
            index = foundAdn.recordNumber;
            newAdn.efid = efid;
            newAdn.extRecord = extensionEF;
            newAdn.recordNumber = index;
        } //End block
        Message pendingResponse = userWriteResponse.get(efid);
        if(pendingResponse != null)        
        {
            sendErrorResponse(response, "Have pending update for EF:" + efid);
            return;
        } //End block
        userWriteResponse.put(efid, response);
        new AdnRecordLoader(phone).updateEF(newAdn, efid, extensionEF,
                index, pin2,
                obtainMessage(EVENT_UPDATE_ADN_DONE, efid, index, newAdn));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.676 -0400", hash_original_method = "05810E0F51AA47EAC0C24CA3CBEDF0F7", hash_generated_method = "8F70942F0E8B611AC0C6CB7694891581")
    public void requestLoadAllAdnLike(int efid, int extensionEf, Message response) {
        addTaint(response.getTaint());
        addTaint(extensionEf);
        addTaint(efid);
        ArrayList<Message> waiters;
        ArrayList<AdnRecord> result;
        if(efid == EF_PBR)        
        {
            result = mUsimPhoneBookManager.loadEfFilesFromUsim();
        } //End block
        else
        {
            result = getRecordsIfLoaded(efid);
        } //End block
        if(result != null)        
        {
            if(response != null)            
            {
                AsyncResult.forMessage(response).result = result;
                response.sendToTarget();
            } //End block
            return;
        } //End block
        waiters = adnLikeWaiters.get(efid);
        if(waiters != null)        
        {
            waiters.add(response);
            return;
        } //End block
        waiters = new ArrayList<Message>();
        waiters.add(response);
        adnLikeWaiters.put(efid, waiters);
        if(extensionEf < 0)        
        {
            if(response != null)            
            {
                AsyncResult.forMessage(response).exception
                    = new RuntimeException("EF is not known ADN-like EF:" + efid);
                response.sendToTarget();
            } //End block
            return;
        } //End block
        new AdnRecordLoader(phone).loadAllFromEF(efid, extensionEf,
            obtainMessage(EVENT_LOAD_ALL_ADN_LIKE_DONE, efid, 0));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.677 -0400", hash_original_method = "06D7CFA235737447F2D0DAD9C5CA936C", hash_generated_method = "7F0B9F088C8B8A2F2C50B0AFC0D77CE5")
    private void notifyWaiters(ArrayList<Message> waiters, AsyncResult ar) {
        addTaint(ar.getTaint());
        addTaint(waiters.getTaint());
        if(waiters == null)        
        {
            return;
        } //End block
for(int i = 0, s = waiters.size();i < s;i++)
        {
            Message waiter = waiters.get(i);
            AsyncResult.forMessage(waiter, ar.result, ar.exception);
            waiter.sendToTarget();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.679 -0400", hash_original_method = "EDA0843A3B437B2415185CC41779F06F", hash_generated_method = "44BFC8ECF48DE65EBB31675B99882F9A")
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        AsyncResult ar;
        int efid;
switch(msg.what){
        case EVENT_LOAD_ALL_ADN_LIKE_DONE:
        ar = (AsyncResult) msg.obj;
        efid = msg.arg1;
        ArrayList<Message> waiters;
        waiters = adnLikeWaiters.get(efid);
        adnLikeWaiters.delete(efid);
        if(ar.exception == null)        
        {
            adnLikeFiles.put(efid, (ArrayList<AdnRecord>) ar.result);
        } //End block
        notifyWaiters(waiters, ar);
        break;
        case EVENT_UPDATE_ADN_DONE:
        ar = (AsyncResult)msg.obj;
        efid = msg.arg1;
        int index = msg.arg2;
        AdnRecord adn = (AdnRecord) (ar.userObj);
        if(ar.exception == null)        
        {
            adnLikeFiles.get(efid).set(index - 1, adn);
            mUsimPhoneBookManager.invalidateCache();
        } //End block
        Message response = userWriteResponse.get(efid);
        userWriteResponse.delete(efid);
        AsyncResult.forMessage(response, null, ar.exception);
        response.sendToTarget();
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.680 -0400", hash_original_field = "03AB7BF51351057C2E3D1FF08AB06611", hash_generated_field = "EF915D97284F3936495B1375E22F8448")

    static final int EVENT_LOAD_ALL_ADN_LIKE_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:12.680 -0400", hash_original_field = "7C5CFEC1409E135FD47F8C89B6004DD5", hash_generated_field = "45468B5879EA75ECFA4CD728BEBE82F1")

    static final int EVENT_UPDATE_ADN_DONE = 2;
}


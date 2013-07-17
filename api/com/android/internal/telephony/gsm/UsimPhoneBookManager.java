package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.android.internal.telephony.AdnRecord;
import com.android.internal.telephony.AdnRecordCache;
import com.android.internal.telephony.IccConstants;
import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.PhoneBase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UsimPhoneBookManager extends Handler implements IccConstants {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.985 -0400", hash_original_field = "7D373B4F0DFF7E92AC122910BF9B25C5", hash_generated_field = "208E31DBC6A3857B5997E7C1BCB1166B")

    private PbrFile mPbrFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.985 -0400", hash_original_field = "30E1F8B5FEAFF3D5D3F3D60A2669D6EC", hash_generated_field = "73182A5184196FAAD039E44D2C16F121")

    private Boolean mIsPbrPresent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.985 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "E7BDAD23CF4F53103B9ED94B380FFE2A")

    private PhoneBase mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.985 -0400", hash_original_field = "BA1723592FC6435C40C8AD8626B01970", hash_generated_field = "640171AAF9460B26A1955741F0E8BDD1")

    private AdnRecordCache mAdnCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.985 -0400", hash_original_field = "B89DEBA2CB26B1AC973763E3E152017B", hash_generated_field = "C8F8FCD335E09ED70E70801AB39A894A")

    private Object mLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.985 -0400", hash_original_field = "53A38FDCFCCC8ECCB18A04C23D93072B", hash_generated_field = "F015F032A7EB90DEA83FE0426648EF9F")

    private ArrayList<AdnRecord> mPhoneBookRecords;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.985 -0400", hash_original_field = "63024429CACFB70F75A3BECB3F2E6C36", hash_generated_field = "8920C02D769F140478E3FF9AAD342322")

    private boolean mEmailPresentInIap = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.985 -0400", hash_original_field = "7B86766C70934F19080F42E3D35B4DFF", hash_generated_field = "85C5852B556432EAA1F206B261622D09")

    private int mEmailTagNumberInIap = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.985 -0400", hash_original_field = "4D4CA197DA1CB6A858C87C60961C500B", hash_generated_field = "F0E5C0A038832AB5FF92C39635F7D36F")

    private ArrayList<byte[]> mIapFileRecord;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.985 -0400", hash_original_field = "419263776F38DA2F0745455CE61D0A73", hash_generated_field = "89657832ADF45F3FD36226A626E3E654")

    private ArrayList<byte[]> mEmailFileRecord;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.985 -0400", hash_original_field = "5D6A4FFEA4D7A28766408604E7A641BD", hash_generated_field = "9EF1137FB9FBD5B78A3EDED47EC19EF2")

    private Map<Integer, ArrayList<String>> mEmailsForAdnRec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.985 -0400", hash_original_field = "C9062F039BF2FB54B18203718C657CDA", hash_generated_field = "04358A29D9E3ACD0C9C2B1379BC842DB")

    private boolean mRefreshCache = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.986 -0400", hash_original_method = "49FEAD20C5C47E2BA26F4ED2BE1800D2", hash_generated_method = "C6C0A75B50E09ACCB60EA00A5CED0347")
    public  UsimPhoneBookManager(PhoneBase phone, AdnRecordCache cache) {
        mPhone = phone;
        mPhoneBookRecords = new ArrayList<AdnRecord>();
        mPbrFile = null;
        mIsPbrPresent = true;
        mAdnCache = cache;
        // ---------- Original Method ----------
        //mPhone = phone;
        //mPhoneBookRecords = new ArrayList<AdnRecord>();
        //mPbrFile = null;
        //mIsPbrPresent = true;
        //mAdnCache = cache;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.987 -0400", hash_original_method = "E0D906663A0994551C89240DFDC0BDC8", hash_generated_method = "ABA5A37BF0D9B72AE08F6D010D45EC01")
    public void reset() {
        mPhoneBookRecords.clear();
        mIapFileRecord = null;
        mEmailFileRecord = null;
        mPbrFile = null;
        mIsPbrPresent = true;
        mRefreshCache = false;
        // ---------- Original Method ----------
        //mPhoneBookRecords.clear();
        //mIapFileRecord = null;
        //mEmailFileRecord = null;
        //mPbrFile = null;
        //mIsPbrPresent = true;
        //mRefreshCache = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.988 -0400", hash_original_method = "B81A15F32DE42ED7FA5FD76607998109", hash_generated_method = "79E5CCCE3EFF5A25251AE36CFEF90753")
    public ArrayList<AdnRecord> loadEfFilesFromUsim() {
        synchronized
(mLock)        {
            if(!mPhoneBookRecords.isEmpty())            
            {
                if(mRefreshCache)                
                {
                    mRefreshCache = false;
                    refreshCache();
                } //End block
ArrayList<AdnRecord> var8C99AB5783B2B47FF38441E92273C2C9_1224567110 =                 mPhoneBookRecords;
                var8C99AB5783B2B47FF38441E92273C2C9_1224567110.addTaint(taint);
                return var8C99AB5783B2B47FF38441E92273C2C9_1224567110;
            } //End block
            if(!mIsPbrPresent)            
            {
ArrayList<AdnRecord> var540C13E9E156B687226421B24F2DF178_1660787099 =             null;
            var540C13E9E156B687226421B24F2DF178_1660787099.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1660787099;
            }
            if(mPbrFile == null)            
            {
                readPbrFileAndWait();
            } //End block
            if(mPbrFile == null)            
            {
ArrayList<AdnRecord> var540C13E9E156B687226421B24F2DF178_2104264372 =             null;
            var540C13E9E156B687226421B24F2DF178_2104264372.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2104264372;
            }
            int numRecs = mPbrFile.mFileIds.size();
for(int i = 0;i < numRecs;i++)
            {
                readAdnFileAndWait(i);
                readEmailFileAndWait(i);
            } //End block
        } //End block
ArrayList<AdnRecord> var8C99AB5783B2B47FF38441E92273C2C9_999948468 =         mPhoneBookRecords;
        var8C99AB5783B2B47FF38441E92273C2C9_999948468.addTaint(taint);
        return var8C99AB5783B2B47FF38441E92273C2C9_999948468;
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //if (!mPhoneBookRecords.isEmpty()) {
                //if (mRefreshCache) {
                    //mRefreshCache = false;
                    //refreshCache();
                //}
                //return mPhoneBookRecords;
            //}
            //if (!mIsPbrPresent) return null;
            //if (mPbrFile == null) {
                //readPbrFileAndWait();
            //}
            //if (mPbrFile == null) return null;
            //int numRecs = mPbrFile.mFileIds.size();
            //for (int i = 0; i < numRecs; i++) {
                //readAdnFileAndWait(i);
                //readEmailFileAndWait(i);
            //}
        //}
        //return mPhoneBookRecords;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.988 -0400", hash_original_method = "B532D4E2E21067521A95047E8C8D19E8", hash_generated_method = "D25B4351DA4581F02965F916DEC5A2E4")
    private void refreshCache() {
        if(mPbrFile == null)        
        return;
        mPhoneBookRecords.clear();
        int numRecs = mPbrFile.mFileIds.size();
for(int i = 0;i < numRecs;i++)
        {
            readAdnFileAndWait(i);
        } //End block
        // ---------- Original Method ----------
        //if (mPbrFile == null) return;
        //mPhoneBookRecords.clear();
        //int numRecs = mPbrFile.mFileIds.size();
        //for (int i = 0; i < numRecs; i++) {
            //readAdnFileAndWait(i);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.989 -0400", hash_original_method = "4227D3403F7221594B4C4984D58136B1", hash_generated_method = "94D421C1BCB4B33EF173797F9066F6AC")
    public void invalidateCache() {
        mRefreshCache = true;
        // ---------- Original Method ----------
        //mRefreshCache = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.989 -0400", hash_original_method = "78E381AC3959E12E81678D4DFFBA5C8B", hash_generated_method = "78D7A3DA17E948EF054C319C109A5332")
    private void readPbrFileAndWait() {
        mPhone.getIccFileHandler().loadEFLinearFixedAll(EF_PBR, obtainMessage(EVENT_PBR_LOAD_DONE));
        try 
        {
            mLock.wait();
        } //End block
        catch (InterruptedException e)
        {
        } //End block
        // ---------- Original Method ----------
        //mPhone.getIccFileHandler().loadEFLinearFixedAll(EF_PBR, obtainMessage(EVENT_PBR_LOAD_DONE));
        //try {
            //mLock.wait();
        //} catch (InterruptedException e) {
            //Log.e(LOG_TAG, "Interrupted Exception in readAdnFileAndWait");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.990 -0400", hash_original_method = "48BBB6A0A30AD38B5848D3F55664B632", hash_generated_method = "91BC59C078EAD56145BBED890F082825")
    private void readEmailFileAndWait(int recNum) {
        addTaint(recNum);
        Map <Integer,Integer> fileIds;
        fileIds = mPbrFile.mFileIds.get(recNum);
        if(fileIds == null)        
        return;
        if(fileIds.containsKey(USIM_EFEMAIL_TAG))        
        {
            int efid = fileIds.get(USIM_EFEMAIL_TAG);
            if(mEmailPresentInIap)            
            {
                readIapFileAndWait(fileIds.get(USIM_EFIAP_TAG));
                if(mIapFileRecord == null)                
                {
                    return;
                } //End block
            } //End block
            mPhone.getIccFileHandler().loadEFLinearFixedAll(fileIds.get(USIM_EFEMAIL_TAG),
                    obtainMessage(EVENT_EMAIL_LOAD_DONE));
            try 
            {
                mLock.wait();
            } //End block
            catch (InterruptedException e)
            {
            } //End block
            if(mEmailFileRecord == null)            
            {
                return;
            } //End block
            updatePhoneAdnRecord();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.990 -0400", hash_original_method = "9E809A1ED86DEC7D2454BACD182423F6", hash_generated_method = "A820AC140FAB73CAD101B3FAA05AEE33")
    private void readIapFileAndWait(int efid) {
        addTaint(efid);
        mPhone.getIccFileHandler().loadEFLinearFixedAll(efid, obtainMessage(EVENT_IAP_LOAD_DONE));
        try 
        {
            mLock.wait();
        } //End block
        catch (InterruptedException e)
        {
        } //End block
        // ---------- Original Method ----------
        //mPhone.getIccFileHandler().loadEFLinearFixedAll(efid, obtainMessage(EVENT_IAP_LOAD_DONE));
        //try {
            //mLock.wait();
        //} catch (InterruptedException e) {
            //Log.e(LOG_TAG, "Interrupted Exception in readIapFileAndWait");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.992 -0400", hash_original_method = "DBF9EE6E650F45B09979783B6AE92B3D", hash_generated_method = "4156D82294C7CD27C0A6844601929707")
    private void updatePhoneAdnRecord() {
        if(mEmailFileRecord == null)        
        return;
        int numAdnRecs = mPhoneBookRecords.size();
        if(mIapFileRecord != null)        
        {
for(int i = 0;i < numAdnRecs;i++)
            {
                byte[] record = null;
                try 
                {
                    record = mIapFileRecord.get(i);
                } //End block
                catch (IndexOutOfBoundsException e)
                {
                    break;
                } //End block
                int recNum = record[mEmailTagNumberInIap];
                if(recNum != -1)                
                {
                    String[] emails = new String[1];
                    emails[0] = readEmailRecord(recNum - 1);
                    AdnRecord rec = mPhoneBookRecords.get(i);
                    if(rec != null)                    
                    {
                        rec.setEmails(emails);
                    } //End block
                    else
                    {
                        rec = new AdnRecord("", "", emails);
                    } //End block
                    mPhoneBookRecords.set(i, rec);
                } //End block
            } //End block
        } //End block
        int len = mPhoneBookRecords.size();
        if(mEmailsForAdnRec == null)        
        {
            parseType1EmailFile(len);
        } //End block
for(int i = 0;i < numAdnRecs;i++)
        {
            ArrayList<String> emailList = null;
            try 
            {
                emailList = mEmailsForAdnRec.get(i);
            } //End block
            catch (IndexOutOfBoundsException e)
            {
                break;
            } //End block
            if(emailList == null)            
            continue;
            AdnRecord rec = mPhoneBookRecords.get(i);
            String[] emails = new String[emailList.size()];
            System.arraycopy(emailList.toArray(), 0, emails, 0, emailList.size());
            rec.setEmails(emails);
            mPhoneBookRecords.set(i, rec);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.994 -0400", hash_original_method = "8AA09CE6055FA7D5E93DEAB0645B4CBD", hash_generated_method = "126F6A07ADDF1EB74AEF13B9750EC461")
     void parseType1EmailFile(int numRecs) {
        addTaint(numRecs);
        mEmailsForAdnRec = new HashMap<Integer, ArrayList<String>>();
        byte[] emailRec = null;
for(int i = 0;i < numRecs;i++)
        {
            try 
            {
                emailRec = mEmailFileRecord.get(i);
            } //End block
            catch (IndexOutOfBoundsException e)
            {
                break;
            } //End block
            int adnRecNum = emailRec[emailRec.length - 1];
            if(adnRecNum == -1)            
            {
                continue;
            } //End block
            String email = readEmailRecord(i);
            if(email == null || email.equals(""))            
            {
                continue;
            } //End block
            ArrayList<String> val = mEmailsForAdnRec.get(adnRecNum - 1);
            if(val == null)            
            {
                val = new ArrayList<String>();
            } //End block
            val.add(email);
            mEmailsForAdnRec.put(adnRecNum - 1, val);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.995 -0400", hash_original_method = "9DD87F6722942AC55924DBE05DD72D60", hash_generated_method = "81C96AC3648A83F87EDF098BE796EE98")
    private String readEmailRecord(int recNum) {
        addTaint(recNum);
        byte[] emailRec = null;
        try 
        {
            emailRec = mEmailFileRecord.get(recNum);
        } //End block
        catch (IndexOutOfBoundsException e)
        {
String var540C13E9E156B687226421B24F2DF178_1246058146 =             null;
            var540C13E9E156B687226421B24F2DF178_1246058146.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1246058146;
        } //End block
        String email = IccUtils.adnStringFieldToString(emailRec, 0, emailRec.length - 2);
String var2D726FE6F9242582D95F0FF51CCDA35C_1741471184 =         email;
        var2D726FE6F9242582D95F0FF51CCDA35C_1741471184.addTaint(taint);
        return var2D726FE6F9242582D95F0FF51CCDA35C_1741471184;
        // ---------- Original Method ----------
        //byte[] emailRec = null;
        //try {
            //emailRec = mEmailFileRecord.get(recNum);
        //} catch (IndexOutOfBoundsException e) {
            //return null;
        //}
        //String email = IccUtils.adnStringFieldToString(emailRec, 0, emailRec.length - 2);
        //return email;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.995 -0400", hash_original_method = "4035A9584818EC181E07E84AC976F741", hash_generated_method = "E70B516799F454C07E73389D802999BC")
    private void readAdnFileAndWait(int recNum) {
        addTaint(recNum);
        Map <Integer,Integer> fileIds;
        fileIds = mPbrFile.mFileIds.get(recNum);
        if(fileIds == null || fileIds.isEmpty())        
        return;
        int extEf = 0;
        if(fileIds.containsKey(USIM_EFEXT1_TAG))        
        {
            extEf = fileIds.get(USIM_EFEXT1_TAG);
        } //End block
        mAdnCache.requestLoadAllAdnLike(fileIds.get(USIM_EFADN_TAG),
            extEf, obtainMessage(EVENT_USIM_ADN_LOAD_DONE));
        try 
        {
            mLock.wait();
        } //End block
        catch (InterruptedException e)
        {
        } //End block
        // ---------- Original Method ----------
        //Map <Integer,Integer> fileIds;
        //fileIds = mPbrFile.mFileIds.get(recNum);
        //if (fileIds == null || fileIds.isEmpty()) return;
        //int extEf = 0;
        //if (fileIds.containsKey(USIM_EFEXT1_TAG)) {
            //extEf = fileIds.get(USIM_EFEXT1_TAG);
        //}
        //mAdnCache.requestLoadAllAdnLike(fileIds.get(USIM_EFADN_TAG),
            //extEf, obtainMessage(EVENT_USIM_ADN_LOAD_DONE));
        //try {
            //mLock.wait();
        //} catch (InterruptedException e) {
            //Log.e(LOG_TAG, "Interrupted Exception in readAdnFileAndWait");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.996 -0400", hash_original_method = "EC7FC3EA469B316149A3EE38C863088E", hash_generated_method = "6438DF12A3F41DFBB05FA12A3D7EEBCA")
    private void createPbrFile(ArrayList<byte[]> records) {
        if(records == null)        
        {
            mPbrFile = null;
            mIsPbrPresent = false;
            return;
        } //End block
        mPbrFile = new PbrFile(records);
        // ---------- Original Method ----------
        //if (records == null) {
            //mPbrFile = null;
            //mIsPbrPresent = false;
            //return;
        //}
        //mPbrFile = new PbrFile(records);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.996 -0400", hash_original_method = "DBCDBDCB51A5EB5E1A763E38D42C7855", hash_generated_method = "108787DAAABEE7D2F37A89956E1E2A4B")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        AsyncResult ar;
switch(msg.what){
        case EVENT_PBR_LOAD_DONE:
        ar = (AsyncResult) msg.obj;
        if(ar.exception == null)        
        {
            createPbrFile((ArrayList<byte[]>)ar.result);
        } //End block
        synchronized
(mLock)        {
            mLock.notify();
        } //End block
        break;
        case EVENT_USIM_ADN_LOAD_DONE:
        log("Loading USIM ADN records done");
        ar = (AsyncResult) msg.obj;
        if(ar.exception == null)        
        {
            mPhoneBookRecords.addAll((ArrayList<AdnRecord>)ar.result);
        } //End block
        synchronized
(mLock)        {
            mLock.notify();
        } //End block
        break;
        case EVENT_IAP_LOAD_DONE:
        log("Loading USIM IAP records done");
        ar = (AsyncResult) msg.obj;
        if(ar.exception == null)        
        {
            mIapFileRecord = ((ArrayList<byte[]>)ar.result);
        } //End block
        synchronized
(mLock)        {
            mLock.notify();
        } //End block
        break;
        case EVENT_EMAIL_LOAD_DONE:
        log("Loading USIM Email records done");
        ar = (AsyncResult) msg.obj;
        if(ar.exception == null)        
        {
            mEmailFileRecord = ((ArrayList<byte[]>)ar.result);
        } //End block
        synchronized
(mLock)        {
            mLock.notify();
        } //End block
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.996 -0400", hash_original_method = "B26CBB1291A6152D9C092C7AC934B437", hash_generated_method = "AAF410B832FB4150C632556005AFA12A")
    private void log(String msg) {
        addTaint(msg.getTaint());
        if(DBG)        
        Log.d(LOG_TAG, msg);
        // ---------- Original Method ----------
        //if(DBG) Log.d(LOG_TAG, msg);
    }

    
    private class PbrFile {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.996 -0400", hash_original_field = "B8225B3EF7629400F3BF178F99D2511D", hash_generated_field = "DD2BC0CCB77C9B04C419C3A18FB77046")

        HashMap<Integer,Map<Integer,Integer>> mFileIds;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.997 -0400", hash_original_method = "D67956DDFF065803AA18EDD362DE0213", hash_generated_method = "722D976515B3987707A664C21D6D3378")
          PbrFile(ArrayList<byte[]> records) {
            addTaint(records.getTaint());
            mFileIds = new HashMap<Integer, Map<Integer, Integer>>();
            SimTlv recTlv;
            int recNum = 0;
for(byte[] record : records)
            {
                recTlv = new SimTlv(record, 0, record.length);
                parseTag(recTlv, recNum);
                recNum ++;
            } //End block
            // ---------- Original Method ----------
            //mFileIds = new HashMap<Integer, Map<Integer, Integer>>();
            //SimTlv recTlv;
            //int recNum = 0;
            //for (byte[] record: records) {
                //recTlv = new SimTlv(record, 0, record.length);
                //parseTag(recTlv, recNum);
                //recNum ++;
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.997 -0400", hash_original_method = "D93ED3119C94191277253FF2EE0C71AD", hash_generated_method = "CDFA39D15832799BA034DAB20D3CC40D")
         void parseTag(SimTlv tlv, int recNum) {
            addTaint(recNum);
            addTaint(tlv.getTaint());
            SimTlv tlvEf;
            int tag;
            byte[] data;
            Map<Integer, Integer> val = new HashMap<Integer, Integer>();
            do {
                {
                    tag = tlv.getTag();
switch(tag){
                    case USIM_TYPE1_TAG:
                    case USIM_TYPE3_TAG:
                    case USIM_TYPE2_TAG:
                    data = tlv.getData();
                    tlvEf = new SimTlv(data, 0, data.length);
                    parseEf(tlvEf, val, tag);
                    break;
}
                } //End block
} while (tlv.nextObject());
            mFileIds.put(recNum, val);
            // ---------- Original Method ----------
            //SimTlv tlvEf;
            //int tag;
            //byte[] data;
            //Map<Integer, Integer> val = new HashMap<Integer, Integer>();
            //do {
                //tag = tlv.getTag();
                //switch(tag) {
                //case USIM_TYPE1_TAG: 
                //case USIM_TYPE3_TAG: 
                //case USIM_TYPE2_TAG: 
                    //data = tlv.getData();
                    //tlvEf = new SimTlv(data, 0, data.length);
                    //parseEf(tlvEf, val, tag);
                    //break;
                //}
            //} while (tlv.nextObject());
            //mFileIds.put(recNum, val);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.997 -0400", hash_original_method = "27E6C520D8DED1C5B5FE1A348EAE7100", hash_generated_method = "C031F6DD438E67F7A35E4818F7519E09")
         void parseEf(SimTlv tlv, Map<Integer, Integer> val, int parentTag) {
            addTaint(parentTag);
            addTaint(val.getTaint());
            addTaint(tlv.getTaint());
            int tag;
            byte[] data;
            int tagNumberWithinParentTag = 0;
            do {
                {
                    tag = tlv.getTag();
                    if(parentTag == USIM_TYPE2_TAG && tag == USIM_EFEMAIL_TAG)                    
                    {
                        mEmailPresentInIap = true;
                        mEmailTagNumberInIap = tagNumberWithinParentTag;
                    } //End block
switch(tag){
                    case USIM_EFEMAIL_TAG:
                    case USIM_EFADN_TAG:
                    case USIM_EFEXT1_TAG:
                    case USIM_EFANR_TAG:
                    case USIM_EFPBC_TAG:
                    case USIM_EFGRP_TAG:
                    case USIM_EFAAS_TAG:
                    case USIM_EFGSD_TAG:
                    case USIM_EFUID_TAG:
                    case USIM_EFCCP1_TAG:
                    case USIM_EFIAP_TAG:
                    case USIM_EFSNE_TAG:
                    data = tlv.getData();
                    int efid = ((data[0] & 0xFF) << 8) | (data[1] & 0xFF);
                    val.put(tag, efid);
                    break;
}                    tagNumberWithinParentTag ++;
                } //End block
} while (tlv.nextObject());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.997 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "D922E4732DF1A8050A7A55C2D62EC423")

    private static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.997 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.997 -0400", hash_original_field = "CD352F3B9D0116533D402573E8A4DCF2", hash_generated_field = "1C7072F210A9F01872115E74B443A7C2")

    private static final int EVENT_PBR_LOAD_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.998 -0400", hash_original_field = "1CFDD3F5FDEF4A6626FBAB9748306ED1", hash_generated_field = "8B8127A364BC154368D2CA94E199826A")

    private static final int EVENT_USIM_ADN_LOAD_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.998 -0400", hash_original_field = "791BE5F906F5488493170F0A72D746E3", hash_generated_field = "FF1B3159F722D0E2252C1CE019A8E559")

    private static final int EVENT_IAP_LOAD_DONE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.998 -0400", hash_original_field = "3DD28124E3B78AF6F22B9BD4596CD9C9", hash_generated_field = "84966C7C18B9D868C7030F1A0F87EB9C")

    private static final int EVENT_EMAIL_LOAD_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.998 -0400", hash_original_field = "A5BADDDBA23AD45683468FBC8BB12B56", hash_generated_field = "AB49351C0C67D5101FE6BCA8B9ED3322")

    private static final int USIM_TYPE1_TAG = 0xA8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.998 -0400", hash_original_field = "6079D3004778761C3EC181BBA589F910", hash_generated_field = "FFA29DCAF13AB805CCCC449C8F474D63")

    private static final int USIM_TYPE2_TAG = 0xA9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.998 -0400", hash_original_field = "52390331DE7E8F6C5A35626A32180AFE", hash_generated_field = "526A6B91825B243AC22F035F0742D7C0")

    private static final int USIM_TYPE3_TAG = 0xAA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.998 -0400", hash_original_field = "37C81B662AAC2B38F18BF44CA6A4A37F", hash_generated_field = "EBE8D23A68F4248C778E6521D3841324")

    private static final int USIM_EFADN_TAG = 0xC0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.998 -0400", hash_original_field = "F93D18E8D71CC1A36BCAD173070006BC", hash_generated_field = "F0933E4B079887BF30150AA4A729FBE8")

    private static final int USIM_EFIAP_TAG = 0xC1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.998 -0400", hash_original_field = "B275F5625E9AF8B2EEB79E41A9EAA1F5", hash_generated_field = "1C4CC1E181A2BE8CE9A6765D1A59E830")

    private static final int USIM_EFEXT1_TAG = 0xC2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.998 -0400", hash_original_field = "44D52017DE50936354BB014167EF1023", hash_generated_field = "94F97153FD11E48B73BB877CB4372BC4")

    private static final int USIM_EFSNE_TAG = 0xC3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.998 -0400", hash_original_field = "71124F1C90CE93784C43B92498D1970D", hash_generated_field = "D82C230BC5822E29EF5458D69FE172CF")

    private static final int USIM_EFANR_TAG = 0xC4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.998 -0400", hash_original_field = "A5A229CA49D64B5979288BB378A0D978", hash_generated_field = "7742BCE8249F92717AD8569D0CA09B3F")

    private static final int USIM_EFPBC_TAG = 0xC5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.998 -0400", hash_original_field = "A88828E5AAC306BAB8183A35DB1B61AB", hash_generated_field = "4B9F0B93A9E74AECF883919694C255EB")

    private static final int USIM_EFGRP_TAG = 0xC6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.998 -0400", hash_original_field = "80D9D7423DC4AA8F62C982BEE2EB15B6", hash_generated_field = "9043CACA7B56CF871B398E2E3104B81F")

    private static final int USIM_EFAAS_TAG = 0xC7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.998 -0400", hash_original_field = "A9C7FE93F73FDF4232B5A94B83B75465", hash_generated_field = "10882180C7FBB6B7841898AC8588E860")

    private static final int USIM_EFGSD_TAG = 0xC8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.998 -0400", hash_original_field = "5C58BA68643A1946514F6BAE0EE3E0A3", hash_generated_field = "65087FA88C25538A2C4F170D25BBE1DB")

    private static final int USIM_EFUID_TAG = 0xC9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.998 -0400", hash_original_field = "ECF3E30EA67882C0BF2F95801F306829", hash_generated_field = "F26C983BC0EB690DFFD958504CC21D62")

    private static final int USIM_EFEMAIL_TAG = 0xCA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.999 -0400", hash_original_field = "627C8FC5D0B2BB7A75B0DFCCBA487BDC", hash_generated_field = "A9142AB7D4AAFA3289BD2734D8B176B9")

    private static final int USIM_EFCCP1_TAG = 0xCB;
}


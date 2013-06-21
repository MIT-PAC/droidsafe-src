package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    private PbrFile mPbrFile;
    private Boolean mIsPbrPresent;
    private PhoneBase mPhone;
    private AdnRecordCache mAdnCache;
    private Object mLock = new Object();
    private ArrayList<AdnRecord> mPhoneBookRecords;
    private boolean mEmailPresentInIap = false;
    private int mEmailTagNumberInIap = 0;
    private ArrayList<byte[]> mIapFileRecord;
    private ArrayList<byte[]> mEmailFileRecord;
    private Map<Integer, ArrayList<String>> mEmailsForAdnRec;
    private boolean mRefreshCache = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.050 -0400", hash_original_method = "49FEAD20C5C47E2BA26F4ED2BE1800D2", hash_generated_method = "79D28584EAFE923BC98DB831CD1302B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UsimPhoneBookManager(PhoneBase phone, AdnRecordCache cache) {
        dsTaint.addTaint(phone.dsTaint);
        dsTaint.addTaint(cache.dsTaint);
        mPhoneBookRecords = new ArrayList<AdnRecord>();
        mPbrFile = null;
        mIsPbrPresent = true;
        // ---------- Original Method ----------
        //mPhone = phone;
        //mPhoneBookRecords = new ArrayList<AdnRecord>();
        //mPbrFile = null;
        //mIsPbrPresent = true;
        //mAdnCache = cache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.051 -0400", hash_original_method = "E0D906663A0994551C89240DFDC0BDC8", hash_generated_method = "ABA5A37BF0D9B72AE08F6D010D45EC01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.051 -0400", hash_original_method = "B81A15F32DE42ED7FA5FD76607998109", hash_generated_method = "F7A11AF571A1C16E9EE827F8E2207E8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayList<AdnRecord> loadEfFilesFromUsim() {
        {
            {
                boolean var9D433910E1D3843659FCB90F123565EA_1114640297 = (!mPhoneBookRecords.isEmpty());
                {
                    {
                        mRefreshCache = false;
                        refreshCache();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                readPbrFileAndWait();
            } //End block
            int numRecs;
            numRecs = mPbrFile.mFileIds.size();
            {
                int i;
                i = 0;
                {
                    readAdnFileAndWait(i);
                    readEmailFileAndWait(i);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (ArrayList<AdnRecord>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.052 -0400", hash_original_method = "B532D4E2E21067521A95047E8C8D19E8", hash_generated_method = "DEE7A7A6E640A8A49F0A7EEB22EC3C5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void refreshCache() {
        mPhoneBookRecords.clear();
        int numRecs;
        numRecs = mPbrFile.mFileIds.size();
        {
            int i;
            i = 0;
            {
                readAdnFileAndWait(i);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mPbrFile == null) return;
        //mPhoneBookRecords.clear();
        //int numRecs = mPbrFile.mFileIds.size();
        //for (int i = 0; i < numRecs; i++) {
            //readAdnFileAndWait(i);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.052 -0400", hash_original_method = "4227D3403F7221594B4C4984D58136B1", hash_generated_method = "94D421C1BCB4B33EF173797F9066F6AC")
    @DSModeled(DSC.SAFE)
    public void invalidateCache() {
        mRefreshCache = true;
        // ---------- Original Method ----------
        //mRefreshCache = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.052 -0400", hash_original_method = "78E381AC3959E12E81678D4DFFBA5C8B", hash_generated_method = "3F8F554B0DFE76C73E3BA3F105EA8D1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readPbrFileAndWait() {
        mPhone.getIccFileHandler().loadEFLinearFixedAll(EF_PBR, obtainMessage(EVENT_PBR_LOAD_DONE));
        try 
        {
            mLock.wait();
        } //End block
        catch (InterruptedException e)
        { }
        // ---------- Original Method ----------
        //mPhone.getIccFileHandler().loadEFLinearFixedAll(EF_PBR, obtainMessage(EVENT_PBR_LOAD_DONE));
        //try {
            //mLock.wait();
        //} catch (InterruptedException e) {
            //Log.e(LOG_TAG, "Interrupted Exception in readAdnFileAndWait");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.053 -0400", hash_original_method = "48BBB6A0A30AD38B5848D3F55664B632", hash_generated_method = "D130841AE3D99EB1DFF2FE8CBD0DD294")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readEmailFileAndWait(int recNum) {
        dsTaint.addTaint(recNum);
        Map <Integer,Integer> fileIds;
        fileIds = mPbrFile.mFileIds.get(recNum);
        {
            boolean var2294A8F7D58B58C18C6F6AAEB87D3621_1808994267 = (fileIds.containsKey(USIM_EFEMAIL_TAG));
            {
                int efid;
                efid = fileIds.get(USIM_EFEMAIL_TAG);
                {
                    readIapFileAndWait(fileIds.get(USIM_EFIAP_TAG));
                } //End block
                mPhone.getIccFileHandler().loadEFLinearFixedAll(fileIds.get(USIM_EFEMAIL_TAG),
                    obtainMessage(EVENT_EMAIL_LOAD_DONE));
                try 
                {
                    mLock.wait();
                } //End block
                catch (InterruptedException e)
                { }
                updatePhoneAdnRecord();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.053 -0400", hash_original_method = "9E809A1ED86DEC7D2454BACD182423F6", hash_generated_method = "00F8F0EC6198FA35B627EA8F9BA99179")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readIapFileAndWait(int efid) {
        dsTaint.addTaint(efid);
        mPhone.getIccFileHandler().loadEFLinearFixedAll(efid, obtainMessage(EVENT_IAP_LOAD_DONE));
        try 
        {
            mLock.wait();
        } //End block
        catch (InterruptedException e)
        { }
        // ---------- Original Method ----------
        //mPhone.getIccFileHandler().loadEFLinearFixedAll(efid, obtainMessage(EVENT_IAP_LOAD_DONE));
        //try {
            //mLock.wait();
        //} catch (InterruptedException e) {
            //Log.e(LOG_TAG, "Interrupted Exception in readIapFileAndWait");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.053 -0400", hash_original_method = "DBF9EE6E650F45B09979783B6AE92B3D", hash_generated_method = "06321A5C5906311640F6F52BEE62B55E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updatePhoneAdnRecord() {
        int numAdnRecs;
        numAdnRecs = mPhoneBookRecords.size();
        {
            {
                int i;
                i = 0;
                {
                    byte[] record;
                    record = null;
                    try 
                    {
                        record = mIapFileRecord.get(i);
                    } //End block
                    catch (IndexOutOfBoundsException e)
                    { }
                    int recNum;
                    recNum = record[mEmailTagNumberInIap];
                    {
                        String[] emails;
                        emails = new String[1];
                        emails[0] = readEmailRecord(recNum - 1);
                        AdnRecord rec;
                        rec = mPhoneBookRecords.get(i);
                        {
                            rec.setEmails(emails);
                        } //End block
                        {
                            rec = new AdnRecord("", "", emails);
                        } //End block
                        mPhoneBookRecords.set(i, rec);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        int len;
        len = mPhoneBookRecords.size();
        {
            parseType1EmailFile(len);
        } //End block
        {
            int i;
            i = 0;
            {
                ArrayList<String> emailList;
                emailList = null;
                try 
                {
                    emailList = mEmailsForAdnRec.get(i);
                } //End block
                catch (IndexOutOfBoundsException e)
                { }
                AdnRecord rec;
                rec = mPhoneBookRecords.get(i);
                String[] emails;
                emails = new String[emailList.size()];
                System.arraycopy(emailList.toArray(), 0, emails, 0, emailList.size());
                rec.setEmails(emails);
                mPhoneBookRecords.set(i, rec);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.054 -0400", hash_original_method = "8AA09CE6055FA7D5E93DEAB0645B4CBD", hash_generated_method = "56F618ADE9506487D2E4EB3983BF6561")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void parseType1EmailFile(int numRecs) {
        dsTaint.addTaint(numRecs);
        mEmailsForAdnRec = new HashMap<Integer, ArrayList<String>>();
        byte[] emailRec;
        emailRec = null;
        {
            int i;
            i = 0;
            {
                try 
                {
                    emailRec = mEmailFileRecord.get(i);
                } //End block
                catch (IndexOutOfBoundsException e)
                { }
                int adnRecNum;
                adnRecNum = emailRec[emailRec.length - 1];
                String email;
                email = readEmailRecord(i);
                {
                    boolean var7580166154D64CB834904276F6B67CAD_787003197 = (email == null || email.equals(""));
                } //End collapsed parenthetic
                ArrayList<String> val;
                val = mEmailsForAdnRec.get(adnRecNum - 1);
                {
                    val = new ArrayList<String>();
                } //End block
                val.add(email);
                mEmailsForAdnRec.put(adnRecNum - 1, val);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.054 -0400", hash_original_method = "9DD87F6722942AC55924DBE05DD72D60", hash_generated_method = "92531E34A6B645FB427CA74993E39BF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String readEmailRecord(int recNum) {
        dsTaint.addTaint(recNum);
        byte[] emailRec;
        emailRec = null;
        try 
        {
            emailRec = mEmailFileRecord.get(recNum);
        } //End block
        catch (IndexOutOfBoundsException e)
        { }
        String email;
        email = IccUtils.adnStringFieldToString(emailRec, 0, emailRec.length - 2);
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.055 -0400", hash_original_method = "4035A9584818EC181E07E84AC976F741", hash_generated_method = "5A4F9CD51853BFE9A61D8DE61BF74A1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readAdnFileAndWait(int recNum) {
        dsTaint.addTaint(recNum);
        Map <Integer,Integer> fileIds;
        fileIds = mPbrFile.mFileIds.get(recNum);
        {
            boolean varA67B124270236CD7C1FC832187360DEE_810040990 = (fileIds == null || fileIds.isEmpty());
        } //End collapsed parenthetic
        int extEf;
        extEf = 0;
        {
            boolean var826F82931AF9A1D83BE91383C0B6480A_2076160927 = (fileIds.containsKey(USIM_EFEXT1_TAG));
            {
                extEf = fileIds.get(USIM_EFEXT1_TAG);
            } //End block
        } //End collapsed parenthetic
        mAdnCache.requestLoadAllAdnLike(fileIds.get(USIM_EFADN_TAG),
            extEf, obtainMessage(EVENT_USIM_ADN_LOAD_DONE));
        try 
        {
            mLock.wait();
        } //End block
        catch (InterruptedException e)
        { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.055 -0400", hash_original_method = "EC7FC3EA469B316149A3EE38C863088E", hash_generated_method = "C35BEFAAE54EE0A1672BB5D80066D3B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void createPbrFile(ArrayList<byte[]> records) {
        dsTaint.addTaint(records.dsTaint);
        {
            mPbrFile = null;
            mIsPbrPresent = false;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.065 -0400", hash_original_method = "DBCDBDCB51A5EB5E1A763E38D42C7855", hash_generated_method = "47FC7C612F110C25D46D035E546748D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        AsyncResult ar;
        //Begin case EVENT_PBR_LOAD_DONE 
        ar = (AsyncResult) msg.obj;
        //End case EVENT_PBR_LOAD_DONE 
        //Begin case EVENT_PBR_LOAD_DONE 
        {
            createPbrFile((ArrayList<byte[]>)ar.result);
        } //End block
        //End case EVENT_PBR_LOAD_DONE 
        //Begin case EVENT_PBR_LOAD_DONE 
        {
            mLock.notify();
        } //End block
        //End case EVENT_PBR_LOAD_DONE 
        //Begin case EVENT_USIM_ADN_LOAD_DONE 
        log("Loading USIM ADN records done");
        //End case EVENT_USIM_ADN_LOAD_DONE 
        //Begin case EVENT_USIM_ADN_LOAD_DONE 
        ar = (AsyncResult) msg.obj;
        //End case EVENT_USIM_ADN_LOAD_DONE 
        //Begin case EVENT_USIM_ADN_LOAD_DONE 
        {
            mPhoneBookRecords.addAll((ArrayList<AdnRecord>)ar.result);
        } //End block
        //End case EVENT_USIM_ADN_LOAD_DONE 
        //Begin case EVENT_USIM_ADN_LOAD_DONE 
        {
            mLock.notify();
        } //End block
        //End case EVENT_USIM_ADN_LOAD_DONE 
        //Begin case EVENT_IAP_LOAD_DONE 
        log("Loading USIM IAP records done");
        //End case EVENT_IAP_LOAD_DONE 
        //Begin case EVENT_IAP_LOAD_DONE 
        ar = (AsyncResult) msg.obj;
        //End case EVENT_IAP_LOAD_DONE 
        //Begin case EVENT_IAP_LOAD_DONE 
        {
            mIapFileRecord = ((ArrayList<byte[]>)ar.result);
        } //End block
        //End case EVENT_IAP_LOAD_DONE 
        //Begin case EVENT_IAP_LOAD_DONE 
        {
            mLock.notify();
        } //End block
        //End case EVENT_IAP_LOAD_DONE 
        //Begin case EVENT_EMAIL_LOAD_DONE 
        log("Loading USIM Email records done");
        //End case EVENT_EMAIL_LOAD_DONE 
        //Begin case EVENT_EMAIL_LOAD_DONE 
        ar = (AsyncResult) msg.obj;
        //End case EVENT_EMAIL_LOAD_DONE 
        //Begin case EVENT_EMAIL_LOAD_DONE 
        {
            mEmailFileRecord = ((ArrayList<byte[]>)ar.result);
        } //End block
        //End case EVENT_EMAIL_LOAD_DONE 
        //Begin case EVENT_EMAIL_LOAD_DONE 
        {
            mLock.notify();
        } //End block
        //End case EVENT_EMAIL_LOAD_DONE 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.065 -0400", hash_original_method = "B26CBB1291A6152D9C092C7AC934B437", hash_generated_method = "112A9B9653C1FE3B4D0C73B1DFE11696")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void log(String msg) {
        dsTaint.addTaint(msg);
        Log.d(LOG_TAG, msg);
        // ---------- Original Method ----------
        //if(DBG) Log.d(LOG_TAG, msg);
    }

    
    private class PbrFile {
        HashMap<Integer,Map<Integer,Integer>> mFileIds;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.069 -0400", hash_original_method = "D67956DDFF065803AA18EDD362DE0213", hash_generated_method = "A4BF0C4EB4B73F5F8F5A972A73F0D889")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         PbrFile(ArrayList<byte[]> records) {
            dsTaint.addTaint(records.dsTaint);
            mFileIds = new HashMap<Integer, Map<Integer, Integer>>();
            SimTlv recTlv;
            int recNum;
            recNum = 0;
            {
                Iterator<byte[]> varC5932E3C459EC5D6F84D20C1CA8BC089_1461625655 = (records).iterator();
                varC5932E3C459EC5D6F84D20C1CA8BC089_1461625655.hasNext();
                byte[] record = varC5932E3C459EC5D6F84D20C1CA8BC089_1461625655.next();
                {
                    recTlv = new SimTlv(record, 0, record.length);
                    parseTag(recTlv, recNum);
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.070 -0400", hash_original_method = "D93ED3119C94191277253FF2EE0C71AD", hash_generated_method = "07A166E3C585A000A7951D97FFC6592F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void parseTag(SimTlv tlv, int recNum) {
            dsTaint.addTaint(recNum);
            dsTaint.addTaint(tlv.dsTaint);
            SimTlv tlvEf;
            int tag;
            byte[] data;
            Map<Integer, Integer> val;
            val = new HashMap<Integer, Integer>();
            {
                tag = tlv.getTag();
                //Begin case USIM_TYPE1_TAG USIM_TYPE3_TAG USIM_TYPE2_TAG 
                data = tlv.getData();
                //End case USIM_TYPE1_TAG USIM_TYPE3_TAG USIM_TYPE2_TAG 
                //Begin case USIM_TYPE1_TAG USIM_TYPE3_TAG USIM_TYPE2_TAG 
                tlvEf = new SimTlv(data, 0, data.length);
                //End case USIM_TYPE1_TAG USIM_TYPE3_TAG USIM_TYPE2_TAG 
                //Begin case USIM_TYPE1_TAG USIM_TYPE3_TAG USIM_TYPE2_TAG 
                parseEf(tlvEf, val, tag);
                //End case USIM_TYPE1_TAG USIM_TYPE3_TAG USIM_TYPE2_TAG 
            } //End block
            {
                boolean var2BD20FFFB0EEC59B00776BE63CF9A28E_1143732730 = (tlv.nextObject());
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.071 -0400", hash_original_method = "27E6C520D8DED1C5B5FE1A348EAE7100", hash_generated_method = "24070EA960C7F73A7B6C72DDA895D078")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void parseEf(SimTlv tlv, Map<Integer, Integer> val, int parentTag) {
            dsTaint.addTaint(val.dsTaint);
            dsTaint.addTaint(parentTag);
            dsTaint.addTaint(tlv.dsTaint);
            int tag;
            byte[] data;
            int tagNumberWithinParentTag;
            tagNumberWithinParentTag = 0;
            {
                tag = tlv.getTag();
                {
                    mEmailPresentInIap = true;
                    mEmailTagNumberInIap = tagNumberWithinParentTag;
                } //End block
                //Begin case USIM_EFEMAIL_TAG USIM_EFADN_TAG USIM_EFEXT1_TAG USIM_EFANR_TAG USIM_EFPBC_TAG USIM_EFGRP_TAG USIM_EFAAS_TAG USIM_EFGSD_TAG USIM_EFUID_TAG USIM_EFCCP1_TAG USIM_EFIAP_TAG USIM_EFSNE_TAG 
                data = tlv.getData();
                //End case USIM_EFEMAIL_TAG USIM_EFADN_TAG USIM_EFEXT1_TAG USIM_EFANR_TAG USIM_EFPBC_TAG USIM_EFGRP_TAG USIM_EFAAS_TAG USIM_EFGSD_TAG USIM_EFUID_TAG USIM_EFCCP1_TAG USIM_EFIAP_TAG USIM_EFSNE_TAG 
                //Begin case USIM_EFEMAIL_TAG USIM_EFADN_TAG USIM_EFEXT1_TAG USIM_EFANR_TAG USIM_EFPBC_TAG USIM_EFGRP_TAG USIM_EFAAS_TAG USIM_EFGSD_TAG USIM_EFUID_TAG USIM_EFCCP1_TAG USIM_EFIAP_TAG USIM_EFSNE_TAG 
                int efid;
                efid = ((data[0] & 0xFF) << 8) | (data[1] & 0xFF);
                //End case USIM_EFEMAIL_TAG USIM_EFADN_TAG USIM_EFEXT1_TAG USIM_EFANR_TAG USIM_EFPBC_TAG USIM_EFGRP_TAG USIM_EFAAS_TAG USIM_EFGSD_TAG USIM_EFUID_TAG USIM_EFCCP1_TAG USIM_EFIAP_TAG USIM_EFSNE_TAG 
                //Begin case USIM_EFEMAIL_TAG USIM_EFADN_TAG USIM_EFEXT1_TAG USIM_EFANR_TAG USIM_EFPBC_TAG USIM_EFGRP_TAG USIM_EFAAS_TAG USIM_EFGSD_TAG USIM_EFUID_TAG USIM_EFCCP1_TAG USIM_EFIAP_TAG USIM_EFSNE_TAG 
                val.put(tag, efid);
                //End case USIM_EFEMAIL_TAG USIM_EFADN_TAG USIM_EFEXT1_TAG USIM_EFANR_TAG USIM_EFPBC_TAG USIM_EFGRP_TAG USIM_EFAAS_TAG USIM_EFGSD_TAG USIM_EFUID_TAG USIM_EFCCP1_TAG USIM_EFIAP_TAG USIM_EFSNE_TAG 
            } //End block
            {
                boolean var2BD20FFFB0EEC59B00776BE63CF9A28E_1710057037 = (tlv.nextObject());
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private static final String LOG_TAG = "GSM";
    private static final boolean DBG = true;
    private static final int EVENT_PBR_LOAD_DONE = 1;
    private static final int EVENT_USIM_ADN_LOAD_DONE = 2;
    private static final int EVENT_IAP_LOAD_DONE = 3;
    private static final int EVENT_EMAIL_LOAD_DONE = 4;
    private static final int USIM_TYPE1_TAG   = 0xA8;
    private static final int USIM_TYPE2_TAG   = 0xA9;
    private static final int USIM_TYPE3_TAG   = 0xAA;
    private static final int USIM_EFADN_TAG   = 0xC0;
    private static final int USIM_EFIAP_TAG   = 0xC1;
    private static final int USIM_EFEXT1_TAG  = 0xC2;
    private static final int USIM_EFSNE_TAG   = 0xC3;
    private static final int USIM_EFANR_TAG   = 0xC4;
    private static final int USIM_EFPBC_TAG   = 0xC5;
    private static final int USIM_EFGRP_TAG   = 0xC6;
    private static final int USIM_EFAAS_TAG   = 0xC7;
    private static final int USIM_EFGSD_TAG   = 0xC8;
    private static final int USIM_EFUID_TAG   = 0xC9;
    private static final int USIM_EFEMAIL_TAG = 0xCA;
    private static final int USIM_EFCCP1_TAG  = 0xCB;
}


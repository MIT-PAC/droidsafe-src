package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final String LOG_TAG = "GSM";
    private static final boolean DBG = true;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.031 -0400", hash_original_method = "49FEAD20C5C47E2BA26F4ED2BE1800D2", hash_generated_method = "0CF8E3173060DC9D9F1E662BCF6E3833")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.031 -0400", hash_original_method = "E0D906663A0994551C89240DFDC0BDC8", hash_generated_method = "47F3B608A6245F766CA9414ADD30BE85")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.032 -0400", hash_original_method = "B81A15F32DE42ED7FA5FD76607998109", hash_generated_method = "EF37AC99D76730C3704CBDBCD65CDC56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayList<AdnRecord> loadEfFilesFromUsim() {
        {
            {
                boolean var9D433910E1D3843659FCB90F123565EA_2121532727 = (!mPhoneBookRecords.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.032 -0400", hash_original_method = "B532D4E2E21067521A95047E8C8D19E8", hash_generated_method = "64AD0AA3CBBE29ACB14255D08712532A")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.032 -0400", hash_original_method = "4227D3403F7221594B4C4984D58136B1", hash_generated_method = "8F49576F19EC20F09F515824E0C0EDA9")
    @DSModeled(DSC.SAFE)
    public void invalidateCache() {
        mRefreshCache = true;
        // ---------- Original Method ----------
        //mRefreshCache = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.032 -0400", hash_original_method = "78E381AC3959E12E81678D4DFFBA5C8B", hash_generated_method = "32F655C1E8B5C3DB71F8E60267F66255")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.032 -0400", hash_original_method = "48BBB6A0A30AD38B5848D3F55664B632", hash_generated_method = "BDAF8ED78DB51DC8C7CCC6B0DAF884EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readEmailFileAndWait(int recNum) {
        dsTaint.addTaint(recNum);
        Map <Integer,Integer> fileIds;
        fileIds = mPbrFile.mFileIds.get(recNum);
        {
            boolean var2294A8F7D58B58C18C6F6AAEB87D3621_2016077493 = (fileIds.containsKey(USIM_EFEMAIL_TAG));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.032 -0400", hash_original_method = "9E809A1ED86DEC7D2454BACD182423F6", hash_generated_method = "70380AFA24B23C42563D23C384147DF6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.032 -0400", hash_original_method = "DBF9EE6E650F45B09979783B6AE92B3D", hash_generated_method = "DBEA21267A77CDEB81F8D6819D2E9C9F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.033 -0400", hash_original_method = "8AA09CE6055FA7D5E93DEAB0645B4CBD", hash_generated_method = "DA4E870B5E6DA279EA21E379D0991127")
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
                    boolean var7580166154D64CB834904276F6B67CAD_1892216223 = (email == null || email.equals(""));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.033 -0400", hash_original_method = "9DD87F6722942AC55924DBE05DD72D60", hash_generated_method = "A764DA207A59D243E5D062E999E039C2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.033 -0400", hash_original_method = "4035A9584818EC181E07E84AC976F741", hash_generated_method = "B278F90076D5AF7E9487B0E4EC7B7330")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readAdnFileAndWait(int recNum) {
        dsTaint.addTaint(recNum);
        Map <Integer,Integer> fileIds;
        fileIds = mPbrFile.mFileIds.get(recNum);
        {
            boolean varA67B124270236CD7C1FC832187360DEE_183743922 = (fileIds == null || fileIds.isEmpty());
        } //End collapsed parenthetic
        int extEf;
        extEf = 0;
        {
            boolean var826F82931AF9A1D83BE91383C0B6480A_1744432822 = (fileIds.containsKey(USIM_EFEXT1_TAG));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.033 -0400", hash_original_method = "EC7FC3EA469B316149A3EE38C863088E", hash_generated_method = "888F9A26BA5B918E62082ABF3E65B588")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.033 -0400", hash_original_method = "DBCDBDCB51A5EB5E1A763E38D42C7855", hash_generated_method = "4E10D0AE86D6132E2F569BC14A8252A0")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.034 -0400", hash_original_method = "B26CBB1291A6152D9C092C7AC934B437", hash_generated_method = "094EA10445171343C6E13B6CC8A5E0C4")
    @DSModeled(DSC.SAFE)
    private void log(String msg) {
        dsTaint.addTaint(msg);
        Log.d(LOG_TAG, msg);
        // ---------- Original Method ----------
        //if(DBG) Log.d(LOG_TAG, msg);
    }

    
    private class PbrFile {
        HashMap<Integer,Map<Integer,Integer>> mFileIds;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.034 -0400", hash_original_method = "D67956DDFF065803AA18EDD362DE0213", hash_generated_method = "B871843A8375300E34788F36795E26D6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         PbrFile(ArrayList<byte[]> records) {
            dsTaint.addTaint(records.dsTaint);
            mFileIds = new HashMap<Integer, Map<Integer, Integer>>();
            SimTlv recTlv;
            int recNum;
            recNum = 0;
            {
                Iterator<byte[]> seatecAstronomy42 = records.iterator();
                seatecAstronomy42.hasNext();
                byte[] record = seatecAstronomy42.next();
                {
                    recTlv = new SimTlv(record, 0, record.length);
                    parseTag(recTlv, recNum);
                    recNum ++;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.034 -0400", hash_original_method = "D93ED3119C94191277253FF2EE0C71AD", hash_generated_method = "84EE2E78380F8B9DA3DA5CC5CFCDE525")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void parseTag(SimTlv tlv, int recNum) {
            dsTaint.addTaint(tlv.dsTaint);
            dsTaint.addTaint(recNum);
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
                boolean var2BD20FFFB0EEC59B00776BE63CF9A28E_1403364554 = (tlv.nextObject());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:10.034 -0400", hash_original_method = "27E6C520D8DED1C5B5FE1A348EAE7100", hash_generated_method = "104D7624EE6D90370904734FA89962D8")
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
                tagNumberWithinParentTag ++;
            } //End block
            {
                boolean var2BD20FFFB0EEC59B00776BE63CF9A28E_513750295 = (tlv.nextObject());
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
}



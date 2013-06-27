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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.583 -0400", hash_original_field = "7D373B4F0DFF7E92AC122910BF9B25C5", hash_generated_field = "208E31DBC6A3857B5997E7C1BCB1166B")

    private PbrFile mPbrFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.583 -0400", hash_original_field = "30E1F8B5FEAFF3D5D3F3D60A2669D6EC", hash_generated_field = "73182A5184196FAAD039E44D2C16F121")

    private Boolean mIsPbrPresent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.583 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "E7BDAD23CF4F53103B9ED94B380FFE2A")

    private PhoneBase mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.583 -0400", hash_original_field = "BA1723592FC6435C40C8AD8626B01970", hash_generated_field = "640171AAF9460B26A1955741F0E8BDD1")

    private AdnRecordCache mAdnCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.583 -0400", hash_original_field = "B89DEBA2CB26B1AC973763E3E152017B", hash_generated_field = "C8F8FCD335E09ED70E70801AB39A894A")

    private Object mLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.583 -0400", hash_original_field = "53A38FDCFCCC8ECCB18A04C23D93072B", hash_generated_field = "F015F032A7EB90DEA83FE0426648EF9F")

    private ArrayList<AdnRecord> mPhoneBookRecords;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.583 -0400", hash_original_field = "63024429CACFB70F75A3BECB3F2E6C36", hash_generated_field = "8920C02D769F140478E3FF9AAD342322")

    private boolean mEmailPresentInIap = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.583 -0400", hash_original_field = "7B86766C70934F19080F42E3D35B4DFF", hash_generated_field = "85C5852B556432EAA1F206B261622D09")

    private int mEmailTagNumberInIap = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.583 -0400", hash_original_field = "4D4CA197DA1CB6A858C87C60961C500B", hash_generated_field = "F0E5C0A038832AB5FF92C39635F7D36F")

    private ArrayList<byte[]> mIapFileRecord;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.584 -0400", hash_original_field = "419263776F38DA2F0745455CE61D0A73", hash_generated_field = "89657832ADF45F3FD36226A626E3E654")

    private ArrayList<byte[]> mEmailFileRecord;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.584 -0400", hash_original_field = "5D6A4FFEA4D7A28766408604E7A641BD", hash_generated_field = "9EF1137FB9FBD5B78A3EDED47EC19EF2")

    private Map<Integer, ArrayList<String>> mEmailsForAdnRec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.584 -0400", hash_original_field = "C9062F039BF2FB54B18203718C657CDA", hash_generated_field = "04358A29D9E3ACD0C9C2B1379BC842DB")

    private boolean mRefreshCache = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.584 -0400", hash_original_method = "49FEAD20C5C47E2BA26F4ED2BE1800D2", hash_generated_method = "C6C0A75B50E09ACCB60EA00A5CED0347")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.585 -0400", hash_original_method = "E0D906663A0994551C89240DFDC0BDC8", hash_generated_method = "ABA5A37BF0D9B72AE08F6D010D45EC01")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.595 -0400", hash_original_method = "B81A15F32DE42ED7FA5FD76607998109", hash_generated_method = "D2EC940AD6C8A0DA03434275EA54BBAB")
    public ArrayList<AdnRecord> loadEfFilesFromUsim() {
        ArrayList<AdnRecord> varB4EAC82CA7396A68D541C85D26508E83_872307768 = null; //Variable for return #1
        ArrayList<AdnRecord> varB4EAC82CA7396A68D541C85D26508E83_1768682170 = null; //Variable for return #2
        ArrayList<AdnRecord> varB4EAC82CA7396A68D541C85D26508E83_1957752018 = null; //Variable for return #3
        ArrayList<AdnRecord> varB4EAC82CA7396A68D541C85D26508E83_1680063943 = null; //Variable for return #4
        {
            {
                boolean var9D433910E1D3843659FCB90F123565EA_1354122507 = (!mPhoneBookRecords.isEmpty());
                {
                    {
                        mRefreshCache = false;
                        refreshCache();
                    } //End block
                    varB4EAC82CA7396A68D541C85D26508E83_872307768 = mPhoneBookRecords;
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1768682170 = null;
            {
                readPbrFileAndWait();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1957752018 = null;
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
        varB4EAC82CA7396A68D541C85D26508E83_1680063943 = mPhoneBookRecords;
        ArrayList<AdnRecord> varA7E53CE21691AB073D9660D615818899_1421048041; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1421048041 = varB4EAC82CA7396A68D541C85D26508E83_872307768;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1421048041 = varB4EAC82CA7396A68D541C85D26508E83_1768682170;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1421048041 = varB4EAC82CA7396A68D541C85D26508E83_1957752018;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1421048041 = varB4EAC82CA7396A68D541C85D26508E83_1680063943;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1421048041.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1421048041;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.596 -0400", hash_original_method = "B532D4E2E21067521A95047E8C8D19E8", hash_generated_method = "DEE7A7A6E640A8A49F0A7EEB22EC3C5D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.596 -0400", hash_original_method = "4227D3403F7221594B4C4984D58136B1", hash_generated_method = "94D421C1BCB4B33EF173797F9066F6AC")
    public void invalidateCache() {
        mRefreshCache = true;
        // ---------- Original Method ----------
        //mRefreshCache = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.597 -0400", hash_original_method = "78E381AC3959E12E81678D4DFFBA5C8B", hash_generated_method = "3F8F554B0DFE76C73E3BA3F105EA8D1B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.605 -0400", hash_original_method = "48BBB6A0A30AD38B5848D3F55664B632", hash_generated_method = "E1CE3502B03DD71A3A67E47573E90F32")
    private void readEmailFileAndWait(int recNum) {
        Map <Integer,Integer> fileIds;
        fileIds = mPbrFile.mFileIds.get(recNum);
        {
            boolean var2294A8F7D58B58C18C6F6AAEB87D3621_620979286 = (fileIds.containsKey(USIM_EFEMAIL_TAG));
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
        addTaint(recNum);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.606 -0400", hash_original_method = "9E809A1ED86DEC7D2454BACD182423F6", hash_generated_method = "8FC4D7ACC9751F1DB92E2C440B276842")
    private void readIapFileAndWait(int efid) {
        mPhone.getIccFileHandler().loadEFLinearFixedAll(efid, obtainMessage(EVENT_IAP_LOAD_DONE));
        try 
        {
            mLock.wait();
        } //End block
        catch (InterruptedException e)
        { }
        addTaint(efid);
        // ---------- Original Method ----------
        //mPhone.getIccFileHandler().loadEFLinearFixedAll(efid, obtainMessage(EVENT_IAP_LOAD_DONE));
        //try {
            //mLock.wait();
        //} catch (InterruptedException e) {
            //Log.e(LOG_TAG, "Interrupted Exception in readIapFileAndWait");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.610 -0400", hash_original_method = "DBF9EE6E650F45B09979783B6AE92B3D", hash_generated_method = "06321A5C5906311640F6F52BEE62B55E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.622 -0400", hash_original_method = "8AA09CE6055FA7D5E93DEAB0645B4CBD", hash_generated_method = "8B8EF966FC2E923B6762F32490EF216F")
     void parseType1EmailFile(int numRecs) {
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
                    boolean var7580166154D64CB834904276F6B67CAD_2142038445 = (email == null || email.equals(""));
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
        addTaint(numRecs);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.628 -0400", hash_original_method = "9DD87F6722942AC55924DBE05DD72D60", hash_generated_method = "4935FB5AB39E1223CADD41423E9C6C41")
    private String readEmailRecord(int recNum) {
        String varB4EAC82CA7396A68D541C85D26508E83_100260089 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_9461581 = null; //Variable for return #2
        byte[] emailRec;
        emailRec = null;
        try 
        {
            emailRec = mEmailFileRecord.get(recNum);
        } //End block
        catch (IndexOutOfBoundsException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_100260089 = null;
        } //End block
        String email;
        email = IccUtils.adnStringFieldToString(emailRec, 0, emailRec.length - 2);
        varB4EAC82CA7396A68D541C85D26508E83_9461581 = email;
        addTaint(recNum);
        String varA7E53CE21691AB073D9660D615818899_407048125; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_407048125 = varB4EAC82CA7396A68D541C85D26508E83_100260089;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_407048125 = varB4EAC82CA7396A68D541C85D26508E83_9461581;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_407048125.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_407048125;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.640 -0400", hash_original_method = "4035A9584818EC181E07E84AC976F741", hash_generated_method = "1D7DE77C47403D623C6C014E751A32E6")
    private void readAdnFileAndWait(int recNum) {
        Map <Integer,Integer> fileIds;
        fileIds = mPbrFile.mFileIds.get(recNum);
        {
            boolean varA67B124270236CD7C1FC832187360DEE_195507383 = (fileIds == null || fileIds.isEmpty());
        } //End collapsed parenthetic
        int extEf;
        extEf = 0;
        {
            boolean var826F82931AF9A1D83BE91383C0B6480A_1672143500 = (fileIds.containsKey(USIM_EFEXT1_TAG));
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
        addTaint(recNum);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.642 -0400", hash_original_method = "EC7FC3EA469B316149A3EE38C863088E", hash_generated_method = "E61880AEFD24F4AF7CF359A587F7808A")
    private void createPbrFile(ArrayList<byte[]> records) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.652 -0400", hash_original_method = "DBCDBDCB51A5EB5E1A763E38D42C7855", hash_generated_method = "43BF6D20E8D0C31A3AD3617BDE49890A")
    @Override
    public void handleMessage(Message msg) {
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
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.653 -0400", hash_original_method = "B26CBB1291A6152D9C092C7AC934B437", hash_generated_method = "43525AB9820103BD8833B755D5CF5385")
    private void log(String msg) {
        Log.d(LOG_TAG, msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //if(DBG) Log.d(LOG_TAG, msg);
    }

    
    private class PbrFile {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.653 -0400", hash_original_field = "B8225B3EF7629400F3BF178F99D2511D", hash_generated_field = "DD2BC0CCB77C9B04C419C3A18FB77046")

        HashMap<Integer,Map<Integer,Integer>> mFileIds;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.660 -0400", hash_original_method = "D67956DDFF065803AA18EDD362DE0213", hash_generated_method = "A28F19DA07D5C1B0015B681EC02A2974")
          PbrFile(ArrayList<byte[]> records) {
            mFileIds = new HashMap<Integer, Map<Integer, Integer>>();
            SimTlv recTlv;
            int recNum;
            recNum = 0;
            {
                Iterator<byte[]> varC5932E3C459EC5D6F84D20C1CA8BC089_689005615 = (records).iterator();
                varC5932E3C459EC5D6F84D20C1CA8BC089_689005615.hasNext();
                byte[] record = varC5932E3C459EC5D6F84D20C1CA8BC089_689005615.next();
                {
                    recTlv = new SimTlv(record, 0, record.length);
                    parseTag(recTlv, recNum);
                } //End block
            } //End collapsed parenthetic
            addTaint(records.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.665 -0400", hash_original_method = "D93ED3119C94191277253FF2EE0C71AD", hash_generated_method = "7660918FF79187672CF4BF86C94CBB8F")
         void parseTag(SimTlv tlv, int recNum) {
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
                boolean var2BD20FFFB0EEC59B00776BE63CF9A28E_480890545 = (tlv.nextObject());
            } //End collapsed parenthetic
            mFileIds.put(recNum, val);
            addTaint(tlv.getTaint());
            addTaint(recNum);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.667 -0400", hash_original_method = "27E6C520D8DED1C5B5FE1A348EAE7100", hash_generated_method = "480A212D703BFDFD6D109DC59DC6BF08")
         void parseEf(SimTlv tlv, Map<Integer, Integer> val, int parentTag) {
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
                boolean var2BD20FFFB0EEC59B00776BE63CF9A28E_1446506880 = (tlv.nextObject());
            } //End collapsed parenthetic
            addTaint(tlv.getTaint());
            addTaint(val.getTaint());
            addTaint(parentTag);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.667 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "5530865D20356CB868DD2FE7091750DF")

    private static String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.667 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "EA7FF8772A7B2A0121F9F6C2158F8474")

    private static boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.667 -0400", hash_original_field = "CD352F3B9D0116533D402573E8A4DCF2", hash_generated_field = "3977ED57F07AB4C3F888A11522AB208E")

    private static int EVENT_PBR_LOAD_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.667 -0400", hash_original_field = "1CFDD3F5FDEF4A6626FBAB9748306ED1", hash_generated_field = "68A6E01A11D231151BB82AE4C38A4469")

    private static int EVENT_USIM_ADN_LOAD_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.667 -0400", hash_original_field = "791BE5F906F5488493170F0A72D746E3", hash_generated_field = "26999718C2AE7D4274912441857120AF")

    private static int EVENT_IAP_LOAD_DONE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.667 -0400", hash_original_field = "3DD28124E3B78AF6F22B9BD4596CD9C9", hash_generated_field = "8D148D1816B6ABF54F79187A7DE26076")

    private static int EVENT_EMAIL_LOAD_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.667 -0400", hash_original_field = "A5BADDDBA23AD45683468FBC8BB12B56", hash_generated_field = "28058B26A88AE2061BF4E4D03F307E90")

    private static int USIM_TYPE1_TAG = 0xA8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.667 -0400", hash_original_field = "6079D3004778761C3EC181BBA589F910", hash_generated_field = "94ECFABB3BA6043CE1945E2DCFFC76C3")

    private static int USIM_TYPE2_TAG = 0xA9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.667 -0400", hash_original_field = "52390331DE7E8F6C5A35626A32180AFE", hash_generated_field = "B67042F55BD920430889752824ED89ED")

    private static int USIM_TYPE3_TAG = 0xAA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.667 -0400", hash_original_field = "37C81B662AAC2B38F18BF44CA6A4A37F", hash_generated_field = "9487B80191343602BA262493119DF2A4")

    private static int USIM_EFADN_TAG = 0xC0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.667 -0400", hash_original_field = "F93D18E8D71CC1A36BCAD173070006BC", hash_generated_field = "C887EFC19D581DA61F9035475EDB0832")

    private static int USIM_EFIAP_TAG = 0xC1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.667 -0400", hash_original_field = "B275F5625E9AF8B2EEB79E41A9EAA1F5", hash_generated_field = "4D8A1949EB1597A75A325A2601A630CF")

    private static int USIM_EFEXT1_TAG = 0xC2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.667 -0400", hash_original_field = "44D52017DE50936354BB014167EF1023", hash_generated_field = "23ADF17BE9227F658C43B762C9E24793")

    private static int USIM_EFSNE_TAG = 0xC3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.667 -0400", hash_original_field = "71124F1C90CE93784C43B92498D1970D", hash_generated_field = "D833084BE75CAFF1ECD4F5D7C1C4D183")

    private static int USIM_EFANR_TAG = 0xC4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.667 -0400", hash_original_field = "A5A229CA49D64B5979288BB378A0D978", hash_generated_field = "48111B5204D09E47B965B2CF9E9D4619")

    private static int USIM_EFPBC_TAG = 0xC5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.667 -0400", hash_original_field = "A88828E5AAC306BAB8183A35DB1B61AB", hash_generated_field = "4044B2343F0D5FA92386D2D2EFE449BB")

    private static int USIM_EFGRP_TAG = 0xC6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.668 -0400", hash_original_field = "80D9D7423DC4AA8F62C982BEE2EB15B6", hash_generated_field = "D5D180CBB481E824DE8743E048017AE4")

    private static int USIM_EFAAS_TAG = 0xC7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.668 -0400", hash_original_field = "A9C7FE93F73FDF4232B5A94B83B75465", hash_generated_field = "F6255860311D6C7E52F3E308385CDCD0")

    private static int USIM_EFGSD_TAG = 0xC8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.668 -0400", hash_original_field = "5C58BA68643A1946514F6BAE0EE3E0A3", hash_generated_field = "162E1676AA9CD2C38AED88F5559CC1AE")

    private static int USIM_EFUID_TAG = 0xC9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.668 -0400", hash_original_field = "ECF3E30EA67882C0BF2F95801F306829", hash_generated_field = "D2B0FF589F3F9CB1209836806E599434")

    private static int USIM_EFEMAIL_TAG = 0xCA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:23.668 -0400", hash_original_field = "627C8FC5D0B2BB7A75B0DFCCBA487BDC", hash_generated_field = "90C7C0E430B3FCCE421D5828D3825A3B")

    private static int USIM_EFCCP1_TAG = 0xCB;
}


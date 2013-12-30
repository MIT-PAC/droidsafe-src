package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.android.internal.telephony.AdnRecord;
import com.android.internal.telephony.AdnRecordCache;
import com.android.internal.telephony.IccConstants;
import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.PhoneBase;






public class UsimPhoneBookManager extends Handler implements IccConstants {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.961 -0500", hash_original_field = "28DECCA9F494133CD6F61BCA99A50ECA", hash_generated_field = "D922E4732DF1A8050A7A55C2D62EC423")

    private static final String LOG_TAG = "GSM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.964 -0500", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.995 -0500", hash_original_field = "67D3C61E42C2CC1F4738B79A29401BB4", hash_generated_field = "1C7072F210A9F01872115E74B443A7C2")


    private static final int EVENT_PBR_LOAD_DONE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.997 -0500", hash_original_field = "D8C2E83D1734B5BAD21CF993799AB823", hash_generated_field = "8B8127A364BC154368D2CA94E199826A")

    private static final int EVENT_USIM_ADN_LOAD_DONE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.001 -0500", hash_original_field = "AA24FD01F82F93F4B8869A4FD50CFC4A", hash_generated_field = "FF1B3159F722D0E2252C1CE019A8E559")

    private static final int EVENT_IAP_LOAD_DONE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.004 -0500", hash_original_field = "C4BAA968755EFBCE51F48F60BDE2CE36", hash_generated_field = "84966C7C18B9D868C7030F1A0F87EB9C")

    private static final int EVENT_EMAIL_LOAD_DONE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.006 -0500", hash_original_field = "3509C5A9471EBD0F2620C8E68315F470", hash_generated_field = "AB49351C0C67D5101FE6BCA8B9ED3322")


    private static final int USIM_TYPE1_TAG   = 0xA8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.008 -0500", hash_original_field = "C5131E2F23DE86525681896EFB7A89C1", hash_generated_field = "FFA29DCAF13AB805CCCC449C8F474D63")

    private static final int USIM_TYPE2_TAG   = 0xA9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.011 -0500", hash_original_field = "AFA90BB741EDCE3498BC9B67E0FF7096", hash_generated_field = "526A6B91825B243AC22F035F0742D7C0")

    private static final int USIM_TYPE3_TAG   = 0xAA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.013 -0500", hash_original_field = "D6D1BEC027EB803E1F8C7D30D953732C", hash_generated_field = "EBE8D23A68F4248C778E6521D3841324")

    private static final int USIM_EFADN_TAG   = 0xC0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.017 -0500", hash_original_field = "53D28CA9C7EB4A81E055B1AD97D36C73", hash_generated_field = "F0933E4B079887BF30150AA4A729FBE8")

    private static final int USIM_EFIAP_TAG   = 0xC1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.019 -0500", hash_original_field = "D90585D75F15A06B7DF21896941D94BC", hash_generated_field = "1C4CC1E181A2BE8CE9A6765D1A59E830")

    private static final int USIM_EFEXT1_TAG  = 0xC2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.022 -0500", hash_original_field = "4322DB58F70E22FCB33D810DA1A43B7E", hash_generated_field = "94F97153FD11E48B73BB877CB4372BC4")

    private static final int USIM_EFSNE_TAG   = 0xC3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.024 -0500", hash_original_field = "0E68535E088D896AD46DE53F884C56C2", hash_generated_field = "D82C230BC5822E29EF5458D69FE172CF")

    private static final int USIM_EFANR_TAG   = 0xC4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.027 -0500", hash_original_field = "6FD7A7025ADF2C94491B770C77E450BD", hash_generated_field = "7742BCE8249F92717AD8569D0CA09B3F")

    private static final int USIM_EFPBC_TAG   = 0xC5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.030 -0500", hash_original_field = "B2E316671D8CF257ADB57DC2518329B1", hash_generated_field = "4B9F0B93A9E74AECF883919694C255EB")

    private static final int USIM_EFGRP_TAG   = 0xC6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.032 -0500", hash_original_field = "E5AC2F9D19B1BB33A4626DE6223DAA5C", hash_generated_field = "9043CACA7B56CF871B398E2E3104B81F")

    private static final int USIM_EFAAS_TAG   = 0xC7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.035 -0500", hash_original_field = "81B87E563017452B4B009D8834845658", hash_generated_field = "10882180C7FBB6B7841898AC8588E860")

    private static final int USIM_EFGSD_TAG   = 0xC8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.037 -0500", hash_original_field = "AA6F4DC252B6751ED299F334065ACD01", hash_generated_field = "65087FA88C25538A2C4F170D25BBE1DB")

    private static final int USIM_EFUID_TAG   = 0xC9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.040 -0500", hash_original_field = "AEB366BCF527CCBECA748D3A7CE50194", hash_generated_field = "F26C983BC0EB690DFFD958504CC21D62")

    private static final int USIM_EFEMAIL_TAG = 0xCA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.042 -0500", hash_original_field = "F16814DCAAE9E6EC75FDEFA67F86153F", hash_generated_field = "A9142AB7D4AAFA3289BD2734D8B176B9")

    private static final int USIM_EFCCP1_TAG  = 0xCB;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.966 -0500", hash_original_field = "79989D361C46DF497F8F059E8AE88B45", hash_generated_field = "208E31DBC6A3857B5997E7C1BCB1166B")

    private PbrFile mPbrFile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.968 -0500", hash_original_field = "419A96A1774B016B2E218845CBF80AD6", hash_generated_field = "73182A5184196FAAD039E44D2C16F121")

    private Boolean mIsPbrPresent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.971 -0500", hash_original_field = "B504049739EC0253F0006BF183324917", hash_generated_field = "E7BDAD23CF4F53103B9ED94B380FFE2A")

    private PhoneBase mPhone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.974 -0500", hash_original_field = "47899E8A037B68E82F4ED10183FF986C", hash_generated_field = "640171AAF9460B26A1955741F0E8BDD1")

    private AdnRecordCache mAdnCache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.976 -0500", hash_original_field = "83DB9DCBBD2D99A708D9A1934D5CD5AB", hash_generated_field = "C8F8FCD335E09ED70E70801AB39A894A")

    private Object mLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.978 -0500", hash_original_field = "DA7E3E27D27D5822213A8739441AE260", hash_generated_field = "F015F032A7EB90DEA83FE0426648EF9F")

    private ArrayList<AdnRecord> mPhoneBookRecords;

    
    private class PbrFile {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.090 -0500", hash_original_field = "DD2BC0CCB77C9B04C419C3A18FB77046", hash_generated_field = "DD2BC0CCB77C9B04C419C3A18FB77046")

        HashMap<Integer,Map<Integer,Integer>> mFileIds;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.092 -0500", hash_original_method = "D67956DDFF065803AA18EDD362DE0213", hash_generated_method = "D67956DDFF065803AA18EDD362DE0213")
        
PbrFile(ArrayList<byte[]> records) {
            mFileIds = new HashMap<Integer, Map<Integer, Integer>>();
            SimTlv recTlv;
            int recNum = 0;
            for (byte[] record: records) {
                recTlv = new SimTlv(record, 0, record.length);
                parseTag(recTlv, recNum);
                recNum ++;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.095 -0500", hash_original_method = "D93ED3119C94191277253FF2EE0C71AD", hash_generated_method = "40B384586491343441CBA49466163935")
        
void parseTag(SimTlv tlv, int recNum) {
            SimTlv tlvEf;
            int tag;
            byte[] data;
            Map<Integer, Integer> val = new HashMap<Integer, Integer>();
            do {
                tag = tlv.getTag();
                switch(tag) {
                case USIM_TYPE1_TAG: // A8
                case USIM_TYPE3_TAG: // AA
                case USIM_TYPE2_TAG: // A9
                    data = tlv.getData();
                    tlvEf = new SimTlv(data, 0, data.length);
                    parseEf(tlvEf, val, tag);
                    break;
                }
            } while (tlv.nextObject());
            mFileIds.put(recNum, val);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.098 -0500", hash_original_method = "27E6C520D8DED1C5B5FE1A348EAE7100", hash_generated_method = "27E6C520D8DED1C5B5FE1A348EAE7100")
        
void parseEf(SimTlv tlv, Map<Integer, Integer> val, int parentTag) {
            int tag;
            byte[] data;
            int tagNumberWithinParentTag = 0;
            do {
                tag = tlv.getTag();
                if (parentTag == USIM_TYPE2_TAG && tag == USIM_EFEMAIL_TAG) {
                    mEmailPresentInIap = true;
                    mEmailTagNumberInIap = tagNumberWithinParentTag;
                }
                switch(tag) {
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
                }
                tagNumberWithinParentTag ++;
            } while(tlv.nextObject());
        }

        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.981 -0500", hash_original_field = "24FF176E5D2A32D148A86CDFC84A9C5F", hash_generated_field = "8920C02D769F140478E3FF9AAD342322")

    private boolean mEmailPresentInIap = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.983 -0500", hash_original_field = "4F47F06D7F5E8AC439DAE68C817DFFE1", hash_generated_field = "85C5852B556432EAA1F206B261622D09")

    private int mEmailTagNumberInIap = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.985 -0500", hash_original_field = "36D97AA57C0ECC30ED5F44384817CFEA", hash_generated_field = "F0E5C0A038832AB5FF92C39635F7D36F")

    private ArrayList<byte[]> mIapFileRecord;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.987 -0500", hash_original_field = "C4E4C4CFB632C2939931DA6F59CD9176", hash_generated_field = "89657832ADF45F3FD36226A626E3E654")

    private ArrayList<byte[]> mEmailFileRecord;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.990 -0500", hash_original_field = "81AE9A7D3174F7A2932F983DFB11A23C", hash_generated_field = "9EF1137FB9FBD5B78A3EDED47EC19EF2")

    private Map<Integer, ArrayList<String>> mEmailsForAdnRec;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.992 -0500", hash_original_field = "888ED39E2F62F3536157946AFD87418F", hash_generated_field = "04358A29D9E3ACD0C9C2B1379BC842DB")

    private boolean mRefreshCache = false;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.045 -0500", hash_original_method = "49FEAD20C5C47E2BA26F4ED2BE1800D2", hash_generated_method = "3157A13339E0AC834A88258566AA87B7")
    
public UsimPhoneBookManager(PhoneBase phone, AdnRecordCache cache) {
        mPhone = phone;
        mPhoneBookRecords = new ArrayList<AdnRecord>();
        mPbrFile = null;
        // We assume its present, after the first read this is updated.
        // So we don't have to read from UICC if its not present on subsequent reads.
        mIsPbrPresent = true;
        mAdnCache = cache;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.048 -0500", hash_original_method = "E0D906663A0994551C89240DFDC0BDC8", hash_generated_method = "31F64A58C844911A781270B1E95C82F4")
    
public void reset() {
        mPhoneBookRecords.clear();
        mIapFileRecord = null;
        mEmailFileRecord = null;
        mPbrFile = null;
        mIsPbrPresent = true;
        mRefreshCache = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.050 -0500", hash_original_method = "B81A15F32DE42ED7FA5FD76607998109", hash_generated_method = "72E3A9E53221461FE1E851CA9BE744D1")
    
public ArrayList<AdnRecord> loadEfFilesFromUsim() {
        synchronized (mLock) {
            if (!mPhoneBookRecords.isEmpty()) {
                if (mRefreshCache) {
                    mRefreshCache = false;
                    refreshCache();
                }
                return mPhoneBookRecords;
            }

            if (!mIsPbrPresent) return null;

            // Check if the PBR file is present in the cache, if not read it
            // from the USIM.
            if (mPbrFile == null) {
                readPbrFileAndWait();
            }

            if (mPbrFile == null) return null;

            int numRecs = mPbrFile.mFileIds.size();
            for (int i = 0; i < numRecs; i++) {
                readAdnFileAndWait(i);
                readEmailFileAndWait(i);
            }
            // All EF files are loaded, post the response.
        }
        return mPhoneBookRecords;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.052 -0500", hash_original_method = "B532D4E2E21067521A95047E8C8D19E8", hash_generated_method = "556C751DABBC44784EFD65205A48F2B8")
    
private void refreshCache() {
        if (mPbrFile == null) return;
        mPhoneBookRecords.clear();

        int numRecs = mPbrFile.mFileIds.size();
        for (int i = 0; i < numRecs; i++) {
            readAdnFileAndWait(i);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.061 -0500", hash_original_method = "4227D3403F7221594B4C4984D58136B1", hash_generated_method = "E92C87BF43A241654EBD0F8897BB80F1")
    
public void invalidateCache() {
        mRefreshCache = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.063 -0500", hash_original_method = "78E381AC3959E12E81678D4DFFBA5C8B", hash_generated_method = "76D322E24F54A199CCFA37DD8BB7FFE9")
    
private void readPbrFileAndWait() {
        mPhone.getIccFileHandler().loadEFLinearFixedAll(EF_PBR, obtainMessage(EVENT_PBR_LOAD_DONE));
        try {
            mLock.wait();
        } catch (InterruptedException e) {
            Log.e(LOG_TAG, "Interrupted Exception in readAdnFileAndWait");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.066 -0500", hash_original_method = "48BBB6A0A30AD38B5848D3F55664B632", hash_generated_method = "D18508225BEB12B4A3EB1916E778819D")
    
private void readEmailFileAndWait(int recNum) {
        Map <Integer,Integer> fileIds;
        fileIds = mPbrFile.mFileIds.get(recNum);
        if (fileIds == null) return;

        if (fileIds.containsKey(USIM_EFEMAIL_TAG)) {
            int efid = fileIds.get(USIM_EFEMAIL_TAG);
            // Check if the EFEmail is a Type 1 file or a type 2 file.
            // If mEmailPresentInIap is true, its a type 2 file.
            // So we read the IAP file and then read the email records.
            // instead of reading directly.
            if (mEmailPresentInIap) {
                readIapFileAndWait(fileIds.get(USIM_EFIAP_TAG));
                if (mIapFileRecord == null) {
                    Log.e(LOG_TAG, "Error: IAP file is empty");
                    return;
                }
            }
            // Read the EFEmail file.
            mPhone.getIccFileHandler().loadEFLinearFixedAll(fileIds.get(USIM_EFEMAIL_TAG),
                    obtainMessage(EVENT_EMAIL_LOAD_DONE));
            try {
                mLock.wait();
            } catch (InterruptedException e) {
                Log.e(LOG_TAG, "Interrupted Exception in readEmailFileAndWait");
            }

            if (mEmailFileRecord == null) {
                Log.e(LOG_TAG, "Error: Email file is empty");
                return;
            }
            updatePhoneAdnRecord();
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.069 -0500", hash_original_method = "9E809A1ED86DEC7D2454BACD182423F6", hash_generated_method = "DABED92A54C4D4BB9F6267150658C8C2")
    
private void readIapFileAndWait(int efid) {
        mPhone.getIccFileHandler().loadEFLinearFixedAll(efid, obtainMessage(EVENT_IAP_LOAD_DONE));
        try {
            mLock.wait();
        } catch (InterruptedException e) {
            Log.e(LOG_TAG, "Interrupted Exception in readIapFileAndWait");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.072 -0500", hash_original_method = "DBF9EE6E650F45B09979783B6AE92B3D", hash_generated_method = "BBFEF3BA32D85A95CBC5F9042AAF4634")
    
private void updatePhoneAdnRecord() {
        if (mEmailFileRecord == null) return;
        int numAdnRecs = mPhoneBookRecords.size();
        if (mIapFileRecord != null) {
            // The number of records in the IAP file is same as the number of records in ADN file.
            // The order of the pointers in an EFIAP shall be the same as the order of file IDs
            // that appear in the TLV object indicated by Tag 'A9' in the reference file record.
            // i.e value of mEmailTagNumberInIap

            for (int i = 0; i < numAdnRecs; i++) {
                byte[] record = null;
                try {
                    record = mIapFileRecord.get(i);
                } catch (IndexOutOfBoundsException e) {
                    Log.e(LOG_TAG, "Error: Improper ICC card: No IAP record for ADN, continuing");
                    break;
                }
                int recNum = record[mEmailTagNumberInIap];

                if (recNum != -1) {
                    String[] emails = new String[1];
                    // SIM record numbers are 1 based
                    emails[0] = readEmailRecord(recNum - 1);
                    AdnRecord rec = mPhoneBookRecords.get(i);
                    if (rec != null) {
                        rec.setEmails(emails);
                    } else {
                        // might be a record with only email
                        rec = new AdnRecord("", "", emails);
                    }
                    mPhoneBookRecords.set(i, rec);
                }
            }
        }

        // ICC cards can be made such that they have an IAP file but all
        // records are empty. So we read both type 1 and type 2 file
        // email records, just to be sure.

        int len = mPhoneBookRecords.size();
        // Type 1 file, the number of records is the same as the number of
        // records in the ADN file.
        if (mEmailsForAdnRec == null) {
            parseType1EmailFile(len);
        }
        for (int i = 0; i < numAdnRecs; i++) {
            ArrayList<String> emailList = null;
            try {
                emailList = mEmailsForAdnRec.get(i);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
            if (emailList == null) continue;

            AdnRecord rec = mPhoneBookRecords.get(i);

            String[] emails = new String[emailList.size()];
            System.arraycopy(emailList.toArray(), 0, emails, 0, emailList.size());
            rec.setEmails(emails);
            mPhoneBookRecords.set(i, rec);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.075 -0500", hash_original_method = "8AA09CE6055FA7D5E93DEAB0645B4CBD", hash_generated_method = "69BF3DB68C851A416798FF3B8776EEE8")
    
void parseType1EmailFile(int numRecs) {
        mEmailsForAdnRec = new HashMap<Integer, ArrayList<String>>();
        byte[] emailRec = null;
        for (int i = 0; i < numRecs; i++) {
            try {
                emailRec = mEmailFileRecord.get(i);
            } catch (IndexOutOfBoundsException e) {
                Log.e(LOG_TAG, "Error: Improper ICC card: No email record for ADN, continuing");
                break;
            }
            int adnRecNum = emailRec[emailRec.length - 1];

            if (adnRecNum == -1) {
                continue;
            }

            String email = readEmailRecord(i);

            if (email == null || email.equals("")) {
                continue;
            }

            // SIM record numbers are 1 based.
            ArrayList<String> val = mEmailsForAdnRec.get(adnRecNum - 1);
            if (val == null) {
                val = new ArrayList<String>();
            }
            val.add(email);
            // SIM record numbers are 1 based.
            mEmailsForAdnRec.put(adnRecNum - 1, val);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.078 -0500", hash_original_method = "9DD87F6722942AC55924DBE05DD72D60", hash_generated_method = "E2C2B402986EE8D77DB5075BBF0908D0")
    
private String readEmailRecord(int recNum) {
        byte[] emailRec = null;
        try {
            emailRec = mEmailFileRecord.get(recNum);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }

        // The length of the record is X+2 byte, where X bytes is the email address
        String email = IccUtils.adnStringFieldToString(emailRec, 0, emailRec.length - 2);
        return email;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.080 -0500", hash_original_method = "4035A9584818EC181E07E84AC976F741", hash_generated_method = "9234A510276F1310065E47AFB526C552")
    
private void readAdnFileAndWait(int recNum) {
        Map <Integer,Integer> fileIds;
        fileIds = mPbrFile.mFileIds.get(recNum);
        if (fileIds == null || fileIds.isEmpty()) return;


        int extEf = 0;
        // Only call fileIds.get while EFEXT1_TAG is available
        if (fileIds.containsKey(USIM_EFEXT1_TAG)) {
            extEf = fileIds.get(USIM_EFEXT1_TAG);
        }

        mAdnCache.requestLoadAllAdnLike(fileIds.get(USIM_EFADN_TAG),
            extEf, obtainMessage(EVENT_USIM_ADN_LOAD_DONE));
        try {
            mLock.wait();
        } catch (InterruptedException e) {
            Log.e(LOG_TAG, "Interrupted Exception in readAdnFileAndWait");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.083 -0500", hash_original_method = "EC7FC3EA469B316149A3EE38C863088E", hash_generated_method = "7374B6345F1361797E3F8C145159730B")
    
private void createPbrFile(ArrayList<byte[]> records) {
        if (records == null) {
            mPbrFile = null;
            mIsPbrPresent = false;
            return;
        }
        mPbrFile = new PbrFile(records);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.087 -0500", hash_original_method = "DBCDBDCB51A5EB5E1A763E38D42C7855", hash_generated_method = "867F5F3747F8A06A94F7CA8A00E1E196")
    
@Override
    public void handleMessage(Message msg) {
        AsyncResult ar;

        switch(msg.what) {
        case EVENT_PBR_LOAD_DONE:
            ar = (AsyncResult) msg.obj;
            if (ar.exception == null) {
                createPbrFile((ArrayList<byte[]>)ar.result);
            }
            synchronized (mLock) {
                mLock.notify();
            }
            break;
        case EVENT_USIM_ADN_LOAD_DONE:
            log("Loading USIM ADN records done");
            ar = (AsyncResult) msg.obj;
            if (ar.exception == null) {
                mPhoneBookRecords.addAll((ArrayList<AdnRecord>)ar.result);
            }
            synchronized (mLock) {
                mLock.notify();
            }
            break;
        case EVENT_IAP_LOAD_DONE:
            log("Loading USIM IAP records done");
            ar = (AsyncResult) msg.obj;
            if (ar.exception == null) {
                mIapFileRecord = ((ArrayList<byte[]>)ar.result);
            }
            synchronized (mLock) {
                mLock.notify();
            }
            break;
        case EVENT_EMAIL_LOAD_DONE:
            log("Loading USIM Email records done");
            ar = (AsyncResult) msg.obj;
            if (ar.exception == null) {
                mEmailFileRecord = ((ArrayList<byte[]>)ar.result);
            }

            synchronized (mLock) {
                mLock.notify();
            }
            break;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:32.102 -0500", hash_original_method = "B26CBB1291A6152D9C092C7AC934B437", hash_generated_method = "8C3AE1BEB7398E3267102189A3848636")
    
private void log(String msg) {
        if(DBG) Log.d(LOG_TAG, msg);
    }
}


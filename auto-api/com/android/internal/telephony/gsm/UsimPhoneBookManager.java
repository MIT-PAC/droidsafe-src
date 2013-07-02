package com.android.internal.telephony.gsm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.932 -0400", hash_original_field = "7D373B4F0DFF7E92AC122910BF9B25C5", hash_generated_field = "208E31DBC6A3857B5997E7C1BCB1166B")

    private PbrFile mPbrFile;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.932 -0400", hash_original_field = "30E1F8B5FEAFF3D5D3F3D60A2669D6EC", hash_generated_field = "73182A5184196FAAD039E44D2C16F121")

    private Boolean mIsPbrPresent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.932 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "E7BDAD23CF4F53103B9ED94B380FFE2A")

    private PhoneBase mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.932 -0400", hash_original_field = "BA1723592FC6435C40C8AD8626B01970", hash_generated_field = "640171AAF9460B26A1955741F0E8BDD1")

    private AdnRecordCache mAdnCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.932 -0400", hash_original_field = "B89DEBA2CB26B1AC973763E3E152017B", hash_generated_field = "C8F8FCD335E09ED70E70801AB39A894A")

    private Object mLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.932 -0400", hash_original_field = "53A38FDCFCCC8ECCB18A04C23D93072B", hash_generated_field = "F015F032A7EB90DEA83FE0426648EF9F")

    private ArrayList<AdnRecord> mPhoneBookRecords;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.932 -0400", hash_original_field = "63024429CACFB70F75A3BECB3F2E6C36", hash_generated_field = "8920C02D769F140478E3FF9AAD342322")

    private boolean mEmailPresentInIap = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.932 -0400", hash_original_field = "7B86766C70934F19080F42E3D35B4DFF", hash_generated_field = "85C5852B556432EAA1F206B261622D09")

    private int mEmailTagNumberInIap = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.932 -0400", hash_original_field = "4D4CA197DA1CB6A858C87C60961C500B", hash_generated_field = "F0E5C0A038832AB5FF92C39635F7D36F")

    private ArrayList<byte[]> mIapFileRecord;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.932 -0400", hash_original_field = "419263776F38DA2F0745455CE61D0A73", hash_generated_field = "89657832ADF45F3FD36226A626E3E654")

    private ArrayList<byte[]> mEmailFileRecord;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.932 -0400", hash_original_field = "5D6A4FFEA4D7A28766408604E7A641BD", hash_generated_field = "9EF1137FB9FBD5B78A3EDED47EC19EF2")

    private Map<Integer, ArrayList<String>> mEmailsForAdnRec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.932 -0400", hash_original_field = "C9062F039BF2FB54B18203718C657CDA", hash_generated_field = "04358A29D9E3ACD0C9C2B1379BC842DB")

    private boolean mRefreshCache = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.932 -0400", hash_original_method = "49FEAD20C5C47E2BA26F4ED2BE1800D2", hash_generated_method = "C6C0A75B50E09ACCB60EA00A5CED0347")
    public  UsimPhoneBookManager(PhoneBase phone, AdnRecordCache cache) {
        mPhone = phone;
        mPhoneBookRecords = new ArrayList<AdnRecord>();
        mPbrFile = null;
        mIsPbrPresent = true;
        mAdnCache = cache;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.933 -0400", hash_original_method = "E0D906663A0994551C89240DFDC0BDC8", hash_generated_method = "ABA5A37BF0D9B72AE08F6D010D45EC01")
    public void reset() {
        mPhoneBookRecords.clear();
        mIapFileRecord = null;
        mEmailFileRecord = null;
        mPbrFile = null;
        mIsPbrPresent = true;
        mRefreshCache = false;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.933 -0400", hash_original_method = "B81A15F32DE42ED7FA5FD76607998109", hash_generated_method = "14ACF87A7CC030DF0CB6E89CC0A13D45")
    public ArrayList<AdnRecord> loadEfFilesFromUsim() {
        ArrayList<AdnRecord> varB4EAC82CA7396A68D541C85D26508E83_395596292 = null; 
        ArrayList<AdnRecord> varB4EAC82CA7396A68D541C85D26508E83_591592248 = null; 
        ArrayList<AdnRecord> varB4EAC82CA7396A68D541C85D26508E83_534237708 = null; 
        ArrayList<AdnRecord> varB4EAC82CA7396A68D541C85D26508E83_1732707261 = null; 
        {
            {
                boolean var9D433910E1D3843659FCB90F123565EA_590784426 = (!mPhoneBookRecords.isEmpty());
                {
                    {
                        mRefreshCache = false;
                        refreshCache();
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_395596292 = mPhoneBookRecords;
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_591592248 = null;
            {
                readPbrFileAndWait();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_534237708 = null;
            int numRecs = mPbrFile.mFileIds.size();
            {
                int i = 0;
                {
                    readAdnFileAndWait(i);
                    readEmailFileAndWait(i);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1732707261 = mPhoneBookRecords;
        ArrayList<AdnRecord> varA7E53CE21691AB073D9660D615818899_572093848; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_572093848 = varB4EAC82CA7396A68D541C85D26508E83_395596292;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_572093848 = varB4EAC82CA7396A68D541C85D26508E83_591592248;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_572093848 = varB4EAC82CA7396A68D541C85D26508E83_534237708;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_572093848 = varB4EAC82CA7396A68D541C85D26508E83_1732707261;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_572093848.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_572093848;
        
        
            
                
                    
                    
                
                
            
            
            
                
            
            
            
            
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.934 -0400", hash_original_method = "B532D4E2E21067521A95047E8C8D19E8", hash_generated_method = "6BFDD9BF75AE305E7DF75C55EC437DEF")
    private void refreshCache() {
        mPhoneBookRecords.clear();
        int numRecs = mPbrFile.mFileIds.size();
        {
            int i = 0;
            {
                readAdnFileAndWait(i);
            } 
        } 
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.934 -0400", hash_original_method = "4227D3403F7221594B4C4984D58136B1", hash_generated_method = "94D421C1BCB4B33EF173797F9066F6AC")
    public void invalidateCache() {
        mRefreshCache = true;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.934 -0400", hash_original_method = "78E381AC3959E12E81678D4DFFBA5C8B", hash_generated_method = "3F8F554B0DFE76C73E3BA3F105EA8D1B")
    private void readPbrFileAndWait() {
        mPhone.getIccFileHandler().loadEFLinearFixedAll(EF_PBR, obtainMessage(EVENT_PBR_LOAD_DONE));
        try 
        {
            mLock.wait();
        } 
        catch (InterruptedException e)
        { }
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.935 -0400", hash_original_method = "48BBB6A0A30AD38B5848D3F55664B632", hash_generated_method = "15ED6BFC660DD6E201314A0B83ECD441")
    private void readEmailFileAndWait(int recNum) {
        Map <Integer,Integer> fileIds;
        fileIds = mPbrFile.mFileIds.get(recNum);
        {
            boolean var2294A8F7D58B58C18C6F6AAEB87D3621_617872670 = (fileIds.containsKey(USIM_EFEMAIL_TAG));
            {
                int efid = fileIds.get(USIM_EFEMAIL_TAG);
                {
                    readIapFileAndWait(fileIds.get(USIM_EFIAP_TAG));
                } 
                mPhone.getIccFileHandler().loadEFLinearFixedAll(fileIds.get(USIM_EFEMAIL_TAG),
                    obtainMessage(EVENT_EMAIL_LOAD_DONE));
                try 
                {
                    mLock.wait();
                } 
                catch (InterruptedException e)
                { }
                updatePhoneAdnRecord();
            } 
        } 
        addTaint(recNum);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.936 -0400", hash_original_method = "9E809A1ED86DEC7D2454BACD182423F6", hash_generated_method = "8FC4D7ACC9751F1DB92E2C440B276842")
    private void readIapFileAndWait(int efid) {
        mPhone.getIccFileHandler().loadEFLinearFixedAll(efid, obtainMessage(EVENT_IAP_LOAD_DONE));
        try 
        {
            mLock.wait();
        } 
        catch (InterruptedException e)
        { }
        addTaint(efid);
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.937 -0400", hash_original_method = "DBF9EE6E650F45B09979783B6AE92B3D", hash_generated_method = "DBC93D38A546306B826496F159CD1E37")
    private void updatePhoneAdnRecord() {
        int numAdnRecs = mPhoneBookRecords.size();
        {
            {
                int i = 0;
                {
                    byte[] record = null;
                    try 
                    {
                        record = mIapFileRecord.get(i);
                    } 
                    catch (IndexOutOfBoundsException e)
                    { }
                    int recNum = record[mEmailTagNumberInIap];
                    {
                        String[] emails = new String[1];
                        emails[0] = readEmailRecord(recNum - 1);
                        AdnRecord rec = mPhoneBookRecords.get(i);
                        {
                            rec.setEmails(emails);
                        } 
                        {
                            rec = new AdnRecord("", "", emails);
                        } 
                        mPhoneBookRecords.set(i, rec);
                    } 
                } 
            } 
        } 
        int len = mPhoneBookRecords.size();
        {
            parseType1EmailFile(len);
        } 
        {
            int i = 0;
            {
                ArrayList<String> emailList = null;
                try 
                {
                    emailList = mEmailsForAdnRec.get(i);
                } 
                catch (IndexOutOfBoundsException e)
                { }
                AdnRecord rec = mPhoneBookRecords.get(i);
                String[] emails = new String[emailList.size()];
                System.arraycopy(emailList.toArray(), 0, emails, 0, emailList.size());
                rec.setEmails(emails);
                mPhoneBookRecords.set(i, rec);
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.938 -0400", hash_original_method = "8AA09CE6055FA7D5E93DEAB0645B4CBD", hash_generated_method = "37B554A0383ED978DAC7EC4B13CDFA8A")
     void parseType1EmailFile(int numRecs) {
        mEmailsForAdnRec = new HashMap<Integer, ArrayList<String>>();
        byte[] emailRec = null;
        {
            int i = 0;
            {
                try 
                {
                    emailRec = mEmailFileRecord.get(i);
                } 
                catch (IndexOutOfBoundsException e)
                { }
                int adnRecNum = emailRec[emailRec.length - 1];
                String email = readEmailRecord(i);
                {
                    boolean var7580166154D64CB834904276F6B67CAD_4888178 = (email == null || email.equals(""));
                } 
                ArrayList<String> val = mEmailsForAdnRec.get(adnRecNum - 1);
                {
                    val = new ArrayList<String>();
                } 
                val.add(email);
                mEmailsForAdnRec.put(adnRecNum - 1, val);
            } 
        } 
        addTaint(numRecs);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.939 -0400", hash_original_method = "9DD87F6722942AC55924DBE05DD72D60", hash_generated_method = "C63EE887C4C9D06EC3A9CC758C48310B")
    private String readEmailRecord(int recNum) {
        String varB4EAC82CA7396A68D541C85D26508E83_781735340 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1187423964 = null; 
        byte[] emailRec = null;
        try 
        {
            emailRec = mEmailFileRecord.get(recNum);
        } 
        catch (IndexOutOfBoundsException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_781735340 = null;
        } 
        String email = IccUtils.adnStringFieldToString(emailRec, 0, emailRec.length - 2);
        varB4EAC82CA7396A68D541C85D26508E83_1187423964 = email;
        addTaint(recNum);
        String varA7E53CE21691AB073D9660D615818899_1435699755; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1435699755 = varB4EAC82CA7396A68D541C85D26508E83_781735340;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1435699755 = varB4EAC82CA7396A68D541C85D26508E83_1187423964;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1435699755.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1435699755;
        
        
        
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.939 -0400", hash_original_method = "4035A9584818EC181E07E84AC976F741", hash_generated_method = "A2B1DC40ADDEB4BA66AF79BCA96946F8")
    private void readAdnFileAndWait(int recNum) {
        Map <Integer,Integer> fileIds;
        fileIds = mPbrFile.mFileIds.get(recNum);
        {
            boolean varA67B124270236CD7C1FC832187360DEE_2039439155 = (fileIds == null || fileIds.isEmpty());
        } 
        int extEf = 0;
        {
            boolean var826F82931AF9A1D83BE91383C0B6480A_508029999 = (fileIds.containsKey(USIM_EFEXT1_TAG));
            {
                extEf = fileIds.get(USIM_EFEXT1_TAG);
            } 
        } 
        mAdnCache.requestLoadAllAdnLike(fileIds.get(USIM_EFADN_TAG),
            extEf, obtainMessage(EVENT_USIM_ADN_LOAD_DONE));
        try 
        {
            mLock.wait();
        } 
        catch (InterruptedException e)
        { }
        addTaint(recNum);
        
        
        
        
        
        
            
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.939 -0400", hash_original_method = "EC7FC3EA469B316149A3EE38C863088E", hash_generated_method = "E61880AEFD24F4AF7CF359A587F7808A")
    private void createPbrFile(ArrayList<byte[]> records) {
        {
            mPbrFile = null;
            mIsPbrPresent = false;
        } 
        mPbrFile = new PbrFile(records);
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.940 -0400", hash_original_method = "DBCDBDCB51A5EB5E1A763E38D42C7855", hash_generated_method = "43BF6D20E8D0C31A3AD3617BDE49890A")
    @Override
    public void handleMessage(Message msg) {
        AsyncResult ar;
        
        ar = (AsyncResult) msg.obj;
        
        
        {
            createPbrFile((ArrayList<byte[]>)ar.result);
        } 
        
        
        {
            mLock.notify();
        } 
        
        
        log("Loading USIM ADN records done");
        
        
        ar = (AsyncResult) msg.obj;
        
        
        {
            mPhoneBookRecords.addAll((ArrayList<AdnRecord>)ar.result);
        } 
        
        
        {
            mLock.notify();
        } 
        
        
        log("Loading USIM IAP records done");
        
        
        ar = (AsyncResult) msg.obj;
        
        
        {
            mIapFileRecord = ((ArrayList<byte[]>)ar.result);
        } 
        
        
        {
            mLock.notify();
        } 
        
        
        log("Loading USIM Email records done");
        
        
        ar = (AsyncResult) msg.obj;
        
        
        {
            mEmailFileRecord = ((ArrayList<byte[]>)ar.result);
        } 
        
        
        {
            mLock.notify();
        } 
        
        addTaint(msg.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.940 -0400", hash_original_method = "B26CBB1291A6152D9C092C7AC934B437", hash_generated_method = "43525AB9820103BD8833B755D5CF5385")
    private void log(String msg) {
        Log.d(LOG_TAG, msg);
        addTaint(msg.getTaint());
        
        
    }

    
    private class PbrFile {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.941 -0400", hash_original_field = "B8225B3EF7629400F3BF178F99D2511D", hash_generated_field = "DD2BC0CCB77C9B04C419C3A18FB77046")

        HashMap<Integer,Map<Integer,Integer>> mFileIds;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.942 -0400", hash_original_method = "D67956DDFF065803AA18EDD362DE0213", hash_generated_method = "027798BAFAC7F66B82A830820AC23693")
          PbrFile(ArrayList<byte[]> records) {
            mFileIds = new HashMap<Integer, Map<Integer, Integer>>();
            SimTlv recTlv;
            int recNum = 0;
            {
                Iterator<byte[]> varC5932E3C459EC5D6F84D20C1CA8BC089_211410524 = (records).iterator();
                varC5932E3C459EC5D6F84D20C1CA8BC089_211410524.hasNext();
                byte[] record = varC5932E3C459EC5D6F84D20C1CA8BC089_211410524.next();
                {
                    recTlv = new SimTlv(record, 0, record.length);
                    parseTag(recTlv, recNum);
                } 
            } 
            addTaint(records.getTaint());
            
            
            
            
            
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.942 -0400", hash_original_method = "D93ED3119C94191277253FF2EE0C71AD", hash_generated_method = "4FDD4035065DA7BC2205E1DD147676E3")
         void parseTag(SimTlv tlv, int recNum) {
            SimTlv tlvEf;
            int tag;
            byte[] data;
            Map<Integer, Integer> val = new HashMap<Integer, Integer>();
            {
                tag = tlv.getTag();
                
                data = tlv.getData();
                
                
                tlvEf = new SimTlv(data, 0, data.length);
                
                
                parseEf(tlvEf, val, tag);
                
            } 
            {
                boolean var2BD20FFFB0EEC59B00776BE63CF9A28E_144809750 = (tlv.nextObject());
            } 
            mFileIds.put(recNum, val);
            addTaint(tlv.getTaint());
            addTaint(recNum);
            
            
            
            
            
            
                
                
                
                
                
                    
                    
                    
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.943 -0400", hash_original_method = "27E6C520D8DED1C5B5FE1A348EAE7100", hash_generated_method = "29ABEF24B5410DD0417D70AD558BD9C2")
         void parseEf(SimTlv tlv, Map<Integer, Integer> val, int parentTag) {
            int tag;
            byte[] data;
            int tagNumberWithinParentTag = 0;
            {
                tag = tlv.getTag();
                {
                    mEmailPresentInIap = true;
                    mEmailTagNumberInIap = tagNumberWithinParentTag;
                } 
                
                data = tlv.getData();
                
                
                int efid = ((data[0] & 0xFF) << 8) | (data[1] & 0xFF);
                
                
                val.put(tag, efid);
                
            } 
            {
                boolean var2BD20FFFB0EEC59B00776BE63CF9A28E_342271435 = (tlv.nextObject());
            } 
            addTaint(tlv.getTaint());
            addTaint(val.getTaint());
            addTaint(parentTag);
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.943 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "D922E4732DF1A8050A7A55C2D62EC423")

    private static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.943 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.943 -0400", hash_original_field = "CD352F3B9D0116533D402573E8A4DCF2", hash_generated_field = "1C7072F210A9F01872115E74B443A7C2")

    private static final int EVENT_PBR_LOAD_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.943 -0400", hash_original_field = "1CFDD3F5FDEF4A6626FBAB9748306ED1", hash_generated_field = "8B8127A364BC154368D2CA94E199826A")

    private static final int EVENT_USIM_ADN_LOAD_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.943 -0400", hash_original_field = "791BE5F906F5488493170F0A72D746E3", hash_generated_field = "FF1B3159F722D0E2252C1CE019A8E559")

    private static final int EVENT_IAP_LOAD_DONE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.943 -0400", hash_original_field = "3DD28124E3B78AF6F22B9BD4596CD9C9", hash_generated_field = "84966C7C18B9D868C7030F1A0F87EB9C")

    private static final int EVENT_EMAIL_LOAD_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.943 -0400", hash_original_field = "A5BADDDBA23AD45683468FBC8BB12B56", hash_generated_field = "AB49351C0C67D5101FE6BCA8B9ED3322")

    private static final int USIM_TYPE1_TAG = 0xA8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.943 -0400", hash_original_field = "6079D3004778761C3EC181BBA589F910", hash_generated_field = "FFA29DCAF13AB805CCCC449C8F474D63")

    private static final int USIM_TYPE2_TAG = 0xA9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.943 -0400", hash_original_field = "52390331DE7E8F6C5A35626A32180AFE", hash_generated_field = "526A6B91825B243AC22F035F0742D7C0")

    private static final int USIM_TYPE3_TAG = 0xAA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.943 -0400", hash_original_field = "37C81B662AAC2B38F18BF44CA6A4A37F", hash_generated_field = "EBE8D23A68F4248C778E6521D3841324")

    private static final int USIM_EFADN_TAG = 0xC0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.943 -0400", hash_original_field = "F93D18E8D71CC1A36BCAD173070006BC", hash_generated_field = "F0933E4B079887BF30150AA4A729FBE8")

    private static final int USIM_EFIAP_TAG = 0xC1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.943 -0400", hash_original_field = "B275F5625E9AF8B2EEB79E41A9EAA1F5", hash_generated_field = "1C4CC1E181A2BE8CE9A6765D1A59E830")

    private static final int USIM_EFEXT1_TAG = 0xC2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.943 -0400", hash_original_field = "44D52017DE50936354BB014167EF1023", hash_generated_field = "94F97153FD11E48B73BB877CB4372BC4")

    private static final int USIM_EFSNE_TAG = 0xC3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.943 -0400", hash_original_field = "71124F1C90CE93784C43B92498D1970D", hash_generated_field = "D82C230BC5822E29EF5458D69FE172CF")

    private static final int USIM_EFANR_TAG = 0xC4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.943 -0400", hash_original_field = "A5A229CA49D64B5979288BB378A0D978", hash_generated_field = "7742BCE8249F92717AD8569D0CA09B3F")

    private static final int USIM_EFPBC_TAG = 0xC5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.943 -0400", hash_original_field = "A88828E5AAC306BAB8183A35DB1B61AB", hash_generated_field = "4B9F0B93A9E74AECF883919694C255EB")

    private static final int USIM_EFGRP_TAG = 0xC6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.943 -0400", hash_original_field = "80D9D7423DC4AA8F62C982BEE2EB15B6", hash_generated_field = "9043CACA7B56CF871B398E2E3104B81F")

    private static final int USIM_EFAAS_TAG = 0xC7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.943 -0400", hash_original_field = "A9C7FE93F73FDF4232B5A94B83B75465", hash_generated_field = "10882180C7FBB6B7841898AC8588E860")

    private static final int USIM_EFGSD_TAG = 0xC8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.943 -0400", hash_original_field = "5C58BA68643A1946514F6BAE0EE3E0A3", hash_generated_field = "65087FA88C25538A2C4F170D25BBE1DB")

    private static final int USIM_EFUID_TAG = 0xC9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.943 -0400", hash_original_field = "ECF3E30EA67882C0BF2F95801F306829", hash_generated_field = "F26C983BC0EB690DFFD958504CC21D62")

    private static final int USIM_EFEMAIL_TAG = 0xCA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.944 -0400", hash_original_field = "627C8FC5D0B2BB7A75B0DFCCBA487BDC", hash_generated_field = "A9142AB7D4AAFA3289BD2734D8B176B9")

    private static final int USIM_EFCCP1_TAG = 0xCB;
}


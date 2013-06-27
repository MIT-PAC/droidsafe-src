package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class AdnRecordLoader extends Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.187 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "4D74BFF297E0DF8FA98FF6D8A8DBA78C")

    PhoneBase phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.187 -0400", hash_original_field = "FEB78CC258BDC76867354F01C22DBE43", hash_generated_field = "036ADE2862D2A42E9D25EBB639B81422")

    int ef;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.188 -0400", hash_original_field = "D8E3DC447ACBE488908DF601D2648CC9", hash_generated_field = "1F822E6940DDE842720B0C7DA6C46B62")

    int extensionEF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.188 -0400", hash_original_field = "B7D07153F471E6227FBC2A1DBF1B7D46", hash_generated_field = "21A6C1E891AA9C60FA5155604EF98417")

    int pendingExtLoads;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.188 -0400", hash_original_field = "7CD68A12689ED678E4F02DF5FF6F0C49", hash_generated_field = "04812594E45CC9AEFCC2441E721F5447")

    Message userResponse;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.188 -0400", hash_original_field = "1CE8F9C8C598A33E655651C0899EF7BC", hash_generated_field = "247B791A35A84ACFB3A5BD453F069E1B")

    String pin2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.188 -0400", hash_original_field = "94FFE9B9C5894C1D45DFC612B295C53B", hash_generated_field = "23F79AC71281FC94187158A5D1BA833B")

    int recordNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.188 -0400", hash_original_field = "62FEAEB3DF20337E3D35BAB4C7D3C6B1", hash_generated_field = "78DD856F69213B918116896C99742E98")

    ArrayList<AdnRecord> adns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.188 -0400", hash_original_field = "B4A88417B3D0170D754C647C30B7216A", hash_generated_field = "BCA77D12632DFCDF9A8AEB56A649B3D3")

    Object result;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.188 -0400", hash_original_method = "042ECF1C251BBED01DD567DA5D6FB1BE", hash_generated_method = "6F0F0DBFBFB3D86988DB1CAD42996FED")
    public  AdnRecordLoader(PhoneBase phone) {
        super(phone.getHandler().getLooper());
        this.phone = phone;
        LOG_TAG = phone.getPhoneName();
        // ---------- Original Method ----------
        //this.phone = phone;
        //LOG_TAG = phone.getPhoneName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.189 -0400", hash_original_method = "E52409147EA4C18E8F78BAF12B808BF8", hash_generated_method = "6EB46D6941E8B29BDE235893777C0E24")
    public void loadFromEF(int ef, int extensionEF, int recordNumber,
                Message response) {
        this.ef = ef;
        this.extensionEF = extensionEF;
        this.recordNumber = recordNumber;
        this.userResponse = response;
        phone.mIccFileHandler.loadEFLinearFixed(
                    ef, recordNumber,
                    obtainMessage(EVENT_ADN_LOAD_DONE));
        // ---------- Original Method ----------
        //this.ef = ef;
        //this.extensionEF = extensionEF;
        //this.recordNumber = recordNumber;
        //this.userResponse = response;
        //phone.mIccFileHandler.loadEFLinearFixed(
                    //ef, recordNumber,
                    //obtainMessage(EVENT_ADN_LOAD_DONE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.189 -0400", hash_original_method = "3B75C101082AA8B5F76E21C5AC0D856A", hash_generated_method = "DF4256CB7896A805A14912C7FC61BE58")
    public void loadAllFromEF(int ef, int extensionEF,
                Message response) {
        this.ef = ef;
        this.extensionEF = extensionEF;
        this.userResponse = response;
        phone.mIccFileHandler.loadEFLinearFixedAll(
                    ef,
                    obtainMessage(EVENT_ADN_LOAD_ALL_DONE));
        // ---------- Original Method ----------
        //this.ef = ef;
        //this.extensionEF = extensionEF;
        //this.userResponse = response;
        //phone.mIccFileHandler.loadEFLinearFixedAll(
                    //ef,
                    //obtainMessage(EVENT_ADN_LOAD_ALL_DONE));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.190 -0400", hash_original_method = "A04989E1C9551E085CB246E835FB8373", hash_generated_method = "CCA2DE92CF4A8017E08361AB1870D84A")
    public void updateEF(AdnRecord adn, int ef, int extensionEF, int recordNumber,
            String pin2, Message response) {
        this.ef = ef;
        this.extensionEF = extensionEF;
        this.recordNumber = recordNumber;
        this.userResponse = response;
        this.pin2 = pin2;
        phone.mIccFileHandler.getEFLinearRecordSize( ef,
            obtainMessage(EVENT_EF_LINEAR_RECORD_SIZE_DONE, adn));
        addTaint(adn.getTaint());
        // ---------- Original Method ----------
        //this.ef = ef;
        //this.extensionEF = extensionEF;
        //this.recordNumber = recordNumber;
        //this.userResponse = response;
        //this.pin2 = pin2;
        //phone.mIccFileHandler.getEFLinearRecordSize( ef,
            //obtainMessage(EVENT_EF_LINEAR_RECORD_SIZE_DONE, adn));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.211 -0400", hash_original_method = "051E5CCA6123D268EF8D870B0A4015BF", hash_generated_method = "95B13100AE5F938118B9788F9E0AD856")
    public void handleMessage(Message msg) {
        AsyncResult ar;
        byte data[];
        AdnRecord adn;
        try 
        {
            //Begin case EVENT_EF_LINEAR_RECORD_SIZE_DONE 
            ar = (AsyncResult)(msg.obj);
            //End case EVENT_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_EF_LINEAR_RECORD_SIZE_DONE 
            adn = (AdnRecord)(ar.userObj);
            //End case EVENT_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_EF_LINEAR_RECORD_SIZE_DONE 
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("get EF record size failed",
                                ar.exception);
            } //End block
            //End case EVENT_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_EF_LINEAR_RECORD_SIZE_DONE 
            int[] recordSize;
            recordSize = (int[])ar.result;
            //End case EVENT_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_EF_LINEAR_RECORD_SIZE_DONE 
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("get wrong EF record size format",
                                ar.exception);
            } //End block
            //End case EVENT_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_EF_LINEAR_RECORD_SIZE_DONE 
            data = adn.buildAdnString(recordSize[0]);
            //End case EVENT_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_EF_LINEAR_RECORD_SIZE_DONE 
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("wrong ADN format",
                                ar.exception);
            } //End block
            //End case EVENT_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_EF_LINEAR_RECORD_SIZE_DONE 
            phone.mIccFileHandler.updateEFLinearFixed(ef, recordNumber,
                            data, pin2, obtainMessage(EVENT_UPDATE_RECORD_DONE));
            //End case EVENT_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_EF_LINEAR_RECORD_SIZE_DONE 
            pendingExtLoads = 1;
            //End case EVENT_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_UPDATE_RECORD_DONE 
            ar = (AsyncResult)(msg.obj);
            //End case EVENT_UPDATE_RECORD_DONE 
            //Begin case EVENT_UPDATE_RECORD_DONE 
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("update EF adn record failed",
                                ar.exception);
            } //End block
            //End case EVENT_UPDATE_RECORD_DONE 
            //Begin case EVENT_UPDATE_RECORD_DONE 
            pendingExtLoads = 0;
            //End case EVENT_UPDATE_RECORD_DONE 
            //Begin case EVENT_UPDATE_RECORD_DONE 
            result = null;
            //End case EVENT_UPDATE_RECORD_DONE 
            //Begin case EVENT_ADN_LOAD_DONE 
            ar = (AsyncResult)(msg.obj);
            //End case EVENT_ADN_LOAD_DONE 
            //Begin case EVENT_ADN_LOAD_DONE 
            data = (byte[])(ar.result);
            //End case EVENT_ADN_LOAD_DONE 
            //Begin case EVENT_ADN_LOAD_DONE 
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("load failed", ar.exception);
            } //End block
            //End case EVENT_ADN_LOAD_DONE 
            //Begin case EVENT_ADN_LOAD_DONE 
            {
                Log.d(LOG_TAG,"ADN EF: 0x"
                            + Integer.toHexString(ef)
                            + ":" + recordNumber
                            + "\n" + IccUtils.bytesToHexString(data));
            } //End block
            //End case EVENT_ADN_LOAD_DONE 
            //Begin case EVENT_ADN_LOAD_DONE 
            adn = new AdnRecord(ef, recordNumber, data);
            //End case EVENT_ADN_LOAD_DONE 
            //Begin case EVENT_ADN_LOAD_DONE 
            result = adn;
            //End case EVENT_ADN_LOAD_DONE 
            //Begin case EVENT_ADN_LOAD_DONE 
            {
                boolean varFE2DCF0A5347115B122FEC19A7AE9B4D_216193291 = (adn.hasExtendedRecord());
                {
                    pendingExtLoads = 1;
                    phone.mIccFileHandler.loadEFLinearFixed(
                            extensionEF, adn.extRecord,
                            obtainMessage(EVENT_EXT_RECORD_LOAD_DONE, adn));
                } //End block
            } //End collapsed parenthetic
            //End case EVENT_ADN_LOAD_DONE 
            //Begin case EVENT_EXT_RECORD_LOAD_DONE 
            ar = (AsyncResult)(msg.obj);
            //End case EVENT_EXT_RECORD_LOAD_DONE 
            //Begin case EVENT_EXT_RECORD_LOAD_DONE 
            data = (byte[])(ar.result);
            //End case EVENT_EXT_RECORD_LOAD_DONE 
            //Begin case EVENT_EXT_RECORD_LOAD_DONE 
            adn = (AdnRecord)(ar.userObj);
            //End case EVENT_EXT_RECORD_LOAD_DONE 
            //Begin case EVENT_EXT_RECORD_LOAD_DONE 
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("load failed", ar.exception);
            } //End block
            //End case EVENT_EXT_RECORD_LOAD_DONE 
            //Begin case EVENT_EXT_RECORD_LOAD_DONE 
            Log.d(LOG_TAG,"ADN extension EF: 0x"
                        + Integer.toHexString(extensionEF)
                        + ":" + adn.extRecord
                        + "\n" + IccUtils.bytesToHexString(data));
            //End case EVENT_EXT_RECORD_LOAD_DONE 
            //Begin case EVENT_EXT_RECORD_LOAD_DONE 
            adn.appendExtRecord(data);
            //End case EVENT_EXT_RECORD_LOAD_DONE 
            //Begin case EVENT_ADN_LOAD_ALL_DONE 
            ar = (AsyncResult)(msg.obj);
            //End case EVENT_ADN_LOAD_ALL_DONE 
            //Begin case EVENT_ADN_LOAD_ALL_DONE 
            ArrayList<byte[]> datas;
            datas = (ArrayList<byte[]>)(ar.result);
            //End case EVENT_ADN_LOAD_ALL_DONE 
            //Begin case EVENT_ADN_LOAD_ALL_DONE 
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("load failed", ar.exception);
            } //End block
            //End case EVENT_ADN_LOAD_ALL_DONE 
            //Begin case EVENT_ADN_LOAD_ALL_DONE 
            adns = new ArrayList<AdnRecord>(datas.size());
            //End case EVENT_ADN_LOAD_ALL_DONE 
            //Begin case EVENT_ADN_LOAD_ALL_DONE 
            result = adns;
            //End case EVENT_ADN_LOAD_ALL_DONE 
            //Begin case EVENT_ADN_LOAD_ALL_DONE 
            pendingExtLoads = 0;
            //End case EVENT_ADN_LOAD_ALL_DONE 
            //Begin case EVENT_ADN_LOAD_ALL_DONE 
            {
                int i, s;
                i = 0;
                s = datas.size();
                {
                    adn = new AdnRecord(ef, 1 + i, datas.get(i));
                    adns.add(adn);
                    {
                        boolean var60B64E5A1B8439B55F8C49ADD0A148AF_1189668685 = (adn.hasExtendedRecord());
                        {
                            phone.mIccFileHandler.loadEFLinearFixed(
                                extensionEF, adn.extRecord,
                                obtainMessage(EVENT_EXT_RECORD_LOAD_DONE, adn));
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            //End case EVENT_ADN_LOAD_ALL_DONE 
        } //End block
        catch (RuntimeException exc)
        {
            {
                AsyncResult.forMessage(userResponse)
                                .exception = exc;
                userResponse.sendToTarget();
                userResponse = null;
            } //End block
        } //End block
        {
            AsyncResult.forMessage(userResponse).result
                = result;
            userResponse.sendToTarget();
            userResponse = null;
        } //End block
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.213 -0400", hash_original_field = "E352FA068E2A15ACE6EF763778B80C2C", hash_generated_field = "17A3362C3349AC144D451B5CA8B78324")

    static String LOG_TAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.213 -0400", hash_original_field = "C34EBD8BE313D3F515534EF218F0270F", hash_generated_field = "C54DA2C35B6B5FFF34A0088F91C399A9")

    static int EVENT_ADN_LOAD_DONE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.213 -0400", hash_original_field = "6BDC27EFB296ABEEC5CB5DDE25669728", hash_generated_field = "3F0F51C456CA2D70CEC6A04EADA4D416")

    static int EVENT_EXT_RECORD_LOAD_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.213 -0400", hash_original_field = "D93A812DE5DF1B1B3326089AAE00BD42", hash_generated_field = "E33418C11A5BFB1A3C9967D5372203B1")

    static int EVENT_ADN_LOAD_ALL_DONE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.213 -0400", hash_original_field = "7E129EB068D22E1546E4794922C7F231", hash_generated_field = "BFC288CD42055783BBCEC347942074E4")

    static int EVENT_EF_LINEAR_RECORD_SIZE_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.213 -0400", hash_original_field = "B3962F33DF711CD7D3C2F19D39D3F6D8", hash_generated_field = "0EDFEB3544324C3930C76C801775893C")

    static int EVENT_UPDATE_RECORD_DONE = 5;
}


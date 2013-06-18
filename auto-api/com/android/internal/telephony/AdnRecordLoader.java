package com.android.internal.telephony;

// Droidsafe Imports
import java.util.ArrayList;

import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import droidsafe.annotations.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class AdnRecordLoader extends Handler {
    static String LOG_TAG;
    PhoneBase phone;
    int ef;
    int extensionEF;
    int pendingExtLoads;
    Message userResponse;
    String pin2;
    int recordNumber;
    ArrayList<AdnRecord> adns;
    Object result;
    static final int EVENT_ADN_LOAD_DONE = 1;
    static final int EVENT_EXT_RECORD_LOAD_DONE = 2;
    static final int EVENT_ADN_LOAD_ALL_DONE = 3;
    static final int EVENT_EF_LINEAR_RECORD_SIZE_DONE = 4;
    static final int EVENT_UPDATE_RECORD_DONE = 5;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.569 -0400", hash_original_method = "042ECF1C251BBED01DD567DA5D6FB1BE", hash_generated_method = "8BCA0E98260F7077043A2422210C3ABE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @DSModeled(DSC.SPEC)
    public AdnRecordLoader(PhoneBase phone) {
        super(phone.getHandler().getLooper());
        dsTaint.addTaint(phone.dsTaint);
        LOG_TAG = phone.getPhoneName();
        // ---------- Original Method ----------
        //this.phone = phone;
        //LOG_TAG = phone.getPhoneName();
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.569 -0400", hash_original_method = "E52409147EA4C18E8F78BAF12B808BF8", hash_generated_method = "9E3D4D8AC46E682153EB43219B7F12A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void loadFromEF(int ef, int extensionEF, int recordNumber,
                Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(ef);
        dsTaint.addTaint(recordNumber);
        dsTaint.addTaint(extensionEF);
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.569 -0400", hash_original_method = "3B75C101082AA8B5F76E21C5AC0D856A", hash_generated_method = "8532DBDDD55CED52507B39B5671C2DB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void loadAllFromEF(int ef, int extensionEF,
                Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(ef);
        dsTaint.addTaint(extensionEF);
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.569 -0400", hash_original_method = "A04989E1C9551E085CB246E835FB8373", hash_generated_method = "2AE686CD92B31D57B000D0F5B8FAC189")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateEF(AdnRecord adn, int ef, int extensionEF, int recordNumber,
            String pin2, Message response) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(ef);
        dsTaint.addTaint(recordNumber);
        dsTaint.addTaint(pin2);
        dsTaint.addTaint(adn.dsTaint);
        dsTaint.addTaint(extensionEF);
        phone.mIccFileHandler.getEFLinearRecordSize( ef,
            obtainMessage(EVENT_EF_LINEAR_RECORD_SIZE_DONE, adn));
        // ---------- Original Method ----------
        //this.ef = ef;
        //this.extensionEF = extensionEF;
        //this.recordNumber = recordNumber;
        //this.userResponse = response;
        //this.pin2 = pin2;
        //phone.mIccFileHandler.getEFLinearRecordSize( ef,
            //obtainMessage(EVENT_EF_LINEAR_RECORD_SIZE_DONE, adn));
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.570 -0400", hash_original_method = "051E5CCA6123D268EF8D870B0A4015BF", hash_generated_method = "7247AC6D60022FB90AF47995E8B70057")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @DSModeled(DSC.SPEC)
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
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
                boolean varFE2DCF0A5347115B122FEC19A7AE9B4D_277710893 = (adn.hasExtendedRecord());
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
            //Begin case EVENT_EXT_RECORD_LOAD_DONE
            pendingExtLoads--;
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
                if (DroidSafeAndroidRuntime.control)  throw new RuntimeException("load failed", ar.exception);
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
                        boolean var60B64E5A1B8439B55F8C49ADD0A148AF_2091290829 = (adn.hasExtendedRecord());
                        {
                            pendingExtLoads++;
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }


}



package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;

import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class AdnRecordLoader extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.635 -0500", hash_original_field = "B23F1213336A6A9687543ED87A15B656", hash_generated_field = "17A3362C3349AC144D451B5CA8B78324")

    static String LOG_TAG;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.657 -0500", hash_original_field = "2C7F3EDB742DE4DD6ECF1FAC496F496B", hash_generated_field = "6C4F2B2823554C1D8FB27E13A8A823B4")

    static final int EVENT_ADN_LOAD_DONE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.661 -0500", hash_original_field = "5B60DBB5A2E0FCCA3B462950F5880ACD", hash_generated_field = "E558B4E6E15486F9756108AEB9A85B6E")

    static final int EVENT_EXT_RECORD_LOAD_DONE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.664 -0500", hash_original_field = "055183BB074C7261387E30CFCA21B559", hash_generated_field = "877794DC8B76A5511EB8F1B4B7465CD6")

    static final int EVENT_ADN_LOAD_ALL_DONE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.666 -0500", hash_original_field = "765E0A7DA3C92D2D3C778C920082696A", hash_generated_field = "E3DB2F84D66B5CCEB103F156F258C13F")

    static final int EVENT_EF_LINEAR_RECORD_SIZE_DONE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.668 -0500", hash_original_field = "40F67A4D338105BFF55A3D2C6827271D", hash_generated_field = "16AB62374737D17C58E4C93E27895A01")

    static final int EVENT_UPDATE_RECORD_DONE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.637 -0500", hash_original_field = "4D74BFF297E0DF8FA98FF6D8A8DBA78C", hash_generated_field = "4D74BFF297E0DF8FA98FF6D8A8DBA78C")

    PhoneBase phone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.640 -0500", hash_original_field = "036ADE2862D2A42E9D25EBB639B81422", hash_generated_field = "036ADE2862D2A42E9D25EBB639B81422")

    int ef;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.642 -0500", hash_original_field = "1F822E6940DDE842720B0C7DA6C46B62", hash_generated_field = "1F822E6940DDE842720B0C7DA6C46B62")

    int extensionEF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.644 -0500", hash_original_field = "21A6C1E891AA9C60FA5155604EF98417", hash_generated_field = "21A6C1E891AA9C60FA5155604EF98417")

    int pendingExtLoads;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.646 -0500", hash_original_field = "04812594E45CC9AEFCC2441E721F5447", hash_generated_field = "04812594E45CC9AEFCC2441E721F5447")

    Message userResponse;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.648 -0500", hash_original_field = "247B791A35A84ACFB3A5BD453F069E1B", hash_generated_field = "247B791A35A84ACFB3A5BD453F069E1B")

    String pin2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.650 -0500", hash_original_field = "23F79AC71281FC94187158A5D1BA833B", hash_generated_field = "23F79AC71281FC94187158A5D1BA833B")

    int recordNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.653 -0500", hash_original_field = "78DD856F69213B918116896C99742E98", hash_generated_field = "78DD856F69213B918116896C99742E98")

    ArrayList<AdnRecord> adns;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.655 -0500", hash_original_field = "BCA77D12632DFCDF9A8AEB56A649B3D3", hash_generated_field = "AF3702DCE31842B1077A6BA0BEAC4C02")

    // Either an AdnRecord or a reference to adns depending
    // if this is a load one or load all operation
    Object result;

    //***** Constructor

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.671 -0500", hash_original_method = "042ECF1C251BBED01DD567DA5D6FB1BE", hash_generated_method = "7182F409E2E9F9BA6679316937A3B108")
    
public AdnRecordLoader(PhoneBase phone) {
        // The telephony unit-test cases may create AdnRecords
        // in secondary threads
        super(phone.getHandler().getLooper());

        this.phone = phone;
        LOG_TAG = phone.getPhoneName();
    }

    /**
     * Resulting AdnRecord is placed in response.obj.result
     * or response.obj.exception is set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.673 -0500", hash_original_method = "E52409147EA4C18E8F78BAF12B808BF8", hash_generated_method = "F5840CD261EEAED96C05048DE1D667D2")
    
public void
    loadFromEF(int ef, int extensionEF, int recordNumber,
                Message response) {
        this.ef = ef;
        this.extensionEF = extensionEF;
        this.recordNumber = recordNumber;
        this.userResponse = response;

        phone.mIccFileHandler.loadEFLinearFixed(
                    ef, recordNumber,
                    obtainMessage(EVENT_ADN_LOAD_DONE));

    }

    /**
     * Resulting ArrayList&lt;adnRecord> is placed in response.obj.result
     * or response.obj.exception is set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.676 -0500", hash_original_method = "3B75C101082AA8B5F76E21C5AC0D856A", hash_generated_method = "D18BF8D4530C4119F169AC9E5C51ECE3")
    
public void
    loadAllFromEF(int ef, int extensionEF,
                Message response) {
        this.ef = ef;
        this.extensionEF = extensionEF;
        this.userResponse = response;

        phone.mIccFileHandler.loadEFLinearFixedAll(
                    ef,
                    obtainMessage(EVENT_ADN_LOAD_ALL_DONE));

    }

    /**
     * Write adn to a EF SIM record
     * It will get the record size of EF record and compose hex adn array
     * then write the hex array to EF record
     *
     * @param adn is set with alphaTag and phone number
     * @param ef EF fileid
     * @param extensionEF extension EF fileid
     * @param recordNumber 1-based record index
     * @param pin2 for CHV2 operations, must be null if pin2 is not needed
     * @param response will be sent to its handler when completed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.679 -0500", hash_original_method = "A04989E1C9551E085CB246E835FB8373", hash_generated_method = "72794CF8418DDDE2C6E8DE9C87189279")
    
public void
    updateEF(AdnRecord adn, int ef, int extensionEF, int recordNumber,
            String pin2, Message response) {
        this.ef = ef;
        this.extensionEF = extensionEF;
        this.recordNumber = recordNumber;
        this.userResponse = response;
        this.pin2 = pin2;

        phone.mIccFileHandler.getEFLinearRecordSize( ef,
            obtainMessage(EVENT_EF_LINEAR_RECORD_SIZE_DONE, adn));
    }

    //***** Overridden from Handler

    @DSSafe(DSCat.IPC_CALLBACK)
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:11.683 -0500", hash_original_method = "051E5CCA6123D268EF8D870B0A4015BF", hash_generated_method = "3A1D97C4CD64F1883311ED84843E30BE")
    
public void
    handleMessage(Message msg) {
        AsyncResult ar;
        byte data[];
        AdnRecord adn;

        try {
            switch (msg.what) {
                case EVENT_EF_LINEAR_RECORD_SIZE_DONE:
                    ar = (AsyncResult)(msg.obj);
                    adn = (AdnRecord)(ar.userObj);

                    if (ar.exception != null) {
                        throw new RuntimeException("get EF record size failed",
                                ar.exception);
                    }

                    int[] recordSize = (int[])ar.result;
                    // recordSize is int[3] array
                    // int[0]  is the record length
                    // int[1]  is the total length of the EF file
                    // int[2]  is the number of records in the EF file
                    // So int[0] * int[2] = int[1]
                   if (recordSize.length != 3 || recordNumber > recordSize[2]) {
                        throw new RuntimeException("get wrong EF record size format",
                                ar.exception);
                    }

                    data = adn.buildAdnString(recordSize[0]);

                    if(data == null) {
                        throw new RuntimeException("wrong ADN format",
                                ar.exception);
                    }

                    phone.mIccFileHandler.updateEFLinearFixed(ef, recordNumber,
                            data, pin2, obtainMessage(EVENT_UPDATE_RECORD_DONE));

                    pendingExtLoads = 1;

                    break;
                case EVENT_UPDATE_RECORD_DONE:
                    ar = (AsyncResult)(msg.obj);
                    if (ar.exception != null) {
                        throw new RuntimeException("update EF adn record failed",
                                ar.exception);
                    }
                    pendingExtLoads = 0;
                    result = null;
                    break;
                case EVENT_ADN_LOAD_DONE:
                    ar = (AsyncResult)(msg.obj);
                    data = (byte[])(ar.result);

                    if (ar.exception != null) {
                        throw new RuntimeException("load failed", ar.exception);
                    }

                    if (false) {
                        Log.d(LOG_TAG,"ADN EF: 0x"
                            + Integer.toHexString(ef)
                            + ":" + recordNumber
                            + "\n" + IccUtils.bytesToHexString(data));
                    }

                    adn = new AdnRecord(ef, recordNumber, data);
                    result = adn;

                    if (adn.hasExtendedRecord()) {
                        // If we have a valid value in the ext record field,
                        // we're not done yet: we need to read the corresponding
                        // ext record and append it

                        pendingExtLoads = 1;

                        phone.mIccFileHandler.loadEFLinearFixed(
                            extensionEF, adn.extRecord,
                            obtainMessage(EVENT_EXT_RECORD_LOAD_DONE, adn));
                    }
                break;

                case EVENT_EXT_RECORD_LOAD_DONE:
                    ar = (AsyncResult)(msg.obj);
                    data = (byte[])(ar.result);
                    adn = (AdnRecord)(ar.userObj);

                    if (ar.exception != null) {
                        throw new RuntimeException("load failed", ar.exception);
                    }

                    Log.d(LOG_TAG,"ADN extension EF: 0x"
                        + Integer.toHexString(extensionEF)
                        + ":" + adn.extRecord
                        + "\n" + IccUtils.bytesToHexString(data));

                    adn.appendExtRecord(data);

                    pendingExtLoads--;
                    // result should have been set in
                    // EVENT_ADN_LOAD_DONE or EVENT_ADN_LOAD_ALL_DONE
                break;

                case EVENT_ADN_LOAD_ALL_DONE:
                    ar = (AsyncResult)(msg.obj);
                    ArrayList<byte[]> datas = (ArrayList<byte[]>)(ar.result);

                    if (ar.exception != null) {
                        throw new RuntimeException("load failed", ar.exception);
                    }

                    adns = new ArrayList<AdnRecord>(datas.size());
                    result = adns;
                    pendingExtLoads = 0;

                    for(int i = 0, s = datas.size() ; i < s ; i++) {
                        adn = new AdnRecord(ef, 1 + i, datas.get(i));
                        adns.add(adn);

                        if (adn.hasExtendedRecord()) {
                            // If we have a valid value in the ext record field,
                            // we're not done yet: we need to read the corresponding
                            // ext record and append it

                            pendingExtLoads++;

                            phone.mIccFileHandler.loadEFLinearFixed(
                                extensionEF, adn.extRecord,
                                obtainMessage(EVENT_EXT_RECORD_LOAD_DONE, adn));
                        }
                    }
                break;
            }
        } catch (RuntimeException exc) {
            if (userResponse != null) {
                AsyncResult.forMessage(userResponse)
                                .exception = exc;
                userResponse.sendToTarget();
                // Loading is all or nothing--either every load succeeds
                // or we fail the whole thing.
                userResponse = null;
            }
            return;
        }

        if (userResponse != null && pendingExtLoads == 0) {
            AsyncResult.forMessage(userResponse).result
                = result;

            userResponse.sendToTarget();
            userResponse = null;
        }
    }
}


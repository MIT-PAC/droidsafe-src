package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.*;
import android.util.Log;
import java.util.ArrayList;

public abstract class IccFileHandler extends Handler implements IccConstants {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.054 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "4FEA837943E73EF5CB83661843F1AD15")

    protected PhoneBase phone;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.054 -0400", hash_original_method = "D43DCB164382547ACBC107CD3DAC237A", hash_generated_method = "B69471EEAB99E896BBF620126EB05566")
    protected  IccFileHandler(PhoneBase phone) {
        super();
        this.phone = phone;
        // ---------- Original Method ----------
        //this.phone = phone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.060 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.069 -0400", hash_original_method = "663260DCC0AEA6DC2CA2BB2A67F595C2", hash_generated_method = "C03FA8E8DEBCB3CC3244BCC48EF21DAE")
    public void loadEFLinearFixed(int fileid, int recordNum, Message onLoaded) {
        Message response;
        response = obtainMessage(EVENT_GET_RECORD_SIZE_DONE,
                        new LoadLinearFixedContext(fileid, recordNum, onLoaded));
        phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                        0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
        addTaint(fileid);
        addTaint(recordNum);
        addTaint(onLoaded.getTaint());
        // ---------- Original Method ----------
        //Message response
            //= obtainMessage(EVENT_GET_RECORD_SIZE_DONE,
                        //new LoadLinearFixedContext(fileid, recordNum, onLoaded));
        //phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                        //0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.070 -0400", hash_original_method = "AD3D0941CCBE990655E4D58F2671DA3B", hash_generated_method = "BD17FC239961041AE043659D0AA9A0A8")
    public void loadEFImgLinearFixed(int recordNum, Message onLoaded) {
        Message response;
        response = obtainMessage(EVENT_READ_IMG_DONE,
                new LoadLinearFixedContext(IccConstants.EF_IMG, recordNum,
                        onLoaded));
        phone.mCM.iccIO(COMMAND_GET_RESPONSE, IccConstants.EF_IMG, "img",
                recordNum, READ_RECORD_MODE_ABSOLUTE,
                GET_RESPONSE_EF_IMG_SIZE_BYTES, null, null, response);
        addTaint(recordNum);
        addTaint(onLoaded.getTaint());
        // ---------- Original Method ----------
        //Message response = obtainMessage(EVENT_READ_IMG_DONE,
                //new LoadLinearFixedContext(IccConstants.EF_IMG, recordNum,
                        //onLoaded));
        //phone.mCM.iccIO(COMMAND_GET_RESPONSE, IccConstants.EF_IMG, "img",
                //recordNum, READ_RECORD_MODE_ABSOLUTE,
                //GET_RESPONSE_EF_IMG_SIZE_BYTES, null, null, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.070 -0400", hash_original_method = "50E0C1880D1B176F78B29AB1FC2AC0F6", hash_generated_method = "51FC8D0DFF2ACDDE03415395325012EB")
    public void getEFLinearRecordSize(int fileid, Message onLoaded) {
        Message response;
        response = obtainMessage(EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE,
                        new LoadLinearFixedContext(fileid, onLoaded));
        phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                    0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
        addTaint(fileid);
        addTaint(onLoaded.getTaint());
        // ---------- Original Method ----------
        //Message response
                //= obtainMessage(EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE,
                        //new LoadLinearFixedContext(fileid, onLoaded));
        //phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                    //0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.070 -0400", hash_original_method = "65C59C00611DFB92BBD6DFE9FDCAEDDA", hash_generated_method = "A933EE2AF3D42464936EF43C2F4B93D2")
    public void loadEFLinearFixedAll(int fileid, Message onLoaded) {
        Message response;
        response = obtainMessage(EVENT_GET_RECORD_SIZE_DONE,
                        new LoadLinearFixedContext(fileid,onLoaded));
        phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                        0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
        addTaint(fileid);
        addTaint(onLoaded.getTaint());
        // ---------- Original Method ----------
        //Message response = obtainMessage(EVENT_GET_RECORD_SIZE_DONE,
                        //new LoadLinearFixedContext(fileid,onLoaded));
        //phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                        //0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.071 -0400", hash_original_method = "E6873BA2275643766469BAAFD3B2D8F2", hash_generated_method = "BB470E3987BAAC7830A6B454AF492D24")
    public void loadEFTransparent(int fileid, Message onLoaded) {
        Message response;
        response = obtainMessage(EVENT_GET_BINARY_SIZE_DONE,
                        fileid, 0, onLoaded);
        phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                        0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
        addTaint(fileid);
        addTaint(onLoaded.getTaint());
        // ---------- Original Method ----------
        //Message response = obtainMessage(EVENT_GET_BINARY_SIZE_DONE,
                        //fileid, 0, onLoaded);
        //phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                        //0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.072 -0400", hash_original_method = "2560A35ADA01F4B533EB0E56DA8161F2", hash_generated_method = "68A4E2BA9F1804D3CEC6301763711CF5")
    public void loadEFImgTransparent(int fileid, int highOffset, int lowOffset,
            int length, Message onLoaded) {
        Message response;
        response = obtainMessage(EVENT_READ_ICON_DONE, fileid, 0,
                onLoaded);
        phone.mCM.iccIO(COMMAND_READ_BINARY, fileid, "img", highOffset, lowOffset,
                length, null, null, response);
        addTaint(fileid);
        addTaint(highOffset);
        addTaint(lowOffset);
        addTaint(length);
        addTaint(onLoaded.getTaint());
        // ---------- Original Method ----------
        //Message response = obtainMessage(EVENT_READ_ICON_DONE, fileid, 0,
                //onLoaded);
        //phone.mCM.iccIO(COMMAND_READ_BINARY, fileid, "img", highOffset, lowOffset,
                //length, null, null, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.073 -0400", hash_original_method = "FA70C1BBB046CBB00612B81948F784B1", hash_generated_method = "AE8D22DD7D3FA6396C13767590052FCC")
    public void updateEFLinearFixed(int fileid, int recordNum, byte[] data,
            String pin2, Message onComplete) {
        phone.mCM.iccIO(COMMAND_UPDATE_RECORD, fileid, getEFPath(fileid),
                        recordNum, READ_RECORD_MODE_ABSOLUTE, data.length,
                        IccUtils.bytesToHexString(data), pin2, onComplete);
        addTaint(fileid);
        addTaint(recordNum);
        addTaint(data[0]);
        addTaint(pin2.getTaint());
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //phone.mCM.iccIO(COMMAND_UPDATE_RECORD, fileid, getEFPath(fileid),
                        //recordNum, READ_RECORD_MODE_ABSOLUTE, data.length,
                        //IccUtils.bytesToHexString(data), pin2, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.088 -0400", hash_original_method = "E2C68C0F33001D18516AF5A16FEBCDCE", hash_generated_method = "270B5E73C771D1D7317F0BCC67A20BDB")
    public void updateEFTransparent(int fileid, byte[] data, Message onComplete) {
        phone.mCM.iccIO(COMMAND_UPDATE_BINARY, fileid, getEFPath(fileid),
                        0, 0, data.length,
                        IccUtils.bytesToHexString(data), null, onComplete);
        addTaint(fileid);
        addTaint(data[0]);
        addTaint(onComplete.getTaint());
        // ---------- Original Method ----------
        //phone.mCM.iccIO(COMMAND_UPDATE_BINARY, fileid, getEFPath(fileid),
                        //0, 0, data.length,
                        //IccUtils.bytesToHexString(data), null, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.088 -0400", hash_original_method = "75655596118E033F36F4E4359D6ED264", hash_generated_method = "927E19D6094B263F0E3182C74BEF8A0B")
    private void sendResult(Message response, Object result, Throwable ex) {
        AsyncResult.forMessage(response, result, ex);
        response.sendToTarget();
        addTaint(response.getTaint());
        addTaint(result.getTaint());
        addTaint(ex.getTaint());
        // ---------- Original Method ----------
        //if (response == null) {
            //return;
        //}
        //AsyncResult.forMessage(response, result, ex);
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.123 -0400", hash_original_method = "7545CD0BE0B692221088F308787036AD", hash_generated_method = "D5F87AC3D2D7F83FB51151E2D8B2F77C")
    public void handleMessage(Message msg) {
        AsyncResult ar;
        IccIoResult result;
        Message response;
        response = null;
        String str;
        LoadLinearFixedContext lc;
        IccException iccException;
        byte data[];
        int size;
        int fileid;
        int recordNum;
        int recordSize[];
        try 
        {
            //Begin case EVENT_READ_IMG_DONE 
            ar = (AsyncResult) msg.obj;
            //End case EVENT_READ_IMG_DONE 
            //Begin case EVENT_READ_IMG_DONE 
            lc = (LoadLinearFixedContext) ar.userObj;
            //End case EVENT_READ_IMG_DONE 
            //Begin case EVENT_READ_IMG_DONE 
            result = (IccIoResult) ar.result;
            //End case EVENT_READ_IMG_DONE 
            //Begin case EVENT_READ_IMG_DONE 
            response = lc.onLoaded;
            //End case EVENT_READ_IMG_DONE 
            //Begin case EVENT_READ_IMG_DONE 
            iccException = result.getException();
            //End case EVENT_READ_IMG_DONE 
            //Begin case EVENT_READ_IMG_DONE 
            {
                sendResult(response, result.payload, ar.exception);
            } //End block
            //End case EVENT_READ_IMG_DONE 
            //Begin case EVENT_READ_ICON_DONE 
            ar = (AsyncResult) msg.obj;
            //End case EVENT_READ_ICON_DONE 
            //Begin case EVENT_READ_ICON_DONE 
            response = (Message) ar.userObj;
            //End case EVENT_READ_ICON_DONE 
            //Begin case EVENT_READ_ICON_DONE 
            result = (IccIoResult) ar.result;
            //End case EVENT_READ_ICON_DONE 
            //Begin case EVENT_READ_ICON_DONE 
            iccException = result.getException();
            //End case EVENT_READ_ICON_DONE 
            //Begin case EVENT_READ_ICON_DONE 
            {
                sendResult(response, result.payload, ar.exception);
            } //End block
            //End case EVENT_READ_ICON_DONE 
            //Begin case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            lc = (LoadLinearFixedContext) ar.userObj;
            //End case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            result = (IccIoResult) ar.result;
            //End case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            response = lc.onLoaded;
            //End case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            {
                sendResult(response, null, ar.exception);
            } //End block
            //End case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            iccException = result.getException();
            //End case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            {
                sendResult(response, null, iccException);
            } //End block
            //End case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            data = result.payload;
            //End case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            {
                if (DroidSafeAndroidRuntime.control) throw new IccFileTypeMismatch();
            } //End block
            //End case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            recordSize = new int[3];
            //End case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            recordSize[0] = data[RESPONSE_DATA_RECORD_LENGTH] & 0xFF;
            //End case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            recordSize[1] = ((data[RESPONSE_DATA_FILE_SIZE_1] & 0xff) << 8)
                       + (data[RESPONSE_DATA_FILE_SIZE_2] & 0xff);
            //End case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            recordSize[2] = recordSize[1] / recordSize[0];
            //End case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            sendResult(response, recordSize, null);
            //End case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_RECORD_SIZE_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_RECORD_SIZE_DONE 
            lc = (LoadLinearFixedContext) ar.userObj;
            //End case EVENT_GET_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_RECORD_SIZE_DONE 
            result = (IccIoResult) ar.result;
            //End case EVENT_GET_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_RECORD_SIZE_DONE 
            response = lc.onLoaded;
            //End case EVENT_GET_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_RECORD_SIZE_DONE 
            {
                sendResult(response, null, ar.exception);
            } //End block
            //End case EVENT_GET_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_RECORD_SIZE_DONE 
            iccException = result.getException();
            //End case EVENT_GET_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_RECORD_SIZE_DONE 
            {
                sendResult(response, null, iccException);
            } //End block
            //End case EVENT_GET_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_RECORD_SIZE_DONE 
            data = result.payload;
            //End case EVENT_GET_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_RECORD_SIZE_DONE 
            fileid = lc.efid;
            //End case EVENT_GET_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_RECORD_SIZE_DONE 
            recordNum = lc.recordNum;
            //End case EVENT_GET_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_RECORD_SIZE_DONE 
            {
                if (DroidSafeAndroidRuntime.control) throw new IccFileTypeMismatch();
            } //End block
            //End case EVENT_GET_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_RECORD_SIZE_DONE 
            {
                if (DroidSafeAndroidRuntime.control) throw new IccFileTypeMismatch();
            } //End block
            //End case EVENT_GET_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_RECORD_SIZE_DONE 
            lc.recordSize = data[RESPONSE_DATA_RECORD_LENGTH] & 0xFF;
            //End case EVENT_GET_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_RECORD_SIZE_DONE 
            size = ((data[RESPONSE_DATA_FILE_SIZE_1] & 0xff) << 8)
                       + (data[RESPONSE_DATA_FILE_SIZE_2] & 0xff);
            //End case EVENT_GET_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_RECORD_SIZE_DONE 
            lc.countRecords = size / lc.recordSize;
            //End case EVENT_GET_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_RECORD_SIZE_DONE 
            {
                lc.results = new ArrayList<byte[]>(lc.countRecords);
            } //End block
            //End case EVENT_GET_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_RECORD_SIZE_DONE 
            phone.mCM.iccIO(COMMAND_READ_RECORD, lc.efid, getEFPath(lc.efid),
                         lc.recordNum,
                         READ_RECORD_MODE_ABSOLUTE,
                         lc.recordSize, null, null,
                         obtainMessage(EVENT_READ_RECORD_DONE, lc));
            //End case EVENT_GET_RECORD_SIZE_DONE 
            //Begin case EVENT_GET_BINARY_SIZE_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_GET_BINARY_SIZE_DONE 
            //Begin case EVENT_GET_BINARY_SIZE_DONE 
            response = (Message) ar.userObj;
            //End case EVENT_GET_BINARY_SIZE_DONE 
            //Begin case EVENT_GET_BINARY_SIZE_DONE 
            result = (IccIoResult) ar.result;
            //End case EVENT_GET_BINARY_SIZE_DONE 
            //Begin case EVENT_GET_BINARY_SIZE_DONE 
            {
                sendResult(response, null, ar.exception);
            } //End block
            //End case EVENT_GET_BINARY_SIZE_DONE 
            //Begin case EVENT_GET_BINARY_SIZE_DONE 
            iccException = result.getException();
            //End case EVENT_GET_BINARY_SIZE_DONE 
            //Begin case EVENT_GET_BINARY_SIZE_DONE 
            {
                sendResult(response, null, iccException);
            } //End block
            //End case EVENT_GET_BINARY_SIZE_DONE 
            //Begin case EVENT_GET_BINARY_SIZE_DONE 
            data = result.payload;
            //End case EVENT_GET_BINARY_SIZE_DONE 
            //Begin case EVENT_GET_BINARY_SIZE_DONE 
            fileid = msg.arg1;
            //End case EVENT_GET_BINARY_SIZE_DONE 
            //Begin case EVENT_GET_BINARY_SIZE_DONE 
            {
                if (DroidSafeAndroidRuntime.control) throw new IccFileTypeMismatch();
            } //End block
            //End case EVENT_GET_BINARY_SIZE_DONE 
            //Begin case EVENT_GET_BINARY_SIZE_DONE 
            {
                if (DroidSafeAndroidRuntime.control) throw new IccFileTypeMismatch();
            } //End block
            //End case EVENT_GET_BINARY_SIZE_DONE 
            //Begin case EVENT_GET_BINARY_SIZE_DONE 
            size = ((data[RESPONSE_DATA_FILE_SIZE_1] & 0xff) << 8)
                       + (data[RESPONSE_DATA_FILE_SIZE_2] & 0xff);
            //End case EVENT_GET_BINARY_SIZE_DONE 
            //Begin case EVENT_GET_BINARY_SIZE_DONE 
            phone.mCM.iccIO(COMMAND_READ_BINARY, fileid, getEFPath(fileid),
                                0, 0, size, null, null,
                                obtainMessage(EVENT_READ_BINARY_DONE,
                                              fileid, 0, response));
            //End case EVENT_GET_BINARY_SIZE_DONE 
            //Begin case EVENT_READ_RECORD_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_READ_RECORD_DONE 
            //Begin case EVENT_READ_RECORD_DONE 
            lc = (LoadLinearFixedContext) ar.userObj;
            //End case EVENT_READ_RECORD_DONE 
            //Begin case EVENT_READ_RECORD_DONE 
            result = (IccIoResult) ar.result;
            //End case EVENT_READ_RECORD_DONE 
            //Begin case EVENT_READ_RECORD_DONE 
            response = lc.onLoaded;
            //End case EVENT_READ_RECORD_DONE 
            //Begin case EVENT_READ_RECORD_DONE 
            {
                sendResult(response, null, ar.exception);
            } //End block
            //End case EVENT_READ_RECORD_DONE 
            //Begin case EVENT_READ_RECORD_DONE 
            iccException = result.getException();
            //End case EVENT_READ_RECORD_DONE 
            //Begin case EVENT_READ_RECORD_DONE 
            {
                sendResult(response, null, iccException);
            } //End block
            //End case EVENT_READ_RECORD_DONE 
            //Begin case EVENT_READ_RECORD_DONE 
            {
                sendResult(response, result.payload, null);
            } //End block
            {
                lc.results.add(result.payload);
                {
                    sendResult(response, lc.results, null);
                } //End block
                {
                    phone.mCM.iccIO(COMMAND_READ_RECORD, lc.efid, getEFPath(lc.efid),
                                    lc.recordNum,
                                    READ_RECORD_MODE_ABSOLUTE,
                                    lc.recordSize, null, null,
                                    obtainMessage(EVENT_READ_RECORD_DONE, lc));
                } //End block
            } //End block
            //End case EVENT_READ_RECORD_DONE 
            //Begin case EVENT_READ_BINARY_DONE 
            ar = (AsyncResult)msg.obj;
            //End case EVENT_READ_BINARY_DONE 
            //Begin case EVENT_READ_BINARY_DONE 
            response = (Message) ar.userObj;
            //End case EVENT_READ_BINARY_DONE 
            //Begin case EVENT_READ_BINARY_DONE 
            result = (IccIoResult) ar.result;
            //End case EVENT_READ_BINARY_DONE 
            //Begin case EVENT_READ_BINARY_DONE 
            {
                sendResult(response, null, ar.exception);
            } //End block
            //End case EVENT_READ_BINARY_DONE 
            //Begin case EVENT_READ_BINARY_DONE 
            iccException = result.getException();
            //End case EVENT_READ_BINARY_DONE 
            //Begin case EVENT_READ_BINARY_DONE 
            {
                sendResult(response, null, iccException);
            } //End block
            //End case EVENT_READ_BINARY_DONE 
            //Begin case EVENT_READ_BINARY_DONE 
            sendResult(response, result.payload, null);
            //End case EVENT_READ_BINARY_DONE 
        } //End block
        catch (Exception exc)
        {
            {
                sendResult(response, null, exc);
            } //End block
            {
                loge("uncaught exception" + exc);
            } //End block
        } //End block
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.125 -0400", hash_original_method = "186CFCBD54A740D0E08382313B3D28EB", hash_generated_method = "1FD0D47B5C8B794E37D3071179F0218C")
    protected String getCommonIccEFPath(int efid) {
        String varB4EAC82CA7396A68D541C85D26508E83_433519127 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_736888532 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1217804515 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_2005339560 = null; //Variable for return #4
        //Begin case EF_ADN EF_FDN EF_MSISDN EF_SDN EF_EXT1 EF_EXT2 EF_EXT3 
        varB4EAC82CA7396A68D541C85D26508E83_433519127 = MF_SIM + DF_TELECOM;
        //End case EF_ADN EF_FDN EF_MSISDN EF_SDN EF_EXT1 EF_EXT2 EF_EXT3 
        //Begin case EF_ICCID EF_PL 
        varB4EAC82CA7396A68D541C85D26508E83_736888532 = MF_SIM;
        //End case EF_ICCID EF_PL 
        //Begin case EF_IMG 
        varB4EAC82CA7396A68D541C85D26508E83_1217804515 = MF_SIM + DF_TELECOM + DF_GRAPHICS;
        //End case EF_IMG 
        varB4EAC82CA7396A68D541C85D26508E83_2005339560 = null;
        addTaint(efid);
        String varA7E53CE21691AB073D9660D615818899_799816201; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_799816201 = varB4EAC82CA7396A68D541C85D26508E83_433519127;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_799816201 = varB4EAC82CA7396A68D541C85D26508E83_736888532;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_799816201 = varB4EAC82CA7396A68D541C85D26508E83_1217804515;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_799816201 = varB4EAC82CA7396A68D541C85D26508E83_2005339560;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_799816201.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_799816201;
        // ---------- Original Method ----------
        //switch(efid) {
        //case EF_ADN:
        //case EF_FDN:
        //case EF_MSISDN:
        //case EF_SDN:
        //case EF_EXT1:
        //case EF_EXT2:
        //case EF_EXT3:
            //return MF_SIM + DF_TELECOM;
        //case EF_ICCID:
        //case EF_PL:
            //return MF_SIM;
        //case EF_IMG:
            //return MF_SIM + DF_TELECOM + DF_GRAPHICS;
        //}
        //return null;
    }

    
    protected abstract String getEFPath(int efid);

    
    protected abstract void logd(String s);

    
    protected abstract void loge(String s);

    
    static class LoadLinearFixedContext {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.128 -0400", hash_original_field = "1E3235258D1AA505A2572AF2B7877EBF", hash_generated_field = "48F4A49B3891A623660D9D89A749D7FD")

        int efid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.128 -0400", hash_original_field = "CA295049F4D4B86A33AD27D536F404C9", hash_generated_field = "448A06525EF8C132E28A8573FF9B2600")

        int recordNum;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.128 -0400", hash_original_field = "5BF8005FBC54CBD8FD3B1DD07A722DAC", hash_generated_field = "F30A01C2B6ADD522369D460AF8A04CE9")

        int recordSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.128 -0400", hash_original_field = "2F5F454F98EAFD8B6FA7B7DDD9C0D375", hash_generated_field = "8940C0F4994601D31321FD5647CCE2C9")

        int countRecords;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.128 -0400", hash_original_field = "BB847FAFDB6A081B966FD76E5B4A5A46", hash_generated_field = "3FC49A57EDDE4CDC0FE7CAB1D79A6EF9")

        boolean loadAll;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.128 -0400", hash_original_field = "ECD4FD81A15FB8610B3A4FC91F4CADEE", hash_generated_field = "20B78D0A5BE6006623DEB5273A81CD7C")

        Message onLoaded;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.133 -0400", hash_original_field = "53E61336BB49EC978968786B07DEA50B", hash_generated_field = "0881DA448D3638C35BB652108D0CFFA3")

        ArrayList<byte[]> results;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.139 -0400", hash_original_method = "51FF1105D833FA23AFEA102913139717", hash_generated_method = "39DEDF6560E57782DF67CC79885DC1F4")
          LoadLinearFixedContext(int efid, int recordNum, Message onLoaded) {
            this.efid = efid;
            this.recordNum = recordNum;
            this.onLoaded = onLoaded;
            this.loadAll = false;
            // ---------- Original Method ----------
            //this.efid = efid;
            //this.recordNum = recordNum;
            //this.onLoaded = onLoaded;
            //this.loadAll = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.140 -0400", hash_original_method = "D730261F991D6C5434BBC408762FB0A8", hash_generated_method = "94B3DA3648FF158F58E975BBA6C57772")
          LoadLinearFixedContext(int efid, Message onLoaded) {
            this.efid = efid;
            this.recordNum = 1;
            this.loadAll = true;
            this.onLoaded = onLoaded;
            // ---------- Original Method ----------
            //this.efid = efid;
            //this.recordNum = 1;
            //this.loadAll = true;
            //this.onLoaded = onLoaded;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.140 -0400", hash_original_field = "318A56FDDC0971A06DDAF82064AC442B", hash_generated_field = "2EB96A8DC1E5872EAF17C2402DF642F6")

    static protected int COMMAND_READ_BINARY = 0xb0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.140 -0400", hash_original_field = "34027F43B17C5807993431EB36EFC094", hash_generated_field = "33BC63AB7D56A3D4DE77F28860F82331")

    static protected int COMMAND_UPDATE_BINARY = 0xd6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.140 -0400", hash_original_field = "A8EB47362E5BD46BCD3E537FFB913C2A", hash_generated_field = "12252E2DC1E0D4FA5CCAC53C2B3C09B3")

    static protected int COMMAND_READ_RECORD = 0xb2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.140 -0400", hash_original_field = "5C96FC38E0457D0ACCCF02655BA6BACE", hash_generated_field = "97F8D6843D07C0A54BA327625F8A87C8")

    static protected int COMMAND_UPDATE_RECORD = 0xdc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.140 -0400", hash_original_field = "762DBAEAF0DEEFAC7318EC3992F45222", hash_generated_field = "61CEF8A9285E5D4CBBA562E1EFBD8DA0")

    static protected int COMMAND_SEEK = 0xa2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.140 -0400", hash_original_field = "9E07D20045C9CCDC3AAA50366888CD96", hash_generated_field = "E78FBA7DFF326CFDBFB92CC39F866941")

    static protected int COMMAND_GET_RESPONSE = 0xc0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.140 -0400", hash_original_field = "4F2BF81F6166FA757C22344938E2EA18", hash_generated_field = "0EEA0A9BEC2D4C8463F4CA70D26ECBBD")

    static protected int READ_RECORD_MODE_ABSOLUTE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.140 -0400", hash_original_field = "BAA5639619ADFED8619888117163DE5D", hash_generated_field = "DBC20E8925C84D9996F9F6D8AA00420E")

    static protected int EF_TYPE_TRANSPARENT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.140 -0400", hash_original_field = "E3D29FACCA57A330DE33B009B84315EA", hash_generated_field = "A9BD6D7F5192FCC8CE79BCB3388FD6CA")

    static protected int EF_TYPE_LINEAR_FIXED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.140 -0400", hash_original_field = "41AB7479E17711009D1C7B82FC85659A", hash_generated_field = "6AA65FE074B3E39054B4F9FB10EB969C")

    static protected int EF_TYPE_CYCLIC = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "0F57D71893501A3C31DC199F5F98BC8A", hash_generated_field = "A83DFF152FA5A9FC6FA29EB2E059619D")

    static protected int TYPE_RFU = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "D56D54AA8ED30C719AA5B95D6FECB6B1", hash_generated_field = "8E8453AC53AD0336D401A2F1A761D1FE")

    static protected int TYPE_MF = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "B3685F98E592A6107B4E2354D87A7193", hash_generated_field = "7F02BEE8730D59A1DAE3A515126D8206")

    static protected int TYPE_DF = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "CFBA50CB9DCD254C3D2680FC7FB4BEF0", hash_generated_field = "48A7CF5F742EBF8600CE242CCBB6FC27")

    static protected int TYPE_EF = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "F6BB29AA53BBF9DE9C53F532B31EC6BC", hash_generated_field = "22A58521CD4B3D305D10AE3A50269C67")

    static protected int GET_RESPONSE_EF_SIZE_BYTES = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "C694B3C5B19B2B34343AE0527BD22FA0", hash_generated_field = "1B8DAA063004B25C8E7E078DE33A00DA")

    static protected int GET_RESPONSE_EF_IMG_SIZE_BYTES = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "4B0F775CA9CA6342E43E72152035686B", hash_generated_field = "08E53BCCA31F6EE6AA73150A5B3B6C23")

    static protected int RESPONSE_DATA_RFU_1 = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "A32BF89BB95C9B553DB1BE58928DC599", hash_generated_field = "D38EE4D6F3C2800076AA91012160FF40")

    static protected int RESPONSE_DATA_RFU_2 = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "594B04AA21CBA125FDFB07D4713B5C85", hash_generated_field = "5E6B0C6A79A29D0657FCF621781884CA")

    static protected int RESPONSE_DATA_FILE_SIZE_1 = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "1B5BDC6143ED0636944B7068258869F5", hash_generated_field = "3CF6B219FF5A4D5DF145FC59A8E80213")

    static protected int RESPONSE_DATA_FILE_SIZE_2 = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "0DD2C949F83F4738943FF1B5ACF8C437", hash_generated_field = "63243CB7C983F6720FA54E20C31DD7AD")

    static protected int RESPONSE_DATA_FILE_ID_1 = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "071187F6A4E0F0F915B06F13A6B6A412", hash_generated_field = "779C2EED6F956ABC43D9A551913A5C3F")

    static protected int RESPONSE_DATA_FILE_ID_2 = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "A1B4879034CE46A3B92A2B159332FE69", hash_generated_field = "918A723A162B7CBDEE36603A9252261E")

    static protected int RESPONSE_DATA_FILE_TYPE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "50646660E26260B5AAF89C2543CFF5D0", hash_generated_field = "94BE770964F035DC1BB3A102149FC4CE")

    static protected int RESPONSE_DATA_RFU_3 = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "415D37C6141AAAB43B5318B9055D51D9", hash_generated_field = "6FF175E0C2D3E9BF4E395A33AB5EA4A4")

    static protected int RESPONSE_DATA_ACCESS_CONDITION_1 = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "8D2037AF738732656927C87452C17C35", hash_generated_field = "ED57C9CF16C44A220B68B21CD41D6E2A")

    static protected int RESPONSE_DATA_ACCESS_CONDITION_2 = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "DE4FE15B24745E56ED845352E73B6390", hash_generated_field = "3CA8D974BB534595CB506FC26FD413E3")

    static protected int RESPONSE_DATA_ACCESS_CONDITION_3 = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "679479BC539273DA14D64C466A924045", hash_generated_field = "2743980F6BE48ABBAAEB5ACBAC704D77")

    static protected int RESPONSE_DATA_FILE_STATUS = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "FB6C7EBC7E3B0D58F20E7FB6499386E0", hash_generated_field = "BE3D4455C164E3E048672B704FD16447")

    static protected int RESPONSE_DATA_LENGTH = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "CE3577A4E3C9AC05B0096D3981053858", hash_generated_field = "B57F833CBA02155CC4B0F962C75D3822")

    static protected int RESPONSE_DATA_STRUCTURE = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "555EC3B6595CD9384E6D5DAD6097BD8E", hash_generated_field = "FAAE4BDBAB5F411F510C08A1489E5176")

    static protected int RESPONSE_DATA_RECORD_LENGTH = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "455E5DFCD1826703807B3D4D0C0756E8", hash_generated_field = "A7EEB32D7CBC5B1FAAD9856175D5BA83")

    static protected int EVENT_GET_BINARY_SIZE_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "57E4B85F881FE711BD1D7DF910A6C7ED", hash_generated_field = "1DEA71772000D53259995344593218AE")

    static protected int EVENT_READ_BINARY_DONE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "F808224DEBCEFA849E63D39372A2F59C", hash_generated_field = "61DABF16A638479920598F47935E87EF")

    static protected int EVENT_GET_RECORD_SIZE_DONE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.141 -0400", hash_original_field = "AD27EE89D714D1FF1AD713F4053E90E4", hash_generated_field = "A6957829B85B11F723CBF5F9832926CA")

    static protected int EVENT_READ_RECORD_DONE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.142 -0400", hash_original_field = "55F87A0FE0368FC595039E5B08D713F8", hash_generated_field = "9EC368296EB0A3A7FB6478A10A833B5F")

    static protected int EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.142 -0400", hash_original_field = "C045E73937799748D4E6D53FEDEEFA3E", hash_generated_field = "6437BC528D7E546D39A1A159FE34D21F")

    static protected int EVENT_READ_IMG_DONE = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.142 -0400", hash_original_field = "655C30EAAFB547A5CE2C813C7A826EC1", hash_generated_field = "CE818DD2D7073889D988A245AC30C9DA")

    static protected int EVENT_READ_ICON_DONE = 10;
}


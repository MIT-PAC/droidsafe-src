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
    protected PhoneBase phone;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.324 -0400", hash_original_method = "D43DCB164382547ACBC107CD3DAC237A", hash_generated_method = "9F21649DDBC4ED485AB5E4503DA4EDF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected IccFileHandler(PhoneBase phone) {
        super();
        dsTaint.addTaint(phone.dsTaint);
        // ---------- Original Method ----------
        //this.phone = phone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.325 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    @DSModeled(DSC.SAFE)
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.325 -0400", hash_original_method = "663260DCC0AEA6DC2CA2BB2A67F595C2", hash_generated_method = "96B19B4E15EEC01AC17AE098EF1BD89F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void loadEFLinearFixed(int fileid, int recordNum, Message onLoaded) {
        dsTaint.addTaint(recordNum);
        dsTaint.addTaint(onLoaded.dsTaint);
        dsTaint.addTaint(fileid);
        Message response;
        response = obtainMessage(EVENT_GET_RECORD_SIZE_DONE,
                        new LoadLinearFixedContext(fileid, recordNum, onLoaded));
        phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                        0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
        // ---------- Original Method ----------
        //Message response
            //= obtainMessage(EVENT_GET_RECORD_SIZE_DONE,
                        //new LoadLinearFixedContext(fileid, recordNum, onLoaded));
        //phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                        //0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.325 -0400", hash_original_method = "AD3D0941CCBE990655E4D58F2671DA3B", hash_generated_method = "025EA9239F917DA7326E34320EC478DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void loadEFImgLinearFixed(int recordNum, Message onLoaded) {
        dsTaint.addTaint(recordNum);
        dsTaint.addTaint(onLoaded.dsTaint);
        Message response;
        response = obtainMessage(EVENT_READ_IMG_DONE,
                new LoadLinearFixedContext(IccConstants.EF_IMG, recordNum,
                        onLoaded));
        phone.mCM.iccIO(COMMAND_GET_RESPONSE, IccConstants.EF_IMG, "img",
                recordNum, READ_RECORD_MODE_ABSOLUTE,
                GET_RESPONSE_EF_IMG_SIZE_BYTES, null, null, response);
        // ---------- Original Method ----------
        //Message response = obtainMessage(EVENT_READ_IMG_DONE,
                //new LoadLinearFixedContext(IccConstants.EF_IMG, recordNum,
                        //onLoaded));
        //phone.mCM.iccIO(COMMAND_GET_RESPONSE, IccConstants.EF_IMG, "img",
                //recordNum, READ_RECORD_MODE_ABSOLUTE,
                //GET_RESPONSE_EF_IMG_SIZE_BYTES, null, null, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.325 -0400", hash_original_method = "50E0C1880D1B176F78B29AB1FC2AC0F6", hash_generated_method = "3652F4C38804AAACCCC3521221914967")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getEFLinearRecordSize(int fileid, Message onLoaded) {
        dsTaint.addTaint(onLoaded.dsTaint);
        dsTaint.addTaint(fileid);
        Message response;
        response = obtainMessage(EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE,
                        new LoadLinearFixedContext(fileid, onLoaded));
        phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                    0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
        // ---------- Original Method ----------
        //Message response
                //= obtainMessage(EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE,
                        //new LoadLinearFixedContext(fileid, onLoaded));
        //phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                    //0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.325 -0400", hash_original_method = "65C59C00611DFB92BBD6DFE9FDCAEDDA", hash_generated_method = "8D3152ECDD1376A2D9157D113241613B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void loadEFLinearFixedAll(int fileid, Message onLoaded) {
        dsTaint.addTaint(onLoaded.dsTaint);
        dsTaint.addTaint(fileid);
        Message response;
        response = obtainMessage(EVENT_GET_RECORD_SIZE_DONE,
                        new LoadLinearFixedContext(fileid,onLoaded));
        phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                        0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
        // ---------- Original Method ----------
        //Message response = obtainMessage(EVENT_GET_RECORD_SIZE_DONE,
                        //new LoadLinearFixedContext(fileid,onLoaded));
        //phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                        //0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.326 -0400", hash_original_method = "E6873BA2275643766469BAAFD3B2D8F2", hash_generated_method = "929D14DBA96AC524C74F7CE49FC95405")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void loadEFTransparent(int fileid, Message onLoaded) {
        dsTaint.addTaint(onLoaded.dsTaint);
        dsTaint.addTaint(fileid);
        Message response;
        response = obtainMessage(EVENT_GET_BINARY_SIZE_DONE,
                        fileid, 0, onLoaded);
        phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                        0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
        // ---------- Original Method ----------
        //Message response = obtainMessage(EVENT_GET_BINARY_SIZE_DONE,
                        //fileid, 0, onLoaded);
        //phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                        //0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.326 -0400", hash_original_method = "2560A35ADA01F4B533EB0E56DA8161F2", hash_generated_method = "A73132FC20879BE4100C1AD2C2047CCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void loadEFImgTransparent(int fileid, int highOffset, int lowOffset,
            int length, Message onLoaded) {
        dsTaint.addTaint(onLoaded.dsTaint);
        dsTaint.addTaint(lowOffset);
        dsTaint.addTaint(length);
        dsTaint.addTaint(highOffset);
        dsTaint.addTaint(fileid);
        Message response;
        response = obtainMessage(EVENT_READ_ICON_DONE, fileid, 0,
                onLoaded);
        phone.mCM.iccIO(COMMAND_READ_BINARY, fileid, "img", highOffset, lowOffset,
                length, null, null, response);
        // ---------- Original Method ----------
        //Message response = obtainMessage(EVENT_READ_ICON_DONE, fileid, 0,
                //onLoaded);
        //phone.mCM.iccIO(COMMAND_READ_BINARY, fileid, "img", highOffset, lowOffset,
                //length, null, null, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.326 -0400", hash_original_method = "FA70C1BBB046CBB00612B81948F784B1", hash_generated_method = "8CC4D503BE634ABB47B8C0BD1B8CBE77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateEFLinearFixed(int fileid, int recordNum, byte[] data,
            String pin2, Message onComplete) {
        dsTaint.addTaint(recordNum);
        dsTaint.addTaint(pin2);
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(fileid);
        phone.mCM.iccIO(COMMAND_UPDATE_RECORD, fileid, getEFPath(fileid),
                        recordNum, READ_RECORD_MODE_ABSOLUTE, data.length,
                        IccUtils.bytesToHexString(data), pin2, onComplete);
        // ---------- Original Method ----------
        //phone.mCM.iccIO(COMMAND_UPDATE_RECORD, fileid, getEFPath(fileid),
                        //recordNum, READ_RECORD_MODE_ABSOLUTE, data.length,
                        //IccUtils.bytesToHexString(data), pin2, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.327 -0400", hash_original_method = "E2C68C0F33001D18516AF5A16FEBCDCE", hash_generated_method = "CF96C154D0EB2AD86C040F8DFFFAE7FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void updateEFTransparent(int fileid, byte[] data, Message onComplete) {
        dsTaint.addTaint(onComplete.dsTaint);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(fileid);
        phone.mCM.iccIO(COMMAND_UPDATE_BINARY, fileid, getEFPath(fileid),
                        0, 0, data.length,
                        IccUtils.bytesToHexString(data), null, onComplete);
        // ---------- Original Method ----------
        //phone.mCM.iccIO(COMMAND_UPDATE_BINARY, fileid, getEFPath(fileid),
                        //0, 0, data.length,
                        //IccUtils.bytesToHexString(data), null, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.327 -0400", hash_original_method = "75655596118E033F36F4E4359D6ED264", hash_generated_method = "AD50DB7F2D3B8A52E37D00BD757084E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void sendResult(Message response, Object result, Throwable ex) {
        dsTaint.addTaint(response.dsTaint);
        dsTaint.addTaint(ex.dsTaint);
        dsTaint.addTaint(result.dsTaint);
        AsyncResult.forMessage(response, result, ex);
        response.sendToTarget();
        // ---------- Original Method ----------
        //if (response == null) {
            //return;
        //}
        //AsyncResult.forMessage(response, result, ex);
        //response.sendToTarget();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.331 -0400", hash_original_method = "7545CD0BE0B692221088F308787036AD", hash_generated_method = "7E9DC5A0E91DDD2DA23649F240A3E1B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.332 -0400", hash_original_method = "186CFCBD54A740D0E08382313B3D28EB", hash_generated_method = "9BEE016EED3CD8DBA2506F1A91FEBA45")
    @DSModeled(DSC.SAFE)
    protected String getCommonIccEFPath(int efid) {
        dsTaint.addTaint(efid);
        return dsTaint.getTaintString();
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
        int efid;
        int recordNum, recordSize, countRecords;
        boolean loadAll;
        Message onLoaded;
        ArrayList<byte[]> results;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.332 -0400", hash_original_method = "51FF1105D833FA23AFEA102913139717", hash_generated_method = "CABBD6AB490E7FCA7C8CC1C20DBD9DF9")
        @DSModeled(DSC.SAFE)
         LoadLinearFixedContext(int efid, int recordNum, Message onLoaded) {
            dsTaint.addTaint(recordNum);
            dsTaint.addTaint(onLoaded.dsTaint);
            dsTaint.addTaint(efid);
            this.loadAll = false;
            // ---------- Original Method ----------
            //this.efid = efid;
            //this.recordNum = recordNum;
            //this.onLoaded = onLoaded;
            //this.loadAll = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.333 -0400", hash_original_method = "D730261F991D6C5434BBC408762FB0A8", hash_generated_method = "A32B704011772A18B8469E43F72261F9")
        @DSModeled(DSC.SAFE)
         LoadLinearFixedContext(int efid, Message onLoaded) {
            dsTaint.addTaint(onLoaded.dsTaint);
            dsTaint.addTaint(efid);
            this.recordNum = 1;
            this.loadAll = true;
            // ---------- Original Method ----------
            //this.efid = efid;
            //this.recordNum = 1;
            //this.loadAll = true;
            //this.onLoaded = onLoaded;
        }

        
    }


    
    static protected final int COMMAND_READ_BINARY = 0xb0;
    static protected final int COMMAND_UPDATE_BINARY = 0xd6;
    static protected final int COMMAND_READ_RECORD = 0xb2;
    static protected final int COMMAND_UPDATE_RECORD = 0xdc;
    static protected final int COMMAND_SEEK = 0xa2;
    static protected final int COMMAND_GET_RESPONSE = 0xc0;
    static protected final int READ_RECORD_MODE_ABSOLUTE = 4;
    static protected final int EF_TYPE_TRANSPARENT = 0;
    static protected final int EF_TYPE_LINEAR_FIXED = 1;
    static protected final int EF_TYPE_CYCLIC = 3;
    static protected final int TYPE_RFU = 0;
    static protected final int TYPE_MF  = 1;
    static protected final int TYPE_DF  = 2;
    static protected final int TYPE_EF  = 4;
    static protected final int GET_RESPONSE_EF_SIZE_BYTES = 15;
    static protected final int GET_RESPONSE_EF_IMG_SIZE_BYTES = 10;
    static protected final int RESPONSE_DATA_RFU_1 = 0;
    static protected final int RESPONSE_DATA_RFU_2 = 1;
    static protected final int RESPONSE_DATA_FILE_SIZE_1 = 2;
    static protected final int RESPONSE_DATA_FILE_SIZE_2 = 3;
    static protected final int RESPONSE_DATA_FILE_ID_1 = 4;
    static protected final int RESPONSE_DATA_FILE_ID_2 = 5;
    static protected final int RESPONSE_DATA_FILE_TYPE = 6;
    static protected final int RESPONSE_DATA_RFU_3 = 7;
    static protected final int RESPONSE_DATA_ACCESS_CONDITION_1 = 8;
    static protected final int RESPONSE_DATA_ACCESS_CONDITION_2 = 9;
    static protected final int RESPONSE_DATA_ACCESS_CONDITION_3 = 10;
    static protected final int RESPONSE_DATA_FILE_STATUS = 11;
    static protected final int RESPONSE_DATA_LENGTH = 12;
    static protected final int RESPONSE_DATA_STRUCTURE = 13;
    static protected final int RESPONSE_DATA_RECORD_LENGTH = 14;
    static protected final int EVENT_GET_BINARY_SIZE_DONE = 4;
    static protected final int EVENT_READ_BINARY_DONE = 5;
    static protected final int EVENT_GET_RECORD_SIZE_DONE = 6;
    static protected final int EVENT_READ_RECORD_DONE = 7;
    static protected final int EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE = 8;
    static protected final int EVENT_READ_IMG_DONE = 9;
    static protected final int EVENT_READ_ICON_DONE = 10;
}


package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.*;
import android.util.Log;
import java.util.ArrayList;

public abstract class IccFileHandler extends Handler implements IccConstants {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.499 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "4FEA837943E73EF5CB83661843F1AD15")

    protected PhoneBase phone;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.499 -0400", hash_original_method = "D43DCB164382547ACBC107CD3DAC237A", hash_generated_method = "B69471EEAB99E896BBF620126EB05566")
    protected  IccFileHandler(PhoneBase phone) {
        super();
        this.phone = phone;
        // ---------- Original Method ----------
        //this.phone = phone;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.500 -0400", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "614D737B8CBDA53A99A22331B445C19D")
    public void dispose() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.500 -0400", hash_original_method = "663260DCC0AEA6DC2CA2BB2A67F595C2", hash_generated_method = "E8F910D7E1BA3B3CCB0E099D067687BA")
    public void loadEFLinearFixed(int fileid, int recordNum, Message onLoaded) {
        addTaint(onLoaded.getTaint());
        addTaint(recordNum);
        addTaint(fileid);
        Message response = obtainMessage(EVENT_GET_RECORD_SIZE_DONE,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.501 -0400", hash_original_method = "AD3D0941CCBE990655E4D58F2671DA3B", hash_generated_method = "A71314FA168457C1BBAA39DE2F07118D")
    public void loadEFImgLinearFixed(int recordNum, Message onLoaded) {
        addTaint(onLoaded.getTaint());
        addTaint(recordNum);
        Message response = obtainMessage(EVENT_READ_IMG_DONE,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.501 -0400", hash_original_method = "50E0C1880D1B176F78B29AB1FC2AC0F6", hash_generated_method = "83CE1220F70A8E0A7858A0A91EBDAD7E")
    public void getEFLinearRecordSize(int fileid, Message onLoaded) {
        addTaint(onLoaded.getTaint());
        addTaint(fileid);
        Message response = obtainMessage(EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.501 -0400", hash_original_method = "65C59C00611DFB92BBD6DFE9FDCAEDDA", hash_generated_method = "FE376B104781CC0719C190FF20952443")
    public void loadEFLinearFixedAll(int fileid, Message onLoaded) {
        addTaint(onLoaded.getTaint());
        addTaint(fileid);
        Message response = obtainMessage(EVENT_GET_RECORD_SIZE_DONE,
                        new LoadLinearFixedContext(fileid,onLoaded));
        phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                        0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
        // ---------- Original Method ----------
        //Message response = obtainMessage(EVENT_GET_RECORD_SIZE_DONE,
                        //new LoadLinearFixedContext(fileid,onLoaded));
        //phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                        //0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.502 -0400", hash_original_method = "E6873BA2275643766469BAAFD3B2D8F2", hash_generated_method = "59A635F6A26076F4AC7D79F76702D14F")
    public void loadEFTransparent(int fileid, Message onLoaded) {
        addTaint(onLoaded.getTaint());
        addTaint(fileid);
        Message response = obtainMessage(EVENT_GET_BINARY_SIZE_DONE,
                        fileid, 0, onLoaded);
        phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                        0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
        // ---------- Original Method ----------
        //Message response = obtainMessage(EVENT_GET_BINARY_SIZE_DONE,
                        //fileid, 0, onLoaded);
        //phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, getEFPath(fileid),
                        //0, 0, GET_RESPONSE_EF_SIZE_BYTES, null, null, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.502 -0400", hash_original_method = "2560A35ADA01F4B533EB0E56DA8161F2", hash_generated_method = "1A3415A9F48A58C007711ADD60A7EC52")
    public void loadEFImgTransparent(int fileid, int highOffset, int lowOffset,
            int length, Message onLoaded) {
        addTaint(onLoaded.getTaint());
        addTaint(length);
        addTaint(lowOffset);
        addTaint(highOffset);
        addTaint(fileid);
        Message response = obtainMessage(EVENT_READ_ICON_DONE, fileid, 0,
                onLoaded);
        phone.mCM.iccIO(COMMAND_READ_BINARY, fileid, "img", highOffset, lowOffset,
                length, null, null, response);
        // ---------- Original Method ----------
        //Message response = obtainMessage(EVENT_READ_ICON_DONE, fileid, 0,
                //onLoaded);
        //phone.mCM.iccIO(COMMAND_READ_BINARY, fileid, "img", highOffset, lowOffset,
                //length, null, null, response);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.502 -0400", hash_original_method = "FA70C1BBB046CBB00612B81948F784B1", hash_generated_method = "9207D66BEB06124BB0AD7DAE43024007")
    public void updateEFLinearFixed(int fileid, int recordNum, byte[] data,
            String pin2, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(pin2.getTaint());
        addTaint(data[0]);
        addTaint(recordNum);
        addTaint(fileid);
        phone.mCM.iccIO(COMMAND_UPDATE_RECORD, fileid, getEFPath(fileid),
                        recordNum, READ_RECORD_MODE_ABSOLUTE, data.length,
                        IccUtils.bytesToHexString(data), pin2, onComplete);
        // ---------- Original Method ----------
        //phone.mCM.iccIO(COMMAND_UPDATE_RECORD, fileid, getEFPath(fileid),
                        //recordNum, READ_RECORD_MODE_ABSOLUTE, data.length,
                        //IccUtils.bytesToHexString(data), pin2, onComplete);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.503 -0400", hash_original_method = "E2C68C0F33001D18516AF5A16FEBCDCE", hash_generated_method = "7CB0E461FA6C6E2EF8B5F25316499AF0")
    public void updateEFTransparent(int fileid, byte[] data, Message onComplete) {
        addTaint(onComplete.getTaint());
        addTaint(data[0]);
        addTaint(fileid);
        phone.mCM.iccIO(COMMAND_UPDATE_BINARY, fileid, getEFPath(fileid),
                        0, 0, data.length,
                        IccUtils.bytesToHexString(data), null, onComplete);
        // ---------- Original Method ----------
        //phone.mCM.iccIO(COMMAND_UPDATE_BINARY, fileid, getEFPath(fileid),
                        //0, 0, data.length,
                        //IccUtils.bytesToHexString(data), null, onComplete);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.503 -0400", hash_original_method = "75655596118E033F36F4E4359D6ED264", hash_generated_method = "3FA08E26A7C2474CC418010849B9EF04")
    private void sendResult(Message response, Object result, Throwable ex) {
        addTaint(ex.getTaint());
        addTaint(result.getTaint());
        addTaint(response.getTaint());
    if(response == null)        
        {
            return;
        } //End block
        AsyncResult.forMessage(response, result, ex);
        response.sendToTarget();
        // ---------- Original Method ----------
        //if (response == null) {
            //return;
        //}
        //AsyncResult.forMessage(response, result, ex);
        //response.sendToTarget();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.511 -0400", hash_original_method = "7545CD0BE0B692221088F308787036AD", hash_generated_method = "5200CE46A7F7442BAD5D32B816103E58")
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        AsyncResult ar;
        IccIoResult result;
        Message response = null;
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
switch(msg.what){
            case EVENT_READ_IMG_DONE:
            ar = (AsyncResult) msg.obj;
            lc = (LoadLinearFixedContext) ar.userObj;
            result = (IccIoResult) ar.result;
            response = lc.onLoaded;
            iccException = result.getException();
    if(iccException != null)            
            {
                sendResult(response, result.payload, ar.exception);
            } //End block
            break;
            case EVENT_READ_ICON_DONE:
            ar = (AsyncResult) msg.obj;
            response = (Message) ar.userObj;
            result = (IccIoResult) ar.result;
            iccException = result.getException();
    if(iccException != null)            
            {
                sendResult(response, result.payload, ar.exception);
            } //End block
            break;
            case EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE:
            ar = (AsyncResult)msg.obj;
            lc = (LoadLinearFixedContext) ar.userObj;
            result = (IccIoResult) ar.result;
            response = lc.onLoaded;
    if(ar.exception != null)            
            {
                sendResult(response, null, ar.exception);
                break;
            } //End block
            iccException = result.getException();
    if(iccException != null)            
            {
                sendResult(response, null, iccException);
                break;
            } //End block
            data = result.payload;
    if(TYPE_EF != data[RESPONSE_DATA_FILE_TYPE] ||
                    EF_TYPE_LINEAR_FIXED != data[RESPONSE_DATA_STRUCTURE])            
            {
                IccFileTypeMismatch varF83A54C1C10242D7072BF9E0A98D9CF1_244236650 = new IccFileTypeMismatch();
                varF83A54C1C10242D7072BF9E0A98D9CF1_244236650.addTaint(taint);
                throw varF83A54C1C10242D7072BF9E0A98D9CF1_244236650;
            } //End block
            recordSize = new int[3];
            recordSize[0] = data[RESPONSE_DATA_RECORD_LENGTH] & 0xFF;
            recordSize[1] = ((data[RESPONSE_DATA_FILE_SIZE_1] & 0xff) << 8)
                       + (data[RESPONSE_DATA_FILE_SIZE_2] & 0xff);
            recordSize[2] = recordSize[1] / recordSize[0];
            sendResult(response, recordSize, null);
            break;
            case EVENT_GET_RECORD_SIZE_DONE:
            ar = (AsyncResult)msg.obj;
            lc = (LoadLinearFixedContext) ar.userObj;
            result = (IccIoResult) ar.result;
            response = lc.onLoaded;
    if(ar.exception != null)            
            {
                sendResult(response, null, ar.exception);
                break;
            } //End block
            iccException = result.getException();
    if(iccException != null)            
            {
                sendResult(response, null, iccException);
                break;
            } //End block
            data = result.payload;
            fileid = lc.efid;
            recordNum = lc.recordNum;
    if(TYPE_EF != data[RESPONSE_DATA_FILE_TYPE])            
            {
                IccFileTypeMismatch varF83A54C1C10242D7072BF9E0A98D9CF1_771393732 = new IccFileTypeMismatch();
                varF83A54C1C10242D7072BF9E0A98D9CF1_771393732.addTaint(taint);
                throw varF83A54C1C10242D7072BF9E0A98D9CF1_771393732;
            } //End block
    if(EF_TYPE_LINEAR_FIXED != data[RESPONSE_DATA_STRUCTURE])            
            {
                IccFileTypeMismatch varF83A54C1C10242D7072BF9E0A98D9CF1_1852667591 = new IccFileTypeMismatch();
                varF83A54C1C10242D7072BF9E0A98D9CF1_1852667591.addTaint(taint);
                throw varF83A54C1C10242D7072BF9E0A98D9CF1_1852667591;
            } //End block
            lc.recordSize = data[RESPONSE_DATA_RECORD_LENGTH] & 0xFF;
            size = ((data[RESPONSE_DATA_FILE_SIZE_1] & 0xff) << 8)
                       + (data[RESPONSE_DATA_FILE_SIZE_2] & 0xff);
            lc.countRecords = size / lc.recordSize;
    if(lc.loadAll)            
            {
                lc.results = new ArrayList<byte[]>(lc.countRecords);
            } //End block
            phone.mCM.iccIO(COMMAND_READ_RECORD, lc.efid, getEFPath(lc.efid),
                         lc.recordNum,
                         READ_RECORD_MODE_ABSOLUTE,
                         lc.recordSize, null, null,
                         obtainMessage(EVENT_READ_RECORD_DONE, lc));
            break;
            case EVENT_GET_BINARY_SIZE_DONE:
            ar = (AsyncResult)msg.obj;
            response = (Message) ar.userObj;
            result = (IccIoResult) ar.result;
    if(ar.exception != null)            
            {
                sendResult(response, null, ar.exception);
                break;
            } //End block
            iccException = result.getException();
    if(iccException != null)            
            {
                sendResult(response, null, iccException);
                break;
            } //End block
            data = result.payload;
            fileid = msg.arg1;
    if(TYPE_EF != data[RESPONSE_DATA_FILE_TYPE])            
            {
                IccFileTypeMismatch varF83A54C1C10242D7072BF9E0A98D9CF1_1084835458 = new IccFileTypeMismatch();
                varF83A54C1C10242D7072BF9E0A98D9CF1_1084835458.addTaint(taint);
                throw varF83A54C1C10242D7072BF9E0A98D9CF1_1084835458;
            } //End block
    if(EF_TYPE_TRANSPARENT != data[RESPONSE_DATA_STRUCTURE])            
            {
                IccFileTypeMismatch varF83A54C1C10242D7072BF9E0A98D9CF1_547015547 = new IccFileTypeMismatch();
                varF83A54C1C10242D7072BF9E0A98D9CF1_547015547.addTaint(taint);
                throw varF83A54C1C10242D7072BF9E0A98D9CF1_547015547;
            } //End block
            size = ((data[RESPONSE_DATA_FILE_SIZE_1] & 0xff) << 8)
                       + (data[RESPONSE_DATA_FILE_SIZE_2] & 0xff);
            phone.mCM.iccIO(COMMAND_READ_BINARY, fileid, getEFPath(fileid),
                                0, 0, size, null, null,
                                obtainMessage(EVENT_READ_BINARY_DONE,
                                              fileid, 0, response));
            break;
            case EVENT_READ_RECORD_DONE:
            ar = (AsyncResult)msg.obj;
            lc = (LoadLinearFixedContext) ar.userObj;
            result = (IccIoResult) ar.result;
            response = lc.onLoaded;
    if(ar.exception != null)            
            {
                sendResult(response, null, ar.exception);
                break;
            } //End block
            iccException = result.getException();
    if(iccException != null)            
            {
                sendResult(response, null, iccException);
                break;
            } //End block
    if(!lc.loadAll)            
            {
                sendResult(response, result.payload, null);
            } //End block
            else
            {
                lc.results.add(result.payload);
                lc.recordNum++;
    if(lc.recordNum > lc.countRecords)                
                {
                    sendResult(response, lc.results, null);
                } //End block
                else
                {
                    phone.mCM.iccIO(COMMAND_READ_RECORD, lc.efid, getEFPath(lc.efid),
                                    lc.recordNum,
                                    READ_RECORD_MODE_ABSOLUTE,
                                    lc.recordSize, null, null,
                                    obtainMessage(EVENT_READ_RECORD_DONE, lc));
                } //End block
            } //End block
            break;
            case EVENT_READ_BINARY_DONE:
            ar = (AsyncResult)msg.obj;
            response = (Message) ar.userObj;
            result = (IccIoResult) ar.result;
    if(ar.exception != null)            
            {
                sendResult(response, null, ar.exception);
                break;
            } //End block
            iccException = result.getException();
    if(iccException != null)            
            {
                sendResult(response, null, iccException);
                break;
            } //End block
            sendResult(response, result.payload, null);
            break;
}
        } //End block
        catch (Exception exc)
        {
    if(response != null)            
            {
                sendResult(response, null, exc);
            } //End block
            else
            {
                loge("uncaught exception" + exc);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.512 -0400", hash_original_method = "186CFCBD54A740D0E08382313B3D28EB", hash_generated_method = "C1A386917C74DB020F818753C69C92FA")
    protected String getCommonIccEFPath(int efid) {
        addTaint(efid);
switch(efid){
        case EF_ADN:
        case EF_FDN:
        case EF_MSISDN:
        case EF_SDN:
        case EF_EXT1:
        case EF_EXT2:
        case EF_EXT3:
String varC105CB41AAF16150249B5DA550B272CE_1781655195 =         MF_SIM + DF_TELECOM;
        varC105CB41AAF16150249B5DA550B272CE_1781655195.addTaint(taint);
        return varC105CB41AAF16150249B5DA550B272CE_1781655195;
        case EF_ICCID:
        case EF_PL:
String varC5BB3B026D2813421F379E2F13F91D02_301272194 =         MF_SIM;
        varC5BB3B026D2813421F379E2F13F91D02_301272194.addTaint(taint);
        return varC5BB3B026D2813421F379E2F13F91D02_301272194;
        case EF_IMG:
String varF9EB698F99A9BDFF5C272E2D1596B263_1037785980 =         MF_SIM + DF_TELECOM + DF_GRAPHICS;
        varF9EB698F99A9BDFF5C272E2D1596B263_1037785980.addTaint(taint);
        return varF9EB698F99A9BDFF5C272E2D1596B263_1037785980;
}String var540C13E9E156B687226421B24F2DF178_1343209498 =         null;
        var540C13E9E156B687226421B24F2DF178_1343209498.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1343209498;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.513 -0400", hash_original_field = "1E3235258D1AA505A2572AF2B7877EBF", hash_generated_field = "48F4A49B3891A623660D9D89A749D7FD")

        int efid;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.513 -0400", hash_original_field = "CA295049F4D4B86A33AD27D536F404C9", hash_generated_field = "448A06525EF8C132E28A8573FF9B2600")

        int recordNum;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.513 -0400", hash_original_field = "5BF8005FBC54CBD8FD3B1DD07A722DAC", hash_generated_field = "F30A01C2B6ADD522369D460AF8A04CE9")

        int recordSize;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.513 -0400", hash_original_field = "2F5F454F98EAFD8B6FA7B7DDD9C0D375", hash_generated_field = "8940C0F4994601D31321FD5647CCE2C9")

        int countRecords;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.513 -0400", hash_original_field = "BB847FAFDB6A081B966FD76E5B4A5A46", hash_generated_field = "3FC49A57EDDE4CDC0FE7CAB1D79A6EF9")

        boolean loadAll;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.513 -0400", hash_original_field = "ECD4FD81A15FB8610B3A4FC91F4CADEE", hash_generated_field = "20B78D0A5BE6006623DEB5273A81CD7C")

        Message onLoaded;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.513 -0400", hash_original_field = "53E61336BB49EC978968786B07DEA50B", hash_generated_field = "0881DA448D3638C35BB652108D0CFFA3")

        ArrayList<byte[]> results;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.514 -0400", hash_original_method = "51FF1105D833FA23AFEA102913139717", hash_generated_method = "39DEDF6560E57782DF67CC79885DC1F4")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.515 -0400", hash_original_method = "D730261F991D6C5434BBC408762FB0A8", hash_generated_method = "94B3DA3648FF158F58E975BBA6C57772")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.515 -0400", hash_original_field = "318A56FDDC0971A06DDAF82064AC442B", hash_generated_field = "3CC60D7DB30C18A0452D9C9FBB518575")

    static protected final int COMMAND_READ_BINARY = 0xb0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.515 -0400", hash_original_field = "34027F43B17C5807993431EB36EFC094", hash_generated_field = "52CE690B836D20CF1E855B08938321D5")

    static protected final int COMMAND_UPDATE_BINARY = 0xd6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.515 -0400", hash_original_field = "A8EB47362E5BD46BCD3E537FFB913C2A", hash_generated_field = "BC9C2764EDA638334784F399B103E9E0")

    static protected final int COMMAND_READ_RECORD = 0xb2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.515 -0400", hash_original_field = "5C96FC38E0457D0ACCCF02655BA6BACE", hash_generated_field = "8BF22C00B90ECE41C175F284E14EB6F8")

    static protected final int COMMAND_UPDATE_RECORD = 0xdc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.516 -0400", hash_original_field = "762DBAEAF0DEEFAC7318EC3992F45222", hash_generated_field = "8B9C977412DD987F5424817123628799")

    static protected final int COMMAND_SEEK = 0xa2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.516 -0400", hash_original_field = "9E07D20045C9CCDC3AAA50366888CD96", hash_generated_field = "9C29D11CB02119C04CD878F24FD81DAA")

    static protected final int COMMAND_GET_RESPONSE = 0xc0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.516 -0400", hash_original_field = "4F2BF81F6166FA757C22344938E2EA18", hash_generated_field = "AE4A7A14F63E2E0B4D9A7D7CBC69BBF3")

    static protected final int READ_RECORD_MODE_ABSOLUTE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.516 -0400", hash_original_field = "BAA5639619ADFED8619888117163DE5D", hash_generated_field = "B134B87914AE417BA97C107B99B8CDB9")

    static protected final int EF_TYPE_TRANSPARENT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.516 -0400", hash_original_field = "E3D29FACCA57A330DE33B009B84315EA", hash_generated_field = "6E3709AF8775D792AC4A070C596F9861")

    static protected final int EF_TYPE_LINEAR_FIXED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.516 -0400", hash_original_field = "41AB7479E17711009D1C7B82FC85659A", hash_generated_field = "2394B70D9734050F861A3B3CB5C98303")

    static protected final int EF_TYPE_CYCLIC = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.516 -0400", hash_original_field = "0F57D71893501A3C31DC199F5F98BC8A", hash_generated_field = "4F6A96AD1CFA7A0B6F5F28A0AF40A03E")

    static protected final int TYPE_RFU = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.516 -0400", hash_original_field = "D56D54AA8ED30C719AA5B95D6FECB6B1", hash_generated_field = "C12E1BA59E42BE4005DF2464AFF7BDD8")

    static protected final int TYPE_MF = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.516 -0400", hash_original_field = "B3685F98E592A6107B4E2354D87A7193", hash_generated_field = "17EDC54C4C805341C1E3BD385DADBD3F")

    static protected final int TYPE_DF = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.516 -0400", hash_original_field = "CFBA50CB9DCD254C3D2680FC7FB4BEF0", hash_generated_field = "A3CD59D6127DE19679D87A08B2F34045")

    static protected final int TYPE_EF = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.516 -0400", hash_original_field = "F6BB29AA53BBF9DE9C53F532B31EC6BC", hash_generated_field = "8B5DF3D8E3782991E722AD74CEABBA98")

    static protected final int GET_RESPONSE_EF_SIZE_BYTES = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.516 -0400", hash_original_field = "C694B3C5B19B2B34343AE0527BD22FA0", hash_generated_field = "5F8D8623CED36DF566DA8C82F1CFAEAB")

    static protected final int GET_RESPONSE_EF_IMG_SIZE_BYTES = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.516 -0400", hash_original_field = "4B0F775CA9CA6342E43E72152035686B", hash_generated_field = "6E588483220153E3A5CA5B13BFDBB87D")

    static protected final int RESPONSE_DATA_RFU_1 = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.516 -0400", hash_original_field = "A32BF89BB95C9B553DB1BE58928DC599", hash_generated_field = "B4E1945F68B64B65F65ABDC4D0578A48")

    static protected final int RESPONSE_DATA_RFU_2 = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.516 -0400", hash_original_field = "594B04AA21CBA125FDFB07D4713B5C85", hash_generated_field = "8FF5EBA412756AC6E802E2BAC0FBDAED")

    static protected final int RESPONSE_DATA_FILE_SIZE_1 = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.516 -0400", hash_original_field = "1B5BDC6143ED0636944B7068258869F5", hash_generated_field = "DDB49D3A31C04577F0DB449EF1DD0448")

    static protected final int RESPONSE_DATA_FILE_SIZE_2 = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.516 -0400", hash_original_field = "0DD2C949F83F4738943FF1B5ACF8C437", hash_generated_field = "7E722ABC4E41AE1CC40344A1978E9C0B")

    static protected final int RESPONSE_DATA_FILE_ID_1 = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.517 -0400", hash_original_field = "071187F6A4E0F0F915B06F13A6B6A412", hash_generated_field = "0AA73A2D770760EB67EB3D4FD789E7A4")

    static protected final int RESPONSE_DATA_FILE_ID_2 = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.517 -0400", hash_original_field = "A1B4879034CE46A3B92A2B159332FE69", hash_generated_field = "BA1B7DC7209FCB1EF51F72F887933559")

    static protected final int RESPONSE_DATA_FILE_TYPE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.517 -0400", hash_original_field = "50646660E26260B5AAF89C2543CFF5D0", hash_generated_field = "8AA9EB145B76A6BF1DCD4275917932B3")

    static protected final int RESPONSE_DATA_RFU_3 = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.517 -0400", hash_original_field = "415D37C6141AAAB43B5318B9055D51D9", hash_generated_field = "DE14F002E7E80FE2825FEC61B0815958")

    static protected final int RESPONSE_DATA_ACCESS_CONDITION_1 = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.517 -0400", hash_original_field = "8D2037AF738732656927C87452C17C35", hash_generated_field = "0CF86211F8BFE346CC8DCB9949EDB3A6")

    static protected final int RESPONSE_DATA_ACCESS_CONDITION_2 = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.517 -0400", hash_original_field = "DE4FE15B24745E56ED845352E73B6390", hash_generated_field = "42ECBE4F040FEC401BC6BE7771289E30")

    static protected final int RESPONSE_DATA_ACCESS_CONDITION_3 = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.517 -0400", hash_original_field = "679479BC539273DA14D64C466A924045", hash_generated_field = "199F3CA72C4189885796724CED0A9AEF")

    static protected final int RESPONSE_DATA_FILE_STATUS = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.517 -0400", hash_original_field = "FB6C7EBC7E3B0D58F20E7FB6499386E0", hash_generated_field = "DDE70B9F41C77A0C7A9BD50EB36912CD")

    static protected final int RESPONSE_DATA_LENGTH = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.517 -0400", hash_original_field = "CE3577A4E3C9AC05B0096D3981053858", hash_generated_field = "01DFE7624519AD919AAD908A207C02D6")

    static protected final int RESPONSE_DATA_STRUCTURE = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.517 -0400", hash_original_field = "555EC3B6595CD9384E6D5DAD6097BD8E", hash_generated_field = "FC1BB9BEB6B9507CBA32136E897CC277")

    static protected final int RESPONSE_DATA_RECORD_LENGTH = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.517 -0400", hash_original_field = "455E5DFCD1826703807B3D4D0C0756E8", hash_generated_field = "DC4EBC2D5D669A0166250BA81B924A01")

    static protected final int EVENT_GET_BINARY_SIZE_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.517 -0400", hash_original_field = "57E4B85F881FE711BD1D7DF910A6C7ED", hash_generated_field = "6417995F1CCE3BD60EA55EC5D9BAF9EB")

    static protected final int EVENT_READ_BINARY_DONE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.517 -0400", hash_original_field = "F808224DEBCEFA849E63D39372A2F59C", hash_generated_field = "8D7F7098D55C746BB788A8036B8F4D60")

    static protected final int EVENT_GET_RECORD_SIZE_DONE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.517 -0400", hash_original_field = "AD27EE89D714D1FF1AD713F4053E90E4", hash_generated_field = "E404E9022F0FA890A46E1100E27B724F")

    static protected final int EVENT_READ_RECORD_DONE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.517 -0400", hash_original_field = "55F87A0FE0368FC595039E5B08D713F8", hash_generated_field = "947A21F99F735ED86DA9B734578677CA")

    static protected final int EVENT_GET_EF_LINEAR_RECORD_SIZE_DONE = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.517 -0400", hash_original_field = "C045E73937799748D4E6D53FEDEEFA3E", hash_generated_field = "E159B90A57982AF312C9C8222FA36B34")

    static protected final int EVENT_READ_IMG_DONE = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.517 -0400", hash_original_field = "655C30EAAFB547A5CE2C813C7A826EC1", hash_generated_field = "545706A6E283BA9001F4AD6AECCB60D0")

    static protected final int EVENT_READ_ICON_DONE = 10;
}


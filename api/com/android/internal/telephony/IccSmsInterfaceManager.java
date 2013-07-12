package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;
import com.android.internal.util.HexDump;
import java.util.ArrayList;
import java.util.List;
import static android.telephony.SmsManager.STATUS_ON_ICC_FREE;

public abstract class IccSmsInterfaceManager extends ISms.Stub {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.710 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "C5284483C4CF8ED630A2E2607ED30E12")

    protected PhoneBase mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.710 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.710 -0400", hash_original_field = "DBF05840F0B51F776B05018389E7959D", hash_generated_field = "AC8E6363A1434BE5D4DA002E7C8CA149")

    protected SMSDispatcher mDispatcher;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.710 -0400", hash_original_method = "78E99F4B2BD1DF9D391D1AFBEE29FD49", hash_generated_method = "24E2DDD26F72C69DBA3FD42FF9AA575D")
    protected  IccSmsInterfaceManager(PhoneBase phone) {
        mPhone = phone;
        mContext = phone.getContext();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.711 -0400", hash_original_method = "D94224C2F430A720CDDDF796E6F87142", hash_generated_method = "CD41527436E023BEDAFD5AE49C1066C5")
    protected void enforceReceiveAndSend(String message) {
        addTaint(message.getTaint());
        mContext.enforceCallingPermission(
                "android.permission.RECEIVE_SMS", message);
        mContext.enforceCallingPermission(
                "android.permission.SEND_SMS", message);
        
        
                
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.711 -0400", hash_original_method = "2CBD208E09A1050F1D8C833305F8E60D", hash_generated_method = "446EE09278EF44A6DAD9C13154247D9E")
    public void sendData(String destAddr, String scAddr, int destPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        addTaint(deliveryIntent.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(data[0]);
        addTaint(destPort);
        addTaint(scAddr.getTaint());
        addTaint(destAddr.getTaint());
        mPhone.getContext().enforceCallingPermission(
                "android.permission.SEND_SMS",
                "Sending SMS message");
    if(Log.isLoggable("SMS", Log.VERBOSE))        
        {
            log("sendData: destAddr=" + destAddr + " scAddr=" + scAddr + " destPort=" +
                destPort + " data='"+ HexDump.toHexString(data)  + "' sentIntent=" +
                sentIntent + " deliveryIntent=" + deliveryIntent);
        } 
        mDispatcher.sendData(destAddr, scAddr, destPort, data, sentIntent, deliveryIntent);
        
        
                
                
        
            
                
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.712 -0400", hash_original_method = "9F601681CEADDF9DEDCDA3A25A2BC5E0", hash_generated_method = "1F2C49C8A75A629CFFF67770F15CCFBF")
    public void sendText(String destAddr, String scAddr,
            String text, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        addTaint(deliveryIntent.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(text.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(destAddr.getTaint());
        mPhone.getContext().enforceCallingOrSelfPermission(
                "android.permission.SEND_SMS",
                "Sending SMS message");
    if(Log.isLoggable("SMS", Log.VERBOSE))        
        {
            log("sendText: destAddr=" + destAddr + " scAddr=" + scAddr +
                " text='"+ text + "' sentIntent=" +
                sentIntent + " deliveryIntent=" + deliveryIntent);
        } 
        mDispatcher.sendText(destAddr, scAddr, text, sentIntent, deliveryIntent);
        
        
                
                
        
            
                
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.713 -0400", hash_original_method = "D9EE0BE48B3A066597B9F477CD500C6B", hash_generated_method = "14A5AA337231C614E0F96926CFB86BE4")
    public void sendMultipartText(String destAddr, String scAddr, List<String> parts,
            List<PendingIntent> sentIntents, List<PendingIntent> deliveryIntents) {
        addTaint(deliveryIntents.getTaint());
        addTaint(sentIntents.getTaint());
        addTaint(parts.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(destAddr.getTaint());
        mPhone.getContext().enforceCallingPermission(
                "android.permission.SEND_SMS",
                "Sending SMS message");
    if(Log.isLoggable("SMS", Log.VERBOSE))        
        {
            int i = 0;
for(String part : parts)
            {
                log("sendMultipartText: destAddr=" + destAddr + ", srAddr=" + scAddr +
                        ", part[" + (i++) + "]=" + part);
            } 
        } 
        mDispatcher.sendMultipartText(destAddr, scAddr, (ArrayList<String>) parts,
                (ArrayList<PendingIntent>) sentIntents, (ArrayList<PendingIntent>) deliveryIntents);
        
        
                
                
        
            
            
                
                        
            
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.714 -0400", hash_original_method = "26382ED0E59B10B13781F79838E812B0", hash_generated_method = "7E088DE5CDD779AF6AF18B0C9928B6D9")
    protected ArrayList<SmsRawData> buildValidRawData(ArrayList<byte[]> messages) {
        addTaint(messages.getTaint());
        int count = messages.size();
        ArrayList<SmsRawData> ret;
        ret = new ArrayList<SmsRawData>(count);
for(int i = 0;i < count;i++)
        {
            byte[] ba = messages.get(i);
    if(ba[0] == STATUS_ON_ICC_FREE)            
            {
                ret.add(null);
            } 
            else
            {
                ret.add(new SmsRawData(messages.get(i)));
            } 
        } 
ArrayList<SmsRawData> varEDFF4FBBF053B5DC2B444ADFA049EE0F_71675977 =         ret;
        varEDFF4FBBF053B5DC2B444ADFA049EE0F_71675977.addTaint(taint);
        return varEDFF4FBBF053B5DC2B444ADFA049EE0F_71675977;
        
        
        
        
        
            
            
                
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.715 -0400", hash_original_method = "D79D646E773875E9B0C4106E95D311F1", hash_generated_method = "61B45767BF553A4B0BDAEBC46685963C")
    protected byte[] makeSmsRecordData(int status, byte[] pdu) {
        addTaint(pdu[0]);
        addTaint(status);
        byte[] data = new byte[IccConstants.SMS_RECORD_LENGTH];
        data[0] = (byte)(status & 7);
        System.arraycopy(pdu, 0, data, 1, pdu.length);
for(int j = pdu.length+1;j < IccConstants.SMS_RECORD_LENGTH;j++)
        {
            data[j] = -1;
        } 
        byte[] var8D777F385D3DFEC8815D20F7496026DC_636935095 = (data);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_484616862 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_484616862;
        
        
        
        
        
            
        
        
    }

    
    protected abstract void log(String msg);

    
}


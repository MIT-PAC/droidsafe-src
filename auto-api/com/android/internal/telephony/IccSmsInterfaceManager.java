package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.PendingIntent;
import android.content.Context;
import android.util.Log;
import com.android.internal.util.HexDump;
import java.util.ArrayList;
import java.util.List;
import static android.telephony.SmsManager.STATUS_ON_ICC_FREE;

public abstract class IccSmsInterfaceManager extends ISms.Stub {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.110 -0400", hash_original_field = "44BC87C3198CFC247427A5305FDEA9BE", hash_generated_field = "C5284483C4CF8ED630A2E2607ED30E12")

    protected PhoneBase mPhone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.111 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")

    protected Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.111 -0400", hash_original_field = "DBF05840F0B51F776B05018389E7959D", hash_generated_field = "AC8E6363A1434BE5D4DA002E7C8CA149")

    protected SMSDispatcher mDispatcher;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.111 -0400", hash_original_method = "78E99F4B2BD1DF9D391D1AFBEE29FD49", hash_generated_method = "24E2DDD26F72C69DBA3FD42FF9AA575D")
    protected  IccSmsInterfaceManager(PhoneBase phone) {
        mPhone = phone;
        mContext = phone.getContext();
        // ---------- Original Method ----------
        //mPhone = phone;
        //mContext = phone.getContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.111 -0400", hash_original_method = "D94224C2F430A720CDDDF796E6F87142", hash_generated_method = "AE9AF6E81C49F452E55781C7847130B5")
    protected void enforceReceiveAndSend(String message) {
        mContext.enforceCallingPermission(
                "android.permission.RECEIVE_SMS", message);
        mContext.enforceCallingPermission(
                "android.permission.SEND_SMS", message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //mContext.enforceCallingPermission(
                //"android.permission.RECEIVE_SMS", message);
        //mContext.enforceCallingPermission(
                //"android.permission.SEND_SMS", message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.112 -0400", hash_original_method = "2CBD208E09A1050F1D8C833305F8E60D", hash_generated_method = "D1E65063EF33F6E992AA996CEC83D0AB")
    public void sendData(String destAddr, String scAddr, int destPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        mPhone.getContext().enforceCallingPermission(
                "android.permission.SEND_SMS",
                "Sending SMS message");
        {
            boolean var70BCCE476745B25D958813066B9E6E38_2007757031 = (Log.isLoggable("SMS", Log.VERBOSE));
            {
                log("sendData: destAddr=" + destAddr + " scAddr=" + scAddr + " destPort=" +
                destPort + " data='"+ HexDump.toHexString(data)  + "' sentIntent=" +
                sentIntent + " deliveryIntent=" + deliveryIntent);
            } //End block
        } //End collapsed parenthetic
        mDispatcher.sendData(destAddr, scAddr, destPort, data, sentIntent, deliveryIntent);
        addTaint(destAddr.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(destPort);
        addTaint(data[0]);
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
        // ---------- Original Method ----------
        //mPhone.getContext().enforceCallingPermission(
                //"android.permission.SEND_SMS",
                //"Sending SMS message");
        //if (Log.isLoggable("SMS", Log.VERBOSE)) {
            //log("sendData: destAddr=" + destAddr + " scAddr=" + scAddr + " destPort=" +
                //destPort + " data='"+ HexDump.toHexString(data)  + "' sentIntent=" +
                //sentIntent + " deliveryIntent=" + deliveryIntent);
        //}
        //mDispatcher.sendData(destAddr, scAddr, destPort, data, sentIntent, deliveryIntent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.112 -0400", hash_original_method = "9F601681CEADDF9DEDCDA3A25A2BC5E0", hash_generated_method = "B02F82C2C4DC619A26C97BB24E3481A1")
    public void sendText(String destAddr, String scAddr,
            String text, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        mPhone.getContext().enforceCallingOrSelfPermission(
                "android.permission.SEND_SMS",
                "Sending SMS message");
        {
            boolean var70BCCE476745B25D958813066B9E6E38_281281466 = (Log.isLoggable("SMS", Log.VERBOSE));
            {
                log("sendText: destAddr=" + destAddr + " scAddr=" + scAddr +
                " text='"+ text + "' sentIntent=" +
                sentIntent + " deliveryIntent=" + deliveryIntent);
            } //End block
        } //End collapsed parenthetic
        mDispatcher.sendText(destAddr, scAddr, text, sentIntent, deliveryIntent);
        addTaint(destAddr.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(text.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
        // ---------- Original Method ----------
        //mPhone.getContext().enforceCallingOrSelfPermission(
                //"android.permission.SEND_SMS",
                //"Sending SMS message");
        //if (Log.isLoggable("SMS", Log.VERBOSE)) {
            //log("sendText: destAddr=" + destAddr + " scAddr=" + scAddr +
                //" text='"+ text + "' sentIntent=" +
                //sentIntent + " deliveryIntent=" + deliveryIntent);
        //}
        //mDispatcher.sendText(destAddr, scAddr, text, sentIntent, deliveryIntent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.119 -0400", hash_original_method = "D9EE0BE48B3A066597B9F477CD500C6B", hash_generated_method = "4967C9BF8EE202EA29EEE2483BE55DC7")
    public void sendMultipartText(String destAddr, String scAddr, List<String> parts,
            List<PendingIntent> sentIntents, List<PendingIntent> deliveryIntents) {
        mPhone.getContext().enforceCallingPermission(
                "android.permission.SEND_SMS",
                "Sending SMS message");
        {
            boolean var70BCCE476745B25D958813066B9E6E38_1446068075 = (Log.isLoggable("SMS", Log.VERBOSE));
            {
                int i = 0;
                {
                    Iterator<String> var4E9C8AFBA69334251664FB12D52EFE6A_1567999740 = (parts).iterator();
                    var4E9C8AFBA69334251664FB12D52EFE6A_1567999740.hasNext();
                    String part = var4E9C8AFBA69334251664FB12D52EFE6A_1567999740.next();
                    {
                        log("sendMultipartText: destAddr=" + destAddr + ", srAddr=" + scAddr +
                        ", part[" + (i++) + "]=" + part);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mDispatcher.sendMultipartText(destAddr, scAddr, (ArrayList<String>) parts,
                (ArrayList<PendingIntent>) sentIntents, (ArrayList<PendingIntent>) deliveryIntents);
        addTaint(destAddr.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(parts.getTaint());
        addTaint(sentIntents.getTaint());
        addTaint(deliveryIntents.getTaint());
        // ---------- Original Method ----------
        //mPhone.getContext().enforceCallingPermission(
                //"android.permission.SEND_SMS",
                //"Sending SMS message");
        //if (Log.isLoggable("SMS", Log.VERBOSE)) {
            //int i = 0;
            //for (String part : parts) {
                //log("sendMultipartText: destAddr=" + destAddr + ", srAddr=" + scAddr +
                        //", part[" + (i++) + "]=" + part);
            //}
        //}
        //mDispatcher.sendMultipartText(destAddr, scAddr, (ArrayList<String>) parts,
                //(ArrayList<PendingIntent>) sentIntents, (ArrayList<PendingIntent>) deliveryIntents);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.120 -0400", hash_original_method = "26382ED0E59B10B13781F79838E812B0", hash_generated_method = "73A9217025B518C166F028A9B3984EDB")
    protected ArrayList<SmsRawData> buildValidRawData(ArrayList<byte[]> messages) {
        ArrayList<SmsRawData> varB4EAC82CA7396A68D541C85D26508E83_667137003 = null; //Variable for return #1
        int count = messages.size();
        ArrayList<SmsRawData> ret;
        ret = new ArrayList<SmsRawData>(count);
        {
            int i = 0;
            {
                byte[] ba = messages.get(i);
                {
                    ret.add(null);
                } //End block
                {
                    ret.add(new SmsRawData(messages.get(i)));
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_667137003 = ret;
        addTaint(messages[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_667137003.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_667137003;
        // ---------- Original Method ----------
        //int count = messages.size();
        //ArrayList<SmsRawData> ret;
        //ret = new ArrayList<SmsRawData>(count);
        //for (int i = 0; i < count; i++) {
            //byte[] ba = messages.get(i);
            //if (ba[0] == STATUS_ON_ICC_FREE) {
                //ret.add(null);
            //} else {
                //ret.add(new SmsRawData(messages.get(i)));
            //}
        //}
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.120 -0400", hash_original_method = "D79D646E773875E9B0C4106E95D311F1", hash_generated_method = "D36B7FD802088F78880B7F672FC3DADD")
    protected byte[] makeSmsRecordData(int status, byte[] pdu) {
        byte[] data = new byte[IccConstants.SMS_RECORD_LENGTH];
        data[0] = (byte)(status & 7);
        System.arraycopy(pdu, 0, data, 1, pdu.length);
        {
            int j = pdu.length+1;
            {
                data[j] = -1;
            } //End block
        } //End collapsed parenthetic
        addTaint(status);
        addTaint(pdu[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1394836766 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1394836766;
        // ---------- Original Method ----------
        //byte[] data = new byte[IccConstants.SMS_RECORD_LENGTH];
        //data[0] = (byte)(status & 7);
        //System.arraycopy(pdu, 0, data, 1, pdu.length);
        //for (int j = pdu.length+1; j < IccConstants.SMS_RECORD_LENGTH; j++) {
            //data[j] = -1;
        //}
        //return data;
    }

    
    protected abstract void log(String msg);

    
}


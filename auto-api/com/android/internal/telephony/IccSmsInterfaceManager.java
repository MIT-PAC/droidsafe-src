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
    protected PhoneBase mPhone;
    protected Context mContext;
    protected SMSDispatcher mDispatcher;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.440 -0400", hash_original_method = "78E99F4B2BD1DF9D391D1AFBEE29FD49", hash_generated_method = "A1513F2504C9958FC4894D5DA9B321DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected IccSmsInterfaceManager(PhoneBase phone) {
        dsTaint.addTaint(phone.dsTaint);
        mContext = phone.getContext();
        // ---------- Original Method ----------
        //mPhone = phone;
        //mContext = phone.getContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.440 -0400", hash_original_method = "D94224C2F430A720CDDDF796E6F87142", hash_generated_method = "9ED274ED83B696AB5FAF8A8B45BAEC17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void enforceReceiveAndSend(String message) {
        dsTaint.addTaint(message);
        mContext.enforceCallingPermission(
                "android.permission.RECEIVE_SMS", message);
        mContext.enforceCallingPermission(
                "android.permission.SEND_SMS", message);
        // ---------- Original Method ----------
        //mContext.enforceCallingPermission(
                //"android.permission.RECEIVE_SMS", message);
        //mContext.enforceCallingPermission(
                //"android.permission.SEND_SMS", message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.440 -0400", hash_original_method = "2CBD208E09A1050F1D8C833305F8E60D", hash_generated_method = "5A0B608B858548C7795A22E2E24CC7BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendData(String destAddr, String scAddr, int destPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        dsTaint.addTaint(scAddr);
        dsTaint.addTaint(destAddr);
        dsTaint.addTaint(sentIntent.dsTaint);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(destPort);
        dsTaint.addTaint(deliveryIntent.dsTaint);
        mPhone.getContext().enforceCallingPermission(
                "android.permission.SEND_SMS",
                "Sending SMS message");
        {
            boolean var70BCCE476745B25D958813066B9E6E38_1836731087 = (Log.isLoggable("SMS", Log.VERBOSE));
            {
                log("sendData: destAddr=" + destAddr + " scAddr=" + scAddr + " destPort=" +
                destPort + " data='"+ HexDump.toHexString(data)  + "' sentIntent=" +
                sentIntent + " deliveryIntent=" + deliveryIntent);
            } //End block
        } //End collapsed parenthetic
        mDispatcher.sendData(destAddr, scAddr, destPort, data, sentIntent, deliveryIntent);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.441 -0400", hash_original_method = "9F601681CEADDF9DEDCDA3A25A2BC5E0", hash_generated_method = "5E1390613C5C9723D1D2706265473AA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendText(String destAddr, String scAddr,
            String text, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(scAddr);
        dsTaint.addTaint(destAddr);
        dsTaint.addTaint(sentIntent.dsTaint);
        dsTaint.addTaint(deliveryIntent.dsTaint);
        mPhone.getContext().enforceCallingOrSelfPermission(
                "android.permission.SEND_SMS",
                "Sending SMS message");
        {
            boolean var70BCCE476745B25D958813066B9E6E38_2104607650 = (Log.isLoggable("SMS", Log.VERBOSE));
            {
                log("sendText: destAddr=" + destAddr + " scAddr=" + scAddr +
                " text='"+ text + "' sentIntent=" +
                sentIntent + " deliveryIntent=" + deliveryIntent);
            } //End block
        } //End collapsed parenthetic
        mDispatcher.sendText(destAddr, scAddr, text, sentIntent, deliveryIntent);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.445 -0400", hash_original_method = "D9EE0BE48B3A066597B9F477CD500C6B", hash_generated_method = "D38423018D9BD179460E77DF8A8259EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendMultipartText(String destAddr, String scAddr, List<String> parts,
            List<PendingIntent> sentIntents, List<PendingIntent> deliveryIntents) {
        dsTaint.addTaint(deliveryIntents.dsTaint);
        dsTaint.addTaint(scAddr);
        dsTaint.addTaint(destAddr);
        dsTaint.addTaint(sentIntents.dsTaint);
        dsTaint.addTaint(parts.dsTaint);
        mPhone.getContext().enforceCallingPermission(
                "android.permission.SEND_SMS",
                "Sending SMS message");
        {
            boolean var70BCCE476745B25D958813066B9E6E38_1161513665 = (Log.isLoggable("SMS", Log.VERBOSE));
            {
                int i;
                i = 0;
                {
                    Iterator<String> var4E9C8AFBA69334251664FB12D52EFE6A_859323851 = (parts).iterator();
                    var4E9C8AFBA69334251664FB12D52EFE6A_859323851.hasNext();
                    String part = var4E9C8AFBA69334251664FB12D52EFE6A_859323851.next();
                    {
                        log("sendMultipartText: destAddr=" + destAddr + ", srAddr=" + scAddr +
                        ", part[" + (i++) + "]=" + part);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mDispatcher.sendMultipartText(destAddr, scAddr, (ArrayList<String>) parts,
                (ArrayList<PendingIntent>) sentIntents, (ArrayList<PendingIntent>) deliveryIntents);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.445 -0400", hash_original_method = "26382ED0E59B10B13781F79838E812B0", hash_generated_method = "D62422899DBDC079B0A33B77185FDC58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ArrayList<SmsRawData> buildValidRawData(ArrayList<byte[]> messages) {
        dsTaint.addTaint(messages.dsTaint);
        int count;
        count = messages.size();
        ArrayList<SmsRawData> ret;
        ret = new ArrayList<SmsRawData>(count);
        {
            int i;
            i = 0;
            {
                byte[] ba;
                ba = messages.get(i);
                {
                    ret.add(null);
                } //End block
                {
                    ret.add(new SmsRawData(messages.get(i)));
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (ArrayList<SmsRawData>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.446 -0400", hash_original_method = "D79D646E773875E9B0C4106E95D311F1", hash_generated_method = "646FD13AE7AD764270B2D12E647D9F44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected byte[] makeSmsRecordData(int status, byte[] pdu) {
        dsTaint.addTaint(status);
        dsTaint.addTaint(pdu[0]);
        byte[] data;
        data = new byte[IccConstants.SMS_RECORD_LENGTH];
        data[0] = (byte)(status & 7);
        System.arraycopy(pdu, 0, data, 1, pdu.length);
        {
            int j;
            j = pdu.length+1;
            {
                data[j] = -1;
            } //End block
        } //End collapsed parenthetic
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
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


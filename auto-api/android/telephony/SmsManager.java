package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.text.TextUtils;
import com.android.internal.telephony.ISms;
import com.android.internal.telephony.IccConstants;
import com.android.internal.telephony.SmsRawData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SmsManager {
    private static final SmsManager sInstance = new SmsManager();
    static public final int STATUS_ON_ICC_FREE      = 0;
    static public final int STATUS_ON_ICC_READ      = 1;
    static public final int STATUS_ON_ICC_UNREAD    = 3;
    static public final int STATUS_ON_ICC_SENT      = 5;
    static public final int STATUS_ON_ICC_UNSENT    = 7;
    static public final int RESULT_ERROR_GENERIC_FAILURE    = 1;
    static public final int RESULT_ERROR_RADIO_OFF          = 2;
    static public final int RESULT_ERROR_NULL_PDU           = 3;
    static public final int RESULT_ERROR_NO_SERVICE         = 4;
    static public final int RESULT_ERROR_LIMIT_EXCEEDED     = 5;
    static public final int RESULT_ERROR_FDN_CHECK_FAILURE  = 6;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.801 -0400", hash_original_method = "20095975633950A922641E0460F74587", hash_generated_method = "B61CDFB73A878CC3773E7C0CC6402994")
    @DSModeled(DSC.SAFE)
    private SmsManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.801 -0400", hash_original_method = "9D6620F75021FD9E9FBB0176F1528DEF", hash_generated_method = "38DAE10215A266A5722E2E0C835C852B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendTextMessage(
            String destinationAddress, String scAddress, String text,
            PendingIntent sentIntent, PendingIntent deliveryIntent) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(destinationAddress);
        dsTaint.addTaint(scAddress);
        dsTaint.addTaint(sentIntent.dsTaint);
        dsTaint.addTaint(deliveryIntent.dsTaint);
        {
            boolean varE86D05A26E104A1B0EDAE497337FA7A3_112864503 = (TextUtils.isEmpty(destinationAddress));
            {
                throw new IllegalArgumentException("Invalid destinationAddress");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6C86A511CD0D2845B6E0259573F6A612_1063396107 = (TextUtils.isEmpty(text));
            {
                throw new IllegalArgumentException("Invalid message body");
            } //End block
        } //End collapsed parenthetic
        try 
        {
            ISms iccISms;
            iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            {
                iccISms.sendText(destinationAddress, scAddress, text, sentIntent, deliveryIntent);
            } //End block
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //if (TextUtils.isEmpty(destinationAddress)) {
            //throw new IllegalArgumentException("Invalid destinationAddress");
        //}
        //if (TextUtils.isEmpty(text)) {
            //throw new IllegalArgumentException("Invalid message body");
        //}
        //try {
            //ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            //if (iccISms != null) {
                //iccISms.sendText(destinationAddress, scAddress, text, sentIntent, deliveryIntent);
            //}
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.802 -0400", hash_original_method = "C15BF98DC594420F78E24C2D1AF66E37", hash_generated_method = "663E39B783C6A722A112717291A48C9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayList<String> divideMessage(String text) {
        dsTaint.addTaint(text);
        ArrayList<String> varD47D5CE731AE32F8E2FD8FF5BE5F4338_1064965415 = (SmsMessage.fragmentText(text));
        return (ArrayList<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return SmsMessage.fragmentText(text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.802 -0400", hash_original_method = "C9D37AD9E9C3945E93E31952A098B3F5", hash_generated_method = "7DC7AD1F425C1911EE0AA9107747FFEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendMultipartTextMessage(
            String destinationAddress, String scAddress, ArrayList<String> parts,
            ArrayList<PendingIntent> sentIntents, ArrayList<PendingIntent> deliveryIntents) {
        dsTaint.addTaint(deliveryIntents.dsTaint);
        dsTaint.addTaint(destinationAddress);
        dsTaint.addTaint(scAddress);
        dsTaint.addTaint(sentIntents.dsTaint);
        dsTaint.addTaint(parts.dsTaint);
        {
            boolean varE86D05A26E104A1B0EDAE497337FA7A3_1125418151 = (TextUtils.isEmpty(destinationAddress));
            {
                throw new IllegalArgumentException("Invalid destinationAddress");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var2E04172F06A40E8E21AAB60E7E7515E4_560252805 = (parts == null || parts.size() < 1);
            {
                throw new IllegalArgumentException("Invalid message body");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA44691181AE196D8D15FB58C9A017BC7_2017593111 = (parts.size() > 1);
            {
                try 
                {
                    ISms iccISms;
                    iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
                    {
                        iccISms.sendMultipartText(destinationAddress, scAddress, parts,
                            sentIntents, deliveryIntents);
                    } //End block
                } //End block
                catch (RemoteException ex)
                { }
            } //End block
            {
                PendingIntent sentIntent;
                sentIntent = null;
                PendingIntent deliveryIntent;
                deliveryIntent = null;
                {
                    boolean var17B4198D84E7E0C0200CE6ED7E85D95D_1087527020 = (sentIntents != null && sentIntents.size() > 0);
                    {
                        sentIntent = sentIntents.get(0);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varDD53769B99564EFCB013F3A4AE0EBDF7_1326258776 = (deliveryIntents != null && deliveryIntents.size() > 0);
                    {
                        deliveryIntent = deliveryIntents.get(0);
                    } //End block
                } //End collapsed parenthetic
                sendTextMessage(destinationAddress, scAddress, parts.get(0),
                    sentIntent, deliveryIntent);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.802 -0400", hash_original_method = "5042F246D8D2B46884C265425E52DAB1", hash_generated_method = "006E3B57A9553708CEA464DCFF4BA342")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendDataMessage(
            String destinationAddress, String scAddress, short destinationPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        dsTaint.addTaint(destinationAddress);
        dsTaint.addTaint(destinationPort);
        dsTaint.addTaint(scAddress);
        dsTaint.addTaint(data);
        dsTaint.addTaint(sentIntent.dsTaint);
        dsTaint.addTaint(deliveryIntent.dsTaint);
        {
            boolean varE86D05A26E104A1B0EDAE497337FA7A3_1356905661 = (TextUtils.isEmpty(destinationAddress));
            {
                throw new IllegalArgumentException("Invalid destinationAddress");
            } //End block
        } //End collapsed parenthetic
        {
            throw new IllegalArgumentException("Invalid message data");
        } //End block
        try 
        {
            ISms iccISms;
            iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            {
                iccISms.sendData(destinationAddress, scAddress, destinationPort & 0xFFFF,
                        data, sentIntent, deliveryIntent);
            } //End block
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //if (TextUtils.isEmpty(destinationAddress)) {
            //throw new IllegalArgumentException("Invalid destinationAddress");
        //}
        //if (data == null || data.length == 0) {
            //throw new IllegalArgumentException("Invalid message data");
        //}
        //try {
            //ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            //if (iccISms != null) {
                //iccISms.sendData(destinationAddress, scAddress, destinationPort & 0xFFFF,
                        //data, sentIntent, deliveryIntent);
            //}
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.802 -0400", hash_original_method = "90BE6788389BCE1C80031293D6D7E760", hash_generated_method = "9C1A166120752C95ACA753CF105E8926")
    public static SmsManager getDefault() {
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.802 -0400", hash_original_method = "149DCB8E596A59716D0EA3B88B730E88", hash_generated_method = "C0985EE64490310F309799EB1BCA7330")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean copyMessageToIcc(byte[] smsc, byte[] pdu, int status) {
        dsTaint.addTaint(status);
        dsTaint.addTaint(pdu);
        dsTaint.addTaint(smsc);
        boolean success;
        success = false;
        try 
        {
            ISms iccISms;
            iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            {
                success = iccISms.copyMessageToIccEf(status, pdu, smsc);
            } //End block
        } //End block
        catch (RemoteException ex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean success = false;
        //try {
            //ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            //if (iccISms != null) {
                //success = iccISms.copyMessageToIccEf(status, pdu, smsc);
            //}
        //} catch (RemoteException ex) {
        //}
        //return success;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.803 -0400", hash_original_method = "D912FCB1DFFBD3EFF004E65AAFF52944", hash_generated_method = "F3FE0B7C59BF027F99012AD5C0ADE338")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean deleteMessageFromIcc(int messageIndex) {
        dsTaint.addTaint(messageIndex);
        boolean success;
        success = false;
        byte[] pdu;
        pdu = new byte[IccConstants.SMS_RECORD_LENGTH-1];
        Arrays.fill(pdu, (byte)0xff);
        try 
        {
            ISms iccISms;
            iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            {
                success = iccISms.updateMessageOnIccEf(messageIndex, STATUS_ON_ICC_FREE, pdu);
            } //End block
        } //End block
        catch (RemoteException ex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean success = false;
        //byte[] pdu = new byte[IccConstants.SMS_RECORD_LENGTH-1];
        //Arrays.fill(pdu, (byte)0xff);
        //try {
            //ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            //if (iccISms != null) {
                //success = iccISms.updateMessageOnIccEf(messageIndex, STATUS_ON_ICC_FREE, pdu);
            //}
        //} catch (RemoteException ex) {
        //}
        //return success;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.803 -0400", hash_original_method = "E7AD2FCC9238E9621F78F9C99C389491", hash_generated_method = "A8AB2831A3BD674C4F2742C85080CFD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean updateMessageOnIcc(int messageIndex, int newStatus, byte[] pdu) {
        dsTaint.addTaint(newStatus);
        dsTaint.addTaint(pdu);
        dsTaint.addTaint(messageIndex);
        boolean success;
        success = false;
        try 
        {
            ISms iccISms;
            iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            {
                success = iccISms.updateMessageOnIccEf(messageIndex, newStatus, pdu);
            } //End block
        } //End block
        catch (RemoteException ex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean success = false;
        //try {
            //ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            //if (iccISms != null) {
                //success = iccISms.updateMessageOnIccEf(messageIndex, newStatus, pdu);
            //}
        //} catch (RemoteException ex) {
        //}
        //return success;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.803 -0400", hash_original_method = "99ADD055A9B6DECFD44D9DAC14E75079", hash_generated_method = "5AD3080B061DF3AB84D16BF1437101FC")
    public static ArrayList<SmsMessage> getAllMessagesFromIcc() {
        List<SmsRawData> records = null;
        try {
            ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            if (iccISms != null) {
                records = iccISms.getAllMessagesFromIccEf();
            }
        } catch (RemoteException ex) {
        }
        return createMessageListFromRawRecords(records);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.803 -0400", hash_original_method = "D2AB66A7ACEF0D4C8C4D01478F148AA5", hash_generated_method = "7A7D6FF6F40D988347F775C463C80014")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean enableCellBroadcast(int messageIdentifier) {
        dsTaint.addTaint(messageIdentifier);
        boolean success;
        success = false;
        try 
        {
            ISms iccISms;
            iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            {
                success = iccISms.enableCellBroadcast(messageIdentifier);
            } //End block
        } //End block
        catch (RemoteException ex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean success = false;
        //try {
            //ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            //if (iccISms != null) {
                //success = iccISms.enableCellBroadcast(messageIdentifier);
            //}
        //} catch (RemoteException ex) {
        //}
        //return success;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.803 -0400", hash_original_method = "BF7C27985ACD2C46C3E7C98C6196EF24", hash_generated_method = "7666ED7FD96B4FA7F65BF19D6EF5CD83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean disableCellBroadcast(int messageIdentifier) {
        dsTaint.addTaint(messageIdentifier);
        boolean success;
        success = false;
        try 
        {
            ISms iccISms;
            iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            {
                success = iccISms.disableCellBroadcast(messageIdentifier);
            } //End block
        } //End block
        catch (RemoteException ex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean success = false;
        //try {
            //ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            //if (iccISms != null) {
                //success = iccISms.disableCellBroadcast(messageIdentifier);
            //}
        //} catch (RemoteException ex) {
        //}
        //return success;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.803 -0400", hash_original_method = "48FE73E95EE31EEBE730A030272A67D6", hash_generated_method = "F7D9DF880289517C4D998370D681C4E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean enableCellBroadcastRange(int startMessageId, int endMessageId) {
        dsTaint.addTaint(startMessageId);
        dsTaint.addTaint(endMessageId);
        boolean success;
        success = false;
        try 
        {
            ISms iccISms;
            iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            {
                success = iccISms.enableCellBroadcastRange(startMessageId, endMessageId);
            } //End block
        } //End block
        catch (RemoteException ex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean success = false;
        //try {
            //ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            //if (iccISms != null) {
                //success = iccISms.enableCellBroadcastRange(startMessageId, endMessageId);
            //}
        //} catch (RemoteException ex) {
        //}
        //return success;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.803 -0400", hash_original_method = "528508E389FED61ADC9A70FF93AA8789", hash_generated_method = "8B6AE2E4B0B9DA879DEBA28988B896CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean disableCellBroadcastRange(int startMessageId, int endMessageId) {
        dsTaint.addTaint(startMessageId);
        dsTaint.addTaint(endMessageId);
        boolean success;
        success = false;
        try 
        {
            ISms iccISms;
            iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            {
                success = iccISms.disableCellBroadcastRange(startMessageId, endMessageId);
            } //End block
        } //End block
        catch (RemoteException ex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean success = false;
        //try {
            //ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            //if (iccISms != null) {
                //success = iccISms.disableCellBroadcastRange(startMessageId, endMessageId);
            //}
        //} catch (RemoteException ex) {
        //}
        //return success;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.804 -0400", hash_original_method = "79C62ACAD5DF9EB85CE9ACD9496D0810", hash_generated_method = "79FE88ACD8A5058CAA85B100DE623038")
    private static ArrayList<SmsMessage> createMessageListFromRawRecords(List<SmsRawData> records) {
        ArrayList<SmsMessage> messages = new ArrayList<SmsMessage>();
        if (records != null) {
            int count = records.size();
            for (int i = 0; i < count; i++) {
                SmsRawData data = records.get(i);
                if (data != null) {
                    SmsMessage sms = SmsMessage.createFromEfRecord(i+1, data.getBytes());
                    if (sms != null) {
                        messages.add(sms);
                    }
                }
            }
        }
        return messages;
    }

    
}



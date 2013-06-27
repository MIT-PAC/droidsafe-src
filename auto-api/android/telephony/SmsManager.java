package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.277 -0400", hash_original_method = "20095975633950A922641E0460F74587", hash_generated_method = "EA8DBC7FD3892C316F9DA405480D8C8E")
    private  SmsManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.278 -0400", hash_original_method = "9D6620F75021FD9E9FBB0176F1528DEF", hash_generated_method = "7E1811D6B906CF97E46B4211E9D6B548")
    public void sendTextMessage(
            String destinationAddress, String scAddress, String text,
            PendingIntent sentIntent, PendingIntent deliveryIntent) {
        {
            boolean varE86D05A26E104A1B0EDAE497337FA7A3_838446972 = (TextUtils.isEmpty(destinationAddress));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid destinationAddress");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var6C86A511CD0D2845B6E0259573F6A612_1848597473 = (TextUtils.isEmpty(text));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid message body");
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
        addTaint(destinationAddress.getTaint());
        addTaint(scAddress.getTaint());
        addTaint(text.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.283 -0400", hash_original_method = "C15BF98DC594420F78E24C2D1AF66E37", hash_generated_method = "E1E11A5D805A92420BE49E526CBB6730")
    public ArrayList<String> divideMessage(String text) {
        ArrayList<String> varB4EAC82CA7396A68D541C85D26508E83_124844066 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_124844066 = SmsMessage.fragmentText(text);
        addTaint(text.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_124844066.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_124844066;
        // ---------- Original Method ----------
        //return SmsMessage.fragmentText(text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.285 -0400", hash_original_method = "C9D37AD9E9C3945E93E31952A098B3F5", hash_generated_method = "071950A74DA21FEC8D76DF724BA12EF0")
    public void sendMultipartTextMessage(
            String destinationAddress, String scAddress, ArrayList<String> parts,
            ArrayList<PendingIntent> sentIntents, ArrayList<PendingIntent> deliveryIntents) {
        {
            boolean varE86D05A26E104A1B0EDAE497337FA7A3_660216093 = (TextUtils.isEmpty(destinationAddress));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid destinationAddress");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var2E04172F06A40E8E21AAB60E7E7515E4_1147176562 = (parts == null || parts.size() < 1);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid message body");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA44691181AE196D8D15FB58C9A017BC7_1704768156 = (parts.size() > 1);
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
                    boolean var17B4198D84E7E0C0200CE6ED7E85D95D_1287210828 = (sentIntents != null && sentIntents.size() > 0);
                    {
                        sentIntent = sentIntents.get(0);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varDD53769B99564EFCB013F3A4AE0EBDF7_2006686714 = (deliveryIntents != null && deliveryIntents.size() > 0);
                    {
                        deliveryIntent = deliveryIntents.get(0);
                    } //End block
                } //End collapsed parenthetic
                sendTextMessage(destinationAddress, scAddress, parts.get(0),
                    sentIntent, deliveryIntent);
            } //End block
        } //End collapsed parenthetic
        addTaint(destinationAddress.getTaint());
        addTaint(scAddress.getTaint());
        addTaint(parts.getTaint());
        addTaint(sentIntents.getTaint());
        addTaint(deliveryIntents.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.298 -0400", hash_original_method = "5042F246D8D2B46884C265425E52DAB1", hash_generated_method = "C39CE559C21648F753D61BB4994A80F5")
    public void sendDataMessage(
            String destinationAddress, String scAddress, short destinationPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        {
            boolean varE86D05A26E104A1B0EDAE497337FA7A3_2105227515 = (TextUtils.isEmpty(destinationAddress));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid destinationAddress");
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid message data");
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
        addTaint(destinationAddress.getTaint());
        addTaint(scAddress.getTaint());
        addTaint(destinationPort);
        addTaint(data[0]);
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
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

    
        public static SmsManager getDefault() {
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.299 -0400", hash_original_method = "149DCB8E596A59716D0EA3B88B730E88", hash_generated_method = "8817BC6092EBB011BB8E05799CB6CDD7")
    public boolean copyMessageToIcc(byte[] smsc, byte[] pdu, int status) {
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
        addTaint(smsc[0]);
        addTaint(pdu[0]);
        addTaint(status);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1996428462 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1996428462;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.300 -0400", hash_original_method = "D912FCB1DFFBD3EFF004E65AAFF52944", hash_generated_method = "2E18DC3A97636E6ED922B5F8E233EC6F")
    public boolean deleteMessageFromIcc(int messageIndex) {
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
        addTaint(messageIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1500237624 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1500237624;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.323 -0400", hash_original_method = "E7AD2FCC9238E9621F78F9C99C389491", hash_generated_method = "F846AB256F69AD1D9C1A3964D39FECF2")
    public boolean updateMessageOnIcc(int messageIndex, int newStatus, byte[] pdu) {
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
        addTaint(messageIndex);
        addTaint(newStatus);
        addTaint(pdu[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1393535530 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1393535530;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.324 -0400", hash_original_method = "D2AB66A7ACEF0D4C8C4D01478F148AA5", hash_generated_method = "E99E5778291358A44A27270A48406D75")
    public boolean enableCellBroadcast(int messageIdentifier) {
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
        addTaint(messageIdentifier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_589421199 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_589421199;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.324 -0400", hash_original_method = "BF7C27985ACD2C46C3E7C98C6196EF24", hash_generated_method = "4A0DEF17EAAD928CBB3B360150E18B3B")
    public boolean disableCellBroadcast(int messageIdentifier) {
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
        addTaint(messageIdentifier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_413187266 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_413187266;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.325 -0400", hash_original_method = "48FE73E95EE31EEBE730A030272A67D6", hash_generated_method = "267F0169303EBDA0EDDD209E18EF8061")
    public boolean enableCellBroadcastRange(int startMessageId, int endMessageId) {
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
        addTaint(startMessageId);
        addTaint(endMessageId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1825721996 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1825721996;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.326 -0400", hash_original_method = "528508E389FED61ADC9A70FF93AA8789", hash_generated_method = "97B2898082126FC6B39D10B00B4B50EC")
    public boolean disableCellBroadcastRange(int startMessageId, int endMessageId) {
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
        addTaint(startMessageId);
        addTaint(endMessageId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_266940388 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_266940388;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.327 -0400", hash_original_field = "8533F80B54668A16EAB35508675A0050", hash_generated_field = "8D2E6D84F263F9FD3A9DB4F4FAD2A9CB")

    private static SmsManager sInstance = new SmsManager();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.327 -0400", hash_original_field = "E0656224466B767339BF3B0AD72E7607", hash_generated_field = "279FAF45830B69E17F6A0898B6D117D0")

    static public final int STATUS_ON_ICC_FREE      = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.327 -0400", hash_original_field = "D6DE9CFACC1E907D1ACA6ACB9FE9B1FE", hash_generated_field = "00BACFAD7A3200CC928AC8BD98BBA6EC")

    static public final int STATUS_ON_ICC_READ      = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.327 -0400", hash_original_field = "39E0419B5B42D998DB7EBB1C9B8F68F2", hash_generated_field = "2C5348D548EDFCA8E280127B8158C082")

    static public final int STATUS_ON_ICC_UNREAD    = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.327 -0400", hash_original_field = "A217792F7E24DD56C47D1F033DBCE9FD", hash_generated_field = "BD9F93947F03C611A4A8E88B7B512A07")

    static public final int STATUS_ON_ICC_SENT      = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.327 -0400", hash_original_field = "4705F3860D7365D8DB379BE8BDBE979F", hash_generated_field = "5B255A810A40F44F9F9F38AF79FDDD7D")

    static public final int STATUS_ON_ICC_UNSENT    = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.327 -0400", hash_original_field = "C8D415E2C4D7FEBB26853D2D5C7F39E5", hash_generated_field = "24A2E3A5366B6AB7377EC7C02D71C607")

    static public final int RESULT_ERROR_GENERIC_FAILURE    = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.327 -0400", hash_original_field = "06BBE9509813679846A46BD6E96826F0", hash_generated_field = "78693EA6263B78B03E23201FC00BCB05")

    static public final int RESULT_ERROR_RADIO_OFF          = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.327 -0400", hash_original_field = "843A178824EC8D6E096E8CE0A7EEEF71", hash_generated_field = "158133D9027A00583E016D1C53F6B144")

    static public final int RESULT_ERROR_NULL_PDU           = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.327 -0400", hash_original_field = "5E78E4CB8378DC5FCB9CFE7C9AC2355F", hash_generated_field = "E72951F6A9AF440FD4C872FCF4A49FF0")

    static public final int RESULT_ERROR_NO_SERVICE         = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.327 -0400", hash_original_field = "901628958E82A13F429A040FEEDECFC5", hash_generated_field = "18E101E1D73C57D8B643B40625F78BC7")

    static public final int RESULT_ERROR_LIMIT_EXCEEDED     = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:37.327 -0400", hash_original_field = "E41C2D9A2D3D616B35AA3462D6DD9D55", hash_generated_field = "6144D456FFACE1B39473F88B869D90C0")

    static public final int RESULT_ERROR_FDN_CHECK_FAILURE  = 6;
}


package android.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.474 -0400", hash_original_method = "20095975633950A922641E0460F74587", hash_generated_method = "EA8DBC7FD3892C316F9DA405480D8C8E")
    private  SmsManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.475 -0400", hash_original_method = "9D6620F75021FD9E9FBB0176F1528DEF", hash_generated_method = "C367D1A8E7C9E4E6D33C26D82FACCFA9")
    public void sendTextMessage(
            String destinationAddress, String scAddress, String text,
            PendingIntent sentIntent, PendingIntent deliveryIntent) {
        addTaint(deliveryIntent.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(text.getTaint());
        addTaint(scAddress.getTaint());
        addTaint(destinationAddress.getTaint());
    if(TextUtils.isEmpty(destinationAddress))        
        {
            IllegalArgumentException varB42BCA9F84EFE865520615EB774F2C73_952329134 = new IllegalArgumentException("Invalid destinationAddress");
            varB42BCA9F84EFE865520615EB774F2C73_952329134.addTaint(taint);
            throw varB42BCA9F84EFE865520615EB774F2C73_952329134;
        } //End block
    if(TextUtils.isEmpty(text))        
        {
            IllegalArgumentException var76F1D777251ACBD5299883F4E21EA031_1475084043 = new IllegalArgumentException("Invalid message body");
            var76F1D777251ACBD5299883F4E21EA031_1475084043.addTaint(taint);
            throw var76F1D777251ACBD5299883F4E21EA031_1475084043;
        } //End block
        try 
        {
            ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
    if(iccISms != null)            
            {
                iccISms.sendText(destinationAddress, scAddress, text, sentIntent, deliveryIntent);
            } //End block
        } //End block
        catch (RemoteException ex)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.475 -0400", hash_original_method = "C15BF98DC594420F78E24C2D1AF66E37", hash_generated_method = "61591A2A253AC1EFB9B3B5D6F172AB99")
    public ArrayList<String> divideMessage(String text) {
        addTaint(text.getTaint());
ArrayList<String> var385443288FCC3765E7177723CA8956F8_67906355 =         SmsMessage.fragmentText(text);
        var385443288FCC3765E7177723CA8956F8_67906355.addTaint(taint);
        return var385443288FCC3765E7177723CA8956F8_67906355;
        // ---------- Original Method ----------
        //return SmsMessage.fragmentText(text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.476 -0400", hash_original_method = "C9D37AD9E9C3945E93E31952A098B3F5", hash_generated_method = "6CB7479CC23655B9933EFB7F87FD46AD")
    public void sendMultipartTextMessage(
            String destinationAddress, String scAddress, ArrayList<String> parts,
            ArrayList<PendingIntent> sentIntents, ArrayList<PendingIntent> deliveryIntents) {
        addTaint(deliveryIntents.getTaint());
        addTaint(sentIntents.getTaint());
        addTaint(parts.getTaint());
        addTaint(scAddress.getTaint());
        addTaint(destinationAddress.getTaint());
    if(TextUtils.isEmpty(destinationAddress))        
        {
            IllegalArgumentException varB42BCA9F84EFE865520615EB774F2C73_1083870194 = new IllegalArgumentException("Invalid destinationAddress");
            varB42BCA9F84EFE865520615EB774F2C73_1083870194.addTaint(taint);
            throw varB42BCA9F84EFE865520615EB774F2C73_1083870194;
        } //End block
    if(parts == null || parts.size() < 1)        
        {
            IllegalArgumentException var76F1D777251ACBD5299883F4E21EA031_503762929 = new IllegalArgumentException("Invalid message body");
            var76F1D777251ACBD5299883F4E21EA031_503762929.addTaint(taint);
            throw var76F1D777251ACBD5299883F4E21EA031_503762929;
        } //End block
    if(parts.size() > 1)        
        {
            try 
            {
                ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
    if(iccISms != null)                
                {
                    iccISms.sendMultipartText(destinationAddress, scAddress, parts,
                            sentIntents, deliveryIntents);
                } //End block
            } //End block
            catch (RemoteException ex)
            {
            } //End block
        } //End block
        else
        {
            PendingIntent sentIntent = null;
            PendingIntent deliveryIntent = null;
    if(sentIntents != null && sentIntents.size() > 0)            
            {
                sentIntent = sentIntents.get(0);
            } //End block
    if(deliveryIntents != null && deliveryIntents.size() > 0)            
            {
                deliveryIntent = deliveryIntents.get(0);
            } //End block
            sendTextMessage(destinationAddress, scAddress, parts.get(0),
                    sentIntent, deliveryIntent);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.477 -0400", hash_original_method = "5042F246D8D2B46884C265425E52DAB1", hash_generated_method = "39472F39D44C6211411D2F9A9BCB7C33")
    public void sendDataMessage(
            String destinationAddress, String scAddress, short destinationPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        addTaint(deliveryIntent.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(data[0]);
        addTaint(destinationPort);
        addTaint(scAddress.getTaint());
        addTaint(destinationAddress.getTaint());
    if(TextUtils.isEmpty(destinationAddress))        
        {
            IllegalArgumentException varB42BCA9F84EFE865520615EB774F2C73_567653370 = new IllegalArgumentException("Invalid destinationAddress");
            varB42BCA9F84EFE865520615EB774F2C73_567653370.addTaint(taint);
            throw varB42BCA9F84EFE865520615EB774F2C73_567653370;
        } //End block
    if(data == null || data.length == 0)        
        {
            IllegalArgumentException var289B04CD7DC8DEB1C167AAE9F10470FD_1810711423 = new IllegalArgumentException("Invalid message data");
            var289B04CD7DC8DEB1C167AAE9F10470FD_1810711423.addTaint(taint);
            throw var289B04CD7DC8DEB1C167AAE9F10470FD_1810711423;
        } //End block
        try 
        {
            ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
    if(iccISms != null)            
            {
                iccISms.sendData(destinationAddress, scAddress, destinationPort & 0xFFFF,
                        data, sentIntent, deliveryIntent);
            } //End block
        } //End block
        catch (RemoteException ex)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.478 -0400", hash_original_method = "149DCB8E596A59716D0EA3B88B730E88", hash_generated_method = "CB5F6FCC48E149640F37B7649735EC8B")
    public boolean copyMessageToIcc(byte[] smsc, byte[] pdu, int status) {
        addTaint(status);
        addTaint(pdu[0]);
        addTaint(smsc[0]);
        boolean success = false;
        try 
        {
            ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
    if(iccISms != null)            
            {
                success = iccISms.copyMessageToIccEf(status, pdu, smsc);
            } //End block
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        boolean var260CA9DD8A4577FC00B7BD5810298076_437576262 = (success);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1130195240 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1130195240;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.478 -0400", hash_original_method = "D912FCB1DFFBD3EFF004E65AAFF52944", hash_generated_method = "32930FA0877CF738E4DFD0949656DEFE")
    public boolean deleteMessageFromIcc(int messageIndex) {
        addTaint(messageIndex);
        boolean success = false;
        byte[] pdu = new byte[IccConstants.SMS_RECORD_LENGTH-1];
        Arrays.fill(pdu, (byte)0xff);
        try 
        {
            ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
    if(iccISms != null)            
            {
                success = iccISms.updateMessageOnIccEf(messageIndex, STATUS_ON_ICC_FREE, pdu);
            } //End block
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        boolean var260CA9DD8A4577FC00B7BD5810298076_1935479353 = (success);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1001705026 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1001705026;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.479 -0400", hash_original_method = "E7AD2FCC9238E9621F78F9C99C389491", hash_generated_method = "009281C718119BD9A823428474F29C47")
    public boolean updateMessageOnIcc(int messageIndex, int newStatus, byte[] pdu) {
        addTaint(pdu[0]);
        addTaint(newStatus);
        addTaint(messageIndex);
        boolean success = false;
        try 
        {
            ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
    if(iccISms != null)            
            {
                success = iccISms.updateMessageOnIccEf(messageIndex, newStatus, pdu);
            } //End block
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        boolean var260CA9DD8A4577FC00B7BD5810298076_1874285331 = (success);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1050526755 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1050526755;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.480 -0400", hash_original_method = "D2AB66A7ACEF0D4C8C4D01478F148AA5", hash_generated_method = "A0CC6746FCEAB223D1A447CB68D0278B")
    public boolean enableCellBroadcast(int messageIdentifier) {
        addTaint(messageIdentifier);
        boolean success = false;
        try 
        {
            ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
    if(iccISms != null)            
            {
                success = iccISms.enableCellBroadcast(messageIdentifier);
            } //End block
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        boolean var260CA9DD8A4577FC00B7BD5810298076_1436565752 = (success);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_702304396 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_702304396;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.480 -0400", hash_original_method = "BF7C27985ACD2C46C3E7C98C6196EF24", hash_generated_method = "29E7A83BD81125028D8679C3B61053F3")
    public boolean disableCellBroadcast(int messageIdentifier) {
        addTaint(messageIdentifier);
        boolean success = false;
        try 
        {
            ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
    if(iccISms != null)            
            {
                success = iccISms.disableCellBroadcast(messageIdentifier);
            } //End block
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        boolean var260CA9DD8A4577FC00B7BD5810298076_1456859811 = (success);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_832718011 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_832718011;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.481 -0400", hash_original_method = "48FE73E95EE31EEBE730A030272A67D6", hash_generated_method = "501137E955C308E9F7368068C24F3852")
    public boolean enableCellBroadcastRange(int startMessageId, int endMessageId) {
        addTaint(endMessageId);
        addTaint(startMessageId);
        boolean success = false;
        try 
        {
            ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
    if(iccISms != null)            
            {
                success = iccISms.enableCellBroadcastRange(startMessageId, endMessageId);
            } //End block
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        boolean var260CA9DD8A4577FC00B7BD5810298076_580471993 = (success);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_862273498 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_862273498;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.481 -0400", hash_original_method = "528508E389FED61ADC9A70FF93AA8789", hash_generated_method = "CBEE8F7F96BB5C6585015F66C899A0BF")
    public boolean disableCellBroadcastRange(int startMessageId, int endMessageId) {
        addTaint(endMessageId);
        addTaint(startMessageId);
        boolean success = false;
        try 
        {
            ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
    if(iccISms != null)            
            {
                success = iccISms.disableCellBroadcastRange(startMessageId, endMessageId);
            } //End block
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        boolean var260CA9DD8A4577FC00B7BD5810298076_555099476 = (success);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1485711505 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1485711505;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.482 -0400", hash_original_field = "8533F80B54668A16EAB35508675A0050", hash_generated_field = "582D84745AFAA3A0DFEECEB994BD5990")

    private static final SmsManager sInstance = new SmsManager();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.482 -0400", hash_original_field = "E0656224466B767339BF3B0AD72E7607", hash_generated_field = "279FAF45830B69E17F6A0898B6D117D0")

    static public final int STATUS_ON_ICC_FREE      = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.482 -0400", hash_original_field = "D6DE9CFACC1E907D1ACA6ACB9FE9B1FE", hash_generated_field = "00BACFAD7A3200CC928AC8BD98BBA6EC")

    static public final int STATUS_ON_ICC_READ      = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.482 -0400", hash_original_field = "39E0419B5B42D998DB7EBB1C9B8F68F2", hash_generated_field = "2C5348D548EDFCA8E280127B8158C082")

    static public final int STATUS_ON_ICC_UNREAD    = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.482 -0400", hash_original_field = "A217792F7E24DD56C47D1F033DBCE9FD", hash_generated_field = "BD9F93947F03C611A4A8E88B7B512A07")

    static public final int STATUS_ON_ICC_SENT      = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.482 -0400", hash_original_field = "4705F3860D7365D8DB379BE8BDBE979F", hash_generated_field = "5B255A810A40F44F9F9F38AF79FDDD7D")

    static public final int STATUS_ON_ICC_UNSENT    = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.482 -0400", hash_original_field = "C8D415E2C4D7FEBB26853D2D5C7F39E5", hash_generated_field = "24A2E3A5366B6AB7377EC7C02D71C607")

    static public final int RESULT_ERROR_GENERIC_FAILURE    = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.482 -0400", hash_original_field = "06BBE9509813679846A46BD6E96826F0", hash_generated_field = "78693EA6263B78B03E23201FC00BCB05")

    static public final int RESULT_ERROR_RADIO_OFF          = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.482 -0400", hash_original_field = "843A178824EC8D6E096E8CE0A7EEEF71", hash_generated_field = "158133D9027A00583E016D1C53F6B144")

    static public final int RESULT_ERROR_NULL_PDU           = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.482 -0400", hash_original_field = "5E78E4CB8378DC5FCB9CFE7C9AC2355F", hash_generated_field = "E72951F6A9AF440FD4C872FCF4A49FF0")

    static public final int RESULT_ERROR_NO_SERVICE         = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.482 -0400", hash_original_field = "901628958E82A13F429A040FEEDECFC5", hash_generated_field = "18E101E1D73C57D8B643B40625F78BC7")

    static public final int RESULT_ERROR_LIMIT_EXCEEDED     = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.482 -0400", hash_original_field = "E41C2D9A2D3D616B35AA3462D6DD9D55", hash_generated_field = "6144D456FFACE1B39473F88B869D90C0")

    static public final int RESULT_ERROR_FDN_CHECK_FAILURE  = 6;
}


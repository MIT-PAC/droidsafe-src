package android.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.171 -0400", hash_original_method = "20095975633950A922641E0460F74587", hash_generated_method = "EA8DBC7FD3892C316F9DA405480D8C8E")
    private  SmsManager() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.172 -0400", hash_original_method = "9D6620F75021FD9E9FBB0176F1528DEF", hash_generated_method = "E578DA67A4B771C7899F48578D7D492E")
    public void sendTextMessage(
            String destinationAddress, String scAddress, String text,
            PendingIntent sentIntent, PendingIntent deliveryIntent) {
        {
            boolean varE86D05A26E104A1B0EDAE497337FA7A3_1842815611 = (TextUtils.isEmpty(destinationAddress));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid destinationAddress");
            } 
        } 
        {
            boolean var6C86A511CD0D2845B6E0259573F6A612_773131341 = (TextUtils.isEmpty(text));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid message body");
            } 
        } 
        try 
        {
            ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            {
                iccISms.sendText(destinationAddress, scAddress, text, sentIntent, deliveryIntent);
            } 
        } 
        catch (RemoteException ex)
        { }
        addTaint(destinationAddress.getTaint());
        addTaint(scAddress.getTaint());
        addTaint(text.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
        
        
            
        
        
            
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.172 -0400", hash_original_method = "C15BF98DC594420F78E24C2D1AF66E37", hash_generated_method = "A45C8C9EE8A8AD75CEF0EB7AB87110CA")
    public ArrayList<String> divideMessage(String text) {
        ArrayList<String> varB4EAC82CA7396A68D541C85D26508E83_661418606 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_661418606 = SmsMessage.fragmentText(text);
        addTaint(text.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_661418606.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_661418606;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.173 -0400", hash_original_method = "C9D37AD9E9C3945E93E31952A098B3F5", hash_generated_method = "BFEA3232853A985294926D1312CC67E1")
    public void sendMultipartTextMessage(
            String destinationAddress, String scAddress, ArrayList<String> parts,
            ArrayList<PendingIntent> sentIntents, ArrayList<PendingIntent> deliveryIntents) {
        {
            boolean varE86D05A26E104A1B0EDAE497337FA7A3_180425073 = (TextUtils.isEmpty(destinationAddress));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid destinationAddress");
            } 
        } 
        {
            boolean var2E04172F06A40E8E21AAB60E7E7515E4_1932965873 = (parts == null || parts.size() < 1);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid message body");
            } 
        } 
        {
            boolean varA44691181AE196D8D15FB58C9A017BC7_875359832 = (parts.size() > 1);
            {
                try 
                {
                    ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
                    {
                        iccISms.sendMultipartText(destinationAddress, scAddress, parts,
                            sentIntents, deliveryIntents);
                    } 
                } 
                catch (RemoteException ex)
                { }
            } 
            {
                PendingIntent sentIntent = null;
                PendingIntent deliveryIntent = null;
                {
                    boolean var17B4198D84E7E0C0200CE6ED7E85D95D_1094004290 = (sentIntents != null && sentIntents.size() > 0);
                    {
                        sentIntent = sentIntents.get(0);
                    } 
                } 
                {
                    boolean varDD53769B99564EFCB013F3A4AE0EBDF7_1006638045 = (deliveryIntents != null && deliveryIntents.size() > 0);
                    {
                        deliveryIntent = deliveryIntents.get(0);
                    } 
                } 
                sendTextMessage(destinationAddress, scAddress, parts.get(0),
                    sentIntent, deliveryIntent);
            } 
        } 
        addTaint(destinationAddress.getTaint());
        addTaint(scAddress.getTaint());
        addTaint(parts.getTaint());
        addTaint(sentIntents.getTaint());
        addTaint(deliveryIntents.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.174 -0400", hash_original_method = "5042F246D8D2B46884C265425E52DAB1", hash_generated_method = "250D60A215C459DC8F39143050B15AD2")
    public void sendDataMessage(
            String destinationAddress, String scAddress, short destinationPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        {
            boolean varE86D05A26E104A1B0EDAE497337FA7A3_326370365 = (TextUtils.isEmpty(destinationAddress));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid destinationAddress");
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid message data");
        } 
        try 
        {
            ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            {
                iccISms.sendData(destinationAddress, scAddress, destinationPort & 0xFFFF,
                        data, sentIntent, deliveryIntent);
            } 
        } 
        catch (RemoteException ex)
        { }
        addTaint(destinationAddress.getTaint());
        addTaint(scAddress.getTaint());
        addTaint(destinationPort);
        addTaint(data[0]);
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
        
        
            
        
        
            
        
        
            
            
                
                        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static SmsManager getDefault() {
        return sInstance;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.175 -0400", hash_original_method = "149DCB8E596A59716D0EA3B88B730E88", hash_generated_method = "39D08B5FAADA1F9F9470BFEE41762BA4")
    public boolean copyMessageToIcc(byte[] smsc, byte[] pdu, int status) {
        boolean success = false;
        try 
        {
            ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            {
                success = iccISms.copyMessageToIccEf(status, pdu, smsc);
            } 
        } 
        catch (RemoteException ex)
        { }
        addTaint(smsc[0]);
        addTaint(pdu[0]);
        addTaint(status);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_626770608 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_626770608;
        
        
        
            
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.175 -0400", hash_original_method = "D912FCB1DFFBD3EFF004E65AAFF52944", hash_generated_method = "25851F19E42CF9603F4B5F8402161285")
    public boolean deleteMessageFromIcc(int messageIndex) {
        boolean success = false;
        byte[] pdu = new byte[IccConstants.SMS_RECORD_LENGTH-1];
        Arrays.fill(pdu, (byte)0xff);
        try 
        {
            ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            {
                success = iccISms.updateMessageOnIccEf(messageIndex, STATUS_ON_ICC_FREE, pdu);
            } 
        } 
        catch (RemoteException ex)
        { }
        addTaint(messageIndex);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_145931089 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_145931089;
        
        
        
        
        
            
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.176 -0400", hash_original_method = "E7AD2FCC9238E9621F78F9C99C389491", hash_generated_method = "ED45832214175BF7CF83D0ED88C0F432")
    public boolean updateMessageOnIcc(int messageIndex, int newStatus, byte[] pdu) {
        boolean success = false;
        try 
        {
            ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            {
                success = iccISms.updateMessageOnIccEf(messageIndex, newStatus, pdu);
            } 
        } 
        catch (RemoteException ex)
        { }
        addTaint(messageIndex);
        addTaint(newStatus);
        addTaint(pdu[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1333521767 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1333521767;
        
        
        
            
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.177 -0400", hash_original_method = "D2AB66A7ACEF0D4C8C4D01478F148AA5", hash_generated_method = "845CAB302B82862974DA2142C6ABA884")
    public boolean enableCellBroadcast(int messageIdentifier) {
        boolean success = false;
        try 
        {
            ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            {
                success = iccISms.enableCellBroadcast(messageIdentifier);
            } 
        } 
        catch (RemoteException ex)
        { }
        addTaint(messageIdentifier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_114410069 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_114410069;
        
        
        
            
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.177 -0400", hash_original_method = "BF7C27985ACD2C46C3E7C98C6196EF24", hash_generated_method = "D0BE78D973A2DA08834446CB1A98B3D1")
    public boolean disableCellBroadcast(int messageIdentifier) {
        boolean success = false;
        try 
        {
            ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            {
                success = iccISms.disableCellBroadcast(messageIdentifier);
            } 
        } 
        catch (RemoteException ex)
        { }
        addTaint(messageIdentifier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1617005533 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1617005533;
        
        
        
            
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.178 -0400", hash_original_method = "48FE73E95EE31EEBE730A030272A67D6", hash_generated_method = "5A64666C19245E8970E41168AD633E8F")
    public boolean enableCellBroadcastRange(int startMessageId, int endMessageId) {
        boolean success = false;
        try 
        {
            ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            {
                success = iccISms.enableCellBroadcastRange(startMessageId, endMessageId);
            } 
        } 
        catch (RemoteException ex)
        { }
        addTaint(startMessageId);
        addTaint(endMessageId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1427617651 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1427617651;
        
        
        
            
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.178 -0400", hash_original_method = "528508E389FED61ADC9A70FF93AA8789", hash_generated_method = "C5D957FA8C8C816C55D9B172BDF085CB")
    public boolean disableCellBroadcastRange(int startMessageId, int endMessageId) {
        boolean success = false;
        try 
        {
            ISms iccISms = ISms.Stub.asInterface(ServiceManager.getService("isms"));
            {
                success = iccISms.disableCellBroadcastRange(startMessageId, endMessageId);
            } 
        } 
        catch (RemoteException ex)
        { }
        addTaint(startMessageId);
        addTaint(endMessageId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_287238912 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_287238912;
        
        
        
            
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.178 -0400", hash_original_field = "8533F80B54668A16EAB35508675A0050", hash_generated_field = "582D84745AFAA3A0DFEECEB994BD5990")

    private static final SmsManager sInstance = new SmsManager();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.178 -0400", hash_original_field = "E0656224466B767339BF3B0AD72E7607", hash_generated_field = "279FAF45830B69E17F6A0898B6D117D0")

    static public final int STATUS_ON_ICC_FREE      = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.178 -0400", hash_original_field = "D6DE9CFACC1E907D1ACA6ACB9FE9B1FE", hash_generated_field = "00BACFAD7A3200CC928AC8BD98BBA6EC")

    static public final int STATUS_ON_ICC_READ      = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.178 -0400", hash_original_field = "39E0419B5B42D998DB7EBB1C9B8F68F2", hash_generated_field = "2C5348D548EDFCA8E280127B8158C082")

    static public final int STATUS_ON_ICC_UNREAD    = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.178 -0400", hash_original_field = "A217792F7E24DD56C47D1F033DBCE9FD", hash_generated_field = "BD9F93947F03C611A4A8E88B7B512A07")

    static public final int STATUS_ON_ICC_SENT      = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.178 -0400", hash_original_field = "4705F3860D7365D8DB379BE8BDBE979F", hash_generated_field = "5B255A810A40F44F9F9F38AF79FDDD7D")

    static public final int STATUS_ON_ICC_UNSENT    = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.178 -0400", hash_original_field = "C8D415E2C4D7FEBB26853D2D5C7F39E5", hash_generated_field = "24A2E3A5366B6AB7377EC7C02D71C607")

    static public final int RESULT_ERROR_GENERIC_FAILURE    = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.178 -0400", hash_original_field = "06BBE9509813679846A46BD6E96826F0", hash_generated_field = "78693EA6263B78B03E23201FC00BCB05")

    static public final int RESULT_ERROR_RADIO_OFF          = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.178 -0400", hash_original_field = "843A178824EC8D6E096E8CE0A7EEEF71", hash_generated_field = "158133D9027A00583E016D1C53F6B144")

    static public final int RESULT_ERROR_NULL_PDU           = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.178 -0400", hash_original_field = "5E78E4CB8378DC5FCB9CFE7C9AC2355F", hash_generated_field = "E72951F6A9AF440FD4C872FCF4A49FF0")

    static public final int RESULT_ERROR_NO_SERVICE         = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.178 -0400", hash_original_field = "901628958E82A13F429A040FEEDECFC5", hash_generated_field = "18E101E1D73C57D8B643B40625F78BC7")

    static public final int RESULT_ERROR_LIMIT_EXCEEDED     = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:48.178 -0400", hash_original_field = "E41C2D9A2D3D616B35AA3462D6DD9D55", hash_generated_field = "6144D456FFACE1B39473F88B869D90C0")

    static public final int RESULT_ERROR_FDN_CHECK_FAILURE  = 6;
}


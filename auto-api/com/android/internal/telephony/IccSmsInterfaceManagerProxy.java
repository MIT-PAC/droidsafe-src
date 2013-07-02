package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.app.PendingIntent;
import android.os.ServiceManager;
import java.util.List;

public class IccSmsInterfaceManagerProxy extends ISms.Stub {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.127 -0400", hash_original_field = "A52A97EEB96E996624E6BA1BFF24DA17", hash_generated_field = "4B2DE1FC1C2E4C5A8A18A1F711193C46")

    private IccSmsInterfaceManager mIccSmsInterfaceManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.128 -0400", hash_original_method = "93AA6BF164B05EF7A7122BD605AACB07", hash_generated_method = "28BC12CCB21F3404EF3186553175718D")
    public  IccSmsInterfaceManagerProxy(IccSmsInterfaceManager
            iccSmsInterfaceManager) {
        this.mIccSmsInterfaceManager = iccSmsInterfaceManager;
        {
            boolean var57CA35B873E1E62AB02C8E6DC3FE6622_960686537 = (ServiceManager.getService("isms") == null);
            {
                ServiceManager.addService("isms", this);
            } 
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.128 -0400", hash_original_method = "671E1905A4ABBFEC9E8C5B4CD14B64F9", hash_generated_method = "084F97C58E7BDCADFF8AD86DFAC8FD32")
    public void setmIccSmsInterfaceManager(IccSmsInterfaceManager iccSmsInterfaceManager) {
        this.mIccSmsInterfaceManager = iccSmsInterfaceManager;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.128 -0400", hash_original_method = "DC12853B6F5A9BF9A9AEF133DEC97096", hash_generated_method = "63038CCA26B2439B543A38F39BBD7536")
    public boolean updateMessageOnIccEf(int index, int status, byte[] pdu) throws android.os.RemoteException {
        boolean var6B4D35D9CFA3119C6143FB160A056127_2113807736 = (mIccSmsInterfaceManager.updateMessageOnIccEf(index, status, pdu));
        addTaint(index);
        addTaint(status);
        addTaint(pdu[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_811435054 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_811435054;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.128 -0400", hash_original_method = "A12926ED612F9F1CC0852D606D3EA5CE", hash_generated_method = "705934577273DAFD62DB78F3E99E1FB1")
    public boolean copyMessageToIccEf(int status, byte[] pdu,
            byte[] smsc) throws android.os.RemoteException {
        boolean varADC5A2F9D2035B5448948A7EC2C3D9FB_1026835756 = (mIccSmsInterfaceManager.copyMessageToIccEf(status, pdu, smsc));
        addTaint(status);
        addTaint(pdu[0]);
        addTaint(smsc[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2119910755 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2119910755;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.129 -0400", hash_original_method = "6F960BE075575D7400653ACEFE5617FE", hash_generated_method = "67F1E139B4EE25AE77A0A716F54160E5")
    public List<SmsRawData> getAllMessagesFromIccEf() throws android.os.RemoteException {
        List<SmsRawData> varB4EAC82CA7396A68D541C85D26508E83_1857876544 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1857876544 = mIccSmsInterfaceManager.getAllMessagesFromIccEf();
        varB4EAC82CA7396A68D541C85D26508E83_1857876544.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1857876544;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.129 -0400", hash_original_method = "E01EFF7504F6F5A7F2409B5C1751CC43", hash_generated_method = "D3B89184B29A52A8C2111201F0A0283D")
    public void sendData(String destAddr, String scAddr, int destPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        mIccSmsInterfaceManager.sendData(destAddr, scAddr, destPort, data,
                sentIntent, deliveryIntent);
        addTaint(destAddr.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(destPort);
        addTaint(data[0]);
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.129 -0400", hash_original_method = "D48A5BF0B94B8EDA7081204D0BFF762D", hash_generated_method = "AEDE4EBEA5775D4A1794F54FEF3C303B")
    public void sendText(String destAddr, String scAddr,
            String text, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        mIccSmsInterfaceManager.sendText(destAddr, scAddr, text, sentIntent, deliveryIntent);
        addTaint(destAddr.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(text.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.130 -0400", hash_original_method = "0281C03B46D163678105B9E0741ABCE4", hash_generated_method = "E673206869801DB63A94155BC395A320")
    public void sendMultipartText(String destAddr, String scAddr,
            List<String> parts, List<PendingIntent> sentIntents,
            List<PendingIntent> deliveryIntents) throws android.os.RemoteException {
        mIccSmsInterfaceManager.sendMultipartText(destAddr, scAddr,
                parts, sentIntents, deliveryIntents);
        addTaint(destAddr.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(parts.getTaint());
        addTaint(sentIntents.getTaint());
        addTaint(deliveryIntents.getTaint());
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.130 -0400", hash_original_method = "5D02A742FEB89A51A662A78F91F83EB2", hash_generated_method = "69AE6E1BFA6530784AC08537AE2B880D")
    public boolean enableCellBroadcast(int messageIdentifier) throws android.os.RemoteException {
        boolean varA45658559D2C8AE52393A109A76EAA2E_1555843465 = (mIccSmsInterfaceManager.enableCellBroadcast(messageIdentifier));
        addTaint(messageIdentifier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_586749473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_586749473;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.130 -0400", hash_original_method = "C80EBC5BA55DC936FFC43EB47C1044D2", hash_generated_method = "9E00F16B424A371D57F32FB5B79468BD")
    public boolean disableCellBroadcast(int messageIdentifier) throws android.os.RemoteException {
        boolean var64D5F95156F520A346F2DFFA1E4E3238_1082543193 = (mIccSmsInterfaceManager.disableCellBroadcast(messageIdentifier));
        addTaint(messageIdentifier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1189980186 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1189980186;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.130 -0400", hash_original_method = "77C7447F884D58462B45A73E9887417A", hash_generated_method = "C1A1CC40AFF38CCF2B598221370818D2")
    public boolean enableCellBroadcastRange(int startMessageId, int endMessageId) throws android.os.RemoteException {
        boolean varE9B30095FEC7EB5EE7A835C933C1CB77_2042440401 = (mIccSmsInterfaceManager.enableCellBroadcastRange(startMessageId, endMessageId));
        addTaint(startMessageId);
        addTaint(endMessageId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1662080571 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1662080571;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:23.130 -0400", hash_original_method = "D3E78DE7F13EEAAE236D37E8C5EE46B7", hash_generated_method = "12A933384A37F0005A3DD3E6BEB9AC67")
    public boolean disableCellBroadcastRange(int startMessageId, int endMessageId) throws android.os.RemoteException {
        boolean varD8178CF37E2D825B7B50E7AE9EDDA962_641330282 = (mIccSmsInterfaceManager.disableCellBroadcastRange(startMessageId, endMessageId));
        addTaint(startMessageId);
        addTaint(endMessageId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_342902605 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_342902605;
        
        
    }

    
}


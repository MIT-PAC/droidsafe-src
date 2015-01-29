package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.List;

import android.app.PendingIntent;
import android.os.ServiceManager;

public class IccSmsInterfaceManagerProxy extends ISms.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.297 -0500", hash_original_field = "9E36679ECE5D70992137A1A78E7C1D66", hash_generated_field = "4B2DE1FC1C2E4C5A8A18A1F711193C46")

    private IccSmsInterfaceManager mIccSmsInterfaceManager;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.300 -0500", hash_original_method = "93AA6BF164B05EF7A7122BD605AACB07", hash_generated_method = "6CFCE5EE66CACDEA25B6BCBCE624C06F")
    
public IccSmsInterfaceManagerProxy(IccSmsInterfaceManager
            iccSmsInterfaceManager) {
        this.mIccSmsInterfaceManager = iccSmsInterfaceManager;
        if(ServiceManager.getService("isms") == null) {
            ServiceManager.addService("isms", this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.302 -0500", hash_original_method = "671E1905A4ABBFEC9E8C5B4CD14B64F9", hash_generated_method = "F677C967872A6AD08A865F47495459D3")
    
public void setmIccSmsInterfaceManager(IccSmsInterfaceManager iccSmsInterfaceManager) {
        this.mIccSmsInterfaceManager = iccSmsInterfaceManager;
    }

    @DSSink({DSSinkKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.305 -0500", hash_original_method = "DC12853B6F5A9BF9A9AEF133DEC97096", hash_generated_method = "445B46A34CC6E164EE26F6F3B9CD34CD")
    
public boolean
    updateMessageOnIccEf(int index, int status, byte[] pdu) throws android.os.RemoteException {
         return mIccSmsInterfaceManager.updateMessageOnIccEf(index, status, pdu);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.307 -0500", hash_original_method = "A12926ED612F9F1CC0852D606D3EA5CE", hash_generated_method = "5A63B3FD26283497BA17C64ABB079CAB")
    
public boolean copyMessageToIccEf(int status, byte[] pdu,
            byte[] smsc) throws android.os.RemoteException {
        return mIccSmsInterfaceManager.copyMessageToIccEf(status, pdu, smsc);
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.309 -0500", hash_original_method = "6F960BE075575D7400653ACEFE5617FE", hash_generated_method = "3EE3342D94CCAF39D397AD1D6B31B932")
    
public List<SmsRawData> getAllMessagesFromIccEf() throws android.os.RemoteException {
        return mIccSmsInterfaceManager.getAllMessagesFromIccEf();
    }

    @DSSink({DSSinkKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.311 -0500", hash_original_method = "E01EFF7504F6F5A7F2409B5C1751CC43", hash_generated_method = "9B73C596BA767192D5A40129451A2777")
    
public void sendData(String destAddr, String scAddr, int destPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        mIccSmsInterfaceManager.sendData(destAddr, scAddr, destPort, data,
                sentIntent, deliveryIntent);
    }

    @DSSink({DSSinkKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.314 -0500", hash_original_method = "D48A5BF0B94B8EDA7081204D0BFF762D", hash_generated_method = "007F0AA8F874400EBD2018695353B8ED")
    
public void sendText(String destAddr, String scAddr,
            String text, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        mIccSmsInterfaceManager.sendText(destAddr, scAddr, text, sentIntent, deliveryIntent);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.316 -0500", hash_original_method = "0281C03B46D163678105B9E0741ABCE4", hash_generated_method = "6A73CCCD3E9D2706BF401912732564EB")
    
public void sendMultipartText(String destAddr, String scAddr,
            List<String> parts, List<PendingIntent> sentIntents,
            List<PendingIntent> deliveryIntents) throws android.os.RemoteException {
        mIccSmsInterfaceManager.sendMultipartText(destAddr, scAddr,
                parts, sentIntents, deliveryIntents);
    }

    @DSSink({DSSinkKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.318 -0500", hash_original_method = "5D02A742FEB89A51A662A78F91F83EB2", hash_generated_method = "92529965D29197977041CEF8BA037558")
    
public boolean enableCellBroadcast(int messageIdentifier) throws android.os.RemoteException {
        return mIccSmsInterfaceManager.enableCellBroadcast(messageIdentifier);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.320 -0500", hash_original_method = "C80EBC5BA55DC936FFC43EB47C1044D2", hash_generated_method = "9AFDCCCB5B633684F587E68168F782C5")
    
public boolean disableCellBroadcast(int messageIdentifier) throws android.os.RemoteException {
        return mIccSmsInterfaceManager.disableCellBroadcast(messageIdentifier);
    }

    @DSSink({DSSinkKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.323 -0500", hash_original_method = "77C7447F884D58462B45A73E9887417A", hash_generated_method = "A4DC72D059D7024FE19CFD0A3372E7AB")
    
public boolean enableCellBroadcastRange(int startMessageId, int endMessageId)
            throws android.os.RemoteException {
        return mIccSmsInterfaceManager.enableCellBroadcastRange(startMessageId, endMessageId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.325 -0500", hash_original_method = "D3E78DE7F13EEAAE236D37E8C5EE46B7", hash_generated_method = "4894918419AA156BEFC5F9015BF66405")
    
public boolean disableCellBroadcastRange(int startMessageId, int endMessageId)
            throws android.os.RemoteException {
        return mIccSmsInterfaceManager.disableCellBroadcastRange(startMessageId, endMessageId);
    }
    
}


package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.PendingIntent;
import android.os.ServiceManager;
import java.util.List;

public class IccSmsInterfaceManagerProxy extends ISms.Stub {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.209 -0400", hash_original_field = "A52A97EEB96E996624E6BA1BFF24DA17", hash_generated_field = "4B2DE1FC1C2E4C5A8A18A1F711193C46")

    private IccSmsInterfaceManager mIccSmsInterfaceManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.211 -0400", hash_original_method = "93AA6BF164B05EF7A7122BD605AACB07", hash_generated_method = "38FD44910EB4ED755A00959DC5A7FD4D")
    public  IccSmsInterfaceManagerProxy(IccSmsInterfaceManager
            iccSmsInterfaceManager) {
        this.mIccSmsInterfaceManager = iccSmsInterfaceManager;
        {
            boolean var57CA35B873E1E62AB02C8E6DC3FE6622_932401092 = (ServiceManager.getService("isms") == null);
            {
                ServiceManager.addService("isms", this);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //this.mIccSmsInterfaceManager = iccSmsInterfaceManager;
        //if(ServiceManager.getService("isms") == null) {
            //ServiceManager.addService("isms", this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.299 -0400", hash_original_method = "671E1905A4ABBFEC9E8C5B4CD14B64F9", hash_generated_method = "084F97C58E7BDCADFF8AD86DFAC8FD32")
    public void setmIccSmsInterfaceManager(IccSmsInterfaceManager iccSmsInterfaceManager) {
        this.mIccSmsInterfaceManager = iccSmsInterfaceManager;
        // ---------- Original Method ----------
        //this.mIccSmsInterfaceManager = iccSmsInterfaceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.302 -0400", hash_original_method = "DC12853B6F5A9BF9A9AEF133DEC97096", hash_generated_method = "CB1B0DA4EBE55DE8DD35C42F3108DA1C")
    public boolean updateMessageOnIccEf(int index, int status, byte[] pdu) throws android.os.RemoteException {
        boolean var6B4D35D9CFA3119C6143FB160A056127_2081129744 = (mIccSmsInterfaceManager.updateMessageOnIccEf(index, status, pdu));
        addTaint(index);
        addTaint(status);
        addTaint(pdu[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_459190347 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_459190347;
        // ---------- Original Method ----------
        //return mIccSmsInterfaceManager.updateMessageOnIccEf(index, status, pdu);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.302 -0400", hash_original_method = "A12926ED612F9F1CC0852D606D3EA5CE", hash_generated_method = "66CE28FF5A562B2EE23EEC2C4046412A")
    public boolean copyMessageToIccEf(int status, byte[] pdu,
            byte[] smsc) throws android.os.RemoteException {
        boolean varADC5A2F9D2035B5448948A7EC2C3D9FB_615856850 = (mIccSmsInterfaceManager.copyMessageToIccEf(status, pdu, smsc));
        addTaint(status);
        addTaint(pdu[0]);
        addTaint(smsc[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_876379688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_876379688;
        // ---------- Original Method ----------
        //return mIccSmsInterfaceManager.copyMessageToIccEf(status, pdu, smsc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.303 -0400", hash_original_method = "6F960BE075575D7400653ACEFE5617FE", hash_generated_method = "1C0E335849AF03ED44A37479136F90EC")
    public List<SmsRawData> getAllMessagesFromIccEf() throws android.os.RemoteException {
        List<SmsRawData> varB4EAC82CA7396A68D541C85D26508E83_1656593313 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1656593313 = mIccSmsInterfaceManager.getAllMessagesFromIccEf();
        varB4EAC82CA7396A68D541C85D26508E83_1656593313.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1656593313;
        // ---------- Original Method ----------
        //return mIccSmsInterfaceManager.getAllMessagesFromIccEf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.303 -0400", hash_original_method = "E01EFF7504F6F5A7F2409B5C1751CC43", hash_generated_method = "D3B89184B29A52A8C2111201F0A0283D")
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
        // ---------- Original Method ----------
        //mIccSmsInterfaceManager.sendData(destAddr, scAddr, destPort, data,
                //sentIntent, deliveryIntent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.307 -0400", hash_original_method = "D48A5BF0B94B8EDA7081204D0BFF762D", hash_generated_method = "AEDE4EBEA5775D4A1794F54FEF3C303B")
    public void sendText(String destAddr, String scAddr,
            String text, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        mIccSmsInterfaceManager.sendText(destAddr, scAddr, text, sentIntent, deliveryIntent);
        addTaint(destAddr.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(text.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(deliveryIntent.getTaint());
        // ---------- Original Method ----------
        //mIccSmsInterfaceManager.sendText(destAddr, scAddr, text, sentIntent, deliveryIntent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.307 -0400", hash_original_method = "0281C03B46D163678105B9E0741ABCE4", hash_generated_method = "E673206869801DB63A94155BC395A320")
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
        // ---------- Original Method ----------
        //mIccSmsInterfaceManager.sendMultipartText(destAddr, scAddr,
                //parts, sentIntents, deliveryIntents);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.308 -0400", hash_original_method = "5D02A742FEB89A51A662A78F91F83EB2", hash_generated_method = "8BC87D827A516188DE3822659768B93B")
    public boolean enableCellBroadcast(int messageIdentifier) throws android.os.RemoteException {
        boolean varA45658559D2C8AE52393A109A76EAA2E_1881185822 = (mIccSmsInterfaceManager.enableCellBroadcast(messageIdentifier));
        addTaint(messageIdentifier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1776006435 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1776006435;
        // ---------- Original Method ----------
        //return mIccSmsInterfaceManager.enableCellBroadcast(messageIdentifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.308 -0400", hash_original_method = "C80EBC5BA55DC936FFC43EB47C1044D2", hash_generated_method = "2A9FD22CB05B592231C6F2BB59DEADD6")
    public boolean disableCellBroadcast(int messageIdentifier) throws android.os.RemoteException {
        boolean var64D5F95156F520A346F2DFFA1E4E3238_1942463732 = (mIccSmsInterfaceManager.disableCellBroadcast(messageIdentifier));
        addTaint(messageIdentifier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1597199192 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1597199192;
        // ---------- Original Method ----------
        //return mIccSmsInterfaceManager.disableCellBroadcast(messageIdentifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.316 -0400", hash_original_method = "77C7447F884D58462B45A73E9887417A", hash_generated_method = "32965EA714327A157B703E492E143D22")
    public boolean enableCellBroadcastRange(int startMessageId, int endMessageId) throws android.os.RemoteException {
        boolean varE9B30095FEC7EB5EE7A835C933C1CB77_700848404 = (mIccSmsInterfaceManager.enableCellBroadcastRange(startMessageId, endMessageId));
        addTaint(startMessageId);
        addTaint(endMessageId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_161449920 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_161449920;
        // ---------- Original Method ----------
        //return mIccSmsInterfaceManager.enableCellBroadcastRange(startMessageId, endMessageId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:15.317 -0400", hash_original_method = "D3E78DE7F13EEAAE236D37E8C5EE46B7", hash_generated_method = "B4C2CF28D7DDF555F54C8B324690F75C")
    public boolean disableCellBroadcastRange(int startMessageId, int endMessageId) throws android.os.RemoteException {
        boolean varD8178CF37E2D825B7B50E7AE9EDDA962_1096539215 = (mIccSmsInterfaceManager.disableCellBroadcastRange(startMessageId, endMessageId));
        addTaint(startMessageId);
        addTaint(endMessageId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_812597890 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_812597890;
        // ---------- Original Method ----------
        //return mIccSmsInterfaceManager.disableCellBroadcastRange(startMessageId, endMessageId);
    }

    
}


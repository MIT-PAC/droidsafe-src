package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.PendingIntent;
import android.os.ServiceManager;
import java.util.List;

public class IccSmsInterfaceManagerProxy extends ISms.Stub {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.349 -0400", hash_original_field = "A52A97EEB96E996624E6BA1BFF24DA17", hash_generated_field = "4B2DE1FC1C2E4C5A8A18A1F711193C46")

    private IccSmsInterfaceManager mIccSmsInterfaceManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.350 -0400", hash_original_method = "93AA6BF164B05EF7A7122BD605AACB07", hash_generated_method = "110C295086127DDC68E4D24858CBA893")
    public  IccSmsInterfaceManagerProxy(IccSmsInterfaceManager
            iccSmsInterfaceManager) {
        this.mIccSmsInterfaceManager = iccSmsInterfaceManager;
        if(ServiceManager.getService("isms") == null)        
        {
            ServiceManager.addService("isms", this);
        } //End block
        // ---------- Original Method ----------
        //this.mIccSmsInterfaceManager = iccSmsInterfaceManager;
        //if(ServiceManager.getService("isms") == null) {
            //ServiceManager.addService("isms", this);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.351 -0400", hash_original_method = "671E1905A4ABBFEC9E8C5B4CD14B64F9", hash_generated_method = "084F97C58E7BDCADFF8AD86DFAC8FD32")
    public void setmIccSmsInterfaceManager(IccSmsInterfaceManager iccSmsInterfaceManager) {
        this.mIccSmsInterfaceManager = iccSmsInterfaceManager;
        // ---------- Original Method ----------
        //this.mIccSmsInterfaceManager = iccSmsInterfaceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.351 -0400", hash_original_method = "DC12853B6F5A9BF9A9AEF133DEC97096", hash_generated_method = "CF9813F7A1D7DEA1FE3749E4D9DDC4F6")
    public boolean updateMessageOnIccEf(int index, int status, byte[] pdu) throws android.os.RemoteException {
        addTaint(pdu[0]);
        addTaint(status);
        addTaint(index);
        boolean varFA500E320F6DF10A3FF1C30CCFC14C8B_1924950107 = (mIccSmsInterfaceManager.updateMessageOnIccEf(index, status, pdu));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2089328710 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2089328710;
        // ---------- Original Method ----------
        //return mIccSmsInterfaceManager.updateMessageOnIccEf(index, status, pdu);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.352 -0400", hash_original_method = "A12926ED612F9F1CC0852D606D3EA5CE", hash_generated_method = "85AB939E62927B2281406770CF981650")
    public boolean copyMessageToIccEf(int status, byte[] pdu,
            byte[] smsc) throws android.os.RemoteException {
        addTaint(smsc[0]);
        addTaint(pdu[0]);
        addTaint(status);
        boolean varC24F3CCD31123452A03B2CC64E6AB18C_1740727758 = (mIccSmsInterfaceManager.copyMessageToIccEf(status, pdu, smsc));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1003275517 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1003275517;
        // ---------- Original Method ----------
        //return mIccSmsInterfaceManager.copyMessageToIccEf(status, pdu, smsc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.352 -0400", hash_original_method = "6F960BE075575D7400653ACEFE5617FE", hash_generated_method = "A2981BB69B940C24880E9C09EFFFC469")
    public List<SmsRawData> getAllMessagesFromIccEf() throws android.os.RemoteException {
List<SmsRawData> var1E9CCA9C0A91D2170EE885EDBA8CE17D_983050917 =         mIccSmsInterfaceManager.getAllMessagesFromIccEf();
        var1E9CCA9C0A91D2170EE885EDBA8CE17D_983050917.addTaint(taint);
        return var1E9CCA9C0A91D2170EE885EDBA8CE17D_983050917;
        // ---------- Original Method ----------
        //return mIccSmsInterfaceManager.getAllMessagesFromIccEf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.352 -0400", hash_original_method = "E01EFF7504F6F5A7F2409B5C1751CC43", hash_generated_method = "4D4A8703C00A6950684907735D90CF56")
    public void sendData(String destAddr, String scAddr, int destPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        addTaint(deliveryIntent.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(data[0]);
        addTaint(destPort);
        addTaint(scAddr.getTaint());
        addTaint(destAddr.getTaint());
        mIccSmsInterfaceManager.sendData(destAddr, scAddr, destPort, data,
                sentIntent, deliveryIntent);
        // ---------- Original Method ----------
        //mIccSmsInterfaceManager.sendData(destAddr, scAddr, destPort, data,
                //sentIntent, deliveryIntent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.353 -0400", hash_original_method = "D48A5BF0B94B8EDA7081204D0BFF762D", hash_generated_method = "B0FD0A400016E4768FE793F81FCCDD7F")
    public void sendText(String destAddr, String scAddr,
            String text, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        addTaint(deliveryIntent.getTaint());
        addTaint(sentIntent.getTaint());
        addTaint(text.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(destAddr.getTaint());
        mIccSmsInterfaceManager.sendText(destAddr, scAddr, text, sentIntent, deliveryIntent);
        // ---------- Original Method ----------
        //mIccSmsInterfaceManager.sendText(destAddr, scAddr, text, sentIntent, deliveryIntent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.353 -0400", hash_original_method = "0281C03B46D163678105B9E0741ABCE4", hash_generated_method = "FA1182DFD2239ED27BEFDB81E17D1860")
    public void sendMultipartText(String destAddr, String scAddr,
            List<String> parts, List<PendingIntent> sentIntents,
            List<PendingIntent> deliveryIntents) throws android.os.RemoteException {
        addTaint(deliveryIntents.getTaint());
        addTaint(sentIntents.getTaint());
        addTaint(parts.getTaint());
        addTaint(scAddr.getTaint());
        addTaint(destAddr.getTaint());
        mIccSmsInterfaceManager.sendMultipartText(destAddr, scAddr,
                parts, sentIntents, deliveryIntents);
        // ---------- Original Method ----------
        //mIccSmsInterfaceManager.sendMultipartText(destAddr, scAddr,
                //parts, sentIntents, deliveryIntents);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.353 -0400", hash_original_method = "5D02A742FEB89A51A662A78F91F83EB2", hash_generated_method = "99A9F76A5E6B85CB180D7E17D7029CE1")
    public boolean enableCellBroadcast(int messageIdentifier) throws android.os.RemoteException {
        addTaint(messageIdentifier);
        boolean var506C5595ECDDA92C2B3DEC3C5D76E9CC_1946210102 = (mIccSmsInterfaceManager.enableCellBroadcast(messageIdentifier));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_887967636 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_887967636;
        // ---------- Original Method ----------
        //return mIccSmsInterfaceManager.enableCellBroadcast(messageIdentifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.354 -0400", hash_original_method = "C80EBC5BA55DC936FFC43EB47C1044D2", hash_generated_method = "81ED87E461B40EE83C80AA9675FB4BE7")
    public boolean disableCellBroadcast(int messageIdentifier) throws android.os.RemoteException {
        addTaint(messageIdentifier);
        boolean varC2CEE5A8AE554A17406A79573F4DD06D_654288469 = (mIccSmsInterfaceManager.disableCellBroadcast(messageIdentifier));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_83031839 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_83031839;
        // ---------- Original Method ----------
        //return mIccSmsInterfaceManager.disableCellBroadcast(messageIdentifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.354 -0400", hash_original_method = "77C7447F884D58462B45A73E9887417A", hash_generated_method = "B40CADD4555A4D5445ACA0A62EC2D1EF")
    public boolean enableCellBroadcastRange(int startMessageId, int endMessageId) throws android.os.RemoteException {
        addTaint(endMessageId);
        addTaint(startMessageId);
        boolean var2C08316F81C6C66256B4CFD85C166E4E_1698974682 = (mIccSmsInterfaceManager.enableCellBroadcastRange(startMessageId, endMessageId));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1555628237 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1555628237;
        // ---------- Original Method ----------
        //return mIccSmsInterfaceManager.enableCellBroadcastRange(startMessageId, endMessageId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.354 -0400", hash_original_method = "D3E78DE7F13EEAAE236D37E8C5EE46B7", hash_generated_method = "3E7B1B7C6BE66B9D083F2C307FE62768")
    public boolean disableCellBroadcastRange(int startMessageId, int endMessageId) throws android.os.RemoteException {
        addTaint(endMessageId);
        addTaint(startMessageId);
        boolean varD4CAE18F71A56410E924084ECA151143_919784273 = (mIccSmsInterfaceManager.disableCellBroadcastRange(startMessageId, endMessageId));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2008464628 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2008464628;
        // ---------- Original Method ----------
        //return mIccSmsInterfaceManager.disableCellBroadcastRange(startMessageId, endMessageId);
    }

    
}


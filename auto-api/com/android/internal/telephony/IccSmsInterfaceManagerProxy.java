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
    private IccSmsInterfaceManager mIccSmsInterfaceManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.448 -0400", hash_original_method = "93AA6BF164B05EF7A7122BD605AACB07", hash_generated_method = "DAF41ACF51013AA038042D96F82DF323")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IccSmsInterfaceManagerProxy(IccSmsInterfaceManager
            iccSmsInterfaceManager) {
        dsTaint.addTaint(iccSmsInterfaceManager.dsTaint);
        {
            boolean var57CA35B873E1E62AB02C8E6DC3FE6622_424778474 = (ServiceManager.getService("isms") == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.448 -0400", hash_original_method = "671E1905A4ABBFEC9E8C5B4CD14B64F9", hash_generated_method = "AA7B2836FD1956507F1B8316304B31A2")
    @DSModeled(DSC.SAFE)
    public void setmIccSmsInterfaceManager(IccSmsInterfaceManager iccSmsInterfaceManager) {
        dsTaint.addTaint(iccSmsInterfaceManager.dsTaint);
        // ---------- Original Method ----------
        //this.mIccSmsInterfaceManager = iccSmsInterfaceManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.448 -0400", hash_original_method = "DC12853B6F5A9BF9A9AEF133DEC97096", hash_generated_method = "ED9990297D339BF875A77AF08FD030B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean updateMessageOnIccEf(int index, int status, byte[] pdu) throws android.os.RemoteException {
        dsTaint.addTaint(index);
        dsTaint.addTaint(status);
        dsTaint.addTaint(pdu[0]);
        boolean var6B4D35D9CFA3119C6143FB160A056127_1778459380 = (mIccSmsInterfaceManager.updateMessageOnIccEf(index, status, pdu));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIccSmsInterfaceManager.updateMessageOnIccEf(index, status, pdu);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.448 -0400", hash_original_method = "A12926ED612F9F1CC0852D606D3EA5CE", hash_generated_method = "5E37EA3B8472E4EDC81A2FD4FBE47EA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean copyMessageToIccEf(int status, byte[] pdu,
            byte[] smsc) throws android.os.RemoteException {
        dsTaint.addTaint(status);
        dsTaint.addTaint(pdu[0]);
        dsTaint.addTaint(smsc[0]);
        boolean varADC5A2F9D2035B5448948A7EC2C3D9FB_810278612 = (mIccSmsInterfaceManager.copyMessageToIccEf(status, pdu, smsc));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIccSmsInterfaceManager.copyMessageToIccEf(status, pdu, smsc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.448 -0400", hash_original_method = "6F960BE075575D7400653ACEFE5617FE", hash_generated_method = "04DF67FE44C1C32CCFAB890464EEF417")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<SmsRawData> getAllMessagesFromIccEf() throws android.os.RemoteException {
        List<SmsRawData> var0BB294AD57A59D19AC4D78F89AEE20C5_924196490 = (mIccSmsInterfaceManager.getAllMessagesFromIccEf());
        return (List<SmsRawData>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mIccSmsInterfaceManager.getAllMessagesFromIccEf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.448 -0400", hash_original_method = "E01EFF7504F6F5A7F2409B5C1751CC43", hash_generated_method = "0B99222104465096ACAC8989DDB74831")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendData(String destAddr, String scAddr, int destPort,
            byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        dsTaint.addTaint(scAddr);
        dsTaint.addTaint(destAddr);
        dsTaint.addTaint(sentIntent.dsTaint);
        dsTaint.addTaint(data[0]);
        dsTaint.addTaint(destPort);
        dsTaint.addTaint(deliveryIntent.dsTaint);
        mIccSmsInterfaceManager.sendData(destAddr, scAddr, destPort, data,
                sentIntent, deliveryIntent);
        // ---------- Original Method ----------
        //mIccSmsInterfaceManager.sendData(destAddr, scAddr, destPort, data,
                //sentIntent, deliveryIntent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.449 -0400", hash_original_method = "D48A5BF0B94B8EDA7081204D0BFF762D", hash_generated_method = "10031972F259AF016D5D1969072B975B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendText(String destAddr, String scAddr,
            String text, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(scAddr);
        dsTaint.addTaint(destAddr);
        dsTaint.addTaint(sentIntent.dsTaint);
        dsTaint.addTaint(deliveryIntent.dsTaint);
        mIccSmsInterfaceManager.sendText(destAddr, scAddr, text, sentIntent, deliveryIntent);
        // ---------- Original Method ----------
        //mIccSmsInterfaceManager.sendText(destAddr, scAddr, text, sentIntent, deliveryIntent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.449 -0400", hash_original_method = "0281C03B46D163678105B9E0741ABCE4", hash_generated_method = "5A47CD4D3F97FD0552C1A45F70CF1CBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendMultipartText(String destAddr, String scAddr,
            List<String> parts, List<PendingIntent> sentIntents,
            List<PendingIntent> deliveryIntents) throws android.os.RemoteException {
        dsTaint.addTaint(deliveryIntents.dsTaint);
        dsTaint.addTaint(scAddr);
        dsTaint.addTaint(destAddr);
        dsTaint.addTaint(sentIntents.dsTaint);
        dsTaint.addTaint(parts.dsTaint);
        mIccSmsInterfaceManager.sendMultipartText(destAddr, scAddr,
                parts, sentIntents, deliveryIntents);
        // ---------- Original Method ----------
        //mIccSmsInterfaceManager.sendMultipartText(destAddr, scAddr,
                //parts, sentIntents, deliveryIntents);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.449 -0400", hash_original_method = "5D02A742FEB89A51A662A78F91F83EB2", hash_generated_method = "220FF4E92332D14306CB65F13938BA80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean enableCellBroadcast(int messageIdentifier) throws android.os.RemoteException {
        dsTaint.addTaint(messageIdentifier);
        boolean varA45658559D2C8AE52393A109A76EAA2E_1572140353 = (mIccSmsInterfaceManager.enableCellBroadcast(messageIdentifier));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIccSmsInterfaceManager.enableCellBroadcast(messageIdentifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.449 -0400", hash_original_method = "C80EBC5BA55DC936FFC43EB47C1044D2", hash_generated_method = "2E0F3095EDB0F3D74E74E4179D0F989F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean disableCellBroadcast(int messageIdentifier) throws android.os.RemoteException {
        dsTaint.addTaint(messageIdentifier);
        boolean var64D5F95156F520A346F2DFFA1E4E3238_1558986175 = (mIccSmsInterfaceManager.disableCellBroadcast(messageIdentifier));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIccSmsInterfaceManager.disableCellBroadcast(messageIdentifier);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.449 -0400", hash_original_method = "77C7447F884D58462B45A73E9887417A", hash_generated_method = "67DAD0DCC3E092F9327D0E184490C37E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean enableCellBroadcastRange(int startMessageId, int endMessageId) throws android.os.RemoteException {
        dsTaint.addTaint(startMessageId);
        dsTaint.addTaint(endMessageId);
        boolean varE9B30095FEC7EB5EE7A835C933C1CB77_1807920713 = (mIccSmsInterfaceManager.enableCellBroadcastRange(startMessageId, endMessageId));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIccSmsInterfaceManager.enableCellBroadcastRange(startMessageId, endMessageId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.450 -0400", hash_original_method = "D3E78DE7F13EEAAE236D37E8C5EE46B7", hash_generated_method = "1086BAF14A40CB318BC53732B9FEDE2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean disableCellBroadcastRange(int startMessageId, int endMessageId) throws android.os.RemoteException {
        dsTaint.addTaint(startMessageId);
        dsTaint.addTaint(endMessageId);
        boolean varD8178CF37E2D825B7B50E7AE9EDDA962_1824222168 = (mIccSmsInterfaceManager.disableCellBroadcastRange(startMessageId, endMessageId));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIccSmsInterfaceManager.disableCellBroadcastRange(startMessageId, endMessageId);
    }

    
}


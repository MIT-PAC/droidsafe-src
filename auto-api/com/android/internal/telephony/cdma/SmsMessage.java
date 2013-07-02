package com.android.internal.telephony.cdma;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.SystemProperties;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import com.android.internal.telephony.IccUtils;
import com.android.internal.telephony.SmsHeader;
import com.android.internal.telephony.SmsMessageBase;
import com.android.internal.telephony.TelephonyProperties;
import com.android.internal.telephony.cdma.sms.BearerData;
import com.android.internal.telephony.cdma.sms.CdmaSmsAddress;
import com.android.internal.telephony.cdma.sms.CdmaSmsSubaddress;
import com.android.internal.telephony.cdma.sms.SmsEnvelope;
import com.android.internal.telephony.cdma.sms.UserData;
import com.android.internal.util.BitwiseInputStream;
import com.android.internal.util.HexDump;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static android.telephony.SmsMessage.MAX_USER_DATA_BYTES;
import static android.telephony.SmsMessage.MAX_USER_DATA_BYTES_WITH_HEADER;
import static android.telephony.SmsMessage.MAX_USER_DATA_SEPTETS;
import static android.telephony.SmsMessage.MAX_USER_DATA_SEPTETS_WITH_HEADER;
import static android.telephony.SmsMessage.MessageClass;

public class SmsMessage extends SmsMessageBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.643 -0400", hash_original_field = "9ACB44549B41563697BB490144EC6258", hash_generated_field = "4BAC49709EDEAEFDD9E07400E0F02406")

    private int status;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.643 -0400", hash_original_field = "10C68415B1F778960BA74C87DE7F141E", hash_generated_field = "5DE432FC9FD653332885B7638256C4A9")

    private SmsEnvelope mEnvelope;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.643 -0400", hash_original_field = "1BFE3A3CA6EAE69ADBFFE668557EC2BA", hash_generated_field = "B90F3642F146E4CB5B7C5D2425641201")

    private BearerData mBearerData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.643 -0400", hash_original_method = "6C523C791261F68A00BC5A8339EB91FE", hash_generated_method = "6C523C791261F68A00BC5A8339EB91FE")
    public SmsMessage ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    public static SmsMessage createFromPdu(byte[] pdu) {
        SmsMessage msg = new SmsMessage();
        try {
            msg.parsePdu(pdu);
            return msg;
        } catch (RuntimeException ex) {
            Log.e(LOG_TAG, "SMS PDU parsing failed: ", ex);
            return null;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static SmsMessage newFromParcel(Parcel p) {
        SmsMessage msg = new SmsMessage();
        SmsEnvelope env = new SmsEnvelope();
        CdmaSmsAddress addr = new CdmaSmsAddress();
        CdmaSmsSubaddress subaddr = new CdmaSmsSubaddress();
        byte[] data;
        byte count;
        int countInt;
        int addressDigitMode;
        env.teleService = p.readInt();
        if (0 != p.readByte()) { 
            env.messageType = SmsEnvelope.MESSAGE_TYPE_BROADCAST;
        }
        else {
            if (SmsEnvelope.TELESERVICE_NOT_SET == env.teleService) {
                env.messageType = SmsEnvelope.MESSAGE_TYPE_ACKNOWLEDGE;
            } else {
                env.messageType = SmsEnvelope.MESSAGE_TYPE_POINT_TO_POINT;
            }
        }
        env.serviceCategory = p.readInt();
        addressDigitMode = p.readInt();
        addr.digitMode = (byte) (0xFF & addressDigitMode);
        addr.numberMode = (byte) (0xFF & p.readInt());
        addr.ton = p.readInt();
        addr.numberPlan = (byte) (0xFF & p.readInt());
        count = p.readByte();
        addr.numberOfDigits = count;
        data = new byte[count];
        for (int index=0; index < count; index++) {
            data[index] = p.readByte();
            if (addressDigitMode == CdmaSmsAddress.DIGIT_MODE_4BIT_DTMF) {
                data[index] = msg.convertDtmfToAscii(data[index]);
            }
        }
        addr.origBytes = data;
        subaddr.type = p.readInt();
        subaddr.odd = p.readByte();
        count = p.readByte();
        if (count < 0) {
            count = 0;
        }
        data = new byte[count];
        for (int index = 0; index < count; ++index) {
            data[index] = p.readByte();
        }
        subaddr.origBytes = data;
        countInt = p.readInt();
        if (countInt >0) {
            data = new byte[countInt];
            for (int index=0; index < countInt; index++) {
                data[index] = p.readByte();
            }
            env.bearerData = data;
        }
        env.origAddress = addr;
        env.origSubaddress = subaddr;
        msg.originatingAddress = addr;
        msg.mEnvelope = env;
        msg.createPdu();
        return msg;
    }

    
    @DSModeled(DSC.SAFE)
    public static SmsMessage createFromEfRecord(int index, byte[] data) {
        try {
            SmsMessage msg = new SmsMessage();
            msg.indexOnIcc = index;
            if ((data[0] & 1) == 0) {
                Log.w(LOG_TAG, "SMS parsing failed: Trying to parse a free record");
                return null;
            } else {
                msg.statusOnIcc = data[0] & 0x07;
            }
            int size = data[1];
            byte[] pdu = new byte[size];
            System.arraycopy(data, 2, pdu, 0, size);
            msg.parsePduFromEfRecord(pdu);
            return msg;
        } catch (RuntimeException ex) {
            Log.e(LOG_TAG, "SMS PDU parsing failed: ", ex);
            return null;
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static int getTPLayerLengthForPDU(String pdu) {
        Log.w(LOG_TAG, "getTPLayerLengthForPDU: is not supported in CDMA mode.");
        return 0;
    }

    
    @DSModeled(DSC.SAFE)
    public static SubmitPdu getSubmitPdu(String scAddr, String destAddr, String message,
            boolean statusReportRequested, SmsHeader smsHeader) {
        if (message == null || destAddr == null) {
            return null;
        }
        UserData uData = new UserData();
        uData.payloadStr = message;
        uData.userDataHeader = smsHeader;
        return privateGetSubmitPdu(destAddr, statusReportRequested, uData);
    }

    
    @DSModeled(DSC.SAFE)
    public static SubmitPdu getSubmitPdu(String scAddr, String destAddr, int destPort,
            byte[] data, boolean statusReportRequested) {
        SmsHeader.PortAddrs portAddrs = new SmsHeader.PortAddrs();
        portAddrs.destPort = destPort;
        portAddrs.origPort = 0;
        portAddrs.areEightBits = false;
        SmsHeader smsHeader = new SmsHeader();
        smsHeader.portAddrs = portAddrs;
        UserData uData = new UserData();
        uData.userDataHeader = smsHeader;
        uData.msgEncoding = UserData.ENCODING_OCTET;
        uData.msgEncodingSet = true;
        uData.payload = data;
        return privateGetSubmitPdu(destAddr, statusReportRequested, uData);
    }

    
    @DSModeled(DSC.SAFE)
    public static SubmitPdu getSubmitPdu(String destAddr, UserData userData,
            boolean statusReportRequested) {
        return privateGetSubmitPdu(destAddr, statusReportRequested, userData);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.645 -0400", hash_original_method = "CFC9E8C6C71B803A9382349B0D254790", hash_generated_method = "9006B70899B2F277DA5328B937D690B0")
    public int getProtocolIdentifier() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_650523654 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_650523654;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.645 -0400", hash_original_method = "95CFCAABC583EA802C704015EAFBF308", hash_generated_method = "388C0ADF873B7F718E1FC6056D745D63")
    public boolean isReplace() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1210825050 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1210825050;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.645 -0400", hash_original_method = "201DA8455DBB44F9D4BF017BFCDAFF9F", hash_generated_method = "BCB1FF8CB10CB7D02693787E79DCC22A")
    public boolean isCphsMwiMessage() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1071141225 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1071141225;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.646 -0400", hash_original_method = "B638C86EC79B8E5FA2D28FA811D2BCF0", hash_generated_method = "C9DB344D24D3B10F1C2A36284A77ED07")
    public boolean isMWIClearMessage() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1148995368 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1148995368;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.646 -0400", hash_original_method = "E19020FF854A35A2375E0A8AE070BF97", hash_generated_method = "5D508267E047CFEADDA3F44A186EE7BD")
    public boolean isMWISetMessage() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_110683430 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_110683430;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.646 -0400", hash_original_method = "2F5A490D5EB0B5469046C11BA63EC135", hash_generated_method = "AC5B301B3929984ECB67EE16D9DDDF2D")
    public boolean isMwiDontStore() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_914405766 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_914405766;
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.647 -0400", hash_original_method = "03B5EE24FC37A73D7F31FE2BAB3C2BFD", hash_generated_method = "59FF5C0461C6B644F53ABB0545F85259")
    public int getStatus() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1324277217 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1324277217;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.647 -0400", hash_original_method = "A75C98E30CFF18DAC25DE4B33918A3F4", hash_generated_method = "7C2A014947407D824C37D730ABEF59A9")
    public boolean isStatusReportMessage() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1353852256 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1353852256;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.647 -0400", hash_original_method = "0F1242A5312C3945C722AC39BFD87EF2", hash_generated_method = "F62EE5B783B39C630B52B49A3C646E0D")
    public boolean isReplyPathPresent() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_532888286 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_532888286;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static TextEncodingDetails calculateLength(CharSequence messageBody,
            boolean use7bitOnly) {
        return BearerData.calcTextEncodingDetails(messageBody, use7bitOnly);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.648 -0400", hash_original_method = "BA17728EC06E4E9670ACA616D9E29C12", hash_generated_method = "BD1075BE8ECF02328955F6B9DBBBD855")
     int getTeleService() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1904586488 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1904586488;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.648 -0400", hash_original_method = "1BE3451C0D43919E5115D33DA4A62DB3", hash_generated_method = "F8A955DCE19CCD908CED41F50FAB891C")
     int getMessageType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1727326277 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1727326277;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.649 -0400", hash_original_method = "CD6FB45A1A4A8300476A32D9A94A5A2D", hash_generated_method = "E0F8371BF6FD63CD935A78E8F868FCB0")
    private void parsePdu(byte[] pdu) {
        ByteArrayInputStream bais = new ByteArrayInputStream(pdu);
        DataInputStream dis = new DataInputStream(bais);
        byte length;
        int bearerDataLength;
        SmsEnvelope env = new SmsEnvelope();
        CdmaSmsAddress addr = new CdmaSmsAddress();
        try 
        {
            env.messageType = dis.readInt();
            env.teleService = dis.readInt();
            env.serviceCategory = dis.readInt();
            addr.digitMode = dis.readByte();
            addr.numberMode = dis.readByte();
            addr.ton = dis.readByte();
            addr.numberPlan = dis.readByte();
            length = dis.readByte();
            addr.numberOfDigits = length;
            addr.origBytes = new byte[length];
            dis.read(addr.origBytes, 0, length);
            env.bearerReply = dis.readInt();
            env.replySeqNo = dis.readByte();
            env.errorClass = dis.readByte();
            env.causeCode = dis.readByte();
            bearerDataLength = dis.readInt();
            env.bearerData = new byte[bearerDataLength];
            dis.read(env.bearerData, 0, bearerDataLength);
            dis.close();
        } 
        catch (Exception ex)
        { }
        originatingAddress = addr;
        env.origAddress = addr;
        mEnvelope = env;
        mPdu = pdu;
        parseSms();
        addTaint(pdu[0]);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.651 -0400", hash_original_method = "4600019E789700BB681DB9CDCB53078A", hash_generated_method = "70A816897EA6E8F9580877CA8485D74F")
    private void parsePduFromEfRecord(byte[] pdu) {
        ByteArrayInputStream bais = new ByteArrayInputStream(pdu);
        DataInputStream dis = new DataInputStream(bais);
        SmsEnvelope env = new SmsEnvelope();
        CdmaSmsAddress addr = new CdmaSmsAddress();
        CdmaSmsSubaddress subAddr = new CdmaSmsSubaddress();
        try 
        {
            env.messageType = dis.readByte();
            {
                boolean varCB89B9C40A54203B21970E3B5D78C366_696761915 = (dis.available() > 0);
                {
                    int parameterId = dis.readByte();
                    int parameterLen = dis.readByte();
                    byte[] parameterData = new byte[parameterLen];
                    
                    env.teleService = dis.readUnsignedShort();
                    
                    
                    env.serviceCategory = dis.readUnsignedShort();
                    
                    
                    dis.read(parameterData, 0, parameterLen);
                    
                    
                    BitwiseInputStream addrBis = new BitwiseInputStream(parameterData);
                    
                    
                    addr.digitMode = addrBis.read(1);
                    
                    
                    addr.numberMode = addrBis.read(1);
                    
                    
                    int numberType = 0;
                    
                    
                    {
                        numberType = addrBis.read(3);
                        addr.ton = numberType;
                        addr.numberPlan = addrBis.read(4);
                    } 
                    
                    
                    addr.numberOfDigits = addrBis.read(8);
                    
                    
                    byte[] data = new byte[addr.numberOfDigits];
                    
                    
                    byte b = 0x00;
                    
                    
                    {
                        {
                            int index = 0;
                            {
                                b = (byte) (0xF & addrBis.read(4));
                                data[index] = convertDtmfToAscii(b);
                            } 
                        } 
                    } 
                    {
                        {
                            {
                                int index = 0;
                                {
                                    b = (byte) (0xFF & addrBis.read(8));
                                    data[index] = b;
                                } 
                            } 
                        } 
                    } 
                    
                    
                    addr.origBytes = data;
                    
                    
                    dis.read(parameterData, 0, parameterLen);
                    
                    
                    BitwiseInputStream subAddrBis = new BitwiseInputStream(parameterData);
                    
                    
                    subAddr.type = subAddrBis.read(3);
                    
                    
                    subAddr.odd = subAddrBis.readByteArray(1)[0];
                    
                    
                    int subAddrLen = subAddrBis.read(8);
                    
                    
                    byte[] subdata = new byte[subAddrLen];
                    
                    
                    {
                        int index = 0;
                        {
                            b = (byte) (0xFF & subAddrBis.read(4));
                            subdata[index] = convertDtmfToAscii(b);
                        } 
                    } 
                    
                    
                    subAddr.origBytes = subdata;
                    
                    
                    dis.read(parameterData, 0, parameterLen);
                    
                    
                    BitwiseInputStream replyOptBis = new BitwiseInputStream(parameterData);
                    
                    
                    env.bearerReply = replyOptBis.read(6);
                    
                    
                    dis.read(parameterData, 0, parameterLen);
                    
                    
                    BitwiseInputStream ccBis = new BitwiseInputStream(parameterData);
                    
                    
                    env.replySeqNo = ccBis.readByteArray(6)[0];
                    
                    
                    env.errorClass = ccBis.readByteArray(2)[0];
                    
                    
                    env.causeCode = ccBis.readByteArray(8)[0];
                    
                    
                    dis.read(parameterData, 0, parameterLen);
                    
                    
                    env.bearerData = parameterData;
                    
                    
                    if (DroidSafeAndroidRuntime.control) throw new Exception("unsupported parameterId (" + parameterId + ")");
                    
                } 
            } 
            bais.close();
            dis.close();
        } 
        catch (Exception ex)
        { }
        originatingAddress = addr;
        env.origAddress = addr;
        env.origSubaddress = subAddr;
        mEnvelope = env;
        mPdu = pdu;
        parseSms();
        addTaint(pdu[0]);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.652 -0400", hash_original_method = "64AD6AE28B963471C0AF85BE0E89B856", hash_generated_method = "2EDB82008E1559B6FCE5E65E7B8C1263")
    protected void parseSms() {
        {
            mBearerData = new BearerData();
            {
                mBearerData.numberOfMessages = 0x000000FF & mEnvelope.bearerData[0];
            } 
            {
                Log.d(LOG_TAG, "parseSms: get MWI " +
                      Integer.toString(mBearerData.numberOfMessages));
            } 
        } 
        mBearerData = BearerData.decode(mEnvelope.bearerData);
        {
            boolean var48EBA01C947DF1F8CB9545D7AA0EB5C6_1009499197 = (Log.isLoggable(LOGGABLE_TAG, Log.VERBOSE));
            {
                Log.d(LOG_TAG, "MT raw BearerData = '" +
                      HexDump.toHexString(mEnvelope.bearerData) + "'");
                Log.d(LOG_TAG, "MT (decoded) BearerData = " + mBearerData);
            } 
        } 
        messageRef = mBearerData.messageId;
        {
            userData = mBearerData.userData.payload;
            userDataHeader = mBearerData.userData.userDataHeader;
            messageBody = mBearerData.userData.payloadStr;
        } 
        {
            originatingAddress.address = new String(originatingAddress.origBytes);
        } 
        {
            scTimeMillis = mBearerData.msgCenterTimeStamp.toMillis(true);
        } 
        Log.d(LOG_TAG, "SMS SC timestamp: " + scTimeMillis);
        {
            {
                Log.d(LOG_TAG, "DELIVERY_ACK message without msgStatus (" +
                        (userData == null ? "also missing" : "does have") +
                        " userData).");
                status = 0;
            } 
            {
                status = mBearerData.errorClass << 8;
                status |= mBearerData.messageStatus;
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unsupported message type: " + mBearerData.messageType);
        } 
        {
            parseMessageBody();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.653 -0400", hash_original_method = "7EF6A65398433E9B1CBF5DF28BDBF834", hash_generated_method = "108DD8899CED5E83E256F776CBBD3555")
    public MessageClass getMessageClass() {
        MessageClass varB4EAC82CA7396A68D541C85D26508E83_229254385 = null; 
        MessageClass varB4EAC82CA7396A68D541C85D26508E83_1719372752 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_229254385 = MessageClass.CLASS_0;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1719372752 = MessageClass.UNKNOWN;
        } 
        MessageClass varA7E53CE21691AB073D9660D615818899_25043632; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_25043632 = varB4EAC82CA7396A68D541C85D26508E83_229254385;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_25043632 = varB4EAC82CA7396A68D541C85D26508E83_1719372752;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_25043632.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_25043632;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    private synchronized static int getNextMessageId() {
        int msgId = SystemProperties.getInt(TelephonyProperties.PROPERTY_CDMA_MSG_ID, 1);
        String nextMsgId = Integer.toString((msgId % 0xFFFF) + 1);
        SystemProperties.set(TelephonyProperties.PROPERTY_CDMA_MSG_ID, nextMsgId);
        if (Log.isLoggable(LOGGABLE_TAG, Log.VERBOSE)) {
            Log.d(LOG_TAG, "next " + TelephonyProperties.PROPERTY_CDMA_MSG_ID + " = " + nextMsgId);
            Log.d(LOG_TAG, "readback gets " +
                    SystemProperties.get(TelephonyProperties.PROPERTY_CDMA_MSG_ID));
        }
        return msgId;
    }

    
    @DSModeled(DSC.SAFE)
    private static SubmitPdu privateGetSubmitPdu(String destAddrStr, boolean statusReportRequested,
            UserData userData) {
        CdmaSmsAddress destAddr = CdmaSmsAddress.parse(
                PhoneNumberUtils.cdmaCheckAndProcessPlusCode(destAddrStr));
        if (destAddr == null) return null;
        BearerData bearerData = new BearerData();
        bearerData.messageType = BearerData.MESSAGE_TYPE_SUBMIT;
        bearerData.messageId = getNextMessageId();
        bearerData.deliveryAckReq = statusReportRequested;
        bearerData.userAckReq = false;
        bearerData.readAckReq = false;
        bearerData.reportReq = false;
        bearerData.userData = userData;
        byte[] encodedBearerData = BearerData.encode(bearerData);
        if (Log.isLoggable(LOGGABLE_TAG, Log.VERBOSE)) {
            Log.d(LOG_TAG, "MO (encoded) BearerData = " + bearerData);
            Log.d(LOG_TAG, "MO raw BearerData = '" + HexDump.toHexString(encodedBearerData) + "'");
        }
        if (encodedBearerData == null) return null;
        int teleservice = bearerData.hasUserDataHeader ?
                SmsEnvelope.TELESERVICE_WEMT : SmsEnvelope.TELESERVICE_WMT;
        SmsEnvelope envelope = new SmsEnvelope();
        envelope.messageType = SmsEnvelope.MESSAGE_TYPE_POINT_TO_POINT;
        envelope.teleService = teleservice;
        envelope.destAddress = destAddr;
        envelope.bearerReply = RETURN_ACK;
        envelope.bearerData = encodedBearerData;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream(100);
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeInt(envelope.teleService);
            dos.writeInt(0); 
            dos.writeInt(0); 
            dos.write(destAddr.digitMode);
            dos.write(destAddr.numberMode);
            dos.write(destAddr.ton); 
            dos.write(destAddr.numberPlan);
            dos.write(destAddr.numberOfDigits);
            dos.write(destAddr.origBytes, 0, destAddr.origBytes.length); 
            dos.write(0); 
            dos.write(0); 
            dos.write(0); 
            dos.write(encodedBearerData.length);
            dos.write(encodedBearerData, 0, encodedBearerData.length);
            dos.close();
            SubmitPdu pdu = new SubmitPdu();
            pdu.encodedMessage = baos.toByteArray();
            pdu.encodedScAddress = null;
            return pdu;
        } catch(IOException ex) {
            Log.e(LOG_TAG, "creating SubmitPdu failed: " + ex);
        }
        return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.654 -0400", hash_original_method = "D3C9920CEA488FFF412D7F8E3FE64835", hash_generated_method = "6CFABA9DB366A6587D18E30A715EDA1A")
    private void createPdu() {
        SmsEnvelope env = mEnvelope;
        CdmaSmsAddress addr = env.origAddress;
        ByteArrayOutputStream baos = new ByteArrayOutputStream(100);
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
        try 
        {
            dos.writeInt(env.messageType);
            dos.writeInt(env.teleService);
            dos.writeInt(env.serviceCategory);
            dos.writeByte(addr.digitMode);
            dos.writeByte(addr.numberMode);
            dos.writeByte(addr.ton);
            dos.writeByte(addr.numberPlan);
            dos.writeByte(addr.numberOfDigits);
            dos.write(addr.origBytes, 0, addr.origBytes.length);
            dos.writeInt(env.bearerReply);
            dos.writeByte(env.replySeqNo);
            dos.writeByte(env.errorClass);
            dos.writeByte(env.causeCode);
            dos.writeInt(env.bearerData.length);
            dos.write(env.bearerData, 0, env.bearerData.length);
            dos.close();
            mPdu = baos.toByteArray();
        } 
        catch (IOException ex)
        { }
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.655 -0400", hash_original_method = "A11C498F23B8370C7C5D04AE2A0C173A", hash_generated_method = "BE841F22619666F99E1C3BC7DCA21A98")
    private byte convertDtmfToAscii(byte dtmfDigit) {
        byte asciiDigit;
        
        asciiDigit = 68;
        
        
        asciiDigit = 49;
        
        
        asciiDigit = 50;
        
        
        asciiDigit = 51;
        
        
        asciiDigit = 52;
        
        
        asciiDigit = 53;
        
        
        asciiDigit = 54;
        
        
        asciiDigit = 55;
        
        
        asciiDigit = 56;
        
        
        asciiDigit = 57;
        
        
        asciiDigit = 48;
        
        
        asciiDigit = 42;
        
        
        asciiDigit = 35;
        
        
        asciiDigit = 65;
        
        
        asciiDigit = 66;
        
        
        asciiDigit = 67;
        
        
        asciiDigit = 32;
        
        addTaint(dtmfDigit);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1262994908 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1262994908;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.655 -0400", hash_original_method = "D8D3E4C6269124C18E32B3734994B647", hash_generated_method = "48544C8A9E9F0E6199943D6CCAADCC38")
     int getNumOfVoicemails() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2106661654 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2106661654;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.655 -0400", hash_original_method = "ECE8D39C64EEB1FB74B915B4B0882D92", hash_generated_method = "6E844C2F9C576BBA66843BF716BE375B")
     byte[] getIncomingSmsFingerprint() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        output.write(mEnvelope.teleService);
        output.write(mEnvelope.origAddress.origBytes, 0, mEnvelope.origAddress.origBytes.length);
        output.write(mEnvelope.bearerData, 0, mEnvelope.bearerData.length);
        output.write(mEnvelope.origSubaddress.origBytes, 0,
                mEnvelope.origSubaddress.origBytes.length);
        byte[] varD65B1590CAD42F2218BC6B027D7F1F69_519484159 = (output.toByteArray());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_316555712 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_316555712;
        
        
        
        
        
        
                
        
    }

    
    public static class SubmitPdu extends SubmitPduBase {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.655 -0400", hash_original_method = "0DF27C295EE94AE1A62B7F3B1FD6EBC8", hash_generated_method = "0DF27C295EE94AE1A62B7F3B1FD6EBC8")
        public SubmitPdu ()
        {
            
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.655 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.655 -0400", hash_original_field = "2357469872D5866F26D2C822CE46923A", hash_generated_field = "9363CC8A66AF573FDD4C4EAFB23F1719")

    static private final String LOGGABLE_TAG = "CDMA:SMS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.655 -0400", hash_original_field = "586EB1142AC53CB99BE028392095D8BB", hash_generated_field = "C65F2A73F946D436D2201029781974D6")

    private final static byte TELESERVICE_IDENTIFIER = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.655 -0400", hash_original_field = "C8AF7D5EB333D182386F1FC3882B810E", hash_generated_field = "631EA667FBE5CC787A050F2AB978AD26")

    private final static byte SERVICE_CATEGORY = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.656 -0400", hash_original_field = "5AE3C2F79714CA36272DA80E33B1B0A8", hash_generated_field = "4C46DFCF7F018BB58EF0EDDE72736A41")

    private final static byte ORIGINATING_ADDRESS = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.656 -0400", hash_original_field = "356ADB5AD2DB0C4F17D3825A2E90ACA3", hash_generated_field = "75958DD895EF30960C4DDC1BFED7AB3E")

    private final static byte ORIGINATING_SUB_ADDRESS = 0x03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.656 -0400", hash_original_field = "44891CF0577CAA3FD705D212F4F82F5E", hash_generated_field = "C80E39CEEAD1FA46761297E1FD4776A7")

    private final static byte DESTINATION_ADDRESS = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.656 -0400", hash_original_field = "776A6C166231D3F49EFE98B8D08DF50D", hash_generated_field = "8CED3132652626592505768E52936428")

    private final static byte DESTINATION_SUB_ADDRESS = 0x05;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.656 -0400", hash_original_field = "7C411674CD7DE01D2A1030D8678CCAD8", hash_generated_field = "18C838A90451BDFF11B450AA4B244836")

    private final static byte BEARER_REPLY_OPTION = 0x06;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.656 -0400", hash_original_field = "9A870FDAF4C94D158F7498EDFEDDEFF1", hash_generated_field = "CDDDEAEC17D512E97A804AE8045B86BF")

    private final static byte CAUSE_CODES = 0x07;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.656 -0400", hash_original_field = "9F8FD0F2F108645C92EA36ACEB7F6445", hash_generated_field = "62CE98B8DFD2FCF87BE739E43598B88F")

    private final static byte BEARER_DATA = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.656 -0400", hash_original_field = "808CF176668759542730D3A9E33D8973", hash_generated_field = "FDDF3DFB7B3487AEC77BD14175979048")

    private static final int RETURN_NO_ACK = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.656 -0400", hash_original_field = "A2C9B5227CB49EA24E33A00C98117287", hash_generated_field = "8243279A7C0906DDE4D2CCFF57A1DBAA")

    private static final int RETURN_ACK = 1;
}


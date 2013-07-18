package com.android.internal.telephony.cdma;

// Droidsafe Imports
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import android.os.Parcel;
import android.os.SystemProperties;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsMessage.MessageClass;
import android.util.Log;

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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class SmsMessage extends SmsMessageBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.476 -0400", hash_original_field = "9ACB44549B41563697BB490144EC6258", hash_generated_field = "4BAC49709EDEAEFDD9E07400E0F02406")

    private int status;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.476 -0400", hash_original_field = "10C68415B1F778960BA74C87DE7F141E", hash_generated_field = "5DE432FC9FD653332885B7638256C4A9")

    private SmsEnvelope mEnvelope;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.476 -0400", hash_original_field = "1BFE3A3CA6EAE69ADBFFE668557EC2BA", hash_generated_field = "B90F3642F146E4CB5B7C5D2425641201")

    private BearerData mBearerData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.477 -0400", hash_original_method = "6C523C791261F68A00BC5A8339EB91FE", hash_generated_method = "6C523C791261F68A00BC5A8339EB91FE")
    public SmsMessage ()
    {
        //Synthesized constructor
    }


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

    
    public static int getTPLayerLengthForPDU(String pdu) {
        Log.w(LOG_TAG, "getTPLayerLengthForPDU: is not supported in CDMA mode.");
        return 0;
    }

    
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

    
    public static SubmitPdu getSubmitPdu(String destAddr, UserData userData,
            boolean statusReportRequested) {
        return privateGetSubmitPdu(destAddr, statusReportRequested, userData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.479 -0400", hash_original_method = "CFC9E8C6C71B803A9382349B0D254790", hash_generated_method = "1F57308214B748BCF5A82A90F93256EE")
    public int getProtocolIdentifier() {
        int varCFCD208495D565EF66E7DFF9F98764DA_977416047 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1710992799 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1710992799;
        // ---------- Original Method ----------
        //Log.w(LOG_TAG, "getProtocolIdentifier: is not supported in CDMA mode.");
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.479 -0400", hash_original_method = "95CFCAABC583EA802C704015EAFBF308", hash_generated_method = "63BBF7474C25D11B1B00FBAF88019158")
    public boolean isReplace() {
        boolean var68934A3E9455FA72420237EB05902327_1811186438 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1758457494 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1758457494;
        // ---------- Original Method ----------
        //Log.w(LOG_TAG, "isReplace: is not supported in CDMA mode.");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.479 -0400", hash_original_method = "201DA8455DBB44F9D4BF017BFCDAFF9F", hash_generated_method = "3374A64876A28354F454548299E70D62")
    public boolean isCphsMwiMessage() {
        boolean var68934A3E9455FA72420237EB05902327_235353151 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1014732705 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1014732705;
        // ---------- Original Method ----------
        //Log.w(LOG_TAG, "isCphsMwiMessage: is not supported in CDMA mode.");
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.479 -0400", hash_original_method = "B638C86EC79B8E5FA2D28FA811D2BCF0", hash_generated_method = "6490B2C97E6C9F77F24A12BBAA8C019B")
    public boolean isMWIClearMessage() {
        boolean varCDC0D2B9455043ACA6E69FC0C3F2AA03_1612772789 = (((mBearerData != null) && (mBearerData.numberOfMessages == 0)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1351591523 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1351591523;
        // ---------- Original Method ----------
        //return ((mBearerData != null) && (mBearerData.numberOfMessages == 0));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.479 -0400", hash_original_method = "E19020FF854A35A2375E0A8AE070BF97", hash_generated_method = "FB7275FC48C23692B0F13B4A356B1325")
    public boolean isMWISetMessage() {
        boolean var3A821AFD2F1E1DE1ED4A7C344D339411_1604977720 = (((mBearerData != null) && (mBearerData.numberOfMessages > 0)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_749954937 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_749954937;
        // ---------- Original Method ----------
        //return ((mBearerData != null) && (mBearerData.numberOfMessages > 0));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.480 -0400", hash_original_method = "2F5A490D5EB0B5469046C11BA63EC135", hash_generated_method = "65244972F660A00451DBBEE7AF024FED")
    public boolean isMwiDontStore() {
        boolean var9530482742C8847ECF3D5116815F9984_1208733773 = (((mBearerData != null) &&
                (mBearerData.numberOfMessages > 0) &&
                (mBearerData.userData == null)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1046921106 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1046921106;
        // ---------- Original Method ----------
        //return ((mBearerData != null) &&
                //(mBearerData.numberOfMessages > 0) &&
                //(mBearerData.userData == null));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.480 -0400", hash_original_method = "03B5EE24FC37A73D7F31FE2BAB3C2BFD", hash_generated_method = "7339F73BD6920300BD8E3EB097D88CF4")
    public int getStatus() {
        int varF4217B46F01EF5F8AD25E97FB7D98330_959771723 = ((status << 16));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1427721950 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1427721950;
        // ---------- Original Method ----------
        //return (status << 16);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.480 -0400", hash_original_method = "A75C98E30CFF18DAC25DE4B33918A3F4", hash_generated_method = "60A54B1DF93304F95B9EE1D4A596DE3A")
    public boolean isStatusReportMessage() {
        boolean var73AF530F917F0C44D17B9DDEF7AC1C59_1669596818 = ((mBearerData.messageType == BearerData.MESSAGE_TYPE_DELIVERY_ACK));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_886513378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_886513378;
        // ---------- Original Method ----------
        //return (mBearerData.messageType == BearerData.MESSAGE_TYPE_DELIVERY_ACK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.480 -0400", hash_original_method = "0F1242A5312C3945C722AC39BFD87EF2", hash_generated_method = "4A71408FA225E477BB9548BA33F34672")
    public boolean isReplyPathPresent() {
        boolean var68934A3E9455FA72420237EB05902327_1392605559 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1310639815 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1310639815;
        // ---------- Original Method ----------
        //Log.w(LOG_TAG, "isReplyPathPresent: is not supported in CDMA mode.");
        //return false;
    }

    
    public static TextEncodingDetails calculateLength(CharSequence messageBody,
            boolean use7bitOnly) {
        return BearerData.calcTextEncodingDetails(messageBody, use7bitOnly);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.480 -0400", hash_original_method = "BA17728EC06E4E9670ACA616D9E29C12", hash_generated_method = "B93DA0EFE681AF32B1011EE7AAAB43E5")
     int getTeleService() {
        int var8FF11A73CEE147175526274385453324_450715326 = (mEnvelope.teleService);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_414755683 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_414755683;
        // ---------- Original Method ----------
        //return mEnvelope.teleService;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.480 -0400", hash_original_method = "1BE3451C0D43919E5115D33DA4A62DB3", hash_generated_method = "481795DFD1FF852694D59D87A2C234AC")
     int getMessageType() {
        int varB4DA1871429D0F7F59A63AFB3855201C_1980536725 = (mEnvelope.messageType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_133331501 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_133331501;
        // ---------- Original Method ----------
        //return mEnvelope.messageType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.481 -0400", hash_original_method = "CD6FB45A1A4A8300476A32D9A94A5A2D", hash_generated_method = "2247BF293B6A55F71CB7159A7C65A9B4")
    private void parsePdu(byte[] pdu) {
        addTaint(pdu[0]);
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
        } //End block
        catch (Exception ex)
        {
        } //End block
        originatingAddress = addr;
        env.origAddress = addr;
        mEnvelope = env;
        mPdu = pdu;
        parseSms();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.483 -0400", hash_original_method = "4600019E789700BB681DB9CDCB53078A", hash_generated_method = "03CA9AA858FFE620C961C9FBFD821563")
    private void parsePduFromEfRecord(byte[] pdu) {
        addTaint(pdu[0]);
        ByteArrayInputStream bais = new ByteArrayInputStream(pdu);
        DataInputStream dis = new DataInputStream(bais);
        SmsEnvelope env = new SmsEnvelope();
        CdmaSmsAddress addr = new CdmaSmsAddress();
        CdmaSmsSubaddress subAddr = new CdmaSmsSubaddress();
        try 
        {
            env.messageType = dis.readByte();
            while
(dis.available() > 0)            
            {
                int parameterId = dis.readByte();
                int parameterLen = dis.readByte();
                byte[] parameterData = new byte[parameterLen];
switch(parameterId){
                case TELESERVICE_IDENTIFIER:
                env.teleService = dis.readUnsignedShort();
                break;
                case SERVICE_CATEGORY:
                env.serviceCategory = dis.readUnsignedShort();
                break;
                case ORIGINATING_ADDRESS:
                case DESTINATION_ADDRESS:
                dis.read(parameterData, 0, parameterLen);
                BitwiseInputStream addrBis = new BitwiseInputStream(parameterData);
                addr.digitMode = addrBis.read(1);
                addr.numberMode = addrBis.read(1);
                int numberType = 0;
                if(addr.digitMode == CdmaSmsAddress.DIGIT_MODE_8BIT_CHAR)                
                {
                    numberType = addrBis.read(3);
                    addr.ton = numberType;
                    if(addr.numberMode == CdmaSmsAddress.NUMBER_MODE_NOT_DATA_NETWORK)                    
                    addr.numberPlan = addrBis.read(4);
                } //End block
                addr.numberOfDigits = addrBis.read(8);
                byte[] data = new byte[addr.numberOfDigits];
                byte b = 0x00;
                if(addr.digitMode == CdmaSmsAddress.DIGIT_MODE_4BIT_DTMF)                
                {
for(int index = 0;index < addr.numberOfDigits;index++)
                    {
                        b = (byte) (0xF & addrBis.read(4));
                        data[index] = convertDtmfToAscii(b);
                    } //End block
                } //End block
                else
                if(addr.digitMode == CdmaSmsAddress.DIGIT_MODE_8BIT_CHAR)                
                {
                    if(addr.numberMode == CdmaSmsAddress.NUMBER_MODE_NOT_DATA_NETWORK)                    
                    {
for(int index = 0;index < addr.numberOfDigits;index++)
                        {
                            b = (byte) (0xFF & addrBis.read(8));
                            data[index] = b;
                        } //End block
                    } //End block
                    else
                    if(addr.numberMode == CdmaSmsAddress.NUMBER_MODE_DATA_NETWORK)                    
                    {
                        if(numberType == 2){ }
                    } //End block
                    else
                    {
                    } //End block
                } //End block
                else
                {
                } //End block
                addr.origBytes = data;
                break;
                case ORIGINATING_SUB_ADDRESS:
                case DESTINATION_SUB_ADDRESS:
                dis.read(parameterData, 0, parameterLen);
                BitwiseInputStream subAddrBis = new BitwiseInputStream(parameterData);
                subAddr.type = subAddrBis.read(3);
                subAddr.odd = subAddrBis.readByteArray(1)[0];
                int subAddrLen = subAddrBis.read(8);
                byte[] subdata = new byte[subAddrLen];
for(int index = 0;index < subAddrLen;index++)
                {
                    b = (byte) (0xFF & subAddrBis.read(4));
                    subdata[index] = convertDtmfToAscii(b);
                } //End block
                subAddr.origBytes = subdata;
                break;
                case BEARER_REPLY_OPTION:
                dis.read(parameterData, 0, parameterLen);
                BitwiseInputStream replyOptBis = new BitwiseInputStream(parameterData);
                env.bearerReply = replyOptBis.read(6);
                break;
                case CAUSE_CODES:
                dis.read(parameterData, 0, parameterLen);
                BitwiseInputStream ccBis = new BitwiseInputStream(parameterData);
                env.replySeqNo = ccBis.readByteArray(6)[0];
                env.errorClass = ccBis.readByteArray(2)[0];
                if(env.errorClass != 0x00)                
                env.causeCode = ccBis.readByteArray(8)[0];
                break;
                case BEARER_DATA:
                dis.read(parameterData, 0, parameterLen);
                env.bearerData = parameterData;
                break;
                default:
                Exception var8D2296B02A7A072B6BA49FFB271B0C85_646402841 = new Exception("unsupported parameterId (" + parameterId + ")");
                var8D2296B02A7A072B6BA49FFB271B0C85_646402841.addTaint(taint);
                throw var8D2296B02A7A072B6BA49FFB271B0C85_646402841;
}
            } //End block
            bais.close();
            dis.close();
        } //End block
        catch (Exception ex)
        {
        } //End block
        originatingAddress = addr;
        env.origAddress = addr;
        env.origSubaddress = subAddr;
        mEnvelope = env;
        mPdu = pdu;
        parseSms();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.484 -0400", hash_original_method = "64AD6AE28B963471C0AF85BE0E89B856", hash_generated_method = "0A17B17D92EE2A3116056BE09D5F7714")
    protected void parseSms() {
        if(mEnvelope.teleService == SmsEnvelope.TELESERVICE_MWI)        
        {
            mBearerData = new BearerData();
            if(mEnvelope.bearerData != null)            
            {
                mBearerData.numberOfMessages = 0x000000FF & mEnvelope.bearerData[0];
            } //End block
            if(false)            
            {
                Log.d(LOG_TAG, "parseSms: get MWI " +
                      Integer.toString(mBearerData.numberOfMessages));
            } //End block
            return;
        } //End block
        mBearerData = BearerData.decode(mEnvelope.bearerData);
        if(Log.isLoggable(LOGGABLE_TAG, Log.VERBOSE))        
        {
            Log.d(LOG_TAG, "MT raw BearerData = '" +
                      HexDump.toHexString(mEnvelope.bearerData) + "'");
            Log.d(LOG_TAG, "MT (decoded) BearerData = " + mBearerData);
        } //End block
        messageRef = mBearerData.messageId;
        if(mBearerData.userData != null)        
        {
            userData = mBearerData.userData.payload;
            userDataHeader = mBearerData.userData.userDataHeader;
            messageBody = mBearerData.userData.payloadStr;
        } //End block
        if(originatingAddress != null)        
        {
            originatingAddress.address = new String(originatingAddress.origBytes);
            if(false){ }
        } //End block
        if(mBearerData.msgCenterTimeStamp != null)        
        {
            scTimeMillis = mBearerData.msgCenterTimeStamp.toMillis(true);
        } //End block
        if(false)        
        Log.d(LOG_TAG, "SMS SC timestamp: " + scTimeMillis);
        if(mBearerData.messageType == BearerData.MESSAGE_TYPE_DELIVERY_ACK)        
        {
            if(! mBearerData.messageStatusSet)            
            {
                Log.d(LOG_TAG, "DELIVERY_ACK message without msgStatus (" +
                        (userData == null ? "also missing" : "does have") +
                        " userData).");
                status = 0;
            } //End block
            else
            {
                status = mBearerData.errorClass << 8;
                status |= mBearerData.messageStatus;
            } //End block
        } //End block
        else
        if(mBearerData.messageType != BearerData.MESSAGE_TYPE_DELIVER)        
        {
            RuntimeException varA5A0121C26832F7D104A34AFB630EDD4_1935678825 = new RuntimeException("Unsupported message type: " + mBearerData.messageType);
            varA5A0121C26832F7D104A34AFB630EDD4_1935678825.addTaint(taint);
            throw varA5A0121C26832F7D104A34AFB630EDD4_1935678825;
        } //End block
        if(messageBody != null)        
        {
            if(false){ }            parseMessageBody();
        } //End block
        else
        if((userData != null) && (false))        
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.485 -0400", hash_original_method = "7EF6A65398433E9B1CBF5DF28BDBF834", hash_generated_method = "34FA034D0A345EC842367B2C4748BBAE")
    public MessageClass getMessageClass() {
        if(BearerData.DISPLAY_MODE_IMMEDIATE == mBearerData.displayMode)        
        {
MessageClass varE061C48ACABC1B8BC768E940A25E3735_991577267 =             MessageClass.CLASS_0;
            varE061C48ACABC1B8BC768E940A25E3735_991577267.addTaint(taint);
            return varE061C48ACABC1B8BC768E940A25E3735_991577267;
        } //End block
        else
        {
MessageClass varD7AAFCD744EEA0B66C34410F065237FA_268988632 =             MessageClass.UNKNOWN;
            varD7AAFCD744EEA0B66C34410F065237FA_268988632.addTaint(taint);
            return varD7AAFCD744EEA0B66C34410F065237FA_268988632;
        } //End block
        // ---------- Original Method ----------
        //if (BearerData.DISPLAY_MODE_IMMEDIATE == mBearerData.displayMode ) {
            //return MessageClass.CLASS_0;
        //} else {
            //return MessageClass.UNKNOWN;
        //}
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.485 -0400", hash_original_method = "D3C9920CEA488FFF412D7F8E3FE64835", hash_generated_method = "FCC30460848B7588E0A43ABC0ABBA9FB")
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
        } //End block
        catch (IOException ex)
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.486 -0400", hash_original_method = "A11C498F23B8370C7C5D04AE2A0C173A", hash_generated_method = "3208978665429799D9015E3D2336705B")
    private byte convertDtmfToAscii(byte dtmfDigit) {
        addTaint(dtmfDigit);
        byte asciiDigit;
switch(dtmfDigit){
        case  0:
        asciiDigit = 68;
        break;
        case  1:
        asciiDigit = 49;
        break;
        case  2:
        asciiDigit = 50;
        break;
        case  3:
        asciiDigit = 51;
        break;
        case  4:
        asciiDigit = 52;
        break;
        case  5:
        asciiDigit = 53;
        break;
        case  6:
        asciiDigit = 54;
        break;
        case  7:
        asciiDigit = 55;
        break;
        case  8:
        asciiDigit = 56;
        break;
        case  9:
        asciiDigit = 57;
        break;
        case 10:
        asciiDigit = 48;
        break;
        case 11:
        asciiDigit = 42;
        break;
        case 12:
        asciiDigit = 35;
        break;
        case 13:
        asciiDigit = 65;
        break;
        case 14:
        asciiDigit = 66;
        break;
        case 15:
        asciiDigit = 67;
        break;
        default:
        asciiDigit = 32;
        break;
}        byte var21522A7080D1DD34A6C08FDA3E7B8923_1022080914 = (asciiDigit);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_1191634368 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1191634368;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.486 -0400", hash_original_method = "D8D3E4C6269124C18E32B3734994B647", hash_generated_method = "60A3A7925FEC9AF05ACFFD4361305F57")
     int getNumOfVoicemails() {
        int var8E3F21144FF0BAA03A1A56B1E68F39D4_1004982328 = (mBearerData.numberOfMessages);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1189414479 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1189414479;
        // ---------- Original Method ----------
        //return mBearerData.numberOfMessages;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.486 -0400", hash_original_method = "ECE8D39C64EEB1FB74B915B4B0882D92", hash_generated_method = "CBA641B835AF79EEC0540A9A15250B0F")
     byte[] getIncomingSmsFingerprint() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        output.write(mEnvelope.teleService);
        output.write(mEnvelope.origAddress.origBytes, 0, mEnvelope.origAddress.origBytes.length);
        output.write(mEnvelope.bearerData, 0, mEnvelope.bearerData.length);
        output.write(mEnvelope.origSubaddress.origBytes, 0,
                mEnvelope.origSubaddress.origBytes.length);
        byte[] var81457E86CC2B68A315C17AA75B3E3FCD_1635139377 = (output.toByteArray());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_476063076 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_476063076;
        // ---------- Original Method ----------
        //ByteArrayOutputStream output = new ByteArrayOutputStream();
        //output.write(mEnvelope.teleService);
        //output.write(mEnvelope.origAddress.origBytes, 0, mEnvelope.origAddress.origBytes.length);
        //output.write(mEnvelope.bearerData, 0, mEnvelope.bearerData.length);
        //output.write(mEnvelope.origSubaddress.origBytes, 0,
                //mEnvelope.origSubaddress.origBytes.length);
        //return output.toByteArray();
    }

    
    public static class SubmitPdu extends SubmitPduBase {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.486 -0400", hash_original_method = "0DF27C295EE94AE1A62B7F3B1FD6EBC8", hash_generated_method = "0DF27C295EE94AE1A62B7F3B1FD6EBC8")
        public SubmitPdu ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.486 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.486 -0400", hash_original_field = "2357469872D5866F26D2C822CE46923A", hash_generated_field = "9363CC8A66AF573FDD4C4EAFB23F1719")

    static private final String LOGGABLE_TAG = "CDMA:SMS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.487 -0400", hash_original_field = "586EB1142AC53CB99BE028392095D8BB", hash_generated_field = "C65F2A73F946D436D2201029781974D6")

    private final static byte TELESERVICE_IDENTIFIER = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.487 -0400", hash_original_field = "C8AF7D5EB333D182386F1FC3882B810E", hash_generated_field = "631EA667FBE5CC787A050F2AB978AD26")

    private final static byte SERVICE_CATEGORY = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.487 -0400", hash_original_field = "5AE3C2F79714CA36272DA80E33B1B0A8", hash_generated_field = "4C46DFCF7F018BB58EF0EDDE72736A41")

    private final static byte ORIGINATING_ADDRESS = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.487 -0400", hash_original_field = "356ADB5AD2DB0C4F17D3825A2E90ACA3", hash_generated_field = "75958DD895EF30960C4DDC1BFED7AB3E")

    private final static byte ORIGINATING_SUB_ADDRESS = 0x03;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.487 -0400", hash_original_field = "44891CF0577CAA3FD705D212F4F82F5E", hash_generated_field = "C80E39CEEAD1FA46761297E1FD4776A7")

    private final static byte DESTINATION_ADDRESS = 0x04;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.487 -0400", hash_original_field = "776A6C166231D3F49EFE98B8D08DF50D", hash_generated_field = "8CED3132652626592505768E52936428")

    private final static byte DESTINATION_SUB_ADDRESS = 0x05;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.487 -0400", hash_original_field = "7C411674CD7DE01D2A1030D8678CCAD8", hash_generated_field = "18C838A90451BDFF11B450AA4B244836")

    private final static byte BEARER_REPLY_OPTION = 0x06;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.487 -0400", hash_original_field = "9A870FDAF4C94D158F7498EDFEDDEFF1", hash_generated_field = "CDDDEAEC17D512E97A804AE8045B86BF")

    private final static byte CAUSE_CODES = 0x07;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.487 -0400", hash_original_field = "9F8FD0F2F108645C92EA36ACEB7F6445", hash_generated_field = "62CE98B8DFD2FCF87BE739E43598B88F")

    private final static byte BEARER_DATA = 0x08;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.487 -0400", hash_original_field = "808CF176668759542730D3A9E33D8973", hash_generated_field = "FDDF3DFB7B3487AEC77BD14175979048")

    private static final int RETURN_NO_ACK = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.487 -0400", hash_original_field = "A2C9B5227CB49EA24E33A00C98117287", hash_generated_field = "8243279A7C0906DDE4D2CCFF57A1DBAA")

    private static final int RETURN_ACK = 1;
}


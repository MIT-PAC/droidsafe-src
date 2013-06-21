package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private int status;
    private SmsEnvelope mEnvelope;
    private BearerData mBearerData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.900 -0400", hash_original_method = "C72C4FDBCEC8D62FDBBCA2E507E59AB6", hash_generated_method = "C72C4FDBCEC8D62FDBBCA2E507E59AB6")
        public SmsMessage ()
    {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.902 -0400", hash_original_method = "CFC9E8C6C71B803A9382349B0D254790", hash_generated_method = "4F95C7F0239AD56187838C9DAC9C790E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getProtocolIdentifier() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Log.w(LOG_TAG, "getProtocolIdentifier: is not supported in CDMA mode.");
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.902 -0400", hash_original_method = "95CFCAABC583EA802C704015EAFBF308", hash_generated_method = "D37A56AB82309BBB71EA627343A3B71C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isReplace() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Log.w(LOG_TAG, "isReplace: is not supported in CDMA mode.");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.902 -0400", hash_original_method = "201DA8455DBB44F9D4BF017BFCDAFF9F", hash_generated_method = "2C50877D3C16EA516C258A3EEF7A92C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isCphsMwiMessage() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Log.w(LOG_TAG, "isCphsMwiMessage: is not supported in CDMA mode.");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.902 -0400", hash_original_method = "B638C86EC79B8E5FA2D28FA811D2BCF0", hash_generated_method = "AD76FB378108A970961043824C6134E1")
    @DSModeled(DSC.SAFE)
    public boolean isMWIClearMessage() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((mBearerData != null) && (mBearerData.numberOfMessages == 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.903 -0400", hash_original_method = "E19020FF854A35A2375E0A8AE070BF97", hash_generated_method = "313D1293E8CA75ACC5D5E4464786C41C")
    @DSModeled(DSC.SAFE)
    public boolean isMWISetMessage() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((mBearerData != null) && (mBearerData.numberOfMessages > 0));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.903 -0400", hash_original_method = "2F5A490D5EB0B5469046C11BA63EC135", hash_generated_method = "BAD14A2CC6B0F0D7A45AD7749FD7EDCD")
    @DSModeled(DSC.SAFE)
    public boolean isMwiDontStore() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((mBearerData != null) &&
                //(mBearerData.numberOfMessages > 0) &&
                //(mBearerData.userData == null));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.903 -0400", hash_original_method = "03B5EE24FC37A73D7F31FE2BAB3C2BFD", hash_generated_method = "B70F1D0380B51D1681DA0ED556E28F03")
    @DSModeled(DSC.SAFE)
    public int getStatus() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (status << 16);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.903 -0400", hash_original_method = "A75C98E30CFF18DAC25DE4B33918A3F4", hash_generated_method = "86863D9DB3B3066715C8CDDA8D0754D8")
    @DSModeled(DSC.SAFE)
    public boolean isStatusReportMessage() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mBearerData.messageType == BearerData.MESSAGE_TYPE_DELIVERY_ACK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.903 -0400", hash_original_method = "0F1242A5312C3945C722AC39BFD87EF2", hash_generated_method = "DE69F114A71FCDCB65CC00D8DE7C1022")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isReplyPathPresent() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Log.w(LOG_TAG, "isReplyPathPresent: is not supported in CDMA mode.");
        //return false;
    }

    
        public static TextEncodingDetails calculateLength(CharSequence messageBody,
            boolean use7bitOnly) {
        return BearerData.calcTextEncodingDetails(messageBody, use7bitOnly);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.904 -0400", hash_original_method = "BA17728EC06E4E9670ACA616D9E29C12", hash_generated_method = "3D34181540531964DD450FA08E4E9983")
    @DSModeled(DSC.SAFE)
     int getTeleService() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mEnvelope.teleService;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.904 -0400", hash_original_method = "1BE3451C0D43919E5115D33DA4A62DB3", hash_generated_method = "C9BB8AF0F0B06F74128246D0DDACBD20")
    @DSModeled(DSC.SAFE)
     int getMessageType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mEnvelope.messageType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.904 -0400", hash_original_method = "CD6FB45A1A4A8300476A32D9A94A5A2D", hash_generated_method = "547BB0154F8ABC12134C8C2270F2E73A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parsePdu(byte[] pdu) {
        dsTaint.addTaint(pdu[0]);
        ByteArrayInputStream bais;
        bais = new ByteArrayInputStream(pdu);
        DataInputStream dis;
        dis = new DataInputStream(bais);
        byte length;
        int bearerDataLength;
        SmsEnvelope env;
        env = new SmsEnvelope();
        CdmaSmsAddress addr;
        addr = new CdmaSmsAddress();
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
        { }
        originatingAddress = addr;
        env.origAddress = addr;
        mEnvelope = env;
        mPdu = pdu;
        parseSms();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.906 -0400", hash_original_method = "4600019E789700BB681DB9CDCB53078A", hash_generated_method = "3A483D6A53E5E931A92E8F2114ED6DE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parsePduFromEfRecord(byte[] pdu) {
        dsTaint.addTaint(pdu[0]);
        ByteArrayInputStream bais;
        bais = new ByteArrayInputStream(pdu);
        DataInputStream dis;
        dis = new DataInputStream(bais);
        SmsEnvelope env;
        env = new SmsEnvelope();
        CdmaSmsAddress addr;
        addr = new CdmaSmsAddress();
        CdmaSmsSubaddress subAddr;
        subAddr = new CdmaSmsSubaddress();
        try 
        {
            env.messageType = dis.readByte();
            {
                boolean varCB89B9C40A54203B21970E3B5D78C366_1714863586 = (dis.available() > 0);
                {
                    int parameterId;
                    parameterId = dis.readByte();
                    int parameterLen;
                    parameterLen = dis.readByte();
                    byte[] parameterData;
                    parameterData = new byte[parameterLen];
                    //Begin case TELESERVICE_IDENTIFIER 
                    env.teleService = dis.readUnsignedShort();
                    //End case TELESERVICE_IDENTIFIER 
                    //Begin case SERVICE_CATEGORY 
                    env.serviceCategory = dis.readUnsignedShort();
                    //End case SERVICE_CATEGORY 
                    //Begin case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    dis.read(parameterData, 0, parameterLen);
                    //End case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    //Begin case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    BitwiseInputStream addrBis;
                    addrBis = new BitwiseInputStream(parameterData);
                    //End case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    //Begin case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    addr.digitMode = addrBis.read(1);
                    //End case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    //Begin case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    addr.numberMode = addrBis.read(1);
                    //End case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    //Begin case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    int numberType;
                    numberType = 0;
                    //End case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    //Begin case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    {
                        numberType = addrBis.read(3);
                        addr.ton = numberType;
                        addr.numberPlan = addrBis.read(4);
                    } //End block
                    //End case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    //Begin case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    addr.numberOfDigits = addrBis.read(8);
                    //End case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    //Begin case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    byte[] data;
                    data = new byte[addr.numberOfDigits];
                    //End case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    //Begin case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    byte b;
                    b = 0x00;
                    //End case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    //Begin case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    {
                        {
                            int index;
                            index = 0;
                            {
                                b = (byte) (0xF & addrBis.read(4));
                                data[index] = convertDtmfToAscii(b);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            {
                                int index;
                                index = 0;
                                {
                                    b = (byte) (0xFF & addrBis.read(8));
                                    data[index] = b;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                    //End case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    //Begin case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    addr.origBytes = data;
                    //End case ORIGINATING_ADDRESS DESTINATION_ADDRESS 
                    //Begin case ORIGINATING_SUB_ADDRESS DESTINATION_SUB_ADDRESS 
                    dis.read(parameterData, 0, parameterLen);
                    //End case ORIGINATING_SUB_ADDRESS DESTINATION_SUB_ADDRESS 
                    //Begin case ORIGINATING_SUB_ADDRESS DESTINATION_SUB_ADDRESS 
                    BitwiseInputStream subAddrBis;
                    subAddrBis = new BitwiseInputStream(parameterData);
                    //End case ORIGINATING_SUB_ADDRESS DESTINATION_SUB_ADDRESS 
                    //Begin case ORIGINATING_SUB_ADDRESS DESTINATION_SUB_ADDRESS 
                    subAddr.type = subAddrBis.read(3);
                    //End case ORIGINATING_SUB_ADDRESS DESTINATION_SUB_ADDRESS 
                    //Begin case ORIGINATING_SUB_ADDRESS DESTINATION_SUB_ADDRESS 
                    subAddr.odd = subAddrBis.readByteArray(1)[0];
                    //End case ORIGINATING_SUB_ADDRESS DESTINATION_SUB_ADDRESS 
                    //Begin case ORIGINATING_SUB_ADDRESS DESTINATION_SUB_ADDRESS 
                    int subAddrLen;
                    subAddrLen = subAddrBis.read(8);
                    //End case ORIGINATING_SUB_ADDRESS DESTINATION_SUB_ADDRESS 
                    //Begin case ORIGINATING_SUB_ADDRESS DESTINATION_SUB_ADDRESS 
                    byte[] subdata;
                    subdata = new byte[subAddrLen];
                    //End case ORIGINATING_SUB_ADDRESS DESTINATION_SUB_ADDRESS 
                    //Begin case ORIGINATING_SUB_ADDRESS DESTINATION_SUB_ADDRESS 
                    {
                        int index;
                        index = 0;
                        {
                            b = (byte) (0xFF & subAddrBis.read(4));
                            subdata[index] = convertDtmfToAscii(b);
                        } //End block
                    } //End collapsed parenthetic
                    //End case ORIGINATING_SUB_ADDRESS DESTINATION_SUB_ADDRESS 
                    //Begin case ORIGINATING_SUB_ADDRESS DESTINATION_SUB_ADDRESS 
                    subAddr.origBytes = subdata;
                    //End case ORIGINATING_SUB_ADDRESS DESTINATION_SUB_ADDRESS 
                    //Begin case BEARER_REPLY_OPTION 
                    dis.read(parameterData, 0, parameterLen);
                    //End case BEARER_REPLY_OPTION 
                    //Begin case BEARER_REPLY_OPTION 
                    BitwiseInputStream replyOptBis;
                    replyOptBis = new BitwiseInputStream(parameterData);
                    //End case BEARER_REPLY_OPTION 
                    //Begin case BEARER_REPLY_OPTION 
                    env.bearerReply = replyOptBis.read(6);
                    //End case BEARER_REPLY_OPTION 
                    //Begin case CAUSE_CODES 
                    dis.read(parameterData, 0, parameterLen);
                    //End case CAUSE_CODES 
                    //Begin case CAUSE_CODES 
                    BitwiseInputStream ccBis;
                    ccBis = new BitwiseInputStream(parameterData);
                    //End case CAUSE_CODES 
                    //Begin case CAUSE_CODES 
                    env.replySeqNo = ccBis.readByteArray(6)[0];
                    //End case CAUSE_CODES 
                    //Begin case CAUSE_CODES 
                    env.errorClass = ccBis.readByteArray(2)[0];
                    //End case CAUSE_CODES 
                    //Begin case CAUSE_CODES 
                    env.causeCode = ccBis.readByteArray(8)[0];
                    //End case CAUSE_CODES 
                    //Begin case BEARER_DATA 
                    dis.read(parameterData, 0, parameterLen);
                    //End case BEARER_DATA 
                    //Begin case BEARER_DATA 
                    env.bearerData = parameterData;
                    //End case BEARER_DATA 
                    //Begin case default 
                    if (DroidSafeAndroidRuntime.control) throw new Exception("unsupported parameterId (" + parameterId + ")");
                    //End case default 
                } //End block
            } //End collapsed parenthetic
            bais.close();
            dis.close();
        } //End block
        catch (Exception ex)
        { }
        originatingAddress = addr;
        env.origAddress = addr;
        env.origSubaddress = subAddr;
        mEnvelope = env;
        mPdu = pdu;
        parseSms();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.907 -0400", hash_original_method = "64AD6AE28B963471C0AF85BE0E89B856", hash_generated_method = "5948979246BEF607A91914C33695238D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void parseSms() {
        {
            mBearerData = new BearerData();
            {
                mBearerData.numberOfMessages = 0x000000FF & mEnvelope.bearerData[0];
            } //End block
            {
                Log.d(LOG_TAG, "parseSms: get MWI " +
                      Integer.toString(mBearerData.numberOfMessages));
            } //End block
        } //End block
        mBearerData = BearerData.decode(mEnvelope.bearerData);
        {
            boolean var48EBA01C947DF1F8CB9545D7AA0EB5C6_1232019668 = (Log.isLoggable(LOGGABLE_TAG, Log.VERBOSE));
            {
                Log.d(LOG_TAG, "MT raw BearerData = '" +
                      HexDump.toHexString(mEnvelope.bearerData) + "'");
                Log.d(LOG_TAG, "MT (decoded) BearerData = " + mBearerData);
            } //End block
        } //End collapsed parenthetic
        messageRef = mBearerData.messageId;
        {
            userData = mBearerData.userData.payload;
            userDataHeader = mBearerData.userData.userDataHeader;
            messageBody = mBearerData.userData.payloadStr;
        } //End block
        {
            originatingAddress.address = new String(originatingAddress.origBytes);
        } //End block
        {
            scTimeMillis = mBearerData.msgCenterTimeStamp.toMillis(true);
        } //End block
        Log.d(LOG_TAG, "SMS SC timestamp: " + scTimeMillis);
        {
            {
                Log.d(LOG_TAG, "DELIVERY_ACK message without msgStatus (" +
                        (userData == null ? "also missing" : "does have") +
                        " userData).");
                status = 0;
            } //End block
            {
                status = mBearerData.errorClass << 8;
                status |= mBearerData.messageStatus;
            } //End block
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unsupported message type: " + mBearerData.messageType);
        } //End block
        {
            parseMessageBody();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.907 -0400", hash_original_method = "7EF6A65398433E9B1CBF5DF28BDBF834", hash_generated_method = "AD9BA21134B80E6B9BE59107E037A308")
    @DSModeled(DSC.SAFE)
    public MessageClass getMessageClass() {
        return (MessageClass)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.908 -0400", hash_original_method = "D3C9920CEA488FFF412D7F8E3FE64835", hash_generated_method = "37F1EAC630B45BC15675F5A3AFDE06C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void createPdu() {
        SmsEnvelope env;
        env = mEnvelope;
        CdmaSmsAddress addr;
        addr = env.origAddress;
        ByteArrayOutputStream baos;
        baos = new ByteArrayOutputStream(100);
        DataOutputStream dos;
        dos = new DataOutputStream(new BufferedOutputStream(baos));
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
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.908 -0400", hash_original_method = "A11C498F23B8370C7C5D04AE2A0C173A", hash_generated_method = "DF80C065A89F00FB40564A5E88F90308")
    @DSModeled(DSC.SAFE)
    private byte convertDtmfToAscii(byte dtmfDigit) {
        dsTaint.addTaint(dtmfDigit);
        byte asciiDigit;
        //Begin case 0 
        asciiDigit = 68;
        //End case 0 
        //Begin case 1 
        asciiDigit = 49;
        //End case 1 
        //Begin case 2 
        asciiDigit = 50;
        //End case 2 
        //Begin case 3 
        asciiDigit = 51;
        //End case 3 
        //Begin case 4 
        asciiDigit = 52;
        //End case 4 
        //Begin case 5 
        asciiDigit = 53;
        //End case 5 
        //Begin case 6 
        asciiDigit = 54;
        //End case 6 
        //Begin case 7 
        asciiDigit = 55;
        //End case 7 
        //Begin case 8 
        asciiDigit = 56;
        //End case 8 
        //Begin case 9 
        asciiDigit = 57;
        //End case 9 
        //Begin case 10 
        asciiDigit = 48;
        //End case 10 
        //Begin case 11 
        asciiDigit = 42;
        //End case 11 
        //Begin case 12 
        asciiDigit = 35;
        //End case 12 
        //Begin case 13 
        asciiDigit = 65;
        //End case 13 
        //Begin case 14 
        asciiDigit = 66;
        //End case 14 
        //Begin case 15 
        asciiDigit = 67;
        //End case 15 
        //Begin case default 
        asciiDigit = 32;
        //End case default 
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.908 -0400", hash_original_method = "D8D3E4C6269124C18E32B3734994B647", hash_generated_method = "CBC487D1FD198F5519C7DD73DFFBBDEA")
    @DSModeled(DSC.SAFE)
     int getNumOfVoicemails() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBearerData.numberOfMessages;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.909 -0400", hash_original_method = "ECE8D39C64EEB1FB74B915B4B0882D92", hash_generated_method = "521D4D94398E1DA568EBB21E26234C47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     byte[] getIncomingSmsFingerprint() {
        ByteArrayOutputStream output;
        output = new ByteArrayOutputStream();
        output.write(mEnvelope.teleService);
        output.write(mEnvelope.origAddress.origBytes, 0, mEnvelope.origAddress.origBytes.length);
        output.write(mEnvelope.bearerData, 0, mEnvelope.bearerData.length);
        output.write(mEnvelope.origSubaddress.origBytes, 0,
                mEnvelope.origSubaddress.origBytes.length);
        byte[] varD65B1590CAD42F2218BC6B027D7F1F69_1203108637 = (output.toByteArray());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.909 -0400", hash_original_method = "B7DE6E4B5E35E85E322148859309B318", hash_generated_method = "B7DE6E4B5E35E85E322148859309B318")
                public SubmitPdu ()
        {
        }


    }


    
    static final String LOG_TAG = "CDMA";
    static private final String LOGGABLE_TAG = "CDMA:SMS";
    private final static byte TELESERVICE_IDENTIFIER                    = 0x00;
    private final static byte SERVICE_CATEGORY                          = 0x01;
    private final static byte ORIGINATING_ADDRESS                       = 0x02;
    private final static byte ORIGINATING_SUB_ADDRESS                   = 0x03;
    private final static byte DESTINATION_ADDRESS                       = 0x04;
    private final static byte DESTINATION_SUB_ADDRESS                   = 0x05;
    private final static byte BEARER_REPLY_OPTION                       = 0x06;
    private final static byte CAUSE_CODES                               = 0x07;
    private final static byte BEARER_DATA                               = 0x08;
    private static final int RETURN_NO_ACK  = 0;
    private static final int RETURN_ACK     = 1;
}


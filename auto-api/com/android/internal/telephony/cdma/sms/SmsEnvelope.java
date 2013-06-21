package com.android.internal.telephony.cdma.sms;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.cdma.sms.CdmaSmsSubaddress;

public final class SmsEnvelope {
    public int messageType;
    public int teleService = TELESERVICE_NOT_SET;
    public int serviceCategory;
    public CdmaSmsAddress origAddress;
    public CdmaSmsAddress destAddress;
    public CdmaSmsSubaddress origSubaddress;
    public int bearerReply;
    public byte replySeqNo;
    public byte errorClass;
    public byte causeCode;
    public byte[] bearerData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:14.032 -0400", hash_original_method = "63C615594341C58AE34F731D1CD086D9", hash_generated_method = "476E2A70F0F2BF824A0CD036D3873D68")
    @DSModeled(DSC.SAFE)
    public SmsEnvelope() {
        // ---------- Original Method ----------
    }

    
    static public final int MESSAGE_TYPE_POINT_TO_POINT   = 0x00;
    static public final int MESSAGE_TYPE_BROADCAST        = 0x01;
    static public final int MESSAGE_TYPE_ACKNOWLEDGE      = 0x02;
    static public final int TELESERVICE_NOT_SET           = 0x0000;
    static public final int TELESERVICE_WMT               = 0x1002;
    static public final int TELESERVICE_VMN               = 0x1003;
    static public final int TELESERVICE_WAP               = 0x1004;
    static public final int TELESERVICE_WEMT              = 0x1005;
    static public final int TELESERVICE_MWI               = 0x40000;
    static public final int SMS_BEARER_DATA_MAX = 255;
}


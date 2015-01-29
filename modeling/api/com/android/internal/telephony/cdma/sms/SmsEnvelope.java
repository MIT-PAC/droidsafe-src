package com.android.internal.telephony.cdma.sms;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class SmsEnvelope {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.373 -0500", hash_original_field = "0FE87CBBA33DE6795A87C7AE12FB63CD", hash_generated_field = "B5E654FAE63C8EC1AEFCC489ABA392C6")

    static public final int MESSAGE_TYPE_POINT_TO_POINT   = 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.376 -0500", hash_original_field = "4CAE5BCA140861B1B5C2D44528FC20B6", hash_generated_field = "B5FE7F329D4400C9A754C1E137CA3FF0")

    static public final int MESSAGE_TYPE_BROADCAST        = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.379 -0500", hash_original_field = "CEEDE01534EF124BB9BB8AB9043E78C7", hash_generated_field = "9F74A6530C9C0AF94CC7D19C45EC270B")

    static public final int MESSAGE_TYPE_ACKNOWLEDGE      = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.382 -0500", hash_original_field = "D1384409E20D55047A521BA9D54934EC", hash_generated_field = "10C362BEB09B044A326E37AFCFF6EA00")

    static public final int TELESERVICE_NOT_SET           = 0x0000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.385 -0500", hash_original_field = "A85A68666910F38D3AD8968F58AAF05A", hash_generated_field = "10C75ACAB3FBD44AD95732822F704359")

    static public final int TELESERVICE_WMT               = 0x1002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.387 -0500", hash_original_field = "9DEDACEAEEBCEEA1ADC19CF27CBE4C3D", hash_generated_field = "52F862E3050EB3F6743BC9826B49E68A")

    static public final int TELESERVICE_VMN               = 0x1003;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.390 -0500", hash_original_field = "FEB959018F5B506970C5742E2852A7F1", hash_generated_field = "C27C93C5347BB6AE457B58427999587E")

    static public final int TELESERVICE_WAP               = 0x1004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.393 -0500", hash_original_field = "738E0A4422EEA84884276B0A63091DD2", hash_generated_field = "BC591E49E507A9AD2368ADF9DEB8E832")

    static public final int TELESERVICE_WEMT              = 0x1005;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.395 -0500", hash_original_field = "EFDC698FD53173797157F8DD07EB0701", hash_generated_field = "B2B194ECFDC8A59ACA61F138A7B878D8")

    // Voice mail notification through Message Waiting Indication in CDMA mode or Analog mode.
    // Defined in 3GPP2 C.S-0005, 3.7.5.6, an Info Record containing an 8-bit number with the
    // number of messages waiting, it's used by some CDMA carriers for a voice mail count.
    static public final int TELESERVICE_MWI               = 0x40000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.398 -0500", hash_original_field = "2A604D84FBC553DF262B337376169825", hash_generated_field = "262A8F1CD9DD423349CA263240EE6914")

    //static public final int SERVICECATEGORY_EMERGENCY      = 0x0010;
    //...

    /**
     *  maximum lengths for fields as defined in ril_cdma_sms.h
     */
    static public final int SMS_BEARER_DATA_MAX = 255;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.401 -0500", hash_original_field = "B3E0C00F8616825E1647BC1E6CD823E2", hash_generated_field = "7D96870A082A2C76305FFABAAF52B964")

    public int messageType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.404 -0500", hash_original_field = "B87F0EE97DF0D791942D0F22D2FC4472", hash_generated_field = "C8839B419984DA983316A800C1755B1B")

    public int teleService = TELESERVICE_NOT_SET;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.407 -0500", hash_original_field = "C5C5D99A0E2374001BFD9B447F40AB04", hash_generated_field = "006177D412411665664C6D1FC444C764")

    public int serviceCategory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.409 -0500", hash_original_field = "A89F62209844CA2B21A72E4F970941DD", hash_generated_field = "367DCDB02F9DDFA8DCA8F7032F516D41")

    public CdmaSmsAddress origAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.412 -0500", hash_original_field = "5C9D48B12FBB365ABF7E12EB21DA21C9", hash_generated_field = "E96A6DD1BE0D0F5CDECD40617B6FC1CE")

    public CdmaSmsAddress destAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.414 -0500", hash_original_field = "4571C875610EC1D87A531010053D8379", hash_generated_field = "6ECC2FDCAA408B030475D971F5A0A48D")

    public CdmaSmsSubaddress origSubaddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.417 -0500", hash_original_field = "F5DCABE62A37B03F975887A64183A7FC", hash_generated_field = "2C70C5087C276B72D68572F45FA0F745")

    public int bearerReply;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.419 -0500", hash_original_field = "308AB2045D336AC164D5D18F05DECBEF", hash_generated_field = "4138AAE6653B160948F7189FC3320873")

    public byte replySeqNo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.421 -0500", hash_original_field = "15F7E0ABFDF83DB2F1ECE899DF03D66C", hash_generated_field = "271A50F0CD88736ED1AC89EE3B394309")

    public byte errorClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.424 -0500", hash_original_field = "78F70A8ACA348BA6CDA32A29A614AF68", hash_generated_field = "52FE182CEA008073278146DA36F4F70B")

    public byte causeCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.426 -0500", hash_original_field = "1FA60CD4DAAF71B98F32AD994CBB9E3B", hash_generated_field = "903C8FA6D363529CD415D38CCF8F6F76")

    public byte[] bearerData;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:52.429 -0500", hash_original_method = "63C615594341C58AE34F731D1CD086D9", hash_generated_method = "79FE2318F1E12B4A5C19B379D86BD6EC")
    
public SmsEnvelope() {
        // nothing to see here
    }
}


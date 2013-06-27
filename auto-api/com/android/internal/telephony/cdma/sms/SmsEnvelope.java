package com.android.internal.telephony.cdma.sms;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.cdma.sms.CdmaSmsSubaddress;

public final class SmsEnvelope {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.880 -0400", hash_original_field = "9CEBBECC0F683775CABCD1C6DD3D70C7", hash_generated_field = "7D96870A082A2C76305FFABAAF52B964")

    public int messageType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.880 -0400", hash_original_field = "72B44FDFEAC50F407543C2A52BEE7A0D", hash_generated_field = "C8839B419984DA983316A800C1755B1B")

    public int teleService = TELESERVICE_NOT_SET;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.880 -0400", hash_original_field = "BC70A595D052072B5D94CFFEA6D8D5BB", hash_generated_field = "006177D412411665664C6D1FC444C764")

    public int serviceCategory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.880 -0400", hash_original_field = "4540D74C1BDE1092D59A822A18444C48", hash_generated_field = "367DCDB02F9DDFA8DCA8F7032F516D41")

    public CdmaSmsAddress origAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.880 -0400", hash_original_field = "0D3BB44FE48E5F1B69B8BA1C3EB9D7FE", hash_generated_field = "E96A6DD1BE0D0F5CDECD40617B6FC1CE")

    public CdmaSmsAddress destAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.880 -0400", hash_original_field = "FA9525D3EA78A1360DBBE8549213B695", hash_generated_field = "6ECC2FDCAA408B030475D971F5A0A48D")

    public CdmaSmsSubaddress origSubaddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.880 -0400", hash_original_field = "B8CF623DDF130AB33BB30D26781991AA", hash_generated_field = "2C70C5087C276B72D68572F45FA0F745")

    public int bearerReply;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.880 -0400", hash_original_field = "17510118CC7695002A6172DB3721CFE8", hash_generated_field = "4138AAE6653B160948F7189FC3320873")

    public byte replySeqNo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.880 -0400", hash_original_field = "6D276B3D67752B6AA802B3D7E4A3F489", hash_generated_field = "271A50F0CD88736ED1AC89EE3B394309")

    public byte errorClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.880 -0400", hash_original_field = "31C86B36CAFA4A6BA32B1D85F1B906E2", hash_generated_field = "52FE182CEA008073278146DA36F4F70B")

    public byte causeCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.880 -0400", hash_original_field = "9A5324EDE8626EF68B2C5986E822ECC1", hash_generated_field = "903C8FA6D363529CD415D38CCF8F6F76")

    public byte[] bearerData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.881 -0400", hash_original_method = "63C615594341C58AE34F731D1CD086D9", hash_generated_method = "476E2A70F0F2BF824A0CD036D3873D68")
    public  SmsEnvelope() {
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.881 -0400", hash_original_field = "7824BDFFC1A25EA1974791C435FBB32C", hash_generated_field = "B5E654FAE63C8EC1AEFCC489ABA392C6")

    static public final int MESSAGE_TYPE_POINT_TO_POINT   = 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.881 -0400", hash_original_field = "9C1BD5E5D2262B5008C01D054DC14627", hash_generated_field = "B5FE7F329D4400C9A754C1E137CA3FF0")

    static public final int MESSAGE_TYPE_BROADCAST        = 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.881 -0400", hash_original_field = "56A106398F6531C76CD20BC955E8F551", hash_generated_field = "9F74A6530C9C0AF94CC7D19C45EC270B")

    static public final int MESSAGE_TYPE_ACKNOWLEDGE      = 0x02;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.881 -0400", hash_original_field = "78F72D8D10C87336B63BA965FC01D583", hash_generated_field = "10C362BEB09B044A326E37AFCFF6EA00")

    static public final int TELESERVICE_NOT_SET           = 0x0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.882 -0400", hash_original_field = "D2D6B3085351098AE0B83F0951A90A4B", hash_generated_field = "10C75ACAB3FBD44AD95732822F704359")

    static public final int TELESERVICE_WMT               = 0x1002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.882 -0400", hash_original_field = "28DF30EDBCA17EA6A981A970D6E8899F", hash_generated_field = "52F862E3050EB3F6743BC9826B49E68A")

    static public final int TELESERVICE_VMN               = 0x1003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.882 -0400", hash_original_field = "364B73B38CB9EB6B2C93383518817673", hash_generated_field = "C27C93C5347BB6AE457B58427999587E")

    static public final int TELESERVICE_WAP               = 0x1004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.882 -0400", hash_original_field = "72FF3888AE839619C097FD5585EF51F6", hash_generated_field = "BC591E49E507A9AD2368ADF9DEB8E832")

    static public final int TELESERVICE_WEMT              = 0x1005;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.882 -0400", hash_original_field = "6AB506F5CB6256A4CA6DB99C1BBCDBD4", hash_generated_field = "7680092023DED0668A3834952F0048A5")

    static public final int TELESERVICE_MWI               = 0x40000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:19.882 -0400", hash_original_field = "475923B9FDEA5950001FD45C6C868B8A", hash_generated_field = "F76DAF630D5E4DB46AF30ACFE9E85BC4")

    static public final int SMS_BEARER_DATA_MAX = 255;
}

